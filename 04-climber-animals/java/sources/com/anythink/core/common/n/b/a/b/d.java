package com.anythink.core.common.n.b.a.b;

import com.anythink.core.common.n.b.ah;
import com.anythink.core.common.n.b.r;
import com.anythink.core.common.n.b.w;
import com.anythink.core.common.n.b.z;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class d {
    static final /* synthetic */ boolean a = true;
    private final j b;
    private final com.anythink.core.common.n.b.a c;
    private final f d;
    private final com.anythink.core.common.n.b.e e;
    private final r f;
    private i.a g;
    private final i h;
    private e i;
    private boolean j;
    private ah k;

    d(j jVar, f fVar, com.anythink.core.common.n.b.a aVar, com.anythink.core.common.n.b.e eVar, r rVar) {
        this.b = jVar;
        this.d = fVar;
        this.c = aVar;
        this.e = eVar;
        this.f = rVar;
        this.h = new i(aVar, fVar.a, eVar, rVar);
    }

    public final com.anythink.core.common.n.b.a.c.c a(z zVar, w.a aVar, boolean z) {
        try {
            return a(aVar.d(), aVar.e(), aVar.f(), zVar.b(), zVar.p(), z).a(zVar, aVar);
        } catch (h e) {
            b();
            throw e;
        } catch (IOException e2) {
            b();
            throw new h(e2);
        }
    }

    private e a(int i, int i2, int i3, int i4, boolean z, boolean z2) throws Throwable {
        while (true) {
            e eVarA = a(i, i2, i3, i4, z);
            synchronized (this.d) {
                if (eVarA.d == 0 && !eVarA.g()) {
                    return eVarA;
                }
                if (eVarA.a(z2)) {
                    return eVarA;
                }
                eVarA.e();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005f  */
    private e a(int i, int i2, int i3, int i4, boolean z) throws Throwable {
        Socket socketB;
        Socket socketE;
        e eVar;
        boolean z2;
        ah ahVarB;
        boolean z3;
        List<ah> listC;
        i.a aVar;
        synchronized (this.d) {
            if (this.b.j()) {
                throw new IOException("Canceled");
            }
            this.j = false;
            socketB = null;
            socketE = (this.b.a == null || !this.b.a.b) ? null : this.b.e();
            eVar = this.b.a != null ? this.b.a : null;
            if (eVar != null) {
                z2 = false;
                ahVarB = null;
            } else if (this.d.a(this.c, this.b, null, false)) {
                eVar = this.b.a;
                ahVarB = null;
                z2 = true;
            } else {
                ahVarB = this.k;
                if (ahVarB != null) {
                    this.k = null;
                } else if (e()) {
                    ahVarB = this.b.a.a();
                } else {
                    z2 = false;
                    ahVarB = null;
                }
                z2 = false;
            }
        }
        com.anythink.core.common.n.b.a.c.a(socketE);
        if (eVar != null) {
            return eVar;
        }
        if (ahVarB != null || ((aVar = this.g) != null && aVar.a())) {
            z3 = false;
        } else {
            this.g = this.h.b();
            z3 = true;
        }
        synchronized (this.d) {
            if (this.b.j()) {
                throw new IOException("Canceled");
            }
            if (z3) {
                listC = this.g.c();
                if (this.d.a(this.c, this.b, listC, false)) {
                    eVar = this.b.a;
                    z2 = true;
                }
            } else {
                listC = null;
            }
            if (!z2) {
                if (ahVarB == null) {
                    ahVarB = this.g.b();
                }
                eVar = new e(this.d, ahVarB);
                this.i = eVar;
            }
        }
        if (z2) {
            return eVar;
        }
        eVar.a(i, i2, i3, i4, z);
        this.d.a.b(eVar.a());
        synchronized (this.d) {
            this.i = null;
            if (this.d.a(this.c, this.b, listC, true)) {
                eVar.b = true;
                socketB = eVar.b();
                eVar = this.b.a;
                this.k = ahVarB;
            } else {
                this.d.a(eVar);
                this.b.a(eVar);
            }
        }
        com.anythink.core.common.n.b.a.c.a(socketB);
        return eVar;
    }

    final e a() {
        if (a || Thread.holdsLock(this.d)) {
            return this.i;
        }
        throw new AssertionError();
    }

    final void b() {
        if (!a && Thread.holdsLock(this.d)) {
            throw new AssertionError();
        }
        synchronized (this.d) {
            this.j = true;
        }
    }

    final boolean c() {
        boolean z;
        synchronized (this.d) {
            z = this.j;
        }
        return z;
    }

    final boolean d() {
        synchronized (this.d) {
            boolean z = true;
            if (this.k != null) {
                return true;
            }
            if (e()) {
                this.k = this.b.a.a();
                return true;
            }
            i.a aVar = this.g;
            if ((aVar == null || !aVar.a()) && !this.h.a()) {
                z = false;
            }
            return z;
        }
    }

    private boolean e() {
        return this.b.a != null && this.b.a.c == 0 && com.anythink.core.common.n.b.a.c.a(this.b.a.a().a().a(), this.c.a());
    }
}
