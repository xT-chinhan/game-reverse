package com.bytedance.sdk.openadsdk.core.h.ms;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private lm f2530ms;
    private List<JSONObject> xr;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, lm lmVar, List<JSONObject> list) {
        hVar.ms("getAdsData", (com.bytedance.sdk.component.ms.ka<?, ?>) new ch(lmVar, list));
    }

    public ch(lm lmVar, List<JSONObject> list) {
        this.f2530ms = lmVar;
        this.xr = list;
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        int iOptInt = jSONObject != null ? jSONObject.optInt("ads_num", 3) : -1;
        if (iOptInt < 0) {
            iOptInt = 3;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("creatives", new JSONArray().put(this.f2530ms.rm()));
        jSONObject2.put("firstRes", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        List<JSONObject> list = this.xr;
        if (list != null && list.size() > 0) {
            if (iOptInt > this.xr.size()) {
                iOptInt = this.xr.size();
            }
            int iMin = Math.min(iOptInt, 3);
            for (int i = 0; i < iMin; i++) {
                jSONArray.put(i, this.xr.get(i));
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
