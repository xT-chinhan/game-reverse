package com.bytedance.sdk.openadsdk.core.playable.xr;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static boolean ms(Context context) {
        try {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (!lowerCase.contains("huawei") && !lowerCase.contains("honor")) {
                if (lowerCase.contains("vivo")) {
                    return d(context);
                }
                if (lowerCase.contains("oppo")) {
                    return ka(context);
                }
                if (!lowerCase.contains(MediationConstant.ADN_XIAOMI) && !lowerCase.contains("redmi")) {
                    if (lowerCase.contains("samsung")) {
                        return false;
                    }
                    return c(context);
                }
                return ah(context);
            }
            return xr(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean ms() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        return lowerCase.contains("huawei") || lowerCase.contains("honor") || lowerCase.contains("vivo") || lowerCase.contains(MediationConstant.ADN_XIAOMI) || lowerCase.contains("redmi") || lowerCase.contains("oppo");
    }

    private static boolean xr(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) != 0;
    }

    private static boolean ah(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0;
    }

    private static boolean d(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) != 0;
    }

    private static boolean ka(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0) != 0;
    }

    private static boolean c(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) != 0;
    }
}
