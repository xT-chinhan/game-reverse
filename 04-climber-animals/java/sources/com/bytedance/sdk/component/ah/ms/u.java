package com.bytedance.sdk.component.ah.ms;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
final class u implements ka {
    boolean ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final ah f1018ms = new ah();
    public final y xr;

    u(y yVar) {
        if (yVar == null) {
            throw new NullPointerException("source == null");
        }
        this.xr = yVar;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public ah ah() {
        return this.f1018ms;
    }

    @Override // com.bytedance.sdk.component.ah.ms.y
    public long ms(ah ahVar, long j) throws IOException {
        if (ahVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        if (this.f1018ms.xr == 0 && this.xr.ms(this.f1018ms, 8192L) == -1) {
            return -1L;
        }
        return this.f1018ms.ms(ahVar, Math.min(j, this.f1018ms.xr));
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public boolean ka() throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        return this.f1018ms.ka() && this.xr.ms(this.f1018ms, 8192L) == -1;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public void ms(long j) throws IOException {
        if (!xr(j)) {
            throw new EOFException();
        }
    }

    public boolean xr(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        while (this.f1018ms.xr < j) {
            if (this.xr.ms(this.f1018ms, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public byte x() throws IOException {
        ms(1L);
        return this.f1018ms.x();
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public c ah(long j) throws IOException {
        ms(j);
        return this.f1018ms.ah(j);
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public byte[] h() throws IOException {
        this.f1018ms.ms(this.xr);
        return this.f1018ms.h();
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public byte[] ab(long j) throws IOException {
        ms(j);
        return this.f1018ms.ab(j);
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public void ms(byte[] bArr) throws IOException {
        try {
            ms(bArr.length);
            this.f1018ms.ms(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f1018ms.xr > 0) {
                ah ahVar = this.f1018ms;
                int iMs = ahVar.ms(bArr, i, (int) ahVar.xr);
                if (iMs == -1) {
                    throw new AssertionError();
                }
                i += iMs;
            }
            throw e;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f1018ms.xr == 0 && this.xr.ms(this.f1018ms, 8192L) == -1) {
            return -1;
        }
        return this.f1018ms.read(byteBuffer);
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public String ms(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f1018ms.ms(this.xr);
        return this.f1018ms.ms(charset);
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public String ao() throws IOException {
        return ka(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public String ka(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jMs = ms((byte) 10, 0L, j2);
        if (jMs != -1) {
            return this.f1018ms.c(jMs);
        }
        if (j2 < Long.MAX_VALUE && xr(j2) && this.f1018ms.xr(j2 - 1) == 13 && xr(1 + j2) && this.f1018ms.xr(j2) == 10) {
            return this.f1018ms.c(j2);
        }
        ah ahVar = new ah();
        ah ahVar2 = this.f1018ms;
        ahVar2.ms(ahVar, 0L, Math.min(32L, ahVar2.xr()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f1018ms.xr(), j) + " content=" + ahVar.u().ka() + Typography.ellipsis);
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public short ny() throws IOException {
        ms(2L);
        return this.f1018ms.ny();
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public short hi() throws IOException {
        ms(2L);
        return this.f1018ms.hi();
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public int ch() throws IOException {
        ms(4L);
        return this.f1018ms.ch();
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public int sl() throws IOException {
        ms(4L);
        return this.f1018ms.sl();
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public long zb() throws IOException {
        ms(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!xr(i2)) {
                break;
            }
            byte bXr = this.f1018ms.xr(i);
            if ((bXr < 48 || bXr > 57) && ((bXr < 97 || bXr > 102) && (bXr < 65 || bXr > 70))) {
                if (i != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bXr)));
            }
            i = i2;
        }
        return this.f1018ms.zb();
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public void x(long j) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f1018ms.xr == 0 && this.xr.ms(this.f1018ms, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.f1018ms.xr());
            this.f1018ms.x(jMin);
            j -= jMin;
        }
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public long ms(byte b) throws IOException {
        return ms(b, 0L, Long.MAX_VALUE);
    }

    public long ms(byte b, long j, long j2) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jMs = this.f1018ms.ms(b, j, j2);
            if (jMs != -1) {
                return jMs;
            }
            long j3 = this.f1018ms.xr;
            if (j3 >= j2 || this.xr.ms(this.f1018ms, 8192L) == -1) {
                break;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public boolean ms(long j, c cVar) throws IOException {
        return ms(j, cVar, 0, cVar.ab());
    }

    public boolean ms(long j, c cVar, int i, int i2) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || cVar.ab() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = ((long) i3) + j;
            if (!xr(1 + j2) || this.f1018ms.xr(j2) != cVar.ms(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public InputStream c() {
        return new InputStream() { // from class: com.bytedance.sdk.component.ah.ms.u.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (u.this.ah) {
                    throw new IOException("closed");
                }
                if (u.this.f1018ms.xr == 0 && u.this.xr.ms(u.this.f1018ms, 8192L) == -1) {
                    return -1;
                }
                return u.this.f1018ms.x() & UByte.MAX_VALUE;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (u.this.ah) {
                    throw new IOException("closed");
                }
                nw.ms(bArr.length, i, i2);
                if (u.this.f1018ms.xr == 0 && u.this.xr.ms(u.this.f1018ms, 8192L) == -1) {
                    return -1;
                }
                return u.this.f1018ms.ms(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (u.this.ah) {
                    throw new IOException("closed");
                }
                return (int) Math.min(u.this.f1018ms.xr, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                u.this.close();
            }

            public String toString() {
                return u.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.ah;
    }

    @Override // com.bytedance.sdk.component.ah.ms.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.ah) {
            return;
        }
        this.ah = true;
        this.xr.close();
        this.f1018ms.qv();
    }

    @Override // com.bytedance.sdk.component.ah.ms.y
    public t ms() {
        return this.xr.ms();
    }

    public String toString() {
        return "buffer(" + this.xr + ")";
    }
}
