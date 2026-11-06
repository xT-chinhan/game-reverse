package com.anythink.network.tap;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingListenerExt;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATCustomLoadListenerExt;
import com.anythink.core.api.ATDeviceUtils;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.e.f;
import com.anythink.core.common.k;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.TapAdCustomController;
import com.tapsdk.tapad.TapAdSdk;
import com.taptap.sdk.db.constant.Common;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TapATInitManager extends ATInitMediation {
    public static final String ORIENTATION_KEY = "orientation";
    private static final String a = "space_id";
    private static final String b = "media_id";
    private static final String c = "media_name";
    private static final String d = "media_secret_key";
    private static volatile TapATInitManager e;
    private TapAdCustomController f;
    private volatile boolean g = false;
    private boolean h = false;

    @Override // com.anythink.core.api.ATInitMediation
    public String getAdapterVersion() {
        return "UA_6.5.10";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "TapADN";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.tapsdk.tapad.TapAdSdk";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return "3.16.3.45";
    }

    public static TapATInitManager getInstance() {
        if (e == null) {
            synchronized (TapATInitManager.class) {
                if (e == null) {
                    e = new TapATInitManager();
                }
            }
        }
        return e;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public synchronized void initSDK(final Context context, final Map<String, Object> map, final MediationInitCallback mediationInitCallback) {
        runOnMainThread(new Runnable() { // from class: com.anythink.network.tap.TapATInitManager.1
            @Override // java.lang.Runnable
            public final void run() {
                TapATInitManager.a(TapATInitManager.this, context, map, mediationInitCallback);
            }
        });
    }

    private void a(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        if (this.g) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        if (map == null) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onFail("Tap initialization failed, serviceExtras is null.");
                return;
            }
            return;
        }
        int intFromMap = getIntFromMap(map, "media_id");
        String stringFromMap = getStringFromMap(map, c);
        String stringFromMap2 = getStringFromMap(map, d);
        if (intFromMap == 0 || TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            if (mediationInitCallback != null) {
                String str = "Tap initialization parameter error. mediaId: " + intFromMap + " mediaName: " + stringFromMap + " mediaKey: " + stringFromMap2;
                mediationInitCallback.onFail(str);
                Log.e("TapATInitManager", str);
                return;
            }
            return;
        }
        TapAdConfig.Builder builderWithData = new TapAdConfig.Builder().withMediaId(intFromMap).withMediaName(stringFromMap).withMediaKey(stringFromMap2).withMediaVersion("1").withGameChannel("TopOn").withData(a());
        TapAdCustomController tapAdCustomController = this.f;
        if (tapAdCustomController != null) {
            builderWithData.withCustomController(tapAdCustomController);
        } else {
            builderWithData.withCustomController(new AnonymousClass2());
        }
        builderWithData.enableDebug(ATSDK.isNetworkLogDebug());
        Boolean boolIsShakeEnabled = ATSDKGlobalSetting.isShakeEnabled(69);
        if (boolIsShakeEnabled != null) {
            builderWithData.shakeEnabled(boolIsShakeEnabled.booleanValue());
        }
        try {
            TapAdSdk.init(context, builderWithData.build());
            this.g = true;
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
            }
        } catch (Exception e2) {
            this.g = false;
            Log.e("TapATInitManager", "initSDK() failed: " + e2.getMessage());
            if (mediationInitCallback != null) {
                mediationInitCallback.onFail("Tap initSDK() failed: " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.tap.TapATInitManager$2, reason: invalid class name */
    final class AnonymousClass2 extends TapAdCustomController {
        AnonymousClass2() {
        }

        @Override // com.tapsdk.tapad.TapAdCustomController
        public final String getDevOaid() {
            return ATDeviceUtils.getOaid();
        }
    }

    public void enableOaidStrictMode(boolean z) {
        this.h = z;
    }

    private String a() {
        try {
            boolean z = ATSDK.getPersionalizedAdStatus() == 2;
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Common.System.NAME, "personal_ads_type");
            jSONObject.put(f.a.d, z ? "0" : "1");
            if (this.h) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(Common.System.NAME, "enable_oaid_strict_mode");
                jSONObject2.put(f.a.d, 1);
                jSONArray.put(jSONObject2);
            }
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public Map<String, Boolean> getPluginClassStatus() {
        HashMap map = new HashMap();
        map.put("rxjava-*.jar", Boolean.FALSE);
        map.put("rxandroid-*.jar", Boolean.FALSE);
        map.put("okhttp-*.jar", Boolean.FALSE);
        map.put("okio-*.jar", Boolean.FALSE);
        map.put("glide-*.aar", Boolean.FALSE);
        map.put("gifdecoder-*.jar", Boolean.FALSE);
        map.put("disklrucache-*.jar", Boolean.FALSE);
        try {
            map.put("glide-*.aar", Boolean.TRUE);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            map.put("gifdecoder-*.jar", Boolean.TRUE);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            map.put("disklrucache-*.jar", Boolean.TRUE);
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        try {
            map.put("rxjava-*.jar", Boolean.TRUE);
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        try {
            map.put("rxandroid-*.jar", Boolean.TRUE);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        try {
            map.put("okhttp-*.jar", Boolean.TRUE);
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
        try {
            map.put("okio-*.jar", Boolean.TRUE);
        } catch (Throwable th7) {
            th7.printStackTrace();
        }
        return map;
    }

    public void setTapAdCustomController(TapAdCustomController tapAdCustomController) {
        this.f = tapAdCustomController;
    }

    public int getSpaceId(Map<String, Object> map) {
        return getIntFromMap(map, "space_id");
    }

    public AdRequest getAdRequest(int i, Map<String, Object> map) {
        AdRequest.Builder builderWithSpaceId = new AdRequest.Builder().withSpaceId(i);
        if (map != null) {
            String stringFromMap = getStringFromMap(map, ATAdConst.KEY.USER_CUSTOM_DATA);
            String stringFromMap2 = getStringFromMap(map, "user_id");
            String stringFromMap3 = getStringFromMap(map, "reward_name");
            int intFromMap = getIntFromMap(map, "reward_amount", -1);
            int intFromMap2 = getIntFromMap(map, ATAdConst.KEY.AD_WIDTH, -1);
            int intFromMap3 = getIntFromMap(map, ATAdConst.KEY.AD_HEIGHT, -1);
            if (!TextUtils.isEmpty(stringFromMap)) {
                builderWithSpaceId.withExtra1(stringFromMap);
            }
            if (!TextUtils.isEmpty(stringFromMap3)) {
                builderWithSpaceId.withRewardName(stringFromMap3);
            }
            if (!TextUtils.isEmpty(stringFromMap2)) {
                builderWithSpaceId.withUserId(stringFromMap2);
            }
            if (intFromMap != -1) {
                builderWithSpaceId.withRewardAmount(intFromMap);
            }
            if (intFromMap2 != -1 && intFromMap3 != -1) {
                builderWithSpaceId.withExpressViewAcceptedSize(intFromMap2, intFromMap3);
            }
        }
        return builderWithSpaceId.build();
    }

    public void handleAdLoadedCallback(boolean z, Object obj, Map<String, Object> map, ATBiddingListener aTBiddingListener, ATCustomLoadListener aTCustomLoadListener, BaseAd... baseAdArr) {
        if (!z) {
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(baseAdArr);
                return;
            }
            return;
        }
        BaseAd baseAd = (baseAdArr == null || baseAdArr.length <= 0) ? null : baseAdArr[0];
        int intFromMap = getIntFromMap(map, k.J, -1);
        int intFromMap2 = getIntFromMap(map, "bid_price", 0);
        if (aTBiddingListener == null) {
            return;
        }
        if (intFromMap == 0) {
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(intFromMap2, new StringBuilder().append(System.currentTimeMillis()).toString(), new TapATBiddingNotice(obj), ATAdConst.CURRENCY.RMB_CENT), baseAd);
        } else if (intFromMap == 1) {
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(ATBidRequestInfo.BID_TYPE_ERROR_TYPE), null);
        } else {
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("bid type error, bidType: ".concat(String.valueOf(intFromMap))), null);
        }
    }

    public void handleAdDataLoadedCallback(boolean z, Map<String, Object> map, ATBiddingListener aTBiddingListener, ATCustomLoadListener aTCustomLoadListener, BaseAd... baseAdArr) {
        if (z) {
            BaseAd baseAd = (baseAdArr == null || baseAdArr.length <= 0) ? null : baseAdArr[0];
            int intFromMap = getIntFromMap(map, k.J, -1);
            int intFromMap2 = getIntFromMap(map, "bid_price", 0);
            if (aTBiddingListener instanceof ATBiddingListenerExt) {
                if (intFromMap == 0) {
                    ((ATBiddingListenerExt) aTBiddingListener).onC2SBiddingResultWithData(ATBiddingResult.success(intFromMap2, new StringBuilder().append(System.currentTimeMillis()).toString(), null, ATAdConst.CURRENCY.RMB_CENT), baseAd);
                    return;
                } else if (intFromMap == 1) {
                    ((ATBiddingListenerExt) aTBiddingListener).onC2SBiddingResultWithData(ATBiddingResult.fail(ATBidRequestInfo.BID_TYPE_ERROR_TYPE), null);
                    return;
                } else {
                    ((ATBiddingListenerExt) aTBiddingListener).onC2SBiddingResultWithData(ATBiddingResult.fail("bid type error, bidType: ".concat(String.valueOf(intFromMap))), null);
                    return;
                }
            }
            return;
        }
        if (aTCustomLoadListener instanceof ATCustomLoadListenerExt) {
            ((ATCustomLoadListenerExt) aTCustomLoadListener).onAdDataLoadedWithAds(baseAdArr);
        }
    }

    static /* synthetic */ void a(TapATInitManager tapATInitManager, Context context, Map map, MediationInitCallback mediationInitCallback) {
        if (tapATInitManager.g) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        if (map == null) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onFail("Tap initialization failed, serviceExtras is null.");
                return;
            }
            return;
        }
        int intFromMap = getIntFromMap(map, "media_id");
        String stringFromMap = getStringFromMap(map, c);
        String stringFromMap2 = getStringFromMap(map, d);
        if (intFromMap == 0 || TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            if (mediationInitCallback != null) {
                String str = "Tap initialization parameter error. mediaId: " + intFromMap + " mediaName: " + stringFromMap + " mediaKey: " + stringFromMap2;
                mediationInitCallback.onFail(str);
                Log.e("TapATInitManager", str);
                return;
            }
            return;
        }
        TapAdConfig.Builder builderWithData = new TapAdConfig.Builder().withMediaId(intFromMap).withMediaName(stringFromMap).withMediaKey(stringFromMap2).withMediaVersion("1").withGameChannel("TopOn").withData(tapATInitManager.a());
        TapAdCustomController tapAdCustomController = tapATInitManager.f;
        if (tapAdCustomController != null) {
            builderWithData.withCustomController(tapAdCustomController);
        } else {
            builderWithData.withCustomController(tapATInitManager.new AnonymousClass2());
        }
        builderWithData.enableDebug(ATSDK.isNetworkLogDebug());
        Boolean boolIsShakeEnabled = ATSDKGlobalSetting.isShakeEnabled(69);
        if (boolIsShakeEnabled != null) {
            builderWithData.shakeEnabled(boolIsShakeEnabled.booleanValue());
        }
        try {
            TapAdSdk.init(context, builderWithData.build());
            tapATInitManager.g = true;
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
            }
        } catch (Exception e2) {
            tapATInitManager.g = false;
            Log.e("TapATInitManager", "initSDK() failed: " + e2.getMessage());
            if (mediationInitCallback != null) {
                mediationInitCallback.onFail("Tap initSDK() failed: " + e2.getMessage());
            }
        }
    }
}
