package com.anythink.basead.exoplayer.k;

/* JADX INFO: loaded from: classes.dex */
public final class ac {
    public static final long a = Long.MAX_VALUE;
    private static final long b = 8589934592L;
    private long c;
    private long d;
    private volatile long e = -9223372036854775807L;

    public ac(long j) {
        c(j);
    }

    private synchronized void c(long j) {
        a.b(this.e == -9223372036854775807L);
        this.c = j;
    }

    private long b() {
        return this.c;
    }

    private long c() {
        if (this.e != -9223372036854775807L) {
            return this.e + this.d;
        }
        long j = this.c;
        if (j != Long.MAX_VALUE) {
            return j;
        }
        return -9223372036854775807L;
    }

    public final long a() {
        if (this.c == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.e == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.d;
    }

    private void d() {
        this.e = -9223372036854775807L;
    }

    public final long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.e != -9223372036854775807L) {
            long j2 = (this.e * 90000) / 1000000;
            long j3 = (4294967296L + j2) / b;
            long j4 = ((j3 - 1) * b) + j;
            j += j3 * b;
            if (Math.abs(j4 - j2) < Math.abs(j - j2)) {
                j = j4;
            }
        }
        return b((j * 1000000) / 90000);
    }

    public final long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.e != -9223372036854775807L) {
            this.e = j;
        } else {
            long j2 = this.c;
            if (j2 != Long.MAX_VALUE) {
                this.d = j2 - j;
            }
            synchronized (this) {
                this.e = j;
                notifyAll();
            }
        }
        return j + this.d;
    }

    private synchronized void e() {
        while (this.e == -9223372036854775807L) {
            wait();
        }
    }

    private static long d(long j) {
        return (j * 1000000) / 90000;
    }

    private static long e(long j) {
        return (j * 90000) / 1000000;
    }
}
