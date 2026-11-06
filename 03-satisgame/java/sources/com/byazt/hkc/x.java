package com.byazt.hkc;

import com.byazt.udb.oa;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 46, 21})
public class x implements fs {
    public com.byazt.xnr.qg n;

    @Override // com.byazt.hkc.fs
    public void n(com.byazt.xnr.qg qgVar) {
        this.n = qgVar;
    }

    @Override // com.byazt.hkc.fs
    public void n(final oa oaVar) {
        if (oaVar.sz() == 1) {
            qg(oaVar);
        } else {
            com.byazt.cq.l.n(new com.byazt.qit.x("dynamicparse") { // from class: com.byazt.hkc.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.qg(oaVar);
                }
            }, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(oa oaVar) {
        try {
            JSONObject jSONObjectL = oaVar.l();
            JSONObject jSONObject = new JSONObject(jSONObjectL.optString("template_Plugin"));
            JSONObject jSONObjectOptJSONObject = jSONObjectL.optJSONObject("creative");
            com.byazt.lh.fs fsVarN = new w(jSONObject, jSONObjectOptJSONObject, jSONObjectL.optJSONObject("AdSize"), new JSONObject(jSONObjectL.optString("diff_template_Plugin"))).n(oaVar.q(), oaVar.d(), jSONObjectOptJSONObject.optDouble("score_exact_i18n"), jSONObjectOptJSONObject.optString("comment_num_i18n"), oaVar);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.optString("dynamic_creative"));
                fsVarN.n(jSONObject2.optString("color"));
                fsVarN.n(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.n.n(fsVarN);
        } catch (Exception unused2) {
        }
    }
}
