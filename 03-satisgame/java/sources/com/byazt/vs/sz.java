package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 110})
public class sz extends com.byazt.cf.l<JSONObject, JSONObject> {
    public WeakReference<com.byazt.gcl.s> n;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar) {
        cyVar.n("getAppManage", (com.byazt.cf.l<?, ?>) new sz(sVar));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        return s();
    }

    public sz(com.byazt.gcl.s sVar) {
        this.n = new WeakReference<>(sVar);
    }

    public JSONObject s() {
        com.byazt.gcl.s sVar;
        JSONObject jSONObject = new JSONObject();
        try {
            WeakReference<com.byazt.gcl.s> weakReference = this.n;
            return (weakReference == null || (sVar = weakReference.get()) == null) ? jSONObject : sVar.t();
        } catch (Throwable unused) {
            return jSONObject;
        }
    }
}
