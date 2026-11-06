package com.byazt.qm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2253, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public abstract class c implements Runnable {
    public final String hw;

    public abstract void hn();

    public c(String str, Object... objArr) {
        this.hw = vk.pr(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.hw);
        try {
            hn();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
