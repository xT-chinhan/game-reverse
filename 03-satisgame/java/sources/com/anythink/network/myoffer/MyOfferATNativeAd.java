package com.anythink.network.myoffer;

import android.content.Context;
import android.view.View;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.format.SDMNativeAd;
import com.smartdigimkt.sdk.api.format.SDMNativeAdListener;

/* JADX INFO: loaded from: classes.dex */
public class MyOfferATNativeAd extends CustomNativeAd {
    SDMNativeAd a;
    Context b;
    View c;

    class a implements SDMNativeAdListener {
        a() {
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdListener
        public void onAdClick() {
            MyOfferATNativeAd.this.notifyAdClicked();
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdListener
        public void onAdClosed() {
            MyOfferATNativeAd.this.notifyAdDislikeClick();
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdListener
        public void onAdShow() {
            MyOfferATNativeAd.this.notifyAdImpression();
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdListener
        public void onDeeplinkCallback(boolean z) {
            MyOfferATNativeAd.this.notifyDeeplinkCallback(z);
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdListener
        public void onShowFailed(AdError adError) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0068  */
    public MyOfferATNativeAd(Context context, SDMNativeAd sDMNativeAd) {
        this.b = context.getApplicationContext();
        this.a = sDMNativeAd;
        sDMNativeAd.setListener(new a());
        setAdChoiceIconUrl(this.a.getAdChoiceIconUrl());
        setTitle(this.a.getTitle());
        setDescriptionText(this.a.getDescription());
        setIconImageUrl(this.a.getIcon());
        setMainImageUrl(this.a.getMainImageUrl());
        setCallToActionText(this.a.getCallToAction());
        int interactionType = sDMNativeAd.getInteractionType();
        if (interactionType == 1) {
            setNativeInteractionType(1);
        } else if (interactionType == 2 || interactionType == 3) {
            setNativeInteractionType(2);
        } else if (interactionType == 4) {
            setNativeInteractionType(1);
        } else if (interactionType == 6 || interactionType == 7) {
            setNativeInteractionType(3);
        }
        setMainImageWidth(this.a.getAdImageWidth());
        setMainImageHeight(this.a.getAdImageHeight());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
        SDMNativeAd sDMNativeAd = this.a;
        if (sDMNativeAd != null) {
            sDMNativeAd.unregisterView();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        SDMNativeAd sDMNativeAd = this.a;
        if (sDMNativeAd != null) {
            sDMNativeAd.setListener(null);
            this.a.destroy();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.c == null) {
            this.c = this.a.getMediaView(this.b, null);
        }
        return this.c;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public int getDownloadStatus() {
        int downloadStatus;
        SDMNativeAd sDMNativeAd = this.a;
        if (sDMNativeAd == null || (downloadStatus = sDMNativeAd.getDownloadStatus()) < 0) {
            return 0;
        }
        return downloadStatus;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (this.a != null) {
            this.a.registerAdView(view, aTNativePrepareInfo.getClickViewList(), aTNativePrepareInfo instanceof ATNativePrepareExInfo ? ((ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList() : null, null, null);
        }
    }
}
