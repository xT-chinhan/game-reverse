package com.bytedance.sdk.openadsdk.core.xr;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ka extends ms {
    protected abstract void xr(View view, hi hiVar);

    public ka(Context context, lm lmVar, String str, int i) {
        super(context, lmVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.xr, com.bytedance.sdk.openadsdk.core.xr.d
    public void ms(View view, hi hiVar) {
        if (lm.ka(this.f3795ms)) {
            return;
        }
        super.ms(view, hiVar);
        com.bytedance.sdk.openadsdk.core.xr.ms.xr xrVar = (com.bytedance.sdk.openadsdk.core.xr.ms.xr) this.x.ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.class);
        if (xrVar == null || !xrVar.xr(view)) {
            return;
        }
        xr(view, hiVar);
    }
}
