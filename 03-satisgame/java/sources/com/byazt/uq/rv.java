package com.byazt.uq;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public final class rv {
    public static n n(String str, int i, String str2, String str3) {
        return new n(n(str), String.valueOf(i), n(str2), qg(str3));
    }

    private static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return " ";
        }
        String strTrim = str.trim();
        return TextUtils.isEmpty(strTrim) ? " " : strTrim;
    }

    private static String qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return " ";
        }
        String strTrim = str.trim();
        if (TextUtils.isEmpty(strTrim)) {
            return " ";
        }
        int length = strTrim.length();
        int i = length - 1;
        while (i >= 0) {
            char cCharAt = strTrim.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i--;
        }
        int i2 = i + 1;
        if (i2 == length || i2 < 4 || strTrim.charAt(i2 - 1) != '-' || strTrim.charAt(i2 - 2) != 'b' || strTrim.charAt(i2 - 3) != 'a') {
            return strTrim;
        }
        int i3 = i2 - 4;
        return strTrim.charAt(i3) != 'T' ? strTrim : strTrim.substring(i3);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 160})
    public static final class n {
        public final String l;
        public final String n;
        public final String q;
        public final String qg;
        public final String s;

        public n(String str, String str2, String str3, String str4) {
            this.n = str;
            this.qg = str2;
            this.s = str3;
            this.q = str4;
            this.l = com.byazt.tk.l.qg(str + "_" + str2 + "_" + str3 + "_" + str4);
        }

        public String n() {
            return this.l;
        }
    }
}
