package com.bytedance.sdk.component.panglearmor.ms.ms.ah;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private final int ah;
    private final long d;
    private final ByteBuffer ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final long f1312ms;
    private final long xr;

    public xr(long j, long j2, int i, long j3, ByteBuffer byteBuffer) {
        this.f1312ms = j;
        this.xr = j2;
        this.ah = i;
        this.d = j3;
        this.ka = byteBuffer;
    }

    public long ms() {
        return this.f1312ms;
    }

    public long xr() {
        return this.xr;
    }

    public int ah() {
        return this.ah;
    }

    public long d() {
        return this.d;
    }

    public ByteBuffer ka() {
        return this.ka;
    }
}
