package com.anythink.network.adx;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.d;
import com.anythink.basead.d.f;
import com.anythink.basead.f.e;
import com.anythink.basead.g.g;
import com.anythink.basead.g.j;
import com.anythink.basead.h.c;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.h.x;
import com.anythink.core.common.k;
import com.anythink.core.common.v.m;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdxATInterstitialAdapter extends CustomInterstitialAdapter {
    protected x a;
    protected e b;
    protected int c = 0;
    Map<String, Object> d;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        int iF = m.f(activity);
        HashMap map = new HashMap(1);
        map.put("extra_scenario", this.mScenario);
        map.put(c.j, Integer.valueOf(iF));
        AdxATInitManager.getInstance();
        AdxATInitManager.a(getTrackingInfo(), this.a);
        this.b.a(new g(this.b.d(), getTrackingInfo()) { // from class: com.anythink.network.adx.AdxATInterstitialAdapter.1
            @Override // com.anythink.basead.g.k
            public final void onRewarded() {
            }

            @Override // com.anythink.basead.g.k
            public final void onVideoAdPlayStart() {
                if (AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
                }
            }

            @Override // com.anythink.basead.g.k
            public final void onVideoAdPlayEnd() {
                if (AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onShowFailed(f fVar) {
                if (AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError(fVar.a(), fVar.b());
                }
            }

            @Override // com.anythink.basead.g.g, com.anythink.basead.g.e, com.anythink.basead.g.a
            public final void onAdShow(j jVar) {
                super.onAdShow(jVar);
                if (AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onAdClosed() {
                if (AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
                }
            }

            @Override // com.anythink.basead.g.e, com.anythink.basead.g.a
            public final void onAdClick(j jVar) {
                super.onAdClick(jVar);
                if (AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onDeeplinkCallback(boolean z) {
                if ((AdxATInterstitialAdapter.this.b == null || AdxATInterstitialAdapter.this.b.g()) && AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onDeeplinkCallback(z);
                }
            }
        });
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(activity, map);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        this.b.a(new com.anythink.basead.g.c() { // from class: com.anythink.network.adx.AdxATInterstitialAdapter.2
            @Override // com.anythink.basead.g.c
            public final void onAdDataLoaded() {
                if (AdxATInterstitialAdapter.this.mLoadListener != null) {
                    AdxATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdCacheLoaded() {
                AdxATInterstitialAdapter adxATInterstitialAdapter = AdxATInterstitialAdapter.this;
                adxATInterstitialAdapter.d = d.a(adxATInterstitialAdapter.b);
                if (AdxATInterstitialAdapter.this.getTrackingInfo() != null) {
                    AdxATInterstitialAdapter.this.getTrackingInfo().M(AdxATInterstitialAdapter.this.b.f());
                }
                if (AdxATInterstitialAdapter.this.mLoadListener != null) {
                    AdxATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdLoadFailed(f fVar) {
                if (AdxATInterstitialAdapter.this.mLoadListener != null) {
                    AdxATInterstitialAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
                }
            }
        });
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        e eVar = this.b;
        if (eVar == null) {
            return true;
        }
        eVar.a(new com.anythink.basead.f.c.a() { // from class: com.anythink.network.adx.AdxATInterstitialAdapter.3
            @Override // com.anythink.basead.f.c.a
            public final void onAdCacheLoaded() {
                if (AdxATInterstitialAdapter.this.getTrackingInfo() != null) {
                    AdxATInterstitialAdapter.this.getTrackingInfo().M(AdxATInterstitialAdapter.this.b.f());
                }
            }
        });
        return true;
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        Object obj2;
        Object obj3;
        AdxATInitManager.getInstance().initSDK(context, map, null);
        int i = (!map.containsKey("v_m") || (obj3 = map.get("v_m")) == null) ? 0 : Integer.parseInt(obj3.toString());
        int i2 = (!map.containsKey("s_c_t") || (obj2 = map.get("s_c_t")) == null) ? -1 : Integer.parseInt(obj2.toString());
        this.a = (x) map.get(com.anythink.core.common.d.j.w.a);
        this.b = new e(context, com.anythink.basead.f.c.b.ADX_OFFER_REQUEST_TYPE, this.a);
        com.anythink.basead.f.d.a aVarB = new com.anythink.basead.f.d.a().a((!map.containsKey(k.aF) || (obj = map.get(k.aF)) == null) ? "1" : obj.toString()).a(i).b(i2);
        int i3 = this.c;
        if (i3 > 0) {
            aVarB.a(i3 == 1);
        }
        this.b.a(aVarB.a());
        AdxATInitManager.getInstance();
        AdxATInitManager.a(getTrackingInfo(), this.a);
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        e eVar = this.b;
        if (eVar != null) {
            eVar.b();
            this.b = null;
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        x xVar = this.a;
        return xVar != null ? xVar.b : "";
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return AdxATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        e eVar = this.b;
        boolean z = eVar != null && eVar.c();
        if (z && this.d == null) {
            this.d = d.a(this.b);
        }
        return z;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.d;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getAdExtraInfoMap() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.e();
        }
        return null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        AdxATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 3);
    }
}
