package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class ka implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ la c;

    public ka(la laVar, int i, int i2) {
        this.c = laVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ja jaVar = this.c.a.c;
        if (jaVar != null) {
            jaVar.a(this.a, this.b);
        }
    }
}
