package com.byazt.hb;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 583, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj implements Runnable {
    public WeakReference<Runnable> n;

    public tj(Runnable runnable) {
        this.n = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.n.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
