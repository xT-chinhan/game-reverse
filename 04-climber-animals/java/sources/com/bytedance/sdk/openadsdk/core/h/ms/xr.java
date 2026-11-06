package com.bytedance.sdk.openadsdk.core.h.ms;

import com.bytedance.sdk.component.widget.SSWebView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private SSWebView f2562ms;
    private String xr;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, SSWebView sSWebView, String str) {
        hVar.ms("start_twist_observer", (com.bytedance.sdk.component.ms.ka<?, ?>) new xr(sSWebView, str));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        return ah();
    }

    public xr(SSWebView sSWebView, String str) {
        this.f2562ms = sSWebView;
        this.xr = str;
    }

    public JSONObject ah() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.bytedance.sdk.openadsdk.core.ch.ub().xr(com.bytedance.sdk.openadsdk.core.re.getContext()) && this.f2562ms != null) {
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "success");
                this.f2562ms.ms(2, com.bytedance.sdk.openadsdk.core.ch.ub().ka());
                return jSONObject;
            }
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "unavailable");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
