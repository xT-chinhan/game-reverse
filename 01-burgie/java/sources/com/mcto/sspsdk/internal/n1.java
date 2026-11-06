package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class n1 implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ r1 b;

    public n1(r1 r1Var, long j, float f, float f2) {
        this.b = r1Var;
        this.a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r1 r1Var = this.b;
        if (r1Var.f != 2) {
            y0 y0Var = r1Var.l;
            String str = r1Var.a;
            String str2 = r1Var.n.g;
            float f = this.a;
            y0Var.getClass();
            y0Var.a.a(str, str2, new s0(1, f));
        }
    }
}
