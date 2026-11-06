package com.byazt.nf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public final class tj {
    public static final int qg = 7814;
    public static final Boolean n = Boolean.TRUE;
    public static boolean s = false;
    public static boolean q = false;
    public static int l = 7814;
    public static String w = "7.8.1.4";
    public static int x = 1160;
    public static boolean fs = true;
    public static String rv = "main";
    public static boolean tj = false;
    public static String cp = "6.6.0.0";

    public static String n(String str, int i) {
        return "";
    }

    public static boolean n() {
        return true;
    }

    public static boolean q() {
        return false;
    }

    public static boolean qg() {
        return false;
    }

    public static boolean s() {
        return com.byazt.xhd.s.s();
    }

    public static boolean l() {
        return com.byazt.gks.qg.n().n();
    }

    public static String w() {
        return rv + (n() ? "_plugin" : "") + (tj ? "_open" : "_close");
    }

    public static String x() {
        return n("com.byted.pangle", 7814);
    }

    public static boolean fs() {
        return TextUtils.equals("internal", rv);
    }
}
