package com.kwad.sdk.liteapi.report;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.liteapi.InputParamHolder;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.PackageManagerUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.core.internal.event.iap.lib2plus.BillingClientConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class LiteAppInfo {
    private static JSONObject sCacheJsonObj;
    private String appId;
    private String name;
    private String packageName;
    private String version;

    LiteAppInfo() {
    }

    public static LiteAppInfo newInstance(Context context) {
        LiteAppInfo liteAppInfo = new LiteAppInfo();
        SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
        if (sDKConfig != null) {
            liteAppInfo.appId = sDKConfig.appId;
            liteAppInfo.name = sDKConfig.appName;
        }
        liteAppInfo.packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = PackageManagerUtils.getPackageInfo(context.getApplicationContext(), context.getPackageName(), 64);
            if (packageInfo != null) {
                liteAppInfo.version = packageInfo.versionName;
            }
        } catch (Exception e) {
            LiteApiLogger.printStackTraceOnly(e);
        }
        return liteAppInfo;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getName() {
        return this.name;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getVersion() {
        return this.version;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("appId", this.appId);
            jSONObject.putOpt(TapEventParamConstants.PARAM_NAME, this.name);
            jSONObject.putOpt(BillingClientConstants.PACKAGE_NAME, this.packageName);
            jSONObject.putOpt("version", this.version);
        } catch (JSONException e) {
            LiteApiLogger.printStackTrace(e);
        }
        return jSONObject;
    }
}
