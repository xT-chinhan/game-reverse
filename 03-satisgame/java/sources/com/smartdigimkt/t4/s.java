package com.smartdigimkt.t4;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    public static final long DEFAULT_SPLASH_TIMEOUT_TIME = 5000;
    protected final Object M_LOCK = new Object();
    private volatile com.smartdigimkt.h3.b activeAdLoadLatencyTrace;
    protected com.smartdigimkt.k1.d mCacheAd;

    public final void activateAdLoadLatencyTrace(com.smartdigimkt.h3.b bVar) {
        this.activeAdLoadLatencyTrace = bVar;
    }

    public boolean checkReady() {
        com.smartdigimkt.k1.d dVar = this.mCacheAd;
        boolean zD = dVar != null ? dVar.d() : false;
        if (!zD) {
            this.mCacheAd = null;
        }
        return zD;
    }

    public final com.smartdigimkt.h3.b createAdLoadLatencyTrace(int i) {
        String placementId = getPlacementId();
        getFormat();
        return new com.smartdigimkt.h3.b(placementId);
    }

    public void destroy() {
        synchronized (this.M_LOCK) {
            onDestroy();
            com.smartdigimkt.k1.d dVar = this.mCacheAd;
            if (dVar != null) {
                dVar.c();
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
        return checkReady();
    }

    public final void markAdLoadInternalReady(com.smartdigimkt.h3.b bVar) {
        if (bVar != null) {
            bVar.c();
            bVar.d();
        }
    }

    public void notifyShow() {
        com.smartdigimkt.k1.d dVar = this.mCacheAd;
        if (dVar != null) {
            dVar.e();
        }
    }

    public abstract void onDestroy();
}
