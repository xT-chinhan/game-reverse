package com.anythink.core.b;

import com.anythink.core.common.m.q;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g extends e {
    public g(com.anythink.core.common.h.a aVar) {
        super(aVar);
    }

    @Override // com.anythink.core.b.e
    protected final void a(List<JSONObject> list, q qVar) {
        com.anythink.core.b.a.b bVar = new com.anythink.core.b.a.b();
        bVar.f = this.f.n.a().aL();
        bVar.t = (this.f == null || this.f.c == null) ? null : this.f.c.b();
        com.anythink.core.b.a.a aVar = new com.anythink.core.b.a.a(this.q, this.p, this.o, list, 1, this.f.n.a());
        aVar.a(bVar);
        aVar.a(0, qVar);
    }

    @Override // com.anythink.core.b.e
    protected final String b() {
        return this.f.p;
    }
}
