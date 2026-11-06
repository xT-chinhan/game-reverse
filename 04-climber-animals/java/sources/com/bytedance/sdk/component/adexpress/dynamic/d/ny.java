package com.bytedance.sdk.component.adexpress.dynamic.d;

import com.bytedance.sdk.component.utils.sl;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ny {
    public static void ms(String str, JSONObject jSONObject) {
        JSONObject jSONObjectQr = com.bytedance.sdk.component.adexpress.xr.qr(str);
        if (jSONObjectQr == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectQr.optJSONObject("values");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        ms(jSONObjectOptJSONObject, jSONObject);
    }

    public static JSONObject ms(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectQr = com.bytedance.sdk.component.adexpress.xr.qr(str);
        if (jSONObjectQr == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return ms(jSONObject2, jSONObjectQr.optJSONObject("themeValues"), jSONObject);
    }

    private static void ms(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.has(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    sl.ms(e);
                }
            }
        }
    }

    public static JSONObject ms(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException e) {
                        sl.ms(e);
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String ms(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectQr = com.bytedance.sdk.component.adexpress.xr.qr(str);
        if (jSONObjectQr == null || (jSONObjectOptJSONObject = jSONObjectQr.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("data");
    }

    public static String ms(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectQr = com.bytedance.sdk.component.adexpress.xr.qr(str);
        if (jSONObjectQr == null || (jSONObjectOptJSONObject = jSONObjectQr.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString(str2);
    }

    public static JSONObject ms(JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject("values");
    }

    public static String xr(String str, String str2) {
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            if (str.indexOf(46) < 0) {
                str = str + ".png";
            }
            return str2 + "static/images/" + str;
        }
        return ms.ms(str);
    }
}
