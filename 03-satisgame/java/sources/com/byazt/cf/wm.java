package com.byazt.cf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 93, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC})
public final class wm {
    public static boolean n;

    public static String n() {
        return "";
    }

    public static String n(Throwable th) {
        return "{\"code\":" + (th instanceof hd ? ((hd) th).n : 0) + "}";
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String strSubstring = n ? str.substring(1, str.length() - 1) : "";
        String str2 = "{\"code\":1,\"__data\":" + str;
        if (!strSubstring.isEmpty()) {
            return str2 + "," + strSubstring + "}";
        }
        return str2 + "}";
    }

    public static void n(boolean z) {
        n = z;
    }
}
