package com.byazt.fxc;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1743, 18})
public class l {
    public int n;
    public Map<String, JSONObject> qg;

    public boolean n() {
        int i = this.n;
        return i > 20000 && i < 100000;
    }

    public static l n(JSONObject jSONObject) {
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
                    if (!TextUtils.isEmpty(n(strOptString, strOptString2))) {
                        map.put(n(strOptString, strOptString2), jSONObjectOptJSONObject);
                    }
                }
            }
        }
        l lVar = new l();
        lVar.qg = map;
        lVar.n = iOptInt;
        return lVar;
    }

    public static String n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2 + "_" + str;
    }
}
