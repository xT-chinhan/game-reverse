package com.bytedance.sdk.openadsdk.core.h.ms;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {
    public static void ms(com.bytedance.sdk.component.ms.h hVar) {
        hVar.ms("getDownloadStatus", (com.bytedance.sdk.component.ms.ka<?, ?>) new u());
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        return ms(jSONObject);
    }

    public static JSONObject ms(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            ms(jSONObject2, 1, "params is null", 1, 1);
            return jSONObject2;
        }
        try {
            String strOptString = jSONObject.optString("ad_down_load_id");
            if (TextUtils.isEmpty(strOptString)) {
                ms(jSONObject2, 1, "ad_down_load_id is null", 1, 1);
                return jSONObject2;
            }
            return com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strOptString);
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    private static void ms(JSONObject jSONObject, int i, String str, int i2, int i3) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("code", i);
            jSONObject.put("codeMsg", str);
            jSONObject.put("downloadStatus", i2);
            jSONObject.put("downloadProcessRate", i3);
        } catch (Exception unused) {
        }
    }
}
