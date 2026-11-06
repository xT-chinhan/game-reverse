package com.byazt.ib;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1213, 13})
public final class hw {
    public final long aj;
    public final long c;
    public final long fw;
    public final long hn;
    public final long hw;
    public final long pr;
    public final long uc;
    public final com.byazt.sf.hn vk;
    public final int x;
    public final long zo;

    public hw(long j, long j2, long j3, int i, long j4, long j5, long j6, long j7, long j8, com.byazt.sf.hn hnVar) {
        this.pr = j;
        this.hw = j2;
        this.hn = j3;
        this.x = i;
        this.c = j4;
        this.uc = j5;
        this.fw = j6;
        this.zo = j7;
        this.aj = j8;
        this.vk = hnVar == null ? com.byazt.sf.hn.pr : hnVar;
    }

    public JSONObject pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("used_kb", this.pr);
            jSONObject.put("java_used_kb", this.hw);
            jSONObject.put("limit_kb", this.hn);
            jSONObject.put("ratio", this.x);
            jSONObject.put("native_kb", this.c);
            jSONObject.put("delta_used_kb", this.uc);
            jSONObject.put("delta_java_kb", this.fw);
            jSONObject.put("delta_native_kb", this.zo);
            jSONObject.put("ts", this.aj);
            jSONObject.put("res", this.vk.uc());
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public JSONObject pr(String str) {
        JSONObject jSONObjectPr = pr();
        try {
            jSONObjectPr.put("stage", str);
        } catch (JSONException e) {
        }
        return jSONObjectPr;
    }

    public JSONObject hw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("used_kb", this.pr);
            jSONObject.put("java_used_kb", this.hw);
            jSONObject.put("limit_kb", this.hn);
            jSONObject.put("ratio", this.x);
            jSONObject.put("native_kb", this.c);
            jSONObject.put("ts", this.aj);
            jSONObject.put("res", pr(this.vk));
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    private static JSONObject pr(com.byazt.sf.hn hnVar) {
        JSONObject jSONObject = new JSONObject();
        if (hnVar == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("webview_count", hnVar.pr());
            jSONObject.put("player_count", hnVar.hw());
            jSONObject.put("native_ad_count", hnVar.hn());
            jSONObject.put("oom_count", hnVar.x());
            jSONObject.put("thread_count", hnVar.c());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
