package com.byazt.gm;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 108})
public class m extends com.byazt.ee.c<JSONObject, JSONObject> {
    public WeakReference<com.byazt.sd.nl> pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("getAppManage", (com.byazt.ee.c<?, ?>) new m(nlVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        return hn();
    }

    public m(com.byazt.sd.nl nlVar) {
        this.pr = new WeakReference<>(nlVar);
    }

    public JSONObject hn() {
        com.byazt.sd.nl nlVar;
        JSONObject jSONObject = new JSONObject();
        try {
            WeakReference<com.byazt.sd.nl> weakReference = this.pr;
            if (weakReference == null || (nlVar = weakReference.get()) == null) {
                return jSONObject;
            }
            return nlVar.iu();
        } catch (Throwable th) {
            return jSONObject;
        }
    }
}
