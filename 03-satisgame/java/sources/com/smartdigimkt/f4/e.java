package com.smartdigimkt.f4;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends b {
    public e(com.smartdigimkt.g4.c cVar) {
        super(cVar);
    }

    @Override // com.smartdigimkt.f4.b
    public final void b(AdError adError) {
        com.smartdigimkt.n3.k.a(com.anythink.core.common.f.a.C0017a.c, adError.getCode(), adError.getMessage(), this.d.k(), "", "", "");
    }

    @Override // com.smartdigimkt.f4.b
    public final Object a(Object obj) {
        com.smartdigimkt.n3.k.a(this.i, System.currentTimeMillis(), com.anythink.core.common.f.a.C0017a.c, (String) null);
        return obj;
    }
}
