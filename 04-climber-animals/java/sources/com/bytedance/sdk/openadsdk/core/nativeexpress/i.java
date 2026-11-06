package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class i extends w {
    public i(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        super(context, lmVar, xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.core.nativeexpress.re
    public void ms(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        this.d = "draw_ad";
        this.f2987ms = new NativeExpressDrawVideoView(context, lmVar, xrVar, "draw_ad");
        ms(this.f2987ms, this.ah);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(boolean z) {
        if (this.f2987ms != null) {
            ((NativeExpressVideoView) this.f2987ms).setCanInterruptVideoPlay(z);
        }
    }
}
