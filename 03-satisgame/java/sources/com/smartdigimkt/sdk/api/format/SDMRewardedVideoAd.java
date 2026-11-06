package com.smartdigimkt.sdk.api.format;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ErrorCode;
import com.smartdigimkt.e1.d;
import com.smartdigimkt.e1.h;
import com.smartdigimkt.g1.c;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.h3.b;
import com.smartdigimkt.j1.t;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.t4.l;
import com.smartdigimkt.t4.m;
import com.smartdigimkt.t4.n;
import com.smartdigimkt.t4.o;
import com.smartdigimkt.t4.p;
import com.smartdigimkt.v.a0;
import com.smartdigimkt.v.b0;
import com.smartdigimkt.v.c0;
import com.smartdigimkt.v.z;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SDMRewardedVideoAd extends o implements SDMAdHandler {
    private Context mContext;
    private volatile SDMAdDeepRewardResultListener mDeepRewardListener;
    private SDMRewardVideoListener mDevListener;
    private String mPlacementId;
    private final n mSdmAdLoadManager;
    private volatile boolean isLoading = false;
    private final p mLoadListener = new z(this);

    public SDMRewardedVideoAd(Context context, String str) {
        this.mPlacementId = str;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        this.mSdmAdLoadManager = new n(1, str);
    }

    private void loadInternal(SDMAdRequest sDMAdRequest, b bVar) {
        synchronized (this.M_LOCK) {
            if (this.isLoading) {
                com.smartdigimkt.z3.a aVarA = com.smartdigimkt.z3.b.a(ErrorCode.placementIdError, "");
                markAdLoadInternalReady(bVar);
                f.a().a(new a0(this, bVar, aVarA));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDoubleReward(int i) {
        f.a().a(new c0(this, i));
    }

    @Override // com.smartdigimkt.t4.o
    public int getFormat() {
        return 1;
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
        this.mDeepRewardListener = null;
    }

    public void setDeepRewardListener(SDMAdDeepRewardResultListener sDMAdDeepRewardResultListener) {
        this.mDeepRewardListener = sDMAdDeepRewardResultListener;
        hashCode();
    }

    public void setListener(SDMRewardVideoListener sDMRewardVideoListener) {
        this.mDevListener = sDMRewardVideoListener;
    }

    public void show(Activity activity) {
        if (!checkReady(false)) {
            SDMRewardVideoListener sDMRewardVideoListener = this.mDevListener;
            if (sDMRewardVideoListener != null) {
                sDMRewardVideoListener.onAdPlayFailed(com.smartdigimkt.z3.b.a("20002", "show fail without ad cache"));
                return;
            }
            return;
        }
        this.mCacheAd.d();
        notifyShow();
        d dVar = this.mCacheAd;
        if (!(dVar instanceof h)) {
            SDMRewardVideoListener sDMRewardVideoListener2 = this.mDevListener;
            if (sDMRewardVideoListener2 != null) {
                sDMRewardVideoListener2.onAdPlayFailed(com.smartdigimkt.z3.b.a("20002", "show fail by " + this.mCacheAd));
                return;
            }
            return;
        }
        com.smartdigimkt.b3.b bVar = dVar.e;
        if (bVar != null) {
            bVar.h0.clear();
        }
        d dVar2 = this.mCacheAd;
        b0 b0Var = new b0(this);
        dVar2.getClass();
        t tVar = new t(dVar2, b0Var);
        dVar2.f = tVar;
        c cVar = dVar2.i;
        if (cVar != null) {
            cVar.c = tVar;
        }
        printApiLog("show", "start", "");
        h hVar = (h) this.mCacheAd;
        hashCode();
        hVar.p = this.mDeepRewardListener != null;
        try {
            String str = hVar.c.b + hVar.c.f + hVar.c.k + hVar.e.a + System.currentTimeMillis();
            Map map = hVar.h;
            if (map == null) {
                map = new HashMap(2);
            }
            Map map2 = map;
            hVar.i.a(activity, map2, str, (String) k.a(map2, "extra_scenario", ""), hVar.c != null ? hVar.c.g + hVar.c.f : "", hVar.p);
        } catch (Exception e) {
            e.printStackTrace();
            t tVar2 = hVar.f;
            if (tVar2 != null) {
                tVar2.a(new com.smartdigimkt.j1.h(new g("-9999", e.getMessage())));
            }
        }
    }

    public void load(SDMAdRequest sDMAdRequest) {
        loadInternal(sDMAdRequest, createAdLoadLatencyTrace(0));
    }
}
