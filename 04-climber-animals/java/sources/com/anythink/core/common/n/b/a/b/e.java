package com.anythink.core.common.n.b.a.b;

import com.anythink.core.common.n.b.aa;
import com.anythink.core.common.n.b.ab;
import com.anythink.core.common.n.b.ad;
import com.anythink.core.common.n.b.ae;
import com.anythink.core.common.n.b.af;
import com.anythink.core.common.n.b.ah;
import com.anythink.core.common.n.b.l;
import com.anythink.core.common.n.b.t;
import com.anythink.core.common.n.b.v;
import com.anythink.core.common.n.b.w;
import com.anythink.core.common.n.b.z;
import com.anythink.core.common.n.c.n;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class e extends com.anythink.core.common.n.b.a.e.f.c implements com.anythink.core.common.n.b.j {
    static final /* synthetic */ boolean g = true;
    private static final String i = "throw with null exception";
    private static final int j = 21;
    public final f a;
    boolean b;
    int c;
    int d;
    private final ah k;
    private Socket l;
    private Socket m;
    private t n;
    private ab o;
    private com.anythink.core.common.n.b.a.e.f p;
    private com.anythink.core.common.n.c.e q;
    private com.anythink.core.common.n.c.d r;
    private int s;
    private int t = 1;
    final List<Reference<j>> e = new ArrayList();
    long f = Long.MAX_VALUE;

    public e(f fVar, ah ahVar) {
        this.a = fVar;
        this.k = ahVar;
    }

    public final void e() {
        if (!g && Thread.holdsLock(this.a)) {
            throw new AssertionError();
        }
        synchronized (this.a) {
            this.b = true;
        }
    }

    private static e a(f fVar, ah ahVar, Socket socket, long j2) {
        e eVar = new e(fVar, ahVar);
        eVar.m = socket;
        eVar.f = j2;
        return eVar;
    }

    public final void a(int i2, int i3, int i4, int i5, boolean z) throws Throwable {
        if (this.o != null) {
            throw new IllegalStateException("already connected");
        }
        List<l> listF = this.k.a().f();
        b bVar = new b(listF);
        if (this.k.a().i() == null) {
            if (!listF.contains(l.d)) {
                throw new h(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strF = this.k.a().a().f();
            if (!com.anythink.core.common.n.b.a.g.c.e().b(strF)) {
                throw new h(new UnknownServiceException("CLEARTEXT communication to " + strF + " not permitted by network security policy"));
            }
        } else if (this.k.a().e().contains(ab.H2_PRIOR_KNOWLEDGE)) {
            throw new h(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        h hVar = null;
        while (true) {
            try {
                if (this.k.d()) {
                    a(i2, i3, i4);
                    if (this.l != null) {
                        break;
                    } else {
                        break;
                    }
                }
                a(i2, i3);
                if (this.k.a().i() == null) {
                    if (this.k.a().e().contains(ab.H2_PRIOR_KNOWLEDGE)) {
                        this.m = this.l;
                        this.o = ab.H2_PRIOR_KNOWLEDGE;
                        a(i5);
                    } else {
                        this.m = this.l;
                        this.o = ab.HTTP_1_1;
                    }
                } else {
                    a(bVar);
                    if (this.o == ab.HTTP_2) {
                        a(i5);
                    }
                }
                this.k.c();
                this.k.b();
                break;
            } catch (IOException e) {
                com.anythink.core.common.n.b.a.c.a(this.m);
                com.anythink.core.common.n.b.a.c.a(this.l);
                this.m = null;
                this.l = null;
                this.q = null;
                this.r = null;
                this.n = null;
                this.o = null;
                this.p = null;
                this.k.c();
                this.k.b();
                if (hVar == null) {
                    hVar = new h(e);
                } else {
                    hVar.a(e);
                }
                if (z) {
                    if (!bVar.a(e)) {
                        throw hVar;
                    }
                } else {
                    throw hVar;
                }
            }
        }
        if (this.k.d() && this.l == null) {
            throw new h(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        if (this.p != null) {
            synchronized (this.a) {
                this.t = this.p.a();
            }
        }
    }

    private void a(int i2, int i3) throws IOException {
        Socket socketCreateSocket;
        Proxy proxyB = this.k.b();
        com.anythink.core.common.n.b.a aVarA = this.k.a();
        if (proxyB.type() == Proxy.Type.DIRECT || proxyB.type() == Proxy.Type.HTTP) {
            socketCreateSocket = aVarA.c().createSocket();
        } else {
            socketCreateSocket = new Socket(proxyB);
        }
        this.l = socketCreateSocket;
        this.k.c();
        this.l.setSoTimeout(i3);
        try {
            com.anythink.core.common.n.b.a.g.c.e().a(this.l, this.k.c(), i2);
            try {
                this.q = n.a(n.b(this.l));
                this.r = n.a(n.a(this.l));
            } catch (NullPointerException e) {
                if (i.equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.k.c());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void a(b bVar, int i2) throws Throwable {
        if (this.k.a().i() == null) {
            if (this.k.a().e().contains(ab.H2_PRIOR_KNOWLEDGE)) {
                this.m = this.l;
                this.o = ab.H2_PRIOR_KNOWLEDGE;
                a(i2);
                return;
            } else {
                this.m = this.l;
                this.o = ab.HTTP_1_1;
                return;
            }
        }
        a(bVar);
        if (this.o == ab.HTTP_2) {
            a(i2);
        }
    }

    private void a(int i2) throws SocketException {
        this.m.setSoTimeout(0);
        com.anythink.core.common.n.b.a.e.f fVarA = new com.anythink.core.common.n.b.a.e.f.a().a(this.m, this.k.a().a().f(), this.q, this.r).a(this).a(i2).a();
        this.p = fVarA;
        fVarA.b();
    }

    private void a(b bVar) throws Throwable {
        ab abVarA;
        com.anythink.core.common.n.b.a aVarA = this.k.a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) aVarA.i().createSocket(this.l, aVarA.a().f(), aVarA.a().g(), true);
                try {
                    l lVarA = bVar.a(sSLSocket2);
                    if (lVarA.a()) {
                        com.anythink.core.common.n.b.a.g.c.e().a(sSLSocket2, aVarA.a().f(), aVarA.e());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    t tVarA = t.a(session);
                    if (!aVarA.j().verify(aVarA.a().f(), session)) {
                        List<Certificate> listC = tVarA.c();
                        if (!listC.isEmpty()) {
                            X509Certificate x509Certificate = (X509Certificate) listC.get(0);
                            throw new SSLPeerUnverifiedException("Hostname " + aVarA.a().f() + " not verified:\n    certificate: " + com.anythink.core.common.n.b.g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.anythink.core.common.n.b.a.j.e.a(x509Certificate));
                        }
                        throw new SSLPeerUnverifiedException("Hostname " + aVarA.a().f() + " not verified (no certificates)");
                    }
                    aVarA.k().a(aVarA.a().f(), tVarA.c());
                    String strA = lVarA.a() ? com.anythink.core.common.n.b.a.g.c.e().a(sSLSocket2) : null;
                    this.m = sSLSocket2;
                    this.q = n.a(n.b(sSLSocket2));
                    this.r = n.a(n.a(this.m));
                    this.n = tVarA;
                    if (strA != null) {
                        abVarA = ab.a(strA);
                    } else {
                        abVarA = ab.HTTP_1_1;
                    }
                    this.o = abVarA;
                    if (sSLSocket2 != null) {
                        com.anythink.core.common.n.b.a.g.c.e();
                    }
                } catch (AssertionError e) {
                    e = e;
                    if (!com.anythink.core.common.n.b.a.c.a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        com.anythink.core.common.n.b.a.g.c.e();
                    }
                    com.anythink.core.common.n.b.a.c.a((Socket) sSLSocket);
                    throw th;
                }
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private ad a(int i2, int i3, ad adVar, v vVar) throws IOException {
        String str = "CONNECT " + com.anythink.core.common.n.b.a.c.a(vVar, true) + " HTTP/1.1";
        while (true) {
            com.anythink.core.common.n.b.a.d.a aVar = new com.anythink.core.common.n.b.a.d.a(null, null, this.q, this.r);
            this.q.a().a(i2, TimeUnit.MILLISECONDS);
            this.r.a().a(i3, TimeUnit.MILLISECONDS);
            aVar.a(adVar.c(), str);
            aVar.c();
            af afVarA = aVar.a(false).a(adVar).a();
            aVar.c(afVarA);
            int iC = afVarA.c();
            if (iC == 200) {
                if (this.q.d().g() && this.r.c().g()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iC == 407) {
                ad adVarAuthenticate = this.k.a().d().authenticate(this.k, afVarA);
                if (adVarAuthenticate == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if (ILivePush.ClickType.CLOSE.equalsIgnoreCase(afVarA.a("Connection"))) {
                    return adVarAuthenticate;
                }
                adVar = adVarAuthenticate;
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + afVarA.c());
            }
        }
    }

    private ad h() {
        ad adVarB = new ad.a().a(this.k.a().a()).a("CONNECT", (ae) null).a("Host", com.anythink.core.common.n.b.a.c.a(this.k.a().a(), true)).a("Proxy-Connection", "Keep-Alive").b();
        ad adVarAuthenticate = this.k.a().d().authenticate(this.k, new af.a().a(adVarB).a(ab.HTTP_1_1).a(407).a("Preemptive Authenticate").a(com.anythink.core.common.n.b.a.c.d).a(-1L).b(-1L).a("Proxy-Authenticate", aa.a + "-Preemptive").a());
        return adVarAuthenticate != null ? adVarAuthenticate : adVarB;
    }

    final boolean a(com.anythink.core.common.n.b.a aVar, List<ah> list) {
        boolean z;
        if (this.e.size() >= this.t || this.b || !com.anythink.core.common.n.b.a.a.a.a(this.k.a(), aVar)) {
            return false;
        }
        if (aVar.a().f().equals(this.k.a().a().f())) {
            return true;
        }
        if (this.p != null && list != null) {
            int size = list.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z = false;
                    break;
                }
                ah ahVar = list.get(i2);
                if (ahVar.b().type() == Proxy.Type.DIRECT && this.k.b().type() == Proxy.Type.DIRECT && this.k.c().equals(ahVar.c())) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z || aVar.j() != com.anythink.core.common.n.b.a.j.e.a || !a(aVar.a())) {
                return false;
            }
            try {
                aVar.k().a(aVar.a().f(), this.n.c());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
            }
        }
        return false;
    }

    private boolean a(List<ah> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ah ahVar = list.get(i2);
            if (ahVar.b().type() == Proxy.Type.DIRECT && this.k.b().type() == Proxy.Type.DIRECT && this.k.c().equals(ahVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(v vVar) {
        if (vVar.g() != this.k.a().a().g()) {
            return false;
        }
        if (vVar.f().equals(this.k.a().a().f())) {
            return true;
        }
        if (this.n != null) {
            com.anythink.core.common.n.b.a.j.e eVar = com.anythink.core.common.n.b.a.j.e.a;
            if (com.anythink.core.common.n.b.a.j.e.a(vVar.f(), (X509Certificate) this.n.c().get(0))) {
                return true;
            }
        }
        return false;
    }

    final com.anythink.core.common.n.b.a.c.c a(z zVar, w.a aVar) throws SocketException {
        if (this.p != null) {
            return new com.anythink.core.common.n.b.a.e.g(zVar, this, aVar, this.p);
        }
        this.m.setSoTimeout(aVar.e());
        this.q.a().a(aVar.e(), TimeUnit.MILLISECONDS);
        this.r.a().a(aVar.f(), TimeUnit.MILLISECONDS);
        return new com.anythink.core.common.n.b.a.d.a(zVar, this, this.q, this.r);
    }

    final com.anythink.core.common.n.b.a.k.a.e a(final c cVar) throws SocketException {
        this.m.setSoTimeout(0);
        e();
        return new com.anythink.core.common.n.b.a.k.a.e(this.q, this.r) { // from class: com.anythink.core.common.n.b.a.b.e.1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                cVar.a(true, true, null);
            }
        };
    }

    @Override // com.anythink.core.common.n.b.j
    public final ah a() {
        return this.k;
    }

    public final void f() {
        com.anythink.core.common.n.b.a.c.a(this.l);
    }

    @Override // com.anythink.core.common.n.b.j
    public final Socket b() {
        return this.m;
    }

    public final boolean a(boolean z) {
        if (this.m.isClosed() || this.m.isInputShutdown() || this.m.isOutputShutdown()) {
            return false;
        }
        com.anythink.core.common.n.b.a.e.f fVar = this.p;
        if (fVar != null) {
            return fVar.b(System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.m.getSoTimeout();
                try {
                    this.m.setSoTimeout(1);
                    if (this.q.g()) {
                        this.m.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.m.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.m.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.anythink.core.common.n.b.a.e.f.c
    public final void a(com.anythink.core.common.n.b.a.e.i iVar) {
        iVar.a(com.anythink.core.common.n.b.a.e.b.REFUSED_STREAM, (IOException) null);
    }

    @Override // com.anythink.core.common.n.b.a.e.f.c
    public final void a(com.anythink.core.common.n.b.a.e.f fVar) {
        synchronized (this.a) {
            this.t = fVar.a();
        }
    }

    @Override // com.anythink.core.common.n.b.j
    public final t c() {
        return this.n;
    }

    public final boolean g() {
        return this.p != null;
    }

    final void a(IOException iOException) {
        if (!g && Thread.holdsLock(this.a)) {
            throw new AssertionError();
        }
        synchronized (this.a) {
            if (iOException instanceof com.anythink.core.common.n.b.a.e.n) {
                com.anythink.core.common.n.b.a.e.b bVar = ((com.anythink.core.common.n.b.a.e.n) iOException).a;
                if (bVar == com.anythink.core.common.n.b.a.e.b.REFUSED_STREAM) {
                    int i2 = this.s + 1;
                    this.s = i2;
                    if (i2 > 1) {
                        this.b = true;
                        this.c++;
                    }
                } else if (bVar != com.anythink.core.common.n.b.a.e.b.CANCEL) {
                    this.b = true;
                    this.c++;
                }
            } else if (!g() || (iOException instanceof com.anythink.core.common.n.b.a.e.a)) {
                this.b = true;
                if (this.d == 0) {
                    if (iOException != null) {
                        f fVar = this.a;
                        ah ahVar = this.k;
                        if (ahVar.b().type() != Proxy.Type.DIRECT) {
                            com.anythink.core.common.n.b.a aVarA = ahVar.a();
                            aVarA.g().connectFailed(aVarA.a().a(), ahVar.b().address(), iOException);
                        }
                        fVar.a.a(ahVar);
                    }
                    this.c++;
                }
            }
        }
    }

    @Override // com.anythink.core.common.n.b.j
    public final ab d() {
        return this.o;
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder("Connection{").append(this.k.a().a().f()).append(":").append(this.k.a().a().g()).append(", proxy=").append(this.k.b()).append(" hostAddress=").append(this.k.c()).append(" cipherSuite=");
        t tVar = this.n;
        return sbAppend.append(tVar != null ? tVar.b() : "none").append(" protocol=").append(this.o).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    private void a(int i2, int i3, int i4) throws IOException {
        ad adVarB = new ad.a().a(this.k.a().a()).a("CONNECT", (ae) null).a("Host", com.anythink.core.common.n.b.a.c.a(this.k.a().a(), true)).a("Proxy-Connection", "Keep-Alive").b();
        ad adVarAuthenticate = this.k.a().d().authenticate(this.k, new af.a().a(adVarB).a(ab.HTTP_1_1).a(407).a("Preemptive Authenticate").a(com.anythink.core.common.n.b.a.c.d).a(-1L).b(-1L).a("Proxy-Authenticate", aa.a + "-Preemptive").a());
        if (adVarAuthenticate != null) {
            adVarB = adVarAuthenticate;
        }
        v vVarA = adVarB.a();
        for (int i5 = 0; i5 < 21; i5++) {
            a(i2, i3);
            adVarB = a(i3, i4, adVarB, vVarA);
            if (adVarB == null) {
                return;
            }
            com.anythink.core.common.n.b.a.c.a(this.l);
            this.l = null;
            this.r = null;
            this.q = null;
            this.k.c();
            this.k.b();
        }
    }
}
