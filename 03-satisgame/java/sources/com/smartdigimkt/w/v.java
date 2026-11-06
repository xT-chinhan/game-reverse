package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferNative;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements com.smartdigimkt.t4.p {
    final /* synthetic */ SDMMyOfferNative this$0;

    public v(SDMMyOfferNative sDMMyOfferNative) {
        this.this$0 = sDMMyOfferNative;
    }

    @Override // com.smartdigimkt.t4.p
    public void onAdLoadFail(AdError adError) {
        com.smartdigimkt.h3.b activeAdLoadLatencyTrace = this.this$0.getActiveAdLoadLatencyTrace();
        this.this$0.markAdLoadInternalReady(activeAdLoadLatencyTrace);
        synchronized (((com.smartdigimkt.t4.s) this.this$0).M_LOCK) {
            this.this$0.isLoading = false;
        }
        com.smartdigimkt.q3.f.a().a(new u(this, activeAdLoadLatencyTrace, adError));
    }

    @Override // com.smartdigimkt.t4.p
    public void onAdLoaded(com.smartdigimkt.k1.d dVar) {
        com.smartdigimkt.h3.b activeAdLoadLatencyTrace = this.this$0.getActiveAdLoadLatencyTrace();
        this.this$0.markAdLoadInternalReady(activeAdLoadLatencyTrace);
        synchronized (((com.smartdigimkt.t4.s) this.this$0).M_LOCK) {
            this.this$0.isLoading = false;
        }
        com.smartdigimkt.q3.f.a().a(new t(this, dVar, activeAdLoadLatencyTrace));
    }
}
