package com.anythink.core.c;

import com.anythink.core.common.l.s;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g extends e {
    public g(com.anythink.core.common.h.a aVar) {
        super(aVar);
    }

    @Override // com.anythink.core.c.e
    protected final void a(List<JSONObject> list, s sVar) {
        com.anythink.core.c.a.b bVar = new com.anythink.core.c.a.b();
        bVar.f = this.f.n.a().aK();
        bVar.t = (this.f == null || this.f.c == null) ? null : this.f.c.b();
        com.anythink.core.c.a.c cVar = new com.anythink.core.c.a.c(this.r, this.q, this.p, list, 1, this.f.n.a());
        cVar.a(bVar);
        cVar.a(sVar);
    }

    @Override // com.anythink.core.c.e
    protected final String b() {
        return this.f.p;
    }
}
