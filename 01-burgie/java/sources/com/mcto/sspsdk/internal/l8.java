package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class l8 extends ld {
    public final /* synthetic */ m8 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l8(m8 m8Var, long j) {
        super(j);
        this.f = m8Var;
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void a(long j) {
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void b() {
        this.f.destroy();
    }
}
