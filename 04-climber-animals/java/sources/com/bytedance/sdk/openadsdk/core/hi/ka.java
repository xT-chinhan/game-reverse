package com.bytedance.sdk.openadsdk.core.hi;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.hi.ah.hi;
import com.bytedance.sdk.openadsdk.core.hi.ah.u;
import com.bytedance.sdk.openadsdk.core.hi.ah.zb;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    public static com.bytedance.sdk.openadsdk.core.hi.xr.ah ms(Context context, lm lmVar, String str, boolean z) {
        if (com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms()) {
            if (ms()) {
                return new xr(context, lmVar, str, z);
            }
            return new hi(context, lmVar, str, z);
        }
        if (f.xr(context)) {
            if (ms()) {
                return new com.bytedance.sdk.openadsdk.core.hi.ah.ny(context, lmVar, str, z);
            }
            return new com.bytedance.sdk.openadsdk.core.hi.ah.ch(context, lmVar, str, z);
        }
        if (ms()) {
            return new com.bytedance.sdk.openadsdk.core.hi.ah.ah(context, lmVar, str, z);
        }
        return new com.bytedance.sdk.openadsdk.core.hi.ah.d(context, lmVar, str, z);
    }

    public static com.bytedance.sdk.openadsdk.core.hi.xr.d xr(Context context, lm lmVar, String str, boolean z) {
        if (f.xr(context)) {
            if (ms()) {
                return new com.bytedance.sdk.openadsdk.core.hi.ah.c(context, lmVar, str, z);
            }
            return new com.bytedance.sdk.openadsdk.core.hi.ah.ab(context, lmVar, str, z);
        }
        if (ms()) {
            return new com.bytedance.sdk.openadsdk.core.hi.ah.ms(context, lmVar, str, z);
        }
        return new com.bytedance.sdk.openadsdk.core.hi.ah.xr(context, lmVar, str, z);
    }

    public static com.bytedance.sdk.openadsdk.core.hi.xr.ah ms(Context context, String str, lm lmVar, String str2) {
        if (ms()) {
            return new zb(context, str, lmVar, str2, f.b(lmVar));
        }
        return new u(context, str, lmVar, str2, f.b(lmVar));
    }

    public static boolean ms() {
        return g.xr >= 6600 && re.xr().ub();
    }
}
