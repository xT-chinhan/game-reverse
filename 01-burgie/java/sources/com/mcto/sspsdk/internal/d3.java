package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class d3 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ e3 c;

    public d3(e3 e3Var, int i, String str) {
        this.c = e3Var;
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.c.c.onError(this.a, this.b);
        } catch (Throwable th) {
        }
    }
}
