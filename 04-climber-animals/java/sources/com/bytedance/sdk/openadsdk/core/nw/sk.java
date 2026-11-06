package com.bytedance.sdk.openadsdk.core.nw;

import android.os.Build;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sk {
    public static int ah = 1;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static int f3095ms;
    public static int xr;

    public static void ms(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("ugen_image_load_config")) == null) {
            return;
        }
        f3095ms = jSONObjectOptJSONObject.optInt("api", 0);
        xr = jSONObjectOptJSONObject.optInt("size_limit", 0);
        ah = jSONObjectOptJSONObject.optInt("zip_level", 1);
    }

    public static int ms(int i, int i2) {
        if (f3095ms <= 0 || Build.VERSION.SDK_INT > f3095ms || i == 0 || i2 == 0) {
            return 1;
        }
        int i3 = xr;
        if (i >= i3 || i2 >= i3) {
            return Math.max(1, ah);
        }
        return 1;
    }
}
