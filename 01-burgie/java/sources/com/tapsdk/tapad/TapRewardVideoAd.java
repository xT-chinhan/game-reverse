package com.tapsdk.tapad;

import android.app.Activity;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface TapRewardVideoAd {

    public interface RewardAdInteractionListener {
        void onAdClick(TapRewardVideoAd tapRewardVideoAd);

        void onAdClose(TapRewardVideoAd tapRewardVideoAd);

        void onAdShow(TapRewardVideoAd tapRewardVideoAd);

        void onAdValidShow(TapRewardVideoAd tapRewardVideoAd);

        void onRewardVerify(TapRewardVideoAd tapRewardVideoAd, boolean z, int i, String str, int i2, String str2);

        void onSkippedVideo(TapRewardVideoAd tapRewardVideoAd);

        void onVideoComplete(TapRewardVideoAd tapRewardVideoAd);

        void onVideoError(TapRewardVideoAd tapRewardVideoAd);
    }

    void dispose();

    Map<String, Object> getMediaExtraInfo();

    long getPrice();

    boolean isValid();

    void sendLossNotification(Map<String, Object> map);

    void sendWinNotification(Map<String, Object> map);

    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    void showRewardVideoAd(Activity activity);
}
