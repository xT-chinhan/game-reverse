package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 866})
public class py extends com.byazt.cf.l<JSONObject, JSONObject> {
    public WeakReference<com.byazt.gcl.s> n;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar) {
        cyVar.n("getSendRewardStatus", (com.byazt.cf.l<?, ?>) new py(sVar));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        com.byazt.gcl.s sVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.byazt.gcl.s> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null && (sVar = this.n.get()) != null) {
            jSONObject2.put("isReward", sVar.x());
        }
        return jSONObject2;
    }

    public py(com.byazt.gcl.s sVar) {
        this.n = new WeakReference<>(sVar);
    }
}
