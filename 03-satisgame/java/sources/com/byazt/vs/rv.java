package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends com.byazt.cf.q<JSONObject, JSONObject> {
    public WeakReference<com.byazt.gcl.s> n;

    @Override // com.byazt.cf.q
    public void q() {
    }

    public static void n(com.byazt.cf.cy cyVar, final com.byazt.gcl.s sVar) {
        cyVar.n("interstitial_webview_close", new com.byazt.cf.q.qg() { // from class: com.byazt.vs.rv.1
            @Override // com.byazt.cf.q.qg
            public com.byazt.cf.q n() {
                return new rv(sVar);
            }
        });
    }

    public rv(com.byazt.gcl.s sVar) {
        this.n = new WeakReference<>(sVar);
    }

    @Override // com.byazt.cf.q
    public void n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        com.byazt.vyf.s.cy().pk();
        com.byazt.tk.k.qg("DoInterstitialWebViewCloseMethod", "DoInterstitialWebViewCloseMethod invoke ");
        com.byazt.gcl.s sVar = this.n.get();
        if (sVar == null) {
            com.byazt.tk.k.qg("DoInterstitialWebViewCloseMethod", "invoke error");
            s();
        } else {
            sVar.hd();
        }
    }
}
