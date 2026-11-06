package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 2143})
public class nw {
    public int pr;

    public nw(JSONObject jSONObject) {
        this.pr = 0;
        if (jSONObject != null) {
            this.pr = jSONObject.optInt("playable_reward_type", 0);
        }
    }

    public void pr(JSONObject jSONObject) {
        try {
            jSONObject.put("playable_reward_type", this.pr);
        } catch (JSONException e) {
        }
    }

    private static nw hn(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.na();
    }

    public static int pr(of ofVar) {
        int i;
        nw nwVarHn = hn(ofVar);
        if (nwVarHn == null || (i = nwVarHn.pr) < 0 || i > 1) {
            return 0;
        }
        if (!TextUtils.isEmpty(com.byazt.sd.a.hw().mw()) || lb.m(ofVar)) {
            return nwVarHn.pr;
        }
        return 1;
    }

    public static int hw(of ofVar) {
        String strAj;
        com.byazt.n.x xVarG = qv.g(ofVar);
        if (xVarG == null) {
            strAj = null;
        } else {
            strAj = xVarG.aj();
        }
        try {
            if (TextUtils.isEmpty(strAj)) {
                return 0;
            }
            String[] strArrSplit = strAj.split("x");
            return (strArrSplit.length >= 2 && Integer.parseInt(strArrSplit[0]) > Integer.parseInt(strArrSplit[1])) ? 1 : 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
