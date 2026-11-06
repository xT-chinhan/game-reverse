package com.smartdigimkt.v2;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ p c;

    public f(p pVar, long j, n nVar) {
        this.c = pVar;
        this.a = j;
        this.b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a != this.c.q) {
            return;
        }
        this.b.run();
    }
}
