package com.byazt.shr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends n {
    public String n;
    public long qg;

    public oa(String str, long j) {
        this.n = str;
        this.qg = j;
    }

    @Override // com.byazt.shr.q
    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.n);
            jSONObject.put("preload_size", this.qg);
        } catch (Throwable unused) {
        }
    }
}
