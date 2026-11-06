package com.smartdigimkt.v;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.format.SDMBannerView;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.smartdigimkt.t4.i {
    final /* synthetic */ SDMBannerView this$0;

    public e(SDMBannerView sDMBannerView) {
        this.this$0 = sDMBannerView;
    }

    @Override // com.smartdigimkt.t4.i
    public void onBannerClicked() {
        this.this$0.onAdStatus("click", "success");
        com.smartdigimkt.q3.f.a().a(new a(this));
    }

    @Override // com.smartdigimkt.t4.i
    public void onBannerClose() {
        this.this$0.onAdStatus(ILivePush.ClickType.CLOSE, "success");
        com.smartdigimkt.q3.f.a().a(new c(this));
    }

    @Override // com.smartdigimkt.t4.i
    public void onBannerShow(boolean z) {
        this.this$0.onAdStatus("impression", "success");
        com.smartdigimkt.q3.f.a().a(new b(this));
    }

    @Override // com.smartdigimkt.t4.i
    public void onDeeplinkCallback(boolean z) {
        this.this$0.onAdStatus(SDMAdConst.NETWORK_CUSTOM_KEY.DEEPLINK, z ? "success" : "fail");
        com.smartdigimkt.q3.f.a().a(new d(this, z));
    }
}
