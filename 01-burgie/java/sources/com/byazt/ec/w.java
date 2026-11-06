package com.byazt.ec;

import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 109})
public class w {
    public static boolean hw = false;
    public static boolean pr;

    public static void pr(String str) {
    }

    public static void pr(String str, Throwable th) {
    }

    public static void hw(String str) {
    }

    public static void hw(String str, Throwable th) {
    }

    public static void hn(String str, Throwable th) {
        ho.pr("TeaLog", str, th);
    }

    public static void pr(Throwable th) {
        ho.pr("TeaLog", "", th);
    }

    public static void x(String str, Throwable th) {
    }

    public static void hw(Throwable th) {
        if (th != null) {
            th.getMessage();
        }
    }
}
