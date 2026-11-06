package com.bytedance.sdk.component.hi.ah;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public enum xr {
    INSTANCE;

    private Map<String, ah> xr = new HashMap();

    xr() {
    }

    public ah ms(String str) {
        return this.xr.get(str);
    }

    public void ms(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String next = itKeys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
                ah ahVar = new ah(jSONObject2);
                this.xr.put(ahVar.xr(), ahVar);
            } catch (JSONException unused) {
            }
        }
    }
}
