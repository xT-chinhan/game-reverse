package com.smartdigimkt.sdk.api.format.myoffer;

import android.content.Context;
import com.anythink.core.api.ErrorCode;
import com.smartdigimkt.h3.b;
import com.smartdigimkt.k1.d;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMNativeAd;
import com.smartdigimkt.sdk.api.format.SDMNativeLoadListener;
import com.smartdigimkt.t4.p;
import com.smartdigimkt.t4.q;
import com.smartdigimkt.t4.r;
import com.smartdigimkt.t4.s;
import com.smartdigimkt.t4.u;
import com.smartdigimkt.w.v;
import com.smartdigimkt.w.w;
import com.smartdigimkt.z3.a;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SDMMyOfferNative extends s {
    private Context mContext;
    private SDMNativeLoadListener mDevListener;
    private u mNativeAdImp;
    private String mPlacementId;
    private r mSdmAdLoadManager;
    private volatile boolean isLoading = false;
    private p mLoadListener = new v(this);

    public SDMMyOfferNative(Context context, String str) {
        this.mPlacementId = str;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        this.mSdmAdLoadManager = new r(0, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishNativeWrapperFailure(b bVar) {
        finishAdLoadLatency(bVar, "failure", com.smartdigimkt.z3.b.a(com.anythink.core.common.inner.b.b.d, "Native ad wrapper creation failed."));
    }

    private void loadInternal(SDMAdRequest sDMAdRequest, b bVar) {
        synchronized (this.M_LOCK) {
            if (this.isLoading) {
                a aVarA = com.smartdigimkt.z3.b.a(ErrorCode.placementIdError, "");
                markAdLoadInternalReady(bVar);
                f.a().a(new w(this, bVar, aVarA));
                return;
            }
            activateAdLoadLatencyTrace(bVar);
            this.isLoading = true;
            r rVar = this.mSdmAdLoadManager;
            Context context = this.mContext;
            p pVar = this.mLoadListener;
            rVar.getClass();
            f.a().c(new q(rVar, bVar, context, 0, sDMAdRequest, pVar));
        }
    }

    public Map<String, Object> getExtraInfoMap() {
        d dVar = this.mCacheAd;
        if (dVar != null) {
            return com.smartdigimkt.z.f.a(dVar.e);
        }
        return null;
    }

    @Override // com.smartdigimkt.t4.s
    public int getFormat() {
        return 0;
    }

    public SDMNativeAd getNativeAd() {
        return this.mNativeAdImp;
    }

    @Override // com.smartdigimkt.t4.s
    public String getPlacementId() {
        return this.mPlacementId;
    }

    public void load() {
        load(null);
    }

    @Override // com.smartdigimkt.t4.s
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
