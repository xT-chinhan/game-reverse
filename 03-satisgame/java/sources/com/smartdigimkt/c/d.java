package com.smartdigimkt.c;

import com.smartdigimkt.china.based.twist.TwistG2CV2View;
import com.smartdigimkt.n1.a0;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ TwistG2CV2View a;

    public d(TwistG2CV2View twistG2CV2View) {
        this.a = twistG2CV2View;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.getWidth() > 0 && this.a.getHeight() > 0) {
            TwistG2CV2View twistG2CV2View = this.a;
            twistG2CV2View.applyBannerForegroundProfile(a0.a(com.smartdigimkt.r4.k.b(twistG2CV2View.getContext(), this.a.getWidth()), com.smartdigimkt.r4.k.b(this.a.getContext(), this.a.getHeight()), 2));
        }
        this.a.bringToFront();
    }
}
