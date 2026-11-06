package com.byazt.ua;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 50})
public final class vk {
    public static boolean pr() {
        return uc.pr();
    }

    public static void pr(int i, int i2, String str) {
        pr((Object) str);
    }

    public static void pr(int i, String str) {
        pr(str);
    }

    public static void hw(int i, int i2, String str) {
        pr((Object) str);
    }

    public static String pr(String str) {
        if (str == null) {
            return "";
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return "";
        }
        return "len=" + strTrim.length() + ",hash=" + strTrim.hashCode();
    }

    private static String pr(Object obj) {
        return obj == null ? "" : String.valueOf(obj);
    }
}
