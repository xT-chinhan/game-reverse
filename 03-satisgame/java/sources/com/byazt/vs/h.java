package com.byazt.vs;

import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 878})
public class h extends com.byazt.cf.l<JSONObject, JSONObject> {
    public String n;
    public com.byazt.gcl.s qg;

    public h(String str, com.byazt.gcl.s sVar) {
        this.qg = sVar;
        this.n = str;
    }

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar) {
        cyVar.n("appInfo", (com.byazt.cf.l<?, ?>) new h("appInfo", sVar));
        cyVar.n("adInfo", (com.byazt.cf.l<?, ?>) new h("adInfo", sVar));
        cyVar.n("getTemplateInfo", (com.byazt.cf.l<?, ?>) new h("getTemplateInfo", sVar));
        cyVar.n("getTeMaiAds", (com.byazt.cf.l<?, ?>) new h("getTeMaiAds", sVar));
        cyVar.n("isViewable", (com.byazt.cf.l<?, ?>) new h("isViewable", sVar));
        cyVar.n("getScreenSize", (com.byazt.cf.l<?, ?>) new h("getScreenSize", sVar));
        cyVar.n("getCloseButtonInfo", (com.byazt.cf.l<?, ?>) new h("getCloseButtonInfo", sVar));
        cyVar.n("getVolume", (com.byazt.cf.l<?, ?>) new h("getVolume", sVar));
        cyVar.n("sendReward", (com.byazt.cf.l<?, ?>) new h("sendReward", sVar));
        cyVar.n("subscribe_app_ad", (com.byazt.cf.l<?, ?>) new h("subscribe_app_ad", sVar));
        cyVar.n("download_app_ad", (com.byazt.cf.l<?, ?>) new h("download_app_ad", sVar));
        cyVar.n("cancel_download_app_ad", (com.byazt.cf.l<?, ?>) new h("cancel_download_app_ad", sVar));
        cyVar.n("unsubscribe_app_ad", (com.byazt.cf.l<?, ?>) new h("unsubscribe_app_ad", sVar));
        cyVar.n("clickEvent", (com.byazt.cf.l<?, ?>) new h("clickEvent", sVar));
        cyVar.n("renderDidFinish", (com.byazt.cf.l<?, ?>) new h("renderDidFinish", sVar));
        cyVar.n("dynamicTrack", (com.byazt.cf.l<?, ?>) new h("dynamicTrack", sVar));
        cyVar.n("skipVideo", (com.byazt.cf.l<?, ?>) new h("skipVideo", sVar));
        cyVar.n("muteVideo", (com.byazt.cf.l<?, ?>) new h("muteVideo", sVar));
        cyVar.n("changeVideoState", (com.byazt.cf.l<?, ?>) new h("changeVideoState", sVar));
        cyVar.n("getCurrentVideoState", (com.byazt.cf.l<?, ?>) new h("getCurrentVideoState", sVar));
        cyVar.n("send_temai_product_ids", (com.byazt.cf.l<?, ?>) new h("send_temai_product_ids", sVar));
        cyVar.n("getMaterialMeta", (com.byazt.cf.l<?, ?>) new h("getMaterialMeta", sVar));
        cyVar.n("endcard_load", (com.byazt.cf.l<?, ?>) new h("endcard_load", sVar));
        cyVar.n("pauseWebView", (com.byazt.cf.l<?, ?>) new h("pauseWebView", sVar));
        cyVar.n("pauseWebViewTimers", (com.byazt.cf.l<?, ?>) new h("pauseWebViewTimers", sVar));
        cyVar.n("webview_time_track", (com.byazt.cf.l<?, ?>) new h("webview_time_track", sVar));
        cyVar.n("adInfoStash", (com.byazt.cf.l<?, ?>) new h("adInfoStash", sVar));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        com.byazt.gcl.s.n nVar = new com.byazt.gcl.s.n();
        nVar.n = NotificationCompat.CATEGORY_CALL;
        nVar.s = this.n;
        nVar.q = jSONObject;
        return this.qg.n(nVar, 3);
    }
}
