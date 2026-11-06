package com.smartdigimkt.sdk.api;

import android.content.Context;
import com.smartdigimkt.b3.c;

/* JADX INFO: loaded from: classes3.dex */
public interface IExHandlerBaseAd {

    public interface DataFetchListener {
        c getBaseAdContent();

        void onStatusChanged(int i, String str);
    }

    void addDataFetchListener(DataFetchListener dataFetchListener);

    void addDataFetchListenerV2(DataFetchListener dataFetchListener);

    void onAdxAdDestroy(Context context);

    void pause(c cVar);

    void removeDataFetchListener(DataFetchListener dataFetchListener);

    void removeDataFetchListenerV2(DataFetchListener dataFetchListener);

    void updateOfferInfoWithDataInfo(c cVar);
}
