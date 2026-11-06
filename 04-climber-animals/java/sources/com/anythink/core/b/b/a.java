package com.anythink.core.b.b;

import android.os.SystemClock;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingListenerExt;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.h.n;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements ATBiddingListenerExt {
    private static final String a = "a";
    private final n b;
    private final String c;
    private final Map<String, Object> d;
    private final ATBiddingListener e;
    private volatile boolean f = false;

    public a(n nVar, String str, Map<String, Object> map, ATBiddingListener aTBiddingListener) {
        this.b = nVar;
        this.c = str;
        this.d = map;
        this.e = aTBiddingListener;
    }

    private boolean a() {
        Map<String, Object> map = this.d;
        if (map == null) {
            return false;
        }
        try {
            Object obj = map.get("ad_s_reqf_mode");
            if (obj != null) {
                return obj.toString().equals("2");
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return false;
    }

    @Override // com.anythink.core.api.ATBiddingListener
    public void onC2SBidResult(ATBiddingResult aTBiddingResult) {
        ATBiddingListener aTBiddingListener = this.e;
        if (aTBiddingListener != null) {
            aTBiddingListener.onC2SBidResult(aTBiddingResult);
        }
    }

    @Override // com.anythink.core.api.ATBiddingListener
    public void onC2SBiddingResultWithCache(ATBiddingResult aTBiddingResult, BaseAd baseAd) {
        if (this.f) {
            return;
        }
        this.f = true;
        ATBiddingListener aTBiddingListener = this.e;
        if (aTBiddingListener != null) {
            aTBiddingListener.onC2SBiddingResultWithCache(aTBiddingResult, baseAd);
        }
    }

    @Override // com.anythink.core.api.ATBiddingListenerExt
    public void onC2SBiddingResultWithData(ATBiddingResult aTBiddingResult, BaseAd baseAd) {
        n nVar = this.b;
        if (nVar != null) {
            nVar.u(System.currentTimeMillis());
            this.b.k(SystemClock.elapsedRealtime());
        }
        if (a()) {
            n nVar2 = this.b;
            if (nVar2 != null) {
                nVar2.d();
            }
            onC2SBiddingResultWithCache(aTBiddingResult, baseAd);
        }
    }
}
