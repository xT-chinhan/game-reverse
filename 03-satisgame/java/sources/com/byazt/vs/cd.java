package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 86})
public class cd extends com.byazt.cf.l<JSONObject, JSONObject> {
    public com.byazt.gct.pk n;

    public cd(com.byazt.gct.pk pkVar) {
        this.n = pkVar;
    }

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gct.pk pkVar) {
        cyVar.n("getLiveSaasAuthStatus", (com.byazt.cf.l<?, ?>) new cd(pkVar));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        com.byazt.gct.dg dgVarN;
        com.byazt.gct.pk pkVar;
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.gct.hd hdVar = null;
        if (jSONObject != null) {
            try {
                dgVarN = com.byazt.gct.dg.n(jSONObject.optJSONObject("live_info"));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("deep_link");
                if (jSONObjectOptJSONObject != null) {
                    hdVar = new com.byazt.gct.hd(jSONObjectOptJSONObject);
                }
            } catch (Throwable th) {
                com.byazt.tk.k.qg("glsas", "method:" + th.getMessage());
            }
        } else {
            dgVarN = null;
        }
        if (hdVar == null && (pkVar = this.n) != null) {
            hdVar = pkVar.sz();
        }
        if (dgVarN == null) {
            dgVarN = this.n.cp();
        }
        boolean z = true;
        jSONObject2.put("has_live_silent_auth", dgVarN != null && dgVarN.s());
        jSONObject2.put("has_install_douyin", com.byazt.hoz.n.n(hdVar));
        jSONObject2.put("has_live_authed", com.byazt.wq.qg.n().l() == 2);
        boolean z2 = dgVarN != null && dgVarN.q();
        if (z2) {
            if (com.byazt.wq.qg.n().s() != 2) {
                z = false;
            }
            z2 = z;
        }
        jSONObject2.put("has_playable_auth_switch", z2);
        JSONObject jSONObject3 = new JSONObject();
        if (dgVarN != null) {
            jSONObject3.put("aweme_agreements", dgVarN.l());
            jSONObject3.put("aweme_privacy", dgVarN.w());
        }
        jSONObject2.put("aweme_auth_protocol", jSONObject3);
        return jSONObject2;
    }
}
