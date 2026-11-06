package com.bytedance.sdk.openadsdk.core.h.ms;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private lm f2537ms;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, lm lmVar) {
        hVar.ms("sendEventCode", (com.bytedance.sdk.component.ms.ka<?, ?>) new g(lmVar));
    }

    public g(lm lmVar) {
        this.f2537ms = lmVar;
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar;
        JSONObject jSONObject2 = new JSONObject();
        lm lmVar = this.f2537ms;
        if (lmVar != null && (msVar = (com.bytedance.sdk.openadsdk.ao.xr.ms.ms) com.bytedance.sdk.openadsdk.core.i.ms(lmVar.da(), com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class)) != null) {
            HashMap map = new HashMap();
            int iOptInt = jSONObject.optInt("event_code", -1);
            if (iOptInt >= 200) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("info");
                if (jSONObjectOptJSONObject != null) {
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObjectOptJSONObject.opt(next));
                    }
                }
                msVar.ms(iOptInt, map);
            }
        }
        return jSONObject2;
    }
}
