package com.byazt.nsm;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 723, 19})
public class n {
    public static boolean n(Context context) {
        try {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (!lowerCase.contains("huawei") && !lowerCase.contains("honor")) {
                if (lowerCase.contains("vivo")) {
                    return q(context);
                }
                if (lowerCase.contains("oppo")) {
                    return l(context);
                }
                if (!lowerCase.contains(MediationConstant.ADN_XIAOMI) && !lowerCase.contains("redmi")) {
                    if (lowerCase.contains("samsung")) {
                        return false;
                    }
                    return w(context);
                }
                return s(context);
            }
            return qg(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean n() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        return lowerCase.contains("huawei") || lowerCase.contains("honor") || lowerCase.contains("vivo") || lowerCase.contains(MediationConstant.ADN_XIAOMI) || lowerCase.contains("redmi") || lowerCase.contains("oppo");
    }

    private static boolean qg(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) != 0;
    }

    private static boolean s(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0;
    }

    private static boolean q(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) != 0;
    }

    private static boolean l(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0) != 0;
    }

    private static boolean w(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) != 0;
    }
}
