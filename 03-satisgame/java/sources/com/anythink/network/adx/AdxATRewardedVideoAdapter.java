package com.anythink.network.adx;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.rewardvideo.api.ATRewardRetryTaskInfo;
import com.anythink.rewardvideo.api.ATRewardRetryTaskManager;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMAd;
import com.smartdigimkt.sdk.api.format.SDMAdDeepRewardResult;
import com.smartdigimkt.sdk.api.format.SDMAdDeepRewardResultListener;
import com.smartdigimkt.sdk.api.format.SDMRewardVideoListener;
import com.smartdigimkt.sdk.api.format.SDMRewardedVideoAd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdxATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    private static final String g = "AdxATRewardedVideoAdapter";
    SDMRewardedVideoAd a;
    String b;
    private Map<String, Object> d;
    private String e;
    private Map<String, Object> c = new HashMap();
    private boolean f = false;

    class a implements MediationInitCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;

        /* JADX INFO: renamed from: com.anythink.network.adx.AdxATRewardedVideoAdapter$a$a, reason: collision with other inner class name */
        class C0065a implements SDMRewardVideoListener {
            C0065a() {
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdClick() {
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdClose() {
                AdxATRewardRetryTaskContractManager.notifyAdClosedIncompleteRetryReward(AdxATRewardedVideoAdapter.this.e, AdxATRewardedVideoAdapter.this.f);
                AdxATRewardedVideoAdapter.this.b();
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdLoadFail(AdError adError) {
                AdxATRewardedVideoAdapter.this.notifyATLoadFail(adError.getCode(), adError.getMessage());
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdLoaded() {
                SDMAd sDMAd;
                SDMRewardedVideoAd sDMRewardedVideoAd = AdxATRewardedVideoAdapter.this.a;
                if (sDMRewardedVideoAd != null && (sDMAd = sDMRewardedVideoAd.getSDMAd()) != null) {
                    AdxATRewardedVideoAdapter.this.d = AdxATInitManager.getInstance().fillNetworkInfoMap(sDMAd.getExtraInfo(), AdxATRewardedVideoAdapter.this.d);
                }
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdPlayEnd() {
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdPlayFailed(AdError adError) {
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayFailed(adError.getCode(), adError.getMessage());
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdPlayStart() {
                AdxATRewardedVideoAdapter.this.c();
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdReward() {
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onReward();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onDeeplinkCallback(boolean z) {
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onDeeplinkCallback(z);
                }
            }
        }

        a(Context context, Map map) {
            this.a = context;
            this.b = map;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            AdxATRewardedVideoAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            AdxATRewardedVideoAdapter.this.a = new SDMRewardedVideoAd(this.a, AdxATRewardedVideoAdapter.this.b);
            SDMAdRequest sDMAdRequestBuild = new SDMAdRequest.Builder().setExtraMap(this.b).setCustomEventMap(AdxATRewardedVideoAdapter.this.c).build();
            AdxATRewardedVideoAdapter.this.a.setListener(new C0065a());
            AdxATRewardedVideoAdapter.this.a();
            AdxATRewardedVideoAdapter.this.a.load(sDMAdRequestBuild);
        }
    }

    class b implements SDMAdDeepRewardResultListener {
        b() {
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMAdDeepRewardResultListener
        public void onError(int i, String str) {
            String str2 = AdxATRewardedVideoAdapter.this.e;
            boolean z = AdxATRewardedVideoAdapter.this.f;
            if (str == null) {
                str = "";
            }
            AdxATRewardRetryTaskContractManager.notifyRetryRewardResultFailed(str2, z, i, str);
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMAdDeepRewardResultListener
        public void onSuccess(List<SDMAdDeepRewardResult> list) {
            AdxATRewardRetryTaskContractManager.notifyRetryRewardResult(AdxATRewardedVideoAdapter.this.e, AdxATRewardedVideoAdapter.this.f);
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return AdxATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        if (this.a != null) {
            AdxATRewardRetryTaskContractManager.clearPendingRetryRewardQueryIfSession(this.e);
            b();
            this.a.destroy();
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter
    public Map<String, Object> getAdExtraInfoMap() {
        return this.c;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        AdxATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, false);
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.d;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkName() {
        return AdxATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return AdxATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.c.put(SDMAdConst.EXTRA_PARAMS.E_L_PARAMS, 1);
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean isAdReady() {
        SDMRewardedVideoAd sDMRewardedVideoAd = this.a;
        if (sDMRewardedVideoAd != null) {
            return sDMRewardedVideoAd.isAdReady();
        }
        return false;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_PLACEMENT_ID);
        this.b = stringFromMap;
        if (TextUtils.isEmpty(stringFromMap)) {
            notifyATLoadFail("", "placement id is empty");
        } else {
            Context applicationContext = context.getApplicationContext();
            AdxATInitManager.getInstance().initSDK(applicationContext, map, new a(applicationContext, map));
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdInternalAdapter
    public void notifyWLInfo(int i, Map<String, Object> map) {
        AdxATInitManager.getInstance().notifyWLInfo(i, map, this.a);
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        if (this.a != null) {
            this.c.put("extra_scenario", this.mScenario);
            this.a.show(activity);
        } else {
            CustomRewardedVideoEventListener customRewardedVideoEventListener = this.mImpressionListener;
            if (customRewardedVideoEventListener != null) {
                customRewardedVideoEventListener.onRewardedVideoAdPlayFailed("-1", "sdmRewardedVideoAd is empty");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.e = null;
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        SDMRewardedVideoAd sDMRewardedVideoAd = this.a;
        if (sDMRewardedVideoAd == null) {
            return;
        }
        try {
            ATRewardRetryTaskInfo aTRewardRetryTaskInfoA = a(sDMRewardedVideoAd.getSDMAd().getExtraInfo(), String.valueOf(66), this.a.getSDMAd().getPlaceInfo().getRequestId());
            if (aTRewardRetryTaskInfoA.getConvertType() <= 0) {
                aTRewardRetryTaskInfoA.getConvertType();
                return;
            }
            this.f = true;
            this.e = aTRewardRetryTaskInfoA.getRequestId();
            ATRewardRetryTaskManager.getInstance().notifyATRewardRetryTask(aTRewardRetryTaskInfoA);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        SDMRewardedVideoAd sDMRewardedVideoAd = this.a;
        if (sDMRewardedVideoAd == null) {
            return;
        }
        sDMRewardedVideoAd.setDeepRewardListener(new b());
    }

    private ATRewardRetryTaskInfo a(Map<String, Object> map, String str, String str2) {
        ATRewardRetryTaskInfo aTRewardRetryTaskInfo = new ATRewardRetryTaskInfo();
        if (str == null) {
            str = String.valueOf(66);
        }
        aTRewardRetryTaskInfo.setFirmId(str);
        if (!TextUtils.isEmpty(str2)) {
            aTRewardRetryTaskInfo.setRequestId(str2);
        }
        Object obj = map.get(SDMAdDeepRewardResult.KEY_TASK_TYPE);
        try {
            if ((obj instanceof Integer) && ((Integer) obj).intValue() == 1) {
                aTRewardRetryTaskInfo.setConvertType(6006104);
            }
        } catch (Throwable unused) {
        }
        return aTRewardRetryTaskInfo;
    }
}
