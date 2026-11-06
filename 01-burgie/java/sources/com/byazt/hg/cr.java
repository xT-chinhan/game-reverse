package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 1991})
public class cr {
    public JSONObject c;
    public String fw;
    public String hn;
    public String hw;
    public String pr;
    public int uc;
    public String x;
    public String zo;

    public String pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    public String hn() {
        return this.hn;
    }

    public String x() {
        return this.x;
    }

    public JSONObject c() {
        return this.c;
    }

    public String uc() {
        return this.fw;
    }

    public int fw() {
        return this.uc;
    }

    public String zo() {
        return this.zo;
    }

    public static cr pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        cr crVar = new cr();
        crVar.pr = jSONObject.optString("id");
        crVar.x = jSONObject.optString("data");
        crVar.hn = jSONObject.optString(BreakpointSQLiteKey.URL);
        crVar.hw = jSONObject.optString("md5");
        crVar.fw = jSONObject.optString("express_gesture_priority");
        crVar.uc = jSONObject.optInt("material_type");
        crVar.c = jSONObject.optJSONObject("custom_components");
        crVar.zo = jSONObject.optString("rule_id");
        return crVar;
    }

    public JSONObject aj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.pr);
            jSONObject.put("md5", this.hw);
            jSONObject.put(BreakpointSQLiteKey.URL, this.hn);
            jSONObject.put("data", this.x);
            jSONObject.put("material_type", this.uc);
            jSONObject.put("custom_components", this.c);
            jSONObject.put("express_gesture_priority", this.fw);
            jSONObject.put("rule_id", this.zo);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
