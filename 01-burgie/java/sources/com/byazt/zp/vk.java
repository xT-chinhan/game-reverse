package com.byazt.zp;

import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1229, 50})
public class vk {
    public static JSONObject pr(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    jSONObject.put(jSONObjectOptJSONObject.optString(Common.System.NAME), jSONObjectOptJSONObject.opt(Constants.VALUE_FIELD));
                }
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
