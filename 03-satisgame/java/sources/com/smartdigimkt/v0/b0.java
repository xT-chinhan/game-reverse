package com.smartdigimkt.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {
    public int i;
    public int j;
    public int k;
    public int l;
    public com.smartdigimkt.i0.s q;
    public int a = 1000;
    public int[] b = new int[1000];
    public long[] c = new long[1000];
    public long[] f = new long[1000];
    public int[] e = new int[1000];
    public int[] d = new int[1000];
    public com.smartdigimkt.n0.n[] g = new com.smartdigimkt.n0.n[1000];
    public com.smartdigimkt.i0.s[] h = new com.smartdigimkt.i0.s[1000];
    public long m = Long.MIN_VALUE;
    public long n = Long.MIN_VALUE;
    public boolean p = true;
    public boolean o = true;

    public final synchronized boolean a() {
        return this.l != this.i;
    }

    public final long b(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iC = c(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.f[iC]);
            if ((this.e[iC] & 1) != 0) {
                break;
            }
            iC--;
            if (iC == -1) {
                iC = this.a - 1;
            }
        }
        return jMax;
    }

    public final int c(int i) {
        int i2 = this.k + i;
        int i3 = this.a;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public final synchronized void a(long j, int i, long j2, int i2, com.smartdigimkt.n0.n nVar) {
        if (this.o) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.o = false;
            }
        }
        if (!(!this.p)) {
            throw new IllegalStateException();
        }
        a(j);
        int iC = c(this.i);
        this.f[iC] = j;
        long[] jArr = this.c;
        jArr[iC] = j2;
        this.d[iC] = i2;
        this.e[iC] = i;
        this.g[iC] = nVar;
        this.h[iC] = this.q;
        this.b[iC] = 0;
        int i3 = this.i + 1;
        this.i = i3;
        int i4 = this.a;
        if (i3 == i4) {
            int i5 = i4 + 1000;
            int[] iArr = new int[i5];
            long[] jArr2 = new long[i5];
            long[] jArr3 = new long[i5];
            int[] iArr2 = new int[i5];
            int[] iArr3 = new int[i5];
            com.smartdigimkt.n0.n[] nVarArr = new com.smartdigimkt.n0.n[i5];
            com.smartdigimkt.i0.s[] sVarArr = new com.smartdigimkt.i0.s[i5];
            int i6 = this.k;
            int i7 = i4 - i6;
            System.arraycopy(jArr, i6, jArr2, 0, i7);
            System.arraycopy(this.f, this.k, jArr3, 0, i7);
            System.arraycopy(this.e, this.k, iArr2, 0, i7);
            System.arraycopy(this.d, this.k, iArr3, 0, i7);
            System.arraycopy(this.g, this.k, nVarArr, 0, i7);
            System.arraycopy(this.h, this.k, sVarArr, 0, i7);
            System.arraycopy(this.b, this.k, iArr, 0, i7);
            int i8 = this.k;
            System.arraycopy(this.c, 0, jArr2, i7, i8);
            System.arraycopy(this.f, 0, jArr3, i7, i8);
            System.arraycopy(this.e, 0, iArr2, i7, i8);
            System.arraycopy(this.d, 0, iArr3, i7, i8);
            System.arraycopy(this.g, 0, nVarArr, i7, i8);
            System.arraycopy(this.h, 0, sVarArr, i7, i8);
            System.arraycopy(this.b, 0, iArr, i7, i8);
            this.c = jArr2;
            this.f = jArr3;
            this.e = iArr2;
            this.d = iArr3;
            this.g = nVarArr;
            this.h = sVarArr;
            this.b = iArr;
            this.k = 0;
            this.i = this.a;
            this.a = i5;
        }
    }

    public final synchronized void a(long j) {
        this.n = Math.max(this.n, j);
    }

    public final int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2 && this.f[i] <= j; i4++) {
            if (!z || (this.e[i] & 1) != 0) {
                i3 = i4;
            }
            i++;
            if (i == this.a) {
                i = 0;
            }
        }
        return i3;
    }

    public final long a(int i) {
        this.m = Math.max(this.m, b(i));
        int i2 = this.i - i;
        this.i = i2;
        this.j += i;
        int i3 = this.k + i;
        this.k = i3;
        int i4 = this.a;
        if (i3 >= i4) {
            this.k = i3 - i4;
        }
        int i5 = this.l - i;
        this.l = i5;
        if (i5 < 0) {
            this.l = 0;
        }
        if (i2 == 0) {
            int i6 = this.k;
            if (i6 != 0) {
                i4 = i6;
            }
            int i7 = i4 - 1;
            return this.c[i7] + ((long) this.d[i7]);
        }
        return this.c[this.k];
    }
}
