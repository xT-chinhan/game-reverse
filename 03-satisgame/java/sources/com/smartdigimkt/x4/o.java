package com.smartdigimkt.x4;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements com.smartdigimkt.m3.b {
    public final /* synthetic */ com.smartdigimkt.v4.a a;
    public final /* synthetic */ p b;

    public o(p pVar, com.smartdigimkt.v4.a aVar) {
        this.b = pVar;
        this.a = aVar;
    }

    @Override // com.smartdigimkt.m3.b
    public final boolean a() {
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(com.smartdigimkt.z3.b.a("10005", ""));
        com.smartdigimkt.h3.b bVar = this.a.x;
        if (bVar != null) {
            synchronized (bVar) {
            }
        }
        this.b.d(this.a);
    }
}
