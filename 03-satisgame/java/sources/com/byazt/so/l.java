package com.byazt.so;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.byazt.tk.k;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 427, 18})
public class l {
    public static int n(Context context, boolean z) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return (com.byazt.af.x.n().n(context, "android.permission.CHANGE_NETWORK_STATE") && z && n(connectivityManager)) ? 3 : 2;
                }
                if (type == 0) {
                    return 1;
                }
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    private static boolean n(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable th) {
            k.qg("transmit_TelephonyUtils", "isMobileEnabled error:" + th.getMessage());
            return false;
        }
    }

    public static boolean n(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null || 1 != telephonyManager.getSimState();
    }
}
