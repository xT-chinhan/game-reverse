package com.byazt.yo;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements x {
    public int c;
    public int hn;
    public long hw;
    public long pr;
    public int x = 0;

    public void pr(int i) {
        this.c = i;
    }

    public void pr(long j) {
        this.pr = j;
    }

    public void hw(long j) {
        this.hw = j;
    }

    public void hw(int i) {
        this.hn = i;
    }

    public void hn(int i) {
        this.x = i;
    }

    @Override // com.byazt.yo.x
    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.pr);
            jSONObject.put("buffers_time", this.hw);
            jSONObject.put("break_reason", this.hn);
            jSONObject.put("video_backup", this.x);
            jSONObject.put("vbtt_skip_type", this.c);
        } catch (Throwable th) {
        }
    }
}
