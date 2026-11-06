package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd {
    public static volatile String n;
    public String fs;
    public JSONObject l;
    public int q;
    public String qg;
    public boolean rv;
    public String s;
    public int w;
    public String x;

    public static void n(String str) {
        n = str;
    }

    public hd() {
        this.x = "";
        this.fs = "";
    }

    public hd(JSONObject jSONObject) {
        this.x = "";
        this.fs = "";
        if (jSONObject == null) {
            return;
        }
        qg(jSONObject.optString("deeplink_url"));
        s(jSONObject.optString("fallback_url"));
        n(jSONObject.optInt("fallback_type"));
        this.l = jSONObject.optJSONObject("addon_params");
        this.w = jSONObject.optInt("fallback_landing");
        this.x = jSONObject.optString("fallback_landing_ugen_url");
        this.fs = jSONObject.optString("fallback_landing_ugen_md5");
    }

    public void n(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("deeplink_url", qg());
            jSONObject2.put("fallback_url", q());
            jSONObject2.put("fallback_type", l());
            jSONObject2.put("addon_params", this.l);
            jSONObject2.put("fallback_landing", this.w);
            jSONObject2.put("fallback_landing_ugen_url", this.x);
            jSONObject2.put("fallback_landing_ugen_md5", this.fs);
            jSONObject.put("deep_link", jSONObject2);
        } catch (JSONException unused) {
        }
    }

    public boolean n() {
        return this.rv;
    }

    public void n(boolean z) {
        this.rv = z;
    }

    public String qg() {
        return q(n);
    }

    public int s() {
        return this.w;
    }

    private String q(String str) {
        if (this.l != null && !TextUtils.isEmpty(str) && this.qg != null) {
            String strOptString = this.l.optString(str);
            if (!TextUtils.isEmpty(strOptString)) {
                return this.qg + (this.qg.contains("?") ? "&" : "?") + strOptString;
            }
        }
        return this.qg;
    }

    public void qg(String str) {
        this.qg = str;
    }

    public String q() {
        return this.s;
    }

    public void s(String str) {
        this.s = str;
    }

    public int l() {
        return this.q;
    }

    public void n(int i) {
        this.q = i;
    }

    public String w() {
        return this.x;
    }

    public String x() {
        return this.fs;
    }

    public void n(hd hdVar) {
        if (hdVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(hdVar.qg())) {
            qg(hdVar.qg());
        }
        if (!TextUtils.isEmpty(hdVar.q())) {
            s(hdVar.q());
        }
        if (hdVar.l() != 0) {
            n(hdVar.l());
        }
    }
}
