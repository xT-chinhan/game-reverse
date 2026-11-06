package com.byazt.gm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.hg.of pr;

    public yb(com.byazt.hg.of ofVar) {
        this.pr = ofVar;
    }

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.hg.of ofVar) {
        ybVar.pr("getLiveSaasAuthStatus", (com.byazt.ee.c<?, ?>) new yb(ofVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        com.byazt.hg.qi qiVarPr;
        com.byazt.hg.of ofVar;
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.hg.yb ybVar = null;
        if (jSONObject == null) {
            qiVarPr = null;
        } else {
            try {
                qiVarPr = com.byazt.hg.qi.pr(jSONObject.optJSONObject("live_info"));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("deep_link");
                if (jSONObjectOptJSONObject != null) {
                    ybVar = new com.byazt.hg.yb(jSONObjectOptJSONObject);
                }
            } catch (Throwable th) {
                com.byazt.ca.ho.hw("glsas", "method:" + th.getMessage());
            }
        }
        if (ybVar == null && (ofVar = this.pr) != null) {
            ybVar = ofVar.g();
        }
        if (qiVarPr == null) {
            qiVarPr = this.pr.w();
        }
        boolean z = true;
        jSONObject2.put("has_live_silent_auth", qiVarPr != null && qiVarPr.hn());
        jSONObject2.put("has_install_douyin", com.byazt.dz.pr.pr(ybVar));
        jSONObject2.put("has_live_authed", com.byazt.eg.hw.pr().c() == 2);
        boolean z2 = qiVarPr != null && qiVarPr.x();
        if (z2) {
            if (com.byazt.eg.hw.pr().hn() != 2) {
                z = false;
            }
            z2 = z;
        }
        jSONObject2.put("has_playable_auth_switch", z2);
        JSONObject jSONObject3 = new JSONObject();
        if (qiVarPr != null) {
            jSONObject3.put("aweme_agreements", qiVarPr.c());
            jSONObject3.put("aweme_privacy", qiVarPr.uc());
        }
        jSONObject2.put("aweme_auth_protocol", jSONObject3);
        return jSONObject2;
    }
}
