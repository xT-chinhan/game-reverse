package com.byazt.tl;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 905, 13})
public class hw {
    public static Object pr(JSONObject jSONObject, String str) {
        return pr(jSONObject, str, null);
    }

    public static Object pr(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (jSONObject == null || str == null || str.isEmpty()) {
            return obj;
        }
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
                if (jSONObject2.has(str2)) {
                    i++;
                    obj2 = jSONObject2.get(str2);
                } else {
                    return obj;
                }
            }
            return obj2;
        } catch (Exception e) {
            return obj;
        }
    }
}
