package com.byazt.shr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd implements q {
    public long n;
    public boolean qg;

    public void n(long j) {
        this.n = j;
    }

    public void n(boolean z) {
        this.qg = z;
    }

    @Override // com.byazt.shr.q
    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_cache_size", this.n);
            jSONObject.put("is_auto_play", this.qg);
        } catch (Throwable unused) {
        }
    }
}
