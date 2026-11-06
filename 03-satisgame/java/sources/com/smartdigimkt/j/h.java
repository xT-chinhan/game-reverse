package com.smartdigimkt.j;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements com.smartdigimkt.k.n {
    public final /* synthetic */ com.smartdigimkt.k.n a;
    public final /* synthetic */ u b;

    public h(u uVar, com.smartdigimkt.k.n nVar) {
        this.b = uVar;
        this.a = nVar;
    }

    @Override // com.smartdigimkt.k.n
    public final void onCallback(com.smartdigimkt.k.r rVar) {
        ConcurrentHashMap concurrentHashMap;
        if (rVar != null && rVar.s == com.smartdigimkt.k.c.LOADING && ((concurrentHashMap = this.b.c) == null || !concurrentHashMap.containsKey(rVar.o))) {
            com.smartdigimkt.b3.c cVar = rVar.j;
            if (cVar != null) {
                cVar.D = 7;
            }
            rVar.s = com.smartdigimkt.k.c.PAUSE;
        }
        com.smartdigimkt.k.n nVar = this.a;
        if (nVar != null) {
            nVar.onCallback(rVar);
        }
    }
}
