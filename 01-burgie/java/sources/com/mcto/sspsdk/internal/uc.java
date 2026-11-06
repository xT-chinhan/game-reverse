package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class uc implements Runnable {
    public final /* synthetic */ com.mcto.sspsdk.ssp.taskpage.h a;

    public uc(com.mcto.sspsdk.ssp.taskpage.h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.mcto.sspsdk.ssp.taskpage.h.a(this.a);
    }
}
