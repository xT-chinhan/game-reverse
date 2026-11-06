package com.byazt.lro;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb extends Exception {
    public final int pr;

    public yb(int i, String str) {
        super(str);
        this.pr = i;
    }

    public yb(int i, String str, Throwable th) {
        super(str, th);
        this.pr = i;
    }
}
