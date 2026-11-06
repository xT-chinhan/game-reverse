package com.byazt.vs;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy extends com.byazt.cf.l<JSONObject, JSONObject> {
    public WeakReference<com.byazt.gcl.s> n;
    public com.byazt.gct.pk qg;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gct.pk pkVar, com.byazt.gcl.s sVar) {
        cyVar.n("getDeviceInfo", (com.byazt.cf.l<?, ?>) new cy(sVar, pkVar));
    }

    public cy(com.byazt.gcl.s sVar, com.byazt.gct.pk pkVar) {
        this.n = new WeakReference<>(sVar);
        this.qg = pkVar;
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt("safeArea", s());
        com.byazt.gct.pk pkVar = this.qg;
        if (pkVar != null) {
            jSONObject2.put("disableSafeArea", pkVar.lh());
        }
        return jSONObject2;
    }

    private JSONObject s() {
        com.byazt.gcl.s sVar;
        Context context;
        Window window;
        View decorView;
        WindowInsets rootWindowInsets;
        WeakReference<com.byazt.gcl.s> weakReference = this.n;
        if (weakReference == null || (sVar = weakReference.get()) == null || (context = sVar.getContext()) == null || !(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || (decorView = window.getDecorView()) == null || Build.VERSION.SDK_INT < 28 || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
            return null;
        }
        DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("top", displayCutout.getSafeInsetTop());
            jSONObject.put("bottom", displayCutout.getSafeInsetBottom());
            jSONObject.put("left", displayCutout.getSafeInsetLeft());
            jSONObject.put("right", displayCutout.getSafeInsetRight());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
