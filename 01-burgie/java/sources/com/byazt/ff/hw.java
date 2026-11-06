package com.byazt.ff;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1946, 13})
public class hw {
    public final ByteBuffer c;
    public final int hn;
    public final long hw;
    public final long pr;
    public final long x;

    public hw(long j, long j2, int i, long j3, ByteBuffer byteBuffer) {
        this.pr = j;
        this.hw = j2;
        this.hn = i;
        this.x = j3;
        this.c = byteBuffer;
    }

    public long pr() {
        return this.pr;
    }

    public long hw() {
        return this.hw;
    }

    public int hn() {
        return this.hn;
    }

    public long x() {
        return this.x;
    }

    public ByteBuffer c() {
        return this.c;
    }
}
