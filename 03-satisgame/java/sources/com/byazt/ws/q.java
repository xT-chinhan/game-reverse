package com.byazt.ws;

import com.anythink.core.common.f.a;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 890, 5})
public class q {
    public int l;
    public double n;
    public String q;
    public double qg;
    public int s;
    public String w;
    public JSONObject x;

    private q(double d, double d2, int i, String str, int i2, String str2, JSONObject jSONObject) {
        this.n = d;
        this.qg = d2;
        this.s = i;
        this.q = str;
        this.l = i2;
        this.w = str2;
        this.x = jSONObject;
    }

    public static void n(JSONObject jSONObject, Map<String, q> map) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("prime_rits")) == null) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                try {
                    map.put(strOptString, new q(jSONObject.optDouble("upper", 0.0d), jSONObject.optDouble("lower", 0.0d), jSONObject.optInt("type"), strOptString, jSONObject.optInt("js_mode"), jSONObject.optString(a.C0017a.o), jSONObject.optJSONObject("refresh_time")));
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
            }
        }
    }

    public double n() {
        return this.n;
    }

    public double qg() {
        return this.qg;
    }

    public int getType() {
        return this.s;
    }

    public int s() {
        return this.l;
    }

    public String q() {
        return this.w;
    }

    public int n(String str) {
        JSONObject jSONObject = this.x;
        if (jSONObject != null) {
            return jSONObject.optInt(str);
        }
        return 0;
    }

    public boolean l() {
        return this.n <= 0.0d && this.qg <= 0.0d;
    }
}
