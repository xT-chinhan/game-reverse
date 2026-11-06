package com.smartdigimkt.c0;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.smartdigimkt.a4.b {
    public final /* synthetic */ com.smartdigimkt.h0.e a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ g c;

    public f(g gVar, com.smartdigimkt.h0.e eVar, boolean z) {
        this.c = gVar;
        this.a = eVar;
        this.b = z;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i) {
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, Object obj) {
        this.a.getClass();
        synchronized (this.c) {
            this.c.c.remove(this.a.a);
            if (this.b) {
                this.c.a(this.a);
            }
        }
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, String str, AdError adError) {
        this.a.getClass();
        synchronized (this.c) {
            this.c.c.remove(this.a.a);
            if (!this.b) {
                this.c.b(this.a);
            }
        }
    }
}
