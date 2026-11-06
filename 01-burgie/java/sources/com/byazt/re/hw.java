package com.byazt.re;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public enum hw {
    INSTANCE;

    public Map<String, hn> hw = new HashMap();

    hw() {
    }

    public hn pr(String str) {
        return this.hw.get(str);
    }

    public void pr(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String next = itKeys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
                hn hnVar = new hn(jSONObject2);
                this.hw.put(hnVar.hn(), hnVar);
            } catch (JSONException e) {
            }
        }
    }
}
