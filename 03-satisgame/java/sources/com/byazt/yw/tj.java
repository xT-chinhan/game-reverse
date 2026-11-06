package com.byazt.yw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public final class tj {
    public static void n(String str) {
        com.byazt.qf.fs.l();
    }

    public static void n(Throwable th) {
        if (com.byazt.qf.fs.l().w()) {
            com.byazt.tk.k.n("npth", "NPTH Catch Error", th);
        }
    }

    public static void n(String str, Throwable th) {
        if (com.byazt.qf.fs.l().w()) {
            com.byazt.tk.k.n(str, "NPTH Catch Error", th);
        }
    }

    public static void qg(Throwable th) {
        com.byazt.qf.fs.l();
    }
}
