package com.meta.android.mpg.cm.api;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public interface IMetaAdApi {
    void closeBannerAd();

    String getApiVersion();

    void init(Application application, String str, InitCallback initCallback);

    @Deprecated
    boolean isInSupportVersion();

    boolean isInSupportVersion(int i);

    boolean isInitialized();

    void setLogLevel(int i);

    void setPersonalRecommendAd(boolean z);

    void showBannerAd(int i, IAdCallback iAdCallback);

    void showInterstitialAd(int i, IAdCallback iAdCallback);

    void showVideoAd(int i, IAdCallback.IVideoIAdCallback iVideoIAdCallback);
}
