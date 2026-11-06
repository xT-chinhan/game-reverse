package com.anythink.network.adx;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.banner.unitgroup.api.CustomBannerEventListener;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMAd;
import com.smartdigimkt.sdk.api.format.SDMBannerListener;
import com.smartdigimkt.sdk.api.format.SDMBannerView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdxATBannerAdapter extends CustomBannerAdapter {
    SDMBannerView a;
    String b;
    private Map<String, Object> c = new HashMap();
    private Map<String, Object> d;

    class a implements MediationInitCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;
        final /* synthetic */ Map c;

        /* JADX INFO: renamed from: com.anythink.network.adx.AdxATBannerAdapter$a$a, reason: collision with other inner class name */
        class C0063a implements SDMBannerListener {
            C0063a() {
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMBannerListener
            public void onAdClick() {
                CustomBannerEventListener customBannerEventListener = AdxATBannerAdapter.this.mImpressionEventListener;
                if (customBannerEventListener != null) {
                    customBannerEventListener.onBannerAdClicked();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMBannerListener
            public void onAdClose() {
                CustomBannerEventListener customBannerEventListener = AdxATBannerAdapter.this.mImpressionEventListener;
                if (customBannerEventListener != null) {
                    customBannerEventListener.onBannerAdClose();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMBannerListener
            public void onAdLoadFail(AdError adError) {
                AdxATBannerAdapter.this.notifyATLoadFail(adError.getCode(), adError.getMessage());
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMBannerListener
            public void onAdLoaded() {
                SDMAd sDMAd;
                SDMBannerView sDMBannerView = AdxATBannerAdapter.this.a;
                if (sDMBannerView != null && (sDMAd = sDMBannerView.getSDMAd()) != null) {
                    AdxATBannerAdapter.this.d = AdxATInitManager.getInstance().fillNetworkInfoMap(sDMAd.getExtraInfo(), AdxATBannerAdapter.this.d);
                }
                if (((CustomBannerAdapter) AdxATBannerAdapter.this).mLoadListener != null) {
                    ((CustomBannerAdapter) AdxATBannerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMBannerListener
            public void onAdShow() {
                CustomBannerEventListener customBannerEventListener = AdxATBannerAdapter.this.mImpressionEventListener;
                if (customBannerEventListener != null) {
                    customBannerEventListener.onBannerAdShow();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMBannerListener
            public void onDeeplinkCallback(boolean z) {
                CustomBannerEventListener customBannerEventListener = AdxATBannerAdapter.this.mImpressionEventListener;
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
            AdxATBannerAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            AdxATBannerAdapter.this.a = new SDMBannerView(this.a);
            AdxATBannerAdapter adxATBannerAdapter = AdxATBannerAdapter.this;
            adxATBannerAdapter.a.setPlacementId(adxATBannerAdapter.b);
            SDMAdRequest sDMAdRequestBuild = new SDMAdRequest.Builder().setExtraMap(this.b).setCustomEventMap(AdxATBannerAdapter.this.c).setAdWidth(ATInitMediation.getIntFromMap(this.c, ATAdConst.KEY.AD_WIDTH, 0)).setAdHeight(ATInitMediation.getIntFromMap(this.c, ATAdConst.KEY.AD_HEIGHT, 0)).setBannerRefresh(false).build();
            AdxATBannerAdapter.this.a.setListener(new C0063a());
            AdxATBannerAdapter.this.a.load(sDMAdRequestBuild);
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return AdxATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        SDMBannerView sDMBannerView = this.a;
        if (sDMBannerView != null) {
            sDMBannerView.destroy();
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter
    public Map<String, Object> getAdExtraInfoMap() {
        return this.c;
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.a;
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

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean isAdReady() {
        SDMBannerView sDMBannerView = this.a;
        if (sDMBannerView != null) {
            return sDMBannerView.isAdReady();
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
            AdxATInitManager.getInstance().initSDK(context, map, new a(context.getApplicationContext(), map, map2));
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdInternalAdapter
    public void notifyWLInfo(int i, Map<String, Object> map) {
        AdxATInitManager.getInstance().notifyWLInfo(i, map, this.a);
    }
}
