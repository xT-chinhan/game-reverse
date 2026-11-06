package com.smartdigimkt.sdk.api.format;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public interface SDMNativeAdListener {
    void onAdClick();

    void onAdClosed();

    void onAdShow();

    void onDeeplinkCallback(boolean z);

    void onShowFailed(AdError adError);
}
