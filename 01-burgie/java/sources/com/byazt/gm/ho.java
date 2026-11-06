package com.byazt.gm;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 19})
public class ho extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.hg.of hw;
    public WeakReference<com.byazt.sd.nl> pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.hg.of ofVar, com.byazt.sd.nl nlVar) {
        ybVar.pr("getDeviceInfo", (com.byazt.ee.c<?, ?>) new ho(nlVar, ofVar));
    }

    public ho(com.byazt.sd.nl nlVar, com.byazt.hg.of ofVar) {
        this.pr = new WeakReference<>(nlVar);
        this.hw = ofVar;
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt("safeArea", hn());
        com.byazt.hg.of ofVar = this.hw;
        if (ofVar != null) {
            jSONObject2.put("disableSafeArea", ofVar.gz());
        }
        return jSONObject2;
    }

    private JSONObject hn() {
        com.byazt.sd.nl nlVar;
        Context context;
        Window window;
        View decorView;
        WindowInsets rootWindowInsets;
        WeakReference<com.byazt.sd.nl> weakReference = this.pr;
        if (weakReference == null || (nlVar = weakReference.get()) == null || (context = nlVar.getContext()) == null || !(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || (decorView = window.getDecorView()) == null || Build.VERSION.SDK_INT < 28 || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
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
