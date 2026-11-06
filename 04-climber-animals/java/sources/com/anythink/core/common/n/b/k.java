package com.anythink.core.common.n.b;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    final com.anythink.core.common.n.b.a.b.f a;

    public k() {
        this(5, TimeUnit.MINUTES);
    }

    public k(int i, TimeUnit timeUnit) {
        this.a = new com.anythink.core.common.n.b.a.b.f(i, timeUnit);
    }

    private int a() {
        return this.a.a();
    }

    private int b() {
        return this.a.b();
    }

    private void c() {
        this.a.c();
    }
}
