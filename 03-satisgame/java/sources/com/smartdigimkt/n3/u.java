package com.smartdigimkt.n3;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements Runnable {
    public final /* synthetic */ w a;

    public u(w wVar) {
        this.a = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d.set(false);
        this.a.a(true);
    }
}
