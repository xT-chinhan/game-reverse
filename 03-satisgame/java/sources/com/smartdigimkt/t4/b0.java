package com.smartdigimkt.t4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ com.smartdigimkt.d3.c b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ List d;

    public b0(boolean z, com.smartdigimkt.d3.c cVar, HashMap map, ArrayList arrayList) {
        this.a = z;
        this.b = cVar;
        this.c = map;
        this.d = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a) {
            new com.smartdigimkt.f4.h(d0.a(this.b.h, this.c)).a(0, (com.smartdigimkt.a4.b) null);
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            new com.smartdigimkt.f4.h(d0.a((String) it.next(), this.c)).a(0, (com.smartdigimkt.a4.b) null);
        }
    }
}
