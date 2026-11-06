package com.anythink.core.api;

import android.content.Context;
import android.webkit.GeolocationPermissions;
import com.anythink.core.common.k.d;
import com.anythink.core.d.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IExHandler {
    void addPlLoadStateListener(d dVar);

    String fillCDataParam(String str);

    void fillRequestData(JSONObject jSONObject, b bVar);

    void fillRequestData(JSONObject jSONObject, b bVar, int i);

    void fillRequestDeviceData(JSONObject jSONObject, int i);

    void fillTestDeviceData(JSONObject jSONObject, b bVar);

    String getAid(Context context);

    String getDefaultMarketSchemePackageName();

    String getUniqueId(Context context);

    void initDeviceInfo(Context context);

    boolean isContainsPlStr(String str);

    boolean onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback);

    void resetSSID();

    void startPlugin(Context context);

    void startRefreshes(long j);
}
