package com.smartdigimkt.y1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.SwipeG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 implements Runnable {
    public final /* synthetic */ SwipeG2CV2View a;

    public d1(SwipeG2CV2View swipeG2CV2View) {
        this.a = swipeG2CV2View;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.getWidth() > 0 && this.a.getHeight() > 0) {
            SwipeG2CV2View swipeG2CV2View = this.a;
            swipeG2CV2View.applyBannerForegroundProfile(com.smartdigimkt.n1.a0.a(com.smartdigimkt.r4.k.b(swipeG2CV2View.getContext(), this.a.getWidth()), com.smartdigimkt.r4.k.b(this.a.getContext(), this.a.getHeight()), 3));
        }
        this.a.bringToFront();
        if (this.a.getParent() instanceof View) {
            ((View) this.a.getParent()).bringToFront();
        }
    }
}
