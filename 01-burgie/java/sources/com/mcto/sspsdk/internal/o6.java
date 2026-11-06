package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class o6 extends ld {
    public final /* synthetic */ q6 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o6(q6 q6Var, long j) {
        super(j);
        this.f = q6Var;
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void a(long j) {
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void b() {
        m mVar = this.f.f;
        if (mVar.l) {
            return;
        }
        mVar.onClick(null);
    }
}
