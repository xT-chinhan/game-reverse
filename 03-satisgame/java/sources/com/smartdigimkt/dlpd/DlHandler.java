package com.smartdigimkt.dlpd;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.dlopt.activity.ApkConfirmDialogActivity;
import com.smartdigimkt.j.i;
import com.smartdigimkt.j.n;
import com.smartdigimkt.j.u;
import com.smartdigimkt.j.x;
import com.smartdigimkt.k.g;
import com.smartdigimkt.k.h;
import com.smartdigimkt.k.o;
import com.smartdigimkt.k.p;
import com.smartdigimkt.k.r;
import com.smartdigimkt.n.b;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.j;
import com.smartdigimkt.sdk.api.IDlHandler;
import com.smartdigimkt.sdk.api.IExHandlerBaseAd;
import com.smartdigimkt.sdk.api.SDMEventInterface;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.File;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DlHandler implements IDlHandler {
    private ExHandlerBaseAd exHandlerBaseAd;

    private u getApkDownloadManager() {
        return u.a(SDKContext.getInstance().d());
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public int checkDataFetchType(c cVar, a aVar) {
        u apkDownloadManager = getApkDownloadManager();
        apkDownloadManager.getClass();
        String strA = j.a(cVar);
        synchronized (apkDownloadManager.b) {
            for (int i = 0; i < apkDownloadManager.b.size(); i++) {
                r rVar = (r) apkDownloadManager.b.get(i);
                if (rVar != null && rVar.o.equals(strA)) {
                    return 0;
                }
            }
            ConcurrentHashMap concurrentHashMap = apkDownloadManager.c;
            if (concurrentHashMap != null && concurrentHashMap.containsKey(strA)) {
                return 0;
            }
            ConcurrentHashMap concurrentHashMap2 = apkDownloadManager.d;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(strA)) {
                return 6;
            }
            ConcurrentHashMap concurrentHashMap3 = apkDownloadManager.f;
            if ((concurrentHashMap3 == null || !concurrentHashMap3.containsKey(strA)) && !apkDownloadManager.a(strA)) {
                return b.b(apkDownloadManager.a, cVar.m) ? 5 : 1;
            }
            return 4;
        }
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public void cleanExpiredInfo() {
        u apkDownloadManager = getApkDownloadManager();
        o oVar = apkDownloadManager.o;
        if (oVar != null) {
            oVar.c.b(new g(oVar, null));
            o oVar2 = apkDownloadManager.o;
            oVar2.getClass();
            oVar2.c.a(new h(oVar2), (new Random().nextInt(121) + 60) * 1000, 13);
        }
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public SDMEventInterface createDataFetchListener(SDMEventInterface sDMEventInterface) {
        return new x(sDMEventInterface);
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public void fillDataFetchStatus(Context context, c cVar, a aVar) {
        if (TextUtils.equals(String.valueOf(aVar.c), "0") && !aVar.w) {
            String strA = j.a(cVar);
            String str = cVar.m;
            if (!TextUtils.isEmpty(str) && b.b(context, str)) {
                cVar.D = 2;
            } else if (new File(com.smartdigimkt.n.c.a(strA)).exists()) {
                cVar.D = 5;
            } else {
                f.a().b(new com.smartdigimkt.n.a(context, strA, cVar));
            }
        }
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public void fillRequestDataForDl(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("apk_plugin", 1);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public IExHandlerBaseAd getBaseAdHandler() {
        if (this.exHandlerBaseAd == null) {
            this.exHandlerBaseAd = new ExHandlerBaseAd(getApkDownloadManager());
        }
        return this.exHandlerBaseAd;
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public void handleOfferClick(Context context, a aVar, c cVar, String str, String str2, Runnable runnable, com.smartdigimkt.g3.b bVar) {
        NotificationPermissionRequester.requestIfNeeded(context, cVar);
        u uVarA = u.a(context);
        uVarA.getClass();
        if (b.b(context, cVar.m)) {
            b.c(context, cVar.m);
            return;
        }
        o oVar = uVarA.o;
        if (oVar != null) {
            oVar.c.b(new g(oVar, new n(uVarA, context, aVar, cVar, str, str2, runnable, bVar)));
        }
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public void onAppForegroundStatusChanged(boolean z) {
        Handler handler;
        u apkDownloadManager = getApkDownloadManager();
        ConcurrentHashMap concurrentHashMap = apkDownloadManager.h;
        if (apkDownloadManager.o == null || concurrentHashMap == null || concurrentHashMap.size() <= 0) {
            return;
        }
        if (z) {
            f.a().c(new i(apkDownloadManager));
            return;
        }
        p pVar = apkDownloadManager.q;
        if (pVar == null || (handler = pVar.c) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public void onApplicationBoot() {
        getApkDownloadManager().getClass();
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public void openDataConfirmDialog(Context context, c cVar, a aVar, com.smartdigimkt.g3.a aVar2) {
        c cVar2 = ApkConfirmDialogActivity.c;
        f.a().c(new com.smartdigimkt.i.b(aVar2, cVar, context));
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public void registerMarketReceiver(c cVar) {
        u uVarA = u.a(SDKContext.getInstance().d());
        uVarA.getClass();
        if (cVar == null || TextUtils.isEmpty(cVar.m)) {
            return;
        }
        f.a().a(new com.smartdigimkt.j.j(uVarA, cVar));
    }
}
