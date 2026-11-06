package com.taptap.sdk.kit.internal.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.taptap.sdk.kit.internal.TapLogger;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkUtil {
    private static final String TAG = "NetworkUtil";

    public static ConnectivityManager getConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static String getConnectedType(Context context) {
        try {
            NetworkInfo net = getConnectivityManager(context).getActiveNetworkInfo();
            if (net != null) {
                switch (net.getType()) {
                    case 0:
                        return "mobile";
                    case 1:
                        return com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI;
                    default:
                        return "unknow";
                }
            }
            return "not connected";
        } catch (Error e) {
            return "not connected";
        } catch (Exception e2) {
            return "not connected";
        }
    }

    public static boolean checkHasPermission(Context context, String permission) {
        try {
            int result = context.checkPermission(permission, Process.myPid(), Process.myUid());
            if (result == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private static boolean isWiFiNetwork(ConnectivityManager connectivityManager) {
        NetworkCapabilities capabilities;
        if (Build.VERSION.SDK_INT >= 23) {
            Network network = connectivityManager.getActiveNetwork();
            if (network == null || (capabilities = connectivityManager.getNetworkCapabilities(network)) == null) {
                return false;
            }
            return capabilities.hasTransport(1);
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public static String getNetworkType(Context context) {
        try {
            if (!checkHasPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                return "unknow";
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && !isNetworkAvailable(connectivityManager)) {
                return "unknow";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return mobileNetworkType(context, telephonyManager, connectivityManager);
        } catch (Exception e) {
            TapLogger.logd(TAG, e);
            return "unknow";
        }
    }

    public static boolean isNetworkValid(NetworkCapabilities capabilities) {
        if (capabilities == null) {
            return false;
        }
        if (!capabilities.hasTransport(1) && !capabilities.hasTransport(0) && !capabilities.hasTransport(3) && !capabilities.hasTransport(7) && !capabilities.hasTransport(4) && !capabilities.hasCapability(16)) {
            return false;
        }
        return true;
    }

    private static boolean isNetworkAvailable(ConnectivityManager connectivityManager) {
        NetworkCapabilities capabilities;
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                Network network = connectivityManager.getActiveNetwork();
                if (network != null && (capabilities = connectivityManager.getNetworkCapabilities(network)) != null) {
                    return isNetworkValid(capabilities);
                }
            } else {
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                return networkInfo != null && networkInfo.isConnected();
            }
        }
        return false;
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return true;
        }
        ConnectivityManager manager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (manager == null) {
            return false;
        }
        NetworkInfo networkinfo = manager.getActiveNetworkInfo();
        if (networkinfo != null && networkinfo.isAvailable()) {
            return true;
        }
        return false;
    }

    private static String mobileNetworkType(Context context, TelephonyManager telephonyManager, ConnectivityManager connectivityManager) {
        NetworkInfo networkInfo;
        int networkType = 0;
        if (telephonyManager != null) {
            if (Build.VERSION.SDK_INT >= 30 && (checkHasPermission(context, "android.permission.READ_PHONE_STATE") || telephonyManager.hasCarrierPrivileges())) {
                networkType = telephonyManager.getDataNetworkType();
            } else {
                try {
                    networkType = telephonyManager.getNetworkType();
                } catch (Exception e) {
                }
            }
        }
        if (networkType == 0) {
            if (Build.VERSION.SDK_INT >= 30) {
                return GlobalSetting.SPLASH_AD;
            }
            if (connectivityManager != null && (networkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                networkType = networkInfo.getSubtype();
            }
        }
        switch (networkType) {
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
}
