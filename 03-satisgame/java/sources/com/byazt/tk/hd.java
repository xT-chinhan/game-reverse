package com.byazt.tk;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd {
    public static final Map<com.byazt.hsi.s, Object> n = new ConcurrentHashMap();
    public static AtomicBoolean qg = new AtomicBoolean(false);
    public static final Object s = new Object();

    public static boolean n(Context context) {
        return s(context) != 0;
    }

    public static int qg(Context context) {
        int iS = s(context);
        if (iS == 1) {
            return 0;
        }
        if (iS == 4) {
            return 1;
        }
        if (iS == 5) {
            return 4;
        }
        if (iS != 6) {
            return iS;
        }
        return 6;
    }

    public static int s(Context context) {
        return ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).n(60000L);
    }

    public static boolean q(Context context) {
        return s(context) == 4;
    }

    public static boolean l(Context context) {
        return s(context) == 5;
    }

    public static boolean w(Context context) {
        return s(context) == 6;
    }

    public static String x(Context context) {
        int iS = s(context);
        if (iS == 2) {
            return "2g";
        }
        if (iS == 3) {
            return "3g";
        }
        if (iS == 4) {
            return "wifi";
        }
        if (iS != 5) {
            return iS != 6 ? "mobile" : "5g";
        }
        return "4g";
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }
}
