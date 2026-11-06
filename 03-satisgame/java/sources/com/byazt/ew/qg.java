package com.byazt.ew;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 26})
public class qg {
    public int q;
    public fs qg;
    public ScheduledExecutorService n = null;
    public long s = 0;

    public qg(fs fsVar, int i) {
        this.qg = fsVar;
        this.q = i;
    }

    public void n(long j) {
        this.s = j;
    }

    public void n(int i) {
        ScheduledExecutorService scheduledExecutorServiceN = com.byazt.qit.qg.n(1, new com.byazt.qit.fs("/CrashMonitor"));
        this.n = scheduledExecutorServiceN;
        scheduledExecutorServiceN.scheduleAtFixedRate(new Runnable() { // from class: com.byazt.ew.qg.1
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (System.currentTimeMillis() - qg.this.s > qg.this.q) {
                    qg.this.n.shutdown();
                    if (qg.this.qg != null) {
                        qg.this.qg.qg(0, "自动检测卡死");
                    }
                }
            }
        }, 0L, i, TimeUnit.MILLISECONDS);
    }

    public void n() {
        ScheduledExecutorService scheduledExecutorService = this.n;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    public boolean qg() {
        ScheduledExecutorService scheduledExecutorService = this.n;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }
}
