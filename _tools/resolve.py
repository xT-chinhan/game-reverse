#!/usr/bin/env python3
"""IL2CPP name resolver for Kuna/Ghidra pseudocode.

Usage (CLI):  resolve.py <evidence.json> <libil2cpp.so> < pseudocode.c > annotated.c
Library:      R = Resolver(evidence, so); R.annotate(text)

- sub_XXXX         -> C# method name (from REA inspect_il2cpp_metadata method_addresses)
- dat_XXXX / sub_1589048(0xXXXX) metadata-usage slots (IL2CPP v27+ encoding)
                   -> /*str "..."*/, /*typeof Foo*/, /*method Foo$$Bar*/
Cache: <evidence>.names.pkl next to the evidence file (per project).
"""
import json, os, pickle, re, struct, sys


def _load_names(ev_path, so_sha=None):
    cache = os.path.splitext(os.path.abspath(ev_path))[0] + '.names.pkl'  # per-project evidence dir
    if os.path.exists(cache) and os.path.getmtime(cache) >= os.path.getmtime(ev_path):
        return pickle.load(open(cache, 'rb'))
    d = json.load(open(ev_path))
    _recs = [r for r in d['records'] if r['operation'] == 'inspect_il2cpp_metadata']
    if so_sha:
        _recs = [r for r in _recs if (r['normalized_result'].get('binary') or {}).get('artifact',{}).get('sha256') == so_sha] or _recs
    nr = _recs[0]['normalized_result']
    T, M = nr['types'], nr['methods']

    def full(ti):
        t = T[ti]; n = t['name']
        while t['declaring_type'] not in (-1, None):
            t = T[t['declaring_type']]; n = t['name'] + '.' + n
        return (t['namespace'] + '.' if t['namespace'] else '') + n

    tdn = [full(i) for i in range(len(T))]
    mnames = [tdn[m['declaring_type']] + '$$' + m['name'] for m in M]
    funcs = {}
    for i, a in enumerate(nr['method_addresses']):
        if a['state'] == 'code':
            funcs.setdefault(int(a['rva'], 16), mnames[i])
    typenames = {}
    for coll in ('field_types', 'parameter_types', 'return_types'):
        for x in nr[coll]:
            if x.get('name') and x.get('type') is not None:
                typenames.setdefault(x['type'], x['name'])
    lits = [s['value'] for s in nr['string_literals']]
    types_field = int(nr['binary']['types_field'], 16) if nr.get('binary') and nr['binary'].get('types_field') else None
    out = dict(funcs=funcs, typenames=typenames, lits=lits, mnames=mnames, tdn=tdn, types_field=types_field)
    pickle.dump(out, open(cache, 'wb'))
    return out


def _cid(name):
    return re.sub(r'[^0-9A-Za-z_]', '_', name.replace('$$', '__'))


class Resolver:
    def __init__(self, ev_path, so_path):
        import hashlib
        so_sha = hashlib.sha256(open(so_path,'rb').read()).hexdigest()
        n = _load_names(ev_path, so_sha)
        self.funcs, self.typenames, self.lits = n['funcs'], n['typenames'], n['lits']
        self.mnames, self.tdn = n['mnames'], n['tdn']
        self.data = data = open(so_path, 'rb').read()
        phoff = struct.unpack_from('<Q', data, 0x20)[0]
        phnum = struct.unpack_from('<H', data, 0x38)[0]
        self.segs = []
        for i in range(phnum):
            p_type, _, off, vaddr, _, filesz, _, _ = struct.unpack_from('<IIQQQQQQ', data, phoff + i * 56)
            if p_type == 1:
                self.segs.append((vaddr, off, filesz))
        shoff = struct.unpack_from('<Q', data, 0x28)[0]
        shentsize, shnum = struct.unpack_from('<HH', data, 0x3a)
        self.relo = {}
        for i in range(shnum):
            _, sh_type, _, _, off, size, _, _, _, _ = struct.unpack_from('<IIQQQQIIQQ', data, shoff + i * shentsize)
            if sh_type == 4:  # SHT_RELA
                for j in range(0, size - 23, 24):
                    r_off, r_info, r_add = struct.unpack_from('<QQq', data, off + j)
                    if r_info & 0xffffffff == 1027:  # R_AARCH64_RELATIVE
                        self.relo[r_off] = r_add
        self.types_arr = None
        tf = n['types_field']
        if tf is not None:
            v = self.ptr(tf)
            # the recorded field may point at typesCount (followed by types*) or at types* itself
            self.types_arr = self.ptr(tf + 8) if (v or 0) < 0x100000 else v

    def _foff(self, va):
        for v, o, s in self.segs:
            if v <= va < v + s:
                return o + va - v
        return None

    def rd(self, va):
        o = self._foff(va)
        return None if o is None else struct.unpack_from('<Q', self.data, o)[0]

    def ptr(self, va):
        return self.relo.get(va, self.rd(va))

    def il2type(self, idx):
        if not self.types_arr:
            return None
        tp = self.ptr(self.types_arr + idx * 8)
        if not tp:
            return None
        o = self._foff(tp)
        if o is None:
            return None
        dat = self.ptr(tp)
        t = (struct.unpack_from('<I', self.data, o + 8)[0] >> 16) & 0xff
        if t in (0x11, 0x12) and dat is not None and dat < len(self.tdn):
            return self.tdn[dat]
        if t == 0x15 and dat:  # GENERICINST -> Il2CppGenericClass{ const Il2CppType* type; ...}
            gt = self.ptr(dat)
            if gt:
                gd = self.ptr(gt)
                if gd is not None and gd < len(self.tdn):
                    return self.tdn[gd] + '<..>'
        if t == 0x1d:
            return 'array'
        return None

    def usage(self, va):
        raw = self.rd(va)
        if raw is None or not raw & 1 or raw >> 32:
            return None
        kind, idx = (raw & 0xE0000000) >> 29, (raw & 0x1FFFFFFE) >> 1
        if kind == 5 and idx < len(self.lits):
            return 'str ' + json.dumps(self.lits[idx], ensure_ascii=False)[:160]
        if kind in (1, 2):
            return ('typeof ' if kind == 1 else 'type ') + (self.il2type(idx) or self.typenames.get(idx, f'#{idx}'))
        if kind == 3 and idx < len(self.mnames):
            return 'method ' + self.mnames[idx]
        if kind == 4:
            return f'field #{idx}'
        if kind == 6:
            return f'methodref #{idx}'
        return None

    def annotate(self, src):
        funcs = self.funcs
        out = re.sub(r'\b(?:sub|FUN|fcn)_(?:0x)?([0-9a-fA-F]+)\b',
                     lambda m: _cid(funcs[int(m.group(1), 16)]) if int(m.group(1), 16) in funcs else m.group(0), src)
        notes = {}
        for h in set(re.findall(r'\b(?:dat_|DAT_)(?:0x)?([0-9a-fA-F]{6,9})\b', src)) | set(re.findall(r'\(0x([0-9a-f]{6,9})\)', src)):
            u = self.usage(int(h, 16))
            if u:
                notes[h.lower()] = u
        out = re.sub(r'\b(?:dat_|DAT_)(?:0x)?([0-9a-fA-F]+)\b',
                     lambda m: f'{m.group(0)}/*{notes[m.group(1).lower()]}*/' if m.group(1).lower() in notes else m.group(0), out)
        out = re.sub(r'\(0x([0-9a-f]{6,9})\)',
                     lambda m: f'(0x{m.group(1)}/*{notes[m.group(1)]}*/)' if m.group(1) in notes else m.group(0), out)
        return out


if __name__ == '__main__':
    R = Resolver(sys.argv[1], sys.argv[2])
    sys.stdout.write(R.annotate(sys.stdin.read()))
