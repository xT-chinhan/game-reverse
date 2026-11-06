package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 implements k7 {
    public final /* synthetic */ fa a;
    public final /* synthetic */ i0 b;

    public h0(i0 i0Var, fa faVar) {
        this.b = i0Var;
        this.a = faVar;
    }

    @Override // com.mcto.sspsdk.internal.k7
    public final void a(Object obj) {
        k6 k6Var = this.b.c;
        fa faVar = this.a;
        k6Var.getClass();
        k6Var.a.a(faVar);
    }

    @Override // com.mcto.sspsdk.internal.k7
    public final void onError(int i, String str) {
        this.b.c.onError(13, gj.a(str, this.b.b.g, i));
    }
}
