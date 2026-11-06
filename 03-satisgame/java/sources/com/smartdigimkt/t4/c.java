package com.smartdigimkt.t4;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements p {
    private String mRequestId;
    private volatile boolean mHasReturn = false;
    private volatile boolean isAdTimeout = false;
    private final com.smartdigimkt.m3.a timeOutHandler = com.smartdigimkt.m3.g.a().a;
    private final com.smartdigimkt.m3.b timeoutRunnable = new b(this);

    @Override // com.smartdigimkt.t4.p
    public void onAdLoadFail(AdError adError) {
        this.timeOutHandler.a(this.timeoutRunnable);
        if (this.mHasReturn) {
            return;
        }
        this.mHasReturn = true;
        onAdLoadFail(this.mRequestId, adError);
    }

    public abstract void onAdLoadFail(String str, AdError adError);

    @Override // com.smartdigimkt.t4.p
    public void onAdLoaded(Object obj) {
        this.timeOutHandler.a(this.timeoutRunnable);
        if (this.mHasReturn) {
            return;
        }
        this.mHasReturn = true;
        onAdLoaded(this.mRequestId, this.isAdTimeout, obj);
    }

    public abstract void onAdLoaded(String str, boolean z, Object obj);

    public abstract void onTimeout(String str);

    public void setRequestId(String str) {
        this.mRequestId = str;
    }

    public void startCountDown(long j) {
        this.timeOutHandler.a(this.timeoutRunnable, j);
    }
}
