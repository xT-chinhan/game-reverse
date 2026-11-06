package com.byazt.ee;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 91})
public final class rc {
    public static boolean pr;

    public static String pr(Throwable th) {
        return "{\"code\":" + (th instanceof lb ? ((lb) th).pr : 0) + "}";
    }

    public static String pr(String str) {
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        if (!pr) {
            strSubstring = "";
        } else {
            strSubstring = str.substring(1, str.length() - 1);
        }
        String str2 = "{\"code\":1,\"__data\":" + str;
        if (!strSubstring.isEmpty()) {
            return str2 + "," + strSubstring + "}";
        }
        return str2 + "}";
    }

    public static String pr() {
        return "";
    }

    public static void pr(boolean z) {
        pr = z;
    }
}
