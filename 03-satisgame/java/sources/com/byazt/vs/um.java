package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 33})
public class um extends com.byazt.cf.l<JSONObject, JSONObject> {
    public WeakReference<com.byazt.gcl.s> n;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar) {
        cyVar.n("getPlayTimeCurrent", (com.byazt.cf.l<?, ?>) new um(sVar));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.byazt.gcl.s> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            com.byazt.gcl.s sVar = this.n.get();
            jSONObject2.put("currentTime", sVar != null ? sVar.j() : 0);
        }
        return jSONObject2;
    }

    public um(com.byazt.gcl.s sVar) {
        this.n = new WeakReference<>(sVar);
    }
}
