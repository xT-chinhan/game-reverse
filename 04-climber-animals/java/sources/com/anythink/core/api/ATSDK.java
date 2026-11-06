package com.anythink.core.api;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.v;
import com.anythink.core.common.g.b;
import com.anythink.core.common.j.a;
import com.anythink.core.common.m.g;
import com.anythink.core.common.m.q;
import com.anythink.core.common.v.p;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ATSDK {
    private static boolean HAS_INIT = false;
    public static final int NONPERSONALIZED = 1;
    public static final int PERSONALIZED = 0;
    public static final int UNKNOWN = 2;

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
                t.b().a(context, str, str2, aTNetworkConfig);
                if (aTSDKInitListener != null) {
                    aTSDKInitListener.onSuccess();
                }
            }
        } catch (Error | Exception unused) {
        }
    }

    public static void start() {
        t.b().w();
    }

    public static boolean isCnSDK() {
        t.b();
        return true;
    }

    public static void setWXAppId(String str) {
        t.b().a(str);
    }

    public static void setChannel(String str) {
        if (p.a(str)) {
            t.b().e(str);
        }
    }

    public static void setSubChannel(String str) {
        if (p.b(str)) {
            t.b().f(str);
        }
    }

    public static void initCustomMap(Map<String, Object> map) {
        t.b().a(map);
    }

    public static void initPlacementCustomMap(String str, Map<String, Object> map) {
        t.b().a(str, map);
    }

    public static void setExcludePackageList(List<String> list) {
        t.b().a(list);
    }

    public static void setGDPRUploadDataLevel(Context context, int i) {
        if (context == null) {
            Log.e("anythink", "setGDPRUploadDataLevel: context should not be null");
        } else if (i == 0 || i == 1) {
            v.a(context).a(i);
        } else {
            Log.e("anythink", "GDPR level setting error!!! Level must be PERSONALIZED or NONPERSONALIZED.");
        }
    }

    public static void deniedUploadDeviceInfo(String... strArr) {
        t.b().a(strArr);
    }

    public static int getGDPRDataLevel(Context context) {
        return v.a(context).a();
    }

    public static boolean isEUTraffic(Context context) {
        return v.a(context).d();
    }

    public static void checkIsEuTraffic(Context context, NetTrafficeCallback netTrafficeCallback) {
        v.a(context).a(netTrafficeCallback);
    }

    @Deprecated
    public static void showGdprAuth(Context context) {
        v.a(context).a(context, (ATGDPRAuthCallback) null);
    }

    @Deprecated
    public static void showGdprAuth(Context context, ATGDPRAuthCallback aTGDPRAuthCallback) {
        v.a(context).a(context, aTGDPRAuthCallback);
    }

    public static String getSDKVersionName() {
        return p.a();
    }

    public static void setNetworkLogDebug(boolean z) {
        t.b().b(z);
    }

    public static void setChannelSource(int i) {
        t.b().c(i);
    }

    public static boolean isNetworkLogDebug() {
        return t.b().F();
    }

    public static void integrationChecking(Context context) {
        t.b().d(context);
    }

    public static void setAdLogoVisible(boolean z) {
        t.b().c(z);
    }

    public static void setLocation(Location location) {
        t.b().a(location);
    }

    public static void setWXStatus(boolean z) {
        t.b().a(z);
    }

    public static void setFilterAdSourceIdList(String str, List<String> list) {
        t.b().a(str, list);
    }

    public static void setFilterNetworkFirmIdList(String str, List<String> list) {
        t.b().b(str, list);
    }

    public static void setRiskFilterNetworkFirmIdList(int i, List<String> list) {
        t.b().a(i, list);
    }

    public static void registerDeviceRiskListener(IATDeviceRiskListener iATDeviceRiskListener) {
        t.b().a(iATDeviceRiskListener);
    }

    public static void addCustomAdapterConfig(String str, ATCustomAdapterConfig aTCustomAdapterConfig) {
        t.b().a(str, aTCustomAdapterConfig);
    }

    public static void getArea(final ATAreaCallback aTAreaCallback) {
        if (aTAreaCallback == null) {
            return;
        }
        new g().a(0, new q() { // from class: com.anythink.core.api.ATSDK.1
            @Override // com.anythink.core.common.m.q
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.m.q
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

            @Override // com.anythink.core.common.m.q
            public final void onLoadError(int i, String str, AdError adError) {
                aTAreaCallback.onErrorCallback(adError.printStackTrace());
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadCanceled(int i) {
                aTAreaCallback.onErrorCallback("Request cancel");
            }
        });
    }

    public static void testModeDeviceInfo(Context context, DeviceInfoCallback deviceInfoCallback) {
        t.b().a(context, deviceInfoCallback);
    }

    public static void setInitType(int i) {
        t.b().b(i);
    }

    public static void setDebuggerConfig(Context context, String str, ATDebuggerConfig aTDebuggerConfig) {
        t.b().a(context, str, aTDebuggerConfig);
    }

    public static void setPersonalizedAdStatus(int i) {
        t.b().a(i);
    }

    public static int getPersionalizedAdStatus() {
        return t.b().e();
    }

    public static void setUseHTTP(boolean z) {
        t.b().d(z);
    }

    public static void setSystemDevFragmentType(String str) {
        t.b().r(str);
    }

    public static void setATAdFilter(String[] strArr, IATAdFilter iATAdFilter) {
        t.b().a(strArr, iATAdFilter);
    }

    public static void setATUserDeviceInfo(ATUserDeviceInfo aTUserDeviceInfo) {
        t.b().a(aTUserDeviceInfo);
    }

    public static void setLocalStrategyAssetPath(Context context, String str) {
        t.b();
        t.a(context, str);
    }

    public static void setSharedPlacementConfig(ATSharedPlacementConfig aTSharedPlacementConfig) {
        t.b();
        t.a(aTSharedPlacementConfig);
    }

    public static void setSupportDomainCountry(String... strArr) {
        b.a = strArr;
    }

    public static void setBundleName(String str) {
        t.b().s(str);
    }

    public static void showGDPRConsentDialog(Activity activity, ATGDPRConsentDismissListener aTGDPRConsentDismissListener) {
        a.a().a(aTGDPRConsentDismissListener);
    }

    public static void setAllowedShowNetworkFirmIdList(String str, List<String> list) {
        t.b().c(str, list);
    }

    public static void setForbidShowNetworkFirmIdList(String str, List<String> list) {
        t.b().d(str, list);
    }

    public static void setForbidNetworkFirmIdList(List<String> list) {
        t.b().b(list);
    }

    public static void putFilter(String str, ATAdFilter aTAdFilter) {
        t.b().a(str, aTAdFilter);
    }

    public static void removeFilters() {
        t.b().aa();
    }

    public static void removeFilterWithPlacementId(String str) {
        t.b().t(str);
    }
}
