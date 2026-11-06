package com.anythink.core.common.m.b;

import android.os.Build;
import com.kwad.sdk.api.loader.ApiSpUtils;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class z implements aj.a, e.a, Cloneable {
    static final List<ab> a = com.anythink.core.common.m.b.a.c.a(ab.HTTP_2, ab.HTTP_1_1);
    static final List<l> b = com.anythink.core.common.m.b.a.c.a(l.b, l.d);
    final int A;
    final int B;
    final int C;
    final int D;
    final p c;
    final Proxy d;
    final List<ab> e;
    final List<l> f;
    final List<w> g;
    final List<w> h;
    final r.a i;
    final ProxySelector j;
    final n k;
    final c l;
    final com.anythink.core.common.m.b.a.a.f m;
    final SocketFactory n;
    final SSLSocketFactory o;
    final com.anythink.core.common.m.b.a.j.c p;
    final HostnameVerifier q;
    final g r;
    final b s;
    final b t;
    final k u;
    final q v;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    static {
        com.anythink.core.common.m.b.a.a.a = new com.anythink.core.common.m.b.a.a() { // from class: com.anythink.core.common.m.b.z.1
            @Override // com.anythink.core.common.m.b.a.a
            public final void a(u.a aVar, String str) {
                aVar.a(str);
            }

            @Override // com.anythink.core.common.m.b.a.a
            public final void a(u.a aVar, String str, String str2) {
                aVar.c(str, str2);
            }

            @Override // com.anythink.core.common.m.b.a.a
            public final com.anythink.core.common.m.b.a.b.f a(k kVar) {
                return kVar.a;
            }

            @Override // com.anythink.core.common.m.b.a.a
            public final boolean a(com.anythink.core.common.m.b.a aVar, com.anythink.core.common.m.b.a aVar2) {
                return aVar.a(aVar2);
            }

            @Override // com.anythink.core.common.m.b.a.a
            public final int a(af.a aVar) {
                return aVar.c;
            }

            @Override // com.anythink.core.common.m.b.a.a
            public final e a(z zVar, ad adVar) {
                return ac.a(zVar, adVar, true);
            }

            @Override // com.anythink.core.common.m.b.a.a
            public final com.anythink.core.common.m.b.a.b.c a(af afVar) {
                return afVar.m;
            }

            @Override // com.anythink.core.common.m.b.a.a
            public final void a(l lVar, SSLSocket sSLSocket, boolean z) {
                String[] enabledCipherSuites;
                String[] enabledProtocols;
                if (lVar.g != null) {
                    enabledCipherSuites = com.anythink.core.common.m.b.a.c.a(i.a, sSLSocket.getEnabledCipherSuites(), lVar.g);
                } else {
                    enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
                }
                if (lVar.h != null) {
                    enabledProtocols = com.anythink.core.common.m.b.a.c.a(com.anythink.core.common.m.b.a.c.g, sSLSocket.getEnabledProtocols(), lVar.h);
                } else {
                    enabledProtocols = sSLSocket.getEnabledProtocols();
                }
                String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
                int iA = com.anythink.core.common.m.b.a.c.a(i.a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
                if (z && iA != -1) {
                    enabledCipherSuites = com.anythink.core.common.m.b.a.c.a(enabledCipherSuites, supportedCipherSuites[iA]);
                }
                l lVarB = new l.a(lVar).a(enabledCipherSuites).b(enabledProtocols).b();
                if (lVarB.h != null) {
                    sSLSocket.setEnabledProtocols(lVarB.h);
                }
                if (lVarB.g != null) {
                    sSLSocket.setEnabledCipherSuites(lVarB.g);
                }
            }

            @Override // com.anythink.core.common.m.b.a.a
            public final void a(af.a aVar, com.anythink.core.common.m.b.a.b.c cVar) {
                aVar.m = cVar;
            }
        };
    }

    public z() {
        this(new a());
    }

    z(a aVar) {
        boolean z;
        this.c = aVar.a;
        this.d = aVar.b;
        this.e = aVar.c;
        List<l> list = aVar.d;
        this.f = list;
        this.g = com.anythink.core.common.m.b.a.c.a(aVar.e);
        this.h = com.anythink.core.common.m.b.a.c.a(aVar.f);
        this.i = aVar.g;
        this.j = aVar.h;
        this.k = aVar.i;
        this.l = aVar.j;
        this.m = aVar.k;
        this.n = aVar.l;
        Iterator<l> it = list.iterator();
        loop0: while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else {
                    z = (z || it.next().e) ? true : z;
                }
            }
        }
        if (aVar.m != null || !z) {
            this.o = aVar.m;
            this.p = aVar.n;
        } else {
            X509TrustManager x509TrustManagerA = com.anythink.core.common.m.b.a.c.a();
            this.o = a(x509TrustManagerA);
            this.p = com.anythink.core.common.m.b.a.g.c.e().a(x509TrustManagerA);
        }
        if (this.o != null) {
            com.anythink.core.common.m.b.a.g.c.e();
        }
        this.q = aVar.o;
        this.r = aVar.p.a(this.p);
        this.s = aVar.q;
        this.t = aVar.r;
        this.u = aVar.s;
        this.v = aVar.t;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
        this.D = aVar.B;
        if (this.g.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.g);
        }
        if (this.h.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.h);
        }
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContextC = com.anythink.core.common.m.b.a.g.c.e().c();
            sSLContextC.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContextC.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS", e);
        }
    }

    public final int a() {
        return this.z;
    }

    private int u() {
        return this.A;
    }

    private int v() {
        return this.B;
    }

    private int w() {
        return this.C;
    }

    public final int b() {
        return this.D;
    }

    public final Proxy c() {
        return this.d;
    }

    public final ProxySelector d() {
        return this.j;
    }

    public final n e() {
        return this.k;
    }

    private c x() {
        return this.l;
    }

    private com.anythink.core.common.m.b.a.a.f y() {
        c cVar = this.l;
        return cVar != null ? cVar.a : this.m;
    }

    public final q f() {
        return this.v;
    }

    public final SocketFactory g() {
        return this.n;
    }

    public final SSLSocketFactory h() {
        return this.o;
    }

    public final HostnameVerifier i() {
        return this.q;
    }

    public final g j() {
        return this.r;
    }

    public final b k() {
        return this.t;
    }

    public final b l() {
        return this.s;
    }

    public final k m() {
        return this.u;
    }

    public final boolean n() {
        return this.w;
    }

    public final boolean o() {
        return this.x;
    }

    public final boolean p() {
        return this.y;
    }

    private p z() {
        return this.c;
    }

    public final List<ab> q() {
        return this.e;
    }

    public final List<l> r() {
        return this.f;
    }

    private List<w> A() {
        return this.g;
    }

    private List<w> B() {
        return this.h;
    }

    public final r.a s() {
        return this.i;
    }

    @Override // com.anythink.core.common.m.b.e.a
    public final e a(ad adVar) {
        return ac.a(this, adVar, false);
    }

    @Override // com.anythink.core.common.m.b.aj.a
    public final aj a(ad adVar, ak akVar) {
        com.anythink.core.common.m.b.a.k.a aVar = new com.anythink.core.common.m.b.a.k.a(adVar, akVar, new Random(), this.D);
        aVar.a(this);
        return aVar;
    }

    public final a t() {
        return new a(this);
    }

    public static final class a {
        int A;
        int B;
        p a;
        Proxy b;
        List<ab> c;
        List<l> d;
        final List<w> e;
        final List<w> f;
        r.a g;
        ProxySelector h;
        n i;
        c j;
        com.anythink.core.common.m.b.a.a.f k;
        SocketFactory l;
        SSLSocketFactory m;
        com.anythink.core.common.m.b.a.j.c n;
        HostnameVerifier o;
        g p;
        b q;
        b r;
        k s;
        q t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.a = new p();
            this.c = z.a;
            this.d = z.b;
            this.g = r.a(r.b);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.h = proxySelector;
            if (proxySelector == null) {
                this.h = new com.anythink.core.common.m.b.a.h.a();
            }
            this.i = n.a;
            this.l = SocketFactory.getDefault();
            this.o = com.anythink.core.common.m.b.a.j.e.a;
            this.p = g.a;
            this.q = b.a;
            this.r = b.a;
            this.s = new k();
            this.t = q.b;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        a(z zVar) {
            ArrayList arrayList = new ArrayList();
            this.e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f = arrayList2;
            this.a = zVar.c;
            this.b = zVar.d;
            this.c = zVar.e;
            this.d = zVar.f;
            arrayList.addAll(zVar.g);
            arrayList2.addAll(zVar.h);
            this.g = zVar.i;
            this.h = zVar.j;
            this.i = zVar.k;
            this.k = zVar.m;
            this.j = zVar.l;
            this.l = zVar.n;
            this.m = zVar.o;
            this.n = zVar.p;
            this.o = zVar.q;
            this.p = zVar.r;
            this.q = zVar.s;
            this.r = zVar.t;
            this.s = zVar.u;
            this.t = zVar.v;
            this.u = zVar.w;
            this.v = zVar.x;
            this.w = zVar.y;
            this.x = zVar.z;
            this.y = zVar.A;
            this.z = zVar.B;
            this.A = zVar.C;
            this.B = zVar.D;
        }

        public final a a(TimeUnit timeUnit) {
            this.x = com.anythink.core.common.m.b.a.c.a("timeout", 4L, timeUnit);
            return this;
        }

        private a a(Duration duration) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.x = com.anythink.core.common.m.b.a.c.a("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            }
            return this;
        }

        public final a a(long j, TimeUnit timeUnit) {
            this.y = com.anythink.core.common.m.b.a.c.a("timeout", j, timeUnit);
            return this;
        }

        private a b(Duration duration) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.y = com.anythink.core.common.m.b.a.c.a("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            }
            return this;
        }

        public final a b(long j, TimeUnit timeUnit) {
            this.z = com.anythink.core.common.m.b.a.c.a("timeout", j, timeUnit);
            return this;
        }

        private a c(Duration duration) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.z = com.anythink.core.common.m.b.a.c.a("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            }
            return this;
        }

        public final a c(long j, TimeUnit timeUnit) {
            this.A = com.anythink.core.common.m.b.a.c.a("timeout", j, timeUnit);
            return this;
        }

        private a d(Duration duration) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.A = com.anythink.core.common.m.b.a.c.a("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            }
            return this;
        }

        private a d(long j, TimeUnit timeUnit) {
            this.B = com.anythink.core.common.m.b.a.c.a(ApiSpUtils.SP_INTERVAL, j, timeUnit);
            return this;
        }

        private a e(Duration duration) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.B = com.anythink.core.common.m.b.a.c.a("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            }
            return this;
        }

        private a a(Proxy proxy) {
            this.b = proxy;
            return this;
        }

        private a a(ProxySelector proxySelector) {
            if (proxySelector == null) {
                throw new NullPointerException("proxySelector == null");
            }
            this.h = proxySelector;
            return this;
        }

        private a a(n nVar) {
            if (nVar == null) {
                throw new NullPointerException("cookieJar == null");
            }
            this.i = nVar;
            return this;
        }

        private a a(c cVar) {
            this.j = cVar;
            this.k = null;
            return this;
        }

        public final a a(q qVar) {
            if (qVar == null) {
                throw new NullPointerException("dns == null");
            }
            this.t = qVar;
            return this;
        }

        private a a(SocketFactory socketFactory) {
            if (socketFactory == null) {
                throw new NullPointerException("socketFactory == null");
            }
            if (socketFactory instanceof SSLSocketFactory) {
                throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory");
            }
            this.l = socketFactory;
            return this;
        }

        private a a(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            this.m = sSLSocketFactory;
            this.n = com.anythink.core.common.m.b.a.g.c.e().b(sSLSocketFactory);
            return this;
        }

        private a a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new NullPointerException("trustManager == null");
            }
            this.m = sSLSocketFactory;
            this.n = com.anythink.core.common.m.b.a.g.c.e().a(x509TrustManager);
            return this;
        }

        private a a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.o = hostnameVerifier;
            return this;
        }

        private a a(g gVar) {
            if (gVar == null) {
                throw new NullPointerException("certificatePinner == null");
            }
            this.p = gVar;
            return this;
        }

        private a a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("authenticator == null");
            }
            this.r = bVar;
            return this;
        }

        private a b(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("proxyAuthenticator == null");
            }
            this.q = bVar;
            return this;
        }

        public final a a(k kVar) {
            if (kVar == null) {
                throw new NullPointerException("connectionPool == null");
            }
            this.s = kVar;
            return this;
        }

        private a a(boolean z) {
            this.u = z;
            return this;
        }

        private a b(boolean z) {
            this.v = z;
            return this;
        }

        private a c(boolean z) {
            this.w = z;
            return this;
        }

        public final a a(p pVar) {
            this.a = pVar;
            return this;
        }

        public final a a(List<ab> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(ab.H2_PRIOR_KNOWLEDGE) && !arrayList.contains(ab.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: ".concat(String.valueOf(arrayList)));
            }
            if (arrayList.contains(ab.H2_PRIOR_KNOWLEDGE) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: ".concat(String.valueOf(arrayList)));
            }
            if (arrayList.contains(ab.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: ".concat(String.valueOf(arrayList)));
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(ab.SPDY_3);
            this.c = Collections.unmodifiableList(arrayList);
            return this;
        }

        private a b(List<l> list) {
            this.d = com.anythink.core.common.m.b.a.c.a(list);
            return this;
        }

        private List<w> b() {
            return this.e;
        }

        private a a(w wVar) {
            if (wVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.e.add(wVar);
            return this;
        }

        private List<w> c() {
            return this.f;
        }

        private a b(w wVar) {
            if (wVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f.add(wVar);
            return this;
        }

        public final a a(r rVar) {
            if (rVar == null) {
                throw new NullPointerException("eventListener == null");
            }
            this.g = r.a(rVar);
            return this;
        }

        private a a(r.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("eventListenerFactory == null");
            }
            this.g = aVar;
            return this;
        }

        public final z a() {
            return new z(this);
        }
    }
}
