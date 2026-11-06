package com.efs.sdk.memleaksdk.monitor.shark;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements m, n, Cloneable, ByteChannel {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    r a;
    long b;

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.efs.sdk.memleaksdk.monitor.shark.v
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public long a() {
        return this.b;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public boolean b() {
        return this.b == 0;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public byte c() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        r rVar = this.a;
        int i = rVar.b;
        int i2 = rVar.c;
        int i3 = i + 1;
        byte b = rVar.a[i];
        this.b--;
        if (i3 == i2) {
            this.a = rVar.b();
            s.a(rVar);
        } else {
            rVar.b = i3;
        }
        return b;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public short d() {
        if (this.b < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        r rVar = this.a;
        int i = rVar.b;
        int i2 = rVar.c;
        if (i2 - i < 2) {
            return (short) (((c() & UByte.MAX_VALUE) << 8) | (c() & UByte.MAX_VALUE));
        }
        byte[] bArr = rVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i3] & UByte.MAX_VALUE);
        this.b -= 2;
        if (i4 == i2) {
            this.a = rVar.b();
            s.a(rVar);
        } else {
            rVar.b = i4;
        }
        return (short) i5;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public int e() {
        if (this.b < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        r rVar = this.a;
        int i = rVar.b;
        int i2 = rVar.c;
        if (i2 - i < 4) {
            return ((c() & UByte.MAX_VALUE) << 24) | ((c() & UByte.MAX_VALUE) << 16) | ((c() & UByte.MAX_VALUE) << 8) | (c() & UByte.MAX_VALUE);
        }
        byte[] bArr = rVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & UByte.MAX_VALUE) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & UByte.MAX_VALUE);
        this.b -= 4;
        if (i8 == i2) {
            this.a = rVar.b();
            s.a(rVar);
        } else {
            rVar.b = i8;
        }
        return i9;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public long f() {
        if (this.b < 8) {
            throw new IllegalStateException("size < 8: " + this.b);
        }
        r rVar = this.a;
        int i = rVar.b;
        int i2 = rVar.c;
        if (i2 - i < 8) {
            return ((((long) e()) & 4294967295L) << 32) | (4294967295L & ((long) e()));
        }
        byte[] bArr = rVar.a;
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
        this.b -= 8;
        if (i10 == i2) {
            this.a = rVar.b();
            s.a(rVar);
        } else {
            rVar.b = i10;
        }
        return j6;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public String a(long j) throws EOFException {
        return a(j, x.a);
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public String a(long j, Charset charset) throws EOFException {
        x.a(this.b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        r rVar = this.a;
        if (((long) rVar.b) + j > rVar.c) {
            return new String(b(j), charset);
        }
        String str = new String(rVar.a, rVar.b, (int) j, charset);
        rVar.b = (int) (((long) rVar.b) + j);
        this.b -= j;
        if (rVar.b == rVar.c) {
            this.a = rVar.b();
            s.a(rVar);
        }
        return str;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public byte[] b(long j) throws EOFException {
        x.a(this.b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        a(bArr);
        return bArr;
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iA = a(bArr, i, bArr.length - i);
            if (iA == -1) {
                throw new EOFException();
            }
            i += iA;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        x.a(bArr.length, i, i2);
        r rVar = this.a;
        if (rVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, rVar.c - rVar.b);
        System.arraycopy(rVar.a, rVar.b, bArr, i, iMin);
        rVar.b += iMin;
        this.b -= (long) iMin;
        if (rVar.b == rVar.c) {
            this.a = rVar.b();
            s.a(rVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        r rVar = this.a;
        if (rVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), rVar.c - rVar.b);
        byteBuffer.put(rVar.a, rVar.b, iMin);
        rVar.b += iMin;
        this.b -= (long) iMin;
        if (rVar.b == rVar.c) {
            this.a = rVar.b();
            s.a(rVar);
        }
        return iMin;
    }

    public void g() {
        try {
            c(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public void c(long j) throws EOFException {
        while (j > 0) {
            r rVar = this.a;
            if (rVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, rVar.c - this.a.b);
            long j2 = iMin;
            this.b -= j2;
            j -= j2;
            this.a.b += iMin;
            if (this.a.b == this.a.c) {
                r rVar2 = this.a;
                this.a = rVar2.b();
                s.a(rVar2);
            }
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            r rVarA = a(1);
            int iMin = Math.min(i, 8192 - rVarA.c);
            byteBuffer.get(rVarA.a, rVarA.c, iMin);
            i -= iMin;
            rVarA.c += iMin;
        }
        this.b += (long) iRemaining;
        return iRemaining;
    }

    r a(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        r rVar = this.a;
        if (rVar == null) {
            r rVarA = s.a();
            this.a = rVarA;
            rVarA.g = rVarA;
            rVarA.f = rVarA;
            return rVarA;
        }
        r rVar2 = rVar.g;
        return (rVar2.c + i > 8192 || !rVar2.e) ? rVar2.a(s.a()) : rVar2;
    }

    public void a(l lVar, long j) {
        if (lVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (lVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        x.a(lVar.b, 0L, j);
        while (j > 0) {
            if (j < lVar.a.c - lVar.a.b) {
                r rVar = this.a;
                r rVar2 = rVar != null ? rVar.g : null;
                if (rVar2 != null && rVar2.e) {
                    if ((((long) rVar2.c) + j) - ((long) (rVar2.d ? 0 : rVar2.b)) <= 8192) {
                        lVar.a.a(rVar2, (int) j);
                        lVar.b -= j;
                        this.b += j;
                        return;
                    }
                }
                lVar.a = lVar.a.a((int) j);
            }
            r rVar3 = lVar.a;
            long j2 = rVar3.c - rVar3.b;
            lVar.a = rVar3.b();
            r rVar4 = this.a;
            if (rVar4 == null) {
                this.a = rVar3;
                rVar3.g = rVar3;
                rVar3.f = rVar3;
            } else {
                rVar4.g.a(rVar3).c();
            }
            lVar.b -= j2;
            this.b += j2;
            j -= j2;
        }
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.v
    public long b(l lVar, long j) {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        long j2 = this.b;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        lVar.a(this, j);
        return j;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public long a(byte b) {
        return a(b, 0L, Long.MAX_VALUE);
    }

    public long a(byte b, long j, long j2) {
        r rVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.b), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.b;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (rVar = this.a) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                rVar = rVar.g;
                j4 -= (long) (rVar.c - rVar.b);
            }
        } else {
            while (true) {
                long j6 = ((long) (rVar.c - rVar.b)) + j3;
                if (j6 >= j) {
                    break;
                }
                rVar = rVar.f;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = rVar.a;
            int iMin = (int) Math.min(rVar.c, (((long) rVar.b) + j5) - j4);
            for (int i = (int) ((((long) rVar.b) + j7) - j4); i < iMin; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - rVar.b)) + j4;
                }
            }
            j4 += (long) (rVar.c - rVar.b);
            rVar = rVar.f;
            j7 = j4;
        }
        return -1L;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        long j = this.b;
        if (j != lVar.b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        r rVar = this.a;
        r rVar2 = lVar.a;
        int i = rVar.b;
        int i2 = rVar2.b;
        while (j2 < this.b) {
            long jMin = Math.min(rVar.c - i, rVar2.c - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (rVar.a[i] != rVar2.a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == rVar.c) {
                rVar = rVar.f;
                i = rVar.b;
            }
            if (i2 == rVar2.c) {
                rVar2 = rVar2.f;
                i2 = rVar2.b;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        r rVar = this.a;
        if (rVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = rVar.c;
            for (int i3 = rVar.b; i3 < i2; i3++) {
                i = (i * 31) + rVar.a[i3];
            }
            rVar = rVar.f;
        } while (rVar != this.a);
        return i;
    }

    public String toString() {
        return i().toString();
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public l clone() {
        l lVar = new l();
        if (this.b == 0) {
            return lVar;
        }
        r rVarA = this.a.a();
        lVar.a = rVarA;
        rVarA.g = rVarA;
        rVarA.f = rVarA;
        r rVar = this.a;
        while (true) {
            rVar = rVar.f;
            if (rVar != this.a) {
                lVar.a.g.a(rVar.a());
            } else {
                lVar.b = this.b;
                return lVar;
            }
        }
    }

    public o i() {
        long j = this.b;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
        }
        return b((int) j);
    }

    public o b(int i) {
        if (i == 0) {
            return o.b;
        }
        return new t(this, i);
    }
}
