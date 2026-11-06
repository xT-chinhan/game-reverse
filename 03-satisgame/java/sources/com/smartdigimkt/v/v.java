package com.smartdigimkt.v;

import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.format.SDMNative;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements com.smartdigimkt.t4.p {
    final /* synthetic */ SDMNative this$0;

    public v(SDMNative sDMNative) {
        this.this$0 = sDMNative;
    }

    @Override // com.smartdigimkt.t4.p
    public void onAdLoadFail(AdError adError) {
        com.smartdigimkt.h3.b activeAdLoadLatencyTrace = this.this$0.getActiveAdLoadLatencyTrace();
        this.this$0.markAdLoadInternalReady(activeAdLoadLatencyTrace);
        this.this$0.printAdStatusLog("request_result", "fail", adError != null ? adError.getErrorInfo() : "", adError);
        synchronized (((com.smartdigimkt.t4.o) this.this$0).M_LOCK) {
            this.this$0.isLoading = false;
        }
        com.smartdigimkt.q3.f.a().a(new u(this, activeAdLoadLatencyTrace, adError));
    }

    @Override // com.smartdigimkt.t4.p
    public void onAdLoaded(com.smartdigimkt.e1.d dVar) {
        com.smartdigimkt.h3.b activeAdLoadLatencyTrace = this.this$0.getActiveAdLoadLatencyTrace();
        this.this$0.markAdLoadInternalReady(activeAdLoadLatencyTrace);
        this.this$0.printAdStatusLog("request_result", "success", "");
        synchronized (((com.smartdigimkt.t4.o) this.this$0).M_LOCK) {
            this.this$0.isLoading = false;
        }
        com.smartdigimkt.q3.f.a().a(new t(this, dVar, activeAdLoadLatencyTrace));
    }
}
