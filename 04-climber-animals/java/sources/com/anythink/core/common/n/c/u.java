package com.anythink.core.common.n.c;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class u extends f {
    final transient byte[][] f;
    final transient int[] g;

    u(c cVar, int i) {
        super(null);
        y.a(cVar.c, 0L, i);
        s sVar = cVar.b;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (sVar.e == sVar.d) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += sVar.e - sVar.d;
            i4++;
            sVar = sVar.h;
        }
        this.f = new byte[i4][];
        this.g = new int[i4 * 2];
        s sVar2 = cVar.b;
        int i5 = 0;
        while (i2 < i) {
            this.f[i5] = sVar2.c;
            i2 += sVar2.e - sVar2.d;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.g;
            iArr[i5] = i2;
            iArr[this.f.length + i5] = sVar2.d;
            sVar2.f = true;
            i5++;
            sVar2 = sVar2.h;
        }
    }

    @Override // com.anythink.core.common.n.c.f
    public final String a() {
        return n().a();
    }

    @Override // com.anythink.core.common.n.c.f
    public final String a(Charset charset) {
        return n().a(charset);
    }

    @Override // com.anythink.core.common.n.c.f
    public final String b() {
        return n().b();
    }

    @Override // com.anythink.core.common.n.c.f
    public final String g() {
        return n().g();
    }

    @Override // com.anythink.core.common.n.c.f
    public final f h() {
        return n().h();
    }

    @Override // com.anythink.core.common.n.c.f
    public final f i() {
        return n().i();
    }

    @Override // com.anythink.core.common.n.c.f
    public final f c() {
        return n().c();
    }

    @Override // com.anythink.core.common.n.c.f
    public final f d() {
        return n().d();
    }

    @Override // com.anythink.core.common.n.c.f
    public final f e() {
        return n().e();
    }

    @Override // com.anythink.core.common.n.c.f
    public final f a(f fVar) {
        return n().a(fVar);
    }

    @Override // com.anythink.core.common.n.c.f
    public final f b(f fVar) {
        return n().b(fVar);
    }

    @Override // com.anythink.core.common.n.c.f
    public final String f() {
        return n().f();
    }

    @Override // com.anythink.core.common.n.c.f
    public final f a(int i) {
        return n().a(i);
    }

    @Override // com.anythink.core.common.n.c.f
    public final f a(int i, int i2) {
        return n().a(i, i2);
    }

    @Override // com.anythink.core.common.n.c.f
    public final byte b(int i) {
        y.a(this.g[this.f.length - 1], i, 1L);
        int iC = c(i);
        int i2 = iC == 0 ? 0 : this.g[iC - 1];
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        return bArr[iC][(i - i2) + iArr[bArr.length + iC]];
    }

    private int c(int i) {
        int iBinarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.anythink.core.common.n.c.f
    public final int j() {
        return this.g[this.f.length - 1];
    }

    @Override // com.anythink.core.common.n.c.f
    public final byte[] k() {
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.anythink.core.common.n.c.f
    public final ByteBuffer m() {
        return ByteBuffer.wrap(k()).asReadOnlyBuffer();
    }

    @Override // com.anythink.core.common.n.c.f
    public final void a(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            outputStream.write(this.f[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    @Override // com.anythink.core.common.n.c.f
    final void a(c cVar) {
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            s sVar = new s(this.f[i], i3, (i3 + i4) - i2, true, false);
            if (cVar.b == null) {
                sVar.i = sVar;
                sVar.h = sVar;
                cVar.b = sVar;
            } else {
                cVar.b.i.a(sVar);
            }
            i++;
            i2 = i4;
        }
        cVar.c += (long) i2;
    }

    @Override // com.anythink.core.common.n.c.f
    public final boolean a(int i, f fVar, int i2, int i3) {
        if (i < 0 || i > j() - i3) {
            return false;
        }
        int iC = c(i);
        while (i3 > 0) {
            int i4 = iC == 0 ? 0 : this.g[iC - 1];
            int iMin = Math.min(i3, ((this.g[iC] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr = this.f;
            if (!fVar.a(i2, bArr[iC], (i - i4) + iArr[bArr.length + iC], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iC++;
        }
        return true;
    }

    @Override // com.anythink.core.common.n.c.f
    public final boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > j() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iC = c(i);
        while (i3 > 0) {
            int i4 = iC == 0 ? 0 : this.g[iC - 1];
            int iMin = Math.min(i3, ((this.g[iC] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr2 = this.f;
            if (!y.a(bArr2[iC], (i - i4) + iArr[bArr2.length + iC], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iC++;
        }
        return true;
    }

    @Override // com.anythink.core.common.n.c.f
    public final int a(byte[] bArr, int i) {
        return n().a(bArr, i);
    }

    @Override // com.anythink.core.common.n.c.f
    public final int b(byte[] bArr, int i) {
        return n().b(bArr, i);
    }

    private f n() {
        return new f(k());
    }

    @Override // com.anythink.core.common.n.c.f
    final byte[] l() {
        return k();
    }

    @Override // com.anythink.core.common.n.c.f
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.j() == j() && a(0, fVar, 0, j())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.anythink.core.common.n.c.f
    public final int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int length = this.f.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.f[i2];
            int[] iArr = this.g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.d = i3;
        return i3;
    }

    @Override // com.anythink.core.common.n.c.f
    public final String toString() {
        return n().toString();
    }

    private Object o() {
        return n();
    }
}
