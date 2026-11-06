package com.smartdigimkt.t4;

import com.smartdigimkt.sdk.api.format.SDMNativeAdListener;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements com.smartdigimkt.j1.a {
    public final /* synthetic */ SDMNativeAdListener a;

    public t(SDMNativeAdListener sDMNativeAdListener) {
        this.a = sDMNativeAdListener;
    }

    @Override // com.smartdigimkt.j1.a
    public final void onAdClick(com.smartdigimkt.j1.w wVar) {
        SDMNativeAdListener sDMNativeAdListener = this.a;
        if (sDMNativeAdListener != null) {
            sDMNativeAdListener.onAdClick();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public final void onAdClosed() {
    }

    @Override // com.smartdigimkt.j1.a
    public final void onAdShow(com.smartdigimkt.j1.w wVar) {
        SDMNativeAdListener sDMNativeAdListener = this.a;
        if (sDMNativeAdListener != null) {
            sDMNativeAdListener.onAdShow();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public final void onDeeplinkCallback(boolean z) {
    }

    @Override // com.smartdigimkt.j1.a
    public final void onShowFailed(com.smartdigimkt.h0.g gVar) {
    }
}
