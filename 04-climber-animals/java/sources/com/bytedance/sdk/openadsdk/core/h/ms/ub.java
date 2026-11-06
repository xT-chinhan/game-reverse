package com.bytedance.sdk.openadsdk.core.h.ms;

import com.bytedance.sdk.openadsdk.core.nw.az;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ub extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private lm f2559ms;

    public ub(lm lmVar) {
        this.f2559ms = lmVar;
    }

    public static void ms(com.bytedance.sdk.component.ms.h hVar, lm lmVar) {
        hVar.ms("getLiveSaasAuthStatus", (com.bytedance.sdk.component.ms.ka<?, ?>) new ub(lmVar));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        az azVarMs;
        lm lmVar;
        JSONObject jSONObject2 = new JSONObject();
        com.bytedance.sdk.openadsdk.core.nw.h hVar = null;
        if (jSONObject != null) {
            try {
                azVarMs = az.ms(jSONObject.optJSONObject("live_info"));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("deep_link");
                if (jSONObjectOptJSONObject != null) {
                    hVar = new com.bytedance.sdk.openadsdk.core.nw.h(jSONObjectOptJSONObject);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.d("glsas", "method:" + th.getMessage());
            }
        } else {
            azVarMs = null;
        }
        if (hVar == null && (lmVar = this.f2559ms) != null) {
            hVar = lmVar.tc();
        }
        if (azVarMs == null) {
            azVarMs = this.f2559ms.ml();
        }
        boolean z = true;
        jSONObject2.put("has_live_silent_auth", azVarMs != null && azVarMs.ah());
        jSONObject2.put("has_install_douyin", com.bytedance.sdk.openadsdk.core.live.ka.ms.ms(hVar));
        jSONObject2.put("has_live_authed", com.bytedance.sdk.openadsdk.core.live.xr.ms().ka() == 2);
        boolean z2 = azVarMs != null && azVarMs.d();
        if (z2) {
            if (com.bytedance.sdk.openadsdk.core.live.xr.ms().ah() != 2) {
                z = false;
            }
            z2 = z;
        }
        jSONObject2.put("has_playable_auth_switch", z2);
        JSONObject jSONObject3 = new JSONObject();
        if (azVarMs != null) {
            jSONObject3.put("aweme_agreements", azVarMs.ka());
            jSONObject3.put("aweme_privacy", azVarMs.c());
        }
        jSONObject2.put("aweme_auth_protocol", jSONObject3);
        return jSONObject2;
    }
}
