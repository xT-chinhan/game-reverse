package com.smartdigimkt.z;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ String a = "1";
    public final /* synthetic */ com.smartdigimkt.n1.b0 b;
    public final /* synthetic */ d c;

    public b(d dVar, com.smartdigimkt.n1.b0 b0Var) {
        this.c = dVar;
        this.b = b0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.c) {
            List list = (List) this.c.a.get(this.a);
            if (list != null) {
                list.remove(this.b);
            }
        }
    }
}
