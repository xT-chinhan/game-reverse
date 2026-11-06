package com.byazt.dz;

import android.text.TextUtils;
import com.byazt.hg.of;
import com.taptap.sdk.db.constant.Common;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 903, 121})
public class x {
    public static boolean pr(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        String strOptString = jSONObject.optString(Common.System.NAME, null);
                        if (TextUtils.equals(strOptString, "ec_reward_gold") || TextUtils.equals(strOptString, "reward_gold") || TextUtils.equals(strOptString, "auth_reward_gold")) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Throwable th) {
                return true;
            }
        }
        return true;
    }

    public static boolean pr(of ofVar) {
        JSONObject jSONObjectC;
        com.byazt.ze.pr prVarSv = ofVar.sv();
        return (prVarSv == null || (jSONObjectC = prVarSv.c()) == null || jSONObjectC.optBoolean("landing_type", false)) ? false : true;
    }
}
