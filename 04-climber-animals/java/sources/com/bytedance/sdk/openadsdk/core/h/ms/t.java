package com.bytedance.sdk.openadsdk.core.h.ms;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class t extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f2558ms;
    private com.bytedance.sdk.openadsdk.core.pc xr;

    public t(String str, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        this.xr = pcVar;
        this.f2558ms = str;
    }

    public static void ms(com.bytedance.sdk.component.ms.h hVar, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("appInfo", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("appInfo", pcVar));
        hVar.ms("adInfo", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("adInfo", pcVar));
        hVar.ms("getTemplateInfo", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("getTemplateInfo", pcVar));
        hVar.ms("getTeMaiAds", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("getTeMaiAds", pcVar));
        hVar.ms("isViewable", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("isViewable", pcVar));
        hVar.ms("getScreenSize", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("getScreenSize", pcVar));
        hVar.ms("getCloseButtonInfo", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("getCloseButtonInfo", pcVar));
        hVar.ms("getVolume", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("getVolume", pcVar));
        hVar.ms("sendReward", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("sendReward", pcVar));
        hVar.ms("subscribe_app_ad", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("subscribe_app_ad", pcVar));
        hVar.ms("download_app_ad", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("download_app_ad", pcVar));
        hVar.ms("cancel_download_app_ad", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("cancel_download_app_ad", pcVar));
        hVar.ms("unsubscribe_app_ad", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("unsubscribe_app_ad", pcVar));
        hVar.ms("clickEvent", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("clickEvent", pcVar));
        hVar.ms("renderDidFinish", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("renderDidFinish", pcVar));
        hVar.ms("dynamicTrack", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("dynamicTrack", pcVar));
        hVar.ms("skipVideo", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("skipVideo", pcVar));
        hVar.ms("muteVideo", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("muteVideo", pcVar));
        hVar.ms("changeVideoState", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("changeVideoState", pcVar));
        hVar.ms("getCurrentVideoState", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("getCurrentVideoState", pcVar));
        hVar.ms("send_temai_product_ids", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("send_temai_product_ids", pcVar));
        hVar.ms("getMaterialMeta", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("getMaterialMeta", pcVar));
        hVar.ms("endcard_load", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("endcard_load", pcVar));
        hVar.ms("pauseWebView", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("pauseWebView", pcVar));
        hVar.ms("pauseWebViewTimers", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("pauseWebViewTimers", pcVar));
        hVar.ms("webview_time_track", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("webview_time_track", pcVar));
        hVar.ms("adInfoStash", (com.bytedance.sdk.component.ms.ka<?, ?>) new t("adInfoStash", pcVar));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.pc.ms msVar = new com.bytedance.sdk.openadsdk.core.pc.ms();
        msVar.f3269ms = NotificationCompat.CATEGORY_CALL;
        msVar.ah = this.f2558ms;
        msVar.d = jSONObject;
        return this.xr.ms(msVar, 3);
    }
}
