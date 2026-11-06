package com.byazt.ec;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.taptap.sdk.kit.internal.time.TapTime;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 5})
public class uc {
    public static String pr(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferencesHw = com.byazt.mg.hw.hw(context, "applog_net_cache.dat", 0);
        if (System.currentTimeMillis() - sharedPreferencesHw.getLong("start_mills", 0L) < TapTime.MAX_SKEW_MS) {
            String string = sharedPreferencesHw.getString(an.Q, null);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        String strHw = hw(context);
        SharedPreferences.Editor editorEdit = sharedPreferencesHw.edit();
        if (!TextUtils.isEmpty(strHw)) {
            editorEdit.putString(an.Q, strHw);
        }
        editorEdit.putLong("start_mills", System.currentTimeMillis());
        editorEdit.apply();
        return strHw;
    }

    private static String hw(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            w.hw(e);
            activeNetworkInfo = null;
        } catch (Throwable th) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (1 == type) {
            return NetworkUtil.NETWORK_TYPE_WIFI;
        }
        if (type != 0) {
            return null;
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkUtil.NETWORK_CLASS_2G;
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
                return NetworkUtil.NETWORK_CLASS_3G;
            case 13:
            case 18:
            case 19:
                return NetworkUtil.NETWORK_CLASS_4G;
            default:
                return "mobile";
        }
    }
}
