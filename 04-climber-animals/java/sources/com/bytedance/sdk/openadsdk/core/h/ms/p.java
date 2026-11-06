package com.bytedance.sdk.openadsdk.core.h.ms;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p extends com.bytedance.sdk.component.ms.d<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.pc> f2552ms;

    @Override // com.bytedance.sdk.component.ms.d
    protected void d() {
    }

    public static void ms(com.bytedance.sdk.component.ms.h hVar, final com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("showAppDetailOrPrivacyDialog", new com.bytedance.sdk.component.ms.d.xr() { // from class: com.bytedance.sdk.openadsdk.core.h.ms.p.1
            @Override // com.bytedance.sdk.component.ms.d.xr
            public com.bytedance.sdk.component.ms.d ms() {
                return new p(pcVar);
            }
        });
    }

    public p(com.bytedance.sdk.openadsdk.core.pc pcVar) {
        this.f2552ms = new WeakReference<>(pcVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.ms.d
    public void ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.ch.ub().fm();
        WeakReference<com.bytedance.sdk.openadsdk.core.pc> weakReference = this.f2552ms;
        if (weakReference == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pc pcVar = weakReference.get();
        if (pcVar == null) {
            ah();
            return;
        }
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("show_dialog_style");
        if (iOptInt == 1) {
            pcVar.re();
        } else if (iOptInt == 2) {
            pcVar.b();
        }
    }
}
