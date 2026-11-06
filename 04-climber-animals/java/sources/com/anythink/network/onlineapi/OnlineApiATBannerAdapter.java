package com.anythink.network.onlineapi;

import android.content.Context;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.basead.d;
import com.anythink.basead.d.f;
import com.anythink.basead.f.b;
import com.anythink.basead.f.c;
import com.anythink.basead.g.a;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.j;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.k;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class OnlineApiATBannerAdapter extends CustomBannerAdapter {
    x a;
    String b;
    Map<String, Object> c;
    private b d;
    private View e;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return "";
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        b bVar;
        if (this.e == null && (bVar = this.d) != null && bVar.c()) {
            this.e = this.d.a();
        }
        if (this.c == null) {
            this.c = d.a(this.d);
        }
        return this.e;
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        Object obj2;
        this.b = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i = (!map.containsKey(k.aM) || (obj2 = map.get(k.aM)) == null) ? 0 : Integer.parseInt(obj2.toString());
        String string = (!map.containsKey("size") || (obj = map.get("size")) == null) ? y.a : obj.toString();
        this.a = (x) map.get(j.w.a);
        b bVar = new b(context, c.b.ONLINE_API_OFFER_REQUEST_TYPE, this.a);
        this.d = bVar;
        bVar.a(new com.anythink.basead.f.d.a().c(i).b(string).a());
        this.d.a(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.anythink.network.onlineapi.OnlineApiATBannerAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements a {
        @Override // com.anythink.basead.g.a
        public final void onShowFailed(f fVar) {
        }

        AnonymousClass2() {
        }

        @Override // com.anythink.basead.g.a
        public final void onAdShow(com.anythink.basead.g.j jVar) {
            if (OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                OnlineApiATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
            }
        }

        @Override // com.anythink.basead.g.a
        public final void onAdClosed() {
            if (OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                OnlineApiATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.anythink.basead.g.a
        public final void onAdClick(com.anythink.basead.g.j jVar) {
            n trackingInfo = OnlineApiATBannerAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.I(jVar.a);
                trackingInfo.J(jVar.b);
            }
            if (OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                OnlineApiATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.anythink.basead.g.a
        public final void onDeeplinkCallback(boolean z) {
            if (OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                OnlineApiATBannerAdapter.this.mImpressionEventListener.onDeeplinkCallback(z);
            }
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        this.e = null;
        b bVar = this.d;
        if (bVar != null) {
            bVar.a((a) null);
            this.d.b();
            this.d = null;
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.c;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        Object obj2;
        this.b = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i = (!map.containsKey(k.aM) || (obj2 = map.get(k.aM)) == null) ? 0 : Integer.parseInt(obj2.toString());
        String string = (!map.containsKey("size") || (obj = map.get("size")) == null) ? y.a : obj.toString();
        this.a = (x) map.get(j.w.a);
        b bVar = new b(context, c.b.ONLINE_API_OFFER_REQUEST_TYPE, this.a);
        this.d = bVar;
        bVar.a(new com.anythink.basead.f.d.a().c(i).b(string).a());
        this.d.a(new AnonymousClass2());
        this.d.a(new com.anythink.basead.g.c() { // from class: com.anythink.network.onlineapi.OnlineApiATBannerAdapter.1
            @Override // com.anythink.basead.g.c
            public final void onAdDataLoaded() {
                if (OnlineApiATBannerAdapter.this.mLoadListener != null) {
                    OnlineApiATBannerAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdCacheLoaded() {
                OnlineApiATBannerAdapter onlineApiATBannerAdapter = OnlineApiATBannerAdapter.this;
                onlineApiATBannerAdapter.e = onlineApiATBannerAdapter.d.a();
                if (OnlineApiATBannerAdapter.this.mLoadListener != null) {
                    if (OnlineApiATBannerAdapter.this.e != null) {
                        OnlineApiATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    } else {
                        OnlineApiATBannerAdapter.this.mLoadListener.onAdLoadError("", "Online bannerView = null");
                    }
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdLoadFailed(f fVar) {
                if (OnlineApiATBannerAdapter.this.mLoadListener != null) {
                    OnlineApiATBannerAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
                }
            }
        });
    }
}
