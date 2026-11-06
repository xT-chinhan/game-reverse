package com.smartdigimkt.a1;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ s c;

    public o(s sVar, int i, long j) {
        this.c = sVar;
        this.a = i;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.b.a(this.a, this.b);
    }
}
