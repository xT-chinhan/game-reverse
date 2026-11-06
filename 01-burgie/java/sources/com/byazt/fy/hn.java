package com.byazt.fy;

import android.text.TextUtils;
import com.byazt.ch.nt;
import com.byazt.dd.fw;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 967, 20})
public final class hn {
    public final Map<String, Object> hw;
    public final String pr;

    private hn(String str, Map<String, Object> map) {
        this.pr = str;
        this.hw = map;
    }

    public static hn pr(nt ntVar, JSONObject jSONObject, Map<String, Object> map) {
        String strPr;
        JSONObject jSONObjectHn = ntVar != null ? ntVar.hn() : null;
        HashMap map2 = new HashMap();
        if (jSONObjectHn == null) {
            strPr = "";
        } else {
            strPr = com.byazt.tn.hw.pr(jSONObjectHn.optString("type"), jSONObject);
            JSONObject jSONObjectOptJSONObject = jSONObjectHn.optJSONObject("params");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map2.put(next, pr(jSONObjectOptJSONObject.opt(next), jSONObject));
                }
            }
        }
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        return new hn(strPr, map2);
    }

    public static hn pr(fw.pr prVar, JSONObject jSONObject, Map<String, Object> map) {
        String strPr = com.byazt.tn.hw.pr(prVar != null ? prVar.hw() : "", jSONObject);
        HashMap map2 = new HashMap();
        if (prVar != null && prVar.hn() != null) {
            for (Map.Entry<String, Object> entry : prVar.hn().entrySet()) {
                map2.put(entry.getKey(), pr(entry.getValue(), jSONObject));
            }
        }
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        return new hn(strPr, map2);
    }

    public String pr() {
        return this.pr;
    }

    public Map<String, Object> hw() {
        return this.hw;
    }

    public String pr(String str) {
        Map<String, Object> map = this.hw;
        Object obj = map != null ? map.get(str) : null;
        return obj == null ? "" : String.valueOf(obj);
    }

    public int pr(String str, int i) {
        Map<String, Object> map = this.hw;
        Object obj = map != null ? map.get(str) : null;
        if (obj == null) {
            return i;
        }
        try {
            return Integer.parseInt(String.valueOf(obj));
        } catch (Exception e) {
            return i;
        }
    }

    public boolean pr(String str, boolean z) {
        Map<String, Object> map = this.hw;
        Object obj = map != null ? map.get(str) : null;
        if (obj == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(String.valueOf(obj));
        } catch (Exception e) {
            return z;
        }
    }

    public JSONObject hw(String str) {
        Map<String, Object> map = this.hw;
        Object obj = map != null ? map.get(str) : null;
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
            try {
                return new JSONObject(String.valueOf(obj));
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public JSONArray hn(String str) {
        Map<String, Object> map = this.hw;
        Object obj = map != null ? map.get(str) : null;
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
            try {
                return new JSONArray(String.valueOf(obj));
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public <T> T pr(String str, Class<T> cls) {
        Map<String, Object> map = this.hw;
        T t = map != null ? (T) map.get(str) : null;
        if (t != null && cls.isInstance(t)) {
            return t;
        }
        return null;
    }

    private static Object pr(Object obj, JSONObject jSONObject) {
        if (obj instanceof JSONObject) {
            return obj;
        }
        return com.byazt.tn.hw.pr(Objects.toString(obj, ""), jSONObject);
    }
}
