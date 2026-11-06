package com.byazt.uq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 113})
public final class d {
    public static boolean n() {
        return w.n();
    }

    public static void n(int i, int i2, String str) {
        n((Object) str);
    }

    public static void n(int i, String str) {
        n(str);
    }

    public static void qg(int i, int i2, String str) {
        n((Object) str);
    }

    public static String n(String str) {
        if (str == null) {
            return "";
        }
        String strTrim = str.trim();
        return strTrim.isEmpty() ? "" : "len=" + strTrim.length() + ",hash=" + strTrim.hashCode();
    }

    private static String n(Object obj) {
        return obj == null ? "" : String.valueOf(obj);
    }
}
