package com.bytedance.sdk.openadsdk.core.component.reward.ms;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends xr {
    private static volatile ka xr;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ms.xr
    protected boolean xr() {
        return true;
    }

    public static ka ms() {
        if (xr == null) {
            synchronized (ka.class) {
                if (xr == null) {
                    xr = new ka(re.getContext());
                }
            }
        }
        return xr;
    }

    private ka(Context context) {
        super(context);
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str, int i, ah ahVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ah ahVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ah();
        ahVar2.ms(str);
        ahVar2.ms(i + 1);
        ms(xrVar, ahVar, ahVar2);
    }
}
