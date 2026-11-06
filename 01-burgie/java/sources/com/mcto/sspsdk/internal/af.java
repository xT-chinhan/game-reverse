package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class af implements Runnable {
    public final /* synthetic */ cf a;

    public af(cf cfVar) {
        this.a = cfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        gf gfVar = this.a.a;
        int i = gf.L;
        gfVar.c();
    }
}
