package com.byazt.uko;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 931, 61})
public class aj {
    public static void pr(String str, JSONObject jSONObject) {
        JSONObject jSONObjectWt = com.byazt.dj.hw.wt(str);
        if (jSONObjectWt == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectWt.optJSONObject("values");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        pr(jSONObjectOptJSONObject, jSONObject);
    }

    public static JSONObject pr(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectWt = com.byazt.dj.hw.wt(str);
        if (jSONObjectWt == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return pr(jSONObject2, jSONObjectWt.optJSONObject("themeValues"), jSONObject);
    }

    private static void pr(JSONObject jSONObject, JSONObject jSONObject2) {
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
                }
            }
        }
    }

    public static JSONObject pr(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException e) {
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String pr(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectWt = com.byazt.dj.hw.wt(str);
        if (jSONObjectWt == null || (jSONObjectOptJSONObject = jSONObjectWt.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("data");
    }

    public static String pr(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectWt = com.byazt.dj.hw.wt(str);
        if (jSONObjectWt == null || (jSONObjectOptJSONObject = jSONObjectWt.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString(str2);
    }

    public static JSONObject pr(JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject("values");
    }

    public static String hw(String str, String str2) {
        if (com.byazt.dj.x.pr()) {
            if (str.indexOf(46) < 0) {
                str = str + ".png";
            }
            return str2 + "static/images/" + str;
        }
        return pr.pr(str);
    }
}
