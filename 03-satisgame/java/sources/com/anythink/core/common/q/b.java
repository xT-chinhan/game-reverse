package com.anythink.core.common.q;

import com.anythink.core.api.ATAdRequest;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    h a;
    int b;
    boolean c;
    long d;
    d e;
    ATAdRequest f;

    public b(h hVar, int i, ATAdRequest aTAdRequest) {
        this.a = hVar;
        this.b = i;
        this.f = aTAdRequest;
    }

    public final ATAdRequest a() {
        return this.f;
    }

    private boolean c() {
        return this.c;
    }

    public final void b() {
        this.c = true;
    }

    private long d() {
        return this.d;
    }

    public final void a(long j) {
        this.d = j;
    }

    public final void a(d dVar) {
        this.e = dVar;
    }
}
