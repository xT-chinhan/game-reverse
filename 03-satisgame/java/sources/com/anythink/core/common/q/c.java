package com.anythink.core.common.q;

import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.as;
import com.anythink.core.common.h.n;
import com.anythink.core.e.l;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String l = "c";
    String a;
    h b;
    int c;
    d d;
    int e;
    boolean f;
    long g;
    String h;
    boolean i;
    Boolean j;
    com.anythink.core.common.u.b.d k;
    private ATAdRequest m;

    public c(String str) {
        this.a = str;
        this.h = str + "_" + hashCode();
    }

    public final void a(b bVar) {
        this.b = bVar.a;
        this.c = bVar.b;
        this.e = bVar.a.a;
        this.d = bVar.e;
        this.f = bVar.c;
        this.g = bVar.d;
        this.m = bVar.f;
    }

    public final String a() {
        return this.h;
    }

    private void a(Boolean bool) {
        this.j = bool;
    }

    private Boolean f() {
        return this.j;
    }

    private void g() {
        if (this.f && this.g != -1) {
            this.k = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.du, new AnonymousClass1());
            com.anythink.core.common.s.c.a().a(this.k, this.g);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.q.c$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.k();
        }
    }

    private void h() {
        if (this.k != null) {
            com.anythink.core.common.s.c.a().a(this.k);
        }
    }

    private com.anythink.core.common.f i() {
        return com.anythink.core.common.f.a(s.b().g(), this.a, String.valueOf(this.e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        h();
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(this.h, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(AdError adError) {
        h();
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(this.h, this.b, adError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(this.h, this.b);
        }
    }

    public final int d() {
        return this.c;
    }

    public final String e() {
        return this.a;
    }

    private as l() {
        com.anythink.core.common.h.d dVar;
        as asVar = new as();
        asVar.a(s.b().M());
        asVar.c = this.c;
        asVar.a(this.m);
        h hVar = this.b;
        if (hVar != null) {
            n nVar = hVar.g;
            as asVar2 = this.b.f;
            l lVar = this.b.h;
            g gVar = this.b.j;
            if (asVar2 != null) {
                dVar = asVar2.i;
                if (dVar == null) {
                    dVar = new com.anythink.core.common.h.d();
                }
                dVar.a(asVar2.a);
            } else {
                dVar = new com.anythink.core.common.h.d();
                if (this.c == 17) {
                    dVar.b(nVar != null ? 1 : 2);
                }
            }
            dVar.a(this.b.i);
            if (nVar != null) {
                dVar.a(nVar.aQ(), nVar.aa(), nVar.aO());
            } else if (lVar != null) {
                dVar.a(lVar.i(), lVar.ax(), lVar.ah());
            }
            if (gVar != null) {
                dVar.b(gVar.h());
                dVar.a(gVar.f());
                dVar.a(gVar.k());
            }
        } else {
            dVar = null;
        }
        asVar.i = dVar;
        return asVar;
    }

    public final boolean b() {
        return this.j == null || !this.i;
    }

    public final void c() {
        com.anythink.core.common.h.d dVar;
        com.anythink.core.common.f fVarA = com.anythink.core.common.f.a(s.b().g(), this.a, String.valueOf(this.e));
        if (this.f && this.g != -1) {
            this.k = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.du, new AnonymousClass1());
            com.anythink.core.common.s.c.a().a(this.k, this.g);
        }
        as asVar = new as();
        asVar.a(s.b().M());
        asVar.c = this.c;
        asVar.a(this.m);
        h hVar = this.b;
        if (hVar != null) {
            n nVar = hVar.g;
            as asVar2 = this.b.f;
            l lVar = this.b.h;
            g gVar = this.b.j;
            if (asVar2 != null) {
                dVar = asVar2.i;
                if (dVar == null) {
                    dVar = new com.anythink.core.common.h.d();
                }
                dVar.a(asVar2.a);
            } else {
                dVar = new com.anythink.core.common.h.d();
                if (this.c == 17) {
                    dVar.b(nVar != null ? 1 : 2);
                }
            }
            dVar.a(this.b.i);
            if (nVar != null) {
                dVar.a(nVar.aQ(), nVar.aa(), nVar.aO());
            } else if (lVar != null) {
                dVar.a(lVar.i(), lVar.ax(), lVar.ah());
            }
            if (gVar != null) {
                dVar.b(gVar.h());
                dVar.a(gVar.f());
                dVar.a(gVar.k());
            }
        } else {
            dVar = null;
        }
        asVar.i = dVar;
        fVarA.a(s.b().g(), String.valueOf(this.e), this.a, asVar, new com.anythink.core.common.d.a() { // from class: com.anythink.core.common.q.c.2
            @Override // com.anythink.core.common.d.a
            public final void onAdLoaded() {
                c.this.j();
            }

            @Override // com.anythink.core.common.d.a
            public final void onAdLoadFail(AdError adError) {
                c.this.a(adError);
            }
        });
    }
}
