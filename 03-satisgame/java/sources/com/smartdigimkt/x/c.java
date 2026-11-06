package com.smartdigimkt.x;

import android.content.Context;
import com.smartdigimkt.sdk.api.IExHandlerBaseAd;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements IExHandlerBaseAd {
    public static volatile c b;
    public final IExHandlerBaseAd a;

    public c() {
        com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
        if (bVarE != null) {
            this.a = bVarE.getBaseAdHandler();
        }
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public final void addDataFetchListener(IExHandlerBaseAd.DataFetchListener dataFetchListener) {
        IExHandlerBaseAd iExHandlerBaseAd = this.a;
        if (iExHandlerBaseAd == null || dataFetchListener == null) {
            return;
        }
        iExHandlerBaseAd.addDataFetchListener(dataFetchListener);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public final void addDataFetchListenerV2(IExHandlerBaseAd.DataFetchListener dataFetchListener) {
        IExHandlerBaseAd iExHandlerBaseAd = this.a;
        if (iExHandlerBaseAd == null || dataFetchListener == null) {
            return;
        }
        iExHandlerBaseAd.addDataFetchListenerV2(dataFetchListener);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public final void onAdxAdDestroy(Context context) {
        IExHandlerBaseAd iExHandlerBaseAd = this.a;
        if (iExHandlerBaseAd != null) {
            iExHandlerBaseAd.onAdxAdDestroy(context);
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public final void pause(com.smartdigimkt.b3.c cVar) {
        IExHandlerBaseAd iExHandlerBaseAd = this.a;
        if (iExHandlerBaseAd == null || cVar == null) {
            return;
        }
        iExHandlerBaseAd.pause(cVar);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public final void removeDataFetchListener(IExHandlerBaseAd.DataFetchListener dataFetchListener) {
        IExHandlerBaseAd iExHandlerBaseAd = this.a;
        if (iExHandlerBaseAd == null || dataFetchListener == null) {
            return;
        }
        iExHandlerBaseAd.removeDataFetchListener(dataFetchListener);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public final void removeDataFetchListenerV2(IExHandlerBaseAd.DataFetchListener dataFetchListener) {
        IExHandlerBaseAd iExHandlerBaseAd = this.a;
        if (iExHandlerBaseAd == null || dataFetchListener == null) {
            return;
        }
        iExHandlerBaseAd.removeDataFetchListenerV2(dataFetchListener);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public final void updateOfferInfoWithDataInfo(com.smartdigimkt.b3.c cVar) {
        IExHandlerBaseAd iExHandlerBaseAd = this.a;
        if (iExHandlerBaseAd == null || cVar == null) {
            return;
        }
        iExHandlerBaseAd.updateOfferInfoWithDataInfo(cVar);
    }
}
