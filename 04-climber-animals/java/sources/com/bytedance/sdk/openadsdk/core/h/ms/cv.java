package com.bytedance.sdk.openadsdk.core.h.ms;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class cv extends com.bytedance.sdk.component.ms.d<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.pc> f2531ms;

    @Override // com.bytedance.sdk.component.ms.d
    protected void d() {
    }

    public static void ms(com.bytedance.sdk.component.ms.h hVar, final com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("commonConvert", new com.bytedance.sdk.component.ms.d.xr() { // from class: com.bytedance.sdk.openadsdk.core.h.ms.cv.1
            @Override // com.bytedance.sdk.component.ms.d.xr
            public com.bytedance.sdk.component.ms.d ms() {
                return new cv(pcVar);
            }
        });
    }

    public cv(com.bytedance.sdk.openadsdk.core.pc pcVar) {
        this.f2531ms = new WeakReference<>(pcVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.ms.d
    public void ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.ugeno.ny.ms msVarLe;
        JSONObject jSONObjectXr;
        com.bytedance.sdk.openadsdk.core.ch.ub().fm();
        JSONObject jSONObject2 = new JSONObject();
        try {
            WeakReference<com.bytedance.sdk.openadsdk.core.pc> weakReference = this.f2531ms;
            if (weakReference == null) {
                com.bytedance.sdk.openadsdk.core.t.u.ms().ms("commonConvert", "js", 1, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.xr.ms().d(null);
                return;
            }
            com.bytedance.sdk.openadsdk.core.pc pcVar = weakReference.get();
            if (pcVar == null) {
                ah();
                com.bytedance.sdk.openadsdk.core.t.u.ms().ms("commonConvert", "js", 2, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.xr.ms().d(null);
                return;
            }
            if (jSONObject == null) {
                com.bytedance.sdk.openadsdk.core.t.u.ms().ms("commonConvert", "js", 3, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.xr.ms().d(null);
                return;
            }
            lm lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(jSONObject);
            int iOptInt = jSONObject.optInt("j_live_saas_param_interaction_type", -1);
            if (lmVarMs == null) {
                com.bytedance.sdk.openadsdk.core.t.u.ms().ms("commonConvert", "js", 4, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.xr.ms().d(lmVarMs);
                return;
            }
            lmVarMs.ms(true);
            jSONObject2.putOpt("live_interaction_type", Integer.valueOf(lmVarMs.ku()));
            jSONObject2.putOpt("ext", lmVarMs.lx());
            if (lmVarMs.rn() == null && (msVarLe = lmVarMs.le()) != null && (jSONObjectXr = msVarLe.xr()) != null) {
                lmVarMs.ms(com.bytedance.sdk.openadsdk.core.nw.u.ms(jSONObjectXr));
            }
            pcVar.ms(lmVarMs, iOptInt);
            com.bytedance.sdk.openadsdk.core.t.u.ms().ms("commonConvert", "js", 0, jSONObject2);
            com.bytedance.sdk.openadsdk.core.live.xr.ms().d(lmVarMs);
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 200);
                ms(jSONObject3);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms("xeasy", e.getMessage());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.core.t.u.ms().ms("commonConvert", "js", 0, jSONObject2);
            com.bytedance.sdk.openadsdk.core.live.xr.ms().d(null);
            throw th;
        }
    }
}
