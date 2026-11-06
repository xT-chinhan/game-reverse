package com.byazt.vzq;

/* JADX INFO: loaded from: classes2.dex */
public enum n {
    USE_KWS(0),
    USE_ALOG(1),
    USE_PITAYA(2),
    USE_OTHER(3);

    public long l;
    public long w;

    n(int i) {
        if (i < 0 || i > 63) {
            throw new IllegalArgumentException("bit argument illegal exception,range [0,63]");
        }
        this.l = 1 << i;
        this.w = i;
    }

    public long n() {
        return this.l;
    }
}
