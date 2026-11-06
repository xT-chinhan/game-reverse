package com.anythink.network.adx;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMAd;
import com.smartdigimkt.sdk.api.format.SDMInterstitialAd;
import com.smartdigimkt.sdk.api.format.SDMInterstitialListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdxATInterstitialAdapter extends CustomInterstitialAdapter {
    SDMInterstitialAd a;
    String b;
    private Map<String, Object> c = new HashMap();
    private Map<String, Object> d;

    class a implements MediationInitCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;

        /* JADX INFO: renamed from: com.anythink.network.adx.AdxATInterstitialAdapter$a$a, reason: collision with other inner class name */
        class C0064a implements SDMInterstitialListener {
            C0064a() {
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdClick() {
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdClose() {
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdLoadFail(AdError adError) {
                AdxATInterstitialAdapter.this.notifyATLoadFail(adError.getCode(), adError.getMessage());
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdLoaded() {
                SDMAd sDMAd;
                SDMInterstitialAd sDMInterstitialAd = AdxATInterstitialAdapter.this.a;
                if (sDMInterstitialAd != null && (sDMAd = sDMInterstitialAd.getSDMAd()) != null) {
                    AdxATInterstitialAdapter.this.d = AdxATInitManager.getInstance().fillNetworkInfoMap(sDMAd.getExtraInfo(), AdxATInterstitialAdapter.this.d);
                }
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mLoadListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdShow() {
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdShowFail(AdError adError) {
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoError(adError.getCode(), adError.getMessage());
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdVideoEnd() {
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoEnd();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdVideoStart() {
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoStart();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onDeeplinkCallback(boolean z) {
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onDeeplinkCallback(z);
                }
            }
        }

        a(Context context, Map map) {
            this.a = context;
            this.b = map;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            AdxATInterstitialAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            AdxATInterstitialAdapter.this.a = new SDMInterstitialAd(this.a, AdxATInterstitialAdapter.this.b);
            SDMAdRequest sDMAdRequestBuild = new SDMAdRequest.Builder().setExtraMap(this.b).setCustomEventMap(AdxATInterstitialAdapter.this.c).build();
            AdxATInterstitialAdapter.this.a.setListener(new C0064a());
            AdxATInterstitialAdapter.this.a.load(sDMAdRequestBuild);
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return AdxATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        SDMInterstitialAd sDMInterstitialAd = this.a;
        if (sDMInterstitialAd != null) {
            sDMInterstitialAd.destroy();
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
        SDMInterstitialAd sDMInterstitialAd = this.a;
        if (sDMInterstitialAd != null) {
            return sDMInterstitialAd.isAdReady();
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

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        if (this.a != null) {
            this.c.put("extra_scenario", this.mScenario);
            this.a.show(activity);
        } else {
            CustomInterstitialEventListener customInterstitialEventListener = this.mImpressListener;
            if (customInterstitialEventListener != null) {
                customInterstitialEventListener.onInterstitialAdVideoError("-1", "sdmInterstitialAd is empty");
            }
        }
    }
}
