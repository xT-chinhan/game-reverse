package com.smartdigimkt.a1;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    public final /* synthetic */ com.smartdigimkt.l0.d a;
    public final /* synthetic */ s b;

    public l(s sVar, com.smartdigimkt.l0.d dVar) {
        this.b = sVar;
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b.a(this.a);
    }
}
