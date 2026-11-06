package com.anythink.core.common.d;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.GeolocationPermissions;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATOsDmEntity;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.IDlHandler;
import com.anythink.core.api.IExHandler;
import com.anythink.core.api.IExHandlerBaseAd;
import com.anythink.core.api.IOdHandler;
import com.anythink.core.api.IOsExHandler;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class r implements IDlHandler, IExHandler, IOdHandler, IOsExHandler {
    private final IExHandler a;
    private final IDlHandler b;
    private final IOdHandler c;
    private final IOsExHandler d;

    public r(IExHandler iExHandler, IDlHandler iDlHandler, IOdHandler iOdHandler, IOsExHandler iOsExHandler) {
        this.a = iExHandler;
        this.b = iDlHandler;
        this.c = iOdHandler;
        this.d = iOsExHandler;
    }

    public final boolean a() {
        return this.b != null;
    }

    @Override // com.anythink.core.api.IExHandler, com.anythink.core.api.IOdHandler
    public final void initDeviceInfo(Context context) {
        IOdHandler iOdHandler = this.c;
        if (iOdHandler != null) {
            iOdHandler.initDeviceInfo(context);
        }
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.initDeviceInfo(context);
        }
    }

    @Override // com.anythink.core.api.IExHandler, com.anythink.core.api.IOdHandler
    public final String getUniqueId(Context context) {
        IOdHandler iOdHandler;
        IExHandler iExHandler = this.a;
        String uniqueId = iExHandler != null ? iExHandler.getUniqueId(context) : "";
        return (!TextUtils.isEmpty(uniqueId) || (iOdHandler = this.c) == null) ? uniqueId : iOdHandler.getUniqueId(context);
    }

    @Override // com.anythink.core.api.IExHandler
    public final JSONObject getCnDInfo() {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            return iExHandler.getCnDInfo();
        }
        return null;
    }

    @Override // com.anythink.core.api.IExHandler
    public final void fillRequestData(JSONObject jSONObject, com.anythink.core.e.b bVar) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.fillRequestData(jSONObject, bVar);
        }
    }

    @Override // com.anythink.core.api.IExHandler, com.anythink.core.api.IOdHandler
    public final void fillRequestData(JSONObject jSONObject, com.anythink.core.e.b bVar, int i) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.fillRequestData(jSONObject, bVar, i);
        }
        IOdHandler iOdHandler = this.c;
        if (iOdHandler != null) {
            iOdHandler.fillRequestData(jSONObject, bVar, i);
        }
    }

    @Override // com.anythink.core.api.IExHandler
    public final void fillRequestDeviceData(JSONObject jSONObject, int i) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.fillRequestDeviceData(jSONObject, i);
        }
    }

    @Override // com.anythink.core.api.IExHandler, com.anythink.core.api.IOdHandler
    public final void fillTestDeviceData(JSONObject jSONObject, com.anythink.core.e.b bVar) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.fillTestDeviceData(jSONObject, bVar);
        }
        IOdHandler iOdHandler = this.c;
        if (iOdHandler != null) {
            iOdHandler.fillTestDeviceData(jSONObject, bVar);
        }
    }

    @Override // com.anythink.core.api.IExHandler, com.anythink.core.api.IOdHandler
    public final String fillCDataParam(String str) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            str = iExHandler.fillCDataParam(str);
        }
        IOdHandler iOdHandler = this.c;
        if (iOdHandler != null) {
            str = iOdHandler.fillCDataParam(str);
        }
        return !TextUtils.isEmpty(str) ? str.replace("at_device1", "").replace("at_device2", "").replace("at_device3", "") : str;
    }

    @Override // com.anythink.core.api.IExHandler
    public final ATEventInterface createDataFetchListener(ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd, ATEventInterface aTEventInterface) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            return iExHandler.createDataFetchListener(aTBaseAdAdapter, baseAd, aTEventInterface);
        }
        return null;
    }

    @Override // com.anythink.core.api.IOdHandler
    public final boolean checkDebuggerDevice(Context context, String str) {
        IOdHandler iOdHandler = this.c;
        if (iOdHandler != null) {
            return iOdHandler.checkDebuggerDevice(context, str);
        }
        return false;
    }

    @Override // com.anythink.core.api.IExHandler
    public final String getAid(Context context) {
        IExHandler iExHandler = this.a;
        return iExHandler != null ? iExHandler.getAid(context) : "";
    }

    @Override // com.anythink.core.api.IExHandler
    public final boolean onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            return iExHandler.onGeolocationPermissionsShowPrompt(str, callback);
        }
        return false;
    }

    @Override // com.anythink.core.api.IExHandler
    public final void resetSSID() {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.resetSSID();
        }
    }

    @Override // com.anythink.core.api.IExHandler
    public final void startPlugin(Context context) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.startPlugin(context);
        }
    }

    @Override // com.anythink.core.api.IExHandler
    public final void startUpDateUPID(Context context) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.startUpDateUPID(context);
        }
    }

    @Override // com.anythink.core.api.IExHandler
    public final void startRefreshes(long j) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.startRefreshes(j);
        }
    }

    @Override // com.anythink.core.api.IExHandler
    public final void addPlLoadStateListener(com.anythink.core.common.j.d dVar) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.addPlLoadStateListener(dVar);
        }
    }

    @Override // com.anythink.core.api.IExHandler
    public final boolean isContainsPlStr(String str) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            return iExHandler.isContainsPlStr(str);
        }
        return false;
    }

    @Override // com.anythink.core.api.IDlHandler
    public final void handleOfferClick(Context context, x xVar, w wVar, String str, String str2, Runnable runnable, com.anythink.core.common.j.b bVar) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.handleOfferClick(context, xVar, wVar, str, str2, runnable, bVar);
        }
    }

    @Override // com.anythink.core.api.IDlHandler
    public final void openDataConfirmDialog(Context context, w wVar, x xVar, com.anythink.core.common.j.a aVar) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.openDataConfirmDialog(context, wVar, xVar, aVar);
        }
    }

    @Override // com.anythink.core.api.IDlHandler
    public final int checkDataFetchType(w wVar, x xVar) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler == null) {
            return 0;
        }
        iDlHandler.checkDataFetchType(wVar, xVar);
        return 0;
    }

    @Override // com.anythink.core.api.IDlHandler
    public final void fillDataFetchStatus(Context context, w wVar, x xVar) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.fillDataFetchStatus(context, wVar, xVar);
        }
    }

    @Override // com.anythink.core.api.IDlHandler
    public final IExHandlerBaseAd getBaseAdHandler() {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            return iDlHandler.getBaseAdHandler();
        }
        return null;
    }

    @Override // com.anythink.core.api.IDlHandler
    public final void onApplicationBoot() {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.onApplicationBoot();
        }
    }

    @Override // com.anythink.core.api.IDlHandler
    public final void onAppForegroundStatusChanged(boolean z) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.onAppForegroundStatusChanged(z);
        }
    }

    @Override // com.anythink.core.api.IDlHandler
    public final void cleanExpiredInfo() {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.cleanExpiredInfo();
        }
    }

    @Override // com.anythink.core.api.IDlHandler
    public final void fillRequestDataForDl(JSONObject jSONObject) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.fillRequestDataForDl(jSONObject);
        }
    }

    @Override // com.anythink.core.api.IOsExHandler
    public final ATOsDmEntity getOsDmEntity() {
        IOsExHandler iOsExHandler = this.d;
        if (iOsExHandler != null) {
            return iOsExHandler.getOsDmEntity();
        }
        return null;
    }

    @Override // com.anythink.core.api.IOsExHandler
    public final String getCdnUrl() {
        IOsExHandler iOsExHandler = this.d;
        return iOsExHandler != null ? iOsExHandler.getCdnUrl() : "";
    }

    @Override // com.anythink.core.api.IOsExHandler
    public final String getGdprUrl() {
        IOsExHandler iOsExHandler = this.d;
        return iOsExHandler != null ? iOsExHandler.getGdprUrl() : "";
    }

    @Override // com.anythink.core.api.IExHandler
    public final String getDefaultMarketSchemePackageName() {
        IExHandler iExHandler = this.a;
        return iExHandler != null ? iExHandler.getDefaultMarketSchemePackageName() : "com.android.vending";
    }

    @Override // com.anythink.core.api.IExHandler
    public final void uploadAegisData(com.anythink.core.e.b bVar) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.uploadAegisData(bVar);
        }
    }
}
