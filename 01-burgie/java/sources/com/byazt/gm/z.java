package com.byazt.gm;

import android.support.v4.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 110})
public class z extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.sd.nl hw;
    public String pr;

    public z(String str, com.byazt.sd.nl nlVar) {
        this.hw = nlVar;
        this.pr = str;
    }

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("appInfo", (com.byazt.ee.c<?, ?>) new z("appInfo", nlVar));
        ybVar.pr("adInfo", (com.byazt.ee.c<?, ?>) new z("adInfo", nlVar));
        ybVar.pr("getTemplateInfo", (com.byazt.ee.c<?, ?>) new z("getTemplateInfo", nlVar));
        ybVar.pr("getTeMaiAds", (com.byazt.ee.c<?, ?>) new z("getTeMaiAds", nlVar));
        ybVar.pr("isViewable", (com.byazt.ee.c<?, ?>) new z("isViewable", nlVar));
        ybVar.pr("getScreenSize", (com.byazt.ee.c<?, ?>) new z("getScreenSize", nlVar));
        ybVar.pr("getCloseButtonInfo", (com.byazt.ee.c<?, ?>) new z("getCloseButtonInfo", nlVar));
        ybVar.pr("getVolume", (com.byazt.ee.c<?, ?>) new z("getVolume", nlVar));
        ybVar.pr("sendReward", (com.byazt.ee.c<?, ?>) new z("sendReward", nlVar));
        ybVar.pr("subscribe_app_ad", (com.byazt.ee.c<?, ?>) new z("subscribe_app_ad", nlVar));
        ybVar.pr("download_app_ad", (com.byazt.ee.c<?, ?>) new z("download_app_ad", nlVar));
        ybVar.pr("cancel_download_app_ad", (com.byazt.ee.c<?, ?>) new z("cancel_download_app_ad", nlVar));
        ybVar.pr("unsubscribe_app_ad", (com.byazt.ee.c<?, ?>) new z("unsubscribe_app_ad", nlVar));
        ybVar.pr("clickEvent", (com.byazt.ee.c<?, ?>) new z("clickEvent", nlVar));
        ybVar.pr("renderDidFinish", (com.byazt.ee.c<?, ?>) new z("renderDidFinish", nlVar));
        ybVar.pr("dynamicTrack", (com.byazt.ee.c<?, ?>) new z("dynamicTrack", nlVar));
        ybVar.pr("skipVideo", (com.byazt.ee.c<?, ?>) new z("skipVideo", nlVar));
        ybVar.pr("muteVideo", (com.byazt.ee.c<?, ?>) new z("muteVideo", nlVar));
        ybVar.pr("changeVideoState", (com.byazt.ee.c<?, ?>) new z("changeVideoState", nlVar));
        ybVar.pr("getCurrentVideoState", (com.byazt.ee.c<?, ?>) new z("getCurrentVideoState", nlVar));
        ybVar.pr("send_temai_product_ids", (com.byazt.ee.c<?, ?>) new z("send_temai_product_ids", nlVar));
        ybVar.pr("getMaterialMeta", (com.byazt.ee.c<?, ?>) new z("getMaterialMeta", nlVar));
        ybVar.pr("endcard_load", (com.byazt.ee.c<?, ?>) new z("endcard_load", nlVar));
        ybVar.pr("pauseWebView", (com.byazt.ee.c<?, ?>) new z("pauseWebView", nlVar));
        ybVar.pr("pauseWebViewTimers", (com.byazt.ee.c<?, ?>) new z("pauseWebViewTimers", nlVar));
        ybVar.pr("webview_time_track", (com.byazt.ee.c<?, ?>) new z("webview_time_track", nlVar));
        ybVar.pr("adInfoStash", (com.byazt.ee.c<?, ?>) new z("adInfoStash", nlVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        com.byazt.sd.nl.pr prVar = new com.byazt.sd.nl.pr();
        prVar.pr = NotificationCompat.CATEGORY_CALL;
        prVar.hn = this.pr;
        prVar.x = jSONObject;
        return this.hw.pr(prVar, 3);
    }
}
