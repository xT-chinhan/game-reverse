package com.byazt.qit;

import com.anythink.core.common.l.f;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 101})
public class fs implements ThreadFactory {
    public final String n;
    public final AtomicInteger q;
    public final ThreadGroup qg;
    public int s;

    public fs(String str) {
        this(5, str);
    }

    public fs(int i, String str) {
        this.q = new AtomicInteger(1);
        this.s = i;
        this.qg = new ThreadGroup("csj_g_" + str);
        this.n = "csj_" + (rv.qg.w() ? f.W : "") + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadN = n(this.qg, runnable, this.n + "_" + this.q.getAndIncrement());
        if (threadN.isDaemon()) {
            threadN.setDaemon(false);
        }
        int i = this.s;
        if (i > 10) {
            this.s = 10;
        } else if (i <= 0) {
            this.s = 1;
        }
        threadN.setPriority(this.s);
        return threadN;
    }

    public Thread n(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new com.byazt.xis.s(threadGroup, runnable, str);
    }
}
