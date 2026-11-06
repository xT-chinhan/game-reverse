package com.anythink.basead.exoplayer.h;

import java.io.EOFException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class x implements com.anythink.basead.exoplayer.e.m {
    public static final int a = -1;
    private static final int b = 32;
    private final com.anythink.basead.exoplayer.j.b c;
    private final int d;
    private final w e;
    private final w.a f;
    private final com.anythink.basead.exoplayer.k.s g;
    private a h;
    private a i;
    private a j;
    private com.anythink.basead.exoplayer.m k;
    private boolean l;
    private com.anythink.basead.exoplayer.m m;
    private long n;
    private long o;
    private boolean p;
    private b q;

    public interface b {
        void i();
    }

    public x(com.anythink.basead.exoplayer.j.b bVar) {
        this.c = bVar;
        int iD = bVar.d();
        this.d = iD;
        this.e = new w();
        this.f = new w.a();
        this.g = new com.anythink.basead.exoplayer.k.s(32);
        a aVar = new a(0L, iD);
        this.h = aVar;
        this.i = aVar;
        this.j = aVar;
    }

    private void l() {
        this.e.a();
        a(this.h);
        a aVar = new a(0L, this.d);
        this.h = aVar;
        this.i = aVar;
        this.j = aVar;
        this.o = 0L;
        this.c.b();
    }

    private void c(int i) {
        this.e.b(i);
    }

    private void m() {
        this.p = true;
    }

    public final int b() {
        return this.e.b();
    }

    public final void a(int i) {
        long jA = this.e.a(i);
        this.o = jA;
        if (jA == 0 || jA == this.h.a) {
            a(this.h);
            a aVar = new a(this.o, this.d);
            this.h = aVar;
            this.i = aVar;
            this.j = aVar;
            return;
        }
        a aVar2 = this.h;
        while (this.o > aVar2.b) {
            aVar2 = aVar2.e;
        }
        a aVar3 = aVar2.e;
        a(aVar3);
        aVar2.e = new a(aVar2.b, this.d);
        this.j = this.o == aVar2.b ? aVar2.e : aVar2;
        if (this.i == aVar3) {
            this.i = aVar2.e;
        }
    }

    public final boolean c() {
        return this.e.f();
    }

    public final int d() {
        return this.e.c();
    }

    public final int e() {
        return this.e.d();
    }

    private int n() {
        return this.e.e();
    }

    public final com.anythink.basead.exoplayer.m f() {
        return this.e.g();
    }

    public final long g() {
        return this.e.h();
    }

    public final long h() {
        return this.e.i();
    }

    public final void i() {
        this.e.j();
        this.i = this.h;
    }

    public final void a(long j, boolean z, boolean z2) {
        c(this.e.a(j, z, z2));
    }

    private void o() {
        c(this.e.l());
    }

    public final void j() {
        c(this.e.m());
    }

    public final int k() {
        return this.e.k();
    }

    public final int a(long j, boolean z) {
        return this.e.a(j, z);
    }

    public final boolean b(int i) {
        return this.e.c(i);
    }

    public final int a(com.anythink.basead.exoplayer.n nVar, com.anythink.basead.exoplayer.c.e eVar, boolean z, boolean z2, long j) {
        int iA = this.e.a(nVar, eVar, z, z2, this.k, this.f);
        if (iA == -5) {
            this.k = nVar.a;
            return -5;
        }
        if (iA != -4) {
            if (iA == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!eVar.c()) {
            if (eVar.f < j) {
                eVar.b(Integer.MIN_VALUE);
            }
            if (eVar.g()) {
                w.a aVar = this.f;
                long j2 = aVar.b;
                int iE = 1;
                this.g.a(1);
                a(j2, this.g.a, 1);
                long j3 = j2 + 1;
                byte b2 = this.g.a[0];
                boolean z3 = (b2 & 128) != 0;
                int i = b2 & 127;
                if (eVar.d.a == null) {
                    eVar.d.a = new byte[16];
                }
                a(j3, eVar.d.a, i);
                long j4 = j3 + ((long) i);
                if (z3) {
                    this.g.a(2);
                    a(j4, this.g.a, 2);
                    j4 += 2;
                    iE = this.g.e();
                }
                int i2 = iE;
                int[] iArr = eVar.d.d;
                if (iArr == null || iArr.length < i2) {
                    iArr = new int[i2];
                }
                int[] iArr2 = iArr;
                int[] iArr3 = eVar.d.e;
                if (iArr3 == null || iArr3.length < i2) {
                    iArr3 = new int[i2];
                }
                int[] iArr4 = iArr3;
                if (z3) {
                    int i3 = i2 * 6;
                    this.g.a(i3);
                    a(j4, this.g.a, i3);
                    j4 += (long) i3;
                    this.g.c(0);
                    for (int i4 = 0; i4 < i2; i4++) {
                        iArr2[i4] = this.g.e();
                        iArr4[i4] = this.g.m();
                    }
                } else {
                    iArr2[0] = 0;
                    iArr4[0] = aVar.a - ((int) (j4 - aVar.b));
                }
                com.anythink.basead.exoplayer.e.m.a aVar2 = aVar.c;
                eVar.d.a(i2, iArr2, iArr4, aVar2.b, eVar.d.a, aVar2.a, aVar2.c, aVar2.d);
                int i5 = (int) (j4 - aVar.b);
                aVar.b += (long) i5;
                aVar.a -= i5;
            }
            eVar.d(this.f.a);
            long j5 = this.f.b;
            ByteBuffer byteBuffer = eVar.e;
            int i6 = this.f.a;
            b(j5);
            while (i6 > 0) {
                int iMin = Math.min(i6, (int) (this.i.b - j5));
                byteBuffer.put(this.i.d.a, this.i.a(j5), iMin);
                i6 -= iMin;
                j5 += (long) iMin;
                if (j5 == this.i.b) {
                    this.i = this.i.e;
                }
            }
        }
        return -4;
    }

    private void a(com.anythink.basead.exoplayer.c.e eVar, w.a aVar) {
        long j = aVar.b;
        int iE = 1;
        this.g.a(1);
        a(j, this.g.a, 1);
        long j2 = j + 1;
        byte b2 = this.g.a[0];
        boolean z = (b2 & 128) != 0;
        int i = b2 & 127;
        if (eVar.d.a == null) {
            eVar.d.a = new byte[16];
        }
        a(j2, eVar.d.a, i);
        long j3 = j2 + ((long) i);
        if (z) {
            this.g.a(2);
            a(j3, this.g.a, 2);
            j3 += 2;
            iE = this.g.e();
        }
        int i2 = iE;
        int[] iArr = eVar.d.d;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = eVar.d.e;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i2 * 6;
            this.g.a(i3);
            a(j3, this.g.a, i3);
            j3 += (long) i3;
            this.g.c(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = this.g.e();
                iArr4[i4] = this.g.m();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar.a - ((int) (j3 - aVar.b));
        }
        com.anythink.basead.exoplayer.e.m.a aVar2 = aVar.c;
        eVar.d.a(i2, iArr2, iArr4, aVar2.b, eVar.d.a, aVar2.a, aVar2.c, aVar2.d);
        int i5 = (int) (j3 - aVar.b);
        aVar.b += (long) i5;
        aVar.a -= i5;
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        b(j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (this.i.b - j));
            byteBuffer.put(this.i.d.a, this.i.a(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == this.i.b) {
                this.i = this.i.e;
            }
        }
    }

    private void a(long j, byte[] bArr, int i) {
        b(j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (this.i.b - j));
            System.arraycopy(this.i.d.a, this.i.a(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == this.i.b) {
                this.i = this.i.e;
            }
        }
    }

    private void b(long j) {
        while (j >= this.i.b) {
            this.i = this.i.e;
        }
    }

    private void c(long j) {
        if (j == -1) {
            return;
        }
        while (j >= this.h.b) {
            this.c.a(this.h.d);
            this.h = this.h.a();
        }
        if (this.i.a < this.h.a) {
            this.i = this.h;
        }
    }

    public final void a(b bVar) {
        this.q = bVar;
    }

    public final void a(long j) {
        if (this.n != j) {
            this.n = j;
            this.l = true;
        }
    }

    @Override // com.anythink.basead.exoplayer.e.m
    public final void a(com.anythink.basead.exoplayer.m mVar) {
        com.anythink.basead.exoplayer.m mVarA;
        long j = this.n;
        if (mVar == null) {
            mVarA = null;
        } else {
            mVarA = (j == 0 || mVar.l == Long.MAX_VALUE) ? mVar : mVar.a(mVar.l + j);
        }
        boolean zA = this.e.a(mVarA);
        this.m = mVar;
        this.l = false;
        b bVar = this.q;
        if (bVar == null || !zA) {
            return;
        }
        bVar.i();
    }

    @Override // com.anythink.basead.exoplayer.e.m
    public final int a(com.anythink.basead.exoplayer.e.f fVar, int i, boolean z) throws EOFException {
        int iA = fVar.a(this.j.d.a, this.j.a(this.o), d(i));
        if (iA != -1) {
            e(iA);
            return iA;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.anythink.basead.exoplayer.e.m
    public final void a(com.anythink.basead.exoplayer.k.s sVar, int i) {
        while (i > 0) {
            int iD = d(i);
            sVar.a(this.j.d.a, this.j.a(this.o), iD);
            i -= iD;
            e(iD);
        }
    }

    @Override // com.anythink.basead.exoplayer.e.m
    public final void a(long j, int i, int i2, int i3, com.anythink.basead.exoplayer.e.m.a aVar) {
        if (this.l) {
            a(this.m);
        }
        if (this.p) {
            if ((i & 1) == 0 || !this.e.a(j)) {
                return;
            } else {
                this.p = false;
            }
        }
        this.e.a(j + this.n, i, (this.o - ((long) i2)) - ((long) i3), i2, aVar);
    }

    private void a(a aVar) {
        if (aVar.c) {
            boolean z = this.j.c;
            int i = (z ? 1 : 0) + (((int) (this.j.a - aVar.a)) / this.d);
            com.anythink.basead.exoplayer.j.a[] aVarArr = new com.anythink.basead.exoplayer.j.a[i];
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2] = aVar.d;
                aVar = aVar.a();
            }
            this.c.a(aVarArr);
        }
    }

    private int d(int i) {
        if (!this.j.c) {
            this.j.a(this.c.a(), new a(this.j.b, this.d));
        }
        return Math.min(i, (int) (this.j.b - this.o));
    }

    private void e(int i) {
        long j = this.o + ((long) i);
        this.o = j;
        if (j == this.j.b) {
            this.j = this.j.e;
        }
    }

    private static com.anythink.basead.exoplayer.m a(com.anythink.basead.exoplayer.m mVar, long j) {
        if (mVar == null) {
            return null;
        }
        return (j == 0 || mVar.l == Long.MAX_VALUE) ? mVar : mVar.a(mVar.l + j);
    }

    private static final class a {
        public final long a;
        public final long b;
        public boolean c;
        public com.anythink.basead.exoplayer.j.a d;
        public a e;

        public a(long j, int i) {
            this.a = j;
            this.b = j + ((long) i);
        }

        public final void a(com.anythink.basead.exoplayer.j.a aVar, a aVar2) {
            this.d = aVar;
            this.e = aVar2;
            this.c = true;
        }

        public final int a(long j) {
            return ((int) (j - this.a)) + this.d.b;
        }

        public final a a() {
            this.d = null;
            a aVar = this.e;
            this.e = null;
            return aVar;
        }
    }

    public final void a() {
        this.e.a();
        a(this.h);
        a aVar = new a(0L, this.d);
        this.h = aVar;
        this.i = aVar;
        this.j = aVar;
        this.o = 0L;
        this.c.b();
    }
}
