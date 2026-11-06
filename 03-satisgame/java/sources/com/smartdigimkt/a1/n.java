package com.smartdigimkt.a1;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Runnable {
    public final /* synthetic */ com.smartdigimkt.i0.s a;
    public final /* synthetic */ s b;

    public n(s sVar, com.smartdigimkt.i0.s sVar2) {
        this.b = sVar;
        this.a = sVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b.a(this.a);
    }
}
