package com.bytedance.sdk.openadsdk.core.live.ka;

import android.text.TextUtils;
import com.anythink.core.common.e.f;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    public static int ms(Map<String, Object> map) {
        try {
            return ((Integer) map.get("live_saas_param_interaction_type")).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean ms(String str) {
        try {
            return (TextUtils.isEmpty(str) || new JSONObject(str).optJSONObject("enter_request") == null || xr(str)) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean xr(String str) {
        JSONObject jSONObjectOptJSONObject;
        try {
            if (TextUtils.isEmpty(str) || (jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("enter_request")) == null) {
                return false;
            }
            int iOptInt = jSONObjectOptJSONObject.optInt("activity_type");
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("incr_coupon");
            if (iOptInt == 1 && jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject2.optInt("interaction_type") == 1 && jSONObjectOptJSONObject2.optInt("task_time") > 0 && jSONObjectOptJSONObject2.optLong(f.a.d) > 0) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
