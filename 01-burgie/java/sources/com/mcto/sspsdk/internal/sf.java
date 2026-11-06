package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class sf implements Runnable {
    public final /* synthetic */ long[] a;
    public final /* synthetic */ long b;
    public final /* synthetic */ uf c;

    public sf(uf ufVar, long[] jArr, long j) {
        this.c = ufVar;
        this.a = jArr;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        uf ufVar = this.c;
        if (!ufVar.j) {
            ufVar.q = null;
            return;
        }
        long jCurrentTimeMillis = this.b - (System.currentTimeMillis() - this.a[0]);
        if (jCurrentTimeMillis > 0) {
            this.c.n.postDelayed(this, Math.min(1000L, jCurrentTimeMillis));
            return;
        }
        w8 w8Var = this.c.p;
        if (w8Var != null) {
            uf ufVar2 = w8Var.a.w;
            if (ufVar2 != null && ufVar2.getParent() != null) {
                w8Var.a.w.c();
                x8 x8Var = w8Var.a;
                x8Var.a.removeView(x8Var.w);
                w8Var.a.w = null;
            }
            w8Var.a.n();
        }
        this.c.q = null;
    }
}
