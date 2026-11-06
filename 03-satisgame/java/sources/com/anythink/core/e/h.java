package com.anythink.core.e;

import com.anythink.core.common.h.au;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    private final int a;
    private final List<au> b;

    public h(b bVar, List<au> list) {
        this.a = bVar != null ? bVar.aI() : 2;
        this.b = list;
    }

    public final void a(com.anythink.core.common.l.s sVar) {
        int i = this.a;
        if (i == 1) {
            new com.anythink.core.common.l.n(this.b).a(0, sVar);
        } else {
            if (i == 2) {
                new com.anythink.core.common.l.e.f(this.b).a(sVar);
                return;
            }
            com.anythink.core.common.l.p pVar = new com.anythink.core.common.l.p(sVar);
            new com.anythink.core.common.l.n(this.b).a(0, (com.anythink.core.common.l.s) pVar);
            new com.anythink.core.common.l.e.f(this.b).a(pVar);
        }
    }

    private int a() {
        return this.a;
    }
}
