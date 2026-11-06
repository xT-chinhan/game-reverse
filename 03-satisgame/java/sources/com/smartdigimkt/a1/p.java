package com.smartdigimkt.a1;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ float d;
    public final /* synthetic */ s e;

    public p(s sVar, int i, int i2, int i3, float f) {
        this.e = sVar;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.b.a(this.a, this.b, this.c, this.d);
    }
}
