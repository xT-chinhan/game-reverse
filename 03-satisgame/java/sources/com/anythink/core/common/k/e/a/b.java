package com.anythink.core.common.k.e.a;

import android.content.Context;
import android.view.View;
import com.anythink.core.api.ATNetworkConfirmInfo;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    void onAdClicked(View view);

    void onAdDislikeButtonClick();

    void onAdImpressed();

    void onAdVideoEnd();

    void onAdVideoProgress(int i);

    void onAdVideoStart();

    void onClose();

    void onDeeplinkCallback(boolean z);

    void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo);

    void onVideoError(String str, String str2);
}
