package com.byazt.xe;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 19})
public final class n {
    public static volatile n qg;
    public volatile qg n;

    private n() {
    }

    public static n n() {
        if (qg == null) {
            synchronized (n.class) {
                if (qg == null) {
                    qg = new n();
                }
            }
        }
        return qg;
    }

    public qg qg() {
        return this.n;
    }
}
