package com.byazt.ca;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb {
    public static final Map<com.byazt.apo.hn, Object> pr = new ConcurrentHashMap();
    public static AtomicBoolean hw = new AtomicBoolean(false);
    public static final Object hn = new Object();

    public static boolean pr(Context context) {
        return hn(context) != 0;
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
        return ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).pr(60000L);
    }

    public static boolean x(Context context) {
        return hn(context) == 4;
    }

    public static boolean c(Context context) {
        return hn(context) == 5;
    }

    public static boolean uc(Context context) {
        return hn(context) == 6;
    }

    public static String fw(Context context) {
        switch (hn(context)) {
            case 2:
                return NetworkUtil.NETWORK_CLASS_2G;
            case 3:
                return NetworkUtil.NETWORK_CLASS_3G;
            case 4:
                return NetworkUtil.NETWORK_TYPE_WIFI;
            case 5:
                return NetworkUtil.NETWORK_CLASS_4G;
            case 6:
                return NetworkUtil.NETWORK_CLASS_5G;
            default:
                return "mobile";
        }
    }

    public static boolean pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }
}
