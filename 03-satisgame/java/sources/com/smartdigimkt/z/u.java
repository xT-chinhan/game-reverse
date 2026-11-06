package com.smartdigimkt.z;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements com.smartdigimkt.g3.a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ v b;

    public u(v vVar, boolean z) {
        this.b = vVar;
        this.a = z;
    }

    @Override // com.smartdigimkt.g3.a
    public final void a(boolean z) {
        if (z) {
            com.smartdigimkt.q3.f.a().c(new t(this));
            return;
        }
        com.smartdigimkt.a0.e eVar = this.b.b.g;
        if (eVar != null) {
            eVar.c();
        }
    }
}
