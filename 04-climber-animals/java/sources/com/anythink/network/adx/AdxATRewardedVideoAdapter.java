package com.anythink.network.adx;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.d;
import com.anythink.basead.d.f;
import com.anythink.basead.f.g;
import com.anythink.basead.g.j;
import com.anythink.basead.h.c;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.m;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdxATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    x a;
    g b;
    Map<String, Object> c;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        int iF = m.f(activity);
        HashMap map = new HashMap(1);
        map.put("extra_scenario", this.mScenario);
        map.put(c.j, Integer.valueOf(iF));
        AdxATInitManager.getInstance();
        AdxATInitManager.a(getTrackingInfo(), this.a);
        this.b.a(new com.anythink.basead.g.g(this.b.d(), getTrackingInfo()) { // from class: com.anythink.network.adx.AdxATRewardedVideoAdapter.1
            @Override // com.anythink.basead.g.k
            public final void onVideoAdPlayStart() {
            }

            @Override // com.anythink.basead.g.k
            public final void onVideoAdPlayEnd() {
                if (AdxATRewardedVideoAdapter.this.mImpressionListener != null) {
                    AdxATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onShowFailed(f fVar) {
                if (AdxATRewardedVideoAdapter.this.mImpressionListener != null) {
                    AdxATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed(fVar.a(), fVar.b());
                }
            }

            @Override // com.anythink.basead.g.k
            public final void onRewarded() {
                if (AdxATRewardedVideoAdapter.this.mImpressionListener != null) {
                    AdxATRewardedVideoAdapter.this.mImpressionListener.onReward();
                }
            }

            @Override // com.anythink.basead.g.g, com.anythink.basead.g.e, com.anythink.basead.g.a
            public final void onAdShow(j jVar) {
                super.onAdShow(jVar);
                if (AdxATRewardedVideoAdapter.this.mImpressionListener != null) {
                    AdxATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onAdClosed() {
                if (AdxATRewardedVideoAdapter.this.mImpressionListener != null) {
                    AdxATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
                }
            }

            @Override // com.anythink.basead.g.e, com.anythink.basead.g.a
            public final void onAdClick(j jVar) {
                super.onAdClick(jVar);
                if (AdxATRewardedVideoAdapter.this.mImpressionListener != null) {
                    AdxATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onDeeplinkCallback(boolean z) {
                if ((AdxATRewardedVideoAdapter.this.b == null || AdxATRewardedVideoAdapter.this.b.g()) && AdxATRewardedVideoAdapter.this.mImpressionListener != null) {
                    AdxATRewardedVideoAdapter.this.mImpressionListener.onDeeplinkCallback(z);
                }
            }
        });
        g gVar = this.b;
        if (gVar != null) {
            gVar.a(activity, map);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        this.b.a(new com.anythink.basead.g.c() { // from class: com.anythink.network.adx.AdxATRewardedVideoAdapter.2
            @Override // com.anythink.basead.g.c
            public final void onAdDataLoaded() {
                if (AdxATRewardedVideoAdapter.this.mLoadListener != null) {
                    AdxATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdCacheLoaded() {
                AdxATRewardedVideoAdapter adxATRewardedVideoAdapter = AdxATRewardedVideoAdapter.this;
                adxATRewardedVideoAdapter.c = d.a(adxATRewardedVideoAdapter.b);
                if (AdxATRewardedVideoAdapter.this.getTrackingInfo() != null) {
                    AdxATRewardedVideoAdapter.this.getTrackingInfo().M(AdxATRewardedVideoAdapter.this.b.f());
                }
                if (AdxATRewardedVideoAdapter.this.mLoadListener != null) {
                    AdxATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdLoadFailed(f fVar) {
                if (AdxATRewardedVideoAdapter.this.mLoadListener != null) {
                    AdxATRewardedVideoAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
                }
            }
        });
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        g gVar = this.b;
        if (gVar == null) {
            return true;
        }
        gVar.a(new com.anythink.basead.f.c.a() { // from class: com.anythink.network.adx.AdxATRewardedVideoAdapter.3
            @Override // com.anythink.basead.f.c.a
            public final void onAdCacheLoaded() {
                if (AdxATRewardedVideoAdapter.this.getTrackingInfo() != null) {
                    AdxATRewardedVideoAdapter.this.getTrackingInfo().M(AdxATRewardedVideoAdapter.this.b.f());
                }
            }
        });
        return true;
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        Object obj2;
        AdxATInitManager.getInstance().initSDK(context, map, null);
        int i = (!map.containsKey("v_m") || (obj2 = map.get("v_m")) == null) ? 0 : Integer.parseInt(obj2.toString());
        int i2 = (!map.containsKey("s_c_t") || (obj = map.get("s_c_t")) == null) ? -1 : Integer.parseInt(obj.toString());
        this.a = (x) map.get(com.anythink.core.common.d.j.w.a);
        g gVar = new g(context, com.anythink.basead.f.c.b.ADX_OFFER_REQUEST_TYPE, this.a);
        this.b = gVar;
        gVar.a(new com.anythink.basead.f.d.a().a(i).b(i2).a());
        AdxATInitManager.getInstance();
        AdxATInitManager.a(getTrackingInfo(), this.a);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        g gVar = this.b;
        if (gVar != null) {
            gVar.b();
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
        g gVar = this.b;
        boolean z = gVar != null && gVar.c();
        if (z && this.c == null) {
            this.c = d.a(this.b);
        }
        return z;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getAdExtraInfoMap() {
        g gVar = this.b;
        if (gVar != null) {
            return gVar.e();
        }
        return null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        AdxATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 1);
    }
}
