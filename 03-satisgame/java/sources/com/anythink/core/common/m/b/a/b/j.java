package com.anythink.core.common.m.b.a.b;

import com.anythink.core.common.m.b.ad;
import com.anythink.core.common.m.b.r;
import com.anythink.core.common.m.b.v;
import com.anythink.core.common.m.b.w;
import com.anythink.core.common.m.b.z;
import com.anythink.core.common.m.c.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    static final /* synthetic */ boolean b = true;
    public e a;
    private final z c;
    private final f d;
    private final com.anythink.core.common.m.b.e e;
    private final r f;
    private final com.anythink.core.common.m.c.a g;
    private Object h;
    private ad i;
    private d j;
    private c k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;

    public j(z zVar, com.anythink.core.common.m.b.e eVar) {
        com.anythink.core.common.m.c.a aVar = new com.anythink.core.common.m.c.a() { // from class: com.anythink.core.common.m.b.a.b.j.1
            @Override // com.anythink.core.common.m.c.a
            protected final void a() {
                j.this.i();
            }
        };
        this.g = aVar;
        this.c = zVar;
        this.d = com.anythink.core.common.m.b.a.a.a.a(zVar.m());
        this.e = eVar;
        this.f = zVar.s().a();
        aVar.a(zVar.a(), TimeUnit.MILLISECONDS);
    }

    public final x a() {
        return this.g;
    }

    public final void b() {
        this.g.c();
    }

    public final void c() {
        if (this.o) {
            throw new IllegalStateException();
        }
        this.o = true;
        this.g.d();
    }

    private IOException b(IOException iOException) {
        if (this.o || !this.g.d()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final void d() {
        this.h = com.anythink.core.common.m.b.a.g.c.e().a("response.body().close()");
    }

    public final void a(ad adVar) {
        SSLSocketFactory sSLSocketFactoryH;
        HostnameVerifier hostnameVerifierI;
        com.anythink.core.common.m.b.g gVarJ;
        ad adVar2 = this.i;
        if (adVar2 != null) {
            if (com.anythink.core.common.m.b.a.c.a(adVar2.a(), adVar.a()) && this.j.d()) {
                return;
            }
            if (this.k != null) {
                throw new IllegalStateException();
            }
            if (this.j != null) {
                a((IOException) null, true);
                this.j = null;
            }
        }
        this.i = adVar;
        f fVar = this.d;
        v vVarA = adVar.a();
        if (vVarA.c()) {
            sSLSocketFactoryH = this.c.h();
            hostnameVerifierI = this.c.i();
            gVarJ = this.c.j();
        } else {
            sSLSocketFactoryH = null;
            hostnameVerifierI = null;
            gVarJ = null;
        }
        this.j = new d(this, fVar, new com.anythink.core.common.m.b.a(vVarA.f(), vVarA.g(), this.c.f(), this.c.g(), sSLSocketFactoryH, hostnameVerifierI, gVarJ, this.c.l(), this.c.c(), this.c.q(), this.c.r(), this.c.d()), this.e, this.f);
    }

    private com.anythink.core.common.m.b.a a(v vVar) {
        SSLSocketFactory sSLSocketFactoryH;
        HostnameVerifier hostnameVerifierI;
        com.anythink.core.common.m.b.g gVarJ;
        if (vVar.c()) {
            sSLSocketFactoryH = this.c.h();
            hostnameVerifierI = this.c.i();
            gVarJ = this.c.j();
        } else {
            sSLSocketFactoryH = null;
            hostnameVerifierI = null;
            gVarJ = null;
        }
        return new com.anythink.core.common.m.b.a(vVar.f(), vVar.g(), this.c.f(), this.c.g(), sSLSocketFactoryH, hostnameVerifierI, gVarJ, this.c.l(), this.c.c(), this.c.q(), this.c.r(), this.c.d());
    }

    final c a(w.a aVar, boolean z) {
        synchronized (this.d) {
            if (this.p) {
                throw new IllegalStateException("released");
            }
            if (this.k != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        c cVar = new c(this, this.e, this.f, this.j, this.j.a(this.c, aVar, z));
        synchronized (this.d) {
            this.k = cVar;
            this.l = false;
            this.m = false;
        }
        return cVar;
    }

    final void a(e eVar) {
        if (!b && !Thread.holdsLock(this.d)) {
            throw new AssertionError();
        }
        if (this.a != null) {
            throw new IllegalStateException();
        }
        this.a = eVar;
        eVar.e.add(new a(this, this.h));
    }

    final Socket e() {
        if (!b && !Thread.holdsLock(this.d)) {
            throw new AssertionError();
        }
        int size = this.a.e.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            if (this.a.e.get(i).get() == this) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException();
        }
        e eVar = this.a;
        eVar.e.remove(i);
        this.a = null;
        if (eVar.e.isEmpty()) {
            eVar.f = System.nanoTime();
            if (this.d.b(eVar)) {
                return eVar.b();
            }
        }
        return null;
    }

    public final void f() {
        synchronized (this.d) {
            if (this.p) {
                throw new IllegalStateException();
            }
            this.k = null;
        }
    }

    final IOException a(c cVar, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        synchronized (this.d) {
            c cVar2 = this.k;
            if (cVar != cVar2) {
                return iOException;
            }
            boolean z4 = true;
            if (z) {
                z3 = !this.l;
                this.l = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (!this.m) {
                    z3 = true;
                }
                this.m = true;
            }
            if (this.l && this.m && z3) {
                cVar2.a().d++;
                this.k = null;
            } else {
                z4 = false;
            }
            return z4 ? a(iOException, false) : iOException;
        }
    }

    public final IOException a(IOException iOException) {
        synchronized (this.d) {
            this.p = true;
        }
        return a(iOException, false);
    }

    private IOException a(IOException iOException, boolean z) {
        Socket socketE;
        boolean z2;
        synchronized (this.d) {
            if (z) {
                if (this.k != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            socketE = (this.a != null && this.k == null && (z || this.p)) ? e() : null;
            z2 = this.p && this.k == null;
        }
        com.anythink.core.common.m.b.a.c.a(socketE);
        if (!z2 || this.o || !this.g.d()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final boolean g() {
        return this.j.c() && this.j.d();
    }

    public final boolean h() {
        boolean z;
        synchronized (this.d) {
            z = this.k != null;
        }
        return z;
    }

    public final void i() {
        c cVar;
        e eVarA;
        synchronized (this.d) {
            this.n = true;
            cVar = this.k;
            d dVar = this.j;
            if (dVar != null && dVar.a() != null) {
                eVarA = this.j.a();
            } else {
                eVarA = this.a;
            }
        }
        if (cVar != null) {
            cVar.e.e();
        } else if (eVarA != null) {
            eVarA.f();
        }
    }

    public final boolean j() {
        boolean z;
        synchronized (this.d) {
            z = this.n;
        }
        return z;
    }

    static final class a extends WeakReference<j> {
        final Object a;

        a(j jVar, Object obj) {
            super(jVar);
            this.a = obj;
        }
    }
}
