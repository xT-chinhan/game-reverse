package com.byazt.gm;

import android.app.Activity;
import android.content.Context;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 37})
public class pr extends com.byazt.ee.c<JSONObject, JSONObject> {
    public Context hw;
    public String pr;

    public static void pr(com.byazt.ee.yb ybVar, Context context) {
        ybVar.pr("closeView", (com.byazt.ee.c<?, ?>) new pr("closeView", context));
    }

    public pr(String str, Context context) {
        this.pr = str;
        this.hw = context;
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        switch (this.pr) {
            case "closeView":
                Context context = this.hw;
                if (context != null) {
                    ((Activity) context).finish();
                    jSONObject2.put(TrackAction.SUCCESS, true);
                    break;
                } else {
                    jSONObject2.put(TrackAction.SUCCESS, false);
                    break;
                }
            default:
                return jSONObject2;
        }
    }
}
