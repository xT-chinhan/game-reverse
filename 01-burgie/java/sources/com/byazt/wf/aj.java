package com.byazt.wf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 201, 61})
public final class aj {
    public static String pr(Context context) {
        return pr(hn(context));
    }

    public static String pr(com.byazt.tv.hw.EnumC0202hw enumC0202hw) {
        try {
            switch (AnonymousClass1.pr[enumC0202hw.ordinal()]) {
                case 1:
                    return NetworkUtil.NETWORK_TYPE_WIFI;
                case 2:
                    return NetworkUtil.NETWORK_CLASS_2G;
                case 3:
                    return NetworkUtil.NETWORK_CLASS_3G;
                case 4:
                    return NetworkUtil.NETWORK_CLASS_4G;
                case 5:
                    return "mobile";
                default:
                    return "";
            }
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: renamed from: com.byazt.wf.aj$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 201, 202})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.tv.hw.EnumC0202hw.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.tv.hw.EnumC0202hw.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.tv.hw.EnumC0202hw.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[com.byazt.tv.hw.EnumC0202hw.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[com.byazt.tv.hw.EnumC0202hw.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pr[com.byazt.tv.hw.EnumC0202hw.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static com.byazt.tv.hw.EnumC0202hw hn(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return com.byazt.tv.hw.EnumC0202hw.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return com.byazt.tv.hw.EnumC0202hw.WIFI;
                }
                if (type == 0) {
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return com.byazt.tv.hw.EnumC0202hw.MOBILE_3G;
                        case 4:
                        case 7:
                        case 11:
                        default:
                            return com.byazt.tv.hw.EnumC0202hw.MOBILE;
                        case 13:
                            return com.byazt.tv.hw.EnumC0202hw.MOBILE_4G;
                    }
                }
                return com.byazt.tv.hw.EnumC0202hw.MOBILE;
            }
            return com.byazt.tv.hw.EnumC0202hw.NONE;
        } catch (Throwable th) {
            return com.byazt.tv.hw.EnumC0202hw.MOBILE;
        }
    }

    public static boolean hw(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }
}
