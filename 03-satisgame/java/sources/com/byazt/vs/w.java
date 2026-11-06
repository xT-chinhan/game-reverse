package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 13})
public class w extends com.byazt.cf.l<JSONObject, JSONObject> {
    public WeakReference<com.byazt.gcl.s> n;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar) {
        cyVar.n("changePlaySpeedRatio", (com.byazt.cf.l<?, ?>) new w(sVar));
    }

    public w(com.byazt.gcl.s sVar) {
        this.n = new WeakReference<>(sVar);
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        WeakReference<com.byazt.gcl.s> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return new JSONObject();
        }
        float fOptDouble = (float) jSONObject.optDouble("ratio");
        if (fOptDouble > 0.0f && fOptDouble <= 3.0f) {
            this.n.get().n(fOptDouble);
        }
        return new JSONObject();
    }
}
