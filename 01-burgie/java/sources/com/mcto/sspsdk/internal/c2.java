package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class c2 implements Runnable {
    public final /* synthetic */ j2 a;

    public c2(j2 j2Var) {
        this.a = j2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j2 j2Var = this.a;
        kh.a.a(new d2(j2Var, p3.a(j2Var.p)));
    }
}
