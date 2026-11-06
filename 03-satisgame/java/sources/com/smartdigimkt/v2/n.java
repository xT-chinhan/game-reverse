package com.smartdigimkt.v2;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Runnable {
    public final /* synthetic */ p a;

    public n(p pVar) {
        this.a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a.f) {
            p pVar = this.a;
            if (pVar.o) {
                pVar.o = false;
                pVar.p = null;
                pVar.b();
            }
        }
    }
}
