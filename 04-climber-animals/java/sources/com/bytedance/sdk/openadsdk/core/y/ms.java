package com.bytedance.sdk.openadsdk.core.y;

/* JADX INFO: loaded from: classes2.dex */
public enum ms {
    USE_KWS(0),
    USE_ALOG(1),
    USE_PITAYA(2),
    USE_OTHER(3);

    private long c;
    private long ka;

    ms(int i) {
        if (i < 0 || i > 63) {
            throw new IllegalArgumentException("bit argument illegal exception,range [0,63]");
        }
        this.ka = 1 << i;
        this.c = i;
    }

    public long ms() {
        return this.ka;
    }
}
