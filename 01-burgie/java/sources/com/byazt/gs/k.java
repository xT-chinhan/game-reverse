package com.byazt.gs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 250})
public class k {
    public static int pr(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable th) {
            return i;
        }
    }
}
