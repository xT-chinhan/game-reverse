package com.bytedance.sdk.openadsdk.core.p;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.utils.sl;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static int ms(Context context, boolean z, xr xrVar) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return (com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(context, "android.permission.CHANGE_NETWORK_STATE") && z && ms(connectivityManager, context, xrVar)) ? 3 : 2;
                }
                if (type == 0) {
                    return 1;
                }
                return 0;
            }
            return 0;
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    private static boolean ms(ConnectivityManager connectivityManager, Context context, xr xrVar) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable th) {
            sl.d("transmit_TelephonyUtils", "isMobileEnabled error:" + th.getMessage());
            return false;
        }
    }

    public static boolean ms(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null || 1 != telephonyManager.getSimState();
    }
}
