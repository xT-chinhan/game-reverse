package com.anythink.core.common.m.c;

import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.http.TapHttpUtil;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public final class c implements d, e, Cloneable, ByteChannel {
    static final int a = 65533;
    private static final byte[] d = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    s b;
    long c;

    private c B() {
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    public final /* bridge */ /* synthetic */ d A() {
        return this;
    }

    @Override // com.anythink.core.common.m.c.d, com.anythink.core.common.m.c.e
    public final c c() {
        return this;
    }

    @Override // com.anythink.core.common.m.c.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.anythink.core.common.m.c.e
    public final c d() {
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    public final d f() {
        return this;
    }

    @Override // com.anythink.core.common.m.c.d, com.anythink.core.common.m.c.v, java.io.Flushable
    public final void flush() {
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final long b() {
        return this.c;
    }

    @Override // com.anythink.core.common.m.c.d
    public final OutputStream e() {
        return new OutputStream() { // from class: com.anythink.core.common.m.c.c.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public final void flush() {
            }

            @Override // java.io.OutputStream
            public final void write(int i) {
                c.this.l((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                c.this.c(bArr, i, i2);
            }

            public final String toString() {
                return c.this + ".outputStream()";
            }
        };
    }

    @Override // com.anythink.core.common.m.c.e
    public final boolean g() {
        return this.c == 0;
    }

    @Override // com.anythink.core.common.m.c.e
    public final void a(long j) throws EOFException {
        if (this.c < j) {
            throw new EOFException();
        }
    }

    @Override // com.anythink.core.common.m.c.e
    public final boolean b(long j) {
        return this.c >= j;
    }

    @Override // com.anythink.core.common.m.c.e
    public final e h() {
        return n.a(new p(this));
    }

    @Override // com.anythink.core.common.m.c.e
    public final InputStream i() {
        return new InputStream() { // from class: com.anythink.core.common.m.c.c.2
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
            }

            @Override // java.io.InputStream
            public final int read() {
                if (c.this.c > 0) {
                    return c.this.k() & UByte.MAX_VALUE;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public final int read(byte[] bArr, int i, int i2) {
                return c.this.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public final int available() {
                return (int) Math.min(c.this.c, 2147483647L);
            }

            public final String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    private c a(OutputStream outputStream) throws IOException {
        long j = this.c;
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        y.a(j, 0L, j);
        if (j != 0) {
            s sVar = this.b;
            long j2 = 0;
            while (j2 >= sVar.e - sVar.d) {
                j2 -= (long) (sVar.e - sVar.d);
                sVar = sVar.h;
            }
            while (j > 0) {
                int i = (int) (((long) sVar.d) + j2);
                int iMin = (int) Math.min(sVar.e - i, j);
                outputStream.write(sVar.c, i, iMin);
                j -= (long) iMin;
                sVar = sVar.h;
                j2 = 0;
            }
        }
        return this;
    }

    private c a(OutputStream outputStream, long j, long j2) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        y.a(this.c, 0L, j2);
        if (j2 == 0) {
            return this;
        }
        s sVar = this.b;
        while (j >= sVar.e - sVar.d) {
            j -= (long) (sVar.e - sVar.d);
            sVar = sVar.h;
        }
        while (j2 > 0) {
            int i = (int) (((long) sVar.d) + j);
            int iMin = (int) Math.min(sVar.e - i, j2);
            outputStream.write(sVar.c, i, iMin);
            j2 -= (long) iMin;
            sVar = sVar.h;
            j = 0;
        }
        return this;
    }

    public final c a(c cVar, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        y.a(this.c, j, j2);
        if (j2 == 0) {
            return this;
        }
        cVar.c += j2;
        s sVar = this.b;
        while (j >= sVar.e - sVar.d) {
            j -= (long) (sVar.e - sVar.d);
            sVar = sVar.h;
        }
        while (j2 > 0) {
            s sVarA = sVar.a();
            sVarA.d = (int) (((long) sVarA.d) + j);
            sVarA.e = Math.min(sVarA.d + ((int) j2), sVarA.e);
            s sVar2 = cVar.b;
            if (sVar2 == null) {
                sVarA.i = sVarA;
                sVarA.h = sVarA;
                cVar.b = sVarA;
            } else {
                sVar2.i.a(sVarA);
            }
            j2 -= (long) (sVarA.e - sVarA.d);
            sVar = sVar.h;
            j = 0;
        }
        return this;
    }

    private c b(OutputStream outputStream) throws IOException {
        long j = this.c;
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        y.a(j, 0L, j);
        s sVar = this.b;
        while (j > 0) {
            int iMin = (int) Math.min(j, sVar.e - sVar.d);
            outputStream.write(sVar.c, sVar.d, iMin);
            sVar.d += iMin;
            long j2 = iMin;
            this.c -= j2;
            j -= j2;
            if (sVar.d == sVar.e) {
                s sVarC = sVar.c();
                this.b = sVarC;
                t.a(sVar);
                sVar = sVarC;
            }
        }
        return this;
    }

    private c a(OutputStream outputStream, long j) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        y.a(this.c, 0L, j);
        s sVar = this.b;
        while (j > 0) {
            int iMin = (int) Math.min(j, sVar.e - sVar.d);
            outputStream.write(sVar.c, sVar.d, iMin);
            sVar.d += iMin;
            long j2 = iMin;
            this.c -= j2;
            j -= j2;
            if (sVar.d == sVar.e) {
                s sVarC = sVar.c();
                this.b = sVarC;
                t.a(sVar);
                sVar = sVarC;
            }
        }
        return this;
    }

    private c a(InputStream inputStream) throws IOException {
        a(inputStream, LongCompanionObject.MAX_VALUE, true);
        return this;
    }

    private c a(InputStream inputStream, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        a(inputStream, j, false);
        return this;
    }

    private void a(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            s sVarG = g(1);
            int i = inputStream.read(sVarG.c, sVarG.e, (int) Math.min(j, 8192 - sVarG.e));
            if (i == -1) {
                if (!z) {
                    throw new EOFException();
                }
                return;
            } else {
                sVarG.e += i;
                long j2 = i;
                this.c += j2;
                j -= j2;
            }
        }
    }

    public final long j() {
        long j = this.c;
        if (j == 0) {
            return 0L;
        }
        s sVar = this.b.i;
        return (sVar.e >= 8192 || !sVar.g) ? j : j - ((long) (sVar.e - sVar.d));
    }

    @Override // com.anythink.core.common.m.c.e
    public final byte k() {
        if (this.c == 0) {
            throw new IllegalStateException("size == 0");
        }
        s sVar = this.b;
        int i = sVar.d;
        int i2 = sVar.e;
        int i3 = i + 1;
        byte b = sVar.c[i];
        this.c--;
        if (i3 == i2) {
            this.b = sVar.c();
            t.a(sVar);
        } else {
            sVar.d = i3;
        }
        return b;
    }

    public final byte c(long j) {
        y.a(this.c, j, 1L);
        long j2 = this.c;
        if (j2 - j > j) {
            s sVar = this.b;
            while (true) {
                long j3 = sVar.e - sVar.d;
                if (j >= j3) {
                    j -= j3;
                    sVar = sVar.h;
                } else {
                    return sVar.c[sVar.d + ((int) j)];
                }
            }
        } else {
            long j4 = j - j2;
            s sVar2 = this.b;
            do {
                sVar2 = sVar2.i;
                j4 += (long) (sVar2.e - sVar2.d);
            } while (j4 < 0);
            return sVar2.c[sVar2.d + ((int) j4)];
        }
    }

    @Override // com.anythink.core.common.m.c.e
    public final short l() {
        if (this.c < 2) {
            throw new IllegalStateException("size < 2: " + this.c);
        }
        s sVar = this.b;
        int i = sVar.d;
        int i2 = sVar.e;
        if (i2 - i < 2) {
            return (short) (((k() & UByte.MAX_VALUE) << 8) | (k() & UByte.MAX_VALUE));
        }
        byte[] bArr = sVar.c;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i3] & UByte.MAX_VALUE);
        this.c -= 2;
        if (i4 == i2) {
            this.b = sVar.c();
            t.a(sVar);
        } else {
            sVar.d = i4;
        }
        return (short) i5;
    }

    @Override // com.anythink.core.common.m.c.e
    public final int m() {
        if (this.c < 4) {
            throw new IllegalStateException("size < 4: " + this.c);
        }
        s sVar = this.b;
        int i = sVar.d;
        int i2 = sVar.e;
        if (i2 - i < 4) {
            return ((k() & UByte.MAX_VALUE) << 24) | ((k() & UByte.MAX_VALUE) << 16) | ((k() & UByte.MAX_VALUE) << 8) | (k() & UByte.MAX_VALUE);
        }
        byte[] bArr = sVar.c;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & UByte.MAX_VALUE) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & UByte.MAX_VALUE);
        this.c -= 4;
        if (i8 == i2) {
            this.b = sVar.c();
            t.a(sVar);
        } else {
            sVar.d = i8;
        }
        return i9;
    }

    @Override // com.anythink.core.common.m.c.e
    public final long n() {
        if (this.c < 8) {
            throw new IllegalStateException("size < 8: " + this.c);
        }
        s sVar = this.b;
        int i = sVar.d;
        int i2 = sVar.e;
        if (i2 - i < 8) {
            return ((((long) m()) & 4294967295L) << 32) | (4294967295L & ((long) m()));
        }
        byte[] bArr = sVar.c;
        int i3 = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        long j2 = j | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40);
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        long j3 = j2 | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24);
        int i8 = i7 + 1;
        long j4 = j3 | ((((long) bArr[i7]) & 255) << 16);
        int i9 = i8 + 1;
        long j5 = j4 | ((((long) bArr[i8]) & 255) << 8);
        int i10 = i9 + 1;
        long j6 = (((long) bArr[i9]) & 255) | j5;
        this.c -= 8;
        if (i10 == i2) {
            this.b = sVar.c();
            t.a(sVar);
        } else {
            sVar.d = i10;
        }
        return j6;
    }

    @Override // com.anythink.core.common.m.c.e
    public final short o() {
        return y.a(l());
    }

    @Override // com.anythink.core.common.m.c.e
    public final int p() {
        return y.a(m());
    }

    @Override // com.anythink.core.common.m.c.e
    public final long q() {
        return y.a(n());
    }

    @Override // com.anythink.core.common.m.c.e
    public final long r() {
        if (this.c == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i = 0;
        boolean z = false;
        long j = -7;
        long j2 = 0;
        boolean z2 = false;
        do {
            s sVar = this.b;
            byte[] bArr = sVar.c;
            int i2 = sVar.d;
            int i3 = sVar.e;
            while (i2 < i3) {
                byte b = bArr[i2];
                if (b >= 48 && b <= 57) {
                    int i4 = 48 - b;
                    if (j2 < -922337203685477580L || (j2 == -922337203685477580L && i4 < j)) {
                        c cVarL = new c().o(j2).l((int) b);
                        if (!z) {
                            cVarL.k();
                        }
                        throw new NumberFormatException("Number too large: " + cVarL.u());
                    }
                    j2 = (j2 * 10) + ((long) i4);
                } else {
                    if (b != 45 || i != 0) {
                        if (i == 0) {
                            throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(b));
                        }
                        z2 = true;
                        break;
                    }
                    j--;
                    z = true;
                }
                i2++;
                i++;
            }
            if (i2 == i3) {
                this.b = sVar.c();
                t.a(sVar);
            } else {
                sVar.d = i2;
            }
            if (z2) {
                break;
            }
        } while (this.b != null);
        this.c -= (long) i;
        return z ? j2 : -j2;
    }

    @Override // com.anythink.core.common.m.c.e
    public final long s() {
        int i;
        int i2;
        if (this.c == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i3 = 0;
        boolean z = false;
        long j = 0;
        do {
            s sVar = this.b;
            byte[] bArr = sVar.c;
            int i4 = sVar.d;
            int i5 = sVar.e;
            while (i4 < i5) {
                byte b = bArr[i4];
                if (b < 48 || b > 57) {
                    if (b >= 97 && b <= 102) {
                        i = b - 97;
                    } else {
                        if (b < 65 || b > 70) {
                            if (i3 == 0) {
                                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                            }
                            z = true;
                            break;
                        }
                        i = b - 65;
                    }
                    i2 = i + 10;
                } else {
                    i2 = b - 48;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new c().n(j).l((int) b).u());
                }
                j = (j << 4) | ((long) i2);
                i4++;
                i3++;
            }
            if (i4 == i5) {
                this.b = sVar.c();
                t.a(sVar);
            } else {
                sVar.d = i4;
            }
            if (z) {
                break;
            }
        } while (this.b != null);
        this.c -= (long) i3;
        return j;
    }

    @Override // com.anythink.core.common.m.c.e
    public final f t() {
        return new f(y());
    }

    @Override // com.anythink.core.common.m.c.e
    public final f d(long j) {
        return new f(h(j));
    }

    @Override // com.anythink.core.common.m.c.e
    public final int a(o oVar) {
        int iA = a(oVar, false);
        if (iA == -1) {
            return -1;
        }
        try {
            i(oVar.a[iA].j());
            return iA;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    final int a(o oVar, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        s sVar;
        s sVar2 = this.b;
        if (sVar2 == null) {
            if (z) {
                return -2;
            }
            return oVar.indexOf(f.b);
        }
        byte[] bArr = sVar2.c;
        int i5 = sVar2.d;
        int i6 = sVar2.e;
        int[] iArr = oVar.b;
        s sVar3 = sVar2;
        int i7 = -1;
        int i8 = 0;
        loop0: while (true) {
            int i9 = i8 + 1;
            int i10 = iArr[i8];
            int i11 = i9 + 1;
            int i12 = iArr[i9];
            if (i12 != -1) {
                i7 = i12;
            }
            if (sVar3 == null) {
                break;
            }
            if (i10 >= 0) {
                i = i5 + 1;
                int i13 = bArr[i5] & UByte.MAX_VALUE;
                int i14 = i11 + i10;
                while (i11 != i14) {
                    if (i13 == iArr[i11]) {
                        i2 = iArr[i11 + i10];
                        if (i == i6) {
                            sVar3 = sVar3.h;
                            i = sVar3.d;
                            bArr = sVar3.c;
                            i6 = sVar3.e;
                            if (sVar3 == sVar2) {
                                sVar3 = null;
                            }
                        }
                    } else {
                        i11++;
                    }
                }
                return i7;
            }
            int i15 = i11 + (i10 * (-1));
            while (true) {
                int i16 = i5 + 1;
                int i17 = i11 + 1;
                if ((bArr[i5] & UByte.MAX_VALUE) != iArr[i11]) {
                    return i7;
                }
                boolean z2 = i17 == i15;
                if (i16 == i6) {
                    s sVar4 = sVar3.h;
                    i4 = sVar4.d;
                    byte[] bArr2 = sVar4.c;
                    i3 = sVar4.e;
                    if (sVar4 != sVar2) {
                        sVar = sVar4;
                        bArr = bArr2;
                    } else {
                        if (!z2) {
                            break loop0;
                        }
                        bArr = bArr2;
                        sVar = null;
                    }
                } else {
                    s sVar5 = sVar3;
                    i3 = i6;
                    i4 = i16;
                    sVar = sVar5;
                }
                if (z2) {
                    i2 = iArr[i17];
                    i = i4;
                    i6 = i3;
                    sVar3 = sVar;
                    break;
                }
                i5 = i4;
                i6 = i3;
                i11 = i17;
                sVar3 = sVar;
            }
            if (i2 >= 0) {
                return i2;
            }
            i8 = -i2;
            i5 = i;
        }
        if (z) {
            return -2;
        }
        return i7;
    }

    @Override // com.anythink.core.common.m.c.e
    public final void b(c cVar, long j) throws EOFException {
        long j2 = this.c;
        if (j2 < j) {
            cVar.a(this, j2);
            throw new EOFException();
        }
        cVar.a(this, j);
    }

    @Override // com.anythink.core.common.m.c.e
    public final long a(v vVar) {
        long j = this.c;
        if (j > 0) {
            vVar.a(this, j);
        }
        return j;
    }

    @Override // com.anythink.core.common.m.c.e
    public final String u() {
        try {
            return a(this.c, y.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.anythink.core.common.m.c.e
    public final String e(long j) {
        return a(j, y.a);
    }

    @Override // com.anythink.core.common.m.c.e
    public final String a(Charset charset) {
        try {
            return a(this.c, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.anythink.core.common.m.c.e
    public final String a(long j, Charset charset) {
        y.a(this.c, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        s sVar = this.b;
        if (((long) sVar.d) + j > sVar.e) {
            return new String(h(j), charset);
        }
        String str = new String(sVar.c, sVar.d, (int) j, charset);
        sVar.d = (int) (((long) sVar.d) + j);
        this.c -= j;
        if (sVar.d == sVar.e) {
            this.b = sVar.c();
            t.a(sVar);
        }
        return str;
    }

    @Override // com.anythink.core.common.m.c.e
    public final String v() {
        long jA = a((byte) 10);
        if (jA == -1) {
            long j = this.c;
            if (j != 0) {
                return e(j);
            }
            return null;
        }
        return g(jA);
    }

    @Override // com.anythink.core.common.m.c.e
    public final String w() {
        return f(LongCompanionObject.MAX_VALUE);
    }

    @Override // com.anythink.core.common.m.c.e
    public final String f(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = LongCompanionObject.MAX_VALUE;
        if (j != LongCompanionObject.MAX_VALUE) {
            j2 = j + 1;
        }
        long jA = a((byte) 10, 0L, j2);
        if (jA != -1) {
            return g(jA);
        }
        if (j2 < this.c && c(j2 - 1) == 13 && c(j2) == 10) {
            return g(j2);
        }
        c cVar = new c();
        a(cVar, 0L, Math.min(32L, this.c));
        throw new EOFException("\\n not found: limit=" + Math.min(this.c, j) + " content=" + cVar.t().g() + Typography.ellipsis);
    }

    final String g(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (c(j2) == 13) {
                String strE = e(j2);
                i(2L);
                return strE;
            }
        }
        String strE2 = e(j);
        i(1L);
        return strE2;
    }

    @Override // com.anythink.core.common.m.c.e
    public final int x() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.c == 0) {
            throw new EOFException();
        }
        byte bC = c(0L);
        if ((bC & 128) == 0) {
            i = bC & 127;
            i3 = 0;
            i2 = 1;
        } else if ((bC & 224) == 192) {
            i = bC & 31;
            i2 = 2;
            i3 = 128;
        } else if ((bC & 240) == 224) {
            i = bC & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((bC & 248) != 240) {
                i(1L);
                return a;
            }
            i = bC & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.c < j) {
            throw new EOFException("size < " + i2 + ": " + this.c + " (to read code point prefixed 0x" + Integer.toHexString(bC) + ")");
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte bC2 = c(j2);
            if ((bC2 & 192) != 128) {
                i(j2);
                return a;
            }
            i = (i << 6) | (bC2 & com.anythink.core.common.r.a.c.c);
        }
        i(j);
        if (i > 1114111) {
            return a;
        }
        return ((i < 55296 || i > 57343) && i >= i3) ? i : a;
    }

    @Override // com.anythink.core.common.m.c.e
    public final byte[] y() {
        try {
            return h(this.c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.anythink.core.common.m.c.e
    public final byte[] h(long j) throws EOFException {
        y.a(this.c, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        b(bArr);
        return bArr;
    }

    @Override // com.anythink.core.common.m.c.e
    public final int a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    @Override // com.anythink.core.common.m.c.e
    public final void b(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iA = a(bArr, i, bArr.length - i);
            if (iA == -1) {
                throw new EOFException();
            }
            i += iA;
        }
    }

    @Override // com.anythink.core.common.m.c.e
    public final int a(byte[] bArr, int i, int i2) {
        y.a(bArr.length, i, i2);
        s sVar = this.b;
        if (sVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, sVar.e - sVar.d);
        System.arraycopy(sVar.c, sVar.d, bArr, i, iMin);
        sVar.d += iMin;
        this.c -= (long) iMin;
        if (sVar.d == sVar.e) {
            this.b = sVar.c();
            t.a(sVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        s sVar = this.b;
        if (sVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), sVar.e - sVar.d);
        byteBuffer.put(sVar.c, sVar.d, iMin);
        sVar.d += iMin;
        this.c -= (long) iMin;
        if (sVar.d == sVar.e) {
            this.b = sVar.c();
            t.a(sVar);
        }
        return iMin;
    }

    public final void z() {
        try {
            i(this.c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.anythink.core.common.m.c.e
    public final void i(long j) throws EOFException {
        while (j > 0) {
            s sVar = this.b;
            if (sVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, sVar.e - this.b.d);
            long j2 = iMin;
            this.c -= j2;
            j -= j2;
            this.b.d += iMin;
            if (this.b.d == this.b.e) {
                s sVar2 = this.b;
                this.b = sVar2.c();
                t.a(sVar2);
            }
        }
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final c d(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        fVar.a(this);
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final c b(String str) {
        return b(str, 0, str.length());
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final c b(String str, int i, int i2) {
        char cCharAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                s sVarG = g(1);
                byte[] bArr = sVarG.c;
                int i3 = sVarG.e - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = (i3 + i) - sVarG.e;
                sVarG.e += i5;
                this.c += (long) i5;
            } else {
                if (cCharAt2 < 2048) {
                    l((cCharAt2 >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                    l((cCharAt2 & '?') | 128);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    l((cCharAt2 >> '\f') | 224);
                    l(((cCharAt2 >> 6) & 63) | 128);
                    l((cCharAt2 & '?') | 128);
                } else {
                    int i6 = i + 1;
                    char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        l(63);
                        i = i6;
                    } else {
                        int i7 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        l((i7 >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                        l(((i7 >> 12) & 63) | 128);
                        l(((i7 >> 6) & 63) | 128);
                        l((i7 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final c m(int i) {
        if (i < 128) {
            l(i);
        } else if (i < 2048) {
            l((i >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            l((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                l(63);
            } else {
                l((i >> 12) | 224);
                l(((i >> 6) & 63) | 128);
                l((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            l((i >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
            l(((i >> 12) & 63) | 128);
            l(((i >> 6) & 63) | 128);
            l((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final c b(String str, Charset charset) {
        return b(str, 0, str.length(), charset);
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final c b(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(y.a)) {
            return b(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return c(bytes, 0, bytes.length);
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final c d(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return c(bArr, 0, bArr.length);
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final c c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        y.a(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            s sVarG = g(1);
            int iMin = Math.min(i3 - i, 8192 - sVarG.e);
            System.arraycopy(bArr, i, sVarG.c, sVarG.e, iMin);
            i += iMin;
            sVarG.e += iMin;
        }
        this.c += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            s sVarG = g(1);
            int iMin = Math.min(i, 8192 - sVarG.e);
            byteBuffer.get(sVarG.c, sVarG.e, iMin);
            i -= iMin;
            sVarG.e += iMin;
        }
        this.c += (long) iRemaining;
        return iRemaining;
    }

    @Override // com.anythink.core.common.m.c.d
    public final long a(w wVar) {
        if (wVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jA_ = wVar.a_(this, com.anythink.china.a.c.n);
            if (jA_ == -1) {
                return j;
            }
            j += jA_;
        }
    }

    @Override // com.anythink.core.common.m.c.d
    public final d a(w wVar, long j) throws EOFException {
        while (j > 0) {
            long jA_ = wVar.a_(this, j);
            if (jA_ == -1) {
                throw new EOFException();
            }
            j -= jA_;
        }
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final c l(int i) {
        s sVarG = g(1);
        byte[] bArr = sVarG.c;
        int i2 = sVarG.e;
        sVarG.e = i2 + 1;
        bArr[i2] = (byte) i;
        this.c++;
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final c k(int i) {
        s sVarG = g(2);
        byte[] bArr = sVarG.c;
        int i2 = sVarG.e;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        sVarG.e = i3 + 1;
        this.c += 2;
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final c j(int i) {
        return k((int) y.a((short) i));
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final c i(int i) {
        s sVarG = g(4);
        byte[] bArr = sVarG.c;
        int i2 = sVarG.e;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        sVarG.e = i5 + 1;
        this.c += 4;
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final c h(int i) {
        return i(y.a(i));
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final c q(long j) {
        s sVarG = g(8);
        byte[] bArr = sVarG.c;
        int i = sVarG.e;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        sVarG.e = i8 + 1;
        this.c += 8;
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final c p(long j) {
        return q(y.a(j));
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final c o(long j) {
        boolean z;
        if (j == 0) {
            return l(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j < 100000000) {
            if (j < 10000) {
                if (j >= 100) {
                    i = j < 1000 ? 3 : 4;
                } else if (j >= 10) {
                    i = 2;
                }
            } else if (j < C.MICROS_PER_SECOND) {
                i = j < 100000 ? 5 : 6;
            } else {
                i = j < 10000000 ? 7 : 8;
            }
        } else if (j < 1000000000000L) {
            if (j < 10000000000L) {
                i = j < C.NANOS_PER_SECOND ? 9 : 10;
            } else {
                i = j < 100000000000L ? 11 : 12;
            }
        } else if (j < 1000000000000000L) {
            if (j < 10000000000000L) {
                i = 13;
            } else {
                i = j < 100000000000000L ? 14 : 15;
            }
        } else if (j < 100000000000000000L) {
            i = j < 10000000000000000L ? 16 : 17;
        } else {
            i = j < 1000000000000000000L ? 18 : 19;
        }
        if (z) {
            i++;
        }
        s sVarG = g(i);
        byte[] bArr = sVarG.c;
        int i2 = sVarG.e + i;
        while (j != 0) {
            i2--;
            bArr[i2] = d[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        sVarG.e += i;
        this.c += (long) i;
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public final c n(long j) {
        if (j == 0) {
            return l(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        s sVarG = g(iNumberOfTrailingZeros);
        byte[] bArr = sVarG.c;
        int i = sVarG.e;
        for (int i2 = (sVarG.e + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = d[(int) (15 & j)];
            j >>>= 4;
        }
        sVarG.e += iNumberOfTrailingZeros;
        this.c += (long) iNumberOfTrailingZeros;
        return this;
    }

    final s g(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        s sVar = this.b;
        if (sVar == null) {
            s sVarA = t.a();
            this.b = sVarA;
            sVarA.i = sVarA;
            sVarA.h = sVarA;
            return sVarA;
        }
        s sVar2 = sVar.i;
        return (sVar2.e + i > 8192 || !sVar2.g) ? sVar2.a(t.a()) : sVar2;
    }

    @Override // com.anythink.core.common.m.c.v
    public final void a(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        y.a(cVar.c, 0L, j);
        while (j > 0) {
            if (j < cVar.b.e - cVar.b.d) {
                s sVar = this.b;
                s sVar2 = sVar != null ? sVar.i : null;
                if (sVar2 != null && sVar2.g) {
                    if ((((long) sVar2.e) + j) - ((long) (sVar2.f ? 0 : sVar2.d)) <= com.anythink.china.a.c.n) {
                        cVar.b.a(sVar2, (int) j);
                        cVar.c -= j;
                        this.c += j;
                        return;
                    }
                }
                cVar.b = cVar.b.a((int) j);
            }
            s sVar3 = cVar.b;
            long j2 = sVar3.e - sVar3.d;
            cVar.b = sVar3.c();
            s sVar4 = this.b;
            if (sVar4 == null) {
                this.b = sVar3;
                sVar3.i = sVar3;
                sVar3.h = sVar3;
            } else {
                sVar4.i.a(sVar3).d();
            }
            cVar.c -= j2;
            this.c += j2;
            j -= j2;
        }
    }

    @Override // com.anythink.core.common.m.c.w
    public final long a_(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        long j2 = this.c;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        cVar.a(this, j);
        return j;
    }

    @Override // com.anythink.core.common.m.c.e
    public final long a(byte b) {
        return a(b, 0L, LongCompanionObject.MAX_VALUE);
    }

    @Override // com.anythink.core.common.m.c.e
    public final long a(byte b, long j) {
        return a(b, j, LongCompanionObject.MAX_VALUE);
    }

    @Override // com.anythink.core.common.m.c.e
    public final long a(byte b, long j, long j2) {
        s sVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.c), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.c;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (sVar = this.b) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                sVar = sVar.i;
                j4 -= (long) (sVar.e - sVar.d);
            }
        } else {
            while (true) {
                long j6 = ((long) (sVar.e - sVar.d)) + j3;
                if (j6 >= j) {
                    break;
                }
                sVar = sVar.h;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = sVar.c;
            int iMin = (int) Math.min(sVar.e, (((long) sVar.d) + j5) - j4);
            for (int i = (int) ((((long) sVar.d) + j7) - j4); i < iMin; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - sVar.d)) + j4;
                }
            }
            j4 += (long) (sVar.e - sVar.d);
            sVar = sVar.h;
            j7 = j4;
        }
        return -1L;
    }

    @Override // com.anythink.core.common.m.c.e
    public final long b(f fVar) {
        return a(fVar, 0L);
    }

    @Override // com.anythink.core.common.m.c.e
    public final long a(f fVar, long j) {
        if (fVar.j() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        s sVar = this.b;
        long j3 = -1;
        if (sVar == null) {
            return -1L;
        }
        long j4 = this.c;
        if (j4 - j < j) {
            while (j4 > j) {
                sVar = sVar.i;
                j4 -= (long) (sVar.e - sVar.d);
            }
        } else {
            while (true) {
                long j5 = ((long) (sVar.e - sVar.d)) + j2;
                if (j5 >= j) {
                    break;
                }
                sVar = sVar.h;
                j2 = j5;
            }
            j4 = j2;
        }
        byte b = fVar.b(0);
        int iJ = fVar.j();
        long j6 = (this.c - ((long) iJ)) + 1;
        long j7 = j4;
        long j8 = j;
        while (j7 < j6) {
            byte[] bArr = sVar.c;
            int iMin = (int) Math.min(sVar.e, (((long) sVar.d) + j6) - j7);
            for (int i = (int) ((((long) sVar.d) + j8) - j7); i < iMin; i++) {
                if (bArr[i] == b && a(sVar, i + 1, fVar, iJ)) {
                    return ((long) (i - sVar.d)) + j7;
                }
            }
            j7 += (long) (sVar.e - sVar.d);
            sVar = sVar.h;
            j8 = j7;
            j3 = -1;
        }
        return j3;
    }

    @Override // com.anythink.core.common.m.c.e
    public final long c(f fVar) {
        return b(fVar, 0L);
    }

    @Override // com.anythink.core.common.m.c.e
    public final long b(f fVar, long j) {
        int i;
        int i2;
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        s sVar = this.b;
        if (sVar == null) {
            return -1L;
        }
        long j3 = this.c;
        if (j3 - j < j) {
            while (j3 > j) {
                sVar = sVar.i;
                j3 -= (long) (sVar.e - sVar.d);
            }
        } else {
            while (true) {
                long j4 = ((long) (sVar.e - sVar.d)) + j2;
                if (j4 >= j) {
                    break;
                }
                sVar = sVar.h;
                j2 = j4;
            }
            j3 = j2;
        }
        if (fVar.j() == 2) {
            byte b = fVar.b(0);
            byte b2 = fVar.b(1);
            while (j3 < this.c) {
                byte[] bArr = sVar.c;
                i = (int) ((((long) sVar.d) + j) - j3);
                int i3 = sVar.e;
                while (i < i3) {
                    byte b3 = bArr[i];
                    if (b3 == b || b3 == b2) {
                        i2 = sVar.d;
                        return ((long) (i - i2)) + j3;
                    }
                    i++;
                }
                j3 += (long) (sVar.e - sVar.d);
                sVar = sVar.h;
                j = j3;
            }
            return -1L;
        }
        byte[] bArrL = fVar.l();
        while (j3 < this.c) {
            byte[] bArr2 = sVar.c;
            i = (int) ((((long) sVar.d) + j) - j3);
            int i4 = sVar.e;
            while (i < i4) {
                byte b4 = bArr2[i];
                for (byte b5 : bArrL) {
                    if (b4 == b5) {
                        i2 = sVar.d;
                        return ((long) (i - i2)) + j3;
                    }
                }
                i++;
            }
            j3 += (long) (sVar.e - sVar.d);
            sVar = sVar.h;
            j = j3;
        }
        return -1L;
    }

    @Override // com.anythink.core.common.m.c.e
    public final boolean a(long j, f fVar) {
        return a(j, fVar, fVar.j());
    }

    @Override // com.anythink.core.common.m.c.e
    public final boolean a(long j, f fVar, int i) {
        if (j < 0 || i < 0 || this.c - j < i || fVar.j() - 0 < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (c(((long) i2) + j) != fVar.b(i2 + 0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(s sVar, int i, f fVar, int i2) {
        int i3 = sVar.e;
        byte[] bArr = sVar.c;
        for (int i4 = 1; i4 < i2; i4++) {
            if (i == i3) {
                sVar = sVar.h;
                bArr = sVar.c;
                i = sVar.d;
                i3 = sVar.e;
            }
            if (bArr[i] != fVar.b(i4)) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Override // com.anythink.core.common.m.c.v
    public final x a() {
        return x.c;
    }

    private List<Integer> C() {
        if (this.b == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.b.e - this.b.d));
        s sVar = this.b;
        while (true) {
            sVar = sVar.h;
            if (sVar == this.b) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(sVar.e - sVar.d));
        }
    }

    private f D() {
        return c(com.anythink.core.common.u.n.a);
    }

    private f E() {
        return c("SHA-1");
    }

    private f F() {
        return c("SHA-256");
    }

    private f G() {
        return c("SHA-512");
    }

    private f c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            s sVar = this.b;
            if (sVar != null) {
                messageDigest.update(sVar.c, this.b.d, this.b.e - this.b.d);
                s sVar2 = this.b;
                while (true) {
                    sVar2 = sVar2.h;
                    if (sVar2 == this.b) {
                        break;
                    }
                    messageDigest.update(sVar2.c, sVar2.d, sVar2.e - sVar2.d);
                }
            }
            return f.a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private f e(f fVar) {
        return a(TapHttpUtil.HMAC_SHA1, fVar);
    }

    private f f(f fVar) {
        return a(TapHttpUtil.HMAC_SHA256, fVar);
    }

    private f g(f fVar) {
        return a("HmacSHA512", fVar);
    }

    private f a(String str, f fVar) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(fVar.k(), str));
            s sVar = this.b;
            if (sVar != null) {
                mac.update(sVar.c, this.b.d, this.b.e - this.b.d);
                s sVar2 = this.b;
                while (true) {
                    sVar2 = sVar2.h;
                    if (sVar2 == this.b) {
                        break;
                    }
                    mac.update(sVar2.c, sVar2.d, sVar2.e - sVar2.d);
                }
            }
            return f.a(mac.doFinal());
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j = this.c;
        if (j != cVar.c) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        s sVar = this.b;
        s sVar2 = cVar.b;
        int i = sVar.d;
        int i2 = sVar2.d;
        while (j2 < this.c) {
            long jMin = Math.min(sVar.e - i, sVar2.e - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (sVar.c[i] != sVar2.c[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == sVar.e) {
                sVar = sVar.h;
                i = sVar.d;
            }
            if (i2 == sVar2.e) {
                sVar2 = sVar2.h;
                i2 = sVar2.d;
            }
            j2 += jMin;
        }
        return true;
    }

    public final int hashCode() {
        s sVar = this.b;
        if (sVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = sVar.e;
            for (int i3 = sVar.d; i3 < i2; i3++) {
                i = (i * 31) + sVar.c[i3];
            }
            sVar = sVar.h;
        } while (sVar != this.b);
        return i;
    }

    private c H() {
        c cVar = new c();
        if (this.c == 0) {
            return cVar;
        }
        s sVarA = this.b.a();
        cVar.b = sVarA;
        sVarA.i = sVarA;
        sVarA.h = sVarA;
        s sVar = this.b;
        while (true) {
            sVar = sVar.h;
            if (sVar != this.b) {
                cVar.b.i.a(sVar.a());
            } else {
                cVar.c = this.c;
                return cVar;
            }
        }
    }

    private f I() {
        long j = this.c;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.c);
        }
        int i = (int) j;
        if (i == 0) {
            return f.b;
        }
        return new u(this, i);
    }

    private f n(int i) {
        if (i == 0) {
            return f.b;
        }
        return new u(this, i);
    }

    private a J() {
        a aVar = new a();
        if (aVar.a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        aVar.a = this;
        aVar.b = false;
        return aVar;
    }

    private a b(a aVar) {
        if (aVar.a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        aVar.a = this;
        aVar.b = false;
        return aVar;
    }

    private a K() {
        return a(new a());
    }

    public final a a(a aVar) {
        if (aVar.a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        aVar.a = this;
        aVar.b = true;
        return aVar;
    }

    public static final class a implements Closeable {
        public c a;
        public boolean b;
        public byte[] d;
        private s g;
        public long c = -1;
        public int e = -1;
        public int f = -1;

        public final int a() {
            if (this.c == this.a.c) {
                throw new IllegalStateException();
            }
            long j = this.c;
            return j == -1 ? a(0L) : a(j + ((long) (this.f - this.e)));
        }

        public final int a(long j) {
            if (j < -1 || j > this.a.c) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.a.c)));
            }
            if (j == -1 || j == this.a.c) {
                this.g = null;
                this.c = j;
                this.d = null;
                this.e = -1;
                this.f = -1;
                return -1;
            }
            long j2 = this.a.c;
            s sVarA = this.a.b;
            s sVar = this.a.b;
            s sVar2 = this.g;
            long j3 = 0;
            if (sVar2 != null) {
                long j4 = this.c - ((long) (this.e - sVar2.d));
                if (j4 > j) {
                    sVar = this.g;
                    j2 = j4;
                } else {
                    sVarA = this.g;
                    j3 = j4;
                }
            }
            if (j2 - j > j - j3) {
                while (j >= ((long) (sVarA.e - sVarA.d)) + j3) {
                    j3 += (long) (sVarA.e - sVarA.d);
                    sVarA = sVarA.h;
                }
            } else {
                while (j2 > j) {
                    sVar = sVar.i;
                    j2 -= (long) (sVar.e - sVar.d);
                }
                j3 = j2;
                sVarA = sVar;
            }
            if (this.b && sVarA.f) {
                s sVarB = sVarA.b();
                if (this.a.b == sVarA) {
                    this.a.b = sVarB;
                }
                sVarA = sVarA.a(sVarB);
                sVarA.i.c();
            }
            this.g = sVarA;
            this.c = j;
            this.d = sVarA.c;
            this.e = sVarA.d + ((int) (j - j3));
            int i = sVarA.e;
            this.f = i;
            return i - this.e;
        }

        private long b(long j) {
            c cVar = this.a;
            if (cVar == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.b) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j2 = cVar.c;
            if (j <= j2) {
                if (j < 0) {
                    throw new IllegalArgumentException("newSize < 0: ".concat(String.valueOf(j)));
                }
                long j3 = j2 - j;
                while (j3 > 0) {
                    s sVar = this.a.b.i;
                    long j4 = sVar.e - sVar.d;
                    if (j4 <= j3) {
                        this.a.b = sVar.c();
                        t.a(sVar);
                        j3 -= j4;
                    } else {
                        sVar.e = (int) (((long) sVar.e) - j3);
                        break;
                    }
                }
                this.g = null;
                this.c = j;
                this.d = null;
                this.e = -1;
                this.f = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                boolean z = true;
                while (j5 > 0) {
                    s sVarG = this.a.g(1);
                    int iMin = (int) Math.min(j5, 8192 - sVarG.e);
                    sVarG.e += iMin;
                    j5 -= (long) iMin;
                    if (z) {
                        this.g = sVarG;
                        this.c = j2;
                        this.d = sVarG.c;
                        this.e = sVarG.e - iMin;
                        this.f = sVarG.e;
                        z = false;
                    }
                }
            }
            this.a.c = j;
            return j2;
        }

        private long a(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: ".concat(String.valueOf(i)));
            }
            if (i > 8192) {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: ".concat(String.valueOf(i)));
            }
            c cVar = this.a;
            if (cVar == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.b) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j = cVar.c;
            s sVarG = this.a.g(i);
            int i2 = 8192 - sVarG.e;
            sVarG.e = 8192;
            long j2 = i2;
            this.a.c = j + j2;
            this.g = sVarG;
            this.c = j;
            this.d = sVarG.c;
            this.e = 8192 - i2;
            this.f = 8192;
            return j2;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.a = null;
            this.g = null;
            this.c = -1L;
            this.d = null;
            this.e = -1;
            this.f = -1;
        }
    }

    public final String toString() {
        f uVar;
        long j = this.c;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (i == 0) {
                uVar = f.b;
            } else {
                uVar = new u(this, i);
            }
            return uVar.toString();
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.c);
    }

    public final /* synthetic */ Object clone() {
        c cVar = new c();
        if (this.c == 0) {
            return cVar;
        }
        s sVarA = this.b.a();
        cVar.b = sVarA;
        sVarA.i = sVarA;
        sVarA.h = sVarA;
        s sVar = this.b;
        while (true) {
            sVar = sVar.h;
            if (sVar != this.b) {
                cVar.b.i.a(sVar.a());
            } else {
                cVar.c = this.c;
                return cVar;
            }
        }
    }
}
