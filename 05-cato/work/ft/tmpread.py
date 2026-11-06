import sys, os, json, UnityPy
sys.path.insert(0, os.path.expanduser('~/game/_tools'))
from i2_tool import Il2CppGen
B, so, meta = sys.argv[1:4]
D='/tmp/ax/assets/bin/Data'
# merge globalgamemanagers.assets splits so MonoScripts resolve
gg='/tmp/gg'; os.makedirs(gg, exist_ok=True)
if not os.path.exists(gg+'/globalgamemanagers.assets'):
    parts=sorted([f for f in os.listdir(D) if f.startswith('globalgamemanagers.assets.split')], key=lambda x:int(x.split('split')[1]))
    with open(gg+'/globalgamemanagers.assets','wb') as w:
        for p in parts: w.write(open(os.path.join(D,p),'rb').read())
    os.system(f'cp {D}/globalgamemanagers {gg}/')
env=UnityPy.load(B, gg+'/globalgamemanagers', gg+'/globalgamemanagers.assets')
bf=[f for k,f in env.files.items() if k.endswith('.bundle') or 'misc' in k][0]
gen=Il2CppGen(env.objects[0].assets_file.unity_version if hasattr(env.objects[0],'assets_file') else '2022.3')
gen.load_il2cpp(open(so,'rb').read(), open(meta,'rb').read())
env.typetree_generator=gen
want=set(sys.argv[4].split(','))
for o in env.objects:
    if o.type.name=='MonoBehaviour':
        try: nm=o.read(check_read=False).m_Name
        except Exception: continue
        if nm in want:
            t=o.read_typetree()
            small={k:(v if not isinstance(v,list) else f'list[{len(v)}]') for k,v in t.items()}
            print('=====',nm,o.path_id); print(json.dumps(small,ensure_ascii=False,indent=1,default=str)[:3000])
            for k in ('m_FallbackFontAssetTable','fallbackFontAssets','m_CreationSettings','m_AtlasTextures'):
                if k in t: print(k, json.dumps(t[k],default=str)[:800])
