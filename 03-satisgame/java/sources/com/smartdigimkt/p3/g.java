package com.smartdigimkt.p3;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public final f a;
    public final int b;
    public int c;
    public int d;
    public long e = -1;
    public volatile boolean f;
    public volatile boolean g;
    public boolean h;

    public g(f fVar, int i) {
        this.a = fVar;
        if (i >= 0) {
            int[] iArr = fVar.d;
            int i2 = i < iArr.length ? iArr[i] : 100;
            this.b = i2;
        }
        fVar.getClass();
        this.b = i2;
    }

    public final void a(long j, boolean z, boolean z2, long j2, long j3) {
        int i = 0;
        int i2 = z ? 0 : 32;
        f fVar = this.a;
        if (fVar.c && !z2) {
            i2 |= 8;
        }
        boolean z3 = j2 >= ((long) fVar.b);
        boolean z4 = j3 > 0 && 100 * j2 >= ((long) fVar.a) * j3;
        this.c = ((!z || z3) ? 0 : 2) | i2;
        if (z && !z3 && !z4) {
            i = 3;
        }
        int i3 = i | i2;
        this.d = i3;
        if (i3 != 0) {
            this.e = -1L;
        } else if (this.e < 0) {
            this.e = j;
        }
        int i4 = this.b;
        if (i4 > 0) {
            long j4 = this.e;
            if (j4 < 0 || j - j4 < i4) {
                this.d = i3 | 4;
            }
        }
    }
}
