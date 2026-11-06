package com.anythink.core.common.n.b.a.d;

import com.anythink.core.common.n.b.a.c.i;
import com.anythink.core.common.n.b.a.c.k;
import com.anythink.core.common.n.b.ad;
import com.anythink.core.common.n.b.af;
import com.anythink.core.common.n.b.u;
import com.anythink.core.common.n.b.z;
import com.anythink.core.common.n.c.j;
import com.anythink.core.common.n.c.v;
import com.anythink.core.common.n.c.w;
import com.anythink.core.common.n.c.x;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.anythink.core.common.n.b.a.c.c {
    private static final int b = 0;
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static final int f = 4;
    private static final int g = 5;
    private static final int h = 6;
    private static final int i = 262144;
    private final z j;
    private final com.anythink.core.common.n.b.a.b.e k;
    private final com.anythink.core.common.n.c.e l;
    private final com.anythink.core.common.n.c.d m;
    private int n = 0;
    private long o = 262144;
    private u p;

    public a(z zVar, com.anythink.core.common.n.b.a.b.e eVar, com.anythink.core.common.n.c.e eVar2, com.anythink.core.common.n.c.d dVar) {
        this.j = zVar;
        this.k = eVar;
        this.l = eVar2;
        this.m = dVar;
    }

    @Override // com.anythink.core.common.n.b.a.c.c
    public final com.anythink.core.common.n.b.a.b.e a() {
        return this.k;
    }

    @Override // com.anythink.core.common.n.b.a.c.c
    public final v a(ad adVar, long j) {
        if (adVar.d() != null) {
            adVar.d();
        }
        if ("chunked".equalsIgnoreCase(adVar.a("Transfer-Encoding"))) {
            if (this.n != 1) {
                throw new IllegalStateException("state: " + this.n);
            }
            this.n = 2;
            return new b();
        }
        if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.n != 1) {
            throw new IllegalStateException("state: " + this.n);
        }
        this.n = 2;
        return new e(this, (byte) 0);
    }

    @Override // com.anythink.core.common.n.b.a.c.c
    public final void e() {
        com.anythink.core.common.n.b.a.b.e eVar = this.k;
        if (eVar != null) {
            eVar.f();
        }
    }

    @Override // com.anythink.core.common.n.b.a.c.c
    public final void a(ad adVar) {
        Proxy.Type type = this.k.a().b().type();
        StringBuilder sb = new StringBuilder();
        sb.append(adVar.b());
        sb.append(' ');
        if (!adVar.g() && type == Proxy.Type.HTTP) {
            sb.append(adVar.a());
        } else {
            sb.append(i.a(adVar.a()));
        }
        sb.append(" HTTP/1.1");
        a(adVar.c(), sb.toString());
    }

    @Override // com.anythink.core.common.n.b.a.c.c
    public final long a(af afVar) {
        if (!com.anythink.core.common.n.b.a.c.e.d(afVar)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(afVar.a("Transfer-Encoding"))) {
            return -1L;
        }
        return com.anythink.core.common.n.b.a.c.e.a(afVar);
    }

    @Override // com.anythink.core.common.n.b.a.c.c
    public final w b(af afVar) {
        if (!com.anythink.core.common.n.b.a.c.e.d(afVar)) {
            return a(0L);
        }
        if ("chunked".equalsIgnoreCase(afVar.a("Transfer-Encoding"))) {
            com.anythink.core.common.n.b.v vVarA = afVar.a().a();
            if (this.n != 4) {
                throw new IllegalStateException("state: " + this.n);
            }
            this.n = 5;
            return new c(vVarA);
        }
        long jA = com.anythink.core.common.n.b.a.c.e.a(afVar);
        if (jA != -1) {
            return a(jA);
        }
        if (this.n != 4) {
            throw new IllegalStateException("state: " + this.n);
        }
        this.n = 5;
        this.k.e();
        return new f(this, (byte) 0);
    }

    @Override // com.anythink.core.common.n.b.a.c.c
    public final u d() {
        if (this.n != 6) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        u uVar = this.p;
        return uVar != null ? uVar : com.anythink.core.common.n.b.a.c.c;
    }

    private boolean f() {
        return this.n == 6;
    }

    @Override // com.anythink.core.common.n.b.a.c.c
    public final void b() {
        this.m.flush();
    }

    @Override // com.anythink.core.common.n.b.a.c.c
    public final void c() {
        this.m.flush();
    }

    public final void a(u uVar, String str) {
        if (this.n != 0) {
            throw new IllegalStateException("state: " + this.n);
        }
        this.m.b(str).b("\r\n");
        int iA = uVar.a();
        for (int i2 = 0; i2 < iA; i2++) {
            this.m.b(uVar.a(i2)).b(": ").b(uVar.b(i2)).b("\r\n");
        }
        this.m.b("\r\n");
        this.n = 1;
    }

    @Override // com.anythink.core.common.n.b.a.c.c
    public final af.a a(boolean z) throws IOException {
        int i2 = this.n;
        if (i2 != 1 && i2 != 3) {
            throw new IllegalStateException("state: " + this.n);
        }
        try {
            k kVarA = k.a(g());
            af.a aVarA = new af.a().a(kVarA.d).a(kVarA.e).a(kVarA.f).a(h());
            if (z && kVarA.e == 100) {
                return null;
            }
            if (kVarA.e == 100) {
                this.n = 3;
                return aVarA;
            }
            this.n = 4;
            return aVarA;
        } catch (EOFException e2) {
            com.anythink.core.common.n.b.a.b.e eVar = this.k;
            throw new IOException("unexpected end of stream on ".concat(String.valueOf(eVar != null ? eVar.a().a().a().l() : "unknown")), e2);
        }
    }

    private String g() {
        String strF = this.l.f(this.o);
        this.o -= (long) strF.length();
        return strF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public u h() {
        u.a aVar = new u.a();
        while (true) {
            String strG = g();
            if (strG.length() != 0) {
                com.anythink.core.common.n.b.a.a.a.a(aVar, strG);
            } else {
                return aVar.a();
            }
        }
    }

    private v i() {
        if (this.n != 1) {
            throw new IllegalStateException("state: " + this.n);
        }
        this.n = 2;
        return new b();
    }

    private v j() {
        if (this.n != 1) {
            throw new IllegalStateException("state: " + this.n);
        }
        this.n = 2;
        return new e(this, (byte) 0);
    }

    private w a(long j) {
        if (this.n != 4) {
            throw new IllegalStateException("state: " + this.n);
        }
        this.n = 5;
        return new d(j);
    }

    private w a(com.anythink.core.common.n.b.v vVar) {
        if (this.n != 4) {
            throw new IllegalStateException("state: " + this.n);
        }
        this.n = 5;
        return new c(vVar);
    }

    private w k() {
        if (this.n != 4) {
            throw new IllegalStateException("state: " + this.n);
        }
        this.n = 5;
        this.k.e();
        return new f(this, (byte) 0);
    }

    private static void b(j jVar) {
        x xVarA = jVar.a();
        jVar.a(x.c);
        xVarA.f();
        xVarA.h_();
    }

    public final void c(af afVar) {
        long jA = com.anythink.core.common.n.b.a.c.e.a(afVar);
        if (jA == -1) {
            return;
        }
        w wVarA = a(jA);
        com.anythink.core.common.n.b.a.c.a(wVarA, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        wVarA.close();
    }

    private final class e implements v {
        private final j b;
        private boolean c;

        private e() {
            this.b = new j(a.this.m.a());
        }

        /* synthetic */ e(a aVar, byte b) {
            this();
        }

        @Override // com.anythink.core.common.n.c.v
        public final x a() {
            return this.b;
        }

        @Override // com.anythink.core.common.n.c.v
        public final void a(com.anythink.core.common.n.c.c cVar, long j) {
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            com.anythink.core.common.n.b.a.c.a(cVar.b(), j);
            a.this.m.a(cVar, j);
        }

        @Override // com.anythink.core.common.n.c.v, java.io.Flushable
        public final void flush() {
            if (this.c) {
                return;
            }
            a.this.m.flush();
        }

        @Override // com.anythink.core.common.n.c.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.c) {
                return;
            }
            this.c = true;
            a.a(this.b);
            a.this.n = 3;
        }
    }

    private final class b implements v {
        private final j b;
        private boolean c;

        b() {
            this.b = new j(a.this.m.a());
        }

        @Override // com.anythink.core.common.n.c.v
        public final x a() {
            return this.b;
        }

        @Override // com.anythink.core.common.n.c.v
        public final void a(com.anythink.core.common.n.c.c cVar, long j) {
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            a.this.m.n(j);
            a.this.m.b("\r\n");
            a.this.m.a(cVar, j);
            a.this.m.b("\r\n");
        }

        @Override // com.anythink.core.common.n.c.v, java.io.Flushable
        public final synchronized void flush() {
            if (this.c) {
                return;
            }
            a.this.m.flush();
        }

        @Override // com.anythink.core.common.n.c.v, java.io.Closeable, java.lang.AutoCloseable
        public final synchronized void close() {
            if (this.c) {
                return;
            }
            this.c = true;
            a.this.m.b("0\r\n\r\n");
            a.a(this.b);
            a.this.n = 3;
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.n.b.a.d.a$a, reason: collision with other inner class name */
    private abstract class AbstractC0089a implements w {
        protected final j a;
        protected boolean b;

        private AbstractC0089a() {
            this.a = new j(a.this.l.a());
        }

        /* synthetic */ AbstractC0089a(a aVar, byte b) {
            this();
        }

        @Override // com.anythink.core.common.n.c.w
        public final x a() {
            return this.a;
        }

        @Override // com.anythink.core.common.n.c.w
        public long a_(com.anythink.core.common.n.c.c cVar, long j) throws IOException {
            try {
                return a.this.l.a_(cVar, j);
            } catch (IOException e) {
                a.this.k.e();
                b();
                throw e;
            }
        }

        final void b() {
            if (a.this.n == 6) {
                return;
            }
            if (a.this.n != 5) {
                throw new IllegalStateException("state: " + a.this.n);
            }
            a.a(this.a);
            a.this.n = 6;
        }
    }

    private class d extends AbstractC0089a {
        private long e;

        d(long j) {
            super(a.this, (byte) 0);
            this.e = j;
            if (j == 0) {
                b();
            }
        }

        @Override // com.anythink.core.common.n.b.a.d.a.AbstractC0089a, com.anythink.core.common.n.c.w
        public final long a_(com.anythink.core.common.n.c.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.e;
            if (j2 == 0) {
                return -1L;
            }
            long jA_ = super.a_(cVar, Math.min(j2, j));
            if (jA_ == -1) {
                a.this.k.e();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b();
                throw protocolException;
            }
            long j3 = this.e - jA_;
            this.e = j3;
            if (j3 == 0) {
                b();
            }
            return jA_;
        }

        @Override // com.anythink.core.common.n.c.w, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.b) {
                return;
            }
            if (this.e != 0 && !com.anythink.core.common.n.b.a.c.a(this, TimeUnit.MILLISECONDS)) {
                a.this.k.e();
                b();
            }
            this.b = true;
        }
    }

    private class c extends AbstractC0089a {
        private static final long e = -1;
        private final com.anythink.core.common.n.b.v f;
        private long g;
        private boolean h;

        c(com.anythink.core.common.n.b.v vVar) {
            super(a.this, (byte) 0);
            this.g = -1L;
            this.h = true;
            this.f = vVar;
        }

        @Override // com.anythink.core.common.n.b.a.d.a.AbstractC0089a, com.anythink.core.common.n.c.w
        public final long a_(com.anythink.core.common.n.c.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (!this.h) {
                return -1L;
            }
            long j2 = this.g;
            if (j2 == 0 || j2 == -1) {
                if (j2 != -1) {
                    a.this.l.w();
                }
                try {
                    this.g = a.this.l.s();
                    String strTrim = a.this.l.w().trim();
                    if (this.g >= 0 && (strTrim.isEmpty() || strTrim.startsWith(";"))) {
                        if (this.g == 0) {
                            this.h = false;
                            a aVar = a.this;
                            aVar.p = aVar.h();
                            com.anythink.core.common.n.b.a.c.e.a(a.this.j.e(), this.f, a.this.p);
                            b();
                        }
                        if (!this.h) {
                            return -1L;
                        }
                    } else {
                        throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + strTrim + "\"");
                    }
                } catch (NumberFormatException e2) {
                    throw new ProtocolException(e2.getMessage());
                }
            }
            long jA_ = super.a_(cVar, Math.min(j, this.g));
            if (jA_ == -1) {
                a.this.k.e();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b();
                throw protocolException;
            }
            this.g -= jA_;
            return jA_;
        }

        private void c() throws ProtocolException {
            if (this.g != -1) {
                a.this.l.w();
            }
            try {
                this.g = a.this.l.s();
                String strTrim = a.this.l.w().trim();
                if (this.g < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + strTrim + "\"");
                }
                if (this.g == 0) {
                    this.h = false;
                    a aVar = a.this;
                    aVar.p = aVar.h();
                    com.anythink.core.common.n.b.a.c.e.a(a.this.j.e(), this.f, a.this.p);
                    b();
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // com.anythink.core.common.n.c.w, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.b) {
                return;
            }
            if (this.h && !com.anythink.core.common.n.b.a.c.a(this, TimeUnit.MILLISECONDS)) {
                a.this.k.e();
                b();
            }
            this.b = true;
        }
    }

    private class f extends AbstractC0089a {
        private boolean e;

        private f() {
            super(a.this, (byte) 0);
        }

        /* synthetic */ f(a aVar, byte b) {
            this();
        }

        @Override // com.anythink.core.common.n.b.a.d.a.AbstractC0089a, com.anythink.core.common.n.c.w
        public final long a_(com.anythink.core.common.n.c.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (this.e) {
                return -1L;
            }
            long jA_ = super.a_(cVar, j);
            if (jA_ != -1) {
                return jA_;
            }
            this.e = true;
            b();
            return -1L;
        }

        @Override // com.anythink.core.common.n.c.w, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.b) {
                return;
            }
            if (!this.e) {
                b();
            }
            this.b = true;
        }
    }

    static /* synthetic */ void a(j jVar) {
        x xVarA = jVar.a();
        jVar.a(x.c);
        xVarA.f();
        xVarA.h_();
    }
}
