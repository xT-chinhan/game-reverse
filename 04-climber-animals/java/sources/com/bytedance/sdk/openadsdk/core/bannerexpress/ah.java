package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends xr {
    public ah(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        super(context, lmVar, xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.xr
    protected void ms(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        this.f2018ms = new BannerExpressVideoView(context, lmVar, xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ahVar) {
        if (this.f2018ms != null) {
            this.f2018ms.setVideoAdListener(ahVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr
    public com.bytedance.sdk.openadsdk.core.multipro.xr.ms hi() {
        if (this.ab != null && this.ab.get() != null) {
            return this.ab.get().getVideoModel();
        }
        if (this.f2018ms != null) {
            return ((BannerExpressVideoView) this.f2018ms).getVideoModel();
        }
        return null;
    }
}
