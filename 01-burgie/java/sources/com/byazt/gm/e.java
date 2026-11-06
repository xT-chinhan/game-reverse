package com.byazt.gm;

import android.os.Handler;
import android.os.Looper;
import com.tapsdk.tapad.group.constants.Constants;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 105})
public class e extends com.byazt.ee.x<JSONObject, JSONObject> {
    public com.byazt.ap.uc hn;
    public com.byazt.hg.of hw;
    public WeakReference<com.byazt.sd.nl> pr;
    public long x;

    public static void pr(com.byazt.ee.yb ybVar, final com.byazt.sd.nl nlVar, final com.byazt.hg.of ofVar) {
        ybVar.pr("requestVideoDelayCallback", new com.byazt.ee.x.hw() { // from class: com.byazt.gm.e.1
            @Override // com.byazt.ee.x.hw
            public com.byazt.ee.x pr() {
                return new e(nlVar, ofVar);
            }
        });
    }

    public e(com.byazt.sd.nl nlVar, com.byazt.hg.of ofVar) {
        this.pr = new WeakReference<>(nlVar);
        this.hw = ofVar;
    }

    @Override // com.byazt.ee.x
    public void pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        com.byazt.sd.nl nlVar = this.pr.get();
        if (nlVar == null || jSONObject == null) {
            hn();
            return;
        }
        this.hn = new com.byazt.ap.uc() { // from class: com.byazt.gm.e.2
            @Override // com.byazt.ap.uc
            public void pr() {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.byazt.gm.e.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            e.this.pr(new JSONObject());
                        } catch (Exception e) {
                            com.byazt.ca.ho.hw("requestVideoDelay", e.getMessage());
                        }
                    }
                }, e.this.x);
            }
        };
        int iOptInt = jSONObject.optInt(Constants.DELAY_FIELD, -1);
        if (iOptInt < 0) {
            return;
        }
        this.x = iOptInt;
        if (nlVar.hn() != null && nlVar.hn().Q_()) {
            this.hn.pr();
        } else {
            nlVar.pr(this.hn);
        }
    }

    @Override // com.byazt.ee.x
    public void x() {
    }
}
