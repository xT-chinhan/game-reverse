package com.anythink.network.myoffer;

import android.content.Context;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.basead.d;
import com.anythink.basead.d.f;
import com.anythink.basead.g.a;
import com.anythink.basead.g.c;
import com.anythink.basead.h.b;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.j;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.x;
import com.anythink.core.common.r;
import com.anythink.core.common.v.p;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MyOfferATBannerAdapter extends CustomBannerAdapter {
    String a;
    x b;
    Map<String, Object> c;
    private b d;
    private View e;
    private boolean f = false;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return "MyOffer";
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        b bVar;
        if (this.e == null && (bVar = this.d) != null && bVar.a()) {
            this.e = this.d.b();
            if (this.c == null) {
                this.c = d.a(this.d);
            }
        }
        return this.e;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.a = map.get("my_oid").toString();
        }
        if (map.containsKey(j.w.a)) {
            this.b = (x) map.get(j.w.a);
        }
        a(context);
        this.d.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATBannerAdapter.1
            @Override // com.anythink.basead.g.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.g.c
            public final void onAdCacheLoaded() {
                MyOfferATBannerAdapter myOfferATBannerAdapter = MyOfferATBannerAdapter.this;
                myOfferATBannerAdapter.e = myOfferATBannerAdapter.d.b();
                MyOfferATBannerAdapter myOfferATBannerAdapter2 = MyOfferATBannerAdapter.this;
                myOfferATBannerAdapter2.c = d.a(myOfferATBannerAdapter2.d);
                if (MyOfferATBannerAdapter.this.getTrackingInfo() != null) {
                    MyOfferATBannerAdapter.this.getTrackingInfo().M(MyOfferATBannerAdapter.this.d.f());
                }
                if (MyOfferATBannerAdapter.this.mLoadListener != null) {
                    if (MyOfferATBannerAdapter.this.e != null) {
                        MyOfferATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    } else {
                        MyOfferATBannerAdapter.this.mLoadListener.onAdLoadError("", "MyOffer bannerView = null");
                    }
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdLoadFailed(f fVar) {
                if (MyOfferATBannerAdapter.this.mLoadListener != null) {
                    MyOfferATBannerAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
                }
            }
        });
    }

    private void a(Context context) {
        b bVar = new b(context, this.b, this.a, this.f);
        this.d = bVar;
        bVar.a(new a() { // from class: com.anythink.network.myoffer.MyOfferATBannerAdapter.2
            @Override // com.anythink.basead.g.a
            public final void onDeeplinkCallback(boolean z) {
            }

            @Override // com.anythink.basead.g.a
            public final void onShowFailed(f fVar) {
            }

            @Override // com.anythink.basead.g.a
            public final void onAdShow(com.anythink.basead.g.j jVar) {
                if (MyOfferATBannerAdapter.this.mImpressionEventListener != null) {
                    MyOfferATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onAdClosed() {
                if (MyOfferATBannerAdapter.this.mImpressionEventListener != null) {
                    MyOfferATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onAdClick(com.anythink.basead.g.j jVar) {
                n trackingInfo = MyOfferATBannerAdapter.this.getTrackingInfo();
                if (trackingInfo != null) {
                    trackingInfo.I(jVar.a);
                    trackingInfo.J(jVar.b);
                }
                if (MyOfferATBannerAdapter.this.mImpressionEventListener != null) {
                    MyOfferATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
                }
            }
        });
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.a = map.get("my_oid").toString();
        }
        if (map.containsKey(j.w.a)) {
            this.b = (x) map.get(j.w.a);
        }
        if (map.containsKey(r.b)) {
            this.f = ((Boolean) map.get(r.b)).booleanValue();
        }
        a(context);
        return true;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        this.e = null;
        b bVar = this.d;
        if (bVar != null) {
            bVar.a((a) null);
            this.d.c();
            this.d = null;
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return p.a();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.c;
    }
}
