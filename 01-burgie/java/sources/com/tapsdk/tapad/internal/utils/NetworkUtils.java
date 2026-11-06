package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.tapsdk.tapad.internal.InterErrCode;
import com.tapsdk.tapad.internal.observability.InterErrorUtils;
import com.tapsdk.tapad.internal.telephony.TelephonyAccessUtils;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkUtils {
    public static int getNetworkType(Context context) {
        return getNetworkType(context, true);
    }

    private static boolean isNetworkAvailable(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        if (connectivityManager != null) {
            try {
                if (Build.VERSION.SDK_INT < 23) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
                }
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                    return isNetworkValid(networkCapabilities);
                }
            } catch (OutOfMemoryError e) {
            } catch (RuntimeException e2) {
            }
        }
        return false;
    }

    private static boolean isNetworkValid(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null) {
            return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(7) || networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(16);
        }
        return false;
    }

    private static boolean isWiFiNetwork(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        try {
            if (Build.VERSION.SDK_INT < 23) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                return networkInfo != null && networkInfo.isConnectedOrConnecting();
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return networkCapabilities.hasTransport(1);
        } catch (OutOfMemoryError | RuntimeException e) {
            return false;
        }
    }

    private static int mobileNetworkType(Context context, TelephonyManager telephonyManager, ConnectivityManager connectivityManager, boolean z) {
        int subtype;
        NetworkInfo activeNetworkInfo;
        if (z && TelephonyAccessUtils.canQueryMobileNetwork(context, telephonyManager)) {
            TelephonyAccessUtils.ExceptionReporter exceptionReporter = new TelephonyAccessUtils.ExceptionReporter() { // from class: com.tapsdk.tapad.internal.utils.NetworkUtils$$ExternalSyntheticLambda0
                @Override // com.tapsdk.tapad.internal.telephony.TelephonyAccessUtils.ExceptionReporter
                public final void onException(Exception exc) {
                    InterErrorUtils.trackInternalError(InterErrCode.CLIENT_FAIL_GET_NETWORK_TYPE, exc);
                }
            };
            subtype = Build.VERSION.SDK_INT >= 30 ? TelephonyAccessUtils.safeGetDataNetworkType(context, telephonyManager, exceptionReporter) : TelephonyAccessUtils.safeGetNetworkTypeLegacy(context, telephonyManager, exceptionReporter);
        } else {
            subtype = 0;
        }
        if (subtype == 0) {
            if (Build.VERSION.SDK_INT >= 30) {
                return 3;
            }
            if (z && connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                subtype = activeNetworkInfo.getSubtype();
            }
        }
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 5;
            case 13:
            case 18:
            case 19:
                return 6;
            case 16:
            case 17:
            default:
                return 3;
            case 20:
                return 7;
        }
    }

    public static int getNetworkType(Context context, boolean z) {
        try {
            if (!PermissionUtil.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                return 0;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                if (!isNetworkAvailable(connectivityManager)) {
                    return 0;
                }
                if (isWiFiNetwork(connectivityManager)) {
                    return 2;
                }
            }
            return mobileNetworkType(context, (TelephonyManager) context.getSystemService("phone"), connectivityManager, z);
        } catch (Exception e) {
            return 0;
        } catch (OutOfMemoryError e2) {
            return 0;
        }
    }
}
