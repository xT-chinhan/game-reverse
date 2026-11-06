package com.byazt.gm;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 250})
public class k extends com.byazt.ee.c<JSONObject, JSONObject> {
    public List<JSONObject> hw;
    public com.byazt.hg.of pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.hg.of ofVar, List<JSONObject> list) {
        ybVar.pr("getAdsData", (com.byazt.ee.c<?, ?>) new k(ofVar, list));
    }

    public k(com.byazt.hg.of ofVar, List<JSONObject> list) {
        this.pr = ofVar;
        this.hw = list;
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        int iOptInt = jSONObject != null ? jSONObject.optInt("ads_num", 3) : -1;
        if (iOptInt < 0) {
            iOptInt = 3;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("creatives", new JSONArray().put(this.pr.to()));
        jSONObject2.put("firstRes", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        List<JSONObject> list = this.hw;
        if (list != null && list.size() > 0) {
            if (iOptInt > this.hw.size()) {
                iOptInt = this.hw.size();
            }
            int iMin = Math.min(iOptInt, 3);
            for (int i = 0; i < iMin; i++) {
                jSONArray.put(i, this.hw.get(i));
            }
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("creatives", jSONArray);
        jSONObject2.put("secondRes", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("data", jSONObject2);
        return jSONObject5;
    }
}
