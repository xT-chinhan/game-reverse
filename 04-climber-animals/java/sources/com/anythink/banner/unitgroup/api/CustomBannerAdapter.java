package com.anythink.banner.unitgroup.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCommonImpressionListener;
import com.anythink.core.api.ATNetworkConfirmInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomBannerAdapter extends ATBaseAdAdapter {
    public CustomBannerEventListener mImpressionEventListener;

    public abstract View getBannerView();

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        return getBannerView() != null;
    }

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public View getMixView() {
        return getBannerView();
    }

    public final void setAdEventListener(CustomBannerEventListener customBannerEventListener) {
        this.mImpressionEventListener = customBannerEventListener;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public final void releaseLoadResource() {
        super.releaseLoadResource();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void internalFormatShow(Activity activity, ViewGroup viewGroup, final ATCommonImpressionListener aTCommonImpressionListener) {
        this.mImpressionEventListener = new CustomBannerEventListener() { // from class: com.anythink.banner.unitgroup.api.CustomBannerAdapter.1
            @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
            public final void onBannerAdClicked() {
                ATCommonImpressionListener aTCommonImpressionListener2 = aTCommonImpressionListener;
                if (aTCommonImpressionListener2 != null) {
                    aTCommonImpressionListener2.onAdClick();
                }
            }

            @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
            public final void onBannerAdShow() {
                ATCommonImpressionListener aTCommonImpressionListener2 = aTCommonImpressionListener;
                if (aTCommonImpressionListener2 != null) {
                    aTCommonImpressionListener2.onAdImpression();
                }
            }

            @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
            public final void onBannerAdClose() {
                ATCommonImpressionListener aTCommonImpressionListener2 = aTCommonImpressionListener;
                if (aTCommonImpressionListener2 != null) {
                    aTCommonImpressionListener2.onAdDismiss();
                }
            }

            @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
            public final void onDeeplinkCallback(boolean z) {
                ATCommonImpressionListener aTCommonImpressionListener2 = aTCommonImpressionListener;
                if (aTCommonImpressionListener2 != null) {
                    aTCommonImpressionListener2.onDeeplinkCallback(z);
                }
            }

            @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
            public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                ATCommonImpressionListener aTCommonImpressionListener2 = aTCommonImpressionListener;
                if (aTCommonImpressionListener2 != null) {
                    aTCommonImpressionListener2.onDownloadConfirm(context, aTNetworkConfirmInfo);
                }
            }
        };
    }
}
