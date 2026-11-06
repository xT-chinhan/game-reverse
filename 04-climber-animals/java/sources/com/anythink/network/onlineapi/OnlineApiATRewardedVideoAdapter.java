package com.anythink.network.onlineapi;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.d;
import com.anythink.basead.d.f;
import com.anythink.basead.f.g;
import com.anythink.basead.g.j;
import com.anythink.basead.g.k;
import com.anythink.basead.h.c;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.m;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class OnlineApiATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    x a;
    g b;
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

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        int iF = m.f(activity);
        HashMap map = new HashMap(1);
        map.put("extra_scenario", this.mScenario);
        map.put(c.j, Integer.valueOf(iF));
        this.b.a(new k() { // from class: com.anythink.network.onlineapi.OnlineApiATRewardedVideoAdapter.1
            @Override // com.anythink.basead.g.k
            public final void onVideoAdPlayStart() {
            }

            @Override // com.anythink.basead.g.k
            public final void onVideoAdPlayEnd() {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onShowFailed(f fVar) {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed(fVar.a(), fVar.b());
                }
            }

            @Override // com.anythink.basead.g.k
            public final void onRewarded() {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onReward();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onAdShow(j jVar) {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onAdClosed() {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onAdClick(j jVar) {
                n trackingInfo = OnlineApiATRewardedVideoAdapter.this.getTrackingInfo();
                if (trackingInfo != null) {
                    trackingInfo.I(jVar.a);
                    trackingInfo.J(jVar.b);
                }
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onDeeplinkCallback(boolean z) {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onDeeplinkCallback(z);
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
        this.b.a(new com.anythink.basead.g.c() { // from class: com.anythink.network.onlineapi.OnlineApiATRewardedVideoAdapter.2
            @Override // com.anythink.basead.g.c
            public final void onAdDataLoaded() {
                if (OnlineApiATRewardedVideoAdapter.this.mLoadListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdCacheLoaded() {
                OnlineApiATRewardedVideoAdapter onlineApiATRewardedVideoAdapter = OnlineApiATRewardedVideoAdapter.this;
                onlineApiATRewardedVideoAdapter.d = d.a(onlineApiATRewardedVideoAdapter.b);
                if (OnlineApiATRewardedVideoAdapter.this.mLoadListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdLoadFailed(f fVar) {
                if (OnlineApiATRewardedVideoAdapter.this.mLoadListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
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
        g gVar = new g(context, com.anythink.basead.f.c.b.ONLINE_API_OFFER_REQUEST_TYPE, this.a);
        this.b = gVar;
        gVar.a(new com.anythink.basead.f.d.a().a(i).b(i2).a());
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
        return this.c;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        g gVar = this.b;
        boolean z = gVar != null && gVar.c();
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
