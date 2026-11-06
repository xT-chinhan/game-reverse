package com.smartdigimkt.n3;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements com.smartdigimkt.h4.c {
    public final /* synthetic */ r a;

    public p(r rVar) {
        this.a = rVar;
    }

    @Override // com.smartdigimkt.h4.c
    public final void a(Object obj) {
        if (obj instanceof com.smartdigimkt.h4.a) {
            this.a.a(((com.smartdigimkt.h4.a) obj).d);
            r rVar = this.a;
            rVar.i = false;
            com.smartdigimkt.r4.y.a(rVar.f, "sdm_adx_rp_sdk", "LOG_SEND_TIME", System.currentTimeMillis());
        }
    }

    @Override // com.smartdigimkt.h4.c
    public final void a(Throwable th) {
        this.a.i = false;
    }
}
