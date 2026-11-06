package com.bytedance.sdk.openadsdk.core.component.reward.ms;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends xr {
    private static volatile ms xr;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ms.xr
    protected boolean xr() {
        return false;
    }

    public static ms ms() {
        if (xr == null) {
            synchronized (ms.class) {
                if (xr == null) {
                    xr = new ms(re.getContext());
                }
            }
        }
        return xr;
    }

    private ms(Context context) {
        super(context);
    }
}
