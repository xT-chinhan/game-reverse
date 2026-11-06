package com.byazt.gm;

import com.byazt.mg.PluginConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 1121})
public class ls extends com.byazt.ee.c<JSONObject, JSONObject> {
    public final String pr;

    public ls(String str) {
        this.pr = str;
    }

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.hg.of ofVar) {
        ybVar.pr("sendAction", (com.byazt.ee.c<?, ?>) new ls(ofVar.z()));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        Object objX = com.byazt.qd.hw.x(this.pr, 1);
        if (objX instanceof JSONArray) {
            ((JSONArray) objX).put(jSONObject);
        } else {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            com.byazt.qd.hw.pr(this.pr, 1, jSONArray);
        }
        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 0);
        return jSONObject2;
    }
}
