package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 322})
public class vj {
    public int hw;
    public boolean pr;

    public vj(JSONObject jSONObject) {
        this.pr = jSONObject.optBoolean("enable_reward_callback");
        this.hw = jSONObject.optInt("browse_duration_limit", 10);
    }

    public boolean pr() {
        return this.pr;
    }

    public int hw() {
        return this.hw;
    }

    public void pr(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("enable_reward_callback", pr());
            jSONObject2.put("browse_duration_limit", hw());
            jSONObject.put("self_reward_callback", jSONObject2);
        } catch (JSONException e) {
        }
    }
}
