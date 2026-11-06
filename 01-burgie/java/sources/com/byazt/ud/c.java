package com.byazt.ud;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1485, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static boolean pr(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            for (NetworkInfo networkInfo : connectivityManager.getAllNetworkInfo()) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static int hw(Context context) {
        int iHn = hn(context);
        switch (iHn) {
            case 1:
                return 0;
            case 2:
            case 3:
            default:
                return iHn;
            case 4:
                return 1;
            case 5:
                return 4;
            case 6:
                return 6;
        }
    }

    public static int hn(Context context) {
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
                            case 20:
                                return 6;
                            default:
                                String subtypeName = activeNetworkInfo.getSubtypeName();
                                return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
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
}
