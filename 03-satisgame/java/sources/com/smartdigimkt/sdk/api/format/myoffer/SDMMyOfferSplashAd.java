package com.smartdigimkt.sdk.api.format.myoffer;

import android.content.Context;
import android.view.ViewGroup;
import com.anythink.core.api.ErrorCode;
import com.smartdigimkt.h3.b;
import com.smartdigimkt.k1.d;
import com.smartdigimkt.k1.o;
import com.smartdigimkt.k1.p;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMSplashListener;
import com.smartdigimkt.t4.r;
import com.smartdigimkt.t4.s;
import com.smartdigimkt.w.c0;
import com.smartdigimkt.w.d0;
import com.smartdigimkt.w.i0;
import com.smartdigimkt.w.j0;
import com.smartdigimkt.z3.a;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SDMMyOfferSplashAd extends s {
    private volatile boolean isLoading;
    private Context mContext;
    private SDMSplashListener mDevListener;
    private long mFetchAdTimeout;
    private String mPlacementId;
    private r mSdmAdLoadManager;

    public SDMMyOfferSplashAd(Context context, String str) {
        this(context, str, 0L);
    }

    private void loadInternal(SDMAdRequest sDMAdRequest, b bVar) {
        synchronized (this.M_LOCK) {
            if (this.isLoading) {
                a aVarA = com.smartdigimkt.z3.b.a(ErrorCode.placementIdError, "");
                markAdLoadInternalReady(bVar);
                f.a().a(new c0(this, bVar, aVarA));
            } else if (checkReady()) {
                markAdLoadInternalReady(bVar);
                f.a().a(new d0(this, bVar));
            } else {
                activateAdLoadLatencyTrace(bVar);
                this.isLoading = true;
                f.a().c(new i0(this, bVar, sDMAdRequest));
            }
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
        return 4;
    }

    @Override // com.smartdigimkt.t4.s
    public String getPlacementId() {
        return this.mPlacementId;
    }

    public boolean isSupportCustomSkipView() {
        d dVar = this.mCacheAd;
        return dVar != null && (dVar instanceof p);
    }

    public void load() {
        load(null);
    }

    @Override // com.smartdigimkt.t4.s
    public void onDestroy() {
        this.mDevListener = null;
    }

    public void setListener(SDMSplashListener sDMSplashListener) {
        this.mDevListener = sDMSplashListener;
    }

    public void show(ViewGroup viewGroup) {
        if (!checkReady()) {
            SDMSplashListener sDMSplashListener = this.mDevListener;
            if (sDMSplashListener != null) {
                sDMSplashListener.onAdShowFail(com.smartdigimkt.z3.b.a("20002", "show fail without ad cache"));
                return;
            }
            return;
        }
        notifyShow();
        if (!(this.mCacheAd instanceof p)) {
            SDMSplashListener sDMSplashListener2 = this.mDevListener;
            if (sDMSplashListener2 != null) {
                sDMSplashListener2.onAdShowFail(com.smartdigimkt.z3.b.a("20002", "show fail by " + this.mCacheAd));
                return;
            }
            return;
        }
        ((p) this.mCacheAd).i = new j0(this, new WeakReference((p) this.mCacheAd));
        p pVar = (p) this.mCacheAd;
        pVar.k = ((Boolean) k.a(pVar.h, SDMAdConst.EXTRA_PARAMS.SHOW_HIDE_SPLASH_SKIP_VIEW, Boolean.FALSE)).booleanValue();
        f.a().a(new o(pVar, viewGroup));
    }

    public SDMMyOfferSplashAd(Context context, String str, long j) {
        this.isLoading = false;
        this.mPlacementId = str;
        this.mFetchAdTimeout = j;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        this.mSdmAdLoadManager = new r(4, str);
    }

    public void load(SDMAdRequest sDMAdRequest) {
        loadInternal(sDMAdRequest, createAdLoadLatencyTrace(0));
    }
}
