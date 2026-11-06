package com.anythink.network.myoffer;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.d;
import com.anythink.basead.g.c;
import com.anythink.basead.g.k;
import com.anythink.basead.h.f;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.j;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.x;
import com.anythink.core.common.r;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.p;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MyOfferATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    x a;
    Map<String, Object> b;
    private f d;
    private String c = "";
    private boolean e = false;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return "MyOffer";
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.c = map.get("my_oid").toString();
        }
        if (map.containsKey(j.w.a)) {
            this.a = (x) map.get(j.w.a);
        }
        a(context);
        this.d.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATRewardedVideoAdapter.1
            @Override // com.anythink.basead.g.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.g.c
            public final void onAdCacheLoaded() {
                MyOfferATRewardedVideoAdapter myOfferATRewardedVideoAdapter = MyOfferATRewardedVideoAdapter.this;
                myOfferATRewardedVideoAdapter.b = d.a(myOfferATRewardedVideoAdapter.d);
                if (MyOfferATRewardedVideoAdapter.this.getTrackingInfo() != null) {
                    MyOfferATRewardedVideoAdapter.this.getTrackingInfo().M(MyOfferATRewardedVideoAdapter.this.d.f());
                }
                if (MyOfferATRewardedVideoAdapter.this.mLoadListener != null) {
                    MyOfferATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdLoadFailed(com.anythink.basead.d.f fVar) {
                if (MyOfferATRewardedVideoAdapter.this.mLoadListener != null) {
                    MyOfferATRewardedVideoAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
                }
            }
        });
    }

    private void a(Context context) {
        this.d = new f(context, this.a, this.c, this.e);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.c = map.get("my_oid").toString();
        }
        if (map.containsKey(j.w.a)) {
            this.a = (x) map.get(j.w.a);
        }
        if (map.containsKey(r.b)) {
            this.e = ((Boolean) map.get(r.b)).booleanValue();
        }
        a(context);
        return true;
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        int iF = m.f(activity);
        if (isAdReady()) {
            HashMap map = new HashMap(1);
            map.put(com.anythink.basead.h.c.h, this.a.d);
            map.put("extra_scenario", this.mScenario);
            map.put(com.anythink.basead.h.c.j, Integer.valueOf(iF));
            this.d.a(new k() { // from class: com.anythink.network.myoffer.MyOfferATRewardedVideoAdapter.2
                @Override // com.anythink.basead.g.a
                public final void onDeeplinkCallback(boolean z) {
                }

                @Override // com.anythink.basead.g.k
                public final void onVideoAdPlayStart() {
                }

                @Override // com.anythink.basead.g.k
                public final void onVideoAdPlayEnd() {
                    if (MyOfferATRewardedVideoAdapter.this.mImpressionListener != null) {
                        MyOfferATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
                    }
                }

                @Override // com.anythink.basead.g.a
                public final void onShowFailed(com.anythink.basead.d.f fVar) {
                    if (MyOfferATRewardedVideoAdapter.this.mImpressionListener != null) {
                        MyOfferATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed(fVar.a(), fVar.b());
                    }
                }

                @Override // com.anythink.basead.g.k
                public final void onRewarded() {
                    if (MyOfferATRewardedVideoAdapter.this.mImpressionListener != null) {
                        MyOfferATRewardedVideoAdapter.this.mImpressionListener.onReward();
                    }
                }

                @Override // com.anythink.basead.g.a
                public final void onAdShow(com.anythink.basead.g.j jVar) {
                    if (MyOfferATRewardedVideoAdapter.this.mImpressionListener != null) {
                        MyOfferATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
                    }
                }

                @Override // com.anythink.basead.g.a
                public final void onAdClosed() {
                    if (MyOfferATRewardedVideoAdapter.this.mImpressionListener != null) {
                        MyOfferATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
                    }
                }

                @Override // com.anythink.basead.g.a
                public final void onAdClick(com.anythink.basead.g.j jVar) {
                    n trackingInfo = MyOfferATRewardedVideoAdapter.this.getTrackingInfo();
                    if (trackingInfo != null) {
                        trackingInfo.I(jVar.a);
                        trackingInfo.J(jVar.b);
                    }
                    if (MyOfferATRewardedVideoAdapter.this.mImpressionListener != null) {
                        MyOfferATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
                    }
                }
            });
            this.d.a(activity, map);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        f fVar = this.d;
        boolean z = fVar != null && fVar.a();
        if (z && this.b == null) {
            this.b = d.a(this.d);
        }
        return z;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return p.a();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        f fVar = this.d;
        if (fVar != null) {
            fVar.a((k) null);
            this.d = null;
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.b;
    }
}
