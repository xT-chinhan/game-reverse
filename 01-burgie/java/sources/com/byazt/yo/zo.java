package com.byazt.yo;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements x {
    public int hn;
    public long hw;
    public long pr;
    public Map<String, Object> x;

    public void pr(int i) {
        this.hn = i;
    }

    public void pr(long j) {
        this.pr = j;
    }

    public void hw(long j) {
        this.hw = j;
    }

    public void pr(Map<String, Object> map) {
        this.x = map;
    }

    @Override // com.byazt.yo.x
    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Map<String, Object> map = this.x;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            jSONObject.put("buffers_time", this.pr);
            jSONObject.put("total_duration", this.hw);
            jSONObject.put("vbtt_skip_type", this.hn);
        } catch (Throwable th) {
        }
    }
}
