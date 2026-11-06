package com.tapsdk.tapad.internal.telephony;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes3.dex */
public final class TelephonyAccessUtils {

    @FunctionalInterface
    public interface ExceptionReporter {
        void onException(Exception exc);
    }

    private TelephonyAccessUtils() {
    }

    public static boolean canQueryMobileNetwork(Context context, TelephonyManager telephonyManager) {
        return hasNetworkInfoAccess(context, telephonyManager);
    }

    private static boolean hasNetworkInfoAccess(Context context, TelephonyManager telephonyManager) {
        if (context != null && telephonyManager != null) {
            if (hasPhoneStatePermission(context)) {
                return true;
            }
            if (Build.VERSION.SDK_INT >= 22) {
                try {
                    return telephonyManager.hasCarrierPrivileges();
                } catch (SecurityException e) {
                }
            }
        }
        return false;
    }

    private static boolean hasPermission(Context context, String str) {
        return str != null && context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public static boolean hasPhoneStatePermission(Context context) {
        if (context == null) {
            return false;
        }
        if (hasPermission(context, "android.permission.READ_PHONE_STATE")) {
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 33 || !hasPermission(context, "android.permission.READ_BASIC_PHONE_STATE")) {
            return i >= 31 && hasPermission(context, "android.permission.READ_PRECISE_PHONE_STATE");
        }
        return true;
    }

    private static void report(ExceptionReporter exceptionReporter, Exception exc) {
        if (exceptionReporter != null) {
            try {
                exceptionReporter.onException(exc);
            } catch (Throwable th) {
            }
        }
    }

    public static int safeGetDataNetworkType(Context context, TelephonyManager telephonyManager, ExceptionReporter exceptionReporter) {
        if (!hasNetworkInfoAccess(context, telephonyManager)) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 24) {
            return safeGetNetworkTypeLegacy(context, telephonyManager, exceptionReporter);
        }
        try {
            return telephonyManager.getDataNetworkType();
        } catch (Exception e) {
            report(exceptionReporter, e);
            return 0;
        }
    }

    public static int safeGetNetworkTypeLegacy(Context context, TelephonyManager telephonyManager, ExceptionReporter exceptionReporter) {
        if (!hasNetworkInfoAccess(context, telephonyManager)) {
            return 0;
        }
        try {
            return telephonyManager.getNetworkType();
        } catch (Exception e) {
            report(exceptionReporter, e);
            return 0;
        }
    }
}
