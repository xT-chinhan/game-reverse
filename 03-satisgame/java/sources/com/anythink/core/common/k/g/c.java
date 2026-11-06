package com.anythink.core.common.k.g;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATCustomLoadListenerExt;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.y;
import com.anythink.core.common.res.e;

/* JADX INFO: loaded from: classes.dex */
public final class c implements ATCustomLoadListenerExt {
    private final ATCustomLoadListener a;
    private final com.anythink.core.common.k.d.b b;

    public c(ATCustomLoadListener aTCustomLoadListener, com.anythink.core.common.k.d.b bVar) {
        this.b = bVar;
        this.a = aTCustomLoadListener;
    }

    @Override // com.anythink.core.api.ATCustomLoadListener
    public final void onAdDataLoaded() {
        ATCustomLoadListener aTCustomLoadListener = this.a;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdDataLoaded();
        }
    }

    @Override // com.anythink.core.api.ATCustomLoadListener
    public final void onAdCacheLoaded(BaseAd... baseAdArr) {
        final BaseAd baseAd;
        com.anythink.core.common.k.d.b bVar = this.b;
        if (bVar != null && bVar.l()) {
            if (baseAdArr != null && baseAdArr.length > 0 && (baseAd = baseAdArr[0]) != null) {
                this.b.a(baseAd.getNetworkInfoMap());
                boolean zEquals = String.valueOf(this.b.e()).equals("2") ? ((String) this.b.a("size", "")).equals(y.c) : true;
                if (TextUtils.isEmpty(baseAd.getMainImageUrl()) && baseAd.getAdMediaView(new Object[0]) == null && zEquals) {
                    ATCustomLoadListener aTCustomLoadListener = this.a;
                    if (aTCustomLoadListener != null) {
                        aTCustomLoadListener.onAdLoadError("10012", "load fail with no main image.");
                        return;
                    }
                    return;
                }
                if (TextUtils.isEmpty(baseAd.getMainImageUrl())) {
                    this.a.onAdCacheLoaded(new d(baseAd, this.b.a()));
                    return;
                } else if (baseAd.getAdMediaView(new Object[0]) == null) {
                    com.anythink.core.common.res.b.a(s.b().g()).a(new e(2, baseAd.getMainImageUrl()), 0, 0, new com.anythink.core.common.res.b.a() { // from class: com.anythink.core.common.k.g.c.1
                        @Override // com.anythink.core.common.res.b.a
                        public final void onSuccess(String str, Bitmap bitmap) {
                            if (!TextUtils.equals(str, baseAd.getMainImageUrl()) || c.this.a == null) {
                                return;
                            }
                            c.this.a.onAdCacheLoaded(new d(baseAd, c.this.b.a()));
                        }

                        @Override // com.anythink.core.common.res.b.a
                        public final void onFail(String str, String str2) {
                            if (c.this.a != null) {
                                c.this.a.onAdLoadError("10011", "load image fail:".concat(String.valueOf(str2)));
                            }
                        }
                    });
                    return;
                } else {
                    this.a.onAdCacheLoaded(new d(baseAd, this.b.a()));
                    return;
                }
            }
            ATCustomLoadListener aTCustomLoadListener2 = this.a;
            if (aTCustomLoadListener2 != null) {
                aTCustomLoadListener2.onAdLoadError("10011", "load fail with no adObject");
                return;
            }
            return;
        }
        ATCustomLoadListener aTCustomLoadListener3 = this.a;
        if (aTCustomLoadListener3 != null) {
            aTCustomLoadListener3.onAdCacheLoaded(new BaseAd[0]);
        }
    }

    @Override // com.anythink.core.api.ATCustomLoadListener
    public final void onAdLoadError(String str, String str2) {
        ATCustomLoadListener aTCustomLoadListener = this.a;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdLoadError(str, str2);
        }
    }

    @Override // com.anythink.core.api.ATCustomLoadListenerExt
    public final void onAdDataLoadedWithAds(BaseAd... baseAdArr) {
        ATCustomLoadListener aTCustomLoadListener = this.a;
        if (aTCustomLoadListener instanceof ATCustomLoadListenerExt) {
            ((ATCustomLoadListenerExt) aTCustomLoadListener).onAdDataLoadedWithAds(baseAdArr);
        }
    }
}
