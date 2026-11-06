package com.anythink.dlpd;

import android.content.Context;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.IDlHandler;
import com.anythink.core.api.IExHandlerBaseAd;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.k.a;
import com.anythink.core.common.k.b;
import com.anythink.dlopt.activity.ApkConfirmDialogActivity;
import com.anythink.dlopt.common.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DlHandler implements IDlHandler {
    private ExHandlerBaseAd exHandlerBaseAd;

    @Override // com.anythink.core.api.IDlHandler
    public void handleOfferClick(Context context, x xVar, w wVar, String str, String str2, Runnable runnable, b bVar) {
        com.anythink.dlopt.common.b.a(context).a(context, xVar, wVar, str, str2, runnable, bVar);
    }

    @Override // com.anythink.core.api.IDlHandler
    public ATEventInterface createDataFetchListener(ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd, ATEventInterface aTEventInterface) {
        return new d(aTBaseAdAdapter, baseAd, aTEventInterface);
    }

    @Override // com.anythink.core.api.IDlHandler
    public void openDataConfirmDialog(Context context, w wVar, x xVar, a aVar) {
        ApkConfirmDialogActivity.a(context, wVar, aVar);
    }

    @Override // com.anythink.core.api.IDlHandler
    public int checkDataFetchType(w wVar, x xVar) {
        return getApkDownloadManager().b(wVar);
    }

    @Override // com.anythink.core.api.IDlHandler
    public void fillDataFetchStatus(Context context, w wVar, x xVar) {
        com.anythink.dlopt.common.c.a.a(context, wVar, xVar);
    }

    @Override // com.anythink.core.api.IDlHandler
    public IExHandlerBaseAd getBaseAdHandler() {
        if (this.exHandlerBaseAd == null) {
            this.exHandlerBaseAd = new ExHandlerBaseAd(getApkDownloadManager());
        }
        return this.exHandlerBaseAd;
    }

    @Override // com.anythink.core.api.IDlHandler
    public void onApplicationBoot() {
        getApkDownloadManager().h();
    }

    @Override // com.anythink.core.api.IDlHandler
    public void onAppForegroundStatusChanged(boolean z) {
        getApkDownloadManager().a(z);
    }

    @Override // com.anythink.core.api.IDlHandler
    public void cleanExpiredInfo() {
        getApkDownloadManager().e();
    }

    @Override // com.anythink.core.api.IDlHandler
    public void fillRequestDataForDl(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("apk_plugin", 1);
            } catch (Throwable unused) {
            }
        }
    }

    private com.anythink.dlopt.common.b getApkDownloadManager() {
        return com.anythink.dlopt.common.b.a(t.b().g());
    }
}
