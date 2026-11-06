package com.smartdigimkt.sdk.api.format.myoffer;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ErrorCode;
import com.smartdigimkt.h3.b;
import com.smartdigimkt.j1.g;
import com.smartdigimkt.k1.d;
import com.smartdigimkt.k1.m;
import com.smartdigimkt.k1.n;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMRewardVideoListener;
import com.smartdigimkt.sdk.basead.ui.BaseATActivity;
import com.smartdigimkt.t4.p;
import com.smartdigimkt.t4.q;
import com.smartdigimkt.t4.r;
import com.smartdigimkt.t4.s;
import com.smartdigimkt.w.a0;
import com.smartdigimkt.w.b0;
import com.smartdigimkt.w.z;
import com.smartdigimkt.z3.a;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SDMMyOfferRewardedVideoAd extends s {
    private Context mContext;
    private SDMRewardVideoListener mDevListener;
    private String mPlacementId;
    private final r mSdmAdLoadManager;
    private volatile boolean isLoading = false;
    private final p mLoadListener = new z(this);

    public SDMMyOfferRewardedVideoAd(Context context, String str) {
        this.mPlacementId = str;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        this.mSdmAdLoadManager = new r(1, str);
    }

    private void loadInternal(SDMAdRequest sDMAdRequest, b bVar) {
        synchronized (this.M_LOCK) {
            if (this.isLoading) {
                a aVarA = com.smartdigimkt.z3.b.a(ErrorCode.placementIdError, "");
                markAdLoadInternalReady(bVar);
                f.a().a(new a0(this, bVar, aVarA));
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
            f.a().c(new q(rVar, bVar, context, 0, sDMAdRequest, pVar));
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
        return 1;
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

    public void setListener(SDMRewardVideoListener sDMRewardVideoListener) {
        this.mDevListener = sDMRewardVideoListener;
    }

    public void show(Activity activity) {
        if (!checkReady()) {
            SDMRewardVideoListener sDMRewardVideoListener = this.mDevListener;
            if (sDMRewardVideoListener != null) {
                sDMRewardVideoListener.onAdPlayFailed(com.smartdigimkt.z3.b.a("20002", "show fail without ad cache"));
                return;
            }
            return;
        }
        notifyShow();
        d dVar = this.mCacheAd;
        if (!(dVar instanceof n)) {
            SDMRewardVideoListener sDMRewardVideoListener2 = this.mDevListener;
            if (sDMRewardVideoListener2 != null) {
                sDMRewardVideoListener2.onAdPlayFailed(com.smartdigimkt.z3.b.a("20002", "show fail by " + this.mCacheAd));
                return;
            }
            return;
        }
        ((n) dVar).i = new b0(this);
        n nVar = (n) this.mCacheAd;
        nVar.getClass();
        try {
            if (nVar.a == null) {
                g gVar = nVar.i;
                if (gVar != null) {
                    gVar.onShowFailed(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.i, com.anythink.core.common.inner.b.b.H));
                }
            } else {
                String str = (String) k.a(nVar.h, "extra_scenario", "");
                String str2 = nVar.b.g;
                int iY = h.y(activity);
                String str3 = nVar.b.b + nVar.c + System.currentTimeMillis();
                com.smartdigimkt.j1.b.a.a.put(str3, new m(nVar, str3));
                com.smartdigimkt.b3.a aVar = new com.smartdigimkt.b3.a();
                aVar.c = nVar.e;
                aVar.d = str3;
                aVar.a = 1;
                aVar.f = nVar.b;
                aVar.e = iY;
                aVar.b = str;
                BaseATActivity.a(activity, aVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
            g gVar2 = nVar.i;
            if (gVar2 != null) {
                gVar2.onShowFailed(new com.smartdigimkt.h0.g("-9999", e.getMessage()));
            }
        }
    }

    public void load(SDMAdRequest sDMAdRequest) {
        loadInternal(sDMAdRequest, createAdLoadLatencyTrace(0));
    }
}
