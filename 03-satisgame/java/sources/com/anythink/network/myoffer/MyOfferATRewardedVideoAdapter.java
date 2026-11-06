package com.anythink.network.myoffer;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.network.adx.AdxATInitManager;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMRewardVideoListener;
import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferRewardedVideoAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MyOfferATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    SDMMyOfferRewardedVideoAd b;
    String c;
    private String a = "";
    private Map<String, Object> d = new HashMap();

    class a implements MediationInitCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;

        /* JADX INFO: renamed from: com.anythink.network.myoffer.MyOfferATRewardedVideoAdapter$a$a, reason: collision with other inner class name */
        class C0074a implements SDMRewardVideoListener {
            C0074a() {
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdClick() {
                if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdClose() {
                if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdLoadFail(AdError adError) {
                MyOfferATRewardedVideoAdapter.this.notifyATLoadFail(adError.getCode(), adError.getMessage());
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdLoaded() {
                if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdPlayEnd() {
                if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdPlayFailed(AdError adError) {
                if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayFailed(adError.getCode(), adError.getMessage());
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdPlayStart() {
                if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onAdReward() {
                if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener.onReward();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMRewardVideoListener
            public void onDeeplinkCallback(boolean z) {
                if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener.onDeeplinkCallback(z);
                }
            }
        }

        a(Context context, Map map) {
            this.a = context;
            this.b = map;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            MyOfferATRewardedVideoAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            MyOfferATRewardedVideoAdapter.this.b = new SDMMyOfferRewardedVideoAd(this.a, MyOfferATRewardedVideoAdapter.this.c);
            SDMAdRequest sDMAdRequestBuild = new SDMAdRequest.Builder().setExtraMap(this.b).setCustomEventMap(MyOfferATRewardedVideoAdapter.this.d).build();
            MyOfferATRewardedVideoAdapter.this.b.setListener(new C0074a());
            MyOfferATRewardedVideoAdapter.this.b.load(sDMAdRequestBuild);
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return AdxATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        SDMMyOfferRewardedVideoAd sDMMyOfferRewardedVideoAd = this.b;
        if (sDMMyOfferRewardedVideoAd != null) {
            sDMMyOfferRewardedVideoAd.destroy();
            this.b = null;
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        SDMMyOfferRewardedVideoAd sDMMyOfferRewardedVideoAd = this.b;
        if (sDMMyOfferRewardedVideoAd != null) {
            return sDMMyOfferRewardedVideoAd.getExtraInfoMap();
        }
        return null;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkName() {
        return "MyOffer";
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return AdxATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.d.put(SDMAdConst.EXTRA_PARAMS.E_L_PARAMS, 1);
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean isAdReady() {
        SDMMyOfferRewardedVideoAd sDMMyOfferRewardedVideoAd = this.b;
        if (sDMMyOfferRewardedVideoAd != null) {
            return sDMMyOfferRewardedVideoAd.isAdReady();
        }
        return false;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "my_oid", "");
        String stringFromMap = ATInitMediation.getStringFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_PLACEMENT_ID);
        this.c = stringFromMap;
        if (TextUtils.isEmpty(stringFromMap)) {
            notifyATLoadFail("", "placement id is empty");
        } else {
            AdxATInitManager.getInstance().initSDK(context, map, new a(context, map));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        if (this.b != null) {
            this.d.put("extra_scenario", this.mScenario);
            this.b.show(activity);
        } else {
            CustomRewardedVideoEventListener customRewardedVideoEventListener = this.mImpressionListener;
            if (customRewardedVideoEventListener != null) {
                customRewardedVideoEventListener.onRewardedVideoAdPlayFailed("-1", "sdmRewardedVideoAd is empty");
            }
        }
    }
}
