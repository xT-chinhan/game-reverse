package com.bytedance.sdk.openadsdk.core.ugeno.express.ms;

import com.bytedance.adsdk.ugeno.ka.c;
import com.bytedance.sdk.openadsdk.core.h.ms.qv;
import com.bytedance.sdk.openadsdk.core.nativeexpress.hi;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final HashSet<String> f3511ms = new HashSet<>(Arrays.asList("interactiveFinish"));

    public static void ms(hi hiVar, lm lmVar, String str, c.ms msVar) {
        if (msVar == null || hiVar == null) {
            return;
        }
        Map<String, String> mapAh = msVar.ah();
        str.hashCode();
        if (str.equals("interactiveFinish")) {
            int iMs = 0;
            if (mapAh != null) {
                try {
                    iMs = qv.ms(lmVar, Integer.parseInt(mapAh.get("reduce_duration")));
                } catch (NumberFormatException unused) {
                }
            }
            hiVar.xr(iMs);
        }
    }
}
