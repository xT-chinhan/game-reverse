package com.smartdigimkt.sdk.api.format;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ErrorCode;
import com.smartdigimkt.d0.s;
import com.smartdigimkt.g1.c;
import com.smartdigimkt.h3.b;
import com.smartdigimkt.j1.t;
import com.smartdigimkt.n3.k;
import com.smartdigimkt.n3.m;
import com.smartdigimkt.o4.o;
import com.smartdigimkt.p3.l;
import com.smartdigimkt.r4.j;
import com.smartdigimkt.r4.w;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.basead.ui.SdkBannerATView;
import com.smartdigimkt.t4.d;
import com.smartdigimkt.t4.d0;
import com.smartdigimkt.t4.f;
import com.smartdigimkt.t4.g;
import com.smartdigimkt.t4.h;
import com.smartdigimkt.t4.i;
import com.smartdigimkt.t4.n;
import com.smartdigimkt.t4.p;
import com.smartdigimkt.v.e;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class SDMBannerView extends FrameLayout implements h, SDMAdHandler {
    private final Object M_LOCK;
    private final String TAG;
    private volatile b activeAdLoadLatencyTrace;
    private final AtomicBoolean adxFillTiming3000022Reported;
    private boolean canRenderBanner;
    private boolean hasTouchWindow;
    private volatile boolean isLoading;
    private boolean isShowCall;
    private final g mAdCallbackHandler;
    private f mBannerRefreshTimer;
    private com.smartdigimkt.e1.a mCacheAd;
    private SDMBannerListener mDevListener;
    private i mInnerBannerListener;
    private boolean mIsRefresh;
    private com.smartdigimkt.e1.a mLastPresentCacheAd;
    private SDMAdRequest mLastSdmAdRequest;
    private p mLoadListener;
    private String mPlacementId;
    private com.smartdigimkt.e1.a mRefreshCacheAd;
    private final d mRefreshImpressionGate;
    private boolean mRequestConfigRefresh;
    private n mSdmAdLoadManager;
    private l visibilityChecker;

    public SDMBannerView(Context context) {
        super(context);
        this.TAG = "SDMBannerView";
        this.M_LOCK = new Object();
        this.mAdCallbackHandler = new com.smartdigimkt.t4.a();
        this.isLoading = false;
        this.adxFillTiming3000022Reported = new AtomicBoolean(false);
        this.hasTouchWindow = false;
        this.mRefreshImpressionGate = new d();
        this.mIsRefresh = false;
        this.mRequestConfigRefresh = true;
        this.mInnerBannerListener = new e(this);
        this.mLoadListener = new com.smartdigimkt.v.h(this);
        this.mBannerRefreshTimer = new f(this);
    }

    private void beginBannerShowIfAttached(com.smartdigimkt.e1.a aVar) {
        if (aVar == null || !isAttachedToWindow()) {
            return;
        }
        d0.b(aVar);
        aVar.c();
        aVar.d();
    }

    private boolean checkVisibilityPercent() {
        return true;
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
    public com.smartdigimkt.e1.a getBannerCache() {
        com.smartdigimkt.e1.a aVar = this.mRefreshCacheAd;
        if (aVar != null && aVar.a(aVar.b())) {
            return this.mRefreshCacheAd;
        }
        com.smartdigimkt.e1.a aVar2 = this.mCacheAd;
        if (aVar2 == null || !aVar2.a(aVar2.b())) {
            return null;
        }
        return this.mCacheAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInView() {
        return this.hasTouchWindow && isShown() && checkVisibilityPercent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRefreshOpen() {
        com.smartdigimkt.p4.e eVarA;
        return this.mRequestConfigRefresh && (eVarA = o.a().a(this.mPlacementId)) != null && eVarA.n == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markAdLoadInternalReady(b bVar) {
        if (bVar != null) {
            bVar.c();
            bVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdStatus(String str, String str2) {
        onAdStatus(str, str2, null);
    }

    private void printReadyLog(com.smartdigimkt.e1.d dVar, boolean z) {
        if (!z || dVar == null) {
            w.a(this.mPlacementId, j.a(String.valueOf(2)), "isready", String.valueOf(false), "");
        } else if (dVar.c != null) {
            w.a(this.mPlacementId, j.a(String.valueOf(2)), "isready", String.valueOf(true), "");
        }
    }

    private void releaseExpireCache() {
        com.smartdigimkt.e1.a aVar = this.mCacheAd;
        SDMLossInfo sDMLossInfoNewInternalLossInfo = SDMLossInfo.newInternalLossInfo(4);
        if (aVar != null && sDMLossInfoNewInternalLossInfo != null) {
            d0.a(aVar, sDMLossInfoNewInternalLossInfo);
        }
        destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderBannerView(com.smartdigimkt.e1.a aVar, boolean z) {
        View view;
        com.smartdigimkt.b3.l lVar;
        if (aVar != null) {
            this.mRefreshImpressionGate.a = false;
            t tVar = new t(aVar, new com.smartdigimkt.v.n(this, z));
            aVar.f = tVar;
            c cVar = aVar.i;
            if (cVar != null) {
                cVar.c = tVar;
            }
            if (cVar != null) {
                try {
                    Context context = aVar.b;
                    if (cVar.e == null && (lVar = cVar.a) != null && s.a(lVar, cVar.b)) {
                        cVar.e = new SdkBannerATView(context, cVar.b, cVar.a, cVar.c);
                    }
                    view = cVar.e;
                } catch (Throwable th) {
                    String.valueOf(th);
                    onAdStatus("show_failed", "fail", new com.smartdigimkt.z3.a("20002", "Banner inflate failed: " + (th.getMessage() != null ? th.getMessage() : th.getClass().getSimpleName())));
                    return;
                }
            } else {
                view = null;
            }
            if (view != null && view.getParent() != null && view.getParent() != this) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            com.smartdigimkt.e1.a aVar2 = this.mLastPresentCacheAd;
            if (aVar2 != null) {
                aVar2.a();
            }
            this.mLastPresentCacheAd = aVar;
            if (view != null) {
                removeAllViews();
                int i = view.getLayoutParams() != null ? view.getLayoutParams().width : 0;
                if (i == 0) {
                    i = -2;
                }
                int i2 = view.getLayoutParams() != null ? view.getLayoutParams().height : 0;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2 != 0 ? i2 : -2);
                layoutParams.gravity = 17;
                view.setLayoutParams(layoutParams);
                beginBannerShowIfAttached(aVar);
                addView(view, layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleRefreshAfterShow() {
        d dVar = this.mRefreshImpressionGate;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReportBannerFillTiming3000022(com.smartdigimkt.e1.d dVar, String str, b bVar) {
        m.a(this.mPlacementId, dVar, str, bVar, this.adxFillTiming3000022Reported);
    }

    public boolean checkReady(boolean z) {
        boolean z2;
        int i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.smartdigimkt.e1.a aVar = this.mCacheAd;
        if (aVar != null) {
            int iB = aVar.b();
            boolean zA = this.mCacheAd.a(iB);
            if (iB == 1) {
                releaseExpireCache();
            }
            i = iB;
            z2 = zA;
        } else {
            z2 = false;
            i = 0;
        }
        if (z) {
            k.a(z2, this.mPlacementId, this.mCacheAd, System.currentTimeMillis() - jCurrentTimeMillis, i);
            printReadyLog(this.mCacheAd, z2);
        }
        if (!z2) {
            this.mCacheAd = null;
        }
        return z2;
    }

    public void controlShow() {
        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.v.m(this, this.mIsRefresh));
    }

    public void destroy() {
        synchronized (this.M_LOCK) {
            removeAllViews();
            synchronized (this.M_LOCK) {
                com.smartdigimkt.e1.a aVar = this.mCacheAd;
                if (aVar != null) {
                    aVar.a();
                    this.mCacheAd = null;
                }
            }
            com.smartdigimkt.e1.a aVar2 = this.mRefreshCacheAd;
            if (aVar2 != null) {
                aVar2.a();
                this.mRefreshCacheAd = null;
            }
        }
        this.mRefreshImpressionGate.a = false;
        f fVar = this.mBannerRefreshTimer;
        if (fVar != null) {
            fVar.a();
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdHandler
    public SDMAd getSDMAd() {
        com.smartdigimkt.e1.a aVar = this.mCacheAd;
        if (aVar != null) {
            return new com.smartdigimkt.t4.l(aVar);
        }
        return null;
    }

    public boolean isAdReady() {
        return checkReady(true);
    }

    public void load() {
        load(null);
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdHandler
    public void notifyLoss(SDMLossInfo sDMLossInfo) {
        com.smartdigimkt.e1.a aVar = this.mCacheAd;
        if (aVar == null || sDMLossInfo == null) {
            return;
        }
        if (SDMLossInfo.isInternalLossReason(sDMLossInfo.getLossReasonCode())) {
            sDMLossInfo.getLossReasonCode();
        } else {
            d0.a(aVar, sDMLossInfo);
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdHandler
    public void notifyWin(SDMWinInfo sDMWinInfo) {
        d0.a(this.mCacheAd, sDMWinInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        beginBannerShowIfAttached(this.mLastPresentCacheAd);
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
        this.mSdmAdLoadManager = new n(2, str);
        this.mPlacementId = str;
        this.mBannerRefreshTimer.a = str;
    }

    @Override // com.smartdigimkt.t4.h
    public void timeUpRefreshView() {
        this.isShowCall = true;
        this.canRenderBanner = true;
        controlShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdStatus(String str, String str2, AdError adError) {
        g gVar = this.mAdCallbackHandler;
        ((com.smartdigimkt.t4.a) gVar).a = this.mCacheAd;
        com.smartdigimkt.t4.a.a(gVar, str, str2, adError);
        com.smartdigimkt.e1.a aVar = this.mCacheAd;
        com.smartdigimkt.f3.a aVar2 = null;
        com.smartdigimkt.f3.a aVar3 = aVar != null ? aVar.l : null;
        if (aVar3 == null) {
            com.smartdigimkt.e1.a aVar4 = this.mRefreshCacheAd;
            if (aVar4 != null) {
                aVar2 = aVar4.l;
            }
        } else {
            aVar2 = aVar3;
        }
        w.a(aVar2, str, str2, adError != null ? adError.getErrorInfo() : "");
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
                    com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.v.j(this, bVar, aVarA));
                    return;
                }
                boolean z = i == 1;
                this.mIsRefresh = z;
                if (!z && this.mCacheAd != null && checkReady(false)) {
                    markAdLoadInternalReady(bVar);
                    com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.v.k(this, bVar));
                    return;
                }
                this.activeAdLoadLatencyTrace = bVar;
                this.adxFillTiming3000022Reported.set(false);
                this.isLoading = true;
                n nVar = this.mSdmAdLoadManager;
                Context context = getContext();
                p pVar = this.mLoadListener;
                nVar.getClass();
                com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t4.m(nVar, bVar, context, i, sDMAdRequest, pVar));
                return;
            }
        }
        com.smartdigimkt.z3.a aVarA2 = com.smartdigimkt.z3.b.a("10001", "Please call setPlacementId(placementId) first.");
        markAdLoadInternalReady(bVar);
        com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.v.i(this, bVar, aVarA2));
    }

    public SDMBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "SDMBannerView";
        this.M_LOCK = new Object();
        this.mAdCallbackHandler = new com.smartdigimkt.t4.a();
        this.isLoading = false;
        this.adxFillTiming3000022Reported = new AtomicBoolean(false);
        this.hasTouchWindow = false;
        this.mRefreshImpressionGate = new d();
        this.mIsRefresh = false;
        this.mRequestConfigRefresh = true;
        this.mInnerBannerListener = new e(this);
        this.mLoadListener = new com.smartdigimkt.v.h(this);
        this.mBannerRefreshTimer = new f(this);
    }

    public SDMBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "SDMBannerView";
        this.M_LOCK = new Object();
        this.mAdCallbackHandler = new com.smartdigimkt.t4.a();
        this.isLoading = false;
        this.adxFillTiming3000022Reported = new AtomicBoolean(false);
        this.hasTouchWindow = false;
        this.mRefreshImpressionGate = new d();
        this.mIsRefresh = false;
        this.mRequestConfigRefresh = true;
        this.mInnerBannerListener = new e(this);
        this.mLoadListener = new com.smartdigimkt.v.h(this);
        this.mBannerRefreshTimer = new f(this);
    }
}
