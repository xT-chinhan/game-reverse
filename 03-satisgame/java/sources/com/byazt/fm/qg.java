package com.byazt.fm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public enum qg {
    INSTANCE;

    public Map<String, s> qg = new HashMap();

    qg() {
    }

    public s n(String str) {
        return this.qg.get(str);
    }

    public void n(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String next = itKeys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
                s sVar = new s(jSONObject2);
                this.qg.put(sVar.s(), sVar);
            } catch (JSONException unused) {
            }
        }
    }
}
