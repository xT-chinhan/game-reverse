package com.ss.android.download.api.ah;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.ab;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class xr {
    public static long ms(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        try {
            return Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static boolean ms(com.ss.android.socialbase.downloader.ab.ms msVar, String str) {
        if (msVar == null || msVar.ms("apk_update_handler_enable", 1) != 1) {
            return false;
        }
        return "application/ttpatch".equals(str);
    }

    public static JSONObject ms(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            } catch (JSONException e) {
                ab.ms(e);
            }
        }
        return jSONObject2;
    }

    public static JSONObject ms(JSONObject jSONObject) {
        return ms(jSONObject, new JSONObject());
    }

    public static JSONObject ms(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectArr != null && jSONObjectArr.length != 0) {
            for (JSONObject jSONObject2 : jSONObjectArr) {
                if (jSONObject2 != null) {
                    ms(jSONObject2, jSONObject);
                }
            }
        }
        return jSONObject;
    }

    public static String ms(String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }
}
