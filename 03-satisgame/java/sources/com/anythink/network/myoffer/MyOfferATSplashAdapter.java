package com.anythink.network.myoffer;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.network.adx.AdxATInitManager;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMSplashAdExtraInfo;
import com.smartdigimkt.sdk.api.format.SDMSplashListener;
import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferSplashAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MyOfferATSplashAdapter extends CustomSplashAdapter {
    SDMMyOfferSplashAd b;
    String c;
    private String a = "";
    private Map<String, Object> d = new HashMap();

    class a implements MediationInitCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;
        final /* synthetic */ Map c;

        /* JADX INFO: renamed from: com.anythink.network.myoffer.MyOfferATSplashAdapter$a$a, reason: collision with other inner class name */
        class C0075a implements SDMSplashListener {
            C0075a() {
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdClick() {
                if (((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdClose(SDMSplashAdExtraInfo sDMSplashAdExtraInfo) {
                if (sDMSplashAdExtraInfo != null) {
                    ((CustomSplashAdapter) MyOfferATSplashAdapter.this).mDismissType = sDMSplashAdExtraInfo.getDismissType();
                }
                if (((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdLoadFail(AdError adError) {
                MyOfferATSplashAdapter.this.notifyATLoadFail(adError.getCode(), adError.getMessage());
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdLoadTimeout() {
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdLoaded(boolean z) {
                if (((CustomSplashAdapter) MyOfferATSplashAdapter.this).mLoadListener != null) {
                    ((CustomSplashAdapter) MyOfferATSplashAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdShow() {
                if (((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener.onSplashAdShow();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onAdShowFail(AdError adError) {
                if (((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, adError.getCode(), adError.getMessage()));
                    ((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                }
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMSplashListener
            public void onDeeplinkCallback(boolean z) {
                if (((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener.onDeeplinkCallback(z);
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
            MyOfferATSplashAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            MyOfferATSplashAdapter myOfferATSplashAdapter = MyOfferATSplashAdapter.this;
            Context context = this.a;
            MyOfferATSplashAdapter myOfferATSplashAdapter2 = MyOfferATSplashAdapter.this;
            myOfferATSplashAdapter.b = new SDMMyOfferSplashAd(context, myOfferATSplashAdapter2.c, ((CustomSplashAdapter) myOfferATSplashAdapter2).mFetchAdTimeout);
            SDMAdRequest sDMAdRequestBuild = new SDMAdRequest.Builder().setExtraMap(this.b).setCustomEventMap(MyOfferATSplashAdapter.this.d).setAdWidth(ATInitMediation.getIntFromMap(this.c, ATAdConst.KEY.AD_WIDTH, 0)).setAdHeight(ATInitMediation.getIntFromMap(this.c, ATAdConst.KEY.AD_HEIGHT, 0)).build();
            MyOfferATSplashAdapter.this.b.setListener(new C0075a());
            MyOfferATSplashAdapter.this.b.load(sDMAdRequestBuild);
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return AdxATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        SDMMyOfferSplashAd sDMMyOfferSplashAd = this.b;
        if (sDMMyOfferSplashAd != null) {
            sDMMyOfferSplashAd.destroy();
            this.b = null;
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        SDMMyOfferSplashAd sDMMyOfferSplashAd = this.b;
        if (sDMMyOfferSplashAd != null) {
            return sDMMyOfferSplashAd.getExtraInfoMap();
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

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean isAdReady() {
        SDMMyOfferSplashAd sDMMyOfferSplashAd = this.b;
        if (sDMMyOfferSplashAd != null) {
            return sDMMyOfferSplashAd.isAdReady();
        }
        return false;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
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

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (this.b != null) {
            if (isCustomSkipView()) {
                this.d.put(SDMAdConst.EXTRA_PARAMS.SHOW_HIDE_SPLASH_SKIP_VIEW, Boolean.TRUE);
            }
            this.b.show(viewGroup);
        }
    }
}
