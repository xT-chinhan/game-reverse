package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class s6 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ t6 c;

    public s6(t6 t6Var, int i, String str) {
        this.c = t6Var;
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a.onError(this.a, this.b);
    }
}
