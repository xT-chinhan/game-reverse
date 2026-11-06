#!/usr/bin/env python3
# patch_so.py <libil2cpp.so> <out.so> <rva1> <rva2> ...   # each RVA -> 'mov w0,#1; ret'
import struct, sys
src,out=sys.argv[1],sys.argv[2]; rvas=[int(x,16) for x in sys.argv[3:]]
d=bytearray(open(src,'rb').read())
phoff=struct.unpack_from('<Q',d,0x20)[0]; phnum=struct.unpack_from('<H',d,0x38)[0]
segs=[]
for i in range(phnum):
    t,fl,off,va,pa,fsz,msz,al=struct.unpack_from('<IIQQQQQQ',d,phoff+i*56)
    if t==1: segs.append((va,off,fsz))
def fo(va):
    for va0,off,fsz in segs:
        if va0<=va<va0+fsz: return off+va-va0
    raise ValueError(hex(va))
RET_TRUE=bytes.fromhex('200080 52'.replace(' ',''))+bytes.fromhex('c0035f d6'.replace(' ',''))
for rva in rvas:
    o=fo(rva); d[o:o+8]=RET_TRUE; print(f"patched {rva:#x} (off {o:#x}) -> mov w0,#1; ret")
open(out,'wb').write(d); print("wrote",out)
