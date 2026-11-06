package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1140})
public class dg {
    public int fs;
    public String l;
    public String n;
    public String q;
    public boolean qg;
    public qg rv;
    public boolean s;
    public n tj;
    public String w;
    public JSONArray x;

    public static dg n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        dg dgVar = new dg();
        dgVar.n = jSONObject.optString("promotion_id");
        dgVar.qg = jSONObject.optBoolean("is_silent_auth", false);
        dgVar.s = jSONObject.optBoolean("enable_playable_auth", false);
        dgVar.q = jSONObject.optString("aweme_agreements");
        dgVar.l = jSONObject.optString("aweme_privacy");
        dgVar.w = jSONObject.optString("live_csj_libra_param");
        dgVar.x = jSONObject.optJSONArray("tasks");
        dgVar.fs = jSONObject.optInt("live_playable");
        dgVar.tj = n.n(jSONObject.optJSONObject("product"));
        dgVar.rv = qg.n(jSONObject.optJSONObject("coupon"));
        return dgVar;
    }

    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promotion_id", this.n);
            jSONObject.put("is_silent_auth", this.qg);
            jSONObject.put("enable_playable_auth", this.s);
            jSONObject.put("aweme_agreements", this.q);
            jSONObject.put("aweme_privacy", this.l);
            jSONObject.put("live_csj_libra_param", this.w);
            jSONObject.put("tasks", this.x);
            jSONObject.put("live_playable", this.fs);
            n nVar = this.tj;
            if (nVar != null) {
                jSONObject.put("product", nVar.l());
            }
            qg qgVar = this.rv;
            if (qgVar != null) {
                jSONObject.put("coupon", qgVar.s());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String qg() {
        return this.n;
    }

    public boolean s() {
        return this.qg;
    }

    public boolean q() {
        return this.s;
    }

    public String l() {
        return this.q;
    }

    public String w() {
        return this.l;
    }

    public String x() {
        return this.w;
    }

    public JSONArray fs() {
        return this.x;
    }

    public boolean rv() {
        return this.fs == 2 && this.s;
    }

    public qg tj() {
        return this.rv;
    }

    public n cp() {
        return this.tj;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 2231})
    public static class qg {
        public int n;
        public int qg;

        public static qg n(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            qg qgVar = new qg();
            qgVar.n = jSONObject.optInt("amount");
            qgVar.qg = jSONObject.optInt("threshold");
            return qgVar;
        }

        public int n() {
            return this.n;
        }

        public int qg() {
            return this.qg;
        }

        public JSONObject s() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("amount", this.n);
                jSONObject.put("threshold", this.qg);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 2209})
    public static class n {
        public String n;
        public double q;
        public String qg;
        public double s;

        public static n n(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            n nVar = new n();
            nVar.n = jSONObject.optString("title");
            nVar.qg = jSONObject.optString("image");
            nVar.q = jSONObject.optDouble(com.anythink.core.d.b.e.a.h);
            nVar.s = jSONObject.optDouble("origin_price");
            return nVar;
        }

        public String n() {
            return this.n;
        }

        public String qg() {
            return this.qg;
        }

        public double s() {
            return this.s;
        }

        public double q() {
            return this.q;
        }

        public JSONObject l() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.n);
                jSONObject.put("image", this.qg);
                jSONObject.put(com.anythink.core.d.b.e.a.h, this.q);
                jSONObject.put("origin_price", this.s);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }
}
