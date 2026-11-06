package com.anythink.core.api;

import android.content.Context;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.j.a;
import com.anythink.core.common.j.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IDlHandler {
    int checkDataFetchType(w wVar, x xVar);

    void cleanExpiredInfo();

    void fillDataFetchStatus(Context context, w wVar, x xVar);

    void fillRequestDataForDl(JSONObject jSONObject);

    IExHandlerBaseAd getBaseAdHandler();

    void handleOfferClick(Context context, x xVar, w wVar, String str, String str2, Runnable runnable, b bVar);

    void onAppForegroundStatusChanged(boolean z);

    void onApplicationBoot();

    void openDataConfirmDialog(Context context, w wVar, x xVar, a aVar);
}
