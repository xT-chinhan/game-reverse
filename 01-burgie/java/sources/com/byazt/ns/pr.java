package com.byazt.ns;

/* JADX INFO: loaded from: classes2.dex */
public enum pr {
    USE_KWS(0),
    USE_ALOG(1),
    USE_PITAYA(2),
    USE_OTHER(3);

    public long c;
    public long uc;

    pr(int i) {
        if (i < 0 || i > 63) {
            throw new IllegalArgumentException("bit argument illegal exception,range [0,63]");
        }
        this.c = 1 << i;
        this.uc = i;
    }

    public long pr() {
        return this.c;
    }
}
