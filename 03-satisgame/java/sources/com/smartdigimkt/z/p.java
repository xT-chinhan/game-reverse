package com.smartdigimkt.z;

/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public static volatile p f;
    public int a;
    public int b;
    public int c;
    public long d = -1;
    public long e = -1;

    public static p a() {
        if (f == null) {
            synchronized (p.class) {
                if (f == null) {
                    f = new p();
                }
            }
        }
        return f;
    }

    public final synchronized int b() {
        return this.a;
    }

    public final synchronized int c() {
        return this.b;
    }

    public final synchronized int d() {
        return this.c;
    }

    public final synchronized long e() {
        return this.e;
    }

    public final synchronized void f() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = -1L;
        this.e = -1L;
    }

    public final synchronized void a(float f2, float f3, float f4, long j, long j2) {
        int iRound = Math.round(f2);
        int i = 180;
        if (iRound < -180) {
            iRound = -180;
        } else if (iRound > 180) {
            iRound = 180;
        }
        this.a = iRound;
        int iRound2 = Math.round(f3);
        if (iRound2 < -180) {
            iRound2 = -180;
        } else if (iRound2 > 180) {
            iRound2 = 180;
        }
        this.b = iRound2;
        int iRound3 = Math.round(f4);
        if (iRound3 < -180) {
            i = -180;
        } else if (iRound3 <= 180) {
            i = iRound3;
        }
        this.c = i;
        this.d = j;
        this.e = j2;
    }
}
