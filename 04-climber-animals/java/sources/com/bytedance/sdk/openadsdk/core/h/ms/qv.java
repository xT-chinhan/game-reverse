package com.bytedance.sdk.openadsdk.core.h.ms;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class qv extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final WeakReference<com.bytedance.sdk.openadsdk.core.pc> f2555ms;
    private final String xr;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("interactiveStart", (com.bytedance.sdk.component.ms.ka<?, ?>) new qv(pcVar, "interactiveStart"));
        hVar.ms("interactiveFinish", (com.bytedance.sdk.component.ms.ka<?, ?>) new qv(pcVar, "interactiveFinish"));
        hVar.ms("interactiveEnd", (com.bytedance.sdk.component.ms.ka<?, ?>) new qv(pcVar, "interactiveEnd"));
    }

    public qv(com.bytedance.sdk.openadsdk.core.pc pcVar, String str) {
        this.f2555ms = new WeakReference<>(pcVar);
        this.xr = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        if (this.f2555ms.get() == null) {
            return jSONObject2;
        }
        com.bytedance.sdk.openadsdk.core.pc pcVar = this.f2555ms.get();
        lm lmVarX = pcVar.x();
        String str = this.xr;
        str.hashCode();
        int i = 0;
        boolean z = true;
        switch (str) {
            case "interactiveStart":
                pcVar.ub();
                return jSONObject2;
            case "interactiveEnd":
                pcVar.ao();
                return jSONObject2;
            case "interactiveFinish":
                try {
                    if (jSONObject.optInt("finish", 1) != 1) {
                        z = false;
                    }
                    int iMs = ms(lmVarX, jSONObject.optInt("reduce_duration", -1));
                    if (z) {
                        pcVar.d(iMs);
                    } else {
                        i = -1;
                    }
                    jSONObject2.put("code", i);
                    jSONObject2.put("reduce_duration", iMs);
                    break;
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }

    public static int ms(lm lmVar, int i) {
        int iPq = lmVar != null ? lmVar.pq() : 0;
        if (i >= 0 && iPq >= 0) {
            i = Math.min(i, iPq);
        } else if (i < 0) {
            i = iPq >= 0 ? iPq : 0;
        }
        if (qf.ka(lmVar)) {
            return 0;
        }
        return i;
    }
}
