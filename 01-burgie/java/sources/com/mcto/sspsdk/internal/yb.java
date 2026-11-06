package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class yb implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ zb b;

    public yb(zb zbVar, float f) {
        this.b = zbVar;
        this.a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            float f = 0.0f;
            if (this.a != 0.0f) {
                f = 1.0f;
            }
            this.b.b.setVolume(f, f);
        } catch (Exception e) {
            r9.a("ssp_media", this.b.a + ", start: ", e);
            zb zbVar = this.b;
            zbVar.onError(zbVar.b, -1, 0);
        }
    }
}
