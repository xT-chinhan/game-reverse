package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME})
public class nf extends com.byazt.cf.l<JSONObject, JSONObject> {
    public WeakReference<com.byazt.gcl.s> n;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar) {
        cyVar.n("startVideoTransform", (com.byazt.cf.l<?, ?>) new nf(sVar));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        com.byazt.gcl.s sVar;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.byazt.gcl.s> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null || jSONObject == null || (sVar = this.n.get()) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("videoInfo")) == null) {
            return jSONObject2;
        }
        sVar.n((float) jSONObjectOptJSONObject.optDouble("toX"), (float) jSONObjectOptJSONObject.optDouble("toY"), (float) jSONObjectOptJSONObject.optDouble("pivotX"), (float) jSONObjectOptJSONObject.optDouble("pivotY"), jSONObject.optInt(MediationConstant.EXTRA_DURATION));
        return jSONObject2;
    }

    public nf(com.byazt.gcl.s sVar) {
        this.n = new WeakReference<>(sVar);
    }
}
