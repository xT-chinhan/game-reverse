package com.byazt.gm;

import android.support.v4.app.NotificationCompat;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 121})
public class x extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.sd.nl hn;
    public AtomicBoolean pr = new AtomicBoolean(false);
    public AtomicBoolean hw = new AtomicBoolean(false);

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("businessStatusNotify", (com.byazt.ee.c<?, ?>) new x(nlVar));
    }

    public x(com.byazt.sd.nl nlVar) {
        this.hn = nlVar;
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null || this.hn == null) {
            return jSONObject2;
        }
        int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 0);
        if (iOptInt == 0) {
            this.hn.hw(0, 0);
        } else if (iOptInt == 1) {
            int iOptInt2 = jSONObject.optInt("completed", 0);
            int iOptInt3 = jSONObject.optInt("finished", 0);
            if (iOptInt2 == 1 && this.pr.compareAndSet(false, true)) {
                this.hn.hw(1, 1);
            }
            if (iOptInt3 == 1 && this.hw.compareAndSet(false, true)) {
                this.hn.hw(1, 2);
            }
        } else if (iOptInt == 2) {
            this.hn.hw(2, jSONObject.optInt("callUpStatus", 0));
        }
        return jSONObject2;
    }
}
