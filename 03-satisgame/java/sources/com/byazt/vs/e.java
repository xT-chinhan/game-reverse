package com.byazt.vs;

import com.byazt.kfh.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE})
public class e extends com.byazt.cf.l<JSONObject, JSONObject> {
    public SSWebView n;
    public String qg;
    public com.byazt.gcl.s s;

    public static void n(com.byazt.cf.cy cyVar, SSWebView sSWebView, com.byazt.gcl.s sVar) {
        cyVar.n("closeWebview", (com.byazt.cf.l<?, ?>) new e(sSWebView, "closeWebview", sVar));
        cyVar.n("makeVisible", (com.byazt.cf.l<?, ?>) new e(sSWebView, "makeVisible", sVar));
        cyVar.n("getCurrentVisibleState", (com.byazt.cf.l<?, ?>) new e(sSWebView, "getCurrentVisibleState", sVar));
        cyVar.n("checkIfInScreen", (com.byazt.cf.l<?, ?>) new e(sSWebView, "checkIfInScreen", sVar));
        cyVar.n("changeSize", (com.byazt.cf.l<?, ?>) new e(sSWebView, "changeSize", sVar));
        cyVar.n("changeFrame", (com.byazt.cf.l<?, ?>) new e(sSWebView, "changeFrame", sVar));
    }

    public e(SSWebView sSWebView, String str, com.byazt.gcl.s sVar) {
        this.n = sSWebView;
        this.qg = str;
        this.s = sVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        int iOptInt;
        int iOptInt2;
        int iOptInt3;
        JSONObject jSONObject2 = new JSONObject();
        String str = this.qg;
        str.hashCode();
        switch (str) {
            case "changeSize":
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("size");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 2) {
                    int iOptInt4 = jSONArrayOptJSONArray.optInt(0);
                    int iOptInt5 = jSONArrayOptJSONArray.optInt(1);
                    com.byazt.gcl.s sVar = this.s;
                    if (sVar != null) {
                        sVar.n(iOptInt4, iOptInt5);
                    }
                }
                return jSONObject2;
            case "changeFrame":
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("point");
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("size");
                int iOptInt6 = Integer.MAX_VALUE;
                if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() != 2) {
                    iOptInt = Integer.MAX_VALUE;
                    iOptInt2 = Integer.MAX_VALUE;
                } else {
                    iOptInt2 = jSONArrayOptJSONArray2.optInt(0);
                    iOptInt = jSONArrayOptJSONArray2.optInt(1);
                }
                if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() != 2) {
                    iOptInt3 = Integer.MAX_VALUE;
                } else {
                    iOptInt6 = jSONArrayOptJSONArray3.optInt(0);
                    iOptInt3 = jSONArrayOptJSONArray3.optInt(1);
                }
                com.byazt.gcl.s sVar2 = this.s;
                if (sVar2 != null) {
                    sVar2.n(iOptInt2, iOptInt, iOptInt6, iOptInt3);
                }
                return jSONObject2;
            case "getCurrentVisibleState":
                jSONObject2.put("visibleState", !com.byazt.okk.q.qg(this.n, 50, 5) ? 1 : 0);
                return jSONObject2;
            case "closeWebview":
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.vs.e.1
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.n.setVisibility(8);
                    }
                });
                com.byazt.rg.x xVarS = this.s.s();
                if (xVarS != null) {
                    xVarS.qg();
                    jSONObject2.put("success", true);
                } else {
                    jSONObject2.put("success", false);
                }
                return jSONObject2;
            case "makeVisible":
                if (this.n != null) {
                    jSONObject2.put("success", true);
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.vs.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.n != null) {
                                e.this.n.setVisibility(0);
                            }
                            com.byazt.rg.x xVarS2 = e.this.s.s();
                            if (xVarS2 != null) {
                                xVarS2.R_();
                            }
                        }
                    });
                } else {
                    jSONObject2.put("success", false);
                }
                return jSONObject2;
            case "checkIfInScreen":
                boolean zQg = com.byazt.okk.q.qg(this.n, 50, 5);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("in_screen", zQg);
                jSONObject2.put("code", 0);
                jSONObject2.put(com.anythink.core.common.l.f.R, jSONObject3);
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
