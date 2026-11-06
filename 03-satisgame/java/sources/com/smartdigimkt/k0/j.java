package com.smartdigimkt.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Runnable {
    public final /* synthetic */ com.smartdigimkt.l0.d a;
    public final /* synthetic */ l b;

    public j(l lVar, com.smartdigimkt.l0.d dVar) {
        this.b = lVar;
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a) {
        }
        this.b.b.c(this.a);
    }
}
