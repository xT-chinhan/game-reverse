package com.kwad.sdk.liteapi.report;

import android.content.Context;
import com.kwad.sdk.api.loader.DexLoadError;
import com.kwad.sdk.liteapi.LiteApiLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LiteApiReportRequest {
    private static final String TAG = "LiteApiReportRequest";
    public String SDKVersion;
    public int SDKVersionCode;
    public LiteAppInfo appInfo;
    public LiteDeviceInfo deviceInfo;
    public DexLoadError dexLoadInfo;
    public String sdkApiVersion;
    public int sdkApiVersionCode;
    public int sdkType;

    private LiteApiReportRequest() {
    }

    public static LiteApiReportRequest newInstance(Context context, String str, int i) {
        LiteApiLogger.w(TAG, "newInstance start");
        LiteApiReportRequest liteApiReportRequest = new LiteApiReportRequest();
        liteApiReportRequest.sdkType = 1;
        liteApiReportRequest.SDKVersion = "5.9.10.1";
        liteApiReportRequest.SDKVersionCode = 5091001;
        liteApiReportRequest.sdkApiVersion = "5.9.10.1";
        liteApiReportRequest.sdkApiVersionCode = 5091001;
        liteApiReportRequest.dexLoadInfo = new DexLoadError(i, str);
        liteApiReportRequest.deviceInfo = LiteDeviceInfo.createAsync(context);
        liteApiReportRequest.appInfo = LiteAppInfo.newInstance(context);
        LiteApiLogger.w(TAG, "newInstance start end reportRequest: " + liteApiReportRequest);
        return liteApiReportRequest;
    }

    public String getAppId() {
        LiteAppInfo liteAppInfo = this.appInfo;
        if (liteAppInfo == null) {
            return null;
        }
        return liteAppInfo.getAppId();
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("SDKVersion", this.SDKVersion);
            jSONObject.putOpt("SDKVersionCode", Integer.valueOf(this.SDKVersionCode));
            jSONObject.putOpt("sdkApiVersion", this.sdkApiVersion);
            jSONObject.putOpt("sdkApiVersionCode", Integer.valueOf(this.sdkApiVersionCode));
            jSONObject.putOpt("sdkType", Integer.valueOf(this.sdkType));
            jSONObject.putOpt("appInfo", this.appInfo.toJson());
            jSONObject.putOpt("dexLoadInfo", this.dexLoadInfo.toJson());
            jSONObject.putOpt("deviceInfo", this.deviceInfo.toJson());
        } catch (JSONException e) {
            LiteApiLogger.printStackTraceOnly(e);
        }
        return jSONObject;
    }
}
