package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class s5 implements Runnable {
    public final /* synthetic */ u5 a;

    public s5(u5 u5Var) {
        this.a = u5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u5 u5Var = this.a;
        t5 t5Var = u5Var.f;
        if (t5Var != null) {
            t5Var.a(u5Var.c);
        }
    }
}
