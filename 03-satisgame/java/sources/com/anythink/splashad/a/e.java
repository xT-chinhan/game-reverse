package com.anythink.splashad.a;

import android.content.Context;
import com.anythink.core.api.ATCommonImpressionListener;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.ErrorCode;

/* JADX INFO: loaded from: classes.dex */
public final class e implements ATCommonImpressionListener {
    f a;

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdRewardFailed() {
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdVideoPlayEnd() {
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdVideoPlayStart() {
    }

    public e(f fVar) {
        this.a = fVar;
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdImpression() {
        f fVar = this.a;
        if (fVar != null) {
            fVar.onSplashAdShow();
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdShowFail(String str, String str2) {
        f fVar = this.a;
        if (fVar != null) {
            fVar.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2));
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdClick() {
        f fVar = this.a;
        if (fVar != null) {
            fVar.onSplashAdClicked();
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdDismiss() {
        f fVar = this.a;
        if (fVar != null) {
            fVar.onSplashAdDismiss();
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdReward() {
        f fVar = this.a;
        if (fVar != null) {
            fVar.onSplashAdReward();
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onDeeplinkCallback(boolean z) {
        f fVar = this.a;
        if (fVar != null) {
            fVar.onDeeplinkCallback(z);
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        f fVar = this.a;
        if (fVar != null) {
            fVar.onDownloadConfirm(context, aTNetworkConfirmInfo);
        }
    }

    public final void a(int i) {
        f fVar = this.a;
        if (fVar != null) {
            fVar.a(i);
        }
    }
}
