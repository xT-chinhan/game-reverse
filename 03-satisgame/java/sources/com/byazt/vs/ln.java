package com.byazt.vs;

import androidx.core.view.PointerIconCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, PointerIconCompat.TYPE_ZOOM_IN})
public class ln extends com.byazt.cf.l<JSONObject, JSONObject> {
    public final com.byazt.gcl.s n;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar) {
        cyVar.n("pageFinished", (com.byazt.cf.l<?, ?>) new ln(sVar));
    }

    public ln(com.byazt.gcl.s sVar) {
        this.n = sVar;
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.gcl.s sVar = this.n;
        if (sVar != null) {
            sVar.sz();
        }
        return jSONObject2;
    }
}
