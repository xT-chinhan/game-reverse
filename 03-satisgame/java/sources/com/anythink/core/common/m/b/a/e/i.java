package com.anythink.core.common.m.b.a.e;

import com.anythink.core.common.m.b.u;
import com.anythink.core.common.m.c.v;
import com.anythink.core.common.m.c.w;
import com.anythink.core.common.m.c.x;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    static final /* synthetic */ boolean j = true;
    long a = 0;
    long b;
    final int c;
    final f d;
    final a e;
    final c f;
    final c g;
    com.anythink.core.common.m.b.a.e.b h;
    IOException i;
    private final Deque<u> k;
    private boolean l;
    private final b m;

    i(int i, f fVar, boolean z, boolean z2, u uVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.k = arrayDeque;
        this.f = new c();
        this.g = new c();
        if (fVar == null) {
            throw new NullPointerException("connection == null");
        }
        this.c = i;
        this.d = fVar;
        this.b = fVar.p.e();
        b bVar = new b(fVar.o.e());
        this.m = bVar;
        a aVar = new a();
        this.e = aVar;
        bVar.b = z2;
        aVar.b = z;
        if (uVar != null) {
            arrayDeque.add(uVar);
        }
        if (b() && uVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!b() && uVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private int j() {
        return this.c;
    }

    public final synchronized boolean a() {
        if (this.h != null) {
            return false;
        }
        return ((this.m.b || this.m.a) && (this.e.b || this.e.a) && this.l) ? false : true;
    }

    public final boolean b() {
        return this.d.f == ((this.c & 1) == 1);
    }

    private f k() {
        return this.d;
    }

    public final synchronized u c() {
        this.f.c();
        while (this.k.isEmpty() && this.h == null) {
            try {
                i();
            } catch (Throwable th) {
                this.f.b();
                throw th;
            }
        }
        this.f.b();
        if (!this.k.isEmpty()) {
        } else {
            IOException iOException = this.i;
            if (iOException != null) {
                throw iOException;
            }
            throw new n(this.h);
        }
        return this.k.removeFirst();
    }

    public final synchronized u d() throws IOException {
        if (this.h != null) {
            IOException iOException = this.i;
            if (iOException != null) {
                throw iOException;
            }
            throw new n(this.h);
        }
        if (!this.m.b || !this.m.e.g() || !this.m.f.g()) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        if (this.m.h != null) {
            return this.m.h;
        }
        return com.anythink.core.common.m.b.a.c.c;
    }

    private synchronized com.anythink.core.common.m.b.a.e.b l() {
        return this.h;
    }

    private void a(List<com.anythink.core.common.m.b.a.e.c> list, boolean z, boolean z2) {
        boolean z3;
        if (!j && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (list == null) {
            throw new NullPointerException("headers == null");
        }
        synchronized (this) {
            z3 = true;
            this.l = true;
            if (z) {
                this.e.b = true;
            }
        }
        if (!z2) {
            synchronized (this.d) {
                if (this.d.n != 0) {
                    z3 = false;
                }
            }
            z2 = z3;
        }
        this.d.a(this.c, z, list);
        if (z2) {
            this.d.r.b();
        }
    }

    private void a(u uVar) {
        synchronized (this) {
            if (this.e.b) {
                throw new IllegalStateException("already finished");
            }
            if (uVar.a() == 0) {
                throw new IllegalArgumentException("trailers.size() == 0");
            }
            this.e.g = uVar;
        }
    }

    private x m() {
        return this.f;
    }

    private x n() {
        return this.g;
    }

    public final w e() {
        return this.m;
    }

    public final v f() {
        synchronized (this) {
            if (!this.l && !b()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.e;
    }

    public final void a(com.anythink.core.common.m.b.a.e.b bVar, IOException iOException) {
        if (b(bVar, iOException)) {
            this.d.b(this.c, bVar);
        }
    }

    public final void a(com.anythink.core.common.m.b.a.e.b bVar) {
        if (b(bVar, null)) {
            this.d.a(this.c, bVar);
        }
    }

    private boolean b(com.anythink.core.common.m.b.a.e.b bVar, IOException iOException) {
        if (!j && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.h != null) {
                return false;
            }
            if (this.m.b && this.e.b) {
                return false;
            }
            this.h = bVar;
            this.i = iOException;
            notifyAll();
            this.d.b(this.c);
            return true;
        }
    }

    final void a(com.anythink.core.common.m.c.e eVar, int i) {
        if (!j && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.m.a(eVar, i);
    }

    final void a(u uVar, boolean z) {
        boolean zA;
        if (!j && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (!this.l || !z) {
                this.l = true;
                this.k.add(uVar);
            } else {
                this.m.h = uVar;
            }
            if (z) {
                this.m.b = true;
            }
            zA = a();
            notifyAll();
        }
        if (zA) {
            return;
        }
        this.d.b(this.c);
    }

    final synchronized void b(com.anythink.core.common.m.b.a.e.b bVar) {
        if (this.h == null) {
            this.h = bVar;
            notifyAll();
        }
    }

    private final class b implements w {
        static final /* synthetic */ boolean c = true;
        boolean a;
        boolean b;
        private final com.anythink.core.common.m.c.c e = new com.anythink.core.common.m.c.c();
        private final com.anythink.core.common.m.c.c f = new com.anythink.core.common.m.c.c();
        private final long g;
        private u h;

        b(long j) {
            this.g = j;
        }

        /* JADX WARN: Code duplicated, block: B:35:0x009e  */
        /* JADX WARN: Code duplicated, block: B:37:0x00a2 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:38:0x00a4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:39:0x00a5  */
        @Override // com.anythink.core.common.m.c.w
        public final long a_(com.anythink.core.common.m.c.c cVar, long j) throws Throwable {
            Throwable nVar;
            long jA_;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            while (true) {
                synchronized (i.this) {
                    i.this.f.c();
                    try {
                        if (i.this.h == null) {
                            nVar = null;
                        } else if (i.this.i != null) {
                            nVar = i.this.i;
                        } else {
                            nVar = new n(i.this.h);
                        }
                        if (this.a) {
                            throw new IOException("stream closed");
                        }
                        if (this.f.b() > 0) {
                            com.anythink.core.common.m.c.c cVar2 = this.f;
                            jA_ = cVar2.a_(cVar, Math.min(j, cVar2.b()));
                            i.this.a += jA_;
                            if (nVar != null || i.this.a < i.this.d.o.e() / 2) {
                                break;
                                break;
                            }
                            i.this.d.a(i.this.c, i.this.a);
                            i.this.a = 0L;
                            break;
                        }
                        if (this.b || nVar != null) {
                            jA_ = -1;
                            break;
                        }
                        i.this.i();
                        i.this.f.b();
                    } catch (Throwable th) {
                        i.this.f.b();
                        throw th;
                    }
                }
                if (jA_ != -1) {
                    a(jA_);
                    return jA_;
                }
                if (nVar == null) {
                    return -1L;
                }
                throw nVar;
            }
            i.this.f.b();
            if (jA_ != -1) {
                a(jA_);
                return jA_;
            }
            if (nVar == null) {
                return -1L;
            }
            throw nVar;
        }

        private void a(long j) {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            i.this.d.a(j);
        }

        final void a(com.anythink.core.common.m.c.e eVar, long j) throws EOFException {
            boolean z;
            boolean z2;
            boolean z3;
            long jB;
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (i.this) {
                    z = this.b;
                    z2 = true;
                    z3 = this.f.b() + j > this.g;
                }
                if (z3) {
                    eVar.i(j);
                    i.this.a(com.anythink.core.common.m.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    eVar.i(j);
                    return;
                }
                long jA_ = eVar.a_(this.e, j);
                if (jA_ == -1) {
                    throw new EOFException();
                }
                j -= jA_;
                synchronized (i.this) {
                    if (this.a) {
                        jB = this.e.b();
                        this.e.z();
                    } else {
                        if (this.f.b() != 0) {
                            z2 = false;
                        }
                        this.f.a((w) this.e);
                        if (z2) {
                            i.this.notifyAll();
                        }
                        jB = 0;
                    }
                }
                if (jB > 0) {
                    a(jB);
                }
            }
        }

        @Override // com.anythink.core.common.m.c.w
        public final x a() {
            return i.this.f;
        }

        @Override // com.anythink.core.common.m.c.w, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            long jB;
            synchronized (i.this) {
                this.a = true;
                jB = this.f.b();
                this.f.z();
                i.this.notifyAll();
            }
            if (jB > 0) {
                a(jB);
            }
            i.this.g();
        }
    }

    final void g() {
        boolean z;
        boolean zA;
        if (!j && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.m.b && this.m.a && (this.e.b || this.e.a);
            zA = a();
        }
        if (z) {
            a(com.anythink.core.common.m.b.a.e.b.CANCEL, (IOException) null);
        } else {
            if (zA) {
                return;
            }
            this.d.b(this.c);
        }
    }

    final class a implements v {
        static final /* synthetic */ boolean c = true;
        private static final long e = 16384;
        boolean a;
        boolean b;
        private final com.anythink.core.common.m.c.c f = new com.anythink.core.common.m.c.c();
        private u g;

        a() {
        }

        @Override // com.anythink.core.common.m.c.v
        public final void a(com.anythink.core.common.m.c.c cVar, long j) throws IOException {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            this.f.a(cVar, j);
            while (this.f.b() >= 16384) {
                a(false);
            }
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0061  */
        private void a(boolean z) throws IOException {
            long jMin;
            boolean z2;
            synchronized (i.this) {
                i.this.g.c();
                while (i.this.b <= 0 && !this.b && !this.a && i.this.h == null) {
                    try {
                        i.this.i();
                    } catch (Throwable th) {
                        i.this.g.b();
                        throw th;
                    }
                }
                i.this.g.b();
                i.this.h();
                jMin = Math.min(i.this.b, this.f.b());
                i.this.b -= jMin;
            }
            i.this.g.c();
            if (z) {
                try {
                    if (jMin == this.f.b()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } finally {
                    i.this.g.b();
                }
            } else {
                z2 = false;
            }
            i.this.d.a(i.this.c, z2, this.f, jMin);
        }

        @Override // com.anythink.core.common.m.c.v, java.io.Flushable
        public final void flush() throws IOException {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                i.this.h();
            }
            while (this.f.b() > 0) {
                a(false);
                i.this.d.r.b();
            }
        }

        @Override // com.anythink.core.common.m.c.v
        public final x a() {
            return i.this.g;
        }

        @Override // com.anythink.core.common.m.c.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (this.a) {
                    return;
                }
                if (!i.this.e.b) {
                    boolean z = this.f.b() > 0;
                    if (this.g != null) {
                        while (this.f.b() > 0) {
                            a(false);
                        }
                        i.this.d.a(i.this.c, true, com.anythink.core.common.m.b.a.c.a(this.g));
                    } else if (z) {
                        while (this.f.b() > 0) {
                            a(true);
                        }
                    } else {
                        i.this.d.a(i.this.c, true, (com.anythink.core.common.m.c.c) null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.a = true;
                }
                i.this.d.r.b();
                i.this.g();
            }
        }
    }

    final void a(long j2) {
        this.b += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    final void h() throws IOException {
        if (this.e.a) {
            throw new IOException("stream closed");
        }
        if (this.e.b) {
            throw new IOException("stream finished");
        }
        if (this.h != null) {
            IOException iOException = this.i;
            if (iOException == null) {
                throw new n(this.h);
            }
        }
    }

    final void i() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    class c extends com.anythink.core.common.m.c.a {
        c() {
        }

        @Override // com.anythink.core.common.m.c.a
        protected final void a() {
            i.this.a(com.anythink.core.common.m.b.a.e.b.CANCEL);
            i.this.d.c();
        }

        @Override // com.anythink.core.common.m.c.a
        protected final IOException a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public final void b() throws IOException {
            if (d()) {
                throw a((IOException) null);
            }
        }
    }
}
