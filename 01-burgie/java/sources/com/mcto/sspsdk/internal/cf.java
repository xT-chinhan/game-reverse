package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class cf implements u3 {
    public final /* synthetic */ gf a;

    public cf(gf gfVar) {
        this.a = gfVar;
    }

    @Override // com.mcto.sspsdk.internal.u3
    public final void a() {
        gf gfVar = this.a;
        int i = gfVar.l;
        gfVar.post(new bf(this));
    }

    @Override // com.mcto.sspsdk.internal.u3
    public final void b() {
        gf gfVar = this.a;
        int i = gfVar.l;
        gfVar.post(new af(this));
    }
}
