package com.anythink.basead;

import android.content.Context;
import com.anythink.core.api.IExHandlerBaseAd;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;

/* JADX INFO: loaded from: classes.dex */
public class b implements IExHandlerBaseAd {
    private static volatile b a;
    private IExHandlerBaseAd b;

    private b() {
        s sVarC = t.b().c();
        if (sVarC != null) {
            this.b = sVarC.getBaseAdHandler();
        }
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    @Override // com.anythink.core.api.IExHandlerBaseAd
    public void onAdxAdDestroy(Context context) {
        IExHandlerBaseAd iExHandlerBaseAd = this.b;
        if (iExHandlerBaseAd != null) {
            iExHandlerBaseAd.onAdxAdDestroy(context);
        }
    }

    @Override // com.anythink.core.api.IExHandlerBaseAd
    public void addDataFetchListener(IExHandlerBaseAd.DataFetchListener dataFetchListener) {
        IExHandlerBaseAd iExHandlerBaseAd = this.b;
        if (iExHandlerBaseAd == null || dataFetchListener == null) {
            return;
        }
        iExHandlerBaseAd.addDataFetchListener(dataFetchListener);
    }

    @Override // com.anythink.core.api.IExHandlerBaseAd
    public void removeDataFetchListener(IExHandlerBaseAd.DataFetchListener dataFetchListener) {
        IExHandlerBaseAd iExHandlerBaseAd = this.b;
        if (iExHandlerBaseAd == null || dataFetchListener == null) {
            return;
        }
        iExHandlerBaseAd.removeDataFetchListener(dataFetchListener);
    }

    @Override // com.anythink.core.api.IExHandlerBaseAd
    public void updateOfferInfoWithDataInfo(w wVar) {
        IExHandlerBaseAd iExHandlerBaseAd = this.b;
        if (iExHandlerBaseAd == null || wVar == null) {
            return;
        }
        iExHandlerBaseAd.updateOfferInfoWithDataInfo(wVar);
    }

    @Override // com.anythink.core.api.IExHandlerBaseAd
    public void pause(w wVar) {
        IExHandlerBaseAd iExHandlerBaseAd = this.b;
        if (iExHandlerBaseAd == null || wVar == null) {
            return;
        }
        iExHandlerBaseAd.pause(wVar);
    }

    public static abstract class a implements IExHandlerBaseAd.DataFetchListener {
        private w a;

        public a(w wVar) {
            this.a = wVar;
        }

        @Override // com.anythink.core.api.IExHandlerBaseAd.DataFetchListener
        public w getBaseAdContent() {
            return this.a;
        }
    }
}
