package com.byazt.cvl;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, 62})
public class fw {
    public static volatile fw pr = null;
    public com.byazt.zv.uc hw = null;

    private fw() {
    }

    public static fw pr() {
        if (pr == null) {
            synchronized (fw.class) {
                if (pr == null) {
                    pr = new fw();
                }
            }
        }
        return pr;
    }

    public com.byazt.zv.uc hw() {
        return this.hw;
    }
}
