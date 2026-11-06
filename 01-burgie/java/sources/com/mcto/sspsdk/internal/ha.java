package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ha {
    public static String a = "-100";
    public static final AtomicBoolean b = new AtomicBoolean(false);
    public static final ga c = new ga();

    public static String a() {
        if (TextUtils.equals(a, "-100")) {
            b();
        }
        if (!b.getAndSet(true)) {
            try {
                Context context = jd.a;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(c, intentFilter, 2);
                } else {
                    context.registerReceiver(c, intentFilter);
                }
            } catch (Exception e) {
                r9.a("ssp_sdk", "NetworkStatus registerNetworkCallback:", e);
            }
        }
        return a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b() {
        NetworkInfo activeNetworkInfo;
        String str = "14";
        Context context = jd.a;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                int type = activeNetworkInfo.getType();
                try {
                    if (type != 1) {
                        if (type == 0) {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager != null) {
                                switch (telephonyManager.getNetworkType()) {
                                    case 1:
                                        str = "2";
                                        break;
                                    case 2:
                                        str = GlobalSetting.SPLASH_AD;
                                        break;
                                    case 3:
                                        str = GlobalSetting.NATIVE_EXPRESS_AD;
                                        break;
                                    case 4:
                                        str = GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD;
                                        break;
                                    case 5:
                                        str = GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD;
                                        break;
                                    case 6:
                                        str = "10";
                                        break;
                                    case 7:
                                        str = "11";
                                        break;
                                    case 8:
                                        str = GlobalSetting.REWARD_VIDEO_AD;
                                        break;
                                    case 9:
                                        str = GlobalSetting.NATIVE_UNIFIED_AD;
                                        break;
                                    case 10:
                                        str = GlobalSetting.UNIFIED_BANNER_AD;
                                        break;
                                    case 11:
                                        str = "16";
                                        break;
                                    case 12:
                                        str = "13";
                                        break;
                                    case 14:
                                        str = "15";
                                        break;
                                    case 15:
                                        str = "12";
                                        break;
                                    case 16:
                                        str = "17";
                                        break;
                                    case 17:
                                        str = "18";
                                        break;
                                    case 18:
                                        str = "20";
                                        break;
                                    case 20:
                                        str = "20";
                                        break;
                                }
                            }
                        } else if (type == 7) {
                            str = "25";
                        } else if (type == 17) {
                            str = "26";
                        }
                        a = str;
                    }
                    str = "1";
                    y4.r.l = null;
                } catch (Exception e) {
                    e = e;
                    r9.a("ssp_sdk", "get APN Type error. ", e);
                }
                a = str;
            }
            str = "0";
        } catch (Exception e2) {
            e = e2;
            str = "0";
        }
        a = str;
    }
}
