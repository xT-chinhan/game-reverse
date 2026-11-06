package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class lb implements Runnable {
    public final /* synthetic */ zb a;

    public lb(zb zbVar) {
        this.a = zbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        la laVar = this.a.d;
        pa paVar = laVar.a;
        paVar.a = 8;
        paVar.a(8);
        pa paVar2 = laVar.a;
        int i = paVar2.k.a;
        paVar2.getClass();
        pa paVar3 = laVar.a;
        paVar3.a = 11;
        paVar3.a(11);
    }
}
