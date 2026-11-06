package com.smartdigimkt.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class z {
    public volatile long a;
    public volatile long b;
    public final m0 c;
    public final Object d;
    public final com.smartdigimkt.v0.m e;
    public final long f;
    public final long g;
    public final int h;
    public final boolean i;
    public final com.smartdigimkt.v0.k0 j;
    public final com.smartdigimkt.x0.m k;

    public z(m0 m0Var, Object obj, com.smartdigimkt.v0.m mVar, long j, long j2, int i, boolean z, com.smartdigimkt.v0.k0 k0Var, com.smartdigimkt.x0.m mVar2) {
        this.c = m0Var;
        this.d = obj;
        this.e = mVar;
        this.f = j;
        this.g = j2;
        this.a = j;
        this.b = j;
        this.h = i;
        this.i = z;
        this.j = k0Var;
        this.k = mVar2;
    }

    public final z a(com.smartdigimkt.v0.m mVar, long j, long j2) {
        return new z(this.c, this.d, mVar, j, mVar.a() ? j2 : -9223372036854775807L, this.h, this.i, this.j, this.k);
    }

    public z(long j, com.smartdigimkt.x0.m mVar) {
        this(m0.a, null, new com.smartdigimkt.v0.m(0), j, -9223372036854775807L, 1, false, com.smartdigimkt.v0.k0.d, mVar);
    }
}
