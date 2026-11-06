package com.bytedance.sdk.openadsdk.core.h.ms;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends com.bytedance.sdk.component.ms.d<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.pc> f2522ms;

    @Override // com.bytedance.sdk.component.ms.d
    protected void d() {
    }

    public static void ms(com.bytedance.sdk.component.ms.h hVar, final com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("newClickEvent", new com.bytedance.sdk.component.ms.d.xr() { // from class: com.bytedance.sdk.openadsdk.core.h.ms.ab.1
            @Override // com.bytedance.sdk.component.ms.d.xr
            public com.bytedance.sdk.component.ms.d ms() {
                return new ab(pcVar);
            }
        });
    }

    public ab(com.bytedance.sdk.openadsdk.core.pc pcVar) {
        this.f2522ms = new WeakReference<>(pcVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.ms.d
    public void ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.pc pcVar = this.f2522ms.get();
        if (pcVar == null) {
            ah();
        } else {
            pcVar.ch(jSONObject);
        }
    }
}
