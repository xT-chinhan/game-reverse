package com.anythink.network.adx;

import android.content.Context;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.basead.d;
import com.anythink.basead.d.f;
import com.anythink.basead.f.b;
import com.anythink.basead.g.a;
import com.anythink.basead.g.c;
import com.anythink.basead.g.e;
import com.anythink.basead.g.j;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.k;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdxATBannerAdapter extends CustomBannerAdapter {
    x a;
    Map<String, Object> b;
    private b c;
    private View d;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        b bVar = this.c;
        if (bVar != null && this.b == null) {
            this.b = d.a(bVar);
        }
        return this.d;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map, map2);
        this.c.a(new c() { // from class: com.anythink.network.adx.AdxATBannerAdapter.1
            @Override // com.anythink.basead.g.c
            public final void onAdDataLoaded() {
                if (AdxATBannerAdapter.this.mLoadListener != null) {
                    AdxATBannerAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdCacheLoaded() {
                if (AdxATBannerAdapter.this.c == null || AdxATBannerAdapter.this.mLoadListener == null) {
                    return;
                }
                AdxATBannerAdapter adxATBannerAdapter = AdxATBannerAdapter.this;
                adxATBannerAdapter.b = d.a(adxATBannerAdapter.c);
                AdxATInitManager.getInstance();
                AdxATInitManager.a(AdxATBannerAdapter.this.getTrackingInfo(), AdxATBannerAdapter.this.a);
                AdxATBannerAdapter.this.c.a(new e(AdxATBannerAdapter.this.c.d(), AdxATBannerAdapter.this.getTrackingInfo()) { // from class: com.anythink.network.adx.AdxATBannerAdapter.1.1
                    @Override // com.anythink.basead.g.a
                    public final void onShowFailed(f fVar) {
                    }

                    @Override // com.anythink.basead.g.e, com.anythink.basead.g.a
                    public final void onAdShow(j jVar) {
                        super.onAdShow(jVar);
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
                        }
                    }

                    @Override // com.anythink.basead.g.a
                    public final void onAdClosed() {
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
                        }
                    }

                    @Override // com.anythink.basead.g.e, com.anythink.basead.g.a
                    public final void onAdClick(j jVar) {
                        super.onAdClick(jVar);
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
                        }
                    }

                    @Override // com.anythink.basead.g.a
                    public final void onDeeplinkCallback(boolean z) {
                        if ((AdxATBannerAdapter.this.c == null || AdxATBannerAdapter.this.c.g()) && AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onDeeplinkCallback(z);
                        }
                    }
                });
                if (AdxATBannerAdapter.this.getTrackingInfo() != null) {
                    AdxATBannerAdapter.this.getTrackingInfo().M(AdxATBannerAdapter.this.c.f());
                }
                AdxATBannerAdapter adxATBannerAdapter2 = AdxATBannerAdapter.this;
                adxATBannerAdapter2.d = adxATBannerAdapter2.c.a();
                if (AdxATBannerAdapter.this.d != null) {
                    AdxATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                } else {
                    AdxATBannerAdapter.this.mLoadListener.onAdLoadError("", "Adx bannerView = null");
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdLoadFailed(f fVar) {
                if (AdxATBannerAdapter.this.mLoadListener != null) {
                    AdxATBannerAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
                }
            }
        });
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map, map2);
        b bVar = this.c;
        if (bVar == null) {
            return true;
        }
        bVar.a(new com.anythink.basead.f.c.a() { // from class: com.anythink.network.adx.AdxATBannerAdapter.2
            @Override // com.anythink.basead.f.c.a
            public final void onAdCacheLoaded() {
                if (AdxATBannerAdapter.this.getTrackingInfo() != null) {
                    AdxATBannerAdapter.this.getTrackingInfo().M(AdxATBannerAdapter.this.c.f());
                }
                AdxATInitManager.getInstance();
                AdxATInitManager.a(AdxATBannerAdapter.this.getTrackingInfo(), AdxATBannerAdapter.this.a);
                AdxATBannerAdapter.this.c.a(new e(AdxATBannerAdapter.this.c.d(), AdxATBannerAdapter.this.getTrackingInfo()) { // from class: com.anythink.network.adx.AdxATBannerAdapter.2.1
                    @Override // com.anythink.basead.g.a
                    public final void onShowFailed(f fVar) {
                    }

                    @Override // com.anythink.basead.g.e, com.anythink.basead.g.a
                    public final void onAdShow(j jVar) {
                        super.onAdShow(jVar);
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
                        }
                    }

                    @Override // com.anythink.basead.g.a
                    public final void onAdClosed() {
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
                        }
                    }

                    @Override // com.anythink.basead.g.e, com.anythink.basead.g.a
                    public final void onAdClick(j jVar) {
                        super.onAdClick(jVar);
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
                        }
                    }

                    @Override // com.anythink.basead.g.a
                    public final void onDeeplinkCallback(boolean z) {
                        if ((AdxATBannerAdapter.this.c == null || AdxATBannerAdapter.this.c.g()) && AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onDeeplinkCallback(z);
                        }
                    }
                });
                AdxATBannerAdapter.this.postOnMainThread(new Runnable() { // from class: com.anythink.network.adx.AdxATBannerAdapter.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdxATBannerAdapter.this.d = AdxATBannerAdapter.this.c.a();
                    }
                });
            }
        });
        return true;
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        int i;
        int i2;
        Object obj;
        Object obj2;
        AdxATInitManager.getInstance().initSDK(context, map, null);
        int i3 = 0;
        int i4 = (!map.containsKey(k.aM) || (obj2 = map.get(k.aM)) == null) ? 0 : Integer.parseInt(obj2.toString());
        String string = (!map.containsKey("size") || (obj = map.get("size")) == null) ? y.a : obj.toString();
        if (map2 != null) {
            if (map2.containsKey(ATAdConst.KEY.AD_WIDTH)) {
                try {
                    i2 = (int) Double.parseDouble(map2.get(ATAdConst.KEY.AD_WIDTH).toString());
                } catch (Throwable th) {
                    th.printStackTrace();
                    i2 = 0;
                }
            } else {
                i2 = 0;
            }
            if (map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
                try {
                    i3 = (int) Double.parseDouble(map2.get(ATAdConst.KEY.AD_HEIGHT).toString());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            i = i3;
            i3 = i2;
        } else {
            i = 0;
        }
        this.a = (x) map.get(com.anythink.core.common.d.j.w.a);
        b bVar = new b(context, com.anythink.basead.f.c.b.ADX_OFFER_REQUEST_TYPE, this.a);
        this.c = bVar;
        bVar.a(new com.anythink.basead.f.d.a().c(i4).b(string).g(i3).h(i).a());
        AdxATInitManager.getInstance();
        AdxATInitManager.a(getTrackingInfo(), this.a);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        this.d = null;
        b bVar = this.c;
        if (bVar != null) {
            bVar.a((a) null);
            this.c.b();
            this.c = null;
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

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        AdxATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 2);
    }
}
