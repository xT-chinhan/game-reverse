package com.anythink.basead.exoplayer.h.b;

import com.anythink.basead.exoplayer.j.k;
import com.anythink.basead.exoplayer.j.t;
import com.anythink.basead.exoplayer.m;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements t.c {
    public final k b;
    public final int c = 1;
    public final m d;
    public final int e;
    public final Object f;
    public final long g;
    public final long h;
    protected final com.anythink.basead.exoplayer.j.h i;

    public abstract long d();

    public c(com.anythink.basead.exoplayer.j.h hVar, k kVar, m mVar, int i, Object obj, long j, long j2) {
        this.i = (com.anythink.basead.exoplayer.j.h) com.anythink.basead.exoplayer.k.a.a(hVar);
        this.b = (k) com.anythink.basead.exoplayer.k.a.a(kVar);
        this.d = mVar;
        this.e = i;
        this.f = obj;
        this.g = j;
        this.h = j2;
    }

    private long c() {
        return this.h - this.g;
    }
}
