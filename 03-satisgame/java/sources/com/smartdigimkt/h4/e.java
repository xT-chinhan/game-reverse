package com.smartdigimkt.h4;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static e c;
    public static final Object d = new Object();
    public volatile com.smartdigimkt.i4.a a;
    public volatile com.smartdigimkt.i4.b b;

    public final void a(d dVar, c cVar) {
        com.smartdigimkt.i4.d dVar2;
        if (dVar == null) {
            return;
        }
        int iA = dVar.a();
        synchronized (d) {
            try {
                if (iA == 6) {
                    if (this.b == null) {
                        this.b = new com.smartdigimkt.i4.b();
                    }
                    dVar2 = this.b;
                } else {
                    if (this.a == null) {
                        this.a = new com.smartdigimkt.i4.a();
                    }
                    dVar2 = this.a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (dVar2 == null) {
            if (cVar != null) {
                cVar.a((Throwable) new Exception("socketUploadData is null."));
            }
        } else {
            com.smartdigimkt.i4.c cVar2 = new com.smartdigimkt.i4.c(dVar2, dVar, cVar);
            if (dVar.a() == 6) {
                com.smartdigimkt.q3.f.a().a(cVar2, 2);
            } else {
                com.smartdigimkt.q3.f.a().a(cVar2, 3);
            }
        }
    }
}
