package com.byazt.fm;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1624, 8})
public class s {
    public n l;
    public String n;
    public final Map<String, n> q = new HashMap();
    public String qg;
    public boolean s;
    public JSONObject w;

    public s(JSONObject jSONObject) {
        this.s = false;
        String next = jSONObject.keys().next();
        this.qg = next;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
        this.n = jSONObjectOptJSONObject.optString("version");
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("lazyLoad");
        this.s = zOptBoolean;
        if (!zOptBoolean) {
            n(jSONObjectOptJSONObject);
        } else {
            this.w = jSONObjectOptJSONObject;
        }
    }

    private void n(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("events");
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            n nVar = new n(jSONArrayOptJSONArray.optJSONObject(i));
            this.q.put(nVar.n(), nVar);
            if (nVar.n().equals(jSONObject.optString("main"))) {
                this.l = nVar;
            }
        }
    }

    public n n(String str) {
        if (this.s) {
            n(this.w);
        }
        return this.q.get(str);
    }

    public Map<String, n> n() {
        return this.q;
    }

    public n qg() {
        if (this.s) {
            n(this.w);
        }
        return this.l;
    }

    public String s() {
        return this.qg;
    }

    public List<n> n(n nVar, JSONObject jSONObject, Map<String, Object> map) {
        return n(jSONObject, map, nVar.fs());
    }

    public List<n> qg(n nVar, JSONObject jSONObject, Map<String, Object> map) {
        return n(jSONObject, map, nVar.rv());
    }

    private List<n> n(JSONObject jSONObject, Map<String, Object> map, List<n.C0176n> list) {
        n nVarN;
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (n.C0176n c0176n : list) {
            if (c0176n != null && (nVarN = n(c0176n.n())) != null && n(c0176n.qg(), jSONObject, map)) {
                arrayList.add(nVarN);
            }
        }
        return arrayList;
    }

    public static boolean n(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return true;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    jSONObject.put(key, entry.getValue());
                }
            }
            if (str.startsWith("${") && str.endsWith("}")) {
                return Boolean.parseBoolean(com.byazt.sz.n.n(str.substring(2, str.length() - 1)).n(jSONObject).toString());
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public List<n> s(n nVar, JSONObject jSONObject, Map<String, Object> map) {
        List<n.C0176n> listX = nVar.x();
        ArrayList arrayList = new ArrayList();
        for (n.C0176n c0176n : listX) {
            if (c0176n != null && n(c0176n.qg(), jSONObject, map)) {
                arrayList.add(n(c0176n.n()));
            }
        }
        return arrayList;
    }
}
