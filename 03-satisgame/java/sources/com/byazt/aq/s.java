package com.byazt.aq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, 8})
public class s {
    public boolean cp;
    public boolean fs;
    public boolean l;
    public String n;
    public int q;
    public int qg;
    public String rv;
    public int s;
    public int tj;
    public boolean w;
    public JSONArray x;

    private s(String str, int i, int i2, int i3, boolean z, JSONArray jSONArray, boolean z2, com.byazt.dt.n nVar, int i4, boolean z3) {
        this.n = str;
        this.qg = i;
        this.s = i2;
        this.q = i3;
        this.l = z;
        this.x = jSONArray;
        this.fs = z2;
        this.rv = nVar.fs();
        this.tj = i4;
        this.cp = z3;
    }

    public String n() {
        return this.n;
    }

    public int qg() {
        return this.qg;
    }

    public int s() {
        return this.s;
    }

    public boolean q() {
        return this.l;
    }

    public boolean l() {
        return this.fs;
    }

    public String w() {
        return this.rv;
    }

    public int x() {
        return this.tj;
    }

    public Map<Integer, Boolean> fs() {
        HashMap map = new HashMap();
        for (int i = 0; i < this.x.length(); i++) {
            try {
                map.put((Integer) this.x.get(i), Boolean.TRUE);
            } catch (Exception unused) {
            }
        }
        return map;
    }

    public s(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.n = jSONObject.optString("meta_md5");
            this.qg = jSONObject.optInt("consume_time");
            this.s = jSONObject.optInt("reduce_time");
            this.l = jSONObject.optBoolean("is_video_completed");
            this.x = jSONObject.optJSONArray("reward_verify_array");
            this.fs = jSONObject.optBoolean("is_mute");
            this.rv = jSONObject.optString("play_again_string");
            this.tj = jSONObject.optInt("carousel_type");
            this.q = jSONObject.optInt("eternal_global_time");
            this.cp = jSONObject.optBoolean("first_ad_is_video");
        } catch (Exception unused) {
        }
    }

    public JSONObject rv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("meta_md5", this.n);
            jSONObject.put("consume_time", this.qg);
            jSONObject.put("reduce_time", this.s);
            jSONObject.put("is_video_completed", this.l);
            jSONObject.put("is_user_interacted", this.w);
            jSONObject.put("reward_verify_array", this.x);
            jSONObject.put("is_mute", this.fs);
            jSONObject.put("play_again_string", this.rv);
            jSONObject.put("carousel_type", this.tj);
            jSONObject.put("eternal_global_time", this.q);
            jSONObject.put("first_ad_is_video", this.cp);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int tj() {
        return this.q;
    }

    public boolean cp() {
        return this.cp;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, 546})
    public static class n {
        public int fs;
        public JSONArray l;
        public String n;
        public boolean q;
        public int qg;
        public boolean rv;
        public int s;
        public com.byazt.dt.n tj;
        public boolean w;
        public int x;

        public s n() {
            return new s(this.n, this.qg, this.s, this.fs, this.q, this.l, this.w, this.tj, this.x, this.rv);
        }

        public n n(String str) {
            this.n = str;
            return this;
        }

        public n n(int i) {
            this.qg = i;
            return this;
        }

        public n qg(int i) {
            this.s = i;
            return this;
        }

        public n n(boolean z) {
            this.q = z;
            return this;
        }

        public n n(Set<Integer> set) {
            this.l = new JSONArray((Collection) set);
            return this;
        }

        public n qg(boolean z) {
            this.w = z;
            return this;
        }

        public n n(com.byazt.dt.n nVar) {
            this.tj = nVar;
            return this;
        }

        public n s(int i) {
            this.x = i;
            return this;
        }

        public n q(int i) {
            this.fs = i;
            return this;
        }

        public n s(boolean z) {
            this.rv = z;
            return this;
        }
    }
}
