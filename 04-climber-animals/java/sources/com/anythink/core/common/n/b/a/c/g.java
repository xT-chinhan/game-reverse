package com.anythink.core.common.n.b.a.c;

import com.anythink.core.common.n.b.ad;
import com.anythink.core.common.n.b.af;
import com.anythink.core.common.n.b.w;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class g implements w.a {
    private final List<w> a;
    private final com.anythink.core.common.n.b.a.b.j b;
    private final com.anythink.core.common.n.b.a.b.c c;
    private final int d;
    private final ad e;
    private final com.anythink.core.common.n.b.e f;
    private final int g;
    private final int h;
    private final int i;
    private int j;

    public g(List<w> list, com.anythink.core.common.n.b.a.b.j jVar, com.anythink.core.common.n.b.a.b.c cVar, int i, ad adVar, com.anythink.core.common.n.b.e eVar, int i2, int i3, int i4) {
        this.a = list;
        this.b = jVar;
        this.c = cVar;
        this.d = i;
        this.e = adVar;
        this.f = eVar;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    @Override // com.anythink.core.common.n.b.w.a
    public final com.anythink.core.common.n.b.j b() {
        com.anythink.core.common.n.b.a.b.c cVar = this.c;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    @Override // com.anythink.core.common.n.b.w.a
    public final int d() {
        return this.g;
    }

    @Override // com.anythink.core.common.n.b.w.a
    public final w.a a(int i, TimeUnit timeUnit) {
        return new g(this.a, this.b, this.c, this.d, this.e, this.f, com.anythink.core.common.n.b.a.c.a("timeout", i, timeUnit), this.h, this.i);
    }

    @Override // com.anythink.core.common.n.b.w.a
    public final int e() {
        return this.h;
    }

    @Override // com.anythink.core.common.n.b.w.a
    public final w.a b(int i, TimeUnit timeUnit) {
        return new g(this.a, this.b, this.c, this.d, this.e, this.f, this.g, com.anythink.core.common.n.b.a.c.a("timeout", i, timeUnit), this.i);
    }

    @Override // com.anythink.core.common.n.b.w.a
    public final int f() {
        return this.i;
    }

    @Override // com.anythink.core.common.n.b.w.a
    public final w.a c(int i, TimeUnit timeUnit) {
        return new g(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, com.anythink.core.common.n.b.a.c.a("timeout", i, timeUnit));
    }

    public final com.anythink.core.common.n.b.a.b.j g() {
        return this.b;
    }

    public final com.anythink.core.common.n.b.a.b.c h() {
        com.anythink.core.common.n.b.a.b.c cVar = this.c;
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalStateException();
    }

    @Override // com.anythink.core.common.n.b.w.a
    public final com.anythink.core.common.n.b.e c() {
        return this.f;
    }

    @Override // com.anythink.core.common.n.b.w.a
    public final ad a() {
        return this.e;
    }

    @Override // com.anythink.core.common.n.b.w.a
    public final af a(ad adVar) {
        return a(adVar, this.b, this.c);
    }

    public final af a(ad adVar, com.anythink.core.common.n.b.a.b.j jVar, com.anythink.core.common.n.b.a.b.c cVar) {
        if (this.d >= this.a.size()) {
            throw new AssertionError();
        }
        this.j++;
        com.anythink.core.common.n.b.a.b.c cVar2 = this.c;
        if (cVar2 != null && !cVar2.a().a(adVar.a())) {
            throw new IllegalStateException("network interceptor " + this.a.get(this.d - 1) + " must retain the same host and port");
        }
        if (this.c != null && this.j > 1) {
            throw new IllegalStateException("network interceptor " + this.a.get(this.d - 1) + " must call proceed() exactly once");
        }
        g gVar = new g(this.a, jVar, cVar, this.d + 1, adVar, this.f, this.g, this.h, this.i);
        w wVar = this.a.get(this.d);
        af afVarA = wVar.a(gVar);
        if (cVar != null && this.d + 1 < this.a.size() && gVar.j != 1) {
            throw new IllegalStateException("network interceptor " + wVar + " must call proceed() exactly once");
        }
        if (afVarA == null) {
            throw new NullPointerException("interceptor " + wVar + " returned null");
        }
        if (afVarA.g() != null) {
            return afVarA;
        }
        throw new IllegalStateException("interceptor " + wVar + " returned a response with no body");
    }
}
