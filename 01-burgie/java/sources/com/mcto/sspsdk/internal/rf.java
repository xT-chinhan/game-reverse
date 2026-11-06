package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class rf implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ uf b;

    public rf(uf ufVar, long j) {
        this.b = ufVar;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        uf ufVar = this.b;
        if (!ufVar.j) {
            ufVar.o = null;
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        uf ufVar2 = this.b;
        if (jCurrentTimeMillis - ufVar2.s >= this.a) {
            ufVar2.o = null;
            return;
        }
        if (ufVar2.k.size() < 20) {
            uf.a(this.b);
        }
        uf ufVar3 = this.b;
        ufVar3.n.postDelayed(this, ufVar3.c);
    }
}
