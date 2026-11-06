package com.smartdigimkt.t4;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements com.smartdigimkt.a4.b {
    public final /* synthetic */ com.smartdigimkt.u4.a a;

    public c0(com.smartdigimkt.u4.a aVar) {
        this.a = aVar;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i) {
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, Object obj) {
        d0.d(this.a);
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, String str, AdError adError) {
        this.a.k = adError.getCode();
        this.a.l = adError.getMessage();
        d0.d(this.a);
    }
}
