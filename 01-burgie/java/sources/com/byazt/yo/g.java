package com.byazt.yo;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g implements x {
    public long hn;
    public int hw;
    public long pr;

    public void pr(long j) {
        this.pr = j;
    }

    public void pr(int i) {
        this.hw = i;
    }

    public void hw(long j) {
        this.hn = j;
    }

    @Override // com.byazt.yo.x
    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.pr);
            jSONObject.put("buffers_count", this.hw);
            jSONObject.put("total_duration", this.hn);
        } catch (Throwable th) {
        }
    }
}
