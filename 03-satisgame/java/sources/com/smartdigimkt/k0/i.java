package com.smartdigimkt.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ l d;

    public i(l lVar, int i, long j, long j2) {
        this.d = lVar;
        this.a = i;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.b.a(this.a, this.b, this.c);
    }
}
