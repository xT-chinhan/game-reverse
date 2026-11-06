package com.smartdigimkt.sdk.api.format.myoffer;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ErrorCode;
import com.smartdigimkt.h3.b;
import com.smartdigimkt.k1.d;
import com.smartdigimkt.p3.l;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.api.format.SDMBannerListener;
import com.smartdigimkt.sdk.basead.ui.SdkBannerATView;
import com.smartdigimkt.t4.a;
import com.smartdigimkt.t4.f;
import com.smartdigimkt.t4.g;
import com.smartdigimkt.t4.h;
import com.smartdigimkt.t4.i;
import com.smartdigimkt.t4.p;
import com.smartdigimkt.t4.q;
import com.smartdigimkt.t4.r;
import com.smartdigimkt.w.e;
import com.smartdigimkt.w.j;
import com.smartdigimkt.w.k;
import com.smartdigimkt.w.m;
import com.smartdigimkt.w.n;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SDMMyOfferBannerView extends FrameLayout implements h {
    private final Object M_LOCK;
    private final String TAG;
    private volatile b activeAdLoadLatencyTrace;
    private boolean canRenderBanner;
    private boolean hasTouchWindow;
    private volatile boolean isLoading;
    private boolean isShowCall;
    private final g mAdCallbackHandler;
    private f mBannerRefreshTimer;
    private d mCacheAd;
    private SDMBannerListener mDevListener;
    private i mInnerBannerListener;
    private boolean mIsRefresh;
    private d mLastPresentCacheAd;
    private SDMAdRequest mLastSdmAdRequest;
    private p mLoadListener;
    private String mPlacementId;
    private final com.smartdigimkt.t4.d mRefreshImpressionGate;
    private boolean mRequestConfigRefresh;
    private r mSdmAdLoadManager;
    private l visibilityChecker;

    public SDMMyOfferBannerView(Context context) {
        super(context);
        this.TAG = "SDMMyOfferBannerView";
        this.M_LOCK = new Object();
        this.mAdCallbackHandler = new a();
        this.isLoading = false;
        this.hasTouchWindow = false;
        this.mRefreshImpressionGate = new com.smartdigimkt.t4.d();
        this.mIsRefresh = false;
        this.mRequestConfigRefresh = true;
        this.mInnerBannerListener = new e(this);
        this.mLoadListener = new com.smartdigimkt.w.h(this);
        this.mBannerRefreshTimer = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishAdLoadLatency(b bVar, String str, AdError adError) {
        if (bVar == null) {
            return;
        }
        if (adError != null) {
            adError.getCode();
        }
        bVar.b();
        synchronized (this.M_LOCK) {
            if (this.activeAdLoadLatencyTrace == bVar) {
                this.activeAdLoadLatencyTrace = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.smartdigimkt.k1.a getBannerCache() {
        d dVar = this.mCacheAd;
        if (dVar == null || !dVar.d()) {
            return null;
        }
        return (com.smartdigimkt.k1.a) this.mCacheAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInView() {
        return this.hasTouchWindow && isShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRefreshOpen() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markAdLoadInternalReady(b bVar) {
        if (bVar != null) {
            bVar.c();
            bVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderBannerView(com.smartdigimkt.k1.a aVar, boolean z) {
        if (aVar != null) {
            this.mRefreshImpressionGate.a = false;
            aVar.i = new n(this, z);
            View sdkBannerATView = aVar.d() ? new SdkBannerATView(aVar.a, aVar.b, aVar.e, aVar.i) : null;
            if (sdkBannerATView != null && sdkBannerATView.getParent() != null && sdkBannerATView.getParent() != this) {
                ((ViewGroup) sdkBannerATView.getParent()).removeView(sdkBannerATView);
            }
            d dVar = this.mLastPresentCacheAd;
            if (dVar != null) {
                dVar.c();
            }
            this.mLastPresentCacheAd = aVar;
            if (sdkBannerATView != null) {
                removeAllViews();
                int i = sdkBannerATView.getLayoutParams() != null ? sdkBannerATView.getLayoutParams().width : 0;
                if (i == 0) {
                    i = -2;
                }
                int i2 = sdkBannerATView.getLayoutParams() != null ? sdkBannerATView.getLayoutParams().height : 0;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2 != 0 ? i2 : -2);
                layoutParams.gravity = 17;
                sdkBannerATView.setLayoutParams(layoutParams);
                if (isAttachedToWindow()) {
                    aVar.e();
                }
                addView(sdkBannerATView, layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleRefreshAfterShow() {
        com.smartdigimkt.t4.d dVar = this.mRefreshImpressionGate;
        if (dVar.a) {
            return;
        }
        dVar.a = true;
        if (isRefreshOpen()) {
            f fVar = this.mBannerRefreshTimer;
            if (fVar != null) {
                fVar.b();
            }
            if (this.mSdmAdLoadManager == null) {
                return;
            }
            synchronized (this.M_LOCK) {
                if (this.isLoading) {
                    return;
                }
                load(1, this.mLastSdmAdRequest);
            }
        }
    }

    public boolean checkReady() {
        d dVar = this.mCacheAd;
        boolean zD = dVar != null ? dVar.d() : false;
        if (!zD) {
            this.mCacheAd = null;
        }
        return zD;
    }

    public void controlShow() {
        com.smartdigimkt.q3.f.a().c(new m(this, this.mIsRefresh));
    }

    public void destroy() {
        synchronized (this.M_LOCK) {
            removeAllViews();
            synchronized (this.M_LOCK) {
                d dVar = this.mCacheAd;
                if (dVar != null) {
                    dVar.c();
                    this.mCacheAd = null;
                }
            }
        }
        this.mRefreshImpressionGate.a = false;
        f fVar = this.mBannerRefreshTimer;
        if (fVar != null) {
            fVar.a();
        }
    }

    public Map<String, Object> getExtraInfoMap() {
        d dVar = this.mCacheAd;
        if (dVar != null) {
            return com.smartdigimkt.z.f.a(dVar.e);
        }
        return null;
    }

    public boolean isAdReady() {
        return checkReady();
    }

    public void load() {
        load(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        d dVar = this.mLastPresentCacheAd;
        if (dVar != null) {
            dVar.e();
        }
        super.onAttachedToWindow();
        this.hasTouchWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hasTouchWindow = false;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            controlShow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            controlShow();
        }
    }

    public void setListener(SDMBannerListener sDMBannerListener) {
        this.mDevListener = sDMBannerListener;
    }

    public void setPlacementId(String str) {
        this.mSdmAdLoadManager = new r(2, str);
        this.mPlacementId = str;
        this.mBannerRefreshTimer.a = str;
    }

    @Override // com.smartdigimkt.t4.h
    public void timeUpRefreshView() {
        this.isShowCall = true;
        this.canRenderBanner = true;
        controlShow();
    }

    public void load(SDMAdRequest sDMAdRequest) {
        load(0, sDMAdRequest, new b(this.mPlacementId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void load(int i, SDMAdRequest sDMAdRequest) {
        load(i, sDMAdRequest, new b(this.mPlacementId));
    }

    private void load(int i, SDMAdRequest sDMAdRequest, b bVar) {
        if (this.mSdmAdLoadManager != null && !TextUtils.isEmpty(this.mPlacementId)) {
            if (i == 0) {
                this.canRenderBanner = true;
            }
            if (sDMAdRequest != null) {
                this.mRequestConfigRefresh = sDMAdRequest.getBannerRefresh();
            }
            this.mLastSdmAdRequest = sDMAdRequest;
            synchronized (this.M_LOCK) {
                if (this.isLoading) {
                    com.smartdigimkt.z3.a aVarA = com.smartdigimkt.z3.b.a(ErrorCode.placementIdError, "");
                    markAdLoadInternalReady(bVar);
                    com.smartdigimkt.q3.f.a().a(new j(this, bVar, aVarA));
                    return;
                }
                boolean z = i == 1;
                this.mIsRefresh = z;
                if (!z && this.mCacheAd != null && checkReady()) {
                    markAdLoadInternalReady(bVar);
                    com.smartdigimkt.q3.f.a().a(new k(this, bVar));
                    return;
                }
                this.activeAdLoadLatencyTrace = bVar;
                this.isLoading = true;
                r rVar = this.mSdmAdLoadManager;
                Context context = getContext();
                p pVar = this.mLoadListener;
                rVar.getClass();
                com.smartdigimkt.q3.f.a().c(new q(rVar, bVar, context, i, sDMAdRequest, pVar));
                return;
            }
        }
        com.smartdigimkt.z3.a aVarA2 = com.smartdigimkt.z3.b.a("10001", "Please call setPlacementId(placementId) first.");
        markAdLoadInternalReady(bVar);
        com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.w.i(this, bVar, aVarA2));
    }

    public SDMMyOfferBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "SDMMyOfferBannerView";
        this.M_LOCK = new Object();
        this.mAdCallbackHandler = new a();
        this.isLoading = false;
        this.hasTouchWindow = false;
        this.mRefreshImpressionGate = new com.smartdigimkt.t4.d();
        this.mIsRefresh = false;
        this.mRequestConfigRefresh = true;
        this.mInnerBannerListener = new e(this);
        this.mLoadListener = new com.smartdigimkt.w.h(this);
        this.mBannerRefreshTimer = new f(this);
    }

    public SDMMyOfferBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "SDMMyOfferBannerView";
        this.M_LOCK = new Object();
        this.mAdCallbackHandler = new a();
        this.isLoading = false;
        this.hasTouchWindow = false;
        this.mRefreshImpressionGate = new com.smartdigimkt.t4.d();
        this.mIsRefresh = false;
        this.mRequestConfigRefresh = true;
        this.mInnerBannerListener = new e(this);
        this.mLoadListener = new com.smartdigimkt.w.h(this);
        this.mBannerRefreshTimer = new f(this);
    }
}
