package com.bytedance.sdk.openadsdk.core.nw;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pc {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3085ms;
    private int xr;

    public pc(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("landing_page_conf");
        if (jSONObjectOptJSONObject != null) {
            this.f3085ms = jSONObjectOptJSONObject.optInt("swipe_back_type", 0) == 1;
            this.xr = jSONObjectOptJSONObject.optInt("filter_track", 0);
        }
    }

    public void ms(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("swipe_back_type", this.f3085ms ? 1 : 0);
            jSONObject2.put("filter_track", this.xr);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        try {
            jSONObject.put("landing_page_conf", jSONObject2);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.sl.ms(e2);
        }
    }

    private static pc ah(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.kh();
    }

    public static boolean ms(lm lmVar) {
        pc pcVarAh = ah(lmVar);
        if (pcVarAh == null) {
            return false;
        }
        return pcVarAh.f3085ms;
    }

    public static boolean xr(lm lmVar) {
        pc pcVarAh = ah(lmVar);
        return pcVarAh != null && pcVarAh.xr == 1;
    }
}
