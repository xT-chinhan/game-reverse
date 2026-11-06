package com.byazt.gm;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 61})
public class aj extends com.byazt.ee.x<JSONObject, JSONObject> {
    public WeakReference<com.byazt.sd.nl> pr;

    public static void pr(com.byazt.ee.yb ybVar, final com.byazt.sd.nl nlVar) {
        ybVar.pr("newClickEvent", new com.byazt.ee.x.hw() { // from class: com.byazt.gm.aj.1
            @Override // com.byazt.ee.x.hw
            public com.byazt.ee.x pr() {
                return new aj(nlVar);
            }
        });
    }

    public aj(com.byazt.sd.nl nlVar) {
        this.pr = new WeakReference<>(nlVar);
    }

    @Override // com.byazt.ee.x
    public void pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        com.byazt.sd.nl nlVar = this.pr.get();
        if (nlVar == null) {
            hn();
        } else {
            nlVar.zo(jSONObject);
        }
    }

    @Override // com.byazt.ee.x
    public void x() {
    }
}
