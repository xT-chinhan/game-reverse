package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class pb implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ zb c;

    public pb(zb zbVar, int i, int i2) {
        this.c = zbVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        la laVar = this.c.d;
        int i = this.a;
        int i2 = this.b;
        o3 o3Var = laVar.a.g;
        kh.a.a(new ka(laVar, i, i2));
        int i3 = laVar.a.k.a;
    }
}
