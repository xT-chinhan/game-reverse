package com.byazt.qa;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 944, 19})
public class n {
    public int l;
    public int n;
    public String q;
    public int qg;
    public String s;
    public int w;
    public int x;

    public String n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediationConstant.KEY_REASON, this.n);
            jSONObject.put("fill_error_code", this.qg);
            jSONObject.put("fill_error_msg", this.s);
            jSONObject.put("mediation_rit", this.q);
            jSONObject.put("load_sort", this.l);
            jSONObject.put("show_sort", this.w);
            jSONObject.put("has_shown", this.x);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "{\"name\": \"json err\"}";
        }
    }

    public void n(int i) {
        this.x = i;
    }

    public void qg(int i) {
        this.n = i;
    }

    public void s(int i) {
        this.qg = i;
    }

    public void n(String str) {
        this.s = str;
    }

    public void qg(String str) {
        this.q = str;
    }

    public void q(int i) {
        this.l = i;
    }

    public void l(int i) {
        this.w = i;
    }
}
