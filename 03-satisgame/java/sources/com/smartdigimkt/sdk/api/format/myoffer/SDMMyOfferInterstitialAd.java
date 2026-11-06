package com.smartdigimkt.sdk.api.format.myoffer;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ErrorCode;
import com.smartdigimkt.h3.b;
import com.smartdigimkt.j1.g;
import com.smartdigimkt.k1.d;
import com.smartdigimkt.k1.e;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMInterstitialListener;
import com.smartdigimkt.sdk.basead.ui.BaseATActivity;
import com.smartdigimkt.t4.p;
import com.smartdigimkt.t4.r;
import com.smartdigimkt.t4.s;
import com.smartdigimkt.w.q;
import com.smartdigimkt.z3.a;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SDMMyOfferInterstitialAd extends s {
    private Context mContext;
    private SDMInterstitialListener mDevListener;
    private String mPlacementId;
    private r mSdmAdLoadManager;
    private volatile boolean isLoading = false;
    private p mLoadListener = new q(this);

    public SDMMyOfferInterstitialAd(Context context, String str) {
        this.mPlacementId = str;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        this.mSdmAdLoadManager = new r(3, str);
    }

    private void loadInternal(SDMAdRequest sDMAdRequest, b bVar) {
        synchronized (this.M_LOCK) {
            if (this.isLoading) {
                a aVarA = com.smartdigimkt.z3.b.a(ErrorCode.placementIdError, "");
                markAdLoadInternalReady(bVar);
                f.a().a(new com.smartdigimkt.w.r(this, bVar, aVarA));
                return;
            }
            activateAdLoadLatencyTrace(bVar);
            if (checkReady()) {
                this.mLoadListener.onAdLoaded(this.mCacheAd);
                return;
            }
            this.isLoading = true;
            r rVar = this.mSdmAdLoadManager;
            Context context = this.mContext;
            p pVar = this.mLoadListener;
            rVar.getClass();
            f.a().c(new com.smartdigimkt.t4.q(rVar, bVar, context, 0, sDMAdRequest, pVar));
        }
    }

    public Map<String, Object> getExtraInfoMap() {
        d dVar = this.mCacheAd;
        if (dVar != null) {
            return com.smartdigimkt.z.f.a(dVar.e);
        }
        return null;
    }

    @Override // com.smartdigimkt.t4.s
    public int getFormat() {
        return 3;
    }

    @Override // com.smartdigimkt.t4.s
    public String getPlacementId() {
        return this.mPlacementId;
    }

    public void load() {
        load(null);
    }

    @Override // com.smartdigimkt.t4.s
    public void onDestroy() {
        this.mDevListener = null;
    }

    public void setListener(SDMInterstitialListener sDMInterstitialListener) {
        this.mDevListener = sDMInterstitialListener;
    }

    public void show(Activity activity) {
        show(activity, null);
    }

    public void load(SDMAdRequest sDMAdRequest) {
        loadInternal(sDMAdRequest, createAdLoadLatencyTrace(0));
    }

    public void show(Activity activity, Map<String, Object> map) {
        if (!checkReady()) {
            SDMInterstitialListener sDMInterstitialListener = this.mDevListener;
            if (sDMInterstitialListener != null) {
                sDMInterstitialListener.onAdShowFail(com.smartdigimkt.z3.b.a("20002", "show fail without ad cache"));
                return;
            }
            return;
        }
        notifyShow();
        d dVar = this.mCacheAd;
        if (!(dVar instanceof com.smartdigimkt.k1.f)) {
            SDMInterstitialListener sDMInterstitialListener2 = this.mDevListener;
            if (sDMInterstitialListener2 != null) {
                sDMInterstitialListener2.onAdShowFail(com.smartdigimkt.z3.b.a("20002", "show fail by " + this.mCacheAd));
                return;
            }
            return;
        }
        ((com.smartdigimkt.k1.f) dVar).i = new com.smartdigimkt.w.s(this);
        com.smartdigimkt.k1.f fVar = (com.smartdigimkt.k1.f) this.mCacheAd;
        fVar.getClass();
        try {
            if (fVar.a == null) {
                g gVar = fVar.i;
                if (gVar != null) {
                    gVar.onShowFailed(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.i, com.anythink.core.common.inner.b.b.H));
                }
            } else {
                String str = (String) k.a(fVar.h, "extra_scenario", "");
                String str2 = fVar.b.g;
                int iY = h.y(activity);
                String str3 = fVar.b.b + fVar.c + System.currentTimeMillis();
                com.smartdigimkt.j1.b.a.a.put(str3, new e(fVar, str3));
                com.smartdigimkt.b3.a aVar = new com.smartdigimkt.b3.a();
                aVar.c = fVar.e;
                aVar.d = str3;
                aVar.a = 3;
                aVar.f = fVar.b;
                aVar.e = iY;
                aVar.b = str;
                BaseATActivity.a(activity, aVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
            g gVar2 = fVar.i;
            if (gVar2 != null) {
                gVar2.onShowFailed(new com.smartdigimkt.h0.g("-9999", e.getMessage()));
            }
        }
    }
}
