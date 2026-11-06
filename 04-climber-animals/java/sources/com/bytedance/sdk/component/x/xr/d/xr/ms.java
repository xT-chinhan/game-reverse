package com.bytedance.sdk.component.x.xr.d.xr;

import com.baidu.mobads.sdk.internal.bn;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f1554ms;
    private int xr;

    public int ms() {
        return this.f1554ms;
    }

    public int xr() {
        return this.xr;
    }

    ms(int i, int i2, long j) {
        if (i2 < i) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.f1554ms = i;
        this.xr = i2;
    }

    public static ms ms(int i, int i2) {
        return new ms(i, i2, bn.e);
    }

    public static ms ah() {
        return new ms(1, 100, bn.e);
    }
}
