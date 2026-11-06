package com.anythink.core.common.m.c;

import android.content.Context;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class c extends d {
    private static final int e = 5;
    private static final long f = 3600000;
    private volatile h g;

    public c(Context context) {
        super(context);
    }

    @Override // com.anythink.core.common.m.c.d, com.anythink.core.common.m.c.i
    public final com.anythink.core.common.m.b.f a(com.anythink.core.common.m.b.d dVar) {
        if (!b(dVar)) {
            return null;
        }
        if (this.g == null) {
            synchronized (this.d) {
                if (this.g == null) {
                    this.g = new h(this.b, this.c, new h.a(3600000L));
                }
            }
        }
        return this.g.a(dVar, super.a(dVar));
    }

    @Override // com.anythink.core.common.m.c.i
    public final void a(com.anythink.core.common.m.b.f fVar, com.anythink.core.common.m.b.d dVar) {
        if (b(dVar) && this.g != null) {
            this.g.a(fVar, dVar);
        }
    }

    @Override // com.anythink.core.common.m.c.d
    protected final boolean b(com.anythink.core.common.m.b.d dVar) {
        return this.b != null && dVar != null && q.a(this.b) && com.anythink.core.common.m.b.g.d.equals(dVar.b());
    }

    @Override // com.anythink.core.common.m.c.d
    protected final String c(com.anythink.core.common.m.b.d dVar) {
        return this.g != null ? h.a(dVar) : dVar.b();
    }
}
