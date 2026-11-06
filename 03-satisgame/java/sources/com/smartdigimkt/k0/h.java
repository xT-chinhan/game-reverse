package com.smartdigimkt.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {
    public final /* synthetic */ com.smartdigimkt.i0.s a;
    public final /* synthetic */ l b;

    public h(l lVar, com.smartdigimkt.i0.s sVar) {
        this.b = lVar;
        this.a = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b.b(this.a);
    }
}
