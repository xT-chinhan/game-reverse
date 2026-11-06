package com.anythink.core.common.m.c;

import android.content.Context;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class e extends d {
    private static final int e = 5;
    private volatile h f;

    public e(Context context) {
        super(context);
    }

    @Override // com.anythink.core.common.m.c.d, com.anythink.core.common.m.c.i
    public final com.anythink.core.common.m.b.f a(com.anythink.core.common.m.b.d dVar) {
        if (!b(dVar)) {
            return null;
        }
        if (this.f == null) {
            synchronized (this.d) {
                if (this.f == null) {
                    com.anythink.core.common.g.c.a();
                    h.a aVar = new h.a(com.anythink.core.common.g.c.c() ? 3600000L : 86400000L);
                    aVar.c = false;
                    this.f = new h(this.b, this.c, aVar);
                }
            }
        }
        return this.f.a(dVar, super.a(dVar));
    }

    @Override // com.anythink.core.common.m.c.i
    public final void a(com.anythink.core.common.m.b.f fVar, com.anythink.core.common.m.b.d dVar) {
        if (b(dVar) && this.f != null) {
            this.f.a(fVar, dVar);
        }
    }

    @Override // com.anythink.core.common.m.c.d
    protected final boolean b(com.anythink.core.common.m.b.d dVar) {
        return this.b != null && dVar != null && q.a(this.b) && com.anythink.core.common.m.b.g.f.equals(dVar.b());
    }

    @Override // com.anythink.core.common.m.c.d
    protected final String c(com.anythink.core.common.m.b.d dVar) {
        return this.f != null ? h.a(dVar) : dVar.b();
    }
}
