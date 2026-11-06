package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class ib implements Runnable {
    public final /* synthetic */ zb a;

    public ib(zb zbVar) {
        this.a = zbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.b.stop();
        } catch (Exception e) {
            r9.a("ssp_media", this.a.a + ", stop: ", e);
        }
    }
}
