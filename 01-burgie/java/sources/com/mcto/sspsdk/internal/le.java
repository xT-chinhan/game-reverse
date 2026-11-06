package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class le extends ld {
    public final /* synthetic */ ve f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public le(ve veVar, long j) {
        super(j);
        this.f = veVar;
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void a(long j) {
        ve veVar = this.f;
        p pVar = veVar.c;
        te teVar = veVar.f0;
        long j2 = pVar.h;
        teVar.a(pVar, j2, j2 - j);
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void b() {
        this.f.f0.a.k();
    }
}
