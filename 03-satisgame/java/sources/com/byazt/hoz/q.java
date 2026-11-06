package com.byazt.hoz;

import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.vf.fi;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 424, 5})
public class q {
    public static boolean n() {
        try {
            fi fiVar = (fi) com.byazt.qp.q.n("strategy");
            JSONObject jSONObjectN = fiVar != null ? fiVar.n("c_s_s_performance_saas_load", null) : null;
            return jSONObjectN != null && jSONObjectN.optInt("saas_plugin_load", 0) == 2;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString(TapEventParamConstants.PARAM_NAME, null);
                    if (TextUtils.equals(strOptString, "ec_reward_gold") || TextUtils.equals(strOptString, "reward_gold") || TextUtils.equals(strOptString, "auth_reward_gold")) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean n(pk pkVar) {
        JSONObject jSONObjectL;
        com.byazt.ul.n nVarFl = pkVar.fl();
        return (nVarFl == null || (jSONObjectL = nVarFl.l()) == null || jSONObjectL.optBoolean("landing_type", false)) ? false : true;
    }
}
