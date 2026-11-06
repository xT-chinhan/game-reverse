package com.anythink.core.common.n.b;

import java.io.Closeable;
import java.io.EOFException;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class af implements Closeable {
    final ad a;
    final ab b;
    final int c;
    final String d;
    final t e;
    final u f;
    final ag g;
    final af h;
    final af i;
    final af j;
    final long k;
    final long l;
    final com.anythink.core.common.n.b.a.b.c m;
    private volatile d n;

    af(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
    }

    public final ad a() {
        return this.a;
    }

    public final ab b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    private boolean n() {
        int i = this.c;
        return i >= 200 && i < 300;
    }

    public final String d() {
        return this.d;
    }

    public final t e() {
        return this.e;
    }

    private List<String> b(String str) {
        return this.f.b(str);
    }

    private String a(String str, String str2) {
        String strA = this.f.a(str);
        return strA != null ? strA : str2;
    }

    public final u f() {
        return this.f;
    }

    private u o() {
        com.anythink.core.common.n.b.a.b.c cVar = this.m;
        if (cVar == null) {
            throw new IllegalStateException("trailers not available");
        }
        return cVar.e();
    }

    private ag a(long j) throws EOFException {
        com.anythink.core.common.n.c.e eVarH = this.g.c().h();
        com.anythink.core.common.n.c.c cVar = new com.anythink.core.common.n.c.c();
        eVarH.b(j);
        cVar.a(eVarH, Math.min(j, eVarH.d().b()));
        return ag.a(this.g.a(), cVar.b(), cVar);
    }

    public final ag g() {
        return this.g;
    }

    public final a h() {
        return new a(this);
    }

    private boolean p() {
        int i = this.c;
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public final af i() {
        return this.h;
    }

    private af q() {
        return this.i;
    }

    public final af j() {
        return this.j;
    }

    private List<h> r() {
        String str;
        int i = this.c;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                return Collections.emptyList();
            }
            str = "Proxy-Authenticate";
        }
        return com.anythink.core.common.n.b.a.c.e.a(this.f, str);
    }

    public final d k() {
        d dVar = this.n;
        if (dVar != null) {
            return dVar;
        }
        d dVarA = d.a(this.f);
        this.n = dVarA;
        return dVarA;
    }

    public final long l() {
        return this.k;
    }

    public final long m() {
        return this.l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ag agVar = this.g;
        if (agVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        agVar.close();
    }

    public final String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.a + AbstractJsonLexerKt.END_OBJ;
    }

    public static class a {
        ad a;
        ab b;
        int c;
        String d;
        t e;
        u.a f;
        ag g;
        af h;
        af i;
        af j;
        long k;
        long l;
        com.anythink.core.common.n.b.a.b.c m;

        public a() {
            this.c = -1;
            this.f = new u.a();
        }

        a(af afVar) {
            this.c = -1;
            this.a = afVar.a;
            this.b = afVar.b;
            this.c = afVar.c;
            this.d = afVar.d;
            this.e = afVar.e;
            this.f = afVar.f.b();
            this.g = afVar.g;
            this.h = afVar.h;
            this.i = afVar.i;
            this.j = afVar.j;
            this.k = afVar.k;
            this.l = afVar.l;
            this.m = afVar.m;
        }

        public final a a(ad adVar) {
            this.a = adVar;
            return this;
        }

        public final a a(ab abVar) {
            this.b = abVar;
            return this;
        }

        public final a a(int i) {
            this.c = i;
            return this;
        }

        public final a a(String str) {
            this.d = str;
            return this;
        }

        public final a a(t tVar) {
            this.e = tVar;
            return this;
        }

        public final a a(String str, String str2) {
            this.f.d(str, str2);
            return this;
        }

        public final a b(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        private a b(String str) {
            this.f.b(str);
            return this;
        }

        public final a a(u uVar) {
            this.f = uVar.b();
            return this;
        }

        public final a a(ag agVar) {
            this.g = agVar;
            return this;
        }

        public final a a(af afVar) {
            if (afVar != null) {
                a("networkResponse", afVar);
            }
            this.h = afVar;
            return this;
        }

        public final a b(af afVar) {
            if (afVar != null) {
                a("cacheResponse", afVar);
            }
            this.i = afVar;
            return this;
        }

        private static void a(String str, af afVar) {
            if (afVar.g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (afVar.h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (afVar.i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (afVar.j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        private static void d(af afVar) {
            if (afVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public final a a(long j) {
            this.k = j;
            return this;
        }

        public final a b(long j) {
            this.l = j;
            return this;
        }

        private void a(com.anythink.core.common.n.b.a.b.c cVar) {
            this.m = cVar;
        }

        public final af a() {
            if (this.a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.c < 0) {
                throw new IllegalStateException("code < 0: " + this.c);
            }
            if (this.d == null) {
                throw new IllegalStateException("message == null");
            }
            return new af(this);
        }

        public final a c(af afVar) {
            if (afVar == null || afVar.g == null) {
                this.j = afVar;
                return this;
            }
            throw new IllegalArgumentException("priorResponse.body != null");
        }
    }

    public final String a(String str) {
        String strA = this.f.a(str);
        if (strA != null) {
            return strA;
        }
        return null;
    }
}
