package com.bytedance.sdk.openadsdk.u;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private int d;
    private x xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ScheduledExecutorService f4214ms = null;
    private long ah = 0;

    public xr(x xVar, int i) {
        this.xr = xVar;
        this.d = i;
    }

    public void ms(long j) {
        this.ah = j;
    }

    public void ms(int i) {
        ScheduledExecutorService scheduledExecutorServiceMs = com.bytedance.sdk.component.ch.ah.ms(1, new com.bytedance.sdk.component.ch.ch("/CrashMonitor"));
        this.f4214ms = scheduledExecutorServiceMs;
        scheduledExecutorServiceMs.scheduleAtFixedRate(new Runnable() { // from class: com.bytedance.sdk.openadsdk.u.xr.1
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (System.currentTimeMillis() - xr.this.ah > xr.this.d) {
                    xr.this.f4214ms.shutdown();
                    if (xr.this.xr != null) {
                        xr.this.xr.xr(0, "自动检测卡死");
                    }
                }
            }
        }, 0L, i, TimeUnit.MILLISECONDS);
    }

    public void ms() {
        ScheduledExecutorService scheduledExecutorService = this.f4214ms;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    public boolean xr() {
        ScheduledExecutorService scheduledExecutorService = this.f4214ms;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }
}
