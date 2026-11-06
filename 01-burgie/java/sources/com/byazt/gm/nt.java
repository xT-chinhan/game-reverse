package com.byazt.gm;

import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 74})
public class nt extends com.byazt.ee.c<JSONObject, JSONObject> {
    public static void pr(com.byazt.ee.yb ybVar) {
        ybVar.pr("getDownloadStatus", (com.byazt.ee.c<?, ?>) new nt());
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        return pr(jSONObject);
    }

    public static JSONObject pr(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            pr(jSONObject2, 1, "params is null", 1, 1);
            return jSONObject2;
        }
        try {
            String strOptString = jSONObject.optString("ad_down_load_id");
            if (TextUtils.isEmpty(strOptString)) {
                pr(jSONObject2, 1, "ad_down_load_id is null", 1, 1);
                return jSONObject2;
            }
            return com.byazt.dp.hw.pr.pr(strOptString);
        } catch (Throwable th) {
            return jSONObject2;
        }
    }

    private static void pr(JSONObject jSONObject, int i, String str, int i2, int i3) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
            jSONObject.put("codeMsg", str);
            jSONObject.put("downloadStatus", i2);
            jSONObject.put("downloadProcessRate", i3);
        } catch (Exception e) {
        }
    }
}
