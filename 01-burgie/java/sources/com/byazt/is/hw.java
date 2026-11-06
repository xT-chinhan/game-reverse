package com.byazt.is;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 13})
public final class hw {
    public String hw;
    public boolean pr;
    public JSONObject x;
    public long hn = 0;
    public boolean c = x.hw;

    public static hw pr(JSONObject jSONObject) {
        hw hwVar = new hw();
        if (jSONObject != null) {
            hwVar.pr(jSONObject.optString("ec_mall_back_url"));
            hwVar.pr = jSONObject.optBoolean("sub_process", false);
            hwVar.hn = jSONObject.optLong("init_delay", x.pr);
            hwVar.x = jSONObject.optJSONObject("live_tob_init_extra");
            hwVar.pr(jSONObject.optString("ec_mall_back_url"));
            hwVar.c = jSONObject.optBoolean("init_after_click", x.hw);
        }
        return hwVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ec_mall_back_url", this.hw);
            jSONObject.put("sub_process", this.pr);
            jSONObject.put("init_delay", this.hn);
            jSONObject.put("live_tob_init_extra", this.x);
            jSONObject.put("init_after_click", this.c);
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    public boolean pr() {
        return this.pr;
    }

    public long hw() {
        return this.hn;
    }

    public JSONObject hn() {
        return this.x;
    }

    public String x() {
        return this.hw;
    }

    public void pr(String str) {
        this.hw = str;
    }

    public boolean c() {
        return this.c;
    }
}
