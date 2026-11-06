package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.BaseATView;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 extends com.smartdigimkt.x.b {
    public final /* synthetic */ com.smartdigimkt.b3.c b;
    public final /* synthetic */ BaseATView c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(BaseATView baseATView, com.smartdigimkt.b3.c cVar, com.smartdigimkt.b3.c cVar2) {
        super(cVar);
        this.c = baseATView;
        this.b = cVar2;
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd.DataFetchListener
    public final void onStatusChanged(int i, String str) {
        if (i != 2) {
            return;
        }
        BaseATView baseATView = this.c;
        String str2 = baseATView.a;
        com.smartdigimkt.b3.c cVar = this.b;
        String str3 = cVar.m;
        int i2 = cVar.o;
        baseATView.a(131);
    }
}
