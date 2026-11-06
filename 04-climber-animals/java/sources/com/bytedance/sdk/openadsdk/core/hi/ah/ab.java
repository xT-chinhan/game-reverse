package com.bytedance.sdk.openadsdk.core.hi.ah;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends ch implements com.bytedance.sdk.openadsdk.core.hi.xr.d {
    private com.bytedance.sdk.openadsdk.core.hi.xr.d.ms w;

    public ab(Context context, lm lmVar, String str, boolean z) {
        super(context, lmVar, str, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.d
    public void ms(com.bytedance.sdk.openadsdk.core.hi.xr.d.ms msVar) {
        this.w = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x, com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ny() {
        super.ny();
        this.w = null;
    }
}
