package com.byazt.eq;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 672, 26})
public class qg {
    public String l;
    public String n;
    public String q;
    public String qg;
    public String s;
    public String w;

    public qg(String str, String str2, String str3, String str4) {
        this.n = str3;
        this.qg = str2;
        this.q = str;
        this.s = str4;
    }

    public void n(String str, String str2, String str3, String str4) {
        this.n = str3;
        this.qg = str2;
        this.q = str;
        this.s = str4;
    }

    public String n() {
        return this.qg;
    }

    public String qg() {
        return this.n;
    }

    public String toString() {
        JSONObject jSONObjectS = s();
        return jSONObjectS.length() > 0 ? jSONObjectS.toString() : "";
    }

    public JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tk", this.n).put("vd", this.q).put("cr", this.s).put(NotificationCompat.CATEGORY_ERROR, this.qg);
            if (!TextUtils.isEmpty(this.s) && this.s.equals("2")) {
                if (!TextUtils.isEmpty(this.l)) {
                    jSONObject.put("i6", this.l);
                }
                if (!TextUtils.isEmpty(this.w)) {
                    jSONObject.put("prov", this.w);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void n(String str) {
        this.l = str;
    }

    public void qg(String str) {
        this.w = str;
    }
}
