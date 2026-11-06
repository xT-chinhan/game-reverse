package com.smartdigimkt.x4;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends com.smartdigimkt.v4.c {
    @Override // com.smartdigimkt.v4.c
    public final boolean b(com.smartdigimkt.v4.a aVar) {
        com.smartdigimkt.w4.a aVar2;
        if (!aVar.a() && !aVar.y && ((!aVar.z || aVar.l == null) && (aVar2 = aVar.i) != null)) {
            long j = aVar2.c - aVar2.a;
            if (j <= 0) {
                j = 0;
            }
            com.smartdigimkt.p4.e eVar = aVar.n;
            long j2 = eVar != null ? eVar.k : 60000L;
            o oVar = new o(this, aVar);
            com.smartdigimkt.m3.g.a().a.a(oVar, j2 - j);
            aVar.l = oVar;
        }
        return true;
    }
}
