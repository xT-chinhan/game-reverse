package com.kwad.sdk.datacollection;

import com.anythink.core.common.f.e;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class KsSafetyPrivateDataController implements KsSafetyPrivateData {
    private static volatile KsSafetyPrivateDataController instance;
    private static SDKSafetyPrivateData sMSDKPrivateData;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
        public static final int KS_AD_PRIVATE_DATA_ERROR_DEVICE_NOT_SUPPORT = 4;
        public static final int KS_AD_PRIVATE_DATA_ERROR_EXCEPTION = 2;
        public static final int KS_AD_PRIVATE_DATA_ERROR_FAILED = 3;
        public static final int KS_AD_PRIVATE_DATA_ERROR_NO_PERMISSION = 1;
        public static final int KS_AD_PRIVATE_DATA_ERROR_OTHERS = 5;
        public static final int KS_AD_PRIVATE_DATA_NO_ERROR = 0;
    }

    private KsSafetyPrivateDataController() {
    }

    public static synchronized KsSafetyPrivateDataController getInstance() {
        if (instance == null) {
            synchronized (KsSafetyPrivateDataController.class) {
                if (instance == null) {
                    instance = new KsSafetyPrivateDataController();
                }
            }
        }
        return instance;
    }

    public static void init(SDKSafetyPrivateData sDKSafetyPrivateData) {
        sMSDKPrivateData = sDKSafetyPrivateData;
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getIMEI() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getIMEI();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getOaid() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getOaid();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getAndroidID() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getAndroidID();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getMac() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getMac();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getIMEI2() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getIMEI2();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getIMEI3() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getIMEI3();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getIMSI() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getIMSI();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getIccId() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getIccId();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getSimCardPhoneCount() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getSimCardPhoneCount();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getSimCardActivePhoneCount() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getSimCardActivePhoneCount();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getBaseStationInfo() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getBaseStationInfo();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getDeviceId() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getDeviceId();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getAppPackageName() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getAppPackageName();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getIp() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getIp();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getWifiList() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getWifiList();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getLocation() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getLocation();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getAppList() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getAppList();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getSdkType() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getSdkType();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getSdkVersion() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getSdkVersion();
        }
        return getSafetyErrorResponse();
    }

    @Override // com.kwad.sdk.datacollection.KsSafetyPrivateData
    public String getAppId() {
        SDKSafetyPrivateData sDKSafetyPrivateData = sMSDKPrivateData;
        if (sDKSafetyPrivateData != null) {
            return sDKSafetyPrivateData.getAppId();
        }
        return getSafetyErrorResponse();
    }

    private static String getSafetyErrorResponse() {
        return buildSafetyResponse(false, "", 2);
    }

    public static String buildSafetyResponse(boolean z, Object obj, int i) {
        HashMap map = new HashMap();
        map.put("userSet", String.valueOf(z));
        map.put(e.a.d, obj);
        map.put(MediationConstant.KEY_ERROR_CODE, String.valueOf(i));
        return new JSONObject(map).toString();
    }
}
