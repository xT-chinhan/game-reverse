package com.byazt.vy;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd {
    private static int n(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 2;
        if (i != 2) {
            i2 = 3;
            if (i != 3) {
                if (i == 4) {
                    return 1;
                }
                if (i == 5) {
                    return 4;
                }
                if (i != 6) {
                    return i;
                }
                return 5;
            }
        }
        return i2;
    }

    public static String n() {
        return com.byazt.yu.n.n().qg();
    }

    public static int qg() {
        return n(((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).n(60000L));
    }

    public static boolean n(Context context) {
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
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean qg(Context context) {
        return com.byazt.tk.hd.s(context) == 3;
    }

    public static boolean s(Context context) {
        return com.byazt.tk.hd.s(context) == 2;
    }
}
