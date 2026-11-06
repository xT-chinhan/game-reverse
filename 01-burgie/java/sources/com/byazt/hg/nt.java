package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 74})
public class nt {
    public double hn;
    public double hw;
    public double pr;
    public double x;

    public nt(double d, double d2, double d3, double d4) {
        this.pr = d;
        this.hw = d2;
        this.hn = d3;
        this.x = d4;
    }

    public boolean pr(double d, double d2) {
        double d3 = this.hn;
        if (d3 <= 0.0d) {
            return false;
        }
        double d4 = this.x;
        if (d4 <= 0.0d) {
            return false;
        }
        double d5 = this.pr;
        if (d <= d5 || d >= d5 + d3) {
            return false;
        }
        double d6 = this.hw;
        return d2 > d6 && d2 < d6 + d4;
    }

    public static nt pr(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("point");
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("size");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 2 && jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() == 2) {
                return new nt(jSONArrayOptJSONArray.optDouble(0), jSONArrayOptJSONArray.optDouble(1), jSONArrayOptJSONArray2.optInt(0), jSONArrayOptJSONArray2.optInt(1));
            }
            return null;
        }
        return null;
    }

    public static JSONObject pr(nt ntVar) {
        if (ntVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, ntVar.pr);
            jSONArray.put(1, ntVar.hw);
            jSONObject.put("point", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, ntVar.hn);
            jSONArray2.put(1, ntVar.x);
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static double pr(nt ntVar, nt ntVar2) {
        if (ntVar == null || ntVar2 == null) {
            return 0.0d;
        }
        double d = ntVar.pr;
        double d2 = ntVar.hw;
        double d3 = ntVar.hn + d;
        double d4 = ntVar.x + d2;
        double d5 = ntVar2.pr;
        double d6 = ntVar2.hw;
        double d7 = ntVar2.hn + d5;
        double d8 = ntVar2.x + d6;
        double dMax = Math.max(d, d5);
        double dMax2 = Math.max(d2, d6);
        double dMin = (Math.min(d3, d7) - dMax) * (Math.min(d4, d8) - dMax2);
        if (d2 >= d8 || d3 <= d5 || d4 <= d6 || d >= d7) {
            return 0.0d;
        }
        return dMin;
    }

    public static nt hw(nt ntVar, nt ntVar2) {
        if (ntVar == null) {
            return ntVar2;
        }
        if (ntVar2 == null) {
            return null;
        }
        double d = ntVar.pr;
        double d2 = ntVar.hw;
        double d3 = ntVar.hn + d;
        double d4 = ntVar.x + d2;
        double d5 = ntVar2.pr;
        double d6 = ntVar2.hw;
        double d7 = ntVar2.hn + d5;
        double d8 = ntVar2.x + d6;
        double dMin = Math.min(d, d5);
        double dMin2 = Math.min(d2, d6);
        return new nt(dMin, dMin2, Math.abs(Math.max(d3, d7) - dMin), Math.abs(Math.max(d4, d8) - dMin2));
    }
}
