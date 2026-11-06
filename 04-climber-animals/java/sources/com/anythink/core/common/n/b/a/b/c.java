package com.anythink.core.common.n.b.a.b;

import com.anythink.core.common.n.b.ad;
import com.anythink.core.common.n.b.af;
import com.anythink.core.common.n.b.ag;
import com.anythink.core.common.n.b.r;
import com.anythink.core.common.n.b.u;
import com.anythink.core.common.n.c.n;
import com.anythink.core.common.n.c.v;
import com.anythink.core.common.n.c.w;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    final j a;
    final com.anythink.core.common.n.b.e b;
    final r c;
    final d d;
    final com.anythink.core.common.n.b.a.c.c e;
    private boolean f;

    private static void k() {
    }

    private static void l() {
    }

    public c(j jVar, com.anythink.core.common.n.b.e eVar, r rVar, d dVar, com.anythink.core.common.n.b.a.c.c cVar) {
        this.a = jVar;
        this.b = eVar;
        this.c = rVar;
        this.d = dVar;
        this.e = cVar;
    }

    public final e a() {
        return this.e.a();
    }

    public final boolean b() {
        return this.f;
    }

    public final void a(ad adVar) throws IOException {
        try {
            this.e.a(adVar);
        } catch (IOException e) {
            a(e);
            throw e;
        }
    }

    public final v b(ad adVar) {
        this.f = false;
        long jB = adVar.d().b();
        return new a(this.e.a(adVar, jB), jB);
    }

    public final void c() throws IOException {
        try {
            this.e.b();
        } catch (IOException e) {
            a(e);
            throw e;
        }
    }

    public final void d() throws IOException {
        try {
            this.e.c();
        } catch (IOException e) {
            a(e);
            throw e;
        }
    }

    public final af.a a(boolean z) throws IOException {
        try {
            af.a aVarA = this.e.a(z);
            if (aVarA != null) {
                com.anythink.core.common.n.b.a.a.a.a(aVarA, this);
            }
            return aVarA;
        } catch (IOException e) {
            a(e);
            throw e;
        }
    }

    public final ag a(af afVar) throws IOException {
        try {
            String strA = afVar.a("Content-Type");
            long jA = this.e.a(afVar);
            return new com.anythink.core.common.n.b.a.c.h(strA, jA, n.a(new b(this.e.b(afVar), jA)));
        } catch (IOException e) {
            a(e);
            throw e;
        }
    }

    public final u e() {
        return this.e.d();
    }

    private void m() {
        this.a.c();
    }

    public final com.anythink.core.common.n.b.a.k.a.e f() {
        this.a.c();
        return this.e.a().a(this);
    }

    public final void g() {
        a(true, true, null);
    }

    public final void h() {
        this.e.a().e();
    }

    private void n() {
        this.e.e();
    }

    public final void i() {
        this.e.e();
        this.a.a(this, true, true, null);
    }

    private void a(IOException iOException) {
        this.d.b();
        this.e.a().a(iOException);
    }

    final IOException a(boolean z, boolean z2, IOException iOException) {
        if (iOException != null) {
            a(iOException);
        }
        return this.a.a(this, z2, z, iOException);
    }

    public final void j() {
        this.a.a(this, true, false, null);
    }

    private final class a extends com.anythink.core.common.n.c.h {
        private boolean b;
        private long c;
        private long d;
        private boolean e;

        a(v vVar, long j) {
            super(vVar);
            this.c = j;
        }

        @Override // com.anythink.core.common.n.c.h, com.anythink.core.common.n.c.v
        public final void a(com.anythink.core.common.n.c.c cVar, long j) throws IOException {
            if (this.e) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.c;
            if (j2 != -1 && this.d + j > j2) {
                throw new ProtocolException("expected " + this.c + " bytes but received " + (this.d + j));
            }
            try {
                super.a(cVar, j);
                this.d += j;
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // com.anythink.core.common.n.c.h, com.anythink.core.common.n.c.v, java.io.Flushable
        public final void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // com.anythink.core.common.n.c.h, com.anythink.core.common.n.c.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.e) {
                return;
            }
            this.e = true;
            long j = this.c;
            if (j != -1 && this.d != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (IOException e) {
                throw a(e);
            }
        }

        private IOException a(IOException iOException) {
            if (this.b) {
                return iOException;
            }
            this.b = true;
            return c.this.a(false, true, iOException);
        }
    }

    final class b extends com.anythink.core.common.n.c.i {
        private final long b;
        private long c;
        private boolean d;
        private boolean e;

        b(w wVar, long j) {
            super(wVar);
            this.b = j;
            if (j == 0) {
                a(null);
            }
        }

        @Override // com.anythink.core.common.n.c.i, com.anythink.core.common.n.c.w
        public final long a_(com.anythink.core.common.n.c.c cVar, long j) throws IOException {
            if (this.e) {
                throw new IllegalStateException("closed");
            }
            try {
                long jA_ = b().a_(cVar, j);
                if (jA_ == -1) {
                    a(null);
                    return -1L;
                }
                long j2 = this.c + jA_;
                long j3 = this.b;
                if (j3 != -1 && j2 > j3) {
                    throw new ProtocolException("expected " + this.b + " bytes but received " + j2);
                }
                this.c = j2;
                if (j2 == j3) {
                    a(null);
                }
                return jA_;
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // com.anythink.core.common.n.c.i, com.anythink.core.common.n.c.w, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.e) {
                return;
            }
            this.e = true;
            try {
                super.close();
                a(null);
            } catch (IOException e) {
                throw a(e);
            }
        }

        private IOException a(IOException iOException) {
            if (this.d) {
                return iOException;
            }
            this.d = true;
            return c.this.a(true, false, iOException);
        }
    }
}
