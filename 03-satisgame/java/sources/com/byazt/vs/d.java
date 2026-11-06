package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 113})
public class d extends com.byazt.cf.l<JSONObject, JSONObject> {
    public com.byazt.gct.pk n;
    public com.byazt.gcl.s qg;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gct.pk pkVar, com.byazt.gcl.s sVar) {
        cyVar.n("adViewInfo", (com.byazt.cf.l<?, ?>) new d(pkVar, sVar));
    }

    public d(com.byazt.gct.pk pkVar, com.byazt.gcl.s sVar) {
        this.n = pkVar;
        this.qg = sVar;
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("container", this.qg.n());
        jSONObject2.put("creative", this.qg.qg());
        return jSONObject2;
    }
}
