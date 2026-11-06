package com.byazt.gm;

import com.byazt.fj.SSWebView;
import com.byazt.mg.PluginConstants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 13})
public class hw extends com.byazt.ee.c<JSONObject, JSONObject> {
    public String hw;
    public SSWebView pr;

    public static void pr(com.byazt.ee.yb ybVar, SSWebView sSWebView, String str) {
        ybVar.pr("start_twist_observer", (com.byazt.ee.c<?, ?>) new hw(sSWebView, str));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        return hn();
    }

    public hw(SSWebView sSWebView, String str) {
        this.pr = sSWebView;
        this.hw = str;
    }

    public JSONObject hn() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.byazt.sd.zo.nt().hw(com.byazt.sd.a.getContext()) && this.pr != null) {
                jSONObject.put(PluginConstants.KEY_ERROR_CODE, 0);
                jSONObject.put("codeMsg", TrackAction.SUCCESS);
                this.pr.pr(2, com.byazt.sd.zo.nt().x());
                return jSONObject;
            }
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, -1);
            jSONObject.put("codeMsg", "unavailable");
            return jSONObject;
        } catch (Throwable th) {
            return jSONObject;
        }
    }
}
