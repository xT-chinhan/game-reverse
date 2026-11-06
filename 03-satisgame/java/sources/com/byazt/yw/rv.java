package com.byazt.yw;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public final class rv {
    public static String n(Context context) {
        return n(s(context));
    }

    /* JADX INFO: renamed from: com.byazt.yw.rv$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 81})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.xh.qg.EnumC0392qg.values().length];
            n = iArr;
            try {
                iArr[com.byazt.xh.qg.EnumC0392qg.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.xh.qg.EnumC0392qg.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[com.byazt.xh.qg.EnumC0392qg.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[com.byazt.xh.qg.EnumC0392qg.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                n[com.byazt.xh.qg.EnumC0392qg.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String n(com.byazt.xh.qg.EnumC0392qg enumC0392qg) {
        try {
            int i = AnonymousClass1.n[enumC0392qg.ordinal()];
            if (i == 1) {
                return "wifi";
            }
            if (i == 2) {
                return "2g";
            }
            if (i == 3) {
                return "3g";
            }
            if (i != 4) {
                return i != 5 ? "" : "mobile";
            }
            return "4g";
        } catch (Exception unused) {
            return "";
        }
    }

    private static com.byazt.xh.qg.EnumC0392qg s(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return com.byazt.xh.qg.EnumC0392qg.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return com.byazt.xh.qg.EnumC0392qg.WIFI;
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
                            return com.byazt.xh.qg.EnumC0392qg.MOBILE_3G;
                        case 4:
                        case 7:
                        case 11:
                        default:
                            return com.byazt.xh.qg.EnumC0392qg.MOBILE;
                        case 13:
                            return com.byazt.xh.qg.EnumC0392qg.MOBILE_4G;
                    }
                }
                return com.byazt.xh.qg.EnumC0392qg.MOBILE;
            }
            return com.byazt.xh.qg.EnumC0392qg.NONE;
        } catch (Throwable unused) {
            return com.byazt.xh.qg.EnumC0392qg.MOBILE;
        }
    }

    public static boolean qg(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
        } catch (Exception unused) {
        }
    }
}
