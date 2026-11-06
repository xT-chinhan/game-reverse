package com.kwad.sdk.api;

import android.app.Activity;

/* JADX INFO: loaded from: classes3.dex */
public class KsLoadManagerDefault implements KsLoadManager {
    private static final int ERROR_CODE = 0;
    private static final String ERROR_MSG = "SDK not init success";

    @Override // com.kwad.sdk.api.KsLoadManager
    public String getBidRequestToken(KsScene ksScene) {
        return "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public String getBidRequestTokenV2(KsScene ksScene) {
        return "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        return false;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFullScreenVideoAd(KsScene ksScene, KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        fullScreenVideoAdListener.onError(0, ERROR_MSG);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadRewardVideoAd(KsScene ksScene, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        rewardVideoAdListener.onError(0, ERROR_MSG);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        feedAdListener.onError(0, ERROR_MSG);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadConfigFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        feedAdListener.onError(0, ERROR_MSG);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadDrawAd(KsScene ksScene, KsLoadManager.DrawAdListener drawAdListener) {
        drawAdListener.onError(0, ERROR_MSG);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadNativeAd(KsScene ksScene, KsLoadManager.NativeAdListener nativeAdListener) {
        nativeAdListener.onError(0, ERROR_MSG);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadNativeAd(String str, KsLoadManager.NativeAdListener nativeAdListener) {
        nativeAdListener.onError(0, ERROR_MSG);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadBannerAd(KsScene ksScene, KsLoadManager.BannerAdListener bannerAdListener) {
        bannerAdListener.onError(0, ERROR_MSG);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadSplashScreenAd(KsScene ksScene, KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        splashScreenAdListener.onError(0, ERROR_MSG);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadInterstitialAd(KsScene ksScene, KsLoadManager.InterstitialAdListener interstitialAdListener) {
        interstitialAdListener.onError(0, ERROR_MSG);
    }
}
