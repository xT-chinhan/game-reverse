package com.anythink.unitybridge.nativead;

import com.anythink.unitybridge.base.BaseAdListener;

/* JADX INFO: loaded from: classes.dex */
public interface NativeListener extends BaseAdListener {
    void onAdClicked(String str, String str2);

    void onAdCloseButtonClicked(String str, String str2);

    void onAdImpressed(String str, String str2);

    void onAdRevenuePaid(String str, String str2);

    void onAdVideoEnd(String str);

    void onAdVideoProgress(String str, int i);

    void onAdVideoStart(String str);

    void onNativeAdLoadFail(String str, String str2, String str3);

    void onNativeAdLoaded(String str);
}
