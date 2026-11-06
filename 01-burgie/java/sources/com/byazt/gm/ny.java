package com.byazt.gm;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 36})
public class ny extends com.byazt.ee.c<JSONObject, JSONObject> {
    public Context hn;
    public com.byazt.sd.nl hw;
    public String pr;
    public com.byazt.hg.of x;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar, Context context, com.byazt.hg.of ofVar) {
        ybVar.pr("supportHaptic", (com.byazt.ee.c<?, ?>) new ny("supportHaptic", nlVar, context, ofVar));
        ybVar.pr("playHaptic", (com.byazt.ee.c<?, ?>) new ny("playHaptic", nlVar, context, ofVar));
        ybVar.pr("stopHaptic", (com.byazt.ee.c<?, ?>) new ny("stopHaptic", nlVar, context, ofVar));
    }

    public ny(String str, com.byazt.sd.nl nlVar, Context context, com.byazt.hg.of ofVar) {
        this.pr = str;
        this.hw = nlVar;
        this.hn = context;
        this.x = ofVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        switch (this.pr) {
            case "supportHaptic":
                Context context = this.hn;
                jSONObject2.put("supportHaptic", context != null ? com.byazt.tm.hn.pr(context) : false);
                return jSONObject2;
            case "playHaptic":
                com.byazt.tm.hn.pr(jSONObject, this.hn, this.x);
                return jSONObject2;
            case "stopHaptic":
                Context context2 = this.hn;
                if (context2 != null) {
                    com.byazt.tm.hn.hw(context2);
                }
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
