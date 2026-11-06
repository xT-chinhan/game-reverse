package com.anythink.core.common.n.c;

import com.umeng.analytics.pro.ek;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
final class r implements e {
    public final c a = new c();
    public final w b;
    boolean c;

    r(w wVar) {
        if (wVar == null) {
            throw new NullPointerException("source == null");
        }
        this.b = wVar;
    }

    @Override // com.anythink.core.common.n.c.e
    public final c c() {
        return this.a;
    }

    @Override // com.anythink.core.common.n.c.e
    public final c d() {
        return this.a;
    }

    @Override // com.anythink.core.common.n.c.w
    public final long a_(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.c == 0 && this.b.a_(this.a, 8192L) == -1) {
            return -1L;
        }
        return this.a.a_(cVar, Math.min(j, this.a.c));
    }

    @Override // com.anythink.core.common.n.c.e
    public final boolean g() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.a.g() && this.b.a_(this.a, 8192L) == -1;
    }

    @Override // com.anythink.core.common.n.c.e
    public final void a(long j) throws EOFException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    @Override // com.anythink.core.common.n.c.e
    public final boolean b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (this.a.c < j) {
            if (this.b.a_(this.a, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.anythink.core.common.n.c.e
    public final byte k() throws EOFException {
        a(1L);
        return this.a.k();
    }

    @Override // com.anythink.core.common.n.c.e
    public final f t() {
        this.a.a(this.b);
        return this.a.t();
    }

    @Override // com.anythink.core.common.n.c.e
    public final f d(long j) throws EOFException {
        a(j);
        return this.a.d(j);
    }

    @Override // com.anythink.core.common.n.c.e
    public final int a(o oVar) throws EOFException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        do {
            int iA = this.a.a(oVar, true);
            if (iA == -1) {
                return -1;
            }
            if (iA != -2) {
                this.a.i(oVar.a[iA].j());
                return iA;
            }
        } while (this.b.a_(this.a, 8192L) != -1);
        return -1;
    }

    @Override // com.anythink.core.common.n.c.e
    public final byte[] y() {
        this.a.a(this.b);
        return this.a.y();
    }

    @Override // com.anythink.core.common.n.c.e
    public final byte[] h(long j) throws EOFException {
        a(j);
        return this.a.h(j);
    }

    @Override // com.anythink.core.common.n.c.e
    public final int a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    @Override // com.anythink.core.common.n.c.e
    public final void b(byte[] bArr) throws EOFException {
        try {
            a(bArr.length);
            this.a.b(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.a.c > 0) {
                c cVar = this.a;
                int iA = cVar.a(bArr, i, (int) cVar.c);
                if (iA == -1) {
                    throw new AssertionError();
                }
                i += iA;
            }
            throw e;
        }
    }

    @Override // com.anythink.core.common.n.c.e
    public final int a(byte[] bArr, int i, int i2) {
        long j = i2;
        y.a(bArr.length, i, j);
        if (this.a.c == 0 && this.b.a_(this.a, 8192L) == -1) {
            return -1;
        }
        return this.a.a(bArr, i, (int) Math.min(j, this.a.c));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        if (this.a.c == 0 && this.b.a_(this.a, 8192L) == -1) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }

    @Override // com.anythink.core.common.n.c.e
    public final void b(c cVar, long j) throws EOFException {
        try {
            a(j);
            this.a.b(cVar, j);
        } catch (EOFException e) {
            cVar.a((w) this.a);
            throw e;
        }
    }

    @Override // com.anythink.core.common.n.c.e
    public final long a(v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.b.a_(this.a, 8192L) != -1) {
            long j2 = this.a.j();
            if (j2 > 0) {
                j += j2;
                vVar.a(this.a, j2);
            }
        }
        if (this.a.c <= 0) {
            return j;
        }
        long j3 = j + this.a.c;
        c cVar = this.a;
        vVar.a(cVar, cVar.c);
        return j3;
    }

    @Override // com.anythink.core.common.n.c.e
    public final String u() {
        this.a.a(this.b);
        return this.a.u();
    }

    @Override // com.anythink.core.common.n.c.e
    public final String e(long j) throws EOFException {
        a(j);
        return this.a.e(j);
    }

    @Override // com.anythink.core.common.n.c.e
    public final String a(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.a.a(this.b);
        return this.a.a(charset);
    }

    @Override // com.anythink.core.common.n.c.e
    public final String a(long j, Charset charset) throws EOFException {
        a(j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        return this.a.a(j, charset);
    }

    @Override // com.anythink.core.common.n.c.e
    public final String v() {
        long jA = a((byte) 10);
        if (jA != -1) {
            return this.a.g(jA);
        }
        if (this.a.c != 0) {
            return e(this.a.c);
        }
        return null;
    }

    @Override // com.anythink.core.common.n.c.e
    public final String w() {
        return f(Long.MAX_VALUE);
    }

    @Override // com.anythink.core.common.n.c.e
    public final String f(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jA = a((byte) 10, 0L, j2);
        if (jA != -1) {
            return this.a.g(jA);
        }
        if (j2 < Long.MAX_VALUE && b(j2) && this.a.c(j2 - 1) == 13 && b(1 + j2) && this.a.c(j2) == 10) {
            return this.a.g(j2);
        }
        c cVar = new c();
        c cVar2 = this.a;
        cVar2.a(cVar, 0L, Math.min(32L, cVar2.c));
        throw new EOFException("\\n not found: limit=" + Math.min(this.a.c, j) + " content=" + cVar.t().g() + Typography.ellipsis);
    }

    @Override // com.anythink.core.common.n.c.e
    public final int x() throws EOFException {
        int i;
        int i2;
        int i3;
        a(1L);
        byte bC = this.a.c(0L);
        if ((bC & 224) == 192) {
            a(2L);
        } else if ((bC & 240) == 224) {
            a(3L);
        } else if ((bC & 248) == 240) {
            a(4L);
        }
        c cVar = this.a;
        if (cVar.c == 0) {
            throw new EOFException();
        }
        byte bC2 = cVar.c(0L);
        if ((bC2 & 128) == 0) {
            i = bC2 & 127;
            i3 = 0;
            i2 = 1;
        } else if ((bC2 & 224) == 192) {
            i = bC2 & 31;
            i2 = 2;
            i3 = 128;
        } else if ((bC2 & 240) == 224) {
            i = bC2 & ek.m;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((bC2 & 248) != 240) {
                cVar.i(1L);
                return 65533;
            }
            i = bC2 & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (cVar.c < j) {
            throw new EOFException("size < " + i2 + ": " + cVar.c + " (to read code point prefixed 0x" + Integer.toHexString(bC2) + ")");
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte bC3 = cVar.c(j2);
            if ((bC3 & 192) != 128) {
                cVar.i(j2);
                return 65533;
            }
            i = (i << 6) | (bC3 & com.anythink.core.common.s.a.c.c);
        }
        cVar.i(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((i < 55296 || i > 57343) && i >= i3) {
            return i;
        }
        return 65533;
    }

    @Override // com.anythink.core.common.n.c.e
    public final short l() throws EOFException {
        a(2L);
        return this.a.l();
    }

    @Override // com.anythink.core.common.n.c.e
    public final short o() throws EOFException {
        a(2L);
        return y.a(this.a.l());
    }

    @Override // com.anythink.core.common.n.c.e
    public final int m() throws EOFException {
        a(4L);
        return this.a.m();
    }

    @Override // com.anythink.core.common.n.c.e
    public final int p() throws EOFException {
        a(4L);
        return y.a(this.a.m());
    }

    @Override // com.anythink.core.common.n.c.e
    public final long n() throws EOFException {
        a(8L);
        return this.a.n();
    }

    @Override // com.anythink.core.common.n.c.e
    public final long q() throws EOFException {
        a(8L);
        return y.a(this.a.n());
    }

    @Override // com.anythink.core.common.n.c.e
    public final long r() throws EOFException {
        a(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!b(i2)) {
                break;
            }
            byte bC = this.a.c(i);
            if ((bC < 48 || bC > 57) && !(i == 0 && bC == 45)) {
                if (i != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(bC)));
            }
            i = i2;
        }
        return this.a.r();
    }

    @Override // com.anythink.core.common.n.c.e
    public final long s() throws EOFException {
        a(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!b(i2)) {
                break;
            }
            byte bC = this.a.c(i);
            if ((bC < 48 || bC > 57) && ((bC < 97 || bC > 102) && (bC < 65 || bC > 70))) {
                if (i != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bC)));
            }
            i = i2;
        }
        return this.a.s();
    }

    @Override // com.anythink.core.common.n.c.e
    public final void i(long j) throws EOFException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.a.c == 0 && this.b.a_(this.a, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.a.c);
            this.a.i(jMin);
            j -= jMin;
        }
    }

    @Override // com.anythink.core.common.n.c.e
    public final long a(byte b) {
        return a(b, 0L, Long.MAX_VALUE);
    }

    @Override // com.anythink.core.common.n.c.e
    public final long a(byte b, long j) {
        return a(b, j, Long.MAX_VALUE);
    }

    @Override // com.anythink.core.common.n.c.e
    public final long a(byte b, long j, long j2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jA = this.a.a(b, j, j2);
            if (jA != -1) {
                return jA;
            }
            long j3 = this.a.c;
            if (j3 >= j2 || this.b.a_(this.a, 8192L) == -1) {
                break;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // com.anythink.core.common.n.c.e
    public final long b(f fVar) {
        return a(fVar, 0L);
    }

    @Override // com.anythink.core.common.n.c.e
    public final long a(f fVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jA = this.a.a(fVar, j);
            if (jA != -1) {
                return jA;
            }
            long j2 = this.a.c;
            if (this.b.a_(this.a, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, (j2 - ((long) fVar.j())) + 1);
        }
    }

    @Override // com.anythink.core.common.n.c.e
    public final long c(f fVar) {
        return b(fVar, 0L);
    }

    @Override // com.anythink.core.common.n.c.e
    public final long b(f fVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jB = this.a.b(fVar, j);
            if (jB != -1) {
                return jB;
            }
            long j2 = this.a.c;
            if (this.b.a_(this.a, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, j2);
        }
    }

    @Override // com.anythink.core.common.n.c.e
    public final boolean a(long j, f fVar) {
        return a(j, fVar, fVar.j());
    }

    @Override // com.anythink.core.common.n.c.e
    public final boolean a(long j, f fVar, int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || fVar.j() - 0 < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = ((long) i2) + j;
            if (!b(1 + j2) || this.a.c(j2) != fVar.b(i2 + 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.anythink.core.common.n.c.e
    public final e h() {
        return n.a(new p(this));
    }

    @Override // com.anythink.core.common.n.c.e
    public final InputStream i() {
        return new InputStream() { // from class: com.anythink.core.common.n.c.r.1
            @Override // java.io.InputStream
            public final int read() throws IOException {
                if (r.this.c) {
                    throw new IOException("closed");
                }
                if (r.this.a.c == 0 && r.this.b.a_(r.this.a, 8192L) == -1) {
                    return -1;
                }
                return r.this.a.k() & UByte.MAX_VALUE;
            }

            @Override // java.io.InputStream
            public final int read(byte[] bArr, int i, int i2) throws IOException {
                if (r.this.c) {
                    throw new IOException("closed");
                }
                y.a(bArr.length, i, i2);
                if (r.this.a.c == 0 && r.this.b.a_(r.this.a, 8192L) == -1) {
                    return -1;
                }
                return r.this.a.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public final int available() throws IOException {
                if (r.this.c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(r.this.a.c, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                r.this.close();
            }

            public final String toString() {
                return r.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.c;
    }

    @Override // com.anythink.core.common.n.c.w, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.z();
    }

    @Override // com.anythink.core.common.n.c.w
    public final x a() {
        return this.b.a();
    }

    public final String toString() {
        return "buffer(" + this.b + ")";
    }
}
