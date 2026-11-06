package com.anythink.network.myoffer;

import android.content.Context;
import com.anythink.basead.d.f;
import com.anythink.basead.g.a;
import com.anythink.basead.g.c;
import com.anythink.basead.h.e;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.j;
import com.anythink.core.common.h.x;
import com.anythink.core.common.r;
import com.anythink.core.common.v.p;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MyOfferATAdapter extends CustomNativeAdapter {
    e a;
    x b;
    private String c = "";
    private boolean d = false;

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
            this.b = (x) map.get(j.w.a);
        }
        this.a = new e(context, this.b, this.c, this.d);
        final Context applicationContext = context.getApplicationContext();
        this.a.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATAdapter.1
            @Override // com.anythink.basead.g.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.g.c
            public final void onAdCacheLoaded() {
                if (MyOfferATAdapter.this.getTrackingInfo() != null) {
                    MyOfferATAdapter.this.getTrackingInfo().M(MyOfferATAdapter.this.a.f());
                }
                if (MyOfferATAdapter.this.mLoadListener != null) {
                    MyOfferATAdapter.this.mLoadListener.onAdCacheLoaded(new MyOfferATNativeAd(applicationContext, MyOfferATAdapter.this.a));
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdLoadFailed(f fVar) {
                if (MyOfferATAdapter.this.mLoadListener != null) {
                    MyOfferATAdapter.this.mLoadListener.onAdLoadError(fVar.a(), fVar.b());
                }
            }
        });
    }

    private void a(Context context) {
        this.a = new e(context, this.b, this.c, this.d);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.c = map.get("my_oid").toString();
        }
        if (map.containsKey(j.w.a)) {
            this.b = (x) map.get(j.w.a);
        }
        if (map.containsKey(r.b)) {
            this.d = ((Boolean) map.get(r.b)).booleanValue();
        }
        this.a = new e(context, this.b, this.c, this.d);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public BaseAd getBaseAdObject(Context context) {
        e eVar = this.a;
        if (eVar == null || !eVar.a()) {
            return null;
        }
        return new MyOfferATNativeAd(context, this.a);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a((a) null);
            this.a = null;
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.c;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return p.a();
    }
}
