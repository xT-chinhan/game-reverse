package com.byazt.ncu;

import com.byazt.qit.fs;
import com.byazt.qit.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE, 5})
public class q implements ThreadFactory {
    public final ThreadFactory n;
    public final int qg;

    public q(ThreadFactory threadFactory, int i) {
        if (threadFactory == null) {
            this.n = new fs("default");
        } else {
            this.n = threadFactory;
        }
        this.qg = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.n.newThread(runnable);
        return qg() ? new x(threadNewThread) : threadNewThread;
    }

    public final String n() {
        return this.n.getClass().getName();
    }

    public boolean qg() {
        return rv.qg.qg(this.qg);
    }
}
