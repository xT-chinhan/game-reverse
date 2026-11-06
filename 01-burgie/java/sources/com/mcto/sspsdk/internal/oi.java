package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class oi implements Runnable {
    public final /* synthetic */ pi a;

    public oi(pi piVar) {
        this.a = piVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.k.onAdSkip();
    }
}
