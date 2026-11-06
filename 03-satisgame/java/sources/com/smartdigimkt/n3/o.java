package com.smartdigimkt.n3;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements com.smartdigimkt.a4.b {
    public final /* synthetic */ r a;

    public o(r rVar) {
        this.a = rVar;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i) {
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, Object obj) {
        try {
            this.a.a(((Integer) obj).intValue());
            r rVar = this.a;
            rVar.i = false;
            com.smartdigimkt.r4.y.a(rVar.f, "sdm_adx_rp_sdk", "LOG_SEND_TIME", System.currentTimeMillis());
        } catch (Throwable unused) {
            this.a.i = false;
        }
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, String str, AdError adError) {
        this.a.i = false;
    }
}
