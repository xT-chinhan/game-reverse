import sys, os, json, UnityPy
sys.path.insert(0, os.path.expanduser('~/game/_tools'))
from i2_tool import Il2CppGen
so, meta = sys.argv[1:3]; G='/tmp/gg'; D='/tmp/ax/assets/bin/Data'
if not os.path.exists(G+'/globalgamemanagers.assets'):
    parts=sorted([f for f in os.listdir(D) if f.startswith('globalgamemanagers.assets.split')], key=lambda x:int(x.split('split')[1]))
    with open(G+'/globalgamemanagers.assets','wb') as w:
        for p in parts: w.write(open(os.path.join(D,p),'rb').read())
    os.system(f'cp {D}/globalgamemanagers {G}/')
env=UnityPy.load(*[G+'/'+x for x in os.listdir(G)])
gen=Il2CppGen('2022.3.0f1'); gen.load_il2cpp(open(so,'rb').read(), open(meta,'rb').read()); env.typetree_generator=gen
for k,f in env.files.items():
    for o in f.objects.values():
        if o.type.name=='Font':
            d=o.read(); print('FONT',os.path.basename(k),o.path_id,d.m_Name,len(d.m_FontData or b''))
        if o.type.name=='MonoBehaviour' and os.path.basename(k)[:4] in ('7772','f971'):
            t=o.read_typetree()
            print('=====',os.path.basename(k),t['m_Name'],'srcFont',t['m_SourceFontFile'],'popMode',t['m_AtlasPopulationMode'],
                  'chars',len(t['m_CharacterTable']),'glyphs',len(t['m_GlyphTable']),'clearDyn',t.get('m_ClearDynamicDataOnBuild'),
                  'multi',t.get('m_IsMultiAtlasTexturesEnabled'),'fallback',t['m_FallbackFontAssetTable'],'pt',t['m_FaceInfo']['m_PointSize'],'render',t['m_AtlasRenderMode'])
            have={c['m_Unicode'] for c in t['m_CharacterTable']}
            vn='ảốễạửặởầủệắềộữựếĐđơư'
            print('   has:',''.join(c for c in vn if ord(c) in have),' missing:',''.join(c for c in vn if ord(c) not in have))
