package com.byazt.ll;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 19})
public class n {
    public static void n(String str) {
        qg.n.n(str, 1, 0);
    }

    public static void n(String str, long j, long j2) {
        if (j > 0) {
            qg.n.n(str, 3, (int) ((j2 * 100) / j));
        }
    }

    public static void qg(String str, long j, long j2) {
        if (j > 0) {
            qg.n.n(str, 2, (int) ((j2 * 100) / j));
        }
    }

    public static void s(String str, long j, long j2) {
        if (j > 0) {
            qg.n.n(str, 4, (int) ((j2 * 100) / j));
        }
    }

    public static void qg(String str) {
        qg.n.n(str, 5, 100);
    }

    public static void s(String str) {
        qg.n.n(str, 6, 100);
    }
}
