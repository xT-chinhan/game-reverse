package com.smartdigimkt.a1;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ s d;

    public m(s sVar, String str, long j, long j2) {
        this.d = sVar;
        this.a = str;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.b.b(this.a, this.b, this.c);
    }
}
