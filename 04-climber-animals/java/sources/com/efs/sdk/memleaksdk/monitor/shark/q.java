package com.efs.sdk.memleaksdk.monitor.shark;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
final class q implements n {
    public final l a = new l();
    public final v b;
    boolean c;

    q(v vVar) {
        if (vVar == null) {
            throw new NullPointerException("source == null");
        }
        this.b = vVar;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.v
    public long b(l lVar, long j) throws IOException {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b == 0 && this.b.b(this.a, 8192L) == -1) {
            return -1L;
        }
        return this.a.b(lVar, Math.min(j, this.a.b));
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public boolean b() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.a.b() && this.b.b(this.a, 8192L) == -1;
    }

    public void d(long j) throws IOException {
        if (!e(j)) {
            throw new EOFException();
        }
    }

    public boolean e(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (this.a.b < j) {
            if (this.b.b(this.a, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public byte c() throws IOException {
        d(1L);
        return this.a.c();
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public byte[] b(long j) throws IOException {
        d(j);
        return this.a.b(j);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.a.b == 0 && this.b.b(this.a, 8192L) == -1) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public String a(long j) throws IOException {
        d(j);
        return this.a.a(j);
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public String a(long j, Charset charset) throws IOException {
        d(j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        return this.a.a(j, charset);
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public short d() throws IOException {
        d(2L);
        return this.a.d();
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public int e() throws IOException {
        d(4L);
        return this.a.e();
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public long f() throws IOException {
        d(8L);
        return this.a.f();
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public void c(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.a.b == 0 && this.b.b(this.a, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.a.a());
            this.a.c(jMin);
            j -= jMin;
        }
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public long a(byte b) throws IOException {
        return a(b, 0L, Long.MAX_VALUE);
    }

    public long a(byte b, long j, long j2) throws IOException {
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
            long j3 = this.a.b;
            if (j3 >= j2 || this.b.b(this.a, 8192L) == -1) {
                break;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.v, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.g();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
