package com.anythink.network.myoffer;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.d;
import com.anythink.basead.d.f;
import com.anythink.basead.g.a;
import com.anythink.basead.g.c;
import com.anythink.basead.h.g;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.j;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.p;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MyOfferATSplashAdapter extends CustomSplashAdapter {
    String a;
    g b;
    x c;
    Map<String, Object> d;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return "MyOffer";
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        return true;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.a = map.get("my_oid").toString();
        }
        if (map.containsKey(j.w.a)) {
            this.c = (x) map.get(j.w.a);
        }
        g gVar = new g(context, this.c, this.a);
        this.b = gVar;
        gVar.a(new AnonymousClass2());
        this.b.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATSplashAdapter.1
            @Override // com.anythink.basead.g.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.g.c
            public final void onAdCacheLoaded() {
                if (MyOfferATSplashAdapter.this.getTrackingInfo() != null) {
                    MyOfferATSplashAdapter.this.getTrackingInfo().M(MyOfferATSplashAdapter.this.b.f());
                }
                if (MyOfferATSplashAdapter.this.mLoadListener != null) {
                    MyOfferATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdLoadFailed(f fVar) {
                if (MyOfferATSplashAdapter.this.mLoadListener != null) {
                    MyOfferATSplashAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
                }
            }
        });
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        g gVar = this.b;
        boolean z = gVar != null && gVar.a();
        if (z && this.d == null) {
            this.d = d.a(this.b);
        }
        return z;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (this.b != null) {
            if (isCustomSkipView()) {
                this.b.b();
            }
            this.b.a(viewGroup);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        g gVar = this.b;
        if (gVar != null) {
            gVar.g();
            this.b = null;
        }
        this.c = null;
    }

    /* JADX INFO: renamed from: com.anythink.network.myoffer.MyOfferATSplashAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements a {
        @Override // com.anythink.basead.g.a
        public final void onDeeplinkCallback(boolean z) {
        }

        AnonymousClass2() {
        }

        @Override // com.anythink.basead.g.a
        public final void onAdShow(com.anythink.basead.g.j jVar) {
            if (MyOfferATSplashAdapter.this.mImpressionListener != null) {
                MyOfferATSplashAdapter.this.mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.anythink.basead.g.a
        public final void onAdClosed() {
            if (MyOfferATSplashAdapter.this.mImpressionListener != null) {
                MyOfferATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.anythink.basead.g.a
        public final void onAdClick(com.anythink.basead.g.j jVar) {
            n trackingInfo = MyOfferATSplashAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.I(jVar.a);
                trackingInfo.J(jVar.b);
            }
            if (MyOfferATSplashAdapter.this.mImpressionListener != null) {
                MyOfferATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.anythink.basead.g.a
        public final void onShowFailed(f fVar) {
            if (MyOfferATSplashAdapter.this.mImpressionListener != null) {
                MyOfferATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, fVar.a(), fVar.b()));
            }
        }
    }

    private void a(Context context) {
        g gVar = new g(context, this.c, this.a);
        this.b = gVar;
        gVar.a(new AnonymousClass2());
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
        return this.d;
    }
}
