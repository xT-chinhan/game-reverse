package com.anythink.network.adx;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMAd;
import com.smartdigimkt.sdk.api.format.SDMNative;
import com.smartdigimkt.sdk.api.format.SDMNativeAd;
import com.smartdigimkt.sdk.api.format.SDMNativeLoadListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdxATAdapter extends CustomNativeAdapter {
    SDMNative a;
    String b;
    private Map<String, Object> c = new HashMap();
    AdxATNativeAd d;

    class a implements MediationInitCallback {
        final /* synthetic */ Map a;
        final /* synthetic */ Context b;
        final /* synthetic */ Map c;
        final /* synthetic */ Context d;

        /* JADX INFO: renamed from: com.anythink.network.adx.AdxATAdapter$a$a, reason: collision with other inner class name */
        class C0062a implements SDMNativeLoadListener {
            C0062a() {
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMNativeLoadListener
            public void onAdLoadFail(AdError adError) {
                AdxATAdapter.this.notifyATLoadFail(adError.getCode(), adError.getMessage());
            }

            @Override // com.smartdigimkt.sdk.api.format.SDMNativeLoadListener
            public void onAdLoaded(SDMNativeAd sDMNativeAd) {
                if (sDMNativeAd == null) {
                    AdxATAdapter.this.notifyATLoadFail("", "return empty");
                    return;
                }
                a aVar = a.this;
                AdxATNativeAd adxATNativeAd = new AdxATNativeAd(aVar.d, sDMNativeAd, AdxATAdapter.this);
                SDMAd sDMAd = sDMNativeAd.getSDMAd();
                if (sDMAd != null) {
                    adxATNativeAd.setNetworkInfoMap(AdxATInitManager.getInstance().fillNetworkInfoMap(sDMAd.getExtraInfo(), null));
                }
                adxATNativeAd.setAdObject(AdxATAdapter.this.c);
                if (((CustomNativeAdapter) AdxATAdapter.this).mLoadListener != null) {
                    ((CustomNativeAdapter) AdxATAdapter.this).mLoadListener.onAdCacheLoaded(adxATNativeAd);
                } else {
                    AdxATAdapter.this.d = adxATNativeAd;
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
            AdxATAdapter.this.notifyATLoadFail("", str);
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
            AdxATAdapter.this.a = new SDMNative(this.b, AdxATAdapter.this.b);
            SDMAdRequest.Builder customEventMap = new SDMAdRequest.Builder().setExtraMap(this.c).setCustomEventMap(AdxATAdapter.this.c);
            if (!TextUtils.isEmpty(stringFromMap)) {
                customEventMap.setNativeVideoAutoPlay(stringFromMap);
            }
            if (i2 > 0) {
                customEventMap.setAdWidth(i2);
            }
            if (i > 0) {
                customEventMap.setAdHeight(i);
            }
            AdxATAdapter.this.a.setListener(new C0062a());
            AdxATAdapter.this.a.load(customEventMap.build());
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return AdxATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        SDMNative sDMNative = this.a;
        if (sDMNative != null) {
            sDMNative.destroy();
            this.a = null;
        }
        if (this.d != null) {
            this.d = null;
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter
    public Map<String, Object> getAdExtraInfoMap() {
        return this.c;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter
    public BaseAd getBaseAdObject(Context context) {
        AdxATNativeAd adxATNativeAd = this.d;
        if (adxATNativeAd == null || !adxATNativeAd.isValid()) {
            return null;
        }
        return this.d;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        AdxATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, false);
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return null;
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
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Context applicationContext = context.getApplicationContext();
        String stringFromMap = ATInitMediation.getStringFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_PLACEMENT_ID);
        this.b = stringFromMap;
        if (TextUtils.isEmpty(stringFromMap)) {
            notifyATLoadFail("", "placement id is empty");
        } else {
            Context applicationContext2 = context.getApplicationContext();
            AdxATInitManager.getInstance().initSDK(applicationContext2, map, new a(map2, applicationContext2, map, applicationContext));
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdInternalAdapter
    public void notifyWLInfo(int i, Map<String, Object> map) {
        SDMNative sDMNative = this.a;
        AdxATInitManager.getInstance().notifyWLInfo(i, map, sDMNative != null ? sDMNative.getNativeAd() : null);
    }
}
