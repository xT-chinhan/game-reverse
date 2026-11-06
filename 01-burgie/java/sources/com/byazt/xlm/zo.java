package com.byazt.xlm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements ThreadFactory {
    public int hn;
    public final ThreadGroup hw;
    public final String pr;
    public final AtomicInteger x;

    public zo(String str) {
        this(5, str);
    }

    public zo(int i, String str) {
        this.x = new AtomicInteger(1);
        this.hn = i;
        this.hw = new ThreadGroup("csj_g_" + str);
        this.pr = "csj_" + (aj.hw.uc() ? an.ax : "") + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadPr = pr(this.hw, runnable, this.pr + "_" + this.x.getAndIncrement());
        if (threadPr.isDaemon()) {
            threadPr.setDaemon(false);
        }
        int i = this.hn;
        if (i > 10) {
            this.hn = 10;
        } else if (i <= 0) {
            this.hn = 1;
        }
        threadPr.setPriority(this.hn);
        return threadPr;
    }

    public Thread pr(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new com.byazt.fr.hn(threadGroup, runnable, str);
    }
}
