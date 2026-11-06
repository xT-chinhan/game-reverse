package com.smartdigimkt.sdk.api.format;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public interface SDMBannerListener {
    void onAdClick();

    void onAdClose();

    void onAdLoadFail(AdError adError);

    void onAdLoaded();

    void onAdShow();

    void onDeeplinkCallback(boolean z);
}
