package com.smartdigimkt.k1;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ com.smartdigimkt.j1.f a;
    public final /* synthetic */ d b;

    public c(d dVar, com.smartdigimkt.x4.l lVar) {
        this.b = dVar;
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.d()) {
            com.smartdigimkt.j1.f fVar = this.a;
            if (fVar != null) {
                fVar.b();
                return;
            }
            return;
        }
        com.smartdigimkt.j1.f fVar2 = this.a;
        if (fVar2 != null) {
            fVar2.a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.i, com.anythink.core.common.inner.b.b.D));
        }
    }
}
