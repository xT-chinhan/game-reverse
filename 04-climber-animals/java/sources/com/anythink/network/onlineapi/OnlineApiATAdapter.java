package com.anythink.network.onlineapi;

import android.content.Context;
import com.anythink.basead.f.a;
import com.anythink.basead.f.c;
import com.anythink.basead.f.f;
import com.anythink.basead.g.d;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.d.j;
import com.anythink.core.common.h.x;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class OnlineApiATAdapter extends CustomNativeAdapter {
    f a;
    x b;
    String c;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return "";
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    private void a(Context context, Map<String, Object> map) {
        this.c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        this.b = (x) map.get(j.w.a);
        this.a = new f(context, c.b.ONLINE_API_OFFER_REQUEST_TYPE, this.b, false);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        if (this.a != null) {
            this.a = null;
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.c;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        int i;
        int i2;
        this.c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        this.b = (x) map.get(j.w.a);
        this.a = new f(context, c.b.ONLINE_API_OFFER_REQUEST_TYPE, this.b, false);
        int iMin = -1;
        if (map2 != null) {
            try {
                i = Integer.parseInt(map2.get(ATAdConst.KEY.AD_WIDTH).toString());
            } catch (Throwable unused) {
                i = -1;
            }
            try {
                iMin = Integer.parseInt(map2.get(ATAdConst.KEY.AD_HEIGHT).toString());
            } catch (Throwable unused2) {
            }
            i2 = iMin;
            iMin = i;
        } else {
            i2 = -1;
        }
        final int i3 = context.getResources().getDisplayMetrics().widthPixels;
        final int i4 = context.getResources().getDisplayMetrics().heightPixels;
        if (iMin <= 0) {
            iMin = Math.min(i3, i4);
        }
        if (i2 <= 0) {
            i2 = (iMin * 3) / 4;
        }
        if (iMin <= i3) {
            i3 = iMin;
        }
        if (i2 <= i4) {
            i4 = i2;
        }
        final Context applicationContext = context.getApplicationContext();
        this.a.a(new d() { // from class: com.anythink.network.onlineapi.OnlineApiATAdapter.1
            @Override // com.anythink.basead.g.d
            public final void onNativeAdLoaded(a... aVarArr) {
                OnlineApiATNativeAd[] onlineApiATNativeAdArr = new OnlineApiATNativeAd[aVarArr.length];
                for (int i5 = 0; i5 < aVarArr.length; i5++) {
                    aVarArr[i5].a(i3, i4);
                    onlineApiATNativeAdArr[i5] = new OnlineApiATNativeAd(applicationContext, aVarArr[i5]);
                }
                if (OnlineApiATAdapter.this.mLoadListener != null) {
                    OnlineApiATAdapter.this.mLoadListener.onAdCacheLoaded(onlineApiATNativeAdArr);
                }
            }

            @Override // com.anythink.basead.g.d
            public final void onNativeAdLoadError(com.anythink.basead.d.f fVar) {
                if (OnlineApiATAdapter.this.mLoadListener != null) {
                    OnlineApiATAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
                }
            }
        });
    }
}
