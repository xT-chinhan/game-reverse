package com.byazt.hg;

import android.os.Build;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 2108})
public class qo {
    public static int pr = 0;
    public static int hw = 0;
    public static int hn = 1;

    public static void pr(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("ugen_image_load_config")) != null) {
            pr = jSONObjectOptJSONObject.optInt("api", 0);
            hw = jSONObjectOptJSONObject.optInt("size_limit", 0);
            hn = jSONObjectOptJSONObject.optInt("zip_level", 1);
        }
    }

    public static int pr(int i, int i2) {
        if (pr <= 0 || Build.VERSION.SDK_INT > pr || i == 0 || i2 == 0) {
            return 1;
        }
        int i3 = hw;
        if (i >= i3 || i2 >= i3) {
            return Math.max(1, hn);
        }
        return 1;
    }
}
