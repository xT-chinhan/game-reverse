package com.smartdigimkt.w4;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;

    public static long a(long j, long j2) {
        if (j <= 0 || j2 <= 0 || j2 < j) {
            return -1L;
        }
        return j2 - j;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    public final long b(long j, long j2) {
        long jMax;
        long jA = a(this.a, this.h);
        if (jA < 0) {
            return 0L;
        }
        long j3 = this.g;
        if (j3 > 0) {
            long j4 = this.a;
            if (j4 > 0) {
                jMax = Math.max(0L, j3 - j4);
            } else {
                jMax = 0;
            }
        } else {
            jMax = 0;
        }
        if (jMax <= 0) {
            jMax = 0;
        }
        long jA2 = a(this.b, this.c);
        if (jA2 <= 0) {
            jA2 = 0;
        }
        long j5 = jA2 + jMax;
        long jA3 = a(this.d, this.f);
        if (jA3 <= 0) {
            jA3 = 0;
        }
        long j6 = jA3 + j5;
        if (j <= 0) {
            j = 0;
        }
        long j7 = j + j6;
        if (j2 <= 0) {
            j2 = 0;
        }
        long j8 = jA - (j2 + j7);
        if (j8 > 0) {
            return j8;
        }
        return 0L;
    }
}
