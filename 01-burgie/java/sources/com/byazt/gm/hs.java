package com.byazt.gm;

import com.byazt.fj.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP})
public class hs extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.sd.nl hn;
    public String hw;
    public SSWebView pr;

    public static void pr(com.byazt.ee.yb ybVar, SSWebView sSWebView, com.byazt.sd.nl nlVar) {
        ybVar.pr("closeWebview", (com.byazt.ee.c<?, ?>) new hs(sSWebView, "closeWebview", nlVar));
        ybVar.pr("makeVisible", (com.byazt.ee.c<?, ?>) new hs(sSWebView, "makeVisible", nlVar));
        ybVar.pr("getCurrentVisibleState", (com.byazt.ee.c<?, ?>) new hs(sSWebView, "getCurrentVisibleState", nlVar));
        ybVar.pr("changeSize", (com.byazt.ee.c<?, ?>) new hs(sSWebView, "changeSize", nlVar));
        ybVar.pr("changeFrame", (com.byazt.ee.c<?, ?>) new hs(sSWebView, "changeFrame", nlVar));
    }

    public hs(SSWebView sSWebView, String str, com.byazt.sd.nl nlVar) {
        this.pr = sSWebView;
        this.hw = str;
        this.hn = nlVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0044  */
    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        int iOptInt;
        int iOptInt2;
        int iOptInt3;
        JSONObject jSONObject2 = new JSONObject();
        switch (this.hw) {
            case "closeWebview":
                com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.gm.hs.1
                    @Override // java.lang.Runnable
                    public void run() {
                        hs.this.pr.setVisibility(8);
                    }
                });
                com.byazt.uq.aj ajVarHn = this.hn.hn();
                if (ajVarHn != null) {
                    ajVarHn.hw();
                    jSONObject2.put(TrackAction.SUCCESS, true);
                } else {
                    jSONObject2.put(TrackAction.SUCCESS, false);
                }
                return jSONObject2;
            case "makeVisible":
                if (this.pr != null) {
                    jSONObject2.put(TrackAction.SUCCESS, true);
                    com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.gm.hs.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (hs.this.pr != null) {
                                hs.this.pr.setVisibility(0);
                            }
                            com.byazt.uq.aj ajVarHn2 = hs.this.hn.hn();
                            if (ajVarHn2 != null) {
                                ajVarHn2.R_();
                            }
                        }
                    });
                } else {
                    jSONObject2.put(TrackAction.SUCCESS, false);
                }
                return jSONObject2;
            case "getCurrentVisibleState":
                jSONObject2.put("visibleState", !com.byazt.sd.ww.hw(this.pr, 50, 5) ? 1 : 0);
                return jSONObject2;
            case "changeSize":
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("size");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 2) {
                    int iOptInt4 = jSONArrayOptJSONArray.optInt(0);
                    int iOptInt5 = jSONArrayOptJSONArray.optInt(1);
                    com.byazt.sd.nl nlVar = this.hn;
                    if (nlVar != null) {
                        nlVar.pr(iOptInt4, iOptInt5);
                    }
                }
                return jSONObject2;
            case "changeFrame":
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("point");
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("size");
                int iOptInt6 = Integer.MAX_VALUE;
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() == 2) {
                    iOptInt2 = jSONArrayOptJSONArray2.optInt(0);
                    iOptInt = jSONArrayOptJSONArray2.optInt(1);
                } else {
                    iOptInt = Integer.MAX_VALUE;
                    iOptInt2 = Integer.MAX_VALUE;
                }
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() == 2) {
                    iOptInt6 = jSONArrayOptJSONArray3.optInt(0);
                    iOptInt3 = jSONArrayOptJSONArray3.optInt(1);
                } else {
                    iOptInt3 = Integer.MAX_VALUE;
                }
                com.byazt.sd.nl nlVar2 = this.hn;
                if (nlVar2 != null) {
                    nlVar2.pr(iOptInt2, iOptInt, iOptInt6, iOptInt3);
                }
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
