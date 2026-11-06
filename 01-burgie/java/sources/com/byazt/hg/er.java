package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 1620})
public class er {
    public String c;
    public String hn;
    public String hw;
    public String pr;
    public long uc;
    public String x;

    public er() {
    }

    public er(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pr(jSONObject.optString("reward_live_deep_link_user_id"));
        c(jSONObject.optString("reward_live_deep_link_request_id"));
        hw(jSONObject.optString("reward_live_deep_link_room_id"));
        hn(jSONObject.optString("reawrd_live_short_touch_params"));
        x(jSONObject.optString("reawrd_live_extra_pangle_scheme_params"));
        pr(jSONObject.optLong("reward_live_last_time"));
    }

    public String pr() {
        return this.hw;
    }

    public void pr(String str) {
        this.hw = str;
    }

    public String hw() {
        return this.hn;
    }

    public void hw(String str) {
        this.hn = str;
    }

    public String hn() {
        return this.x;
    }

    public void hn(String str) {
        this.x = str;
    }

    public String x() {
        return this.c;
    }

    public void x(String str) {
        this.c = str;
    }

    public long c() {
        return this.uc;
    }

    public void pr(long j) {
        this.uc = j;
    }

    public String uc() {
        return this.pr;
    }

    public void c(String str) {
        this.pr = str;
    }
}
