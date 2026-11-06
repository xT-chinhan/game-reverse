package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class jb implements Runnable {
    public final /* synthetic */ zb a;

    public jb(zb zbVar) {
        this.a = zbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.b.setSurface(null);
            this.a.b.release();
        } catch (Exception e) {
            r9.a("ssp_media", this.a.a + ", release: ", e);
        }
        this.a.b = null;
    }
}
