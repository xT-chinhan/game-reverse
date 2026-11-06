package com.bytedance.sdk.openadsdk.core.ka.xr;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public int f2820ms;
    public Map<String, JSONObject> xr;

    public boolean ms() {
        int i = this.f2820ms;
        return i > 20000 && i < 100000;
    }

    public static ka ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("code");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("result");
        HashMap map = new HashMap();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("id", "");
                    String strOptString2 = jSONObjectOptJSONObject.optString("req_id", "");
                    if (!TextUtils.isEmpty(ms(strOptString, strOptString2))) {
                        map.put(ms(strOptString, strOptString2), jSONObjectOptJSONObject);
                    }
                }
            }
        }
        ka kaVar = new ka();
        kaVar.xr = map;
        kaVar.f2820ms = iOptInt;
        return kaVar;
    }

    public static String ms(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2 + "_" + str;
    }
}
