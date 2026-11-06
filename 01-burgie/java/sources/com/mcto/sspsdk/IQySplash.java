package com.mcto.sspsdk;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IQySplash {

    public interface IAdInteractionListener {
        void onAdClick();

        void onAdShow();

        void onAdSkip();

        void onAdTimeOver();
    }

    Map<String, String> getAdExtra();

    View getSplashView();

    void setSplashInteractionListener(IAdInteractionListener iAdInteractionListener);
}
