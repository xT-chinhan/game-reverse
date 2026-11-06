package com.byazt.gm;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 1490})
public class ii extends com.byazt.ee.x<JSONObject, JSONObject> {
    public WeakReference<com.byazt.sd.nl> pr;

    public static void pr(com.byazt.ee.yb ybVar, final com.byazt.sd.nl nlVar) {
        ybVar.pr("showAppDetailOrPrivacyDialog", new com.byazt.ee.x.hw() { // from class: com.byazt.gm.ii.1
            @Override // com.byazt.ee.x.hw
            public com.byazt.ee.x pr() {
                return new ii(nlVar);
            }
        });
    }

    public ii(com.byazt.sd.nl nlVar) {
        this.pr = new WeakReference<>(nlVar);
    }

    @Override // com.byazt.ee.x
    public void pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        com.byazt.sd.zo.nt().of();
        WeakReference<com.byazt.sd.nl> weakReference = this.pr;
        if (weakReference == null) {
            return;
        }
        com.byazt.sd.nl nlVar = weakReference.get();
        if (nlVar == null) {
            hn();
            return;
        }
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("show_dialog_style");
        if (iOptInt == 1) {
            nlVar.b();
        } else if (iOptInt == 2) {
            nlVar.z();
        }
    }

    @Override // com.byazt.ee.x
    public void x() {
    }
}
