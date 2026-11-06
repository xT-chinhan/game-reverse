package com.smartdigimkt.m3;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements a {
    public static volatile g b;
    public final f a = new f();

    public static g a() {
        if (b == null) {
            synchronized (g.class) {
                if (b == null) {
                    b = new g();
                }
            }
        }
        return b;
    }

    @Override // com.smartdigimkt.m3.a
    public final void a(b bVar, long j) {
        this.a.a(bVar, j);
    }

    @Override // com.smartdigimkt.m3.a
    public final void a(b bVar) {
        if (bVar != null) {
            this.a.a(bVar);
        }
    }
}
