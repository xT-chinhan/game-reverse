package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    private int ah;
    private int d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3063ms;
    private boolean xr;

    public l(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("window_landing");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        this.f3063ms = jSONObjectOptJSONObject.optBoolean("can_jump_to_landing", false);
        this.xr = jSONObjectOptJSONObject.optBoolean("can_click_to_landing", false);
        this.ah = jSONObjectOptJSONObject.optInt("auto_to_landing_type", 0);
        this.d = jSONObjectOptJSONObject.optInt("auto_to_landing_time", 0);
    }

    public void ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("can_jump_to_landing", this.f3063ms);
            jSONObject2.put("can_click_to_landing", this.xr);
            jSONObject2.put("auto_to_landing_type", this.ah);
            jSONObject2.put("auto_to_landing_time", this.d);
            jSONObject.put("window_landing", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.xr("parse json:" + e.getMessage());
        }
    }

    public static boolean ms(lm lmVar) {
        l lVarB = qf.b(lmVar);
        if (lVarB == null || !lVarB.f3063ms || lmVar.fm() == 1) {
            return false;
        }
        if (lmVar.fm() == 2 && lmVar.du() == 3) {
            return false;
        }
        if (lmVar.fm() == 2 && lmVar.du() == 7) {
            return false;
        }
        return (lmVar.kz() == 5 || lmVar.kz() == 15) && !TextUtils.isEmpty(ka(lmVar));
    }

    public static boolean xr(lm lmVar) {
        l lVarB = qf.b(lmVar);
        if (lVarB == null) {
            return false;
        }
        return lVarB.xr;
    }

    public static int ah(lm lmVar) {
        l lVarB = qf.b(lmVar);
        if (lVarB == null) {
            return 0;
        }
        return lVarB.ah;
    }

    public static int d(lm lmVar) {
        l lVarB = qf.b(lmVar);
        if (lVarB == null) {
            return 0;
        }
        return lVarB.d;
    }

    public static String ka(lm lmVar) {
        return lmVar == null ? "" : lmVar.ir();
    }
}
