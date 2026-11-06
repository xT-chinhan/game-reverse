package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class eg {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3049ms;

    public eg(JSONObject jSONObject) {
        this.f3049ms = 0;
        if (jSONObject == null) {
            return;
        }
        this.f3049ms = jSONObject.optInt("playable_reward_type", 0);
    }

    public void ms(JSONObject jSONObject) {
        try {
            jSONObject.put("playable_reward_type", this.f3049ms);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    private static eg xr(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.qf();
    }

    public static int ms(lm lmVar) {
        int i;
        eg egVarXr = xr(lmVar);
        if (egVarXr == null || (i = egVarXr.f3049ms) < 0 || i > 1) {
            return 0;
        }
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.re.xr().ul()) || t.hi(lmVar)) {
            return egVarXr.f3049ms;
        }
        return 1;
    }

    public static int ms(lm lmVar, int i) {
        com.bykv.vk.openvk.component.video.api.ah.ah ahVarMs = qr.ms(lmVar, i);
        String strNy = ahVarMs != null ? ahVarMs.ny() : null;
        try {
            if (TextUtils.isEmpty(strNy)) {
                return 0;
            }
            String[] strArrSplit = strNy.split("x");
            if (strArrSplit.length >= 2 && Integer.parseInt(strArrSplit[0]) > Integer.parseInt(strArrSplit[1])) {
                return 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }
}
