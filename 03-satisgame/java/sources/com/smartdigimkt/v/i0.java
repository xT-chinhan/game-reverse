package com.smartdigimkt.v;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 extends com.smartdigimkt.t4.c {
    final /* synthetic */ j0 this$1;

    public i0(j0 j0Var) {
        this.this$1 = j0Var;
    }

    @Override // com.smartdigimkt.t4.c
    public void onAdLoadFail(String str, AdError adError) {
        j0 j0Var = this.this$1;
        com.smartdigimkt.h3.b bVar = j0Var.val$latencyTrace;
        j0Var.this$0.markAdLoadInternalReady(bVar);
        this.this$1.this$0.printAdStatusLog("request_result", "fail", adError != null ? adError.getErrorInfo() : "", adError);
        synchronized (((com.smartdigimkt.t4.o) this.this$1.this$0).M_LOCK) {
            this.this$1.this$0.isLoading = false;
        }
        com.smartdigimkt.q3.f.a().a(new g0(this, str, bVar, adError));
    }

    @Override // com.smartdigimkt.t4.c
    public void onTimeout(String str) {
        this.this$1.this$0.printAdStatusLog("request_result", "timeout", "");
        j0 j0Var = this.this$1;
        j0Var.this$0.markAdLoadInternalReady(j0Var.val$latencyTrace);
        com.smartdigimkt.q3.f.a().a(new h0(this, str));
    }

    @Override // com.smartdigimkt.t4.c
    public void onAdLoaded(String str, boolean z, com.smartdigimkt.e1.d dVar) {
        j0 j0Var = this.this$1;
        com.smartdigimkt.h3.b bVar = j0Var.val$latencyTrace;
        j0Var.this$0.markAdLoadInternalReady(bVar);
        synchronized (((com.smartdigimkt.t4.o) this.this$1.this$0).M_LOCK) {
            this.this$1.this$0.isLoading = false;
            ((com.smartdigimkt.t4.o) this.this$1.this$0).mCacheAd = dVar;
        }
        this.this$1.this$0.printAdStatusLog("request_result", "success", "");
        com.smartdigimkt.q3.f.a().a(new f0(this, str, bVar, z));
    }
}
