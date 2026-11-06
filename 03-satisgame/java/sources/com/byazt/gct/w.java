package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 13})
public class w {
    public String cp;
    public float d;
    public String fs;
    public String l;
    public String n;
    public JSONArray oa;
    public String q;
    public String qg;
    public JSONArray rv;
    public String s;
    public HashMap<String, String> sz = new HashMap<>();
    public String tj;
    public String w;
    public String x;

    public w() {
    }

    public w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        q(jSONObject.optString("developer_name"));
        qg(jSONObject.optString("app_version"));
        qg(jSONObject.optJSONArray("permissions"));
        l(jSONObject.optString("privacy_policy_url"));
        rv(jSONObject.optString("package_name"));
        tj(jSONObject.optString("app_name"));
        n((float) jSONObject.optDouble("score", 0.0d));
        n(jSONObject.optJSONArray("creative_tags"));
        n(jSONObject.optString("permissions_url"));
        w(jSONObject.optString("desc_url"));
        x(jSONObject.optString("reg_number"));
        fs(jSONObject.optString("reg_url"));
    }

    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.sz.put(str, str2);
    }

    public HashMap<String, String> n() {
        return this.sz;
    }

    public String qg() {
        return this.l;
    }

    public void n(String str) {
        this.l = str;
    }

    public float s() {
        return this.d;
    }

    public void n(float f) {
        this.d = f;
    }

    public JSONArray q() {
        return this.oa;
    }

    public void n(JSONArray jSONArray) {
        this.oa = jSONArray;
    }

    public String l() {
        return this.n;
    }

    public void qg(String str) {
        this.n = str;
    }

    public String w() {
        return this.qg;
    }

    public void s(String str) {
        this.qg = str;
    }

    public String x() {
        return this.s;
    }

    public void q(String str) {
        this.s = str;
    }

    public String fs() {
        return this.q;
    }

    public void l(String str) {
        this.q = str;
    }

    public String rv() {
        return this.w;
    }

    public void w(String str) {
        this.w = str;
    }

    public String tj() {
        return this.x;
    }

    public void x(String str) {
        this.x = str;
    }

    public String cp() {
        return this.fs;
    }

    public void fs(String str) {
        this.fs = str;
    }

    public JSONArray d() {
        return this.rv;
    }

    public void qg(JSONArray jSONArray) {
        this.rv = jSONArray;
    }

    public String oa() {
        return this.tj;
    }

    public void rv(String str) {
        this.tj = str;
    }

    public String sz() {
        return this.cp;
    }

    public void tj(String str) {
        this.cp = str;
    }
}
