package com.bytedance.sdk.openadsdk.upie.ms;

import android.text.TextUtils;
import com.bytedance.adsdk.xr.ny;
import com.bytedance.sdk.component.utils.sl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static String ms(String str, JSONObject jSONObject) {
        com.bytedance.adsdk.xr.xr.ms msVarMs;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                if (!str.startsWith("${") || !str.endsWith("}") || (msVarMs = com.bytedance.adsdk.xr.xr.ms.ms(str.substring(2, str.length() - 1))) == null) {
                    return str;
                }
                Object objMs = msVarMs.ms(jSONObject);
                if (objMs instanceof String) {
                    return (String) objMs;
                }
                if (objMs instanceof com.bytedance.adsdk.xr.xr.ms.ms) {
                    return String.valueOf(ny.ms((com.bytedance.adsdk.xr.xr.ms.ms) objMs));
                }
                return String.valueOf(objMs);
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
        return str;
    }
}
