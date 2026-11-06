package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 225})
public class b extends com.byazt.cf.q<JSONObject, JSONObject> {
    public WeakReference<com.byazt.gcl.s> n;

    @Override // com.byazt.cf.q
    public void q() {
    }

    public b(com.byazt.gcl.s sVar) {
        this.n = new WeakReference<>(sVar);
    }

    public static void n(com.byazt.cf.cy cyVar, final com.byazt.gcl.s sVar) {
        cyVar.n("openPrivacy", new com.byazt.cf.q.qg() { // from class: com.byazt.vs.b.1
            @Override // com.byazt.cf.q.qg
            public com.byazt.cf.q n() {
                return new b(sVar);
            }
        });
    }

    @Override // com.byazt.cf.q
    public void n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        com.byazt.gcl.s sVar;
        com.byazt.gct.pk pkVarFs;
        WeakReference<com.byazt.gcl.s> weakReference = this.n;
        if (weakReference == null || (sVar = weakReference.get()) == null || (pkVarFs = sVar.fs()) == null) {
            return;
        }
        com.byazt.okk.n.n(wVar.getContext(), pkVarFs);
        sVar.ae();
    }
}
