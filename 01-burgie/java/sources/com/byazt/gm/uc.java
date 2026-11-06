package com.byazt.gm;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 5})
public class uc extends com.byazt.ee.c<JSONObject, JSONObject> {
    public WeakReference<com.byazt.sd.nl> pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("changePlaySpeedRatio", (com.byazt.ee.c<?, ?>) new uc(nlVar));
    }

    public uc(com.byazt.sd.nl nlVar) {
        this.pr = new WeakReference<>(nlVar);
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        WeakReference<com.byazt.sd.nl> weakReference = this.pr;
        if (weakReference == null || weakReference.get() == null) {
            return new JSONObject();
        }
        float fOptDouble = (float) jSONObject.optDouble("ratio");
        if (fOptDouble > 0.0f && fOptDouble <= 3.0f) {
            this.pr.get().pr(fOptDouble);
        }
        return new JSONObject();
    }
}
