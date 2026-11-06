package com.byazt.mz;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT, 20})
public class hn extends com.byazt.rj.hn implements Runnable {
    public final Runnable x;

    public hn(Runnable runnable) {
        super(runnable);
        this.x = runnable;
        hw(false);
        pr(false);
    }

    @Override // com.byazt.rj.hn, java.lang.Runnable
    public void run() {
        this.x.run();
    }
}
