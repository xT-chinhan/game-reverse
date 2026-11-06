package com.smartdigimkt.w2;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.GeolocationPermissions;
import com.smartdigimkt.sdk.api.IDlHandler;
import com.smartdigimkt.sdk.api.IExHandler;
import com.smartdigimkt.sdk.api.IExHandlerBaseAd;
import com.smartdigimkt.sdk.api.IOdHandler;
import com.smartdigimkt.sdk.api.SDMEventInterface;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements IExHandler, IDlHandler, IOdHandler {
    public final IExHandler a;
    public final IDlHandler b;
    public final IOdHandler c;

    public b(IExHandler iExHandler, IDlHandler iDlHandler, IOdHandler iOdHandler) {
        this.a = iExHandler;
        this.b = iDlHandler;
        this.c = iOdHandler;
    }

    public final boolean a() {
        return this.b != null;
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public final int checkDataFetchType(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            return iDlHandler.checkDataFetchType(cVar, aVar);
        }
        return 0;
    }

    @Override // com.smartdigimkt.sdk.api.IOdHandler
    public final boolean checkDebuggerDevice(Context context, String str) {
        IOdHandler iOdHandler = this.c;
        if (iOdHandler != null) {
            return iOdHandler.checkDebuggerDevice(context, str);
        }
        return false;
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public final void cleanExpiredInfo() {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.cleanExpiredInfo();
        }
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public final SDMEventInterface createDataFetchListener(SDMEventInterface sDMEventInterface) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            return iDlHandler.createDataFetchListener(sDMEventInterface);
        }
        return null;
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
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

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public final void fillDataFetchStatus(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.fillDataFetchStatus(context, cVar, aVar);
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public final void fillRequestData(JSONObject jSONObject, com.smartdigimkt.p4.a aVar) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.fillRequestData(jSONObject, aVar);
        }
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public final void fillRequestDataForDl(JSONObject jSONObject) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.fillRequestDataForDl(jSONObject);
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public final void fillRequestDeviceData(JSONObject jSONObject, int i) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.fillRequestDeviceData(jSONObject, i);
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public final void fillTestDeviceData(JSONObject jSONObject, com.smartdigimkt.p4.a aVar) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.fillTestDeviceData(jSONObject, aVar);
        }
        IOdHandler iOdHandler = this.c;
        if (iOdHandler != null) {
            iOdHandler.fillTestDeviceData(jSONObject, aVar);
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public final String getAid(Context context) {
        IExHandler iExHandler = this.a;
        return iExHandler != null ? iExHandler.getAid(context) : "";
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public final IExHandlerBaseAd getBaseAdHandler() {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            return iDlHandler.getBaseAdHandler();
        }
        return null;
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public final String getDefaultMarketSchemePackageName() {
        IExHandler iExHandler = this.a;
        return iExHandler != null ? iExHandler.getDefaultMarketSchemePackageName() : "";
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public final void handleOfferClick(Context context, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, String str, String str2, Runnable runnable, com.smartdigimkt.g3.b bVar) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.handleOfferClick(context, aVar, cVar, str, str2, runnable, bVar);
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
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

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public final boolean initPlugin(Context context) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            return iExHandler.initPlugin(context);
        }
        return false;
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public final boolean isContainsPlStr(String str) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            return iExHandler.isContainsPlStr(str);
        }
        return false;
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public final void onAppForegroundStatusChanged(boolean z) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.onAppForegroundStatusChanged(z);
        }
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public final void onApplicationBoot() {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.onApplicationBoot();
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public final boolean onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            return iExHandler.onGeolocationPermissionsShowPrompt(str, callback);
        }
        return false;
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public final void openDataConfirmDialog(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, com.smartdigimkt.g3.a aVar2) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.openDataConfirmDialog(context, cVar, aVar, aVar2);
        }
    }

    @Override // com.smartdigimkt.sdk.api.IDlHandler
    public final void registerMarketReceiver(com.smartdigimkt.b3.c cVar) {
        IDlHandler iDlHandler = this.b;
        if (iDlHandler != null) {
            iDlHandler.registerMarketReceiver(cVar);
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public final void resetSSID() {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.resetSSID();
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public final void startRefreshes(long j) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.startRefreshes(j);
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public final String getUniqueId(Context context) {
        IOdHandler iOdHandler;
        IExHandler iExHandler = this.a;
        String uniqueId = iExHandler != null ? iExHandler.getUniqueId(context) : "";
        return (!TextUtils.isEmpty(uniqueId) || (iOdHandler = this.c) == null) ? uniqueId : iOdHandler.getUniqueId(context);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public final void fillRequestData(JSONObject jSONObject, com.smartdigimkt.p4.a aVar, int i) {
        IExHandler iExHandler = this.a;
        if (iExHandler != null) {
            iExHandler.fillRequestData(jSONObject, aVar, i);
        }
        IOdHandler iOdHandler = this.c;
        if (iOdHandler != null) {
            iOdHandler.fillRequestData(jSONObject, aVar, i);
        }
    }
}
