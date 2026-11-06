package com.anythink.splashad.unitgroup.api;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.core.api.ATCommonImpressionListener;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.splashad.api.ATSplashSkipInfo;
import com.anythink.splashad.api.IATSplashEyeAd;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomSplashAdapter extends ATBaseAdAdapter {
    ATSplashSkipInfo mATSplashSkipInfo;
    protected CustomSplashEventListener mImpressionListener;

    public final void cleanImpressionListener() {
    }

    public IATSplashEyeAd getSplashEyeAd() {
        return null;
    }

    public abstract void show(Activity activity, ViewGroup viewGroup);

    public void startSplashCustomSkipViewClickEye() {
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public final void internalFormatShow(Activity activity, ViewGroup viewGroup, final ATCommonImpressionListener aTCommonImpressionListener) {
        this.mImpressionListener = new CustomSplashEventListener() { // from class: com.anythink.splashad.unitgroup.api.CustomSplashAdapter.1
            @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
            public final void onSplashAdShow() {
                aTCommonImpressionListener.onAdImpression();
            }

            @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
            public final void onSplashAdClicked() {
                aTCommonImpressionListener.onAdClick();
            }

            @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
            public final void onSplashAdReward() {
                aTCommonImpressionListener.onAdReward();
            }

            @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
            public final void onSplashAdDismiss() {
                aTCommonImpressionListener.onAdDismiss();
            }

            @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
            public final void onDeeplinkCallback(boolean z) {
                aTCommonImpressionListener.onDeeplinkCallback(z);
            }

            @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
            public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                aTCommonImpressionListener.onDownloadConfirm(context, aTNetworkConfirmInfo);
            }

            @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
            public final void onSplashAdShowFail(AdError adError) {
                aTCommonImpressionListener.onAdShowFail(adError.getPlatformCode(), adError.getPlatformMSG());
            }
        };
        show(activity, viewGroup);
    }

    public final void setSplashSkipInfo(ATSplashSkipInfo aTSplashSkipInfo) {
        this.mATSplashSkipInfo = aTSplashSkipInfo;
    }

    public final ATSplashSkipInfo getSplashSkipInfo() {
        return this.mATSplashSkipInfo;
    }

    public boolean isSupportCustomSkipView() {
        return isMixNative();
    }

    public final boolean isCustomSkipView() {
        ATSplashSkipInfo aTSplashSkipInfo = this.mATSplashSkipInfo;
        if (aTSplashSkipInfo != null) {
            return aTSplashSkipInfo.canUseCustomSkipView();
        }
        return false;
    }
}
