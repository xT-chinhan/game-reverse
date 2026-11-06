package com.smartdigimkt.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ l d;

    public g(l lVar, String str, long j, long j2) {
        this.d = lVar;
        this.a = str;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.b.a(this.a, this.b, this.c);
    }
}
