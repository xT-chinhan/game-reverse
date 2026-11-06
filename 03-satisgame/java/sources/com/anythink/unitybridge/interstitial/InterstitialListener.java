package com.anythink.unitybridge.interstitial;

import com.anythink.unitybridge.base.BaseAdListener;

/* JADX INFO: loaded from: classes.dex */
public interface InterstitialListener extends BaseAdListener {
    void onAdRevenuePaid(String str, String str2);

    void onInterstitialAdClicked(String str, String str2);

    void onInterstitialAdClose(String str, String str2);

    void onInterstitialAdLoadFail(String str, String str2, String str3);

    void onInterstitialAdLoaded(String str);

    void onInterstitialAdShow(String str, String str2);

    void onInterstitialAdVideoEnd(String str, String str2);

    void onInterstitialAdVideoError(String str, String str2, String str3);

    void onInterstitialAdVideoStart(String str, String str2);
}
