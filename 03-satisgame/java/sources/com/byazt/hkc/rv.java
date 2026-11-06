package com.byazt.hkc;

import com.anythink.core.common.l.f;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 46, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static void n(String str, JSONObject jSONObject) {
        JSONObject jSONObjectHe = com.byazt.twc.qg.he(str);
        if (jSONObjectHe == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectHe.optJSONObject("values");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        n(jSONObjectOptJSONObject, jSONObject);
    }

    public static JSONObject n(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectHe = com.byazt.twc.qg.he(str);
        if (jSONObjectHe == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return n(jSONObject2, jSONObjectHe.optJSONObject("themeValues"), jSONObject);
    }

    private static void n(JSONObject jSONObject, JSONObject jSONObject2) {
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
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static JSONObject n(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String n(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectHe = com.byazt.twc.qg.he(str);
        if (jSONObjectHe == null || (jSONObjectOptJSONObject = jSONObjectHe.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString(f.R);
    }

    public static String n(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectHe = com.byazt.twc.qg.he(str);
        if (jSONObjectHe == null || (jSONObjectOptJSONObject = jSONObjectHe.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString(str2);
    }

    public static JSONObject n(JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject("values");
    }

    public static String qg(String str, String str2) {
        if (com.byazt.twc.q.n()) {
            if (str.indexOf(46) < 0) {
                str = str + ".png";
            }
            return str2 + "static/images/" + str;
        }
        return n.n(str);
    }
}
