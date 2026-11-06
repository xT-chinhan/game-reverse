package com.byazt.xx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MAX_AV_POS_GAP, 13})
public abstract class hw implements Runnable {
    public final String hw;

    public abstract void x();

    public hw(String str, Object... objArr) {
        this.hw = hn.pr(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.hw);
        try {
            x();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
