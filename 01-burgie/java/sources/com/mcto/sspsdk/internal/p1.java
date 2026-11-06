package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class p1 implements Runnable {
    public final /* synthetic */ r1 a;

    public p1(r1 r1Var, String str) {
        this.a = r1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r1 r1Var = this.a;
        if (r1Var.f != 2) {
            y0 y0Var = r1Var.l;
            String str = r1Var.a;
            u0 u0Var = r1Var.n;
            String str2 = u0Var.g;
            String str3 = u0Var.i;
            y0Var.getClass();
            y0Var.a.a(str, str2, new s0(str3));
            xf.a().a((ag) new yf(str2, str3));
        }
    }
}
