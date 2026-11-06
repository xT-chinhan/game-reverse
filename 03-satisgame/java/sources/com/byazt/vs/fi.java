package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 1748})
public class fi extends com.byazt.cf.l<JSONObject, JSONObject> {
    public com.byazt.gcl.s n;
    public WeakReference<com.byazt.ozc.qg> qg;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar, WeakReference<com.byazt.ozc.qg> weakReference) {
        cyVar.n("resumeRewardCountDown", (com.byazt.cf.l<?, ?>) new fi(sVar, weakReference));
    }

    public fi(com.byazt.gcl.s sVar, WeakReference<com.byazt.ozc.qg> weakReference) {
        this.n = sVar;
        this.qg = weakReference;
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.byazt.ozc.qg> weakReference = this.qg;
        if (weakReference != null && weakReference.get() != null) {
            this.qg.get().qg();
            jSONObject2.put("success", true);
        } else {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
