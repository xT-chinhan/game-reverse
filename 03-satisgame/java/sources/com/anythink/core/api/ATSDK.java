package com.anythink.core.api;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.u;
import com.anythink.core.common.g.b;
import com.anythink.core.common.i.a;
import com.anythink.core.common.l.h;
import com.anythink.core.common.u.o;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ATSDK {
    private static boolean HAS_INIT = false;
    public static final int NONPERSONALIZED = 1;
    public static final int PERSONALIZED = 0;
    public static final int UNKNOWN = 2;

    public static int getRequireAdapterBridgeVersion() {
        return 1;
    }

    private ATSDK() {
    }

    public static void init(Context context, String str, String str2) {
        init(context, str, str2, null);
    }

    public static void init(Context context, String str, String str2, ATNetworkConfig aTNetworkConfig) {
        init(context, str, str2, aTNetworkConfig, null);
    }

    @Deprecated
    public static void init(Context context, String str, String str2, ATNetworkConfig aTNetworkConfig, ATSDKInitListener aTSDKInitListener) {
        try {
            if (context == null) {
                if (aTSDKInitListener != null) {
                    aTSDKInitListener.onFail("init: Context is null!");
                }
                Log.e("anythink", "init: Context is null!");
            } else {
                s.b().a(context, str, str2, aTNetworkConfig);
                if (aTSDKInitListener != null) {
                    aTSDKInitListener.onSuccess();
                }
            }
        } catch (Error | Exception unused) {
        }
    }

    public static void start() {
        s.b().x();
    }

    public static boolean isCnSDK() {
        s.b();
        return true;
    }

    public static void setWXAppId(String str) {
        s.b().a(str);
    }

    public static void setChannel(String str) {
        if (o.a(str)) {
            s.b().e(str);
        }
    }

    public static void setSubChannel(String str) {
        if (o.b(str)) {
            s.b().f(str);
        }
    }

    public static void initCustomMap(Map<String, Object> map) {
        s.b().a(map);
    }

    public static void initPlacementCustomMap(String str, Map<String, Object> map) {
        s.b().a(str, map);
    }

    public static void setExcludePackageList(List<String> list) {
        s.b().a(list);
    }

    public static void setGDPRUploadDataLevel(Context context, int i) {
        if (context == null) {
            Log.e("anythink", "setGDPRUploadDataLevel: context should not be null");
        } else if (i == 0 || i == 1) {
            u.a(context).a(i);
        } else {
            Log.e("anythink", "GDPR level setting error!!! Level must be PERSONALIZED or NONPERSONALIZED.");
        }
    }

    public static void deniedUploadDeviceInfo(String... strArr) {
        s.b().a(strArr);
    }

    public static int getGDPRDataLevel(Context context) {
        return u.a(context).a();
    }

    public static boolean isEUTraffic(Context context) {
        return u.a(context).d();
    }

    public static void checkIsEuTraffic(Context context, NetTrafficeCallback netTrafficeCallback) {
        u.a(context).a(netTrafficeCallback, "");
    }

    public static void checkIsEuTraffic(Context context, NetTrafficeCallback netTrafficeCallback, String str) {
        u.a(context).a(netTrafficeCallback, str);
    }

    @Deprecated
    public static void showGdprAuth(Context context) {
        u.a(context).a(context, (ATGDPRAuthCallback) null);
    }

    @Deprecated
    public static void showGdprAuth(Context context, ATGDPRAuthCallback aTGDPRAuthCallback) {
        u.a(context).a(context, aTGDPRAuthCallback);
    }

    public static String getSDKVersionName() {
        return o.a();
    }

    public static void setNetworkLogDebug(boolean z) {
        s.b().b(z);
    }

    public static void setChannelSource(int i) {
        s.b().d(i);
    }

    public static boolean isNetworkLogDebug() {
        return s.b().G();
    }

    public static void integrationChecking(Context context) {
        s.b().b(context);
    }

    public static void setAdLogoVisible(boolean z) {
        s.b().c(z);
    }

    public static void setLocation(Location location) {
        s.b().a(location);
    }

    public static void setWXStatus(boolean z) {
        s.b().a(z);
    }

    public static void setFilterAdSourceIdList(String str, List<String> list) {
        s.b().a(str, list);
    }

    public static void setFilterNetworkFirmIdList(String str, List<String> list) {
        s.b().b(str, list);
    }

    public static void setRiskFilterNetworkFirmIdList(int i, List<String> list) {
        s.b().a(i, list);
    }

    public static void registerDeviceRiskListener(IATDeviceRiskListener iATDeviceRiskListener) {
        s.b().a(iATDeviceRiskListener);
    }

    public static void addCustomAdapterConfig(String str, ATCustomAdapterConfig aTCustomAdapterConfig) {
        s.b().a(str, aTCustomAdapterConfig);
    }

    public static void getArea(final ATAreaCallback aTAreaCallback) {
        if (aTAreaCallback == null) {
            return;
        }
        new h().a(0, new com.anythink.core.common.l.s() { // from class: com.anythink.core.api.ATSDK.1
            @Override // com.anythink.core.common.l.s
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadFinish(int i, Object obj) {
                try {
                    if (!(obj instanceof JSONObject)) {
                        aTAreaCallback.onErrorCallback("There is no result.");
                        return;
                    }
                    JSONObject jSONObject = (JSONObject) obj;
                    if (!jSONObject.has("area")) {
                        aTAreaCallback.onErrorCallback("There is no result.");
                    } else {
                        aTAreaCallback.onResultCallback(jSONObject.optString("area"));
                    }
                } catch (Throwable unused) {
                    aTAreaCallback.onErrorCallback("Internal error");
                }
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadError(int i, String str, AdError adError) {
                aTAreaCallback.onErrorCallback(adError.printStackTrace());
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadCanceled(int i) {
                aTAreaCallback.onErrorCallback("Request cancel");
            }
        });
    }

    public static void testModeDeviceInfo(Context context, DeviceInfoCallback deviceInfoCallback) {
        s.b().a(context, deviceInfoCallback);
    }

    public static void setInitType(int i) {
        s.b().b(i);
    }

    public static void setDebuggerConfig(Context context, String str, ATDebuggerConfig aTDebuggerConfig) {
        s.b().a(context, str, aTDebuggerConfig);
    }

    public static void setPersonalizedAdStatus(int i) {
        s.b().a(i);
    }

    public static int getPersionalizedAdStatus() {
        return s.b().e();
    }

    public static void setUseHTTP(boolean z) {
        s.b().d(z);
    }

    public static void setSystemDevFragmentType(String str) {
        s.b().r(str);
    }

    public static void setATAdFilter(String[] strArr, IATAdFilter iATAdFilter) {
        s.b().a(strArr, iATAdFilter);
    }

    public static void setATUserDeviceInfo(ATUserDeviceInfo aTUserDeviceInfo) {
        s.b().a(aTUserDeviceInfo);
    }

    public static void setLocalStrategyAssetPath(Context context, String str) {
        s.b();
        s.a(context, str);
    }

    public static void setSharedPlacementConfig(ATSharedPlacementConfig aTSharedPlacementConfig) {
        s.b();
        s.a(aTSharedPlacementConfig);
    }

    public static void setSupportDomainCountry(String... strArr) {
        b.a = strArr;
    }

    public static void setBundleName(String str) {
        s.b().s(str);
    }

    public static void showGDPRConsentDialog(Activity activity, ATGDPRConsentDismissListener aTGDPRConsentDismissListener) {
        a.a().b(aTGDPRConsentDismissListener);
    }

    public static void showGDPRConsentDialog(Activity activity, ATGDPRConsentDismissListener aTGDPRConsentDismissListener, String str) {
        a.a().b(aTGDPRConsentDismissListener);
    }

    public static void showGDPRConsentSecondDialog(Activity activity, ATGDPRConsentDismissListener aTGDPRConsentDismissListener, String str) {
        a.a().a(aTGDPRConsentDismissListener);
    }

    public static void setAllowedShowNetworkFirmIdList(String str, List<String> list) {
        s.b().c(str, list);
    }

    public static void setForbidShowNetworkFirmIdList(String str, List<String> list) {
        s.b().d(str, list);
    }

    public static void setForbidNetworkFirmIdList(List<String> list) {
        s.b().b(list);
    }

    public static void putFilter(String str, ATAdFilter aTAdFilter) {
        s.b().a(str, aTAdFilter);
    }

    public static void removeFilters() {
        s.b().aa();
    }

    public static void removeFilterWithPlacementId(String str) {
        s.b().t(str);
    }

    public static void setDeviceInformationData(Map<String, Object> map) {
        s.b().c(map);
    }
}
