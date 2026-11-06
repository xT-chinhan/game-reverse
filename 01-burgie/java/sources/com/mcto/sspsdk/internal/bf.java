package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class bf implements Runnable {
    public final /* synthetic */ cf a;

    public bf(cf cfVar) {
        this.a = cfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        gf gfVar = this.a.a;
        int i = gf.L;
        gfVar.a();
    }
}
