package com.anythink.core.common.m.c;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class j extends x {
    private x a;

    public j(x xVar) {
        if (xVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = xVar;
    }

    public final x a() {
        return this.a;
    }

    public final j a(x xVar) {
        if (xVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = xVar;
        return this;
    }

    @Override // com.anythink.core.common.m.c.x
    public final x a(long j, TimeUnit timeUnit) {
        return this.a.a(j, timeUnit);
    }

    @Override // com.anythink.core.common.m.c.x
    public final long e_() {
        return this.a.e_();
    }

    @Override // com.anythink.core.common.m.c.x
    public final boolean b_() {
        return this.a.b_();
    }

    @Override // com.anythink.core.common.m.c.x
    public final long c_() {
        return this.a.c_();
    }

    @Override // com.anythink.core.common.m.c.x
    public final x a(long j) {
        return this.a.a(j);
    }

    @Override // com.anythink.core.common.m.c.x
    public final x d_() {
        return this.a.d_();
    }

    @Override // com.anythink.core.common.m.c.x
    public final x f() {
        return this.a.f();
    }

    @Override // com.anythink.core.common.m.c.x
    public final void g() throws InterruptedIOException {
        this.a.g();
    }
}
