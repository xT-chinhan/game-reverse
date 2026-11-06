package com.anythink.splashad.api;

import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class ATSplashAdEZListener implements ATSplashExListener {
    @Override // com.anythink.splashad.api.ATSplashAdListener
    public final void onAdLoadTimeout() {
    }

    public abstract void onAdLoaded();

    @Override // com.anythink.splashad.api.ATSplashExListener
    public void onDeeplinkCallback(ATAdInfo aTAdInfo, boolean z) {
    }

    @Override // com.anythink.splashad.api.ATSplashExListener
    public void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
    }

    @Override // com.anythink.splashad.api.ATSplashAdListener
    public final void onAdLoaded(boolean z) {
        onAdLoaded();
    }
}
