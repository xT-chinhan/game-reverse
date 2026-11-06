package com.tapsdk.tapad;

import android.app.Activity;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface TapRewardVideoAd {

    public interface RewardAdInteractionListener {
        void onAdClick();

        void onAdClose();

        void onAdShow();

        void onAdValidShow();

        void onRewardVerify(boolean z, int i, String str, int i2, String str2);

        void onSkippedVideo();

        void onVideoComplete();

        void onVideoError();
    }

    void dispose();

    Map<String, Object> getMediaExtraInfo();

    void sendLossNotification(Map<String, Object> map);

    void sendWinNotification(Map<String, Object> map);

    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    void showRewardVideoAd(Activity activity);
}
