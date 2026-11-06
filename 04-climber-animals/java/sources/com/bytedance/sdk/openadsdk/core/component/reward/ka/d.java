package com.bytedance.sdk.openadsdk.core.component.reward.ka;

import com.bytedance.sdk.openadsdk.core.ch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.bytedance.sdk.openadsdk.core.jw.ms.xr {
    private long ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    long f2190ms;
    private long xr;

    public d() {
        ch.ub().ms(this);
    }

    public void ah() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.xr;
        if (j != 0) {
            this.f2190ms += jCurrentTimeMillis - j;
        }
        this.xr = jCurrentTimeMillis;
    }

    public void d() {
        if (this.xr == 0) {
            return;
        }
        this.f2190ms += System.currentTimeMillis() - this.xr;
        this.xr = 0L;
        this.ah = 0L;
    }

    public long ms(TimeUnit timeUnit) {
        if (timeUnit != null) {
            return timeUnit.convert(this.f2190ms, TimeUnit.MILLISECONDS);
        }
        return this.f2190ms;
    }

    public void ka() {
        this.xr = 0L;
        this.ah = 0L;
        this.f2190ms = 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
    public void ms() {
        d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
    public void xr() {
        ah();
    }
}
