package com.bytedance.sdk.openadsdk.core.h.ms;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.bytedance.sdk.component.ms.d<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.qv.ah ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.pc> f2527ms;
    private lm xr;

    @Override // com.bytedance.sdk.component.ms.d
    protected void d() {
    }

    public static void ms(com.bytedance.sdk.component.ms.h hVar, final com.bytedance.sdk.openadsdk.core.pc pcVar, final lm lmVar) {
        hVar.ms("getNetworkData", new com.bytedance.sdk.component.ms.d.xr() { // from class: com.bytedance.sdk.openadsdk.core.h.ms.c.1
            @Override // com.bytedance.sdk.component.ms.d.xr
            public com.bytedance.sdk.component.ms.d ms() {
                return new c(pcVar, lmVar);
            }
        });
    }

    public c(com.bytedance.sdk.openadsdk.core.pc pcVar, lm lmVar) {
        this.f2527ms = new WeakReference<>(pcVar);
        this.xr = lmVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.ms.d
    public void ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.pc pcVar = this.f2527ms.get();
        if (pcVar == null) {
            ah();
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.ah = new com.bytedance.sdk.openadsdk.core.qv.ah() { // from class: com.bytedance.sdk.openadsdk.core.h.ms.c.2
            @Override // com.bytedance.sdk.openadsdk.core.qv.ah
            public void ms(boolean z, List<lm> list, boolean z2) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!z) {
                        c.this.ms(jSONObject2);
                    } else {
                        jSONObject2.put("creatives", com.bytedance.sdk.openadsdk.core.pc.ms(list));
                        jSONObject2.put("is_cache", z2);
                        if (z2) {
                            jSONObject2.put("prefetch_opt_time", jCurrentTimeMillis - com.bytedance.sdk.openadsdk.core.playable.xr.ms().ah(c.this.xr));
                        }
                        c.this.ms(jSONObject2);
                    }
                    com.bytedance.sdk.openadsdk.core.ch.ub().fm();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.ah("DoGetAdsFromNetwork", "onAdLoaded error", th);
                }
            }
        };
        if ((jSONObject != null && jSONObject.optBoolean("is_first_request", false)) && com.bytedance.sdk.openadsdk.core.playable.xr.ms().ms(this.xr, this.ah)) {
            return;
        }
        pcVar.ms(jSONObject, this.ah);
    }
}
