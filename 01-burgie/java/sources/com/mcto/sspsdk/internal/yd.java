package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQYNative;
import com.mcto.sspsdk.IQyBanner;

/* JADX INFO: loaded from: classes2.dex */
public final class yd implements IQYNative.BannerAdListener {
    public final /* synthetic */ IQYNative.BannerAdListener a;

    public yd(IQYNative.BannerAdListener bannerAdListener) {
        this.a = bannerAdListener;
    }

    @Override // com.mcto.sspsdk.IQYNative.BannerAdListener
    public final void onBannerAdLoad(IQyBanner iQyBanner) {
        kh.a.a(new xd(this, iQyBanner));
    }

    @Override // com.mcto.sspsdk.ssp.callback.AdErrorCallback
    public final void onError(int i, String str) {
        kh.a.a(new wd(this, i, str));
    }
}
