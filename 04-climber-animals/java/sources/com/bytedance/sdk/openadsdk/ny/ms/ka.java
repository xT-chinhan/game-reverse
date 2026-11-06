package com.bytedance.sdk.openadsdk.ny.ms;

import com.bytedance.sdk.component.ms.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.pc;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends com.bytedance.sdk.component.ms.d<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<pc> f4068ms;

    @Override // com.bytedance.sdk.component.ms.d
    protected void d() {
    }

    public ka(pc pcVar) {
        this.f4068ms = new WeakReference<>(pcVar);
    }

    public static void ms(h hVar, final pc pcVar) {
        hVar.ms("openPrivacy", new com.bytedance.sdk.component.ms.d.xr() { // from class: com.bytedance.sdk.openadsdk.ny.ms.ka.1
            @Override // com.bytedance.sdk.component.ms.d.xr
            public com.bytedance.sdk.component.ms.d ms() {
                return new ka(pcVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.ms.d
    public void ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        pc pcVar;
        lm lmVarX;
        WeakReference<pc> weakReference = this.f4068ms;
        if (weakReference == null || (pcVar = weakReference.get()) == null || (lmVarX = pcVar.x()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.ms(cVar.getContext(), lmVarX);
        pcVar.p();
    }
}
