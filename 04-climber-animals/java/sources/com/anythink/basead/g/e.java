package com.anythink.basead.g;

import com.anythink.core.common.d.t;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.w;
import com.anythink.core.common.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements a {
    w a;
    n b;
    private int e = 0;
    boolean c = false;
    boolean d = false;

    public e(w wVar, n nVar) {
        this.a = wVar;
        this.b = nVar;
    }

    public void updateTrackingInfo(n nVar) {
        this.b = nVar;
    }

    @Override // com.anythink.basead.g.a
    public void onAdClick(j jVar) {
        this.e++;
        w wVar = this.a;
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            if (rVar.f() == 1 && this.b != null && !this.d) {
                this.d = true;
                com.anythink.core.common.a.f.a().b(this.b.aI(), rVar);
            }
        }
        n nVar = this.b;
        if (nVar != null) {
            nVar.I(jVar.a);
            this.b.J(jVar.b);
            this.b.W(jVar.e);
            if (this.a.r() != null && this.e <= this.a.r().bF()) {
                this.b.d(true);
            } else {
                this.b.d(false);
            }
        }
        q.a(t.b().g()).a(this.a, this.b, 6);
    }

    private void a() {
        w wVar = this.a;
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            if (rVar.f() == 1) {
                com.anythink.core.common.a.d.a().b(rVar);
                if (this.b == null || this.c) {
                    return;
                }
                this.c = true;
                com.anythink.core.common.a.f.a().a(this.b.aI(), rVar);
            }
        }
    }

    private void b() {
        w wVar = this.a;
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            if (rVar.f() != 1 || this.b == null || this.d) {
                return;
            }
            this.d = true;
            com.anythink.core.common.a.f.a().b(this.b.aI(), rVar);
        }
    }

    @Override // com.anythink.basead.g.a
    public void onAdShow(j jVar) {
        w wVar = this.a;
        if (wVar instanceof r) {
            r rVar = (r) wVar;
            if (rVar.f() == 1) {
                com.anythink.core.common.a.d.a().b(rVar);
                if (this.b != null && !this.c) {
                    this.c = true;
                    com.anythink.core.common.a.f.a().a(this.b.aI(), rVar);
                }
            }
        }
        n nVar = this.b;
        if (nVar != null) {
            nVar.U(this.a.Q());
            this.b.W(jVar.e);
        }
        q.a(t.b().g()).a(this.a, this.b, 4);
    }
}
