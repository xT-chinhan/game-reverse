package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class kb implements Runnable {
    public final /* synthetic */ zb a;

    public kb(zb zbVar) {
        this.a = zbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        la laVar = this.a.d;
        laVar.a.e.set(true);
        pa paVar = laVar.a;
        int i = paVar.k.a;
        if (paVar.a != 5) {
            paVar.a = 2;
            paVar.a(2);
            if (laVar.a.d.get()) {
                pa paVar2 = laVar.a;
                paVar2.a = 3;
                paVar2.a(3);
            }
        }
    }
}
