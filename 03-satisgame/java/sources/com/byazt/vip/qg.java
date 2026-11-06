package com.byazt.vip;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 783, 26})
public class qg {
    public static Object n(JSONObject jSONObject, String str) {
        return n(jSONObject, str, null);
    }

    public static Object n(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (jSONObject != null && str != null && !str.isEmpty()) {
            String[] strArrSplit = str.split("\\.");
            try {
                int length = strArrSplit.length;
                int i = 0;
                Object obj2 = jSONObject;
                while (i < length) {
                    String str2 = strArrSplit[i];
                    if (!(obj2 instanceof JSONObject)) {
                        return obj;
                    }
                    JSONObject jSONObject2 = (JSONObject) obj2;
                    if (!jSONObject2.has(str2)) {
                        return obj;
                    }
                    i++;
                    obj2 = jSONObject2.get(str2);
                }
                return obj2;
            } catch (Exception unused) {
            }
        }
        return obj;
    }
}
