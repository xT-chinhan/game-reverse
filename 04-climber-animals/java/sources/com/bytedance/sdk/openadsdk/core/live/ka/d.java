package com.bytedance.sdk.openadsdk.core.live.ka;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.taptap.sdk.db.constant.Common;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static boolean ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
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
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean ms(lm lmVar) {
        JSONObject jSONObjectKa;
        com.bytedance.sdk.openadsdk.core.ugeno.ny.ms msVarLe = lmVar.le();
        return (msVarLe == null || (jSONObjectKa = msVarLe.ka()) == null || jSONObjectKa.optBoolean("landing_type", false)) ? false : true;
    }
}
