package com.byazt.sf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME, 20})
public final class hn {
    public static final hn pr = new hn(0, 0, 0, 0, 0, 0);
    public final int c;
    public final int fw;
    public final int hn;
    public final int hw;
    public final long uc;
    public final int x;

    public hn(int i, int i2, int i3, int i4, long j, int i5) {
        this.hw = i;
        this.hn = i2;
        this.x = i3;
        this.c = i4;
        this.uc = j;
        this.fw = i5;
    }

    public int pr() {
        return this.hw;
    }

    public int hw() {
        return this.hn;
    }

    public int hn() {
        return this.x;
    }

    public int x() {
        return this.c;
    }

    public int c() {
        return this.fw;
    }

    public JSONObject uc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("webview_count", this.hw);
            jSONObject.put("player_count", this.hn);
            jSONObject.put("native_ad_count", this.x);
            jSONObject.put("oom_count", this.c);
            jSONObject.put("cache_kb", this.uc);
            jSONObject.put("thread_count", this.fw);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
