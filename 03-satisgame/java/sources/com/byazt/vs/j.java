package com.byazt.vs;

import com.byazt.kfh.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT})
public class j extends com.byazt.cf.l<JSONObject, JSONObject> {
    public SSWebView n;
    public String qg;

    public static void n(com.byazt.cf.cy cyVar, SSWebView sSWebView, String str) {
        cyVar.n("close_twist_observer", (com.byazt.cf.l<?, ?>) new j(sSWebView, str));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        return s();
    }

    public j(SSWebView sSWebView, String str) {
        this.n = sSWebView;
        this.qg = str;
    }

    public JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.byazt.vyf.s.cy().qg(com.byazt.nf.rv.getContext()) && this.n != null) {
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "success");
                this.n.U_();
                return jSONObject;
            }
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "unavailable");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
