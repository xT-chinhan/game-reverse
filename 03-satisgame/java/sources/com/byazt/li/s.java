package com.byazt.li;

import android.text.TextUtils;
import com.byazt.vh.cy;
import com.byazt.xz.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2442, 8})
public final class s {
    public final String n;
    public final Map<String, Object> qg;

    private s(String str, Map<String, Object> map) {
        this.n = str;
        this.qg = map;
    }

    public static s n(cy cyVar, JSONObject jSONObject, Map<String, Object> map) {
        String strN;
        JSONObject jSONObjectS = cyVar != null ? cyVar.s() : null;
        HashMap map2 = new HashMap();
        if (jSONObjectS != null) {
            strN = com.byazt.mcb.qg.n(jSONObjectS.optString("type"), jSONObject);
            JSONObject jSONObjectOptJSONObject = jSONObjectS.optJSONObject("params");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map2.put(next, n(jSONObjectOptJSONObject.opt(next), jSONObject));
                }
            }
        } else {
            strN = "";
        }
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        return new s(strN, map2);
    }

    public static s n(x.n nVar, JSONObject jSONObject, Map<String, Object> map) {
        String strN = com.byazt.mcb.qg.n(nVar != null ? nVar.qg() : "", jSONObject);
        HashMap map2 = new HashMap();
        if (nVar != null && nVar.s() != null) {
            for (Map.Entry<String, Object> entry : nVar.s().entrySet()) {
                map2.put(entry.getKey(), n(entry.getValue(), jSONObject));
            }
        }
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        return new s(strN, map2);
    }

    public String n() {
        return this.n;
    }

    public Map<String, Object> qg() {
        return this.qg;
    }

    public String n(String str) {
        Map<String, Object> map = this.qg;
        Object obj = map != null ? map.get(str) : null;
        return obj == null ? "" : String.valueOf(obj);
    }

    public int n(String str, int i) {
        Map<String, Object> map = this.qg;
        Object obj = map != null ? map.get(str) : null;
        if (obj == null) {
            return i;
        }
        try {
            return Integer.parseInt(String.valueOf(obj));
        } catch (Exception unused) {
            return i;
        }
    }

    public boolean n(String str, boolean z) {
        Map<String, Object> map = this.qg;
        Object obj = map != null ? map.get(str) : null;
        if (obj == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(String.valueOf(obj));
        } catch (Exception unused) {
            return z;
        }
    }

    public JSONObject qg(String str) {
        Map<String, Object> map = this.qg;
        Object obj = map != null ? map.get(str) : null;
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
            try {
                return new JSONObject(String.valueOf(obj));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public JSONArray s(String str) {
        Map<String, Object> map = this.qg;
        Object obj = map != null ? map.get(str) : null;
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
            try {
                return new JSONArray(String.valueOf(obj));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public <T> T n(String str, Class<T> cls) {
        Map<String, Object> map = this.qg;
        T t = map != null ? (T) map.get(str) : null;
        if (t != null && cls.isInstance(t)) {
            return t;
        }
        return null;
    }

    private static Object n(Object obj, JSONObject jSONObject) {
        return obj instanceof JSONObject ? obj : com.byazt.mcb.qg.n(Objects.toString(obj, ""), jSONObject);
    }
}
