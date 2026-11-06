package com.byazt.vs;

import com.byazt.kfh.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 26})
public class qg extends com.byazt.cf.l<JSONObject, JSONObject> {
    public SSWebView n;
    public String qg;

    public static void n(com.byazt.cf.cy cyVar, SSWebView sSWebView, String str) {
        cyVar.n("start_twist_observer", (com.byazt.cf.l<?, ?>) new qg(sSWebView, str));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        return s();
    }

    public qg(SSWebView sSWebView, String str) {
        this.n = sSWebView;
        this.qg = str;
    }

    public JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.byazt.vyf.s.cy().qg(com.byazt.nf.rv.getContext()) && this.n != null) {
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "success");
                this.n.n(2, com.byazt.vyf.s.cy().q());
                return jSONObject;
            }
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "unavailable");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
