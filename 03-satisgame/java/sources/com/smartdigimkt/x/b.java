package com.smartdigimkt.x;

import com.smartdigimkt.sdk.api.IExHandlerBaseAd;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements IExHandlerBaseAd.DataFetchListener {
    public final com.smartdigimkt.b3.c a;

    public b(com.smartdigimkt.b3.c cVar) {
        this.a = cVar;
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd.DataFetchListener
    public final com.smartdigimkt.b3.c getBaseAdContent() {
        return this.a;
    }
}
