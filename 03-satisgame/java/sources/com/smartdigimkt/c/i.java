package com.smartdigimkt.c;

import com.smartdigimkt.china.based.twist.TwistG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {
    public final /* synthetic */ j a;

    public i(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TwistG2CV2View twistG2CV2View = this.a.i;
        if (twistG2CV2View == null || twistG2CV2View.getWidth() <= 0 || this.a.i.getHeight() <= 0) {
            return;
        }
        j jVar = this.a;
        jVar.i.applyBannerForegroundProfile(jVar.b());
        this.a.i.bringToFront();
    }
}
