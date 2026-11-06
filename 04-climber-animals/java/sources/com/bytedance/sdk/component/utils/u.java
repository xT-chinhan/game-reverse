package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: classes2.dex */
public class u {
    public static void ms(ub ubVar) {
        w.ms(ubVar);
    }

    public static boolean ms(Context context) {
        return ah(context) != 0;
    }

    public static int xr(Context context) {
        int iAh = ah(context);
        if (iAh == 1) {
            return 0;
        }
        if (iAh == 4) {
            return 1;
        }
        if (iAh == 5) {
            return 4;
        }
        if (iAh != 6) {
            return iAh;
        }
        return 6;
    }

    public static int ah(Context context) {
        return w.ms(context, 60000L);
    }

    public static boolean d(Context context) {
        return ah(context) == 4;
    }

    public static boolean ka(Context context) {
        return ah(context) == 5;
    }

    public static boolean c(Context context) {
        return ah(context) == 6;
    }

    public static String ab(Context context) {
        int iAh = ah(context);
        if (iAh == 2) {
            return NetworkUtil.NETWORK_CLASS_2G;
        }
        if (iAh == 3) {
            return NetworkUtil.NETWORK_CLASS_3G;
        }
        if (iAh == 4) {
            return NetworkUtil.NETWORK_TYPE_WIFI;
        }
        if (iAh != 5) {
            return iAh != 6 ? "mobile" : NetworkUtil.NETWORK_CLASS_5G;
        }
        return NetworkUtil.NETWORK_CLASS_4G;
    }

    public static boolean ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }
}
