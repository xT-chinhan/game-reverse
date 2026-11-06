package com.anythink.network.myoffer;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.anythink.network.adx.AdxATInitManager;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMInterstitialListener;
import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferInterstitialAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MyOfferATInterstitialAdapter extends CustomInterstitialAdapter {
    SDMMyOfferInterstitialAd b;
    String c;
    private String a = "";
    private Map<String, Object> d = new HashMap();

    class a implements MediationInitCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;

        /* JADX INFO: renamed from: com.anythink.network.myoffer.MyOfferATInterstitialAdapter$a$a, reason: collision with other inner class name */
        class C0073a implements SDMInterstitialListener {
            C0073a() {
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdClick() {
                if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdClose() {
                if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdLoadFail(AdError adError) {
                MyOfferATInterstitialAdapter.this.notifyATLoadFail(adError.getCode(), adError.getMessage());
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdLoaded() {
                if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mLoadListener != null) {
                    ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdShow() {
                if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdShowFail(AdError adError) {
                if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoError(adError.getCode(), adError.getMessage());
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdVideoEnd() {
                if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoEnd();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onAdVideoStart() {
                if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoStart();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMInterstitialListener
            public void onDeeplinkCallback(boolean z) {
                if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener.onDeeplinkCallback(z);
                }
            }
        }

        a(Context context, Map map) {
            this.a = context;
            this.b = map;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            MyOfferATInterstitialAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            MyOfferATInterstitialAdapter.this.b = new SDMMyOfferInterstitialAd(this.a, MyOfferATInterstitialAdapter.this.c);
            SDMAdRequest sDMAdRequestBuild = new SDMAdRequest.Builder().setExtraMap(this.b).setCustomEventMap(MyOfferATInterstitialAdapter.this.d).build();
            MyOfferATInterstitialAdapter.this.b.setListener(new C0073a());
            MyOfferATInterstitialAdapter.this.b.load(sDMAdRequestBuild);
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return AdxATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        SDMMyOfferInterstitialAd sDMMyOfferInterstitialAd = this.b;
        if (sDMMyOfferInterstitialAd != null) {
            sDMMyOfferInterstitialAd.destroy();
            this.b = null;
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        SDMMyOfferInterstitialAd sDMMyOfferInterstitialAd = this.b;
        if (sDMMyOfferInterstitialAd != null) {
            return sDMMyOfferInterstitialAd.getExtraInfoMap();
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
        SDMMyOfferInterstitialAd sDMMyOfferInterstitialAd = this.b;
        if (sDMMyOfferInterstitialAd != null) {
            return sDMMyOfferInterstitialAd.isAdReady();
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

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        if (isAdReady()) {
            this.d.put("extra_scenario", this.mScenario);
            this.b.show(activity);
        }
    }
}
