package com.byazt.gm;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 50})
public class vk extends com.byazt.ee.c<JSONObject, JSONObject> {
    public String hn;
    public com.byazt.sd.nl hw;
    public com.byazt.hg.of pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.hg.of ofVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("getEstimatedInteractionAreaInfo", (com.byazt.ee.c<?, ?>) new vk(ofVar, nlVar, "getEstimatedInteractionAreaInfo"));
        ybVar.pr("interactionAreaInfo", (com.byazt.ee.c<?, ?>) new vk(ofVar, nlVar, "interactionAreaInfo"));
    }

    public vk(com.byazt.hg.of ofVar, com.byazt.sd.nl nlVar, String str) {
        this.pr = ofVar;
        this.hw = nlVar;
        this.hn = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        com.byazt.hg.nt ntVarPr;
        com.byazt.hg.nt ntVarPr2;
        JSONObject jSONObject2;
        com.byazt.uq.aj ajVarHn = this.hw.hn();
        switch (this.hn) {
            case "getEstimatedInteractionAreaInfo":
                if (ajVarHn != null) {
                    return ajVarHn.getEstimatedInteractionAreaInfo();
                }
                return null;
            case "interactionAreaInfo":
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("areas");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0 && (jSONObject2 = jSONArrayOptJSONArray.getJSONObject(0)) != null) {
                    ntVarPr = com.byazt.hg.nt.pr(jSONObject2);
                    if (ajVarHn == null) {
                        ntVarPr2 = null;
                    } else {
                        ajVarHn.setEasyPlayInteractionAreaInfo(ntVarPr);
                        ntVarPr2 = com.byazt.hg.nt.pr(ajVarHn.getEstimatedInteractionAreaInfo());
                    }
                } else {
                    ntVarPr = null;
                    ntVarPr2 = null;
                }
                if (ntVarPr2 == null) {
                    if (ajVarHn != null) {
                        ajVarHn.pr(com.byazt.hg.nt.hw(null, ntVarPr), 1.0d);
                        this.hw.hw("canMakeVisiable", (JSONObject) null);
                        return null;
                    }
                    return null;
                }
                if (ntVarPr == null) {
                    ajVarHn.pr(null, -1.0d);
                    ajVarHn.hn();
                    this.hw.hw("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                double dPr = com.byazt.hg.nt.pr(ntVarPr2, ntVarPr);
                double d = ntVarPr.hn * ntVarPr.x;
                double d2 = ntVarPr2.hn * ntVarPr2.x;
                if (d2 == 0.0d) {
                    ajVarHn.pr(com.byazt.hg.nt.hw(ntVarPr2, ntVarPr), 1.0d);
                    this.hw.hw("canMakeVisiable", (JSONObject) null);
                    return null;
                }
                if (d == 0.0d) {
                    ajVarHn.pr(null, -1.0d);
                    ajVarHn.hn();
                    this.hw.hw("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                if (!(dPr / d >= 0.8d)) {
                    ajVarHn.pr(null, -1.0d);
                    ajVarHn.hn();
                    this.hw.hw("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                ajVarHn.pr(com.byazt.hg.nt.hw(ntVarPr2, ntVarPr), (dPr - d2) / d2);
                this.hw.hw("canMakeVisiable", (JSONObject) null);
                return null;
            default:
                return null;
        }
    }
}
