package com.tapsdk.tapad.internal.tracker.experiment.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    public static String a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = b(context).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "not connected";
            }
            int type = activeNetworkInfo.getType();
            if (type != 0) {
                return type != 1 ? "unknow" : NetworkUtil.NETWORK_TYPE_WIFI;
            }
            return "mobile";
        } catch (Error | Exception e) {
            System.out.println(e);
            return "not connected";
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
            } catch (Exception e) {
                System.out.println(e.toString());
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
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
            case 18:
            case 19:
                return "4G";
            case 16:
            case 17:
            default:
                return "unknow";
            case 20:
                return "5G";
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return ContextCompat.checkSelfPermission(context, str) == 0;
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

    public static ConnectivityManager b(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static boolean b(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1);
    }

    public static String c(Context context) {
        try {
            if (!a(context, com.kuaishou.weapon.p0.g.b)) {
                return "unknow";
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || a(connectivityManager)) ? a(context, (TelephonyManager) context.getSystemService("phone"), connectivityManager) : "unknow";
        } catch (Exception e) {
            System.out.println(e.toString());
            return "unknow";
        }
    }

    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }
}
