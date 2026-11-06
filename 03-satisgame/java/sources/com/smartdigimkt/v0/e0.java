package com.smartdigimkt.v0;

import java.io.EOFException;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {
    public final com.smartdigimkt.y0.b a;
    public final int b;
    public final b0 c;
    public final a0 d;
    public final com.smartdigimkt.z0.m e;
    public c0 f;
    public c0 g;
    public c0 h;
    public com.smartdigimkt.i0.s i;
    public long j;
    public d0 k;

    public e0(com.smartdigimkt.y0.b bVar) {
        this.a = bVar;
        ((com.smartdigimkt.y0.l) bVar).getClass();
        this.b = 65536;
        this.c = new b0();
        this.d = new a0();
        this.e = new com.smartdigimkt.z0.m(32);
        c0 c0Var = new c0(65536, 0L);
        this.f = c0Var;
        this.g = c0Var;
        this.h = c0Var;
    }

    public final void a() {
        long jA;
        b0 b0Var = this.c;
        synchronized (b0Var) {
            int i = b0Var.i;
            if (i == 0) {
                jA = -1;
            } else {
                jA = b0Var.a(i);
            }
        }
        a(jA);
    }

    public final long b() {
        long j;
        b0 b0Var = this.c;
        synchronized (b0Var) {
            j = b0Var.n;
        }
        return j;
    }

    public final com.smartdigimkt.i0.s c() {
        com.smartdigimkt.i0.s sVar;
        b0 b0Var = this.c;
        synchronized (b0Var) {
            sVar = b0Var.p ? null : b0Var.q;
        }
        return sVar;
    }

    public final void d() {
        b0 b0Var = this.c;
        int i = 0;
        b0Var.i = 0;
        b0Var.j = 0;
        b0Var.k = 0;
        b0Var.l = 0;
        b0Var.o = true;
        b0Var.m = Long.MIN_VALUE;
        b0Var.n = Long.MIN_VALUE;
        c0 c0Var = this.f;
        if (c0Var.c) {
            c0 c0Var2 = this.h;
            int i2 = (((int) (c0Var2.a - c0Var.a)) / this.b) + (c0Var2.c ? 1 : 0);
            com.smartdigimkt.y0.a[] aVarArr = new com.smartdigimkt.y0.a[i2];
            while (i < i2) {
                aVarArr[i] = c0Var.d;
                c0Var.d = null;
                c0 c0Var3 = c0Var.e;
                c0Var.e = null;
                i++;
                c0Var = c0Var3;
            }
            ((com.smartdigimkt.y0.l) this.a).a(aVarArr);
        }
        c0 c0Var4 = new c0(this.b, 0L);
        this.f = c0Var4;
        this.g = c0Var4;
        this.h = c0Var4;
        this.j = 0L;
        ((com.smartdigimkt.y0.l) this.a).a();
    }

    public final int a(long j, boolean z) {
        b0 b0Var = this.c;
        synchronized (b0Var) {
            int iC = b0Var.c(b0Var.l);
            if (b0Var.a() && j >= b0Var.f[iC] && (j <= b0Var.n || z)) {
                int iA = b0Var.a(iC, b0Var.i - b0Var.l, j, true);
                if (iA == -1) {
                    return -1;
                }
                b0Var.l += iA;
                return iA;
            }
            return -1;
        }
    }

    public final void a(long j, byte[] bArr, int i) {
        while (true) {
            c0 c0Var = this.g;
            if (j < c0Var.b) {
                break;
            } else {
                this.g = c0Var.e;
            }
        }
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (this.g.b - j));
            c0 c0Var2 = this.g;
            com.smartdigimkt.y0.a aVar = c0Var2.d;
            System.arraycopy(aVar.a, ((int) (j - c0Var2.a)) + aVar.b, bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            c0 c0Var3 = this.g;
            if (j == c0Var3.b) {
                this.g = c0Var3.e;
            }
        }
    }

    public final void a(long j) {
        c0 c0Var;
        if (j == -1) {
            return;
        }
        while (true) {
            c0Var = this.f;
            if (j < c0Var.b) {
                break;
            }
            com.smartdigimkt.y0.b bVar = this.a;
            com.smartdigimkt.y0.a aVar = c0Var.d;
            com.smartdigimkt.y0.l lVar = (com.smartdigimkt.y0.l) bVar;
            synchronized (lVar) {
                com.smartdigimkt.y0.a[] aVarArr = lVar.a;
                aVarArr[0] = aVar;
                lVar.a(aVarArr);
            }
            c0 c0Var2 = this.f;
            c0Var2.d = null;
            c0 c0Var3 = c0Var2.e;
            c0Var2.e = null;
            this.f = c0Var3;
        }
        if (this.g.a < c0Var.a) {
            this.g = c0Var;
        }
    }

    public final void a(com.smartdigimkt.i0.s sVar) {
        boolean z;
        if (sVar == null) {
            sVar = null;
        }
        b0 b0Var = this.c;
        synchronized (b0Var) {
            z = true;
            try {
                if (sVar == null) {
                    b0Var.p = true;
                } else {
                    b0Var.p = false;
                    if (!com.smartdigimkt.z0.u.a(sVar, b0Var.q)) {
                        b0Var.q = sVar;
                    }
                }
                z = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        d0 d0Var = this.k;
        if (d0Var == null || !z) {
            return;
        }
        i iVar = (i) d0Var;
        iVar.n.post(iVar.l);
    }

    public final int a(com.smartdigimkt.n0.c cVar, int i) throws InterruptedException, EOFException {
        int iA = a(i);
        c0 c0Var = this.h;
        com.smartdigimkt.y0.a aVar = c0Var.d;
        byte[] bArr = aVar.a;
        int i2 = ((int) (this.j - c0Var.a)) + aVar.b;
        int i3 = cVar.g;
        int iA2 = 0;
        if (i3 != 0) {
            int iMin = Math.min(i3, iA);
            System.arraycopy(cVar.e, 0, bArr, i2, iMin);
            int i4 = cVar.g - iMin;
            cVar.g = i4;
            cVar.f = 0;
            byte[] bArr2 = cVar.e;
            byte[] bArr3 = i4 < bArr2.length - 524288 ? new byte[65536 + i4] : bArr2;
            System.arraycopy(bArr2, iMin, bArr3, 0, i4);
            cVar.e = bArr3;
            iA2 = iMin;
        }
        if (iA2 == 0) {
            iA2 = cVar.a(bArr, i2, iA, 0, true);
        }
        if (iA2 != -1) {
            cVar.d += (long) iA2;
        }
        if (iA2 != -1) {
            long j = this.j + ((long) iA2);
            this.j = j;
            c0 c0Var2 = this.h;
            if (j == c0Var2.b) {
                this.h = c0Var2.e;
            }
            return iA2;
        }
        throw new EOFException();
    }

    public final void a(int i, com.smartdigimkt.z0.m mVar) {
        while (i > 0) {
            int iA = a(i);
            c0 c0Var = this.h;
            com.smartdigimkt.y0.a aVar = c0Var.d;
            mVar.a(aVar.a, ((int) (this.j - c0Var.a)) + aVar.b, iA);
            i -= iA;
            long j = this.j + ((long) iA);
            this.j = j;
            c0 c0Var2 = this.h;
            if (j == c0Var2.b) {
                this.h = c0Var2.e;
            }
        }
    }

    public final void a(long j, int i, int i2, int i3, com.smartdigimkt.n0.n nVar) {
        this.c.a(j, i, (this.j - ((long) i2)) - ((long) i3), i2, nVar);
    }

    public final int a(int i) {
        com.smartdigimkt.y0.a aVar;
        c0 c0Var = this.h;
        if (!c0Var.c) {
            com.smartdigimkt.y0.l lVar = (com.smartdigimkt.y0.l) this.a;
            synchronized (lVar) {
                lVar.c++;
                int i2 = lVar.d;
                if (i2 > 0) {
                    com.smartdigimkt.y0.a[] aVarArr = lVar.e;
                    int i3 = i2 - 1;
                    lVar.d = i3;
                    aVar = aVarArr[i3];
                    aVarArr[i3] = null;
                } else {
                    aVar = new com.smartdigimkt.y0.a(0, new byte[65536]);
                }
            }
            c0 c0Var2 = new c0(this.b, this.h.b);
            c0Var.d = aVar;
            c0Var.e = c0Var2;
            c0Var.c = true;
        }
        return Math.min(i, (int) (this.h.b - this.j));
    }
}
