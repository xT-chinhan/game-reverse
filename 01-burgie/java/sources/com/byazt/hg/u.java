package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 1259})
public class u {
    public int c;
    public String fw;
    public String hn;
    public int hw;
    public String pr;
    public int uc;
    public String x;
    public String zo;

    public String pr() {
        return this.pr;
    }

    public int hw() {
        return this.hw;
    }

    public void pr(String str) {
        this.pr = str;
    }

    public void pr(int i) {
        this.hw = i;
    }

    public String hn() {
        return this.hn;
    }

    public void hw(String str) {
        this.hn = str;
    }

    public String x() {
        return this.x;
    }

    public void hn(String str) {
        this.x = str;
    }

    public int c() {
        return this.c;
    }

    public void hw(int i) {
        this.c = i;
    }

    public int uc() {
        return this.uc;
    }

    public void hn(int i) {
        this.uc = i;
    }

    public String fw() {
        return this.fw;
    }

    public void x(String str) {
        this.fw = str;
    }

    public String zo() {
        return this.zo;
    }

    public void c(String str) {
        this.zo = str;
    }

    public String toString() {
        return aj().toString();
    }

    public JSONObject aj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wc_skip_type", hw());
            jSONObject.put("wc_miniapp_link", pr());
            jSONObject.put("adv_id", hn());
            jSONObject.put("site_id", x());
            jSONObject.put("wc_open_method", uc());
            jSONObject.put("wc_miniapp_sdk", fw());
            jSONObject.put("wc_appid", zo());
        } catch (Throwable th) {
            th.getMessage();
        }
        return jSONObject;
    }

    public static u pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        u uVar = new u();
        try {
            uVar.pr(jSONObject.optInt("wc_skip_type"));
            uVar.pr(jSONObject.optString("wc_miniapp_link"));
            uVar.hw(jSONObject.optString("adv_id"));
            uVar.hn(jSONObject.optString("site_id"));
            uVar.hn(jSONObject.optInt("wc_open_method"));
            uVar.x(jSONObject.optString("wc_miniapp_sdk"));
            uVar.c(jSONObject.optString("wc_appid"));
        } catch (Throwable th) {
            th.getMessage();
        }
        return uVar;
    }
}
