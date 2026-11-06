package com.bytedance.sdk.openadsdk.core.jw;

import com.umeng.analytics.pro.cl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ub {
    public static boolean ms() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObjectGy = com.bytedance.sdk.openadsdk.core.re.xr().gy();
        if (jSONObjectGy == null) {
            return false;
        }
        return jCurrentTimeMillis >= jSONObjectGy.optLong("start", 1707480000000L) && jCurrentTimeMillis <= jSONObjectGy.optLong(cl.s, 1707498000000L);
    }

    public static boolean xr() {
        JSONObject jSONObjectGy = com.bytedance.sdk.openadsdk.core.re.xr().gy();
        return jSONObjectGy != null && ms() && jSONObjectGy.optInt("force_drop", 0) == 1;
    }
}
