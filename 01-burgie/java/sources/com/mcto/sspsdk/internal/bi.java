package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class bi implements Runnable {
    public final /* synthetic */ pi a;
    public final /* synthetic */ di b;

    public bi(di diVar, pi piVar) {
        this.b = diVar;
        this.a = piVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.a.onSplashAdLoad(this.a);
        } catch (Exception e) {
            r9.a("ssp_splash", "splash callbackSuccess: ", e);
        }
    }
}
