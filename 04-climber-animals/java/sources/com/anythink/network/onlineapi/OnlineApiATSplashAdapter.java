package com.anythink.network.onlineapi;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.d;
import com.anythink.basead.d.f;
import com.anythink.basead.f.c;
import com.anythink.basead.f.h;
import com.anythink.basead.g.a;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.j;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.x;
import com.anythink.network.tap.TapATInitManager;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class OnlineApiATSplashAdapter extends CustomSplashAdapter {
    h a;
    x b;
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

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        return true;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        h hVar = this.a;
        boolean z = hVar != null && hVar.c();
        if (z && this.d == null) {
            this.d = d.a(this.a);
        }
        return z;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (this.a != null) {
            if (isCustomSkipView()) {
                this.a.a();
            }
            this.a.a(viewGroup);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        h hVar = this.a;
        if (hVar != null) {
            hVar.b();
            this.a = null;
        }
        this.b = null;
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        int i;
        Object obj2;
        Object obj3;
        this.c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i2 = 1;
        int i3 = (!map.containsKey(TapATInitManager.ORIENTATION_KEY) || (obj3 = map.get(TapATInitManager.ORIENTATION_KEY)) == null) ? 1 : Integer.parseInt(obj3.toString());
        int i4 = (!map.containsKey("countdown") || (obj2 = map.get("countdown")) == null) ? 5 : Integer.parseInt(obj2.toString()) * 1000;
        if (map.containsKey("allows_skip") && (obj = map.get("allows_skip")) != null && (i = Integer.parseInt(obj.toString())) != 0) {
            i2 = i == 1 ? 0 : i;
        }
        this.b = (x) map.get(j.w.a);
        h hVar = new h(context, c.b.ONLINE_API_OFFER_REQUEST_TYPE, this.b);
        this.a = hVar;
        hVar.a(new com.anythink.basead.f.d.a().d(i3).e(i4).f(i2).a());
        this.a.a(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.anythink.network.onlineapi.OnlineApiATSplashAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.g.a
        public final void onAdShow(com.anythink.basead.g.j jVar) {
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.anythink.basead.g.a
        public final void onAdClosed() {
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.anythink.basead.g.a
        public final void onAdClick(com.anythink.basead.g.j jVar) {
            n trackingInfo = OnlineApiATSplashAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.I(jVar.a);
                trackingInfo.J(jVar.b);
            }
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.anythink.basead.g.a
        public final void onDeeplinkCallback(boolean z) {
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.g.a
        public final void onShowFailed(f fVar) {
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, fVar.a(), fVar.b()));
            }
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.d;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        int i;
        Object obj2;
        Object obj3;
        this.c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i2 = 1;
        int i3 = (!map.containsKey(TapATInitManager.ORIENTATION_KEY) || (obj3 = map.get(TapATInitManager.ORIENTATION_KEY)) == null) ? 1 : Integer.parseInt(obj3.toString());
        int i4 = (!map.containsKey("countdown") || (obj2 = map.get("countdown")) == null) ? 5 : Integer.parseInt(obj2.toString()) * 1000;
        if (map.containsKey("allows_skip") && (obj = map.get("allows_skip")) != null && (i = Integer.parseInt(obj.toString())) != 0) {
            i2 = i == 1 ? 0 : i;
        }
        this.b = (x) map.get(j.w.a);
        h hVar = new h(context, c.b.ONLINE_API_OFFER_REQUEST_TYPE, this.b);
        this.a = hVar;
        hVar.a(new com.anythink.basead.f.d.a().d(i3).e(i4).f(i2).a());
        this.a.a(new AnonymousClass2());
        this.a.a(new com.anythink.basead.g.c() { // from class: com.anythink.network.onlineapi.OnlineApiATSplashAdapter.1
            @Override // com.anythink.basead.g.c
            public final void onAdDataLoaded() {
                if (OnlineApiATSplashAdapter.this.mLoadListener != null) {
                    OnlineApiATSplashAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdCacheLoaded() {
                OnlineApiATSplashAdapter onlineApiATSplashAdapter = OnlineApiATSplashAdapter.this;
                onlineApiATSplashAdapter.d = d.a(onlineApiATSplashAdapter.a);
                if (OnlineApiATSplashAdapter.this.mLoadListener != null) {
                    OnlineApiATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdLoadFailed(f fVar) {
                if (OnlineApiATSplashAdapter.this.mLoadListener != null) {
                    OnlineApiATSplashAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
                }
            }
        });
    }
}
