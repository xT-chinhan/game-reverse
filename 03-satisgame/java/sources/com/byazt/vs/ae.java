package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 1759})
public class ae extends com.byazt.cf.l<JSONObject, JSONObject> {
    public com.byazt.ep.qg n;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.ep.qg qgVar) {
        cyVar.n("RendUgenDownloadDialogState", (com.byazt.cf.l<?, ?>) new ae(qgVar));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        n(jSONObject);
        return s();
    }

    private void n(JSONObject jSONObject) {
        if (jSONObject == null || this.n == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("code");
        if (iOptInt == 200) {
            this.n.n();
        } else {
            this.n.n(iOptInt, jSONObject.optString(MediationConstant.KEY_ERROR_MSG));
        }
    }

    public ae(com.byazt.ep.qg qgVar) {
        this.n = qgVar;
    }

    public JSONObject s() {
        return new JSONObject();
    }
}
