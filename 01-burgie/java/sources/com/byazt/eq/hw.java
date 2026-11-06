package com.byazt.eq;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 661, 13})
public class hw {
    public zo hw;
    public int x;
    public ScheduledExecutorService pr = null;
    public long hn = 0;

    public hw(zo zoVar, int i) {
        this.x = 700;
        this.hw = zoVar;
        this.x = i;
    }

    public void pr(long j) {
        this.hn = j;
    }

    public void pr(int i) {
        ScheduledExecutorService scheduledExecutorServicePr = com.byazt.xlm.hw.pr(1, new com.byazt.xlm.zo("/CrashMonitor"));
        this.pr = scheduledExecutorServicePr;
        scheduledExecutorServicePr.scheduleAtFixedRate(new Runnable() { // from class: com.byazt.eq.hw.1
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (System.currentTimeMillis() - hw.this.hn > hw.this.x) {
                    hw.this.pr.shutdown();
                    if (hw.this.hw != null) {
                        hw.this.hw.hw(0, "自动检测卡死");
                    }
                }
            }
        }, 0L, i, TimeUnit.MILLISECONDS);
    }

    public void pr() {
        ScheduledExecutorService scheduledExecutorService = this.pr;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    public boolean hw() {
        ScheduledExecutorService scheduledExecutorService = this.pr;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }
}
