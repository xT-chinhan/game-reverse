package com.smartdigimkt.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ l b;

    public k(l lVar, int i) {
        this.b = lVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b.b(this.a);
    }
}
