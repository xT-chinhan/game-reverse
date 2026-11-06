package com.byazt.vs;

import com.byazt.kfh.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 984})
public class v extends com.byazt.cf.l<JSONObject, JSONObject> {
    public WeakReference<SSWebView> n;

    public static void n(com.byazt.cf.cy cyVar, SSWebView sSWebView) {
        cyVar.n("preventTouchEvent", (com.byazt.cf.l<?, ?>) new v(sSWebView));
    }

    public v(SSWebView sSWebView) {
        this.n = new WeakReference<>(sSWebView);
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isPrevent", false);
            SSWebView sSWebView = this.n.get();
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
