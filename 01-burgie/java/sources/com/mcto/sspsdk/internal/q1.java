package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class q1 implements Runnable {
    public final /* synthetic */ r1 a;

    public q1(r1 r1Var) {
        this.a = r1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r1 r1Var = this.a;
        if (r1Var.f != 2) {
            y0 y0Var = r1Var.l;
            String str = r1Var.a;
            String str2 = r1Var.n.g;
            y0Var.getClass();
            y0Var.a.a(str, str2, new s0(6, 0.0f));
        }
    }
}
