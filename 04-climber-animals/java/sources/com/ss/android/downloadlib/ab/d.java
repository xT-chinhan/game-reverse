package com.ss.android.downloadlib.ab;

import android.text.TextUtils;
import com.anythink.core.common.h.aq;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static String ms(String str, String str2, boolean z, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("notification_jump_url", str2);
            }
            jSONObject.put("show_toast", z);
            jSONObject.put(aq.h, str3);
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        return jSONObject.toString();
    }
}
