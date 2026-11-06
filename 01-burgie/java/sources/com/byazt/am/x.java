package com.byazt.am;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1646, 121})
public class x {
    public static boolean pr(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            ho.hw("ignored", th.toString());
        }
        return false;
    }

    public static int hw(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                switch (activeNetworkInfo.getType()) {
                    case 0:
                        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                            case 16:
                                return 2;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                            case 17:
                                return 3;
                            case 13:
                            case 18:
                            case 19:
                                return 5;
                            default:
                                String subtypeName = activeNetworkInfo.getSubtypeName();
                                return (TextUtils.isEmpty(subtypeName) || !("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName))) ? 1 : 3;
                        }
                    case 1:
                        return 4;
                    default:
                        return 1;
                }
                return 1;
            }
            return 0;
        } catch (Throwable th) {
            return 1;
        }
    }

    public static String hn(Context context) {
        switch (hw(context)) {
            case 2:
                return NetworkUtil.NETWORK_CLASS_2G;
            case 3:
                return NetworkUtil.NETWORK_CLASS_3G;
            case 4:
                return NetworkUtil.NETWORK_TYPE_WIFI;
            case 5:
                return NetworkUtil.NETWORK_CLASS_4G;
            default:
                return "mobile";
        }
    }
}
