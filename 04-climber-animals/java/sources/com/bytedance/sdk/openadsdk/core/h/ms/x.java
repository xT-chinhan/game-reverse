package com.bytedance.sdk.openadsdk.core.h.ms;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {
    private String ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private lm f2561ms;
    private com.bytedance.sdk.openadsdk.core.pc xr;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, lm lmVar, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("getEstimatedInteractionAreaInfo", (com.bytedance.sdk.component.ms.ka<?, ?>) new x(lmVar, pcVar, "getEstimatedInteractionAreaInfo"));
        hVar.ms("interactionAreaInfo", (com.bytedance.sdk.component.ms.ka<?, ?>) new x(lmVar, pcVar, "interactionAreaInfo"));
    }

    public x(lm lmVar, com.bytedance.sdk.openadsdk.core.pc pcVar, String str) {
        this.f2561ms = lmVar;
        this.xr = pcVar;
        this.ah = str;
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.nw.ao aoVarMs;
        com.bytedance.sdk.openadsdk.core.nw.ao aoVarMs2;
        JSONObject jSONObject2;
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny nyVarAh = this.xr.ah();
        String str = this.ah;
        str.hashCode();
        if (str.equals("interactionAreaInfo")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("areas");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0 || (jSONObject2 = jSONArrayOptJSONArray.getJSONObject(0)) == null) {
                aoVarMs = null;
                aoVarMs2 = null;
            } else {
                aoVarMs = com.bytedance.sdk.openadsdk.core.nw.ao.ms(jSONObject2);
                if (nyVarAh != null) {
                    nyVarAh.setEasyPlayInteractionAreaInfo(aoVarMs);
                    aoVarMs2 = com.bytedance.sdk.openadsdk.core.nw.ao.ms(nyVarAh.getEstimatedInteractionAreaInfo());
                } else {
                    aoVarMs2 = null;
                }
            }
            if (aoVarMs2 == null) {
                if (nyVarAh != null) {
                    nyVarAh.ms(com.bytedance.sdk.openadsdk.core.nw.ao.xr(null, aoVarMs), 1.0d);
                    this.xr.ms("canMakeVisiable", (JSONObject) null);
                }
            } else if (aoVarMs == null) {
                nyVarAh.ms(null, -1.0d);
                nyVarAh.ah();
                this.xr.ms("expressWebviewRecycle", (JSONObject) null);
            } else {
                double dMs = com.bytedance.sdk.openadsdk.core.nw.ao.ms(aoVarMs2, aoVarMs);
                double d = aoVarMs.ah * aoVarMs.d;
                double d2 = aoVarMs2.ah * aoVarMs2.d;
                if (d2 == 0.0d) {
                    nyVarAh.ms(com.bytedance.sdk.openadsdk.core.nw.ao.xr(aoVarMs2, aoVarMs), 1.0d);
                    this.xr.ms("canMakeVisiable", (JSONObject) null);
                    return null;
                }
                if (d == 0.0d) {
                    nyVarAh.ms(null, -1.0d);
                    nyVarAh.ah();
                    this.xr.ms("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                double d3 = dMs / d;
                boolean z = d3 >= 0.8d;
                com.bytedance.sdk.component.utils.sl.ms("xeasy", "A:" + d2 + " B:" + d + " o:" + dMs + " R:" + d3);
                if (!z) {
                    nyVarAh.ms(null, -1.0d);
                    nyVarAh.ah();
                    this.xr.ms("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                nyVarAh.ms(com.bytedance.sdk.openadsdk.core.nw.ao.xr(aoVarMs2, aoVarMs), (dMs - d2) / d2);
                this.xr.ms("canMakeVisiable", (JSONObject) null);
                return null;
            }
        } else if (str.equals("getEstimatedInteractionAreaInfo") && nyVarAh != null) {
            return nyVarAh.getEstimatedInteractionAreaInfo();
        }
        return null;
    }
}
