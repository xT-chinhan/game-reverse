package com.smartdigimkt.z;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements Runnable {
    public final /* synthetic */ com.smartdigimkt.b3.c a;
    public final /* synthetic */ Context b;

    public q(Context context, com.smartdigimkt.b3.c cVar) {
        this.a = cVar;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a instanceof com.smartdigimkt.b3.l) {
            g0.a(this.b).a();
            g0 g0VarA = g0.a(this.b);
            com.smartdigimkt.b3.c cVar = this.a;
            g0VarA.b.put(cVar.a, cVar);
        }
    }
}
