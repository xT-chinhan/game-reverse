package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 767})
public class l {
    public int hn;
    public boolean hw;
    public boolean pr;
    public int x;

    public l(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("window_landing");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        this.pr = jSONObjectOptJSONObject.optBoolean("can_jump_to_landing", false);
        this.hw = jSONObjectOptJSONObject.optBoolean("can_click_to_landing", false);
        this.hn = jSONObjectOptJSONObject.optInt("auto_to_landing_type", 0);
        this.x = jSONObjectOptJSONObject.optInt("auto_to_landing_time", 0);
    }

    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("can_jump_to_landing", this.pr);
            jSONObject2.put("can_click_to_landing", this.hw);
            jSONObject2.put("auto_to_landing_type", this.hn);
            jSONObject2.put("auto_to_landing_time", this.x);
            jSONObject.put("window_landing", jSONObject2);
        } catch (JSONException e) {
            com.byazt.ca.ho.pr("parse json:" + e.getMessage());
        }
    }

    public static boolean pr(of ofVar) {
        l lVarNy = jn.ny(ofVar);
        if (lVarNy == null || !lVarNy.pr || ie.pr(ofVar) == 1) {
            return false;
        }
        if (ie.pr(ofVar) == 2 && ie.hn(ofVar) == 3) {
            return false;
        }
        if (ie.pr(ofVar) == 2 && ie.hn(ofVar) == 7) {
            return false;
        }
        return (ofVar.jg() == 5 || ofVar.jg() == 15) && !TextUtils.isEmpty(c(ofVar));
    }

    public static boolean hw(of ofVar) {
        l lVarNy = jn.ny(ofVar);
        if (lVarNy == null) {
            return false;
        }
        return lVarNy.hw;
    }

    public static int hn(of ofVar) {
        l lVarNy = jn.ny(ofVar);
        if (lVarNy == null) {
            return 0;
        }
        return lVarNy.hn;
    }

    public static int x(of ofVar) {
        l lVarNy = jn.ny(ofVar);
        if (lVarNy == null) {
            return 0;
        }
        return lVarNy.x;
    }

    public static String c(of ofVar) {
        if (ofVar == null) {
            return "";
        }
        return ofVar.zo();
    }
}
