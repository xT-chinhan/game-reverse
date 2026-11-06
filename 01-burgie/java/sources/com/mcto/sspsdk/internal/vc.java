package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class vc implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ xc b;

    public vc(xc xcVar, int i) {
        this.b = xcVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        xc xcVar = this.b;
        xc.a(xcVar, xcVar.b[this.a]);
    }
}
