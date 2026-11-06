package com.smartdigimkt.o4;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ e a;

    public b(e eVar, boolean z) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map;
        e eVar = this.a;
        eVar.getClass();
        com.smartdigimkt.g4.c cVar = new com.smartdigimkt.g4.c();
        if (eVar.b != null) {
            com.smartdigimkt.p4.a aVar = eVar.b;
            synchronized (aVar) {
                if (aVar.d == null) {
                    HashMap map2 = new HashMap();
                    aVar.d = map2;
                    HashMap map3 = aVar.b;
                    if (map3 != null) {
                        map2.putAll(map3);
                    }
                    HashMap map4 = aVar.c;
                    if (map4 != null) {
                        aVar.d.putAll(map4);
                    }
                }
                map = aVar.d;
            }
            cVar.c = map;
        }
        new com.smartdigimkt.f4.e(cVar).a(0, (com.smartdigimkt.a4.b) new c(eVar));
    }
}
