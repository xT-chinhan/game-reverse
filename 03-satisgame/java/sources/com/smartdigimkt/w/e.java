package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferBannerView;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.smartdigimkt.t4.i {
    final /* synthetic */ SDMMyOfferBannerView this$0;

    public e(SDMMyOfferBannerView sDMMyOfferBannerView) {
        this.this$0 = sDMMyOfferBannerView;
    }

    @Override // com.smartdigimkt.t4.i
    public void onBannerClicked() {
        com.smartdigimkt.q3.f.a().a(new a(this));
    }

    @Override // com.smartdigimkt.t4.i
    public void onBannerClose() {
        com.smartdigimkt.q3.f.a().a(new c(this));
    }

    @Override // com.smartdigimkt.t4.i
    public void onBannerShow(boolean z) {
        com.smartdigimkt.q3.f.a().a(new b(this));
    }

    @Override // com.smartdigimkt.t4.i
    public void onDeeplinkCallback(boolean z) {
        com.smartdigimkt.q3.f.a().a(new d(this, z));
    }
}
