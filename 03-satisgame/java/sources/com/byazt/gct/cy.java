package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy {
    public double n;
    public double q;
    public double qg;
    public double s;

    public cy(double d, double d2, double d3, double d4) {
        this.n = d;
        this.qg = d2;
        this.s = d3;
        this.q = d4;
    }

    public boolean n(double d, double d2) {
        double d3 = this.s;
        if (d3 <= 0.0d) {
            return false;
        }
        double d4 = this.q;
        if (d4 <= 0.0d) {
            return false;
        }
        double d5 = this.n;
        if (d <= d5 || d >= d5 + d3) {
            return false;
        }
        double d6 = this.qg;
        return d2 > d6 && d2 < d6 + d4;
    }

    public static cy n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("point");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("size");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() != 2 || jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() != 2) {
            return null;
        }
        return new cy(jSONArrayOptJSONArray.optDouble(0), jSONArrayOptJSONArray.optDouble(1), jSONArrayOptJSONArray2.optInt(0), jSONArrayOptJSONArray2.optInt(1));
    }

    public static JSONObject n(cy cyVar) {
        if (cyVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, cyVar.n);
            jSONArray.put(1, cyVar.qg);
            jSONObject.put("point", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, cyVar.s);
            jSONArray2.put(1, cyVar.q);
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static double n(cy cyVar, cy cyVar2) {
        if (cyVar == null || cyVar2 == null) {
            return 0.0d;
        }
        double d = cyVar.n;
        double d2 = cyVar.qg;
        double d3 = cyVar.s + d;
        double d4 = cyVar.q + d2;
        double d5 = cyVar2.n;
        double d6 = cyVar2.qg;
        double d7 = cyVar2.s + d5;
        double d8 = cyVar2.q + d6;
        double dMax = Math.max(d, d5);
        double dMax2 = Math.max(d2, d6);
        double dMin = (Math.min(d3, d7) - dMax) * (Math.min(d4, d8) - dMax2);
        if (d2 >= d8 || d3 <= d5 || d4 <= d6 || d >= d7) {
            return 0.0d;
        }
        return dMin;
    }

    public static cy qg(cy cyVar, cy cyVar2) {
        if (cyVar == null) {
            return cyVar2;
        }
        if (cyVar2 == null) {
            return null;
        }
        double d = cyVar.n;
        double d2 = cyVar.qg;
        double d3 = cyVar.s + d;
        double d4 = cyVar.q + d2;
        double d5 = cyVar2.n;
        double d6 = cyVar2.qg;
        double d7 = cyVar2.s + d5;
        double d8 = cyVar2.q + d6;
        double dMin = Math.min(d, d5);
        double dMin2 = Math.min(d2, d6);
        return new cy(dMin, dMin2, Math.abs(Math.max(d3, d7) - dMin), Math.abs(Math.max(d4, d8) - dMin2));
    }
}
