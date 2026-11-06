package com.byazt.sf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME, 13})
public final class hw {
    public static volatile String pr = "";
    public static volatile boolean hw = true;

    public static void pr(String str) {
        if (str == null) {
            str = "";
        }
        pr = str;
    }

    public static String pr() {
        return pr;
    }

    public static void pr(boolean z) {
        hw = z;
    }

    public static boolean hw() {
        return hw;
    }
}
