package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.BaseBannerATView;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements Runnable {
    public final /* synthetic */ BaseBannerATView a;

    public n0(BaseBannerATView baseBannerATView) {
        this.a = baseBannerATView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseBannerATView baseBannerATView = this.a;
        int i = BaseBannerATView.H;
        baseBannerATView.m();
    }
}
