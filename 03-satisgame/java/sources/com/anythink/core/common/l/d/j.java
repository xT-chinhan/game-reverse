package com.anythink.core.common.l.d;

import android.content.Context;
import com.anythink.core.common.u.p;

/* JADX INFO: loaded from: classes.dex */
public final class j extends d {
    private static final int e = 5;
    private static final long f = 86400000;
    private volatile h g;

    public j(Context context) {
        super(context);
    }

    @Override // com.anythink.core.common.l.d.d, com.anythink.core.common.l.d.i
    public final com.anythink.core.common.l.c.f a(com.anythink.core.common.l.c.d dVar) {
        if (!b(dVar)) {
            return null;
        }
        if (this.g == null) {
            synchronized (this.d) {
                if (this.g == null) {
                    this.g = new h(this.b, this.c, new h.a(86400000L));
                }
            }
        }
        return this.g.a(dVar, super.a(dVar));
    }

    @Override // com.anythink.core.common.l.d.i
    public final void a(com.anythink.core.common.l.c.f fVar, com.anythink.core.common.l.c.d dVar) {
        if (b(dVar) && this.g != null) {
            this.g.a(fVar, dVar);
        }
    }

    @Override // com.anythink.core.common.l.d.d
    protected final boolean b(com.anythink.core.common.l.c.d dVar) {
        return this.b != null && dVar != null && p.a(this.b) && com.anythink.core.common.l.c.g.m.equals(dVar.b());
    }

    @Override // com.anythink.core.common.l.d.d
    protected final String c(com.anythink.core.common.l.c.d dVar) {
        return this.g != null ? h.a(dVar) : dVar.b();
    }
}
