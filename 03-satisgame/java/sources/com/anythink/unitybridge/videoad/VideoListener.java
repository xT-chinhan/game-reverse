package com.anythink.unitybridge.videoad;

import com.anythink.unitybridge.base.BaseAdListener;

/* JADX INFO: loaded from: classes.dex */
public interface VideoListener extends BaseAdListener {
    void onAdRevenuePaid(String str, String str2);

    void onAgainReward(String str, String str2);

    void onReward(String str, String str2);

    void onRewardedVideoAdAgainPlayClicked(String str, String str2);

    void onRewardedVideoAdAgainPlayEnd(String str, String str2);

    void onRewardedVideoAdAgainPlayFailed(String str, String str2, String str3);

    void onRewardedVideoAdAgainPlayStart(String str, String str2);

    void onRewardedVideoAdClosed(String str, boolean z, String str2);

    void onRewardedVideoAdFailed(String str, String str2, String str3);

    void onRewardedVideoAdLoaded(String str);

    void onRewardedVideoAdPlayClicked(String str, String str2);

    void onRewardedVideoAdPlayEnd(String str, String str2);

    void onRewardedVideoAdPlayFailed(String str, String str2, String str3);

    void onRewardedVideoAdPlayStart(String str, String str2);
}
