package com.tapsdk.tapad;

import android.app.Activity;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface TapBannerAd {

    public interface BannerInteractionListener {
        void onAdClick();

        void onAdClose();

        void onAdShow();

        void onAdValidShow();
    }

    void dispose();

    View getBannerView();

    Map<String, Object> getMediaExtraInfo();

    long getPrice();

    boolean isValid();

    void sendLossNotification(Map<String, Object> map);

    void sendWinNotification(Map<String, Object> map);

    void setBannerInteractionListener(BannerInteractionListener bannerInteractionListener);

    void show(Activity activity, int i, int i2);
}
