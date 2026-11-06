package com.anythink.china.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static String b() {
        return "";
    }

    public static String a() {
        try {
            File file = new File("/data/data");
            if (!file.exists()) {
                return "";
            }
            return (file.lastModified() / 1000) + ".000000000";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] a(PackageInfo packageInfo) {
        try {
            return new String[]{"", new StringBuilder().append(packageInfo.lastUpdateTime).toString()};
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean c(Context context) {
        boolean zIsProviderEnabled = ((LocationManager) context.getApplicationContext().getSystemService("location")).isProviderEnabled("gps");
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return zIsProviderEnabled && (packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", context.getPackageName()) == 0 || packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", context.getPackageName()) == 0);
    }

    public static String a(Context context) {
        String subscriberId;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (telephonyManager == null || (subscriberId = telephonyManager.getSubscriberId()) == null) ? "" : subscriberId;
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String b(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                boolean zIsProviderEnabled = ((LocationManager) context.getApplicationContext().getSystemService("location")).isProviderEnabled("gps");
                PackageManager packageManager = context.getApplicationContext().getPackageManager();
                boolean z = false;
                boolean z2 = packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", context.getPackageName()) == 0 || packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", context.getPackageName()) == 0;
                if (zIsProviderEnabled && z2) {
                    z = true;
                }
                if (!z) {
                    return "";
                }
            }
            return d(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String d(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            String ssid = connectionInfo == null ? "" : connectionInfo.getSSID();
            if ("<unknown ssid>".equalsIgnoreCase(ssid)) {
                ssid = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo().getExtraInfo();
            }
            return "<unknown ssid>".equalsIgnoreCase(ssid) ? "" : ssid;
        } catch (Throwable unused) {
            return "";
        }
    }
}
