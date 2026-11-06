package com.byazt.ws;

import android.text.TextUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 890, 8})
public class s {
    public String l;
    public String n;
    public int q;
    public String qg;
    public String s;
    public double w;
    public double x;

    public s(String str, String str2, String str3, int i, String str4, double d, double d2) {
        this.n = str;
        this.qg = str2;
        this.s = str3;
        this.q = i;
        this.l = str4;
        this.w = d;
        this.x = d2;
    }

    public String n() {
        return this.qg;
    }

    public String qg() {
        return this.s;
    }

    public int s() {
        return this.q;
    }

    public String q() {
        return this.l;
    }

    public double l() {
        return this.w;
    }

    public double w() {
        return this.x;
    }

    public static s n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return null;
        }
        return new s(str, jSONObject.optString("label_name"), jSONObject.optString(TapEventParamConstants.PARAM_SUB_TIMESTAMP), jSONObject.optInt("label_id"), jSONObject.optString("label_version"), jSONObject.optDouble("upper_bound"), jSONObject.optDouble("lower_bound"));
    }
}
