package com.anythink.core.common.n.b.a.a;

import com.anythink.core.common.n.b.a.c.h;
import com.anythink.core.common.n.b.ab;
import com.anythink.core.common.n.b.ad;
import com.anythink.core.common.n.b.af;
import com.anythink.core.common.n.b.ag;
import com.anythink.core.common.n.b.u;
import com.anythink.core.common.n.b.w;
import com.anythink.core.common.n.c.n;
import com.anythink.core.common.n.c.v;
import com.anythink.core.common.n.c.x;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class a implements w {
    final f a;

    public a(f fVar) {
        this.a = fVar;
    }

    @Override // com.anythink.core.common.n.b.w
    public final af a(w.a aVar) {
        v vVarB;
        f fVar = this.a;
        af afVarA = fVar != null ? fVar.a(aVar.a()) : null;
        c cVarA = new c.a(System.currentTimeMillis(), aVar.a(), afVarA).a();
        ad adVar = cVarA.a;
        af afVar = cVarA.b;
        f fVar2 = this.a;
        if (fVar2 != null) {
            fVar2.a(cVarA);
        }
        if (afVarA != null && afVar == null) {
            com.anythink.core.common.n.b.a.c.a(afVarA.g());
        }
        if (adVar == null && afVar == null) {
            return new af.a().a(aVar.a()).a(ab.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(com.anythink.core.common.n.b.a.c.d).a(-1L).b(System.currentTimeMillis()).a();
        }
        if (adVar == null) {
            return afVar.h().b(a(afVar)).a();
        }
        try {
            af afVarA2 = aVar.a(adVar);
            if (afVarA2 == null && afVarA != null) {
                com.anythink.core.common.n.b.a.c.a(afVarA.g());
            }
            if (afVar != null) {
                if (afVarA2.c() == 304) {
                    af.a aVarH = afVar.h();
                    u uVarF = afVar.f();
                    u uVarF2 = afVarA2.f();
                    u.a aVar2 = new u.a();
                    int iA = uVarF.a();
                    for (int i = 0; i < iA; i++) {
                        String strA = uVarF.a(i);
                        String strB = uVarF.b(i);
                        if ((!"Warning".equalsIgnoreCase(strA) || !strB.startsWith("1")) && (b(strA) || !a(strA) || uVarF2.a(strA) == null)) {
                            com.anythink.core.common.n.b.a.a.a.a(aVar2, strA, strB);
                        }
                    }
                    int iA2 = uVarF2.a();
                    for (int i2 = 0; i2 < iA2; i2++) {
                        String strA2 = uVarF2.a(i2);
                        if (!b(strA2) && a(strA2)) {
                            com.anythink.core.common.n.b.a.a.a.a(aVar2, strA2, uVarF2.b(i2));
                        }
                    }
                    af afVarA3 = aVarH.a(aVar2.a()).a(afVarA2.l()).b(afVarA2.m()).b(a(afVar)).a(a(afVarA2)).a();
                    afVarA2.g().close();
                    this.a.a();
                    this.a.a(afVar, afVarA3);
                    return afVarA3;
                }
                com.anythink.core.common.n.b.a.c.a(afVar.g());
            }
            af afVarA4 = afVarA2.h().b(a(afVar)).a(a(afVarA2)).a();
            if (this.a != null) {
                if (com.anythink.core.common.n.b.a.c.e.d(afVarA4) && c.a(afVarA4, adVar)) {
                    b bVarA = this.a.a(afVarA4);
                    if (bVarA == null || (vVarB = bVarA.b()) == null) {
                        return afVarA4;
                    }
                    return afVarA4.h().a(new h(afVarA4.a("Content-Type"), afVarA4.g().b(), n.a(new AnonymousClass1(afVarA4.g().c(), bVarA, n.a(vVarB))))).a();
                }
                if (com.anythink.core.common.n.b.a.c.f.a(adVar.b())) {
                    try {
                        this.a.b(adVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return afVarA4;
        } catch (Throwable th) {
            if (afVarA != null) {
                com.anythink.core.common.n.b.a.c.a(afVarA.g());
            }
            throw th;
        }
    }

    private static af a(af afVar) {
        return (afVar == null || afVar.g() == null) ? afVar : afVar.h().a((ag) null).a();
    }

    private af a(b bVar, af afVar) {
        v vVarB;
        if (bVar == null || (vVarB = bVar.b()) == null) {
            return afVar;
        }
        return afVar.h().a(new h(afVar.a("Content-Type"), afVar.g().b(), n.a(new AnonymousClass1(afVar.g().c(), bVar, n.a(vVarB))))).a();
    }

    /* JADX INFO: renamed from: com.anythink.core.common.n.b.a.a.a$1, reason: invalid class name */
    final class AnonymousClass1 implements com.anythink.core.common.n.c.w {
        boolean a;
        final /* synthetic */ com.anythink.core.common.n.c.e b;
        final /* synthetic */ b c;
        final /* synthetic */ com.anythink.core.common.n.c.d d;

        AnonymousClass1(com.anythink.core.common.n.c.e eVar, b bVar, com.anythink.core.common.n.c.d dVar) {
            this.b = eVar;
            this.c = bVar;
            this.d = dVar;
        }

        @Override // com.anythink.core.common.n.c.w
        public final long a_(com.anythink.core.common.n.c.c cVar, long j) throws IOException {
            try {
                long jA_ = this.b.a_(cVar, j);
                if (jA_ == -1) {
                    if (!this.a) {
                        this.a = true;
                        this.d.close();
                    }
                    return -1L;
                }
                cVar.a(this.d.c(), cVar.b() - jA_, jA_);
                this.d.A();
                return jA_;
            } catch (IOException e) {
                if (!this.a) {
                    this.a = true;
                    this.c.a();
                }
                throw e;
            }
        }

        @Override // com.anythink.core.common.n.c.w
        public final x a() {
            return this.b.a();
        }

        @Override // com.anythink.core.common.n.c.w, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (!this.a && !com.anythink.core.common.n.b.a.c.a(this, TimeUnit.MILLISECONDS)) {
                this.a = true;
                this.c.a();
            }
            this.b.close();
        }
    }

    private static u a(u uVar, u uVar2) {
        u.a aVar = new u.a();
        int iA = uVar.a();
        for (int i = 0; i < iA; i++) {
            String strA = uVar.a(i);
            String strB = uVar.b(i);
            if ((!"Warning".equalsIgnoreCase(strA) || !strB.startsWith("1")) && (b(strA) || !a(strA) || uVar2.a(strA) == null)) {
                com.anythink.core.common.n.b.a.a.a.a(aVar, strA, strB);
            }
        }
        int iA2 = uVar2.a();
        for (int i2 = 0; i2 < iA2; i2++) {
            String strA2 = uVar2.a(i2);
            if (!b(strA2) && a(strA2)) {
                com.anythink.core.common.n.b.a.a.a.a(aVar, strA2, uVar2.b(i2));
            }
        }
        return aVar.a();
    }

    private static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    private static boolean b(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
