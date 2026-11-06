package com.byazt.uko;

import com.byazt.mq.m;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 931, 62})
public class fw implements zo {
    public com.byazt.mft.hw pr;

    @Override // com.byazt.uko.zo
    public void pr(com.byazt.mft.hw hwVar) {
        this.pr = hwVar;
    }

    @Override // com.byazt.uko.zo
    public void pr(final m mVar) {
        if (mVar.g() == 1) {
            hw(mVar);
        } else {
            com.byazt.js.c.pr(new com.byazt.xlm.fw("dynamicparse") { // from class: com.byazt.uko.fw.1
                @Override // java.lang.Runnable
                public void run() {
                    fw.this.hw(mVar);
                }
            }, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(m mVar) {
        try {
            JSONObject jSONObjectC = mVar.c();
            JSONObject jSONObject = new JSONObject(jSONObjectC.optString("template_Plugin"));
            JSONObject jSONObjectOptJSONObject = jSONObjectC.optJSONObject(ProviderInteractionViews.ROLE_CREATIVE);
            com.byazt.rk.zo zoVarPr = new uc(jSONObject, jSONObjectOptJSONObject, jSONObjectC.optJSONObject("AdSize"), new JSONObject(jSONObjectC.optString("diff_template_Plugin"))).pr(mVar.x(), mVar.k(), jSONObjectOptJSONObject.optDouble("score_exact_i18n"), jSONObjectOptJSONObject.optString("comment_num_i18n"), mVar);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.optString("dynamic_creative"));
                zoVarPr.pr(jSONObject2.optString("color"));
                zoVarPr.pr(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable th) {
            }
            this.pr.pr(zoVarPr);
        } catch (Exception e) {
        }
    }
}
