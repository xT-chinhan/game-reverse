package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 2174})
public class lv {
    public int c;
    public long hn;
    public int hw;
    public int pr;
    public int x;

    public static lv pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        lv lvVar = new lv();
        lvVar.pr = jSONObject.optInt("auth_type");
        lvVar.hw = jSONObject.optInt("auth_time");
        lvVar.hn = jSONObject.optLong("auth_out_time");
        lvVar.x = jSONObject.optInt("video_open_deeplink");
        lvVar.c = jSONObject.optInt("reject_in");
        return lvVar;
    }

    public JSONObject pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("auth_type", this.pr);
            jSONObject.put("auth_time", this.hw);
            jSONObject.put("auth_out_time", this.hn);
            jSONObject.put("video_open_deeplink", this.x);
            jSONObject.put("reject_in", this.c);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public int hw() {
        return this.pr;
    }

    public int hn() {
        return this.hw;
    }

    public int x() {
        return this.x;
    }

    public long c() {
        return this.hn;
    }

    public int uc() {
        return this.c;
    }
}
