package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 865})
public class pe extends com.byazt.cf.l<JSONObject, JSONObject> {
    public com.byazt.mr.x.n n;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.mr.x.n nVar) {
        cyVar.n("UgenDownloadDialogInteraction", (com.byazt.cf.l<?, ?>) new pe(nVar));
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
        int iOptInt = jSONObject.optInt("InteractionType");
        if (iOptInt == 1) {
            this.n.s(null);
            return;
        }
        if (iOptInt == 2) {
            this.n.n(null);
            return;
        }
        if (iOptInt == 3) {
            this.n.n();
        } else if (iOptInt == 4) {
            this.n.qg(null);
        } else {
            if (iOptInt != 5) {
                return;
            }
            this.n.q(null);
        }
    }

    public pe(com.byazt.mr.x.n nVar) {
        this.n = nVar;
    }

    public JSONObject s() {
        return new JSONObject();
    }
}
