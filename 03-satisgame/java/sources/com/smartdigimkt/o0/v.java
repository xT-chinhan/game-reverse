package com.smartdigimkt.o0;

/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public final s a;
    public final int b;
    public final long[] c;
    public final int[] d;
    public final int e;
    public final long[] f;
    public final int[] g;
    public final long h;

    public v(s sVar, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        if (iArr.length != jArr2.length) {
            throw new IllegalArgumentException();
        }
        if (jArr.length != jArr2.length) {
            throw new IllegalArgumentException();
        }
        if (iArr2.length != jArr2.length) {
            throw new IllegalArgumentException();
        }
        this.a = sVar;
        this.c = jArr;
        this.d = iArr;
        this.e = i;
        this.f = jArr2;
        this.g = iArr2;
        this.h = j;
        this.b = jArr.length;
    }

    public final int a(long j) {
        for (int iA = com.smartdigimkt.z0.u.a(this.f, j, true, false); iA < this.f.length; iA++) {
            if ((this.g[iA] & 1) != 0) {
                return iA;
            }
        }
        return -1;
    }
}
