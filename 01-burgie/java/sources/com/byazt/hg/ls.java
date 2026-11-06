package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 1121})
public class ls {
    public JSONObject pr;

    public String toString() {
        JSONObject jSONObject = this.pr;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String pr() {
        JSONObject jSONObject = this.pr;
        JSONObject jSONObjectOptJSONObject = jSONObject == null ? null : jSONObject.optJSONObject("performance_js");
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject.optString(BreakpointSQLiteKey.URL);
        }
        return "";
    }

    public static ls pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return pr(new JSONObject(str));
        } catch (JSONException e) {
            return null;
        }
    }

    public static ls pr(JSONObject jSONObject) {
        ls lsVar = new ls();
        lsVar.pr = jSONObject;
        return lsVar;
    }
}
