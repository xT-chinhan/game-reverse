package com.bytedance.sdk.openadsdk.core.t;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.re;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    public static boolean ms(String str, double d) {
        JSONObject jSONObjectRt = re.xr().rt();
        if (jSONObjectRt != null && !TextUtils.isEmpty(str)) {
            try {
                double dOptDouble = jSONObjectRt.optDouble(str, d);
                if (dOptDouble >= 1.0d || dOptDouble < 0.0d || com.bytedance.sdk.openadsdk.core.zb.xr.f3898ms.contains(str)) {
                    return true;
                }
                return com.bytedance.sdk.openadsdk.core.c.xr.ms((float) dOptDouble, false);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.xr("sample throwable:" + th.getMessage());
            }
        }
        return true;
    }
}
