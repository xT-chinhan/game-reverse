package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 115})
public class pj {
    public boolean c;
    public String hn;
    public int hw;
    public JSONObject pr;
    public String x;

    public pj(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.pr = jSONObject;
            this.hw = jSONObject.optInt("dialog_type");
            this.hn = jSONObject.optString("template_url");
            this.x = jSONObject.optString("template_md5");
        }
        com.byazt.qk.pr prVar = new com.byazt.qk.pr();
        prVar.hw(c());
        prVar.hn(x());
    }

    public JSONObject pr() {
        return this.pr;
    }

    public JSONObject hw() {
        return this.pr;
    }

    public int hn() {
        return this.hw;
    }

    public String x() {
        return this.hn;
    }

    public String c() {
        return this.x;
    }

    public boolean uc() {
        return this.c;
    }

    public void pr(boolean z) {
        this.c = z;
    }
}
