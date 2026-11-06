package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 29})
public class cp extends com.byazt.cf.l<JSONObject, JSONObject> {
    public com.byazt.gct.pk n;
    public com.byazt.gcl.s qg;
    public String s;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gct.pk pkVar, com.byazt.gcl.s sVar) {
        cyVar.n("getEstimatedInteractionAreaInfo", (com.byazt.cf.l<?, ?>) new cp(pkVar, sVar, "getEstimatedInteractionAreaInfo"));
        cyVar.n("interactionAreaInfo", (com.byazt.cf.l<?, ?>) new cp(pkVar, sVar, "interactionAreaInfo"));
    }

    public cp(com.byazt.gct.pk pkVar, com.byazt.gcl.s sVar, String str) {
        this.n = pkVar;
        this.qg = sVar;
        this.s = str;
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        com.byazt.gct.cy cyVarN;
        com.byazt.gct.cy cyVarN2;
        JSONObject jSONObject2;
        com.byazt.rg.x xVarS = this.qg.s();
        String str = this.s;
        str.hashCode();
        if (str.equals("interactionAreaInfo")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("areas");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0 || (jSONObject2 = jSONArrayOptJSONArray.getJSONObject(0)) == null) {
                cyVarN = null;
                cyVarN2 = null;
            } else {
                cyVarN = com.byazt.gct.cy.n(jSONObject2);
                if (xVarS != null) {
                    xVarS.setEasyPlayInteractionAreaInfo(cyVarN);
                    cyVarN2 = com.byazt.gct.cy.n(xVarS.getEstimatedInteractionAreaInfo());
                } else {
                    cyVarN2 = null;
                }
            }
            if (cyVarN2 == null) {
                if (xVarS != null) {
                    xVarS.n(com.byazt.gct.cy.qg(null, cyVarN), 1.0d);
                    this.qg.qg("canMakeVisiable", (JSONObject) null);
                }
            } else if (cyVarN == null) {
                xVarS.n(null, -1.0d);
                xVarS.s();
                this.qg.qg("expressWebviewRecycle", (JSONObject) null);
            } else {
                double dN = com.byazt.gct.cy.n(cyVarN2, cyVarN);
                double d = cyVarN.s * cyVarN.q;
                double d2 = cyVarN2.s * cyVarN2.q;
                if (d2 == 0.0d) {
                    xVarS.n(com.byazt.gct.cy.qg(cyVarN2, cyVarN), 1.0d);
                    this.qg.qg("canMakeVisiable", (JSONObject) null);
                    return null;
                }
                if (d == 0.0d) {
                    xVarS.n(null, -1.0d);
                    xVarS.s();
                    this.qg.qg("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                if (!(dN / d >= 0.8d)) {
                    xVarS.n(null, -1.0d);
                    xVarS.s();
                    this.qg.qg("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                xVarS.n(com.byazt.gct.cy.qg(cyVarN2, cyVarN), (dN - d2) / d2);
                this.qg.qg("canMakeVisiable", (JSONObject) null);
                return null;
            }
        } else if (str.equals("getEstimatedInteractionAreaInfo") && xVarS != null) {
            return xVarS.getEstimatedInteractionAreaInfo();
        }
        return null;
    }
}
