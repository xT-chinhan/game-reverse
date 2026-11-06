package com.smartdigimkt.w;

import android.content.Context;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferSplashAd;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements Runnable {
    final /* synthetic */ SDMMyOfferSplashAd this$0;
    final /* synthetic */ SDMAdRequest val$adRequest;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;

    public i0(SDMMyOfferSplashAd sDMMyOfferSplashAd, com.smartdigimkt.h3.b bVar, SDMAdRequest sDMAdRequest) {
        this.this$0 = sDMMyOfferSplashAd;
        this.val$latencyTrace = bVar;
        this.val$adRequest = sDMAdRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j = this.this$0.mFetchAdTimeout;
        if (j <= 0) {
            j = 5000;
        }
        h0 h0Var = new h0(this);
        h0Var.startCountDown(j);
        com.smartdigimkt.t4.r rVar = this.this$0.mSdmAdLoadManager;
        Context context = this.this$0.mContext;
        SDMAdRequest sDMAdRequest = this.val$adRequest;
        com.smartdigimkt.h3.b bVar = this.val$latencyTrace;
        rVar.getClass();
        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t4.q(rVar, bVar, context, 0, sDMAdRequest, h0Var));
    }
}
