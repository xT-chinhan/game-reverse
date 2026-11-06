package com.byazt.ee;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 48})
public class lb extends Exception {
    public final int pr;

    public lb(int i) {
        this.pr = i;
    }

    public lb(int i, String str) {
        super(str);
        this.pr = i;
    }
}
