package com.smartdigimkt.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static String b(Context context) {
        String strA;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                boolean zIsProviderEnabled = ((LocationManager) context.getApplicationContext().getSystemService("location")).isProviderEnabled("gps");
                PackageManager packageManager = context.getApplicationContext().getPackageManager();
                boolean z = packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", context.getPackageName()) == 0 || packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", context.getPackageName()) == 0;
                if (!zIsProviderEnabled || !z) {
                    return "";
                }
                strA = a(context);
            } else {
                strA = a(context);
            }
            return strA;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] a(PackageInfo packageInfo) {
        try {
            return new String[]{"", "" + packageInfo.lastUpdateTime};
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(Context context) {
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
