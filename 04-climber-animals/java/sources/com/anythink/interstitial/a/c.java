package com.anythink.interstitial.a;

import android.content.Context;
import com.anythink.core.api.ATCommonImpressionListener;
import com.anythink.core.api.ATNetworkConfirmInfo;

/* JADX INFO: loaded from: classes.dex */
public class c implements ATCommonImpressionListener {
    f c;

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdReward() {
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdRewardFailed() {
    }

    public c(f fVar) {
        this.c = fVar;
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdImpression() {
        f fVar = this.c;
        if (fVar != null) {
            fVar.onInterstitialAdShow();
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdShowFail(String str, String str2) {
        f fVar = this.c;
        if (fVar != null) {
            fVar.onInterstitialAdVideoError(str, str2);
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdClick() {
        f fVar = this.c;
        if (fVar != null) {
            fVar.onInterstitialAdClicked();
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdDismiss() {
        f fVar = this.c;
        if (fVar != null) {
            fVar.onInterstitialAdClose();
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdVideoPlayStart() {
        f fVar = this.c;
        if (fVar != null) {
            fVar.onInterstitialAdVideoStart();
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdVideoPlayEnd() {
        f fVar = this.c;
        if (fVar != null) {
            fVar.onInterstitialAdVideoEnd();
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onDeeplinkCallback(boolean z) {
        f fVar = this.c;
        if (fVar != null) {
            fVar.onDeeplinkCallback(z);
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        f fVar = this.c;
        if (fVar != null) {
            fVar.onDownloadConfirm(context, aTNetworkConfirmInfo);
        }
    }
}
