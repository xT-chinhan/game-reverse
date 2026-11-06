package com.smartdigimkt.t4;

import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.format.SDMLossInfo;
import com.smartdigimkt.sdk.api.format.SDMWinInfo;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o {
    public static final long DEFAULT_SPLASH_TIMEOUT_TIME = 5000;
    private volatile com.smartdigimkt.h3.b activeAdLoadLatencyTrace;
    protected com.smartdigimkt.e1.d mCacheAd;
    protected final Object M_LOCK = new Object();
    private final AtomicBoolean adxFillTiming3000022Reported = new AtomicBoolean(false);
    private final g mAdCallbackHandler = new a();

    public final void activateAdLoadLatencyTrace(com.smartdigimkt.h3.b bVar) {
        this.adxFillTiming3000022Reported.set(false);
        this.activeAdLoadLatencyTrace = bVar;
    }

    public boolean checkReady(boolean z) {
        boolean zA;
        int i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.smartdigimkt.e1.d dVar = this.mCacheAd;
        if (dVar != null) {
            int iB = dVar.b();
            zA = this.mCacheAd.a(iB);
            if (iB == 1) {
                com.smartdigimkt.e1.d dVar2 = this.mCacheAd;
                SDMLossInfo sDMLossInfoNewInternalLossInfo = SDMLossInfo.newInternalLossInfo(4);
                if (dVar2 != null && sDMLossInfoNewInternalLossInfo != null) {
                    d0.a(dVar2, sDMLossInfoNewInternalLossInfo);
                }
                destroy();
            }
            i = iB;
        } else {
            zA = false;
            i = 0;
        }
        if (z) {
            com.smartdigimkt.n3.k.a(zA, getPlacementId(), this.mCacheAd, System.currentTimeMillis() - jCurrentTimeMillis, i);
            com.smartdigimkt.e1.d dVar3 = this.mCacheAd;
            if (!zA || dVar3 == null) {
                com.smartdigimkt.r4.w.a(getPlacementId(), com.smartdigimkt.r4.j.a(String.valueOf(getFormat())), "isready", String.valueOf(false), "");
            } else if (dVar3.c != null) {
                com.smartdigimkt.r4.w.a(getPlacementId(), com.smartdigimkt.r4.j.a(String.valueOf(getFormat())), "isready", String.valueOf(true), "");
            }
        }
        if (!zA) {
            this.mCacheAd = null;
        }
        return zA;
    }

    public final com.smartdigimkt.h3.b createAdLoadLatencyTrace(int i) {
        String placementId = getPlacementId();
        getFormat();
        return new com.smartdigimkt.h3.b(placementId);
    }

    public void destroy() {
        synchronized (this.M_LOCK) {
            onDestroy();
            com.smartdigimkt.e1.d dVar = this.mCacheAd;
            if (dVar != null) {
                dVar.a();
                this.mCacheAd = null;
            }
        }
    }

    public final void finishAdLoadLatency(com.smartdigimkt.h3.b bVar, String str, AdError adError) {
        if (bVar == null) {
            return;
        }
        if (adError != null) {
            adError.getCode();
        }
        bVar.b();
        synchronized (this.M_LOCK) {
            if (this.activeAdLoadLatencyTrace == bVar) {
                this.activeAdLoadLatencyTrace = null;
            }
        }
    }

    public final com.smartdigimkt.h3.b getActiveAdLoadLatencyTrace() {
        return this.activeAdLoadLatencyTrace;
    }

    public abstract int getFormat();

    public abstract String getPlacementId();

    public boolean isAdReady() {
        return checkReady(true);
    }

    public final void markAdLoadInternalReady(com.smartdigimkt.h3.b bVar) {
        if (bVar != null) {
            bVar.c();
            bVar.d();
        }
    }

    public void notifyShow() {
        sendWinFallbackIfNeeded();
        com.smartdigimkt.e1.d dVar = this.mCacheAd;
        if (dVar != null) {
            dVar.c();
        }
    }

    public abstract void onDestroy();

    public void printAdStatusLog(String str, String str2, String str3) {
        printAdStatusLog(str, str2, str3, null);
    }

    public void printApiLog(String str, String str2, String str3) {
        com.smartdigimkt.r4.w.a(getPlacementId(), com.smartdigimkt.r4.j.a(String.valueOf(getFormat())), str, str2, str3);
    }

    public void sendLoss(SDMLossInfo sDMLossInfo) {
        com.smartdigimkt.e1.d dVar = this.mCacheAd;
        if (dVar == null || sDMLossInfo == null) {
            return;
        }
        if (SDMLossInfo.isInternalLossReason(sDMLossInfo.getLossReasonCode())) {
            sDMLossInfo.getLossReasonCode();
        } else {
            d0.a(dVar, sDMLossInfo);
        }
    }

    public void sendWin(SDMWinInfo sDMWinInfo) {
        d0.a(this.mCacheAd, sDMWinInfo);
    }

    public void sendWinFallbackIfNeeded() {
        d0.b(this.mCacheAd);
    }

    public final void tryReportAdxFillTiming3000022(com.smartdigimkt.e1.d dVar, String str, com.smartdigimkt.h3.b bVar) {
        com.smartdigimkt.n3.m.a(getPlacementId(), dVar, str, bVar, this.adxFillTiming3000022Reported);
    }

    public void printAdStatusLog(String str, String str2, String str3, AdError adError) {
        g gVar = this.mAdCallbackHandler;
        ((a) gVar).a = this.mCacheAd;
        a.a(gVar, str, str2, adError);
        com.smartdigimkt.e1.d dVar = this.mCacheAd;
        com.smartdigimkt.r4.w.a(dVar != null ? dVar.l : null, str, str2, str3);
    }
}
