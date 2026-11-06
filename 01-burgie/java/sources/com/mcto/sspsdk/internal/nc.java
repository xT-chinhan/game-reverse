package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class nc implements Runnable {
    public final /* synthetic */ pc a;

    public nc(pc pcVar) {
        this.a = pcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        pc pcVar = this.a;
        pc.a(pcVar, pcVar);
    }
}
