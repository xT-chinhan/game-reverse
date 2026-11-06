package com.smartdigimkt.q3;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ int b;
    public final /* synthetic */ f c;

    public c(f fVar, Runnable runnable, int i) {
        this.c = fVar;
        this.a = runnable;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.a, 0L, this.b);
    }
}
