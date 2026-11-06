package com.anythink.basead.exoplayer;

import com.anythink.basead.exoplayer.h.af;

/* JADX INFO: loaded from: classes.dex */
final class u {
    public final ae a;
    public final Object b;
    public final com.anythink.basead.exoplayer.h.s.a c;
    public final long d;
    public final long e;
    public final int f;
    public final boolean g;
    public final af h;
    public final com.anythink.basead.exoplayer.i.i i;
    public volatile long j;
    public volatile long k;

    public u(ae aeVar, long j, af afVar, com.anythink.basead.exoplayer.i.i iVar) {
        this(aeVar, null, new com.anythink.basead.exoplayer.h.s.a(0), j, -9223372036854775807L, 1, false, afVar, iVar);
    }

    public u(ae aeVar, Object obj, com.anythink.basead.exoplayer.h.s.a aVar, long j, long j2, int i, boolean z, af afVar, com.anythink.basead.exoplayer.i.i iVar) {
        this.a = aeVar;
        this.b = obj;
        this.c = aVar;
        this.d = j;
        this.e = j2;
        this.j = j;
        this.k = j;
        this.f = i;
        this.g = z;
        this.h = afVar;
        this.i = iVar;
    }

    public final u a(com.anythink.basead.exoplayer.h.s.a aVar, long j, long j2) {
        return new u(this.a, this.b, aVar, j, aVar.a() ? j2 : -9223372036854775807L, this.f, this.g, this.h, this.i);
    }

    public final u a(int i) {
        u uVar = new u(this.a, this.b, this.c.a(i), this.d, this.e, this.f, this.g, this.h, this.i);
        a(this, uVar);
        return uVar;
    }

    public final u a(ae aeVar, Object obj) {
        u uVar = new u(aeVar, obj, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        a(this, uVar);
        return uVar;
    }

    public final u b(int i) {
        u uVar = new u(this.a, this.b, this.c, this.d, this.e, i, this.g, this.h, this.i);
        a(this, uVar);
        return uVar;
    }

    public final u a(boolean z) {
        u uVar = new u(this.a, this.b, this.c, this.d, this.e, this.f, z, this.h, this.i);
        a(this, uVar);
        return uVar;
    }

    public final u a(af afVar, com.anythink.basead.exoplayer.i.i iVar) {
        u uVar = new u(this.a, this.b, this.c, this.d, this.e, this.f, this.g, afVar, iVar);
        a(this, uVar);
        return uVar;
    }

    private static void a(u uVar, u uVar2) {
        uVar2.j = uVar.j;
        uVar2.k = uVar.k;
    }
}
