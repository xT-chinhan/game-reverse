package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class ny {
    public static void ms(final String str, final String str2, final lm lmVar) {
        final long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        com.bytedance.sdk.openadsdk.core.t.u.ms().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ny.1
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(ny.ms(str)).ah(str2).c(f.zb(lmVar)).ms("dynamic_backup_render_new");
                xrVarMs.ms(jCurrentTimeMillis);
                return xrVarMs;
            }
        }, "dynamic_backup_render_new");
    }

    public static void ms(final int i, final String str, final String str2, final lm lmVar) {
        com.bytedance.sdk.openadsdk.core.t.u.ms().ka(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ny.2
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(ny.ms(str)).ah(str2).c(f.zb(lmVar)).xr(i).ab(com.bytedance.sdk.openadsdk.core.ny.ms(i));
            }
        });
    }

    public static int ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return 5;
        }
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 1;
            case "rewarded_video":
                return 7;
            case "stream":
                return 6;
            case "fullscreen_interstitial_ad":
                return 8;
            case "splash_ad":
                return 3;
            case "interaction":
                return 2;
            case "draw_ad":
                return 9;
            default:
                return 5;
        }
    }
}
