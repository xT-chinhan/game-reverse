package com.smartdigimkt.x4;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements com.smartdigimkt.m3.b {
    public final /* synthetic */ com.smartdigimkt.v4.a a;
    public final /* synthetic */ x b;

    public t(x xVar, com.smartdigimkt.v4.a aVar) {
        this.b = xVar;
        this.a = aVar;
    }

    @Override // com.smartdigimkt.m3.b
    public final boolean a() {
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.c.get()) {
            this.b.g(this.a);
        } else {
            this.b.d.set(true);
            x.a(this.b, this.a, com.smartdigimkt.z3.b.a("10005", ""), -3);
        }
    }
}
