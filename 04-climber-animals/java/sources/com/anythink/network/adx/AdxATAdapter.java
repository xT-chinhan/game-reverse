package com.anythink.network.adx;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.f.a;
import com.anythink.basead.f.c;
import com.anythink.basead.f.f;
import com.anythink.basead.g.d;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.j;
import com.anythink.core.common.h.x;
import com.anythink.core.common.k;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class AdxATAdapter extends CustomNativeAdapter {
    f a;
    x b;
    boolean c;
    boolean d;
    String e;
    int f;
    int g;
    JSONArray h;
    private boolean i;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map, map2);
        this.a.a(new d() { // from class: com.anythink.network.adx.AdxATAdapter.1
            @Override // com.anythink.basead.g.d
            public final void onNativeAdLoaded(a... aVarArr) {
                AdxATNativeAd[] adxATNativeAdArr = new AdxATNativeAd[aVarArr.length];
                for (int i = 0; i < aVarArr.length; i++) {
                    a aVar = aVarArr[i];
                    aVar.a(AdxATAdapter.this.f, AdxATAdapter.this.g);
                    aVar.a(AdxATAdapter.this.h);
                    aVar.a(AdxATAdapter.this.d);
                    aVar.a(AdxATAdapter.this.e);
                    adxATNativeAdArr[i] = new AdxATNativeAd(context.getApplicationContext(), aVar, AdxATAdapter.this.b, AdxATAdapter.this.i, AdxATAdapter.this.c);
                }
                if (AdxATAdapter.this.getTrackingInfo() != null) {
                    AdxATAdapter.this.getTrackingInfo().M(AdxATAdapter.this.a.f());
                }
                if (AdxATAdapter.this.mLoadListener != null) {
                    AdxATAdapter.this.mLoadListener.onAdCacheLoaded(adxATNativeAdArr);
                }
            }

            @Override // com.anythink.basead.g.d
            public final void onNativeAdLoadError(com.anythink.basead.d.f fVar) {
                if (AdxATAdapter.this.mLoadListener != null) {
                    AdxATAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
                }
            }
        });
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        int iMin;
        int intFromMap;
        AdxATInitManager.getInstance().initSDK(context, map, null);
        this.i = TextUtils.equals("1", ATInitMediation.getStringFromMap(map, "layout_type"));
        this.b = (x) map.get(j.w.a);
        this.a = new f(context, c.b.ADX_OFFER_REQUEST_TYPE, this.b, this.i);
        this.c = TextUtils.equals("0", ATInitMediation.getStringFromMap(map, k.aM, "0"));
        this.d = TextUtils.equals("0", ATInitMediation.getStringFromMap(map, "v_m", "0"));
        this.e = ATInitMediation.getStringFromMap(map, "video_autoplay", "1");
        if (this.i) {
            AdxATInitManager.getInstance();
            this.h = AdxATInitManager.a(map);
        }
        if (!this.i) {
            this.d = true;
            this.e = ATInitMediation.getStringFromMap(map2, AdxATConst.NATIVE_VIDEO_AUTO_PLAY, "1");
        }
        if (map2 != null) {
            iMin = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH);
            intFromMap = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_HEIGHT);
        } else {
            iMin = -1;
            intFromMap = -1;
        }
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        if (iMin <= 0) {
            iMin = Math.min(i, i2);
        }
        if (iMin <= i) {
            i = iMin;
        }
        if (intFromMap > i2) {
            intFromMap = i2;
        }
        this.f = i;
        this.g = intFromMap;
        AdxATInitManager.getInstance();
        AdxATInitManager.a(getTrackingInfo(), this.b);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map, map2);
        f fVar = this.a;
        if (fVar == null) {
            return true;
        }
        fVar.a(new c.a() { // from class: com.anythink.network.adx.AdxATAdapter.2
            @Override // com.anythink.basead.f.c.a
            public final void onAdCacheLoaded() {
                if (AdxATAdapter.this.getTrackingInfo() != null) {
                    AdxATAdapter.this.getTrackingInfo().M(AdxATAdapter.this.a.f());
                }
            }
        });
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public BaseAd getBaseAdObject(Context context) {
        a aVarA;
        f fVar = this.a;
        if (fVar == null || !fVar.c() || (aVarA = this.a.a()) == null) {
            return null;
        }
        aVarA.a(this.f, this.g);
        aVarA.a(this.h);
        aVarA.a(this.d);
        aVarA.a(this.e);
        AdxATNativeAd adxATNativeAd = new AdxATNativeAd(context.getApplicationContext(), aVarA, this.b, this.i, this.c);
        adxATNativeAd.setNetworkInfoMap(com.anythink.basead.d.a(this.a.d()));
        return adxATNativeAd;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        if (this.a != null) {
            this.a = null;
        }
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
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        AdxATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 0);
    }
}
