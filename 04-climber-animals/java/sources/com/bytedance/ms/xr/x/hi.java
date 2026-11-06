package com.bytedance.ms.xr.x;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class hi {
    public static void ms(com.bytedance.ms.xr.ah.ms msVar, com.bytedance.ms.xr.ah.xr xrVar, com.bytedance.ms.xr.ah ahVar) {
        if (msVar == null || msVar.ms() == null || ahVar == null) {
            return;
        }
        JSONObject jSONObjectMs = msVar.ms();
        long jOptLong = jSONObjectMs.optLong("crash_time");
        int iXr = xr(ms("aid"));
        String strMs = com.bytedance.ms.xr.x.ah().ms();
        if (jOptLong <= 0 || iXr <= 0 || TextUtils.isEmpty(strMs) || "0".equals(strMs) || TextUtils.isEmpty(ahVar.ms())) {
            return;
        }
        try {
            String str = "android_" + iXr + "_" + strMs + "_" + jOptLong + "_" + ahVar;
            if (xrVar != null) {
                JSONObject jSONObjectMs2 = xrVar.ms();
                if (jSONObjectMs2 != null) {
                    jSONObjectMs2.put("unique_key", str);
                    return;
                }
                return;
            }
            jSONObjectMs.put("unique_key", str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public static String ms(String str) {
        Map<String, Object> mapMs;
        if (com.bytedance.ms.xr.x.ms() == null || (mapMs = com.bytedance.ms.xr.x.ms().ms()) == null) {
            return null;
        }
        Object obj = mapMs.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static int xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            ch.xr(e);
            return 0;
        }
    }
}
