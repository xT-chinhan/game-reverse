package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQyFullScreenAd;

/* JADX INFO: loaded from: classes2.dex */
public final class k6 implements k7 {
    public final /* synthetic */ t6 a;
    public final /* synthetic */ p b;

    public k6(t6 t6Var, p pVar) {
        this.a = t6Var;
        this.b = pVar;
    }

    @Override // com.mcto.sspsdk.internal.k7
    public final void a(Object obj) {
        this.a.a((IQyFullScreenAd) obj);
    }

    @Override // com.mcto.sspsdk.internal.k7
    public final void onError(int i, String str) {
        t6 t6Var = this.a;
        vh vhVar = this.b.c;
        t6Var.a(i, str);
    }
}
