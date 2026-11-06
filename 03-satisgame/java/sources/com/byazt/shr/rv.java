package com.byazt.shr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv implements q {
    public long n;
    public int q;
    public long qg;
    public int s;

    public void n(long j) {
        this.n = j;
    }

    public void n(int i) {
        this.q = i;
    }

    public void qg(long j) {
        this.qg = j;
    }

    public void qg(int i) {
        this.s = i;
    }

    @Override // com.byazt.shr.q
    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_start_duration", this.n);
            jSONObject.put("video_cache_size", this.qg);
            jSONObject.put("is_auto_play", this.s);
            jSONObject.put("is_supplement_replay", this.q);
        } catch (Throwable unused) {
        }
    }
}
