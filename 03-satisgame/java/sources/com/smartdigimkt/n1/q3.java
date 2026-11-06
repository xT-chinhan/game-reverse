package com.smartdigimkt.n1;

/* JADX INFO: loaded from: classes3.dex */
public final class q3 implements Runnable {
    public final /* synthetic */ r3 a;

    public q3(r3 r3Var) {
        this.a = r3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.b.clearAnimation();
            this.a.b.setAlpha(0.0f);
            r3 r3Var = this.a;
            r3Var.a.removeView(r3Var.b);
        } catch (Throwable unused) {
        }
    }
}
