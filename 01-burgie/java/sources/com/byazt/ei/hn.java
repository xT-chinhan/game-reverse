package com.byazt.ei;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS, 20})
public class hn {
    public String aj;
    public boolean c;
    public JSONArray fw;
    public int hn;
    public int hw;
    public String pr;
    public boolean uc;
    public int vk;
    public boolean w;
    public int x;
    public boolean zo;

    private hn(String str, int i, int i2, int i3, boolean z, JSONArray jSONArray, boolean z2, com.byazt.db.pr prVar, int i4, boolean z3) {
        this.pr = str;
        this.hw = i;
        this.hn = i2;
        this.x = i3;
        this.c = z;
        this.fw = jSONArray;
        this.zo = z2;
        this.aj = prVar.zo();
        this.vk = i4;
        this.w = z3;
    }

    public String pr() {
        return this.pr;
    }

    public int hw() {
        return this.hw;
    }

    public int hn() {
        return this.hn;
    }

    public boolean x() {
        return this.c;
    }

    public boolean c() {
        return this.zo;
    }

    public String uc() {
        return this.aj;
    }

    public int fw() {
        return this.vk;
    }

    public Map<Integer, Boolean> zo() {
        HashMap map = new HashMap();
        for (int i = 0; i < this.fw.length(); i++) {
            try {
                map.put((Integer) this.fw.get(i), Boolean.TRUE);
            } catch (Exception e) {
            }
        }
        return map;
    }

    public hn(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.pr = jSONObject.optString("meta_md5");
            this.hw = jSONObject.optInt("consume_time");
            this.hn = jSONObject.optInt("reduce_time");
            this.c = jSONObject.optBoolean("is_video_completed");
            this.fw = jSONObject.optJSONArray("reward_verify_array");
            this.zo = jSONObject.optBoolean("is_mute");
            this.aj = jSONObject.optString("play_again_string");
            this.vk = jSONObject.optInt("carousel_type");
            this.x = jSONObject.optInt("eternal_global_time");
            this.w = jSONObject.optBoolean("first_ad_is_video");
        } catch (Exception e) {
        }
    }

    public JSONObject aj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("meta_md5", this.pr);
            jSONObject.put("consume_time", this.hw);
            jSONObject.put("reduce_time", this.hn);
            jSONObject.put("is_video_completed", this.c);
            jSONObject.put("is_user_interacted", this.uc);
            jSONObject.put("reward_verify_array", this.fw);
            jSONObject.put("is_mute", this.zo);
            jSONObject.put("play_again_string", this.aj);
            jSONObject.put("carousel_type", this.vk);
            jSONObject.put("eternal_global_time", this.x);
            jSONObject.put("first_ad_is_video", this.w);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public int vk() {
        return this.x;
    }

    public boolean w() {
        return this.w;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS, 116})
    public static class pr {
        public boolean aj;
        public JSONArray c;
        public int fw;
        public int hn;
        public int hw;
        public String pr;
        public boolean uc;
        public com.byazt.db.pr vk;
        public boolean x;
        public int zo;

        public hn pr() {
            return new hn(this.pr, this.hw, this.hn, this.zo, this.x, this.c, this.uc, this.vk, this.fw, this.aj);
        }

        public pr pr(String str) {
            this.pr = str;
            return this;
        }

        public pr pr(int i) {
            this.hw = i;
            return this;
        }

        public pr hw(int i) {
            this.hn = i;
            return this;
        }

        public pr pr(boolean z) {
            this.x = z;
            return this;
        }

        public pr pr(Set<Integer> set) {
            this.c = new JSONArray((Collection) set);
            return this;
        }

        public pr hw(boolean z) {
            this.uc = z;
            return this;
        }

        public pr pr(com.byazt.db.pr prVar) {
            this.vk = prVar;
            return this;
        }

        public pr hn(int i) {
            this.fw = i;
            return this;
        }

        public pr x(int i) {
            this.zo = i;
            return this;
        }

        public pr hn(boolean z) {
            this.aj = z;
            return this;
        }
    }
}
