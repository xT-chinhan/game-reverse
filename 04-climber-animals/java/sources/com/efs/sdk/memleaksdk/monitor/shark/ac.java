package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class ac extends ae {
    private float b = 0.0f;
    private int c = 0;

    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public String d() {
        return "reason_heap_memory";
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public boolean b() {
        float f = ah.i.e;
        if (f > a().getHeapThreshold() && f >= this.b - 0.05f) {
            this.c++;
            g.c("UMonitor.Heap", String.format(Locale.US, "match overThresholdCount: %d, heapRatio: %f, used: %fMB, max: %fMB", Integer.valueOf(this.c), Float.valueOf(f), Float.valueOf(ai.a.b(ah.i.d)), Float.valueOf(ai.a.b(ah.i.a))));
        } else {
            c();
        }
        this.b = f;
        return this.c >= a().getMaxOverThresholdCount();
    }

    public void c() {
        this.b = 0.0f;
        this.c = 0;
    }
}
