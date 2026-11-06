package com.anythink.unitybridge.splash;

import com.anythink.unitybridge.base.BaseAdListener;

/* JADX INFO: loaded from: classes.dex */
public interface SplashListener extends BaseAdListener {
    void onAdRevenuePaid(String str, String str2);

    void onSplashAdClick(String str, String str2);

    void onSplashAdDeeplinkCallback(String str, String str2, boolean z);

    void onSplashAdDismiss(String str, String str2);

    void onSplashAdDownloadConfirm(String str, String str2);

    void onSplashAdLoad(String str, boolean z);

    void onSplashAdLoadFailed(String str, String str2, String str3);

    void onSplashAdLoadTimeOut(String str);

    void onSplashAdShow(String str, String str2);
}
