package com.smartdigimkt.sdk.api.format;

import android.content.Context;
import android.view.ViewGroup;
import com.anythink.core.api.ErrorCode;
import com.smartdigimkt.e1.d;
import com.smartdigimkt.e1.i;
import com.smartdigimkt.e1.j;
import com.smartdigimkt.g1.c;
import com.smartdigimkt.h3.b;
import com.smartdigimkt.j1.t;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.t4.l;
import com.smartdigimkt.t4.n;
import com.smartdigimkt.t4.o;
import com.smartdigimkt.v.d0;
import com.smartdigimkt.v.e0;
import com.smartdigimkt.v.j0;
import com.smartdigimkt.z.c0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class SDMSplashAd extends o implements SDMAdHandler {
    private volatile boolean isLoading;
    private Context mContext;
    private SDMSplashListener mDevListener;
    private long mFetchAdTimeout;
    private String mPlacementId;
    private n mSdmAdLoadManager;

    public SDMSplashAd(Context context, String str) {
        this(context, str, 0L);
    }

    private void loadInternal(SDMAdRequest sDMAdRequest, b bVar) {
        synchronized (this.M_LOCK) {
            if (this.isLoading) {
                com.smartdigimkt.z3.a aVarA = com.smartdigimkt.z3.b.a(ErrorCode.placementIdError, "");
                markAdLoadInternalReady(bVar);
                f.a().a(new d0(this, bVar, aVarA));
            } else if (checkReady(false)) {
                markAdLoadInternalReady(bVar);
                f.a().a(new e0(this, bVar));
            } else {
                activateAdLoadLatencyTrace(bVar);
                this.isLoading = true;
                f.a().c(new j0(this, bVar, sDMAdRequest));
            }
        }
    }

    @Override // com.smartdigimkt.t4.o
    public int getFormat() {
        return 4;
    }

    @Override // com.smartdigimkt.t4.o
    public String getPlacementId() {
        return this.mPlacementId;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdHandler
    public SDMAd getSDMAd() {
        d dVar = this.mCacheAd;
        if (dVar != null) {
            return new l(dVar);
        }
        return null;
    }

    public boolean isSupportCustomSkipView() {
        d dVar = this.mCacheAd;
        if (dVar == null || !(dVar instanceof j)) {
            return false;
        }
        j jVar = (j) dVar;
        return (c0.g(jVar.e, jVar.c) || c0.h(jVar.e, jVar.c)) ? false : true;
    }

    public void load() {
        load(null);
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdHandler
    public void notifyLoss(SDMLossInfo sDMLossInfo) {
        sendLoss(sDMLossInfo);
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdHandler
    public void notifyWin(SDMWinInfo sDMWinInfo) {
        sendWin(sDMWinInfo);
    }

    @Override // com.smartdigimkt.t4.o
    public void onDestroy() {
        this.mDevListener = null;
    }

    public void setListener(SDMSplashListener sDMSplashListener) {
        this.mDevListener = sDMSplashListener;
    }

    public void show(ViewGroup viewGroup) {
        if (!checkReady(false)) {
            SDMSplashListener sDMSplashListener = this.mDevListener;
            if (sDMSplashListener != null) {
                sDMSplashListener.onAdShowFail(com.smartdigimkt.z3.b.a("20002", "show fail without ad cache"));
                return;
            }
            return;
        }
        this.mCacheAd.d();
        notifyShow();
        if (!(this.mCacheAd instanceof j)) {
            SDMSplashListener sDMSplashListener2 = this.mDevListener;
            if (sDMSplashListener2 != null) {
                sDMSplashListener2.onAdShowFail(com.smartdigimkt.z3.b.a("20002", "show fail by " + this.mCacheAd));
                return;
            }
            return;
        }
        WeakReference weakReference = new WeakReference((j) this.mCacheAd);
        d dVar = this.mCacheAd;
        a aVar = new a(this, weakReference);
        dVar.getClass();
        t tVar = new t(dVar, aVar);
        dVar.f = tVar;
        c cVar = dVar.i;
        if (cVar != null) {
            cVar.c = tVar;
        }
        printApiLog("show", "start", "");
        j jVar = (j) this.mCacheAd;
        jVar.getClass();
        com.smartdigimkt.o3.d.a = false;
        jVar.p = ((Boolean) k.a(jVar.h, SDMAdConst.EXTRA_PARAMS.SHOW_HIDE_SPLASH_SKIP_VIEW, Boolean.FALSE)).booleanValue();
        f.a().a(new i(jVar, viewGroup));
    }

    public SDMSplashAd(Context context, String str, long j) {
        this.isLoading = false;
        this.mPlacementId = str;
        this.mFetchAdTimeout = j;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        this.mSdmAdLoadManager = new n(4, str);
    }

    public void load(SDMAdRequest sDMAdRequest) {
        loadInternal(sDMAdRequest, createAdLoadLatencyTrace(0));
    }
}
