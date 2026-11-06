package com.anythink.unitybridge.base;

/* JADX INFO: loaded from: classes.dex */
public interface BaseAdListener {
    void onAdSourceAttempt(String str, String str2);

    void onAdSourceBiddingAttempt(String str, String str2);

    void onAdSourceBiddingFail(String str, String str2, String str3, String str4);

    void onAdSourceBiddingFilled(String str, String str2);

    void onAdSourceLoadFail(String str, String str2, String str3, String str4);

    void onAdSourceLoadFilled(String str, String str2);
}
