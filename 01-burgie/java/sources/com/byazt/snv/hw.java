package com.byazt.snv;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 777, 13})
public class hw {
    public static long pr(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        try {
            return Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    public static boolean pr(com.byazt.ew.pr prVar, String str) {
        if (prVar != null && prVar.pr("apk_update_handler_enable", 1) == 1) {
            return "application/ttpatch".equals(str);
        }
        return false;
    }

    public static JSONObject pr(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            } catch (JSONException e) {
            }
        }
        return jSONObject2;
    }

    public static JSONObject pr(JSONObject jSONObject) {
        return pr(jSONObject, new JSONObject());
    }

    public static JSONObject pr(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectArr == null || jSONObjectArr.length == 0) {
            return jSONObject;
        }
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                pr(jSONObject2, jSONObject);
            }
        }
        return jSONObject;
    }

    public static String pr(String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }
}
