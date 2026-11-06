package com.anythink.core.common.m.b;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    final com.anythink.core.common.m.b.a.b.f a;

    public k() {
        this(5, TimeUnit.MINUTES);
    }

    public k(int i, TimeUnit timeUnit) {
        this.a = new com.anythink.core.common.m.b.a.b.f(i, timeUnit);
    }

    public final int a() {
        return this.a.a();
    }

    public final int b() {
        return this.a.b();
    }

    public final void c() {
        this.a.c();
    }
}
