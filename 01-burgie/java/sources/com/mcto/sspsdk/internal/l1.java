package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class l1 implements Runnable {
    public final /* synthetic */ r1 a;

    public l1(r1 r1Var) {
        this.a = r1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e1.b(this.a.j.getAbsolutePath());
    }
}
