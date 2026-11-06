package com.smartdigimkt.sdk.api.format;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public interface SDMSplashListener {
    void onAdClick();

    void onAdClose(SDMSplashAdExtraInfo sDMSplashAdExtraInfo);

    void onAdLoadFail(AdError adError);

    void onAdLoadTimeout();

    void onAdLoaded(boolean z);

    void onAdShow();

    void onAdShowFail(AdError adError);

    void onDeeplinkCallback(boolean z);
}
