package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class ci implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ di b;

    public ci(di diVar, int i) {
        this.b = diVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.a.onError(this.a, "");
        } catch (Exception e) {
            r9.a("ssp_splash", "splash callbackError: ", e);
        }
    }
}
