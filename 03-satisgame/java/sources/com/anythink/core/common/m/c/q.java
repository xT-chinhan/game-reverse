package com.anythink.core.common.m.c;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
final class q implements d {
    public final c a = new c();
    public final v b;
    boolean c;

    q(v vVar) {
        if (vVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.b = vVar;
    }

    @Override // com.anythink.core.common.m.c.d, com.anythink.core.common.m.c.e
    public final c c() {
        return this.a;
    }

    @Override // com.anythink.core.common.m.c.v
    public final void a(c cVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(cVar, j);
        A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d d(f fVar) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.d(fVar);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d b(String str) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(str);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d b(String str, int i, int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(str, i, i2);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d m(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.m(i);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d b(String str, Charset charset) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(str, charset);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d b(String str, int i, int i2, Charset charset) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(str, i, i2, charset);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d d(byte[] bArr) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.d(bArr);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d c(byte[] bArr, int i, int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(bArr, i, i2);
        return A();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.a.write(byteBuffer);
        A();
        return iWrite;
    }

    @Override // com.anythink.core.common.m.c.d
    public final long a(w wVar) {
        if (wVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jA_ = wVar.a_(this.a, com.anythink.china.a.c.n);
            if (jA_ == -1) {
                return j;
            }
            j += jA_;
            A();
        }
    }

    @Override // com.anythink.core.common.m.c.d
    public final d a(w wVar, long j) throws EOFException {
        while (j > 0) {
            long jA_ = wVar.a_(this.a, j);
            if (jA_ == -1) {
                throw new EOFException();
            }
            j -= jA_;
            A();
        }
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    public final d l(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.l(i);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d k(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.k(i);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d j(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.j(i);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d i(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.i(i);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d h(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.h(i);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d q(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.q(j);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d p(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.p(j);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d o(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.o(j);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d n(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.n(j);
        return A();
    }

    @Override // com.anythink.core.common.m.c.d
    public final d A() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long j = this.a.j();
        if (j > 0) {
            this.b.a(this.a, j);
        }
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    public final d f() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long j = this.a.c;
        if (j > 0) {
            this.b.a(this.a, j);
        }
        return this;
    }

    @Override // com.anythink.core.common.m.c.d
    public final OutputStream e() {
        return new OutputStream() { // from class: com.anythink.core.common.m.c.q.1
            @Override // java.io.OutputStream
            public final void write(int i) throws IOException {
                if (q.this.c) {
                    throw new IOException("closed");
                }
                q.this.a.l((int) ((byte) i));
                q.this.A();
            }

            @Override // java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) throws IOException {
                if (q.this.c) {
                    throw new IOException("closed");
                }
                q.this.a.c(bArr, i, i2);
                q.this.A();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public final void flush() {
                if (q.this.c) {
                    return;
                }
                q.this.flush();
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws Throwable {
                q.this.close();
            }

            public final String toString() {
                return q.this + ".outputStream()";
            }
        };
    }

    @Override // com.anythink.core.common.m.c.d, com.anythink.core.common.m.c.v, java.io.Flushable
    public final void flush() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.c > 0) {
            v vVar = this.b;
            c cVar = this.a;
            vVar.a(cVar, cVar.c);
        }
        this.b.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.c;
    }

    @Override // com.anythink.core.common.m.c.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        if (this.c) {
            return;
        }
        if (this.a.c > 0) {
            v vVar = this.b;
            c cVar = this.a;
            vVar.a(cVar, cVar.c);
        }
        th = null;
        try {
            this.b.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.c = true;
        if (th != null) {
            y.a(th);
        }
    }

    @Override // com.anythink.core.common.m.c.v
    public final x a() {
        return this.b.a();
    }

    public final String toString() {
        return "buffer(" + this.b + ")";
    }
}
