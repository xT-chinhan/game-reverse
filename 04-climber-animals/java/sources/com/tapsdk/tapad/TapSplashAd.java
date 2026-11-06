package com.tapsdk.tapad;

import android.app.Activity;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface TapSplashAd {

    public interface AdInteractionListener {
        void onAdClick();

        void onAdShow();

        void onAdSkip();

        void onAdTimeOver();

        void onAdValidShow();
    }

    void destroyView();

    void dispose();

    long getExpirationTimestamp();

    Map<String, Object> getMediaExtraInfo();

    View getSplashView(Activity activity);

    void sendLossNotification(Map<String, Object> map);

    void sendWinNotification(Map<String, Object> map);

    void setSplashInteractionListener(AdInteractionListener adInteractionListener);

    void show(Activity activity);
}
