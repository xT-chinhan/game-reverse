import zipfile, sys, os
# usage: build.py <misc_bundle> <out_unsigned.apk>
misc, out = sys.argv[1], sys.argv[2]
D='work/data_patched'
repl={
 'assets/bin/Data/5112a62564b5543d188e2fcfb5104c92': 'work/5112_vionly',          # I2 tiếng Việt
 'assets/bin/Data/level2': f'{D}/level2',                                          # footer VN + ẩn CADPA
 'assets/aa/Android/misc_assets_all_3633a28d7b93996f74aca54d3b0ec308.bundle': misc, # font trong màn chơi
 'lib/arm64-v8a/libil2cpp.so': 'work/libil2cpp.bypass.so',                         # bỏ đăng nhập
 'classes2.dex': 'work/classes2.dex',                                              # màn điều khoản VN
 'res/Qg.png': 'work/plogo/Qg.png',                                                # logo CATO màn điều khoản
 'assets/bin/Data/Managed/Metadata/global-metadata.dat': 'work/global-metadata.vi.dat', # chuỗi cứng trong code
}
for g in ['8dc7c3f1fe4a54b668c62f312564c7b0','bf0562304d14490f8b676c5b860b8a79','f772c55ea757d43b0b31bd4c509c7122','53ff87e41a793ae4eac70a50b2dcaa58']:
    repl[f'assets/bin/Data/{g}']=f'{D}/{g}'                                         # logo CATO menu
for sa,dirn in [('sharedassets0','work/sa0'),('sharedassets2','work/sa2'),('globalgamemanagers','work/gga')]:  # font menu / nút BẮT ĐẦU / splash
    for fn in os.listdir(dirn):
        if '.split' in fn: repl[f'assets/bin/Data/{fn}']=f'{dirn}/{fn}'
# work/extra/<đường dẫn zip> ghi đè sau cùng (scene_vi.py: chuỗi scene + font đậm)
EX='work/extra'; split_groups=set()
for dp,_,fs in os.walk(EX):
    for fn in fs:
        z=os.path.relpath(os.path.join(dp,fn),EX)
        if '.split' in z: split_groups.add(z.rsplit('.split',1)[0])
for g in split_groups:
    for k in [k for k in repl if k.startswith(g+'.split')]: del repl[k]
for dp,_,fs in os.walk(EX):
    for fn in fs: repl[os.path.relpath(os.path.join(dp,fn),EX)]=os.path.join(dp,fn)
zin=zipfile.ZipFile('original.apk'); zout=zipfile.ZipFile(out,'w'); names=set(zin.namelist())
groups={n.rsplit('.split',1)[0] for n in names if '.split' in n}
for g in groups:  # mỗi bộ split: hoặc giữ nguyên hết, hoặc thay đủ mọi mảnh cũ
    old={n for n in names if n.startswith(g+'.split')}; new={k for k in repl if k.startswith(g+'.split')}
    assert not new or g in split_groups or old<=new, (g, old-new)
for it in zin.infolist():
    if any(it.filename.startswith(g+'.split') for g in split_groups) and it.filename not in repl: continue  # mảnh thừa
    data=open(repl[it.filename],'rb').read() if it.filename in repl else zin.read(it.filename)
    zi=zipfile.ZipInfo(it.filename,date_time=it.date_time); zi.compress_type=it.compress_type; zi.external_attr=it.external_attr; zi.create_system=it.create_system
    zout.writestr(zi,data)
tmpl=zin.getinfo('assets/bin/Data/sharedassets0.assets.split6')
for k,v in repl.items():
    if k not in names:
        zi=zipfile.ZipInfo(k,date_time=tmpl.date_time); zi.compress_type=tmpl.compress_type; zi.external_attr=tmpl.external_attr; zi.create_system=tmpl.create_system
        zout.writestr(zi,open(v,'rb').read()); print('added',k)
zout.close(); print('built',out,len(repl),'entries replaced/added')
