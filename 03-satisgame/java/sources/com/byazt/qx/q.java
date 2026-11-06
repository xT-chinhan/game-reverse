package com.byazt.qx;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 843, 5})
public class q extends BaseException {
    public final long n;
    public final long qg;

    public q(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.n = j;
        this.qg = j2;
    }

    public long n() {
        return this.n;
    }

    public long qg() {
        return this.qg;
    }
}
