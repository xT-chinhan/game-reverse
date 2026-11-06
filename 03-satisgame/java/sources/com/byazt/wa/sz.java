package com.byazt.wa;

import com.anythink.china.a.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 110})
public final class sz implements l {
    public final s n = new s();
    public final um qg;
    public boolean s;

    public sz(um umVar) {
        if (umVar == null) {
            throw new NullPointerException("source == null");
        }
        this.qg = umVar;
    }

    @Override // com.byazt.wa.l, com.byazt.wa.q
    public s s() {
        return this.n;
    }

    @Override // com.byazt.wa.um
    public long n(s sVar, long j) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        if (this.n.qg == 0 && this.qg.n(this.n, c.n) == -1) {
            return -1L;
        }
        return this.n.n(sVar, Math.min(j, this.n.qg));
    }

    @Override // com.byazt.wa.l
    public boolean l() throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        return this.n.l() && this.qg.n(this.n, c.n) == -1;
    }

    @Override // com.byazt.wa.l
    public void n(long j) throws IOException {
        if (!qg(j)) {
            throw new EOFException();
        }
    }

    public boolean qg(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        while (this.n.qg < j) {
            if (this.qg.n(this.n, c.n) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.byazt.wa.l
    public byte fs() throws IOException {
        n(1L);
        return this.n.fs();
    }

    @Override // com.byazt.wa.l
    public w s(long j) throws IOException {
        n(j);
        return this.n.s(j);
    }

    @Override // com.byazt.wa.l
    public byte[] hd() throws IOException {
        this.n.n(this.qg);
        return this.n.hd();
    }

    @Override // com.byazt.wa.l
    public byte[] x(long j) throws IOException {
        n(j);
        return this.n.x(j);
    }

    @Override // com.byazt.wa.l
    public void n(byte[] bArr) throws IOException {
        try {
            n(bArr.length);
            this.n.n(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.n.qg > 0) {
                s sVar = this.n;
                int iN = sVar.n(bArr, i, (int) sVar.qg);
                if (iN == -1) {
                    throw new AssertionError();
                }
                i += iN;
            }
            throw e;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.n.qg == 0 && this.qg.n(this.n, c.n) == -1) {
            return -1;
        }
        return this.n.read(byteBuffer);
    }

    @Override // com.byazt.wa.l
    public String n(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.n.n(this.qg);
        return this.n.n(charset);
    }

    @Override // com.byazt.wa.l
    public String cy() throws IOException {
        return l(LongCompanionObject.MAX_VALUE);
    }

    @Override // com.byazt.wa.l
    public String l(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = j == LongCompanionObject.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jN = n((byte) 10, 0L, j2);
        if (jN != -1) {
            return this.n.w(jN);
        }
        if (j2 < LongCompanionObject.MAX_VALUE && qg(j2) && this.n.qg(j2 - 1) == 13 && qg(1 + j2) && this.n.qg(j2) == 10) {
            return this.n.w(j2);
        }
        s sVar = new s();
        s sVar2 = this.n;
        sVar2.n(sVar, 0L, Math.min(32L, sVar2.qg()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.n.qg(), j) + " content=" + sVar.sz().l() + Typography.ellipsis);
    }

    @Override // com.byazt.wa.l
    public short rv() throws IOException {
        n(2L);
        return this.n.rv();
    }

    @Override // com.byazt.wa.l
    public short cp() throws IOException {
        n(2L);
        return this.n.cp();
    }

    @Override // com.byazt.wa.l
    public int tj() throws IOException {
        n(4L);
        return this.n.tj();
    }

    @Override // com.byazt.wa.l
    public int d() throws IOException {
        n(4L);
        return this.n.d();
    }

    @Override // com.byazt.wa.l
    public long oa() throws IOException {
        n(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!qg(i2)) {
                break;
            }
            byte bQg = this.n.qg(i);
            if ((bQg < 48 || bQg > 57) && ((bQg < 97 || bQg > 102) && (bQg < 65 || bQg > 70))) {
                if (i != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bQg)));
            }
            i = i2;
        }
        return this.n.oa();
    }

    @Override // com.byazt.wa.l
    public void fs(long j) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.n.qg == 0 && this.qg.n(this.n, c.n) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.n.qg());
            this.n.fs(jMin);
            j -= jMin;
        }
    }

    @Override // com.byazt.wa.l
    public long n(byte b) throws IOException {
        return n(b, 0L, LongCompanionObject.MAX_VALUE);
    }

    public long n(byte b, long j, long j2) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jN = this.n.n(b, j, j2);
            if (jN != -1) {
                return jN;
            }
            long j3 = this.n.qg;
            if (j3 >= j2 || this.qg.n(this.n, c.n) == -1) {
                break;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // com.byazt.wa.l
    public boolean n(long j, w wVar) throws IOException {
        return n(j, wVar, 0, wVar.x());
    }

    public boolean n(long j, w wVar, int i, int i2) throws IOException {
        if (this.s) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || wVar.x() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = ((long) i3) + j;
            if (!qg(1 + j2) || this.n.qg(j2) != wVar.n(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.byazt.wa.l
    public InputStream w() {
        return new InputStream() { // from class: com.byazt.wa.sz.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (sz.this.s) {
                    throw new IOException("closed");
                }
                if (sz.this.n.qg == 0 && sz.this.qg.n(sz.this.n, c.n) == -1) {
                    return -1;
                }
                return sz.this.n.fs() & UByte.MAX_VALUE;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (sz.this.s) {
                    throw new IOException("closed");
                }
                py.n(bArr.length, i, i2);
                if (sz.this.n.qg == 0 && sz.this.qg.n(sz.this.n, c.n) == -1) {
                    return -1;
                }
                return sz.this.n.n(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (sz.this.s) {
                    throw new IOException("closed");
                }
                return (int) Math.min(sz.this.n.qg, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                sz.this.close();
            }

            public String toString() {
                return sz.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.s;
    }

    @Override // com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.s) {
            return;
        }
        this.s = true;
        this.qg.close();
        this.n.cd();
    }

    @Override // com.byazt.wa.um
    public a n() {
        return this.qg.n();
    }

    public String toString() {
        return "buffer(" + this.qg + ")";
    }
}
