package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 1707})
public class ri extends com.byazt.cf.l<JSONObject, JSONObject> {
    public com.byazt.gcl.s n;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar) {
        cyVar.n("ShowUgenDownloadDialog", (com.byazt.cf.l<?, ?>) new ri(sVar));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        return s();
    }

    public ri(com.byazt.gcl.s sVar) {
        this.n = sVar;
    }

    public JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        com.byazt.gcl.s sVar = this.n;
        if (sVar == null) {
            try {
                jSONObject.put("code", -1);
                jSONObject.put("codeMsg", "JsObject is null");
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return sVar.d();
    }
}
