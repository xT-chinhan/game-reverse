package com.byazt.gm;

import com.byazt.mg.PluginConstants;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 62})
public class fw extends com.byazt.ee.x<JSONObject, JSONObject> {
    public WeakReference<com.byazt.sd.nl> pr;

    public static void pr(com.byazt.ee.yb ybVar, final com.byazt.sd.nl nlVar) {
        ybVar.pr("commonConvert", new com.byazt.ee.x.hw() { // from class: com.byazt.gm.fw.1
            @Override // com.byazt.ee.x.hw
            public com.byazt.ee.x pr() {
                return new fw(nlVar);
            }
        });
    }

    public fw(com.byazt.sd.nl nlVar) {
        this.pr = new WeakReference<>(nlVar);
    }

    @Override // com.byazt.ee.x
    public void pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        com.byazt.ze.pr prVarSv;
        JSONObject jSONObjectHw;
        com.byazt.sd.zo.nt().of();
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.hg.of ofVarPr = null;
        try {
            WeakReference<com.byazt.sd.nl> weakReference = this.pr;
            if (weakReference == null) {
                com.byazt.xk.hw.pr().pr("commonConvert", "js", 1, jSONObject2);
                com.byazt.eg.hw.pr().x(null);
                return;
            }
            com.byazt.sd.nl nlVar = weakReference.get();
            if (nlVar == null) {
                hn();
                com.byazt.xk.hw.pr().pr("commonConvert", "js", 2, jSONObject2);
                com.byazt.eg.hw.pr().x(null);
                return;
            }
            if (jSONObject == null) {
                com.byazt.xk.hw.pr().pr("commonConvert", "js", 3, jSONObject2);
                com.byazt.eg.hw.pr().x(null);
                return;
            }
            ofVarPr = com.byazt.sd.pr.pr(jSONObject);
            int iOptInt = jSONObject.optInt("j_live_saas_param_interaction_type", -1);
            int iOptInt2 = jSONObject.optInt("j_download_adapter_mode", 0);
            int iOptInt3 = jSONObject.optInt("j_common_convert_source", 0);
            if (ofVarPr == null) {
                com.byazt.xk.hw.pr().pr("commonConvert", "js", 4, jSONObject2);
                com.byazt.eg.hw.pr().x(ofVarPr);
                return;
            }
            ofVarPr.pr(true);
            jSONObject2.putOpt("live_interaction_type", Integer.valueOf(ofVarPr.c()));
            jSONObject2.putOpt("ext", ofVarPr.B_());
            if (ofVarPr.qa() == null && (prVarSv = ofVarPr.sv()) != null && (jSONObjectHw = prVarSv.hw()) != null) {
                ofVarPr.pr(com.byazt.hg.g.pr(jSONObjectHw));
            }
            nlVar.pr(iOptInt3, ofVarPr, iOptInt, iOptInt2);
            com.byazt.xk.hw.pr().pr("commonConvert", "js", 0, jSONObject2);
            com.byazt.eg.hw.pr().x(ofVarPr);
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(PluginConstants.KEY_ERROR_CODE, 200);
                pr(jSONObject3);
            } catch (Exception e) {
                e.getMessage();
            }
        } catch (Exception e2) {
        } catch (Throwable th) {
            com.byazt.xk.hw.pr().pr("commonConvert", "js", 0, jSONObject2);
            com.byazt.eg.hw.pr().x(null);
            throw th;
        }
    }

    @Override // com.byazt.ee.x
    public void x() {
    }
}
