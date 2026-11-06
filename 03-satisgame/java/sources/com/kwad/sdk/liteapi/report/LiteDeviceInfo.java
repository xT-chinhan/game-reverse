package com.kwad.sdk.liteapi.report;

import android.content.Context;
import android.os.Build;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.LiteOAIDHelper;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class LiteDeviceInfo {
    public String deviceBrand;
    public String deviceModel;
    public String deviceVendor;
    public String language;
    public String oaid;
    public int osApi;
    public int osType;
    public String osVersion;
    public int platform;

    LiteDeviceInfo() {
    }

    public static LiteDeviceInfo createAsync(Context context) {
        LiteDeviceInfo liteDeviceInfo = new LiteDeviceInfo();
        try {
            liteDeviceInfo.oaid = LiteOAIDHelper.obtainCurrent();
            liteDeviceInfo.osApi = Build.VERSION.SDK_INT;
            liteDeviceInfo.osVersion = Build.VERSION.RELEASE;
            liteDeviceInfo.osType = 1;
            liteDeviceInfo.language = Locale.getDefault().getLanguage();
            liteDeviceInfo.deviceVendor = Build.MANUFACTURER;
            liteDeviceInfo.deviceModel = Build.MODEL;
            liteDeviceInfo.deviceBrand = Build.BRAND;
        } catch (Throwable unused) {
        }
        return liteDeviceInfo;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", this.oaid);
        } catch (JSONException e) {
            LiteApiLogger.printStackTrace(e);
        }
        return jSONObject;
    }
}
