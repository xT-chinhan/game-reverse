import json, sys, collections, os
import hashlib
ev, outdir = sys.argv[1], sys.argv[2]
meta_path = sys.argv[3] if len(sys.argv) > 3 else None
_want = hashlib.sha256(open(meta_path,'rb').read()).hexdigest() if meta_path else None
d = json.load(open(ev))
_recs = [r for r in d['records'] if r['operation'] == 'inspect_il2cpp_metadata']
if _want:
    _recs = [r for r in _recs if r.get('subject',{}).get('digest',{}).get('sha256') == _want] or _recs
nr = _recs[0]['normalized_result']
T, M, F, P = nr['types'], nr['methods'], nr['fields'], nr['parameters']
addr, ret, ftyp, ptyp = nr['method_addresses'], nr['return_types'], nr['field_types'], nr['parameter_types']
props = nr['properties']
img_of = {}
for ii, im in enumerate(nr['images']):
    for t in range(im['type_start'], im['type_start'] + im['type_count']):
        img_of[t] = ii
def fullname(ti):
    t = T[ti]; n = t['name']
    while t['declaring_type'] not in (-1, None):
        p = t['declaring_type']; n = T[p]['name'] + '.' + n; t = T[p]
    return (t['namespace'] + '.' if t['namespace'] else '') + n
fields_by = collections.defaultdict(list)
for i, f in enumerate(F): fields_by[f['declaring_type']].append(i)
params_by = collections.defaultdict(list)
for i, p in enumerate(P): params_by[p['method']].append(i)
props_by = collections.defaultdict(list)
for p in props: props_by[p['declaring_type']].append(p['name'])
meths_by = collections.defaultdict(list)
for i, m in enumerate(M): meths_by[m['declaring_type']].append(i)
script = {'ScriptMethod': []}
files = {}
for ti in range(len(T)):
    im = nr['images'][img_of.get(ti, 0)]['name']
    L = files.setdefault(im, [])
    L.append(f"// TypeDefIndex: {ti}\nclass {fullname(ti)}\n{{")
    for fi in fields_by.get(ti, []):
        L.append(f"\t{ftyp[fi]['name'] or '?'} {F[fi]['name']};")
    for pn in props_by.get(ti, []):
        L.append(f"\t// property {pn}")
    for mi in meths_by.get(ti, []):
        a = addr[mi]; ps = ', '.join(f"{ptyp[p]['name'] or '?'} {P[p]['name']}" for p in params_by.get(mi, []))
        loc = f"RVA: {a['rva']}" if a['state'] == 'code' else a['state']
        L.append(f"\t// {loc}\n\t{ret[mi]['name'] or '?'} {M[mi]['name']}({ps}) {{ }}")
        if a['state'] == 'code':
            script['ScriptMethod'].append({'Address': int(a['rva'], 16), 'Name': f"{fullname(ti)}$${M[mi]['name']}"})
    L.append("}\n")
os.makedirs(outdir, exist_ok=True)
with open(f'{outdir}/dump.cs', 'w') as o:
    for im, L in files.items(): o.write(f"// ===== Image: {im} =====\n" + '\n'.join(L) + '\n')
game_img = 'Assembly-CSharp.dll' if 'Assembly-CSharp.dll' in files else None
if game_img:
    with open(f'{outdir}/Assembly-CSharp.cs', 'w') as o: o.write('\n'.join(files[game_img]))
else:
    open(f'{outdir}/NO-Assembly-CSharp.txt','w').write('No Assembly-CSharp.dll image in il2cpp metadata (HybridCLR hot-update: game code is in a managed DLL inside the asset bundles, decompile with ILSpy). See dump.cs for AOT assemblies.')
json.dump(script, open(f'{outdir}/script.json', 'w'))
with open(f'{outdir}/strings.txt', 'w') as o:
    for s in nr['string_literals']: o.write(repr(s['value']) + '\n')
print('types', len(T), 'methods', len(M), 'script entries', len(script['ScriptMethod']))
