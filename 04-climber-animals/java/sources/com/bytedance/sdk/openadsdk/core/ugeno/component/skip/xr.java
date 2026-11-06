package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends com.bytedance.adsdk.ugeno.widget.text.xr {
    public xr(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.xr, com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        if (TextUtils.isEmpty(this.f430ms)) {
            ((UGTextView) this.ka).setText("跳过");
        }
    }

    public void d(boolean z) {
        if (z) {
            xr(0);
            op();
        } else {
            d(0);
            ka(0);
        }
    }
}
