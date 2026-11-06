package com.smartdigimkt.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements l {
    public final long a;
    public final j b;

    public k(long j, long j2) {
        this.a = j;
        m mVar = j2 == 0 ? m.c : new m(0L, j2);
        this.b = new j(mVar, mVar);
    }

    @Override // com.smartdigimkt.n0.l
    public final boolean a() {
        return false;
    }

    @Override // com.smartdigimkt.n0.l
    public final long b() {
        return this.a;
    }

    @Override // com.smartdigimkt.n0.l
    public final j a(long j) {
        return this.b;
    }
}
