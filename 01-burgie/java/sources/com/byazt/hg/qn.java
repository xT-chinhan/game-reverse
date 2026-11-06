package com.byazt.hg;

import com.byazt.mg.PluginConstants;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 467})
public class qn {
    public String hn;
    public int hw;
    public int pr;
    public String x;

    public static qn pr(String str) {
        try {
            return pr(new JSONObject(str));
        } catch (JSONException e) {
            return new qn();
        }
    }

    public static qn pr(JSONObject jSONObject) {
        qn qnVar = new qn();
        qnVar.pr(jSONObject.optInt("ad_live_status"));
        qnVar.hw(jSONObject.optInt(PluginConstants.KEY_APP_ID));
        qnVar.hw(jSONObject.optString("partner"));
        qnVar.hn(jSONObject.optString("secure_key"));
        return qnVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_live_status", pr());
            jSONObject.put(PluginConstants.KEY_APP_ID, hw());
            jSONObject.put("partner", hn());
            jSONObject.put("secure_key", x());
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public int pr() {
        return this.pr;
    }

    public int hw() {
        return this.hw;
    }

    public String hn() {
        return this.hn;
    }

    public String x() {
        return this.x;
    }

    public void pr(int i) {
        this.pr = i;
    }

    public void hw(int i) {
        this.hw = i;
    }

    public void hw(String str) {
        this.hn = str;
    }

    public void hn(String str) {
        this.x = str;
    }

    public boolean c() {
        return this.pr == 1;
    }
}
