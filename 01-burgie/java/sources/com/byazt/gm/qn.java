package com.byazt.gm;

import android.support.v4.app.NotificationCompat;
import com.byazt.mg.PluginConstants;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 467})
public class qn extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.sd.nl pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("sendMaterialMeta", (com.byazt.ee.c<?, ?>) new qn(nlVar));
    }

    public qn(com.byazt.sd.nl nlVar) {
        this.pr = nlVar;
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        boolean zHw;
        com.byazt.hg.of ofVarPr = com.byazt.sd.pr.pr(jSONObject.optJSONObject(ProviderInteractionViews.ROLE_CREATIVE));
        com.byazt.sd.nl nlVar = this.pr;
        if (nlVar != null && ofVarPr != null) {
            nlVar.hn(ofVarPr);
        }
        com.byazt.sd.nl nlVar2 = this.pr;
        if (nlVar2 == null) {
            zHw = false;
        } else {
            zHw = nlVar2.hw(ofVarPr);
            if (ofVarPr != null && ofVarPr.aj() == 4) {
                final String strX = ofVarPr.x();
                if (this.pr.fw(strX) == null) {
                    com.byazt.ri.pr prVarPr = com.byazt.jx.zo.pr(com.byazt.sd.a.getContext(), ofVarPr, this.pr.ve());
                    prVarPr.pr(new com.byazt.nv.pr() { // from class: com.byazt.gm.qn.1
                        @Override // com.byazt.nv.pr
                        public void pr() {
                            com.byazt.dp.pr.pr(strX);
                        }

                        @Override // com.byazt.nv.pr
                        public void pr(long j, long j2, String str, String str2) {
                            com.byazt.dp.pr.pr(strX, j, j2);
                        }

                        @Override // com.byazt.nv.pr
                        public void hw(long j, long j2, String str, String str2) {
                            com.byazt.dp.pr.hw(strX, j, j2);
                        }

                        @Override // com.byazt.nv.pr
                        public void hn(long j, long j2, String str, String str2) {
                            com.byazt.dp.pr.hn(strX, j, j2);
                        }

                        @Override // com.byazt.nv.pr
                        public void pr(long j, String str, String str2) {
                            com.byazt.dp.pr.hw(strX);
                        }

                        @Override // com.byazt.nv.pr
                        public void pr(String str, String str2) {
                            com.byazt.dp.pr.hn(strX);
                        }
                    });
                    this.pr.pr(strX, prVarPr);
                }
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        if (zHw) {
            jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 0);
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, TrackAction.SUCCESS);
        } else {
            jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 11);
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "show 7 factors failed");
        }
        return jSONObject2;
    }
}
