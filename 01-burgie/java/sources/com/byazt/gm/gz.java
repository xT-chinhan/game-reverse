package com.byazt.gm;

import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 672})
public class gz extends com.byazt.ee.c<JSONObject, JSONObject> {
    public WeakReference<com.byazt.sa.hw> hw;
    public com.byazt.sd.nl pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar, WeakReference<com.byazt.sa.hw> weakReference) {
        ybVar.pr("pauseRewardCountDown", (com.byazt.ee.c<?, ?>) new gz(nlVar, weakReference));
    }

    public gz(com.byazt.sd.nl nlVar, WeakReference<com.byazt.sa.hw> weakReference) {
        this.pr = nlVar;
        this.hw = weakReference;
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.byazt.sa.hw> weakReference = this.hw;
        if (weakReference != null && weakReference.get() != null) {
            this.hw.get().pr();
            jSONObject2.put(TrackAction.SUCCESS, true);
        } else {
            jSONObject2.put(TrackAction.SUCCESS, false);
        }
        return jSONObject2;
    }
}
