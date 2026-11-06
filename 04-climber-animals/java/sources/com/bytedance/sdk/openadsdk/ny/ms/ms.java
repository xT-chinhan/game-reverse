package com.bytedance.sdk.openadsdk.ny.ms;

import com.bytedance.sdk.component.ms.h;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.pc;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends com.bytedance.sdk.component.ms.d<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<pc> f4070ms;

    @Override // com.bytedance.sdk.component.ms.d
    protected void d() {
    }

    public static void ms(h hVar, final pc pcVar) {
        hVar.ms("interstitial_webview_close", new com.bytedance.sdk.component.ms.d.xr() { // from class: com.bytedance.sdk.openadsdk.ny.ms.ms.1
            @Override // com.bytedance.sdk.component.ms.d.xr
            public com.bytedance.sdk.component.ms.d ms() {
                return new ms(pcVar);
            }
        });
    }

    public ms(pc pcVar) {
        this.f4070ms = new WeakReference<>(pcVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.ms.d
    public void ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        ch.ub().fm();
        sl.d("DoInterstitialWebViewCloseMethod", "DoInterstitialWebViewCloseMethod invoke ");
        pc pcVar = this.f4070ms.get();
        if (pcVar == null) {
            sl.d("DoInterstitialWebViewCloseMethod", "invoke error");
            ah();
        } else {
            pcVar.u();
        }
    }
}
