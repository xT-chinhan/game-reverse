package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 34})
public class df {
    public String l;
    public String n;
    public String q;
    public String qg;
    public String s;
    public long w;

    public df() {
    }

    public df(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        n(jSONObject.optString("reward_live_deep_link_user_id"));
        l(jSONObject.optString("reward_live_deep_link_request_id"));
        qg(jSONObject.optString("reward_live_deep_link_room_id"));
        s(jSONObject.optString("reawrd_live_short_touch_params"));
        q(jSONObject.optString("reawrd_live_extra_pangle_scheme_params"));
        n(jSONObject.optLong("reward_live_last_time"));
    }

    public String n() {
        return this.qg;
    }

    public void n(String str) {
        this.qg = str;
    }

    public String qg() {
        return this.s;
    }

    public void qg(String str) {
        this.s = str;
    }

    public String s() {
        return this.q;
    }

    public void s(String str) {
        this.q = str;
    }

    public String q() {
        return this.l;
    }

    public void q(String str) {
        this.l = str;
    }

    public long l() {
        return this.w;
    }

    public void n(long j) {
        this.w = j;
    }

    public String w() {
        return this.n;
    }

    public void l(String str) {
        this.n = str;
    }
}
