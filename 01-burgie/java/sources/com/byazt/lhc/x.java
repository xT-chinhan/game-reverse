package com.byazt.lhc;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 502, 121})
public class x extends BaseException {
    public final long hw;
    public final long pr;

    public x(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.pr = j;
        this.hw = j2;
    }

    public long pr() {
        return this.pr;
    }

    public long hw() {
        return this.hw;
    }
}
