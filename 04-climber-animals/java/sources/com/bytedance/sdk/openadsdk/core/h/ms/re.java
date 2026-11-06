package com.bytedance.sdk.openadsdk.core.h.ms;

import com.bytedance.sdk.component.widget.SSWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class re extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<SSWebView> f2556ms;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, SSWebView sSWebView) {
        hVar.ms("preventTouchEvent", (com.bytedance.sdk.component.ms.ka<?, ?>) new re(sSWebView));
    }

    public re(SSWebView sSWebView) {
        this.f2556ms = new WeakReference<>(sSWebView);
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isPrevent", false);
            SSWebView sSWebView = this.f2556ms.get();
            if (sSWebView != null) {
                sSWebView.setIsPreventTouchEvent(zOptBoolean);
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        } catch (Throwable unused) {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
