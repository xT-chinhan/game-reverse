package com.anythink.core.common.t.b;

import com.anythink.core.common.d.s;
import com.anythink.core.common.h.n;

/* JADX INFO: loaded from: classes.dex */
class c implements a {
    private static final String a = "c";

    @Override // com.anythink.core.common.t.b.a
    public final void a(String str) {
    }

    @Override // com.anythink.core.common.t.b.a
    public final void b(e eVar) {
    }

    @Override // com.anythink.core.common.t.b.a
    public final void a(e eVar) {
        eVar.d = System.currentTimeMillis();
    }

    @Override // com.anythink.core.common.t.b.a
    public final void c(e eVar) {
        eVar.g = true;
    }

    @Override // com.anythink.core.common.t.b.a
    public final void d(e eVar) {
        eVar.h = true;
    }

    @Override // com.anythink.core.common.t.b.a
    public final boolean e(e eVar) {
        if (!eVar.h || eVar.g) {
            return false;
        }
        n nVar = eVar.b;
        try {
            if (!eVar.i) {
                nVar.aj();
                com.anythink.core.common.t.e.a(s.b().g());
                com.anythink.core.common.t.e.a(6, nVar);
                eVar.i = true;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    private static void f(e eVar) {
        n nVar = eVar.b;
        try {
            if (eVar.i) {
                return;
            }
            nVar.aj();
            com.anythink.core.common.t.e.a(s.b().g());
            com.anythink.core.common.t.e.a(6, nVar);
            eVar.i = true;
        } catch (Throwable unused) {
        }
    }
}
