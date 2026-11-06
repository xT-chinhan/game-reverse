package com.anythink.network.myoffer;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.anythink.network.adx.AdxATConst;
import com.anythink.network.adx.AdxATInitManager;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMNativeAd;
import com.smartdigimkt.sdk.api.format.SDMNativeLoadListener;
import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferNative;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MyOfferATAdapter extends CustomNativeAdapter {
    SDMMyOfferNative b;
    String c;
    MyOfferATNativeAd e;
    private String a = "";
    private Map<String, Object> d = new HashMap();

    class a implements MediationInitCallback {
        final /* synthetic */ Map a;
        final /* synthetic */ Context b;
        final /* synthetic */ Map c;
        final /* synthetic */ Context d;

        /* JADX INFO: renamed from: com.anythink.network.myoffer.MyOfferATAdapter$a$a, reason: collision with other inner class name */
        class C0071a implements SDMNativeLoadListener {
            C0071a() {
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMNativeLoadListener
            public void onAdLoadFail(AdError adError) {
                MyOfferATAdapter.this.notifyATLoadFail(adError.getCode(), adError.getMessage());
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMNativeLoadListener
            public void onAdLoaded(SDMNativeAd sDMNativeAd) {
                if (sDMNativeAd == null) {
                    MyOfferATAdapter.this.notifyATLoadFail("", "return empty");
                    return;
                }
                MyOfferATNativeAd myOfferATNativeAd = new MyOfferATNativeAd(a.this.d, sDMNativeAd);
                myOfferATNativeAd.setNetworkInfoMap(MyOfferATAdapter.this.b.getExtraInfoMap());
                if (((CustomNativeAdapter) MyOfferATAdapter.this).mLoadListener != null) {
                    ((CustomNativeAdapter) MyOfferATAdapter.this).mLoadListener.onAdCacheLoaded(myOfferATNativeAd);
                } else {
                    MyOfferATAdapter.this.e = myOfferATNativeAd;
                }
            }
        }

        a(Map map, Context context, Map map2, Context context2) {
            this.a = map;
            this.b = context;
            this.c = map2;
            this.d = context2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            MyOfferATAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            String stringFromMap;
            int i;
            Map map = this.a;
            int i2 = 0;
            if (map != null) {
                int intFromMap = ATInitMediation.getIntFromMap(map, ATAdConst.KEY.AD_WIDTH, 0);
                int intFromMap2 = ATInitMediation.getIntFromMap(this.a, ATAdConst.KEY.AD_HEIGHT, 0);
                stringFromMap = ATInitMediation.getStringFromMap(this.a, AdxATConst.NATIVE_VIDEO_AUTO_PLAY, "1");
                i2 = intFromMap;
                i = intFromMap2;
            } else {
                stringFromMap = "";
                i = 0;
            }
            MyOfferATAdapter.this.b = new SDMMyOfferNative(this.b, MyOfferATAdapter.this.c);
            SDMAdRequest.Builder customEventMap = new SDMAdRequest.Builder().setExtraMap(this.c).setCustomEventMap(MyOfferATAdapter.this.d);
            if (!TextUtils.isEmpty(stringFromMap)) {
                customEventMap.setNativeVideoAutoPlay(stringFromMap);
            }
            if (i2 > 0) {
                customEventMap.setAdWidth(i2);
            }
            if (i > 0) {
                customEventMap.setAdHeight(i);
            }
            MyOfferATAdapter.this.b.setListener(new C0071a());
            MyOfferATAdapter.this.b.load(customEventMap.build());
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return AdxATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        SDMMyOfferNative sDMMyOfferNative = this.b;
        if (sDMMyOfferNative != null) {
            sDMMyOfferNative.destroy();
            this.b = null;
        }
        if (this.e != null) {
            this.e = null;
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter
    public BaseAd getBaseAdObject(Context context) {
        MyOfferATNativeAd myOfferATNativeAd = this.e;
        if (myOfferATNativeAd == null || !myOfferATNativeAd.isValid()) {
            return null;
        }
        return this.e;
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
            return;
        }
        Context applicationContext = context.getApplicationContext();
        String stringFromMap2 = ATInitMediation.getStringFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_PLACEMENT_ID);
        this.c = stringFromMap2;
        if (TextUtils.isEmpty(stringFromMap2)) {
            notifyATLoadFail("", "placement id is empty");
        } else {
            AdxATInitManager.getInstance().initSDK(context, map, new a(map2, context, map, applicationContext));
        }
    }
}
