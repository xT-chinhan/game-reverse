#!/usr/bin/env python3
"""I2 Localization LanguageSourceAsset tool for il2cpp Unity builds (no typetree in player data).

  i2_tool.py dump  <srcdir> <asset_file_name> <libil2cpp.so> <global-metadata.dat> <out.json>
  i2_tool.py patch <srcdir> <asset_file_name> <libil2cpp.so> <global-metadata.dat> <in.json> <out_asset_file>

<srcdir> must contain the asset file plus globalgamemanagers + globalgamemanagers.assets (merged from .split*),
so the MonoBehaviour's m_Script can be resolved.
"""
import json, os, sys
import UnityPy
from UnityPy.helpers.TypeTreeGenerator import TypeTreeGenerator, TypeTreeNode


class Il2CppGen(TypeTreeGenerator):
    # assemblies loaded from il2cpp metadata have no ".dll" suffix; UnityPy appends one
    def get_nodes_up(self, assembly, fullname):
        key = (assembly, fullname)
        if key in self.cache:
            return self.cache[key]
        if assembly.endswith('.dll'):
            assembly = assembly[:-4]
        base = list(self.get_nodes(assembly, fullname))
        types = [b.m_Type for b in base]
        # string[] fields come back typed "string" with an Array whose element is itself a
        # string (not char): UnityPy would read them as a single string -> retype as vector.
        for i, b in enumerate(base):
            if b.m_Type == 'string' and i + 3 < len(base) and base[i + 1].m_Type == 'Array' \
                    and base[i + 3].m_Level == b.m_Level + 2 and base[i + 3].m_Type != 'char':
                types[i] = 'vector'
        node = TypeTreeNode.from_list([
            TypeTreeNode(b.m_Level, types[i], b.m_Name, 0, 0, m_MetaFlag=b.m_MetaFlag)
            for i, b in enumerate(base)])
        self.cache[key] = node
        return node


def load(srcdir, name, so, meta):
    env = UnityPy.load(*[os.path.join(srcdir, x) for x in sorted(os.listdir(srcdir))])
    f = [x for k, x in env.files.items() if os.path.basename(k) == name][0]
    gen = Il2CppGen(f.unity_version)
    gen.load_il2cpp(open(so, 'rb').read(), open(meta, 'rb').read())
    env.typetree_generator = gen
    obj = [o for o in f.objects.values() if o.type.name == 'MonoBehaviour'][0]
    return env, f, obj


def main():
    cmd = sys.argv[1]
    srcdir, name, so, meta = sys.argv[2:6]
    env, f, obj = load(srcdir, name, so, meta)
    if cmd == 'dump':
        tree = obj.read_typetree()
        json.dump(tree, open(sys.argv[6], 'w'), ensure_ascii=False, indent=1)
        print('dumped', obj.path_id, tree.get('m_Name'))
    elif cmd == 'patch':
        tree = json.load(open(sys.argv[6]))
        obj.save_typetree(tree)
        open(sys.argv[7], 'wb').write(f.save())
        print('wrote', sys.argv[7])


if __name__ == '__main__':
    main()
