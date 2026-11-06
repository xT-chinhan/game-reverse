package com.anythink.basead.b;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.anythink.basead.b.b.n;
import com.anythink.basead.b.b.o;
import com.anythink.basead.handler.OfferClickHandler;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 6;
    public static final int f = 7;
    public static final int g = 0;
    public static final int h = 1;
    w i;
    Context k;
    x l;
    IOfferClickHandler m;
    private com.anythink.basead.b.b.k p;
    private com.anythink.basead.b.b.b q;
    private com.anythink.basead.b.b.a.C0008a r;
    private com.anythink.basead.b.b.h s;
    private com.anythink.basead.b.b.d t;
    private com.anythink.basead.b.b.c u;
    private com.anythink.basead.b.b.i v;
    private o w;
    private com.anythink.basead.b.b.g x;
    private final String n = getClass().getSimpleName();
    private final int o = 10;
    boolean j = false;

    public interface a {
        void a();

        void a(boolean z);

        boolean a(String str, IOfferClickHandler iOfferClickHandler);

        void b();

        void c();
    }

    public c(Context context, x xVar, w wVar, View view) {
        this.i = wVar;
        this.l = xVar;
        this.k = context.getApplicationContext();
        this.i.h(xVar.d);
        this.m = new OfferClickHandler();
        this.p = new com.anythink.basead.b.b.k(wVar, xVar);
        this.q = new com.anythink.basead.b.b.b();
        com.anythink.basead.b.b.a.C0008a c0008a = new com.anythink.basead.b.b.a.C0008a();
        this.r = c0008a;
        c0008a.a = this.k;
        this.r.b = this.i;
        this.r.c = this.l;
        this.r.d = this.p;
        this.r.e = this.q;
        this.r.f = this.m;
        this.s = new com.anythink.basead.b.b.h(this.r);
        this.t = new com.anythink.basead.b.b.d(this.r);
        this.u = new com.anythink.basead.b.b.c(this.r);
        this.v = new com.anythink.basead.b.b.i(this.r);
        this.w = new o(this.r);
        this.x = new com.anythink.basead.b.b.g(this.r);
        if (view != null) {
            this.t.a(new WeakReference<>(view));
        }
        this.t.a(this.u);
        this.u.a(this.t);
    }

    public final void a(a aVar) {
        com.anythink.basead.b.b.b bVar = this.q;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public final boolean a() {
        com.anythink.basead.b.b.b bVar = this.q;
        if (bVar != null) {
            return bVar.e();
        }
        return false;
    }

    public final void a(com.anythink.basead.d.j jVar) {
        if (this.j || a()) {
            return;
        }
        com.anythink.basead.b.b.k kVar = this.p;
        if (kVar != null) {
            kVar.a(jVar);
        }
        com.anythink.basead.b.b.b bVar = this.q;
        if (bVar != null) {
            bVar.d();
        }
        com.anythink.core.common.v.b.b.a().b(new AnonymousClass1(jVar), 2);
    }

    /* JADX INFO: renamed from: com.anythink.basead.b.c$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.anythink.basead.d.j a;

        AnonymousClass1(com.anythink.basead.d.j jVar) {
            this.a = jVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.s.a().a()) {
                return;
            }
            int iF = e.f(c.this.i, c.this.l);
            if (iF == 1) {
                c.this.u.a(c.this.u.d(), com.anythink.basead.b.b.e.HANDLE_SUCCESS_WITH_WEB_CLICK);
                com.anythink.core.common.u.e.a(c.this.i, c.this.l, 1, c.this.t.a().a() ? 1 : 2);
                return;
            }
            boolean z = false;
            if (iF > 1) {
                com.anythink.core.common.u.e.a(c.this.i, c.this.l, iF, 0);
            }
            final com.anythink.basead.b.b.e eVar = com.anythink.basead.b.b.e.NO_HANDLE;
            if (c.this.l.o.v() != 2) {
                eVar = c.this.t.a().a() ? com.anythink.basead.b.b.e.HANDLE_SUCCESS : com.anythink.basead.b.b.e.HANDLE_FAIL;
            }
            if (eVar == com.anythink.basead.b.b.e.HANDLE_SUCCESS && c.this.l.o.v() == 1) {
                return;
            }
            s sVarC = t.b().c();
            if (sVarC != null && sVarC.a()) {
                z = true;
            }
            if (!this.a.m && c.this.i.K() == 4 && 1 == c.this.l.o.y() && z && eVar != com.anythink.basead.b.b.e.HANDLE_SUCCESS) {
                sVarC.openDataConfirmDialog(c.this.k, c.this.i, c.this.l, new com.anythink.core.common.k.a() { // from class: com.anythink.basead.b.c.1.1
                    @Override // com.anythink.core.common.k.a
                    public final void a(boolean z2) {
                        if (!z2) {
                            if (c.this.q != null) {
                                c.this.q.c();
                                return;
                            }
                            return;
                        }
                        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.b.c.1.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                c.this.a(eVar);
                            }
                        }, 2);
                    }
                });
            } else {
                c.this.a(eVar);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0093 A[PHI: r3
      0x0093: PHI (r3v3 com.anythink.basead.b.b.n) = 
      (r3v1 com.anythink.basead.b.b.n)
      (r3v4 com.anythink.basead.b.b.n)
      (r3v6 com.anythink.basead.b.b.n)
      (r3v8 com.anythink.basead.b.b.n)
     binds: [B:43:0x0090, B:34:0x0069, B:27:0x0050, B:20:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    public final void a(com.anythink.basead.b.b.e eVar) {
        n nVarA;
        n nVarA2;
        int iK = this.i.K();
        String strD = this.u.d();
        if (iK == 1) {
            nVarA = eVar != com.anythink.basead.b.b.e.HANDLE_SUCCESS ? this.v.a() : null;
            if (nVarA == null || !nVarA.a()) {
                nVarA2 = this.u.a(strD, eVar);
            } else {
                nVarA2 = nVarA;
            }
        } else if (iK == 2 || iK == 3) {
            nVarA2 = this.u.a(strD, eVar);
        } else if (iK == 4) {
            nVarA = eVar != com.anythink.basead.b.b.e.HANDLE_SUCCESS ? this.v.a() : null;
            if (nVarA == null || !nVarA.a()) {
                nVarA2 = this.u.a(strD, eVar);
            } else {
                nVarA2 = nVarA;
            }
        } else if (iK == 6) {
            nVarA = eVar != com.anythink.basead.b.b.e.HANDLE_SUCCESS ? this.w.a() : null;
            if (nVarA == null || !nVarA.a()) {
                nVarA2 = this.u.a(strD, eVar);
            } else {
                nVarA2 = nVarA;
            }
        } else if (iK == 7) {
            nVarA = eVar != com.anythink.basead.b.b.e.HANDLE_SUCCESS ? this.x.a() : null;
            if (nVarA == null || !nVarA.a()) {
                nVarA2 = this.u.a(strD, eVar);
            } else {
                nVarA2 = nVarA;
            }
        } else {
            nVarA2 = this.u.a(strD, eVar);
        }
        if (nVarA2 == null || nVarA2.a()) {
            return;
        }
        t.b().b(new Runnable() { // from class: com.anythink.basead.b.c.2
            @Override // java.lang.Runnable
            public final void run() {
                Context contextG = t.b().g();
                if (contextG != null) {
                    Context applicationContext = contextG.getApplicationContext();
                    try {
                        Toast.makeText(applicationContext.getApplicationContext(), q.a(applicationContext, "myoffer_click_no_response", "string"), 0).show();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public final w b() {
        return this.i;
    }

    public final x c() {
        return this.l;
    }

    public final void d() {
        this.j = true;
        com.anythink.basead.b.b.b bVar = this.q;
        if (bVar != null) {
            bVar.f();
            this.q = null;
        }
        com.anythink.basead.b.b.d dVar = this.t;
        if (dVar != null) {
            dVar.c();
        }
    }
}
