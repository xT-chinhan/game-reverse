package com.smartdigimkt.sdk.api;

import android.content.Context;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.g3.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IDlHandler {
    int checkDataFetchType(c cVar, a aVar);

    void cleanExpiredInfo();

    SDMEventInterface createDataFetchListener(SDMEventInterface sDMEventInterface);

    void fillDataFetchStatus(Context context, c cVar, a aVar);

    void fillRequestDataForDl(JSONObject jSONObject);

    IExHandlerBaseAd getBaseAdHandler();

    void handleOfferClick(Context context, a aVar, c cVar, String str, String str2, Runnable runnable, b bVar);

    void onAppForegroundStatusChanged(boolean z);

    void onApplicationBoot();

    void openDataConfirmDialog(Context context, c cVar, a aVar, com.smartdigimkt.g3.a aVar2);

    void registerMarketReceiver(c cVar);
}
