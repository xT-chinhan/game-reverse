package com.bytedance.sdk.openadsdk.core.h.ms;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zb extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.pc> f2567ms;
    private lm xr;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, lm lmVar, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("getDeviceInfo", (com.bytedance.sdk.component.ms.ka<?, ?>) new zb(pcVar, lmVar));
    }

    public zb(com.bytedance.sdk.openadsdk.core.pc pcVar, lm lmVar) {
        this.f2567ms = new WeakReference<>(pcVar);
        this.xr = lmVar;
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt("safeArea", ah());
        lm lmVar = this.xr;
        if (lmVar != null) {
            jSONObject2.put("disableSafeArea", lmVar.d());
        }
        return jSONObject2;
    }

    private JSONObject ah() {
        com.bytedance.sdk.openadsdk.core.pc pcVar;
        Context context;
        Window window;
        View decorView;
        WindowInsets rootWindowInsets;
        WeakReference<com.bytedance.sdk.openadsdk.core.pc> weakReference = this.f2567ms;
        if (weakReference == null || (pcVar = weakReference.get()) == null || (context = pcVar.getContext()) == null || !(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || (decorView = window.getDecorView()) == null || Build.VERSION.SDK_INT < 28 || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
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
