package com.smartdigimkt.v4;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.smartdigimkt.m3.b {
    public final a a;
    public final c b;
    public final /* synthetic */ c c;

    public b(c cVar, a aVar, c cVar2) {
        this.c = cVar;
        this.a = aVar;
        this.b = cVar2;
    }

    @Override // com.smartdigimkt.m3.b
    public final boolean a() {
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.a.e;
        this.a.f.get();
        if (this.a.f.get()) {
            return;
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.c(this.a);
        } else {
            this.a.a(com.smartdigimkt.z3.b.a(com.anythink.core.common.inner.b.b.i, "load ad timeout."));
            this.c.d(this.a);
        }
    }
}
