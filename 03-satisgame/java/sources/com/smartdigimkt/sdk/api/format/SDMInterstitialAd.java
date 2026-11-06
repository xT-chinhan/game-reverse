package com.smartdigimkt.sdk.api.format;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ErrorCode;
import com.smartdigimkt.e1.d;
import com.smartdigimkt.g1.c;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.h3.b;
import com.smartdigimkt.j1.h;
import com.smartdigimkt.j1.t;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.t4.l;
import com.smartdigimkt.t4.m;
import com.smartdigimkt.t4.n;
import com.smartdigimkt.t4.o;
import com.smartdigimkt.t4.p;
import com.smartdigimkt.v.q;
import com.smartdigimkt.v.r;
import com.smartdigimkt.v.s;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SDMInterstitialAd extends o implements SDMAdHandler {
    private Context mContext;
    private SDMInterstitialListener mDevListener;
    private String mPlacementId;
    private n mSdmAdLoadManager;
    private volatile boolean isLoading = false;
    private p mLoadListener = new q(this);

    public SDMInterstitialAd(Context context, String str) {
        this.mPlacementId = str;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        this.mSdmAdLoadManager = new n(3, str);
    }

    private void loadInternal(SDMAdRequest sDMAdRequest, b bVar) {
        synchronized (this.M_LOCK) {
            if (this.isLoading) {
                com.smartdigimkt.z3.a aVarA = com.smartdigimkt.z3.b.a(ErrorCode.placementIdError, "");
                markAdLoadInternalReady(bVar);
                f.a().a(new r(this, bVar, aVarA));
                return;
            }
            activateAdLoadLatencyTrace(bVar);
            if (checkReady(false)) {
                this.mLoadListener.onAdLoaded(this.mCacheAd);
                return;
            }
            this.isLoading = true;
            n nVar = this.mSdmAdLoadManager;
            Context context = this.mContext;
            p pVar = this.mLoadListener;
            nVar.getClass();
            f.a().c(new m(nVar, bVar, context, 0, sDMAdRequest, pVar));
        }
    }

    @Override // com.smartdigimkt.t4.o
    public int getFormat() {
        return 3;
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

    public void setListener(SDMInterstitialListener sDMInterstitialListener) {
        this.mDevListener = sDMInterstitialListener;
    }

    public void show(Activity activity) {
        if (!checkReady(false)) {
            SDMInterstitialListener sDMInterstitialListener = this.mDevListener;
            if (sDMInterstitialListener != null) {
                sDMInterstitialListener.onAdShowFail(com.smartdigimkt.z3.b.a("20002", "show fail without ad cache"));
                return;
            }
            return;
        }
        this.mCacheAd.d();
        notifyShow();
        d dVar = this.mCacheAd;
        if (!(dVar instanceof com.smartdigimkt.e1.f)) {
            SDMInterstitialListener sDMInterstitialListener2 = this.mDevListener;
            if (sDMInterstitialListener2 != null) {
                sDMInterstitialListener2.onAdShowFail(com.smartdigimkt.z3.b.a("20002", "show fail by " + this.mCacheAd));
                return;
            }
            return;
        }
        s sVar = new s(this);
        dVar.getClass();
        t tVar = new t(dVar, sVar);
        dVar.f = tVar;
        c cVar = dVar.i;
        if (cVar != null) {
            cVar.c = tVar;
        }
        printApiLog("show", "start", "");
        com.smartdigimkt.e1.f fVar = (com.smartdigimkt.e1.f) this.mCacheAd;
        fVar.getClass();
        try {
            Map map = fVar.h;
            if (map == null) {
                map = new HashMap(2);
            }
            Map map2 = map;
            fVar.i.a(activity, map2, fVar.c.b + fVar.c.f + fVar.c.k + fVar.e.a + System.currentTimeMillis(), (String) k.a(map2, "extra_scenario", ""), fVar.c != null ? fVar.c.g + fVar.c.f : "");
        } catch (Exception e) {
            e.printStackTrace();
            t tVar2 = fVar.f;
            if (tVar2 != null) {
                tVar2.a(new h(new g("-9999", e.getMessage())));
            }
        }
    }

    public void load(SDMAdRequest sDMAdRequest) {
        loadInternal(sDMAdRequest, createAdLoadLatencyTrace(0));
    }
}
