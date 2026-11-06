package com.byazt.uj;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, 19})
public class n implements hd {
    @Override // com.byazt.uj.hd
    public Object n(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length != 2) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArrayN = n(objArr[0]);
            if (jSONArrayN == null) {
                return jSONArray;
            }
            int i = Integer.parseInt(String.valueOf(objArr[1]));
            for (int i2 = 0; i2 < jSONArrayN.length(); i2 += i) {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = i2 + i3;
                    if (i4 >= jSONArrayN.length()) {
                        break;
                    }
                    jSONArray2.put(jSONArrayN.opt(i4));
                }
                jSONObject2.put("$chunk", jSONArray2);
                jSONArray.put(jSONObject2);
            }
        } catch (Throwable unused) {
        }
        return jSONArray;
    }

    private JSONArray n(Object obj) {
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        if (obj != null && obj.getClass().isArray()) {
            JSONArray jSONArray = new JSONArray();
            for (Object obj2 : (Object[]) obj) {
                jSONArray.put(obj2);
            }
            return jSONArray;
        }
        try {
            return new JSONArray(String.valueOf(obj));
        } catch (JSONException unused) {
            return null;
        }
    }
}
