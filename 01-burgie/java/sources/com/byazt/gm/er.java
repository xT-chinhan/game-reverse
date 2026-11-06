package com.byazt.gm;

import com.byazt.mg.PluginConstants;
import com.bytedance.android.live.base.api.push.ILivePush;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 1620})
public class er extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.sd.nl hw;
    public final String pr;

    public er(com.byazt.sd.nl nlVar, String str) {
        this.hw = nlVar;
        this.pr = str;
    }

    public static void pr(com.byazt.sd.nl nlVar, com.byazt.ee.yb ybVar, com.byazt.hg.of ofVar) {
        ybVar.pr("sendElement", (com.byazt.ee.c<?, ?>) new er(nlVar, ofVar.z()));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (this.hw != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray(ILivePush.ClickType.CLOSE)) != null && jSONArrayOptJSONArray.length() > 0 && (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) != null) {
            this.hw.hw(jSONObjectOptJSONObject.optInt("x"), jSONObjectOptJSONObject.optInt("y"), jSONObjectOptJSONObject.optInt("width"), jSONObjectOptJSONObject.optInt("height"));
        }
        com.byazt.qd.hw.pr(this.pr, 0, jSONObject);
        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 0);
        return jSONObject2;
    }
}
