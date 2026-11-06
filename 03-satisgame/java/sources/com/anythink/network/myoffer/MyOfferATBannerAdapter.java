package com.anythink.network.myoffer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.banner.unitgroup.api.CustomBannerEventListener;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.network.adx.AdxATInitManager;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMBannerListener;
import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferBannerView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MyOfferATBannerAdapter extends CustomBannerAdapter {
    SDMMyOfferBannerView b;
    String c;
    private String a = "";
    private Map<String, Object> d = new HashMap();

    class a implements MediationInitCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;
        final /* synthetic */ Map c;

        /* JADX INFO: renamed from: com.anythink.network.myoffer.MyOfferATBannerAdapter$a$a, reason: collision with other inner class name */
        class C0072a implements SDMBannerListener {
            C0072a() {
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMBannerListener
            public void onAdClick() {
                CustomBannerEventListener customBannerEventListener = MyOfferATBannerAdapter.this.mImpressionEventListener;
                if (customBannerEventListener != null) {
                    customBannerEventListener.onBannerAdClicked();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMBannerListener
            public void onAdClose() {
                CustomBannerEventListener customBannerEventListener = MyOfferATBannerAdapter.this.mImpressionEventListener;
                if (customBannerEventListener != null) {
                    customBannerEventListener.onBannerAdClose();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMBannerListener
            public void onAdLoadFail(AdError adError) {
                MyOfferATBannerAdapter.this.notifyATLoadFail(adError.getCode(), adError.getMessage());
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMBannerListener
            public void onAdLoaded() {
                if (((CustomBannerAdapter) MyOfferATBannerAdapter.this).mLoadListener != null) {
                    ((CustomBannerAdapter) MyOfferATBannerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMBannerListener
            public void onAdShow() {
                CustomBannerEventListener customBannerEventListener = MyOfferATBannerAdapter.this.mImpressionEventListener;
                if (customBannerEventListener != null) {
                    customBannerEventListener.onBannerAdShow();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMBannerListener
            public void onDeeplinkCallback(boolean z) {
                CustomBannerEventListener customBannerEventListener = MyOfferATBannerAdapter.this.mImpressionEventListener;
                if (customBannerEventListener != null) {
                    customBannerEventListener.onDeeplinkCallback(z);
                }
            }
        }

        a(Context context, Map map, Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            MyOfferATBannerAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            MyOfferATBannerAdapter.this.b = new SDMMyOfferBannerView(this.a);
            MyOfferATBannerAdapter myOfferATBannerAdapter = MyOfferATBannerAdapter.this;
            myOfferATBannerAdapter.b.setPlacementId(myOfferATBannerAdapter.c);
            SDMAdRequest sDMAdRequestBuild = new SDMAdRequest.Builder().setExtraMap(this.b).setCustomEventMap(MyOfferATBannerAdapter.this.d).setAdWidth(ATInitMediation.getIntFromMap(this.c, ATAdConst.KEY.AD_WIDTH, 0)).setAdHeight(ATInitMediation.getIntFromMap(this.c, ATAdConst.KEY.AD_HEIGHT, 0)).setBannerRefresh(false).build();
            MyOfferATBannerAdapter.this.b.setListener(new C0072a());
            MyOfferATBannerAdapter.this.b.load(sDMAdRequestBuild);
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return AdxATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        SDMMyOfferBannerView sDMMyOfferBannerView = this.b;
        if (sDMMyOfferBannerView != null) {
            sDMMyOfferBannerView.destroy();
            this.b = null;
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.b;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        SDMMyOfferBannerView sDMMyOfferBannerView = this.b;
        if (sDMMyOfferBannerView != null) {
            return sDMMyOfferBannerView.getExtraInfoMap();
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
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "my_oid", "");
        String stringFromMap = ATInitMediation.getStringFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_PLACEMENT_ID);
        this.c = stringFromMap;
        if (TextUtils.isEmpty(stringFromMap)) {
            notifyATLoadFail("", "placement id is empty");
        } else {
            AdxATInitManager.getInstance().initSDK(context, map, new a(context, map, map2));
        }
    }
}
