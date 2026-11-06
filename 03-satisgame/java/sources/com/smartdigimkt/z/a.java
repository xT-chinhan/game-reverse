package com.smartdigimkt.z;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a = "1";
    public final /* synthetic */ com.smartdigimkt.n1.b0 b;
    public final /* synthetic */ d c;

    public a(d dVar, com.smartdigimkt.n1.b0 b0Var) {
        this.c = dVar;
        this.b = b0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.c) {
            List arrayList = (List) this.c.a.get(this.a);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.c.a.put(this.a, arrayList);
            }
            arrayList.add(this.b);
        }
    }
}
