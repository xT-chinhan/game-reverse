package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class a9 extends ld {
    public final /* synthetic */ b9 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a9(b9 b9Var, long j) {
        super(j);
        this.f = b9Var;
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void a(long j) {
        d9 d9Var = this.f.b;
        d9Var.h.setText(d9Var.j.replace("%dcd", (j / 1000) + "s后"));
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void b() {
        this.f.b.destroy();
    }
}
