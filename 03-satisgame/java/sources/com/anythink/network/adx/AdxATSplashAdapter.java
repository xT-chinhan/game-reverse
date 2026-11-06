package com.anythink.network.adx;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMAd;
import com.smartdigimkt.sdk.api.format.SDMSplashAd;
import com.smartdigimkt.sdk.api.format.SDMSplashAdExtraInfo;
import com.smartdigimkt.sdk.api.format.SDMSplashListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdxATSplashAdapter extends CustomSplashAdapter {
    SDMSplashAd a;
    String b;
    private Map<String, Object> c = new HashMap();
    private Map<String, Object> d;
    private Context e;

    class a implements MediationInitCallback {
        final /* synthetic */ Map a;
        final /* synthetic */ Map b;

        /* JADX INFO: renamed from: com.anythink.network.adx.AdxATSplashAdapter$a$a, reason: collision with other inner class name */
        class C0066a implements SDMSplashListener {
            C0066a() {
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdClick() {
                if (((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdClose(SDMSplashAdExtraInfo sDMSplashAdExtraInfo) {
                if (sDMSplashAdExtraInfo != null) {
                    ((CustomSplashAdapter) AdxATSplashAdapter.this).mDismissType = sDMSplashAdExtraInfo.getDismissType();
                }
                if (((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdLoadFail(AdError adError) {
                AdxATSplashAdapter.this.notifyATLoadFail(adError.getCode(), adError.getMessage());
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdLoadTimeout() {
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdLoaded(boolean z) {
                SDMSplashAd sDMSplashAd = AdxATSplashAdapter.this.a;
                if (sDMSplashAd != null) {
                    SDMAd sDMAd = sDMSplashAd.getSDMAd();
                    if (sDMAd != null) {
                        AdxATSplashAdapter.this.d = AdxATInitManager.getInstance().fillNetworkInfoMap(sDMAd.getExtraInfo(), AdxATSplashAdapter.this.d);
                    }
                    if (((CustomSplashAdapter) AdxATSplashAdapter.this).mLoadListener != null) {
                        ((CustomSplashAdapter) AdxATSplashAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    }
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdShow() {
                if (((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener.onSplashAdShow();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdShowFail(AdError adError) {
                if (((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, adError.getCode(), adError.getMessage()));
                    ((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onDeeplinkCallback(boolean z) {
                if (((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener.onDeeplinkCallback(z);
                }
            }
        }

        a(Map map, Map map2) {
            this.a = map;
            this.b = map2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            AdxATSplashAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            AdxATSplashAdapter adxATSplashAdapter = AdxATSplashAdapter.this;
            Context context = AdxATSplashAdapter.this.e;
            AdxATSplashAdapter adxATSplashAdapter2 = AdxATSplashAdapter.this;
            adxATSplashAdapter.a = new SDMSplashAd(context, adxATSplashAdapter2.b, ((CustomSplashAdapter) adxATSplashAdapter2).mFetchAdTimeout);
            SDMAdRequest sDMAdRequestBuild = new SDMAdRequest.Builder().setExtraMap(this.a).setCustomEventMap(AdxATSplashAdapter.this.c).setAdWidth(ATInitMediation.getIntFromMap(this.b, ATAdConst.KEY.AD_WIDTH, 0)).setAdHeight(ATInitMediation.getIntFromMap(this.b, ATAdConst.KEY.AD_HEIGHT, 0)).build();
            AdxATSplashAdapter.this.a.setListener(new C0066a());
            AdxATSplashAdapter.this.a.load(sDMAdRequestBuild);
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return AdxATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        SDMSplashAd sDMSplashAd = this.a;
        if (sDMSplashAd != null) {
            sDMSplashAd.destroy();
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
        SDMSplashAd sDMSplashAd = this.a;
        if (sDMSplashAd != null) {
            return sDMSplashAd.isAdReady();
        }
        return false;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        SDMSplashAd sDMSplashAd = this.a;
        return sDMSplashAd != null && sDMSplashAd.isSupportCustomSkipView();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_PLACEMENT_ID);
        this.b = stringFromMap;
        if (TextUtils.isEmpty(stringFromMap)) {
            notifyATLoadFail("", "placement id is empty");
        } else {
            this.e = context.getApplicationContext();
            AdxATInitManager.getInstance().initSDK(this.e, map, new a(map, map2));
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdInternalAdapter
    public void notifyWLInfo(int i, Map<String, Object> map) {
        AdxATInitManager.getInstance().notifyWLInfo(i, map, this.a);
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (this.a != null) {
            if (isCustomSkipView()) {
                this.c.put(SDMAdConst.EXTRA_PARAMS.SHOW_HIDE_SPLASH_SKIP_VIEW, Boolean.TRUE);
            }
            this.a.show(viewGroup);
        }
    }
}
