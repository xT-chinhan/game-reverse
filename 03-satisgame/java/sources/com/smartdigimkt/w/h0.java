package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends com.smartdigimkt.t4.c {
    final /* synthetic */ i0 this$1;

    public h0(i0 i0Var) {
        this.this$1 = i0Var;
    }

    @Override // com.smartdigimkt.t4.c
    public void onAdLoadFail(String str, AdError adError) {
        i0 i0Var = this.this$1;
        com.smartdigimkt.h3.b bVar = i0Var.val$latencyTrace;
        i0Var.this$0.markAdLoadInternalReady(bVar);
        if (adError != null) {
            adError.getErrorInfo();
        }
        synchronized (((com.smartdigimkt.t4.s) this.this$1.this$0).M_LOCK) {
            this.this$1.this$0.isLoading = false;
        }
        com.smartdigimkt.q3.f.a().a(new f0(this, bVar, adError));
    }

    @Override // com.smartdigimkt.t4.c
    public void onTimeout(String str) {
        i0 i0Var = this.this$1;
        i0Var.this$0.markAdLoadInternalReady(i0Var.val$latencyTrace);
        com.smartdigimkt.q3.f.a().a(new g0(this));
    }

    @Override // com.smartdigimkt.t4.c
    public void onAdLoaded(String str, boolean z, com.smartdigimkt.k1.d dVar) {
        i0 i0Var = this.this$1;
        com.smartdigimkt.h3.b bVar = i0Var.val$latencyTrace;
        i0Var.this$0.markAdLoadInternalReady(bVar);
        synchronized (((com.smartdigimkt.t4.s) this.this$1.this$0).M_LOCK) {
            this.this$1.this$0.isLoading = false;
            ((com.smartdigimkt.t4.s) this.this$1.this$0).mCacheAd = dVar;
        }
        com.smartdigimkt.q3.f.a().a(new e0(this, z, bVar));
    }
}
