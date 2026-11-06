package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class a7 implements Runnable {
    public final /* synthetic */ cg a;
    public final /* synthetic */ c7 b;

    public a7(c7 c7Var, cg cgVar) {
        this.b = c7Var;
        this.a = cgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c7.a(this.b, this.a);
    }
}
