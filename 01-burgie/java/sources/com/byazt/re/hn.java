package com.byazt.re;

import android.text.TextUtils;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1999, 20})
public class hn {
    public pr c;
    public boolean hn;
    public String hw;
    public String pr;
    public JSONObject uc;
    public final Map<String, pr> x = new HashMap();

    public hn(JSONObject jSONObject) {
        this.hn = false;
        String next = jSONObject.keys().next();
        this.hw = next;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
        this.pr = jSONObjectOptJSONObject.optString("version");
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("lazyLoad");
        this.hn = zOptBoolean;
        if (!zOptBoolean) {
            pr(jSONObjectOptJSONObject);
        } else {
            this.uc = jSONObjectOptJSONObject;
        }
    }

    private void pr(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(d.ar);
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            pr prVar = new pr(jSONArrayOptJSONArray.optJSONObject(i));
            this.x.put(prVar.pr(), prVar);
            if (prVar.pr().equals(jSONObject.optString("main"))) {
                this.c = prVar;
            }
        }
    }

    public pr pr(String str) {
        if (this.hn) {
            pr(this.uc);
        }
        return this.x.get(str);
    }

    public Map<String, pr> pr() {
        return this.x;
    }

    public pr hw() {
        if (this.hn) {
            pr(this.uc);
        }
        return this.c;
    }

    public String hn() {
        return this.hw;
    }

    public List<pr> pr(pr prVar, JSONObject jSONObject, Map<String, Object> map) {
        return pr(jSONObject, map, prVar.zo());
    }

    public List<pr> hw(pr prVar, JSONObject jSONObject, Map<String, Object> map) {
        return pr(jSONObject, map, prVar.aj());
    }

    private List<pr> pr(JSONObject jSONObject, Map<String, Object> map, List<pr.C0175pr> list) {
        pr prVarPr;
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (pr.C0175pr c0175pr : list) {
            if (c0175pr != null && (prVarPr = pr(c0175pr.pr())) != null && pr(c0175pr.hw(), jSONObject, map)) {
                arrayList.add(prVarPr);
            }
        }
        return arrayList;
    }

    public static boolean pr(String str, JSONObject jSONObject, Map<String, Object> map) {
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
            if (!str.startsWith("${") || !str.endsWith("}")) {
                return false;
            }
            return Boolean.parseBoolean(com.byazt.oze.pr.pr(str.substring(2, str.length() - 1)).pr(jSONObject).toString());
        } catch (Throwable th) {
            return false;
        }
    }

    public List<pr> hn(pr prVar, JSONObject jSONObject, Map<String, Object> map) {
        List<pr.C0175pr> listFw = prVar.fw();
        ArrayList arrayList = new ArrayList();
        for (pr.C0175pr c0175pr : listFw) {
            if (c0175pr != null && pr(c0175pr.hw(), jSONObject, map)) {
                arrayList.add(pr(c0175pr.pr()));
            }
        }
        return arrayList;
    }
}
