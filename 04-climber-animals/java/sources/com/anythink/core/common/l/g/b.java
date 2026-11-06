package com.anythink.core.common.l.g;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingListenerExt;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.y;
import com.anythink.core.common.res.e;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ATBiddingListenerExt {
    private final ATBiddingListener a;
    private final com.anythink.core.common.l.d.b b;

    public b(ATBiddingListener aTBiddingListener, com.anythink.core.common.l.d.b bVar) {
        this.a = aTBiddingListener;
        this.b = bVar;
    }

    @Override // com.anythink.core.api.ATBiddingListener
    public final void onC2SBidResult(ATBiddingResult aTBiddingResult) {
        ATBiddingListener aTBiddingListener = this.a;
        if (aTBiddingListener != null) {
            aTBiddingListener.onC2SBidResult(aTBiddingResult);
        }
    }

    @Override // com.anythink.core.api.ATBiddingListener
    public final void onC2SBiddingResultWithCache(final ATBiddingResult aTBiddingResult, final BaseAd baseAd) {
        com.anythink.core.common.l.d.b bVar;
        if (!aTBiddingResult.isSuccessWithUseType() || (bVar = this.b) == null || !bVar.l()) {
            ATBiddingListener aTBiddingListener = this.a;
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(aTBiddingResult, baseAd);
                return;
            }
            return;
        }
        if (baseAd != null) {
            boolean zEquals = String.valueOf(this.b.e()).equals("2") ? ((String) this.b.a("size", "")).equals(y.c) : true;
            this.b.a(baseAd.getNetworkInfoMap());
            if (TextUtils.isEmpty(baseAd.getMainImageUrl()) && baseAd.getAdMediaView(new Object[0]) == null && zEquals) {
                ATBiddingListener aTBiddingListener2 = this.a;
                if (aTBiddingListener2 != null) {
                    aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail("load fail with no main image."), null);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(baseAd.getMainImageUrl())) {
                ATBiddingListener aTBiddingListener3 = this.a;
                if (aTBiddingListener3 != null) {
                    aTBiddingListener3.onC2SBiddingResultWithCache(aTBiddingResult, new d(baseAd, this.b.a()));
                    return;
                }
                return;
            }
            com.anythink.core.common.res.b.a(t.b().g()).a(new e(2, baseAd.getMainImageUrl()), 0, 0, new com.anythink.core.common.res.b.a() { // from class: com.anythink.core.common.l.g.b.1
                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (!TextUtils.equals(str, baseAd.getMainImageUrl()) || b.this.a == null) {
                        return;
                    }
                    b.this.a.onC2SBiddingResultWithCache(aTBiddingResult, new d(baseAd, b.this.b.a()));
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                    if (b.this.a != null) {
                        b.this.a.onC2SBiddingResultWithCache(ATBiddingResult.fail("load image failed: ".concat(String.valueOf(str2))), null);
                    }
                }
            });
            return;
        }
        ATBiddingListener aTBiddingListener4 = this.a;
        if (aTBiddingListener4 != null) {
            aTBiddingListener4.onC2SBiddingResultWithCache(ATBiddingResult.fail("load fail with no adObject"), null);
        }
    }

    @Override // com.anythink.core.api.ATBiddingListenerExt
    public final void onC2SBiddingResultWithData(ATBiddingResult aTBiddingResult, BaseAd baseAd) {
        ATBiddingListener aTBiddingListener = this.a;
        if (aTBiddingListener instanceof ATBiddingListenerExt) {
            ((ATBiddingListenerExt) aTBiddingListener).onC2SBiddingResultWithData(aTBiddingResult, baseAd);
        }
    }
}
