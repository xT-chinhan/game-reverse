package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class wj implements Runnable {
    public final /* synthetic */ w5 a;
    public final /* synthetic */ xj b;

    public wj(xj xjVar, w5 w5Var) {
        this.b = xjVar;
        this.a = w5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c.a(this.a);
    }
}
