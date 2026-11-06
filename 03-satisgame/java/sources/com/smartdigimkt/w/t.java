package com.smartdigimkt.w;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements Runnable {
    final /* synthetic */ v this$1;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;
    final /* synthetic */ com.smartdigimkt.k1.d val$ownBaseAd;

    public t(v vVar, com.smartdigimkt.k1.d dVar, com.smartdigimkt.h3.b bVar) {
        this.this$1 = vVar;
        this.val$ownBaseAd = dVar;
        this.val$latencyTrace = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!(this.val$ownBaseAd instanceof com.smartdigimkt.k1.l)) {
            com.smartdigimkt.z3.a aVarA = com.smartdigimkt.z3.b.a(com.anythink.core.common.inner.b.b.d, "Ad is loaded but not match type.");
            this.this$1.this$0.finishAdLoadLatency(this.val$latencyTrace, "failure", aVarA);
            if (this.this$1.this$0.mDevListener != null) {
                this.this$1.this$0.mDevListener.onAdLoadFail(aVarA);
                return;
            }
            return;
        }
        if (this.this$1.this$0.mDevListener != null) {
            try {
                this.this$1.this$0.mNativeAdImp = new com.smartdigimkt.t4.u((com.smartdigimkt.k1.l) this.val$ownBaseAd);
            } catch (Error e) {
                this.this$1.this$0.finishNativeWrapperFailure(this.val$latencyTrace);
                throw e;
            } catch (RuntimeException e2) {
                this.this$1.this$0.finishNativeWrapperFailure(this.val$latencyTrace);
                throw e2;
            }
        }
        this.this$1.this$0.finishAdLoadLatency(this.val$latencyTrace, "success", null);
        if (this.this$1.this$0.mDevListener != null) {
            this.this$1.this$0.mDevListener.onAdLoaded(this.this$1.this$0.mNativeAdImp);
        }
    }
}
