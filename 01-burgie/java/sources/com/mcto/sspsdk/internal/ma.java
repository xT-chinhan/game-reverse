package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class ma implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ pa b;

    public ma(pa paVar, int i) {
        this.b = paVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var = this.b.g;
        if (o3Var != null) {
            o3Var.a(this.a);
        }
    }
}
