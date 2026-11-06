package com.smartdigimkt.sdk.api.format;

import android.content.Context;
import com.anythink.core.api.ErrorCode;
import com.smartdigimkt.h3.b;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.t4.m;
import com.smartdigimkt.t4.n;
import com.smartdigimkt.t4.o;
import com.smartdigimkt.t4.p;
import com.smartdigimkt.t4.x;
import com.smartdigimkt.v.v;
import com.smartdigimkt.v.w;

/* JADX INFO: loaded from: classes3.dex */
public class SDMNative extends o {
    private Context mContext;
    private SDMNativeLoadListener mDevListener;
    private x mNativeAdImp;
    private String mPlacementId;
    private n mSdmAdLoadManager;
    private volatile boolean isLoading = false;
    private p mLoadListener = new v(this);

    public SDMNative(Context context, String str) {
        this.mPlacementId = str;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        this.mSdmAdLoadManager = new n(0, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishNativeWrapperFailure(b bVar) {
        com.smartdigimkt.z3.a aVarA = com.smartdigimkt.z3.b.a(com.anythink.core.common.inner.b.b.d, "Native ad wrapper creation failed.");
        tryReportAdxFillTiming3000022(this.mCacheAd, null, bVar);
        finishAdLoadLatency(bVar, "failure", aVarA);
    }

    private void loadInternal(SDMAdRequest sDMAdRequest, b bVar) {
        synchronized (this.M_LOCK) {
            if (this.isLoading) {
                com.smartdigimkt.z3.a aVarA = com.smartdigimkt.z3.b.a(ErrorCode.placementIdError, "");
                markAdLoadInternalReady(bVar);
                f.a().a(new w(this, bVar, aVarA));
                return;
            }
            activateAdLoadLatencyTrace(bVar);
            this.isLoading = true;
            n nVar = this.mSdmAdLoadManager;
            Context context = this.mContext;
            p pVar = this.mLoadListener;
            nVar.getClass();
            f.a().c(new m(nVar, bVar, context, 0, sDMAdRequest, pVar));
        }
    }

    @Override // com.smartdigimkt.t4.o
    public int getFormat() {
        return 0;
    }

    public SDMNativeAd getNativeAd() {
        return this.mNativeAdImp;
    }

    @Override // com.smartdigimkt.t4.o
    public String getPlacementId() {
        return this.mPlacementId;
    }

    public void load() {
        load(null);
    }

    @Override // com.smartdigimkt.t4.o
    public void onDestroy() {
        this.mDevListener = null;
    }

    public void setListener(SDMNativeLoadListener sDMNativeLoadListener) {
        this.mDevListener = sDMNativeLoadListener;
    }

    public void load(SDMAdRequest sDMAdRequest) {
        loadInternal(sDMAdRequest, createAdLoadLatencyTrace(0));
    }
}
