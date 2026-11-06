package com.anythink.basead.b.b;

import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.kuaishou.weapon.p0.t;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private w b;
    private x c;
    private com.anythink.basead.d.j d;
    private boolean e;
    private final String a = t.a;
    private boolean f = false;

    public k(w wVar, x xVar) {
        this.b = wVar;
        this.c = xVar;
        this.e = false;
        if (xVar == null || xVar.o == null) {
            return;
        }
        this.e = this.c.o.Y() != 2;
    }

    public final void a(com.anythink.basead.d.j jVar) {
        this.d = jVar;
    }

    public final com.anythink.basead.d.j a() {
        return this.d;
    }

    public final void b() {
        if (this.d == null) {
            return;
        }
        if (this.e || !this.f) {
            this.f = true;
            w wVar = this.b;
            if (wVar == null || !(wVar instanceof bj) || !((bj) wVar).ax() || this.b.r() == null || this.b.r().bK() == 2) {
                com.anythink.basead.b.b.a(9, this.b, this.d);
            }
        }
    }
}
