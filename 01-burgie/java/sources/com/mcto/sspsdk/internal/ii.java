package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class ii implements Runnable {
    public final /* synthetic */ ki a;

    public ii(ki kiVar) {
        this.a = kiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(null, 11, "splash time out.");
    }
}
