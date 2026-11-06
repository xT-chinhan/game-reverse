package com.smartdigimkt.z;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements com.smartdigimkt.g3.a {
    public final /* synthetic */ int a;
    public final /* synthetic */ a0 b;

    public x(a0 a0Var, int i) {
        this.b = a0Var;
        this.a = i;
    }

    @Override // com.smartdigimkt.g3.a
    public final void a(boolean z) {
        if (z) {
            com.smartdigimkt.q3.f.a().c(new w(this));
            return;
        }
        com.smartdigimkt.a0.e eVar = this.b.g;
        if (eVar != null) {
            eVar.c();
        }
    }
}
