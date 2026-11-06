package com.bytedance.ms.xr.x;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class ny {
    public static String ms(Context context) {
        return ms(ah(context));
    }

    /* JADX INFO: renamed from: com.bytedance.ms.xr.x.ny$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f593ms;

        static {
            int[] iArr = new int[com.bytedance.ms.xr.ab.xr.EnumC0216xr.values().length];
            f593ms = iArr;
            try {
                iArr[com.bytedance.ms.xr.ab.xr.EnumC0216xr.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f593ms[com.bytedance.ms.xr.ab.xr.EnumC0216xr.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f593ms[com.bytedance.ms.xr.ab.xr.EnumC0216xr.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f593ms[com.bytedance.ms.xr.ab.xr.EnumC0216xr.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f593ms[com.bytedance.ms.xr.ab.xr.EnumC0216xr.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String ms(com.bytedance.ms.xr.ab.xr.EnumC0216xr enumC0216xr) {
        try {
            int i = AnonymousClass1.f593ms[enumC0216xr.ordinal()];
            if (i == 1) {
                return NetworkUtil.NETWORK_TYPE_WIFI;
            }
            if (i == 2) {
                return NetworkUtil.NETWORK_CLASS_2G;
            }
            if (i == 3) {
                return NetworkUtil.NETWORK_CLASS_3G;
            }
            if (i != 4) {
                return i != 5 ? "" : "mobile";
            }
            return NetworkUtil.NETWORK_CLASS_4G;
        } catch (Exception unused) {
            return "";
        }
    }

    private static com.bytedance.ms.xr.ab.xr.EnumC0216xr ah(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return com.bytedance.ms.xr.ab.xr.EnumC0216xr.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return com.bytedance.ms.xr.ab.xr.EnumC0216xr.WIFI;
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
                            return com.bytedance.ms.xr.ab.xr.EnumC0216xr.MOBILE_3G;
                        case 4:
                        case 7:
                        case 11:
                        default:
                            return com.bytedance.ms.xr.ab.xr.EnumC0216xr.MOBILE;
                        case 13:
                            return com.bytedance.ms.xr.ab.xr.EnumC0216xr.MOBILE_4G;
                    }
                }
                return com.bytedance.ms.xr.ab.xr.EnumC0216xr.MOBILE;
            }
            return com.bytedance.ms.xr.ab.xr.EnumC0216xr.NONE;
        } catch (Throwable unused) {
            return com.bytedance.ms.xr.ab.xr.EnumC0216xr.MOBILE;
        }
    }

    public static boolean xr(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
        } catch (Exception unused) {
        }
    }
}
