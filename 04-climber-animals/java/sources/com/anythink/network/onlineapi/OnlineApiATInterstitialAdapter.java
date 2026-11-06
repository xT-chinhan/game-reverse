package com.anythink.network.onlineapi;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.d;
import com.anythink.basead.d.f;
import com.anythink.basead.f.e;
import com.anythink.basead.g.j;
import com.anythink.basead.g.k;
import com.anythink.basead.h.c;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.m;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class OnlineApiATInterstitialAdapter extends CustomInterstitialAdapter {
    x a;
    e b;
    String c;
    Map<String, Object> d;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return "";
    }

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
        this.b.a(new k() { // from class: com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.1
            @Override // com.anythink.basead.g.k
            public final void onRewarded() {
            }

            @Override // com.anythink.basead.g.k
            public final void onVideoAdPlayStart() {
                if (OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                    OnlineApiATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
                }
            }

            @Override // com.anythink.basead.g.k
            public final void onVideoAdPlayEnd() {
                if (OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                    OnlineApiATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onShowFailed(f fVar) {
                if (OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                    OnlineApiATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError(fVar.a(), fVar.b());
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onAdShow(j jVar) {
                if (OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                    OnlineApiATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onAdClosed() {
                if (OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                    OnlineApiATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onAdClick(j jVar) {
                n trackingInfo = OnlineApiATInterstitialAdapter.this.getTrackingInfo();
                if (trackingInfo != null) {
                    trackingInfo.I(jVar.a);
                    trackingInfo.J(jVar.b);
                }
                if (OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                    OnlineApiATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onDeeplinkCallback(boolean z) {
                if (OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                    OnlineApiATInterstitialAdapter.this.mImpressListener.onDeeplinkCallback(z);
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
        this.b.a(new com.anythink.basead.g.c() { // from class: com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.2
            @Override // com.anythink.basead.g.c
            public final void onAdDataLoaded() {
                if (OnlineApiATInterstitialAdapter.this.mLoadListener != null) {
                    OnlineApiATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdCacheLoaded() {
                OnlineApiATInterstitialAdapter onlineApiATInterstitialAdapter = OnlineApiATInterstitialAdapter.this;
                onlineApiATInterstitialAdapter.d = d.a(onlineApiATInterstitialAdapter.b);
                if (OnlineApiATInterstitialAdapter.this.mLoadListener != null) {
                    OnlineApiATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdLoadFailed(f fVar) {
                if (OnlineApiATInterstitialAdapter.this.mLoadListener != null) {
                    OnlineApiATInterstitialAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
                }
            }
        });
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        return true;
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        Object obj2;
        this.c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i = (!map.containsKey("v_m") || (obj2 = map.get("v_m")) == null) ? 0 : Integer.parseInt(obj2.toString());
        int i2 = (!map.containsKey("s_c_t") || (obj = map.get("s_c_t")) == null) ? -1 : Integer.parseInt(obj.toString());
        this.a = (x) map.get(com.anythink.core.common.d.j.w.a);
        e eVar = new e(context, com.anythink.basead.f.c.b.ONLINE_API_OFFER_REQUEST_TYPE, this.a);
        this.b = eVar;
        eVar.a(new com.anythink.basead.f.d.a().a(i).b(i2).a());
        String stringFromMap = ATInitMediation.getStringFromMap(map, "unit_type");
        if (TextUtils.isEmpty(stringFromMap)) {
            return;
        }
        this.b.a(stringFromMap);
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
        return this.c;
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
}
