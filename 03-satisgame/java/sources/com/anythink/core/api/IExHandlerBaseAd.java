package com.anythink.core.api;

import android.content.Context;
import com.anythink.core.common.h.w;

/* JADX INFO: loaded from: classes.dex */
public interface IExHandlerBaseAd {

    public interface DataFetchListener {
        w getBaseAdContent();

        void onStatusChanged(String str);
    }

    void addDataFetchListener(DataFetchListener dataFetchListener);

    void onAdxAdDestroy(Context context);

    void pause(w wVar);

    void removeDataFetchListener(DataFetchListener dataFetchListener);

    void updateOfferInfoWithDataInfo(w wVar);
}
