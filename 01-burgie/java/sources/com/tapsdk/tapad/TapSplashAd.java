package com.tapsdk.tapad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
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

    long getPrice();

    View getSplashView(Activity activity);

    boolean isValid();

    void sendLossNotification(Map<String, Object> map);

    void sendWinNotification(Map<String, Object> map);

    void setSplashInteractionListener(AdInteractionListener adInteractionListener);

    void show(Activity activity);

    void show(ViewGroup viewGroup);
}
