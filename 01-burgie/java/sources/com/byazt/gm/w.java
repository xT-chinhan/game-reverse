package com.byazt.gm;

import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.tapsdk.tapad.internal.runtime.view.ContainerViewManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 109})
public class w extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.sd.nl hw;
    public com.byazt.hg.of pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.hg.of ofVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("adViewInfo", (com.byazt.ee.c<?, ?>) new w(ofVar, nlVar));
    }

    public w(com.byazt.hg.of ofVar, com.byazt.sd.nl nlVar) {
        this.pr = ofVar;
        this.hw = nlVar;
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(ContainerViewManager.NAME, this.hw.pr());
        jSONObject2.put(ProviderInteractionViews.ROLE_CREATIVE, this.hw.hw());
        return jSONObject2;
    }
}
