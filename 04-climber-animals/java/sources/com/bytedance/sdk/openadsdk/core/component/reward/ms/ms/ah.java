package com.bytedance.sdk.openadsdk.core.component.reward.ms.ms;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.jw.g;
import com.bytedance.sdk.openadsdk.core.jw.op;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final com.bytedance.sdk.component.d.ms.xr f2224ms = g.ms("full_reward_adslot");

    public com.bytedance.sdk.openadsdk.ao.xr.ah.xr ms(String str) {
        try {
            return op.ms(f2224ms.xr(str, (String) null));
        } catch (Throwable unused) {
            return null;
        }
    }

    public void ms(String str, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        if (xrVar != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                f2224ms.ms(str, op.ms(xrVar, str).toString());
            } catch (Throwable unused) {
            }
        }
    }
}
