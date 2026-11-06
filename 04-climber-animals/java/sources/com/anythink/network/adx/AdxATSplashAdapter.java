package com.anythink.network.adx;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.d;
import com.anythink.basead.d.f;
import com.anythink.basead.f.h;
import com.anythink.basead.g.c;
import com.anythink.basead.g.e;
import com.anythink.basead.g.j;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.a.b;
import com.anythink.core.common.h.x;
import com.anythink.network.tap.TapATInitManager;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdxATSplashAdapter extends CustomSplashAdapter {
    h a;
    x b;
    Map<String, Object> c;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    static /* synthetic */ int i(AdxATSplashAdapter adxATSplashAdapter) {
        adxATSplashAdapter.mDismissType = 3;
        return 3;
    }

    static /* synthetic */ int j(AdxATSplashAdapter adxATSplashAdapter) {
        adxATSplashAdapter.mDismissType = 4;
        return 4;
    }

    static /* synthetic */ int k(AdxATSplashAdapter adxATSplashAdapter) {
        adxATSplashAdapter.mDismissType = 99;
        return 99;
    }

    static /* synthetic */ int l(AdxATSplashAdapter adxATSplashAdapter) {
        adxATSplashAdapter.mDismissType = 2;
        return 2;
    }

    static /* synthetic */ int s(AdxATSplashAdapter adxATSplashAdapter) {
        adxATSplashAdapter.mDismissType = 99;
        return 99;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map, map2);
        this.a.a(new c() { // from class: com.anythink.network.adx.AdxATSplashAdapter.1
            @Override // com.anythink.basead.g.c
            public final void onAdDataLoaded() {
                if (AdxATSplashAdapter.this.mLoadListener != null) {
                    AdxATSplashAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdCacheLoaded() {
                AdxATSplashAdapter adxATSplashAdapter = AdxATSplashAdapter.this;
                adxATSplashAdapter.c = d.a(adxATSplashAdapter.a);
                if (AdxATSplashAdapter.this.getTrackingInfo() != null) {
                    AdxATSplashAdapter.this.getTrackingInfo().M(AdxATSplashAdapter.this.a.f());
                }
                if (AdxATSplashAdapter.this.mLoadListener != null) {
                    AdxATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdLoadFailed(f fVar) {
                if (AdxATSplashAdapter.this.mLoadListener != null) {
                    AdxATSplashAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
                }
            }
        });
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        h hVar = this.a;
        boolean z = hVar != null && hVar.c();
        if (z && this.c == null) {
            this.c = d.a(this.a);
        }
        return z;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (this.a != null) {
            AdxATInitManager.getInstance();
            AdxATInitManager.a(getTrackingInfo(), this.b);
            this.a.a(new e(this.a.d(), getTrackingInfo()) { // from class: com.anythink.network.adx.AdxATSplashAdapter.2
                @Override // com.anythink.basead.g.e, com.anythink.basead.g.a
                public final void onAdShow(j jVar) {
                    super.onAdShow(jVar);
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onSplashAdShow();
                    }
                }

                /* JADX WARN: Code duplicated, block: B:16:0x002b A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:4:0x0008, B:14:0x001f, B:15:0x0025, B:16:0x002b, B:17:0x0031), top: B:24:0x0008 }] */
                @Override // com.anythink.basead.g.a
                public final void onAdClosed() {
                    Map<String, Object> adExtraInfoMap = AdxATSplashAdapter.this.getAdExtraInfoMap();
                    if (adExtraInfoMap != null) {
                        try {
                            int intFromMap = ATInitMediation.getIntFromMap(adExtraInfoMap, b.C0077b.a, 1);
                            if (intFromMap == 2) {
                                AdxATSplashAdapter.i(AdxATSplashAdapter.this);
                            } else if (intFromMap == 3 || intFromMap == 5) {
                                AdxATSplashAdapter.k(AdxATSplashAdapter.this);
                            } else if (intFromMap == 6) {
                                AdxATSplashAdapter.j(AdxATSplashAdapter.this);
                            } else if (intFromMap == 10) {
                                AdxATSplashAdapter.k(AdxATSplashAdapter.this);
                            } else {
                                AdxATSplashAdapter.l(AdxATSplashAdapter.this);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                    }
                }

                @Override // com.anythink.basead.g.e, com.anythink.basead.g.a
                public final void onAdClick(j jVar) {
                    super.onAdClick(jVar);
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
                    }
                }

                @Override // com.anythink.basead.g.a
                public final void onDeeplinkCallback(boolean z) {
                    if ((AdxATSplashAdapter.this.a == null || AdxATSplashAdapter.this.a.g()) && AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onDeeplinkCallback(z);
                    }
                }

                @Override // com.anythink.basead.g.a
                public final void onShowFailed(f fVar) {
                    AdxATSplashAdapter.s(AdxATSplashAdapter.this);
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, fVar.a(), fVar.b()));
                        AdxATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                    }
                }
            });
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

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map, map2);
        h hVar = this.a;
        if (hVar == null) {
            return true;
        }
        hVar.a(new com.anythink.basead.f.c.a() { // from class: com.anythink.network.adx.AdxATSplashAdapter.3
            @Override // com.anythink.basead.f.c.a
            public final void onAdCacheLoaded() {
                if (AdxATSplashAdapter.this.getTrackingInfo() != null) {
                    AdxATSplashAdapter.this.getTrackingInfo().M(AdxATSplashAdapter.this.a.f());
                }
            }
        });
        return true;
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        int i;
        Object obj;
        Object obj2;
        Object obj3;
        AdxATInitManager.getInstance().initSDK(context, map, null);
        int i2 = (!map.containsKey(TapATInitManager.ORIENTATION_KEY) || (obj3 = map.get(TapATInitManager.ORIENTATION_KEY)) == null) ? 1 : Integer.parseInt(obj3.toString());
        int i3 = (!map.containsKey("countdown") || (obj2 = map.get("countdown")) == null) ? 5000 : Integer.parseInt(obj2.toString()) * 1000;
        if (!map.containsKey("allows_skip") || (obj = map.get("allows_skip")) == null || (i = Integer.parseInt(obj.toString())) == 0) {
            i = 1;
        } else if (i == 1) {
            i = 0;
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "end_cls", 1);
        x xVar = (x) map.get(com.anythink.core.common.d.j.w.a);
        this.b = xVar;
        if (xVar != null) {
            xVar.w = new HashMap<>();
            this.b.w.put(TapATInitManager.ORIENTATION_KEY, Integer.valueOf(i2));
            this.b.w.put(ATAdConst.KEY.AD_WIDTH, map2.get(ATAdConst.KEY.AD_WIDTH));
            this.b.w.put(ATAdConst.KEY.AD_HEIGHT, map2.get(ATAdConst.KEY.AD_HEIGHT));
        }
        h hVar = new h(context, com.anythink.basead.f.c.b.ADX_OFFER_REQUEST_TYPE, this.b);
        this.a = hVar;
        hVar.a(new com.anythink.basead.f.d.a().d(i2).e(i3).f(i).i(intFromMap).a());
        AdxATInitManager.getInstance();
        AdxATInitManager.a(getTrackingInfo(), this.b);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return AdxATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        x xVar = this.b;
        return xVar != null ? xVar.b : "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getAdExtraInfoMap() {
        h hVar = this.a;
        if (hVar != null) {
            return hVar.e();
        }
        return null;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        h hVar = this.a;
        return hVar != null && hVar.h();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        AdxATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 4);
    }

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(3, AdxATInterstitialAdapter.class);
        return map;
    }
}
