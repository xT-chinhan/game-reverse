package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class ob implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ zb b;

    public ob(zb zbVar, int i, int i2) {
        this.b = zbVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        la laVar = this.b.d;
        int i = this.a;
        pa paVar = laVar.a;
        int i2 = paVar.k.a;
        int i3 = paVar.a;
        if (i == 3) {
            paVar.a = 4;
            paVar.a(4);
            int i4 = laVar.a.k.a;
            return;
        }
        if (i == 701) {
            if (i3 == 5 || i3 == 7) {
                paVar.a = 7;
            } else {
                paVar.a = 6;
            }
            paVar.a(paVar.a);
            return;
        }
        if (i == 702) {
            if (i3 == 6) {
                paVar.a = 4;
                paVar.a(4);
                int i5 = laVar.a.k.a;
            }
            pa paVar2 = laVar.a;
            if (paVar2.a == 7) {
                paVar2.a = 5;
                paVar2.a(5);
                int i6 = laVar.a.k.a;
            }
        }
    }
}
