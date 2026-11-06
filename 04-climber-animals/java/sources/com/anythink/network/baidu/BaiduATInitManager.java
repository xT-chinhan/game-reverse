package com.anythink.network.baidu;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingListenerExt;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATCustomLoadListenerExt;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.d.j;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.SplashAd;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class BaiduATInitManager extends ATInitMediation {
    protected static final String d = "AT_BAIDU_C2S_";
    private static final String e = "BaiduATInitManager";
    private static volatile BaiduATInitManager f;
    Map<String, Map<String, BaiduATBiddingInfo>> a;
    private BDAdConfig.Builder g;
    private String h;
    private boolean i;
    boolean b = false;
    int c = 0;
    private final Object j = new Object();

    public interface InitCallback {
        void onError(Throwable th);

        void onSuccess();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getAdapterVersion() {
        return "UA_6.5.10";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Baidu";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.baidu.mobads.sdk.api.BDAdConfig";
    }

    private BaiduATInitManager() {
    }

    public static BaiduATInitManager getInstance() {
        if (f == null) {
            synchronized (BaiduATInitManager.class) {
                if (f == null) {
                    f = new BaiduATInitManager();
                }
            }
        }
        return f;
    }

    public void setBaiduATCustomController(BaiduATCustomController baiduATCustomController) {
        if (baiduATCustomController != null) {
            MobadsPermissionSettings.setPermissionReadDeviceID(baiduATCustomController.getPermissionReadDeviceID());
            MobadsPermissionSettings.setPermissionLocation(baiduATCustomController.getPermissionLocation());
            MobadsPermissionSettings.setPermissionStorage(baiduATCustomController.getPermissionStorage());
            MobadsPermissionSettings.setPermissionAppList(baiduATCustomController.getPermissionAppList());
            MobadsPermissionSettings.setPermissionOAID(baiduATCustomController.getPermissionOAID());
            MobadsPermissionSettings.setPermissionDeviceInfo(baiduATCustomController.getPermissionDeviceInfo());
            MobadsPermissionSettings.setPermissionAppUpdate(baiduATCustomController.getPermissionAppUpdate());
            MobadsPermissionSettings.setPermissionRunningApp(baiduATCustomController.getPermissionRunningApp());
            this.b = true;
        }
    }

    public void initSDK(Context context, Map<String, Object> map) {
        initSDK(context, map, null);
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        initSDK(context, map, false, mediationInitCallback);
    }

    public void setBDAdConfigBuilder(BDAdConfig.Builder builder) {
        this.g = builder;
    }

    public String getApp_id() {
        return this.h;
    }

    public void initSDK(Context context, Map<String, Object> map, boolean z, MediationInitCallback mediationInitCallback) {
        try {
            this.c = ATSDK.getPersionalizedAdStatus();
        } catch (Throwable unused) {
        }
        MobadsPermissionSettings.setLimitPersonalAds(this.c == 2);
        if (!this.b) {
            MobadsPermissionSettings.setPermissionReadDeviceID(true);
            MobadsPermissionSettings.setPermissionOAID(true);
            MobadsPermissionSettings.setPermissionAppList(true);
            MobadsPermissionSettings.setPermissionStorage(true);
            MobadsPermissionSettings.setPermissionLocation(true);
        }
        if (ATSDK.isNetworkLogDebug()) {
            Log.i("BaiduATInitManager", "MobadsPermissionSettings.getLimitPersonalAdsStatus():" + MobadsPermissionSettings.getLimitPersonalAdsStatus());
        }
        if (this.i) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        synchronized (this.j) {
            if (this.i) {
                if (mediationInitCallback != null) {
                    mediationInitCallback.onSuccess();
                }
                return;
            }
            this.h = (String) map.get("app_id");
            try {
                Object obj = map.get(ATAdConst.KEY.WECHAT_APPID);
                String string = obj != null ? obj.toString() : "";
                if (this.g == null) {
                    this.g = new BDAdConfig.Builder();
                }
                this.g.setAppsid(this.h);
                if (!TextUtils.isEmpty(string)) {
                    this.g.setWXAppid(string);
                }
                this.g.build(context).init();
                this.i = true;
                if (mediationInitCallback != null) {
                    mediationInitCallback.onSuccess();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (mediationInitCallback != null) {
                    mediationInitCallback.onFail(th.getMessage());
                }
            }
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return BaiduATConst.getNetworkVersion();
    }

    private synchronized String a(String str, Object obj, double d2, Object obj2) {
        String str2;
        if (this.a == null) {
            this.a = new ConcurrentHashMap(3);
        }
        Map<String, BaiduATBiddingInfo> concurrentHashMap = this.a.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>(2);
            this.a.put(str, concurrentHashMap);
        }
        str2 = d + UUID.randomUUID().toString();
        concurrentHashMap.put(str2, new BaiduATBiddingInfo(obj, d2, obj2));
        return str2;
    }

    private synchronized BaiduATBiddingInfo a(String str, String str2) {
        Map<String, BaiduATBiddingInfo> map;
        Map<String, Map<String, BaiduATBiddingInfo>> map2 = this.a;
        if (map2 == null || (map = map2.get(str)) == null) {
            return null;
        }
        return map.remove(str2);
    }

    private synchronized void b(String str, String str2) {
        Map<String, BaiduATBiddingInfo> map;
        Map<String, Map<String, BaiduATBiddingInfo>> map2 = this.a;
        if (map2 != null && (map = map2.get(str)) != null) {
            map.remove(str2);
        }
    }

    private static void a(String str, RequestParameters.Builder builder, Map<String, Object> map) {
        try {
            Object obj = map.get(BaiduATConst.REQUEST_PARAMS_CUST_EXT);
            if (obj != null && (obj instanceof Map)) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    try {
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        if ((key instanceof String) && (value instanceof String)) {
                            if (ATSDK.isNetworkLogDebug()) {
                                Log.i(e, "placementId=" + str + ", addCustExt: " + key + " - " + value);
                            }
                            builder.addCustExt((String) key, (String) value);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Object obj2 = map.get(BaiduATConst.REQUEST_PARAMS_EXT);
            if (obj2 == null || !(obj2 instanceof Map)) {
                return;
            }
            for (Map.Entry entry2 : ((Map) obj2).entrySet()) {
                try {
                    Object key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if ((key2 instanceof String) && (value2 instanceof String)) {
                        if (ATSDK.isNetworkLogDebug()) {
                            Log.i(e, "placementId=" + str + ", addExtra: " + key2 + " - " + value2);
                        }
                        builder.addExtra((String) key2, (String) value2);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private static void b(String str, RequestParameters.Builder builder, Map<String, Object> map) {
        int intFromMap = getIntFromMap(map, j.w.u, -1);
        int intFromMap2 = getIntFromMap(map, j.w.v, -1);
        int intFromMap3 = getIntFromMap(map, j.w.w, -1);
        int intFromMap4 = getIntFromMap(map, j.w.x, -1);
        if (intFromMap != -1) {
            builder.addCustExt("A", String.valueOf(intFromMap));
        }
        if (intFromMap2 != -1) {
            builder.addCustExt("B", String.valueOf(intFromMap2));
        }
        if (intFromMap3 != -1) {
            builder.addCustExt("C", String.valueOf(intFromMap3));
        }
        if (intFromMap4 != -1) {
            builder.addCustExt("S", String.valueOf(intFromMap4));
        }
        map.toString();
    }

    static void a(boolean z, Object obj, ATCustomLoadListener aTCustomLoadListener, ATBiddingListener aTBiddingListener) {
        double d2;
        try {
            if (z) {
                String eCPMLevel = "";
                if (obj instanceof RewardVideoAd) {
                    eCPMLevel = ((RewardVideoAd) obj).getECPMLevel();
                } else if (obj instanceof FullScreenVideoAd) {
                    eCPMLevel = ((FullScreenVideoAd) obj).getECPMLevel();
                } else if (obj instanceof ExpressInterstitialAd) {
                    eCPMLevel = ((ExpressInterstitialAd) obj).getECPMLevel();
                } else if (obj instanceof SplashAd) {
                    eCPMLevel = ((SplashAd) obj).getECPMLevel();
                }
                if (TextUtils.isEmpty(eCPMLevel)) {
                    eCPMLevel = "0";
                }
                try {
                    d2 = Double.parseDouble(eCPMLevel);
                } catch (Throwable th) {
                    th.printStackTrace();
                    d2 = 0.0d;
                }
                if (aTBiddingListener instanceof ATBiddingListenerExt) {
                    ((ATBiddingListenerExt) aTBiddingListener).onC2SBiddingResultWithData(ATBiddingResult.success(d2, new StringBuilder().append(System.currentTimeMillis()).toString(), new BaiduATBiddingNotice(obj), ATAdConst.CURRENCY.RMB_CENT), null);
                    return;
                }
                return;
            }
            if (aTCustomLoadListener instanceof ATCustomLoadListenerExt) {
                ((ATCustomLoadListenerExt) aTCustomLoadListener).onAdDataLoadedWithAds(new BaseAd[0]);
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    protected static void a(String str, RequestParameters.Builder builder, Map<String, Object> map, Map<String, Object> map2) {
        Object obj = map2.get(BaiduATConst.REQUEST_PARAMS_CUST_EXT);
        if (obj != null && (obj instanceof Map)) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                try {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if ((key instanceof String) && (value instanceof String)) {
                        if (ATSDK.isNetworkLogDebug()) {
                            Log.i(e, "placementId=" + str + ", addCustExt: " + key + " - " + value);
                        }
                        builder.addCustExt((String) key, (String) value);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        try {
            Object obj2 = map2.get(BaiduATConst.REQUEST_PARAMS_EXT);
            if (obj2 != null && (obj2 instanceof Map)) {
                for (Map.Entry entry2 : ((Map) obj2).entrySet()) {
                    try {
                        Object key2 = entry2.getKey();
                        Object value2 = entry2.getValue();
                        if ((key2 instanceof String) && (value2 instanceof String)) {
                            if (ATSDK.isNetworkLogDebug()) {
                                Log.i(e, "placementId=" + str + ", addExtra: " + key2 + " - " + value2);
                            }
                            builder.addExtra((String) key2, (String) value2);
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        int intFromMap = getIntFromMap(map, j.w.u, -1);
        int intFromMap2 = getIntFromMap(map, j.w.v, -1);
        int intFromMap3 = getIntFromMap(map, j.w.w, -1);
        int intFromMap4 = getIntFromMap(map, j.w.x, -1);
        if (intFromMap != -1) {
            builder.addCustExt("A", String.valueOf(intFromMap));
        }
        if (intFromMap2 != -1) {
            builder.addCustExt("B", String.valueOf(intFromMap2));
        }
        if (intFromMap3 != -1) {
            builder.addCustExt("C", String.valueOf(intFromMap3));
        }
        if (intFromMap4 != -1) {
            builder.addCustExt("S", String.valueOf(intFromMap4));
        }
        map.toString();
    }
}
