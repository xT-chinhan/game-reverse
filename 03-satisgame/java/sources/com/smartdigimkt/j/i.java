package com.smartdigimkt.j;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {
    public final /* synthetic */ u a;

    public i(u uVar) {
        this.a = uVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.h == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.a.h.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add((com.smartdigimkt.k.r) this.a.h.get((String) it.next()));
        }
        com.smartdigimkt.k.p pVar = this.a.q;
        if (pVar != null) {
            pVar.a(arrayList);
        }
    }
}
