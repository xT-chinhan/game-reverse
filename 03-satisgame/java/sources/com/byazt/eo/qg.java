package com.byazt.eo;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1827, 26})
public class qg {
    public int n;
    public boolean q;
    public int qg;
    public int s;

    public int n() {
        return this.n;
    }

    public void n(int i) {
        this.n = i;
    }

    public int qg() {
        return this.qg;
    }

    public void qg(int i) {
        this.qg = i;
    }

    public int s() {
        return this.s;
    }

    public void s(int i) {
        this.s = i;
    }

    public static qg n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return n(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static qg n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        qg qgVar = new qg();
        qgVar.qg(jSONObject.optInt("expire_days"));
        qgVar.n(jSONObject.optInt("log_level"));
        qgVar.s(jSONObject.optInt("max_size"));
        qgVar.n(jSONObject.optBoolean("is_open"));
        return qgVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("expire_days", qg());
            jSONObject.put("log_level", n());
            jSONObject.put("max_size", s());
            jSONObject.put("is_open", q());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public boolean q() {
        return this.q;
    }

    public void n(boolean z) {
        this.q = z;
    }
}
