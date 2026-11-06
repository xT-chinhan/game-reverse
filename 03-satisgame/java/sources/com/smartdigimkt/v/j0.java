package com.smartdigimkt.v;

import android.content.Context;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMSplashAd;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements Runnable {
    final /* synthetic */ SDMSplashAd this$0;
    final /* synthetic */ SDMAdRequest val$adRequest;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;

    public j0(SDMSplashAd sDMSplashAd, com.smartdigimkt.h3.b bVar, SDMAdRequest sDMAdRequest) {
        this.this$0 = sDMSplashAd;
        this.val$latencyTrace = bVar;
        this.val$adRequest = sDMAdRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j = this.this$0.mFetchAdTimeout;
        if (j <= 0) {
            j = 5000;
        }
        i0 i0Var = new i0(this);
        i0Var.startCountDown(j);
        com.smartdigimkt.t4.n nVar = this.this$0.mSdmAdLoadManager;
        Context context = this.this$0.mContext;
        SDMAdRequest sDMAdRequest = this.val$adRequest;
        com.smartdigimkt.h3.b bVar = this.val$latencyTrace;
        nVar.getClass();
        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t4.m(nVar, bVar, context, 0, sDMAdRequest, i0Var));
    }
}
