package com.bytedance.sdk.openadsdk.core.nw;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ao {
    public double ah;
    public double d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public double f3032ms;
    public double xr;

    public ao(double d, double d2, double d3, double d4) {
        this.f3032ms = d;
        this.xr = d2;
        this.ah = d3;
        this.d = d4;
    }

    public boolean ms(double d, double d2) {
        double d3 = this.ah;
        if (d3 <= 0.0d) {
            return false;
        }
        double d4 = this.d;
        if (d4 <= 0.0d) {
            return false;
        }
        double d5 = this.f3032ms;
        if (d <= d5 || d >= d5 + d3) {
            return false;
        }
        double d6 = this.xr;
        return d2 > d6 && d2 < d6 + d4;
    }

    public static ao ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("point");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("size");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() != 2 || jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() != 2) {
            return null;
        }
        return new ao(jSONArrayOptJSONArray.optDouble(0), jSONArrayOptJSONArray.optDouble(1), jSONArrayOptJSONArray2.optInt(0), jSONArrayOptJSONArray2.optInt(1));
    }

    public static JSONObject ms(ao aoVar) {
        if (aoVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, aoVar.f3032ms);
            jSONArray.put(1, aoVar.xr);
            jSONObject.put("point", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, aoVar.ah);
            jSONArray2.put(1, aoVar.d);
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms("xeasy", "json:" + e.getMessage());
            return null;
        }
    }

    public static double ms(ao aoVar, ao aoVar2) {
        if (aoVar == null || aoVar2 == null) {
            return 0.0d;
        }
        double d = aoVar.f3032ms;
        double d2 = aoVar.xr;
        double d3 = aoVar.ah + d;
        double d4 = aoVar.d + d2;
        double d5 = aoVar2.f3032ms;
        double d6 = aoVar2.xr;
        double d7 = aoVar2.ah + d5;
        double d8 = aoVar2.d + d6;
        double dMax = Math.max(d, d5);
        double dMax2 = Math.max(d2, d6);
        double dMin = (Math.min(d3, d7) - dMax) * (Math.min(d4, d8) - dMax2);
        if (d2 >= d8 || d3 <= d5 || d4 <= d6 || d >= d7) {
            return 0.0d;
        }
        return dMin;
    }

    public static ao xr(ao aoVar, ao aoVar2) {
        if (aoVar == null) {
            return aoVar2;
        }
        if (aoVar2 == null) {
            return null;
        }
        double d = aoVar.f3032ms;
        double d2 = aoVar.xr;
        double d3 = aoVar.ah + d;
        double d4 = aoVar.d + d2;
        double d5 = aoVar2.f3032ms;
        double d6 = aoVar2.xr;
        double d7 = aoVar2.ah + d5;
        double d8 = aoVar2.d + d6;
        double dMin = Math.min(d, d5);
        double dMin2 = Math.min(d2, d6);
        return new ao(dMin, dMin2, Math.abs(Math.max(d3, d7) - dMin), Math.abs(Math.max(d4, d8) - dMin2));
    }
}
