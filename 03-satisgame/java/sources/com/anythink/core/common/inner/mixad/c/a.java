package com.anythink.core.common.inner.mixad.c;

import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.api.BaseAd;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ATNativeAdInfo.AdController {
    private BaseAd a;

    public a(BaseAd baseAd) {
        this.a = baseAd;
    }

    @Override // com.anythink.core.api.ATNativeAdInfo.AdController
    public final void resumeVideo() {
        BaseAd baseAd = this.a;
        if (baseAd != null) {
            baseAd.resumeVideo();
        }
    }

    @Override // com.anythink.core.api.ATNativeAdInfo.AdController
    public final void pauseVideo() {
        BaseAd baseAd = this.a;
        if (baseAd != null) {
            baseAd.pauseVideo();
        }
    }

    @Override // com.anythink.core.api.ATNativeAdInfo.AdController
    public final void setVideoMute(boolean z) {
        BaseAd baseAd = this.a;
        if (baseAd != null) {
            baseAd.setVideoMute(z);
        }
    }
}
