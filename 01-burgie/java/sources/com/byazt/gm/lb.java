package com.byazt.gm;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 48})
public class lb extends com.byazt.ee.c<JSONObject, JSONObject> {
    public WeakReference<com.byazt.sd.nl> pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("getPlayTimeCurrent", (com.byazt.ee.c<?, ?>) new lb(nlVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.byazt.sd.nl> weakReference = this.pr;
        if (weakReference == null || weakReference.get() == null) {
            return jSONObject2;
        }
        int iN = 0;
        com.byazt.sd.nl nlVar = this.pr.get();
        if (nlVar != null) {
            iN = nlVar.n();
        }
        jSONObject2.put("currentTime", iN);
        return jSONObject2;
    }

    public lb(com.byazt.sd.nl nlVar) {
        this.pr = new WeakReference<>(nlVar);
    }
}
