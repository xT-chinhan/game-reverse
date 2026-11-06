package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 210})
public class k extends com.byazt.cf.l<JSONObject, JSONObject> {
    public JSONObject n;

    public k(JSONObject jSONObject) {
        this.n = jSONObject;
    }

    public static void n(com.byazt.cf.cy cyVar, JSONObject jSONObject) {
        cyVar.n("getData", (com.byazt.cf.l<?, ?>) new k(jSONObject));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        return com.byazt.ns.qg.n(this.n, jSONObject);
    }
}
