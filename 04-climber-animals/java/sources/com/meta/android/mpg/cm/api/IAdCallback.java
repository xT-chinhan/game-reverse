package com.meta.android.mpg.cm.api;

/* JADX INFO: loaded from: classes3.dex */
public interface IAdCallback {

    public interface IVideoIAdCallback extends IAdCallback {
        void onAdClickSkip();

        void onAdReward();
    }

    void onAdClick();

    void onAdClose();

    void onAdShow();

    void onAdShowFailed(int i, String str);
}
