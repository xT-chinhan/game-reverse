package com.bytedance.sdk.openadsdk.core.h.ms;

import com.bytedance.sdk.component.widget.SSWebView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private SSWebView f2524ms;
    private String xr;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, SSWebView sSWebView, String str) {
        hVar.ms("start_wobble_observer", (com.bytedance.sdk.component.ms.ka<?, ?>) new ah(sSWebView, str));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        return ah();
    }

    public ah(SSWebView sSWebView, String str) {
        this.f2524ms = sSWebView;
        this.xr = str;
    }

    public JSONObject ah() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.bytedance.sdk.openadsdk.core.ch.ub().ms(com.bytedance.sdk.openadsdk.core.re.getContext()) && this.f2524ms != null) {
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "success");
                this.f2524ms.ms(1, com.bytedance.sdk.openadsdk.core.ch.ub().ka());
                return jSONObject;
            }
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "unavailable");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
