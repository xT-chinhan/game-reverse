package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes3.dex */
public class k {
    public static String a(Context context) {
        try {
            if (!a(context, com.kuaishou.weapon.p0.g.b)) {
                return "0";
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                if (!a(connectivityManager)) {
                    return "0";
                }
                if (b(connectivityManager)) {
                    return "2";
                }
            }
            return a(context, (TelephonyManager) context.getSystemService("phone"), connectivityManager);
        } catch (Exception unused) {
            return "0";
        }
    }

    private static String a(Context context, TelephonyManager telephonyManager, ConnectivityManager connectivityManager) {
        int subtype;
        NetworkInfo activeNetworkInfo;
        if (telephonyManager == null) {
            subtype = 0;
        } else if (Build.VERSION.SDK_INT < 30 || !(a(context, "android.permission.READ_PHONE_STATE") || telephonyManager.hasCarrierPrivileges())) {
            try {
                subtype = telephonyManager.getNetworkType();
            } catch (Exception unused) {
                subtype = 0;
            }
        } else {
            subtype = telephonyManager.getDataNetworkType();
        }
        if (subtype == 0) {
            if (Build.VERSION.SDK_INT >= 30) {
                return "3";
            }
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                subtype = activeNetworkInfo.getSubtype();
            }
        }
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "4";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "5";
            case 13:
            case 18:
            case 19:
                return "6";
            case 16:
            case 17:
            default:
                return "3";
            case 20:
                return "7";
        }
    }

    private static boolean a(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Exception unused) {
        }
    }

    private static boolean a(ConnectivityManager connectivityManager) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return a(networkCapabilities);
    }

    public static boolean a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null) {
            return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(7) || networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(16);
        }
        return false;
    }

    public static boolean b(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        return networkInfo != null && networkInfo.isConnected();
    }

    private static boolean b(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1);
    }

    public static boolean c(Context context) {
        if (!m.a(context, com.kuaishou.weapon.p0.g.b)) {
            return false;
        }
        try {
            return a((ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Exception unused) {
            return false;
        }
    }
}
