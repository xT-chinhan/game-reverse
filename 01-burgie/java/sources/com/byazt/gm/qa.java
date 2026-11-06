package com.byazt.gm;

import android.support.v4.app.NotificationCompat;
import com.byazt.mg.PluginConstants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 101})
public class qa extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.hg.of pr;

    public qa(com.byazt.hg.of ofVar) {
        this.pr = ofVar;
    }

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.hg.of ofVar) {
        ybVar.pr("getRestMetas", (com.byazt.ee.c<?, ?>) new qa(ofVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (this.pr != null) {
                jSONArray = new JSONArray(this.pr.kq());
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("creatives", jSONArray);
            jSONObject2.put("data", jSONObject3);
            jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 0);
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, TrackAction.SUCCESS);
        } catch (Exception e) {
            com.byazt.ca.ho.hw("GetRestMetasMethod", "getRestMetas error: " + e.getMessage());
            jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, e.getMessage());
        }
        return jSONObject2;
    }
}
