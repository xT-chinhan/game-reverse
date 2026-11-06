package com.tapsdk.tapad;

import android.app.Activity;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface TapInterstitialAd {

    public interface InterstitialAdInteractionListener {
        void onAdClick();

        void onAdClose();

        void onAdError();

        void onAdShow();

        void onAdValidShow();
    }

    void dispose();

    Map<String, Object> getMediaExtraInfo();

    long getPrice();

    boolean isValid();

    void sendLossNotification(Map<String, Object> map);

    void sendWinNotification(Map<String, Object> map);

    void setInteractionListener(InterstitialAdInteractionListener interstitialAdInteractionListener);

    void show(Activity activity);
}
