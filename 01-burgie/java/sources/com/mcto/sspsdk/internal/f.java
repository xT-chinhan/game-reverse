package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Runnable {
    public final /* synthetic */ h a;
    public final /* synthetic */ s0 b;

    public f(h hVar, s0 s0Var) {
        this.a = hVar;
        this.b = s0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
