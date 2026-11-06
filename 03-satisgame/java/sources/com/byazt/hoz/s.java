package com.byazt.hoz;

import android.text.TextUtils;
import com.anythink.core.common.f.e;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 424, 8})
public class s {
    public static int n(Map<String, Object> map) {
        try {
            return ((Integer) map.get("live_saas_param_interaction_type")).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean n(String str) {
        try {
            return (TextUtils.isEmpty(str) || new JSONObject(str).optJSONObject("enter_request") == null || qg(str)) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean qg(String str) {
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
                    if (jSONObjectOptJSONObject2.optInt("interaction_type") == 1 && jSONObjectOptJSONObject2.optInt("task_time") > 0 && jSONObjectOptJSONObject2.optLong(e.a.d) > 0) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
