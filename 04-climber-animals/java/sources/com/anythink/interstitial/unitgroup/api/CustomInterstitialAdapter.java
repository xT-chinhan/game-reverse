package com.anythink.interstitial.unitgroup.api;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCommonImpressionListener;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.common.d.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomInterstitialAdapter extends ATBaseAdAdapter {
    private static final String TAG = "CustomInterstitialAdapter";
    protected CustomInterstitialEventListener mImpressListener;

    protected boolean isSupportAdCarousel() {
        return false;
    }

    public abstract void show(Activity activity);

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public final void internalFormatShow(Activity activity, ViewGroup viewGroup, final ATCommonImpressionListener aTCommonImpressionListener) {
        this.mImpressListener = new CustomInterstitialEventListener() { // from class: com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter.1
            @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
            public final void onInterstitialAdClicked() {
                aTCommonImpressionListener.onAdClick();
            }

            @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
            public final void onInterstitialAdShow() {
                aTCommonImpressionListener.onAdImpression();
            }

            @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
            public final void onInterstitialAdClose() {
                aTCommonImpressionListener.onAdDismiss();
            }

            @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
            public final void onInterstitialAdVideoStart() {
                aTCommonImpressionListener.onAdVideoPlayStart();
            }

            @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
            public final void onInterstitialAdVideoEnd() {
                aTCommonImpressionListener.onAdVideoPlayEnd();
            }

            @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
            public final void onInterstitialAdVideoError(String str, String str2) {
                aTCommonImpressionListener.onAdShowFail(str, str2);
            }

            @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
            public final void onDeeplinkCallback(boolean z) {
                aTCommonImpressionListener.onDeeplinkCallback(z);
            }

            @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
            public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                aTCommonImpressionListener.onDownloadConfirm(context, aTNetworkConfirmInfo);
            }
        };
        try {
            if (isSupportAdCarousel()) {
                getNetworkName();
                b.b().a(this);
            }
            show(activity);
        } catch (Throwable th) {
            th.printStackTrace();
            CustomInterstitialEventListener customInterstitialEventListener = this.mImpressListener;
            if (customInterstitialEventListener != null) {
                customInterstitialEventListener.onInterstitialAdVideoError("", "exception, show failed: " + th.getMessage());
            }
        }
    }

    public void clearImpressionListener() {
        this.mImpressListener = null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        try {
            if (isSupportAdCarousel()) {
                getNetworkName();
                b.b().b(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
