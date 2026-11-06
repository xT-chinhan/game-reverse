package com.byazt.gm;

import com.byazt.fj.SSWebView;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 574})
public class nl extends com.byazt.ee.c<JSONObject, JSONObject> {
    public WeakReference<SSWebView> pr;

    public static void pr(com.byazt.ee.yb ybVar, SSWebView sSWebView) {
        ybVar.pr("preventTouchEvent", (com.byazt.ee.c<?, ?>) new nl(sSWebView));
    }

    public nl(SSWebView sSWebView) {
        this.pr = new WeakReference<>(sSWebView);
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isPrevent", false);
            SSWebView sSWebView = this.pr.get();
            if (sSWebView != null) {
                sSWebView.setIsPreventTouchEvent(zOptBoolean);
                jSONObject2.put(TrackAction.SUCCESS, true);
            } else {
                jSONObject2.put(TrackAction.SUCCESS, false);
            }
        } catch (Throwable th) {
            jSONObject2.put(TrackAction.SUCCESS, false);
        }
        return jSONObject2;
    }
}
