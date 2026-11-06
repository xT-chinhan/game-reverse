package com.anythink.nativead.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATCustomVideo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.k;
import com.anythink.core.common.d.n;
import com.anythink.core.common.d.r;
import com.anythink.core.common.d.s;
import com.anythink.core.common.f;
import com.anythink.core.common.h.c;
import com.anythink.core.common.inner.mixad.b.e;
import com.anythink.core.common.k.g.d;
import com.anythink.core.common.t.g;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.o;
import com.anythink.core.common.u.p;
import com.anythink.nativead.a.b;
import com.anythink.nativead.unitgroup.a;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class NativeAd {
    private boolean hasSetShowTkDetail;
    private View innerChildView;
    private c mAdCacheInfo;
    protected a mBaseNativeAd;
    DownloadConfirmListener mConfirmListener;
    private Context mContext;
    private ATNativeDislikeListener mDislikeListener;
    ATEventInterface mEventInterface;
    private volatile boolean mIsDestroyed;
    private int mNativeAdHeight;
    private int mNativeAdWidth;
    private ATNativeEventListener mNativeEventListener;
    ATNativeAdView mNativeView;
    private String mPlacementId;
    private ATAdRevenueListener mRevenueListener;
    ATNativeMaterial nativeMaterial;
    private final f realCommonAdManager;
    private ATNativeAdInfo.AdPrepareInfo thirdPartyAdPrepareInfo;
    private final String TAG = getClass().getSimpleName();
    private final AtomicBoolean mRecordedShow = new AtomicBoolean(false);
    private final AtomicBoolean mRecordedImpression = new AtomicBoolean(false);
    private boolean hasCallPrepareApi = false;
    private boolean hasCallPrepareRenderApi = false;
    private boolean hasReportRenderTypeAgent = false;
    View.OnClickListener mDefaultCloseViewListener = new View.OnClickListener() { // from class: com.anythink.nativead.api.NativeAd.14
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (NativeAd.this.mBaseNativeAd != null) {
                NativeAd.this.mBaseNativeAd.notifyAdDislikeClick();
            }
        }
    };
    boolean isManualImpressionTrack = false;

    public interface DownloadConfirmListener {
        void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo);
    }

    public interface ImpressionEventListener {
        void onImpression();
    }

    protected NativeAd(Context context, String str, c cVar, f fVar) {
        this.mNativeAdWidth = 0;
        this.mNativeAdHeight = 0;
        this.mContext = context.getApplicationContext();
        this.mPlacementId = str;
        this.mAdCacheInfo = cVar;
        this.realCommonAdManager = fVar;
        a aVar = (a) cVar.f();
        this.mBaseNativeAd = aVar;
        aVar.setNativeEventListener(new n() { // from class: com.anythink.nativead.api.NativeAd.1
            @Override // com.anythink.core.common.d.n
            public final void onAdDislikeButtonClick() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleAdDislikeButtonClick(nativeAd.mNativeView);
            }

            @Override // com.anythink.core.common.d.n
            public final void onDeeplinkCallback(boolean z) {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleDeeplinkCallback(nativeAd.mNativeView, z);
            }

            @Override // com.anythink.core.common.d.n
            public final void onDownloadConfirmCallback(Context context2, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                NativeAd.this.handleDownloadConfirm(context2, view, aTNetworkConfirmInfo);
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdActRewardSuccess() {
                NativeAd.this.handleAdActRewardSuccess();
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdActReward(int i) {
                NativeAd.this.handleAdActReward(i);
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdImpressed() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleImpression(nativeAd.mNativeView);
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdClicked(View view) {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleClick(nativeAd.mNativeView, view);
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdVideoStart() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleVideoStart(nativeAd.mNativeView);
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdVideoEnd() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleVideoEnd(nativeAd.mNativeView);
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdVideoProgress(int i) {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleVideoProgress(nativeAd.mNativeView, i);
            }
        });
        if (this.mBaseNativeAd instanceof CustomNativeAd) {
            this.nativeMaterial = new b((CustomNativeAd) this.mBaseNativeAd, isSupportRenderToInnerTemplate());
        }
        c cVar2 = this.mAdCacheInfo;
        if (cVar2 == null || cVar2.i() == null || this.mAdCacheInfo.i().k() == null) {
            return;
        }
        Map<String, Object> mapK = this.mAdCacheInfo.i().k();
        this.mNativeAdWidth = ((Integer) p.a(mapK, ATAdConst.KEY.AD_WIDTH, 0)).intValue();
        this.mNativeAdHeight = ((Integer) p.a(mapK, ATAdConst.KEY.AD_HEIGHT, 0)).intValue();
    }

    public ATNativeMaterial getAdMaterial() {
        return this.nativeMaterial;
    }

    public synchronized void renderAdContainer(final ATNativeAdView aTNativeAdView, final View view) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.10
            @Override // java.lang.Runnable
            public final void run() {
                NativeAd.this.renderAdOnUiThread(aTNativeAdView, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void renderAdOnUiThread(ATNativeAdView aTNativeAdView, View view) {
        com.anythink.core.common.k.d.b serverExtraInfo;
        e eVar;
        if (this.mIsDestroyed) {
            return;
        }
        if (aTNativeAdView != null) {
            aTNativeAdView.clear();
        }
        if (aTNativeAdView == null) {
            Log.e("anythink", "renderAdContainer: ATNativeAdView cannot be null for template-rendering ads!");
            return;
        }
        View adMediaView = null;
        if (isNativeExpressByNativeAd()) {
            a aVar = this.mBaseNativeAd;
            if (aVar != null && (adMediaView = aVar.getAdMediaView(aTNativeAdView, Integer.valueOf(aTNativeAdView.getWidth()))) == null) {
                Log.e("anythink", "renderAdContainer: getAdMediaView() cannot be null for template-rendering ads!");
                return;
            }
        } else {
            if (isSupportRenderToInnerTemplate(view != null) && (view = this.innerChildView) == null) {
                com.anythink.core.common.k.d.a aVarA = new com.anythink.core.common.k.d.a.C0028a().a(aTNativeAdView.getContext()).a(this.mBaseNativeAd.getDetail()).a(new com.anythink.core.common.k.e.a() { // from class: com.anythink.nativead.api.NativeAd.11
                    @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
                    public final void onAdDislikeButtonClick() {
                        super.onAdDislikeButtonClick();
                        NativeAd nativeAd = NativeAd.this;
                        nativeAd.handleAdDislikeButtonClick(nativeAd.mNativeView);
                    }
                }).a(new d(this.mBaseNativeAd, this.mAdCacheInfo.e().getServerExtraInfo().a())).a(this.mNativeAdWidth).b(this.mNativeAdHeight).a();
                ATBaseAdAdapter aTBaseAdAdapterE = this.mAdCacheInfo.e();
                if (aTBaseAdAdapterE == null || (serverExtraInfo = aTBaseAdAdapterE.getServerExtraInfo()) == null) {
                    eVar = null;
                } else {
                    aVarA.a(serverExtraInfo);
                    eVar = serverExtraInfo.j() ? new e() : null;
                    if (eVar != null) {
                        eVar.a(new com.anythink.core.common.inner.mixad.c.b(aVarA));
                    }
                }
                if (eVar instanceof com.anythink.core.common.k.c.a.d) {
                    view = eVar.a();
                    this.thirdPartyAdPrepareInfo = eVar.b();
                    this.innerChildView = view;
                } else {
                    view = null;
                }
            }
            if (view == null) {
                Log.e("anythink", "renderAdContainer: selfRenderView cannot be null for self-rendering ads!");
                checkToReportRenderErrorAgent(true);
                return;
            }
            adMediaView = view;
        }
        this.hasCallPrepareRenderApi = true;
        this.mNativeView = aTNativeAdView;
        if (aTNativeAdView != null) {
            aTNativeAdView.attachNativeAd(this);
        }
        if (adMediaView != null) {
            adMediaView.setVisibility(0);
            renderViewToWindow(adMediaView);
        }
    }

    public int getAdInteractionType() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return 0;
        }
        return ((CustomNativeAd) aVar).getNativeAdInteractionType();
    }

    private void renderViewToWindow(View view) {
        aa.b(this.mPlacementId, i.s.s, i.s.A, i.s.o, "");
        ViewGroup customAdContainer = this.mBaseNativeAd.getCustomAdContainer();
        int iHashCode = hashCode();
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (customAdContainer != null) {
            if (customAdContainer.getParent() != null) {
                ((ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
            }
            customAdContainer.addView(view);
        }
        if (customAdContainer != null) {
            view = customAdContainer;
        }
        this.mNativeView.renderView(iHashCode, view, new ImpressionEventListener() { // from class: com.anythink.nativead.api.NativeAd.12
            @Override // com.anythink.nativead.api.NativeAd.ImpressionEventListener
            public final void onImpression() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.anythink.core.common.h.n detail = NativeAd.this.mBaseNativeAd != null ? NativeAd.this.mBaseNativeAd.getDetail() : null;
                if (detail != null && TextUtils.isEmpty(detail.A())) {
                    detail.n(o.a(detail.aR(), detail.N(), jCurrentTimeMillis));
                }
                if (NativeAd.this.mBaseNativeAd instanceof CustomNativeAd) {
                    ((CustomNativeAd) NativeAd.this.mBaseNativeAd).setShowId(detail.A());
                }
                NativeAd nativeAd = NativeAd.this;
                nativeAd.recordShow(nativeAd.mNativeView);
            }
        });
    }

    public synchronized void prepare(final ATNativeAdView aTNativeAdView, final ATNativePrepareInfo aTNativePrepareInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.13
            @Override // java.lang.Runnable
            public final void run() {
                NativeAd.this.prepareOnUiThread(aTNativeAdView, aTNativePrepareInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void prepareOnUiThread(ATNativeAdView aTNativeAdView, ATNativePrepareInfo aTNativePrepareInfo) {
        if (this.mIsDestroyed) {
            return;
        }
        this.hasCallPrepareApi = true;
        if (aTNativeAdView != null) {
            ATNativeAdInfo.AdPrepareInfo adPrepareInfo = this.thirdPartyAdPrepareInfo;
            if (adPrepareInfo != null) {
                a aVar = this.mBaseNativeAd;
                if (aVar instanceof CustomNativeAd) {
                    aTNativePrepareInfo = ((CustomNativeAd) aVar).castToATNativePrepareInfo(adPrepareInfo);
                }
            }
            if (aTNativePrepareInfo == null) {
                aTNativePrepareInfo = new ATNativePrepareInfo();
            }
            this.mBaseNativeAd.setNativePrepareInfo(aTNativePrepareInfo);
            this.mBaseNativeAd.prepare(aTNativeAdView, aTNativePrepareInfo);
            bindListener();
            if (!this.mBaseNativeAd.isNativeExpress()) {
                checkBindView(aTNativePrepareInfo);
            }
        }
    }

    private void checkBindView(ATNativePrepareInfo aTNativePrepareInfo) {
        if (aTNativePrepareInfo == null) {
            return;
        }
        if (aTNativePrepareInfo.getTitleView() == null) {
            printNotSetViewLog("titleView");
        }
        if (aTNativePrepareInfo.getCtaView() == null) {
            printNotSetViewLog("ctaView");
        }
        if (aTNativePrepareInfo.getDescView() == null) {
            printNotSetViewLog("descView");
        }
        if (aTNativePrepareInfo.getIconView() == null) {
            printNotSetViewLog("iconView");
        }
        if (aTNativePrepareInfo.getMainImageView() == null) {
            printNotSetViewLog("mainImageView");
        }
    }

    private void printNotSetViewLog(String str) {
        Log.w(this.TAG, "The " + str + " is not set, it may cause the ad to not be clicked normally.");
    }

    private void bindListener() {
        ATNativePrepareInfo nativePrepareInfo;
        View closeView;
        a aVar = this.mBaseNativeAd;
        if (aVar instanceof CustomNativeAd) {
            CustomNativeAd customNativeAd = (CustomNativeAd) aVar;
            if (customNativeAd.checkHasCloseViewListener() || (nativePrepareInfo = customNativeAd.getNativePrepareInfo()) == null || (closeView = nativePrepareInfo.getCloseView()) == null) {
                return;
            }
            closeView.setOnClickListener(this.mDefaultCloseViewListener);
        }
    }

    public void setNativeEventListener(ATNativeEventListener aTNativeEventListener) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mNativeEventListener = aTNativeEventListener;
    }

    public void setAdRevenueListener(ATAdRevenueListener aTAdRevenueListener) {
        this.mRevenueListener = aTAdRevenueListener;
    }

    public void setDislikeCallbackListener(ATNativeDislikeListener aTNativeDislikeListener) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mDislikeListener = aTNativeDislikeListener;
    }

    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        if (downloadConfirmListener != null) {
            a aVar = this.mBaseNativeAd;
            if (aVar instanceof CustomNativeAd) {
                ((CustomNativeAd) aVar).registerDownloadConfirmListener();
            }
        } else {
            a aVar2 = this.mBaseNativeAd;
            if (aVar2 instanceof CustomNativeAd) {
                ((CustomNativeAd) aVar2).unregeisterDownloadConfirmListener();
            }
        }
        this.mConfirmListener = downloadConfirmListener;
    }

    public synchronized void clear(ATNativeAdView aTNativeAdView) {
        if (this.mIsDestroyed) {
            return;
        }
        try {
            a aVar = this.mBaseNativeAd;
            if (aVar != null) {
                aVar.clear(this.mNativeView);
            }
        } catch (Throwable unused) {
        }
        ATNativeAdView aTNativeAdView2 = this.mNativeView;
        if (aTNativeAdView2 != null) {
            aTNativeAdView2.clearImpressionListener(hashCode());
            this.mNativeView = null;
        }
    }

    public synchronized void destory() {
        if (this.mIsDestroyed) {
            return;
        }
        checkToReportRenderErrorAgent(false);
        clear(this.mNativeView);
        this.mIsDestroyed = true;
        this.mNativeEventListener = null;
        this.mDislikeListener = null;
        this.mDefaultCloseViewListener = null;
        this.mNativeView = null;
        KeyEvent.Callback callback = this.innerChildView;
        if (callback != null) {
            if (callback instanceof com.anythink.core.common.k.e.a.d) {
                ((com.anythink.core.common.k.e.a.d) callback).destroyNativeAd();
            }
            this.innerChildView = null;
        }
        this.thirdPartyAdPrepareInfo = null;
        a aVar = this.mBaseNativeAd;
        if (aVar != null) {
            com.anythink.core.common.u.c.a().b().d(aVar.getDetail());
        }
        a aVar2 = this.mBaseNativeAd;
        if (aVar2 != null) {
            aVar2.setNativePrepareInfo(null);
            this.mBaseNativeAd.destroy();
        }
    }

    private synchronized void checkToReportRenderErrorAgent(boolean z) {
        com.anythink.core.common.h.n detail;
        String str;
        String str2;
        String str3;
        try {
            if ((!this.mRecordedShow.get() || !this.mRecordedImpression.get()) && !this.hasReportRenderTypeAgent) {
                this.hasReportRenderTypeAgent = true;
                a aVar = this.mBaseNativeAd;
                if (aVar != null && (detail = aVar.getDetail()) != null) {
                    if (detail.Z() == 66) {
                        String str4 = this.hasCallPrepareRenderApi ? "1" : "2";
                        String str5 = this.hasCallPrepareApi ? "1" : "2";
                        String str6 = "";
                        if (!this.mRecordedShow.get() && !this.mRecordedImpression.get()) {
                            str6 = "1";
                        } else if (!this.mRecordedImpression.get()) {
                            str6 = "2";
                        }
                        if (z) {
                            str3 = "0";
                            str = "0";
                            str2 = "3";
                        } else {
                            str = str5;
                            str2 = str6;
                            str3 = str4;
                        }
                        Map<String, Object> networkInfoMap = this.mBaseNativeAd.getNetworkInfoMap();
                        Object obj = networkInfoMap.get("dsp_id");
                        Object obj2 = networkInfoMap.get("offer_id");
                        com.anythink.core.common.t.f.a(detail, str2, str3, str, obj != null ? obj.toString() : "", obj2 != null ? obj2.toString() : "");
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void finalize() throws Throwable {
        checkToReportRenderErrorAgent(false);
        super.finalize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void fillShowTrackingInfo(com.anythink.core.common.h.n nVar) {
        if (!this.hasSetShowTkDetail) {
            this.hasSetShowTkDetail = true;
            if (nVar != null) {
                ai.a(this.mContext, nVar);
            }
        }
    }

    void recordShow(ATNativeAdView aTNativeAdView) {
        f fVar;
        if (this.mRecordedShow.compareAndSet(false, true)) {
            final com.anythink.core.common.h.n detail = this.mBaseNativeAd.getDetail();
            c cVar = this.mAdCacheInfo;
            if (cVar != null && (fVar = this.realCommonAdManager) != null) {
                fVar.a(cVar);
            }
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.w, new Runnable() { // from class: com.anythink.nativead.api.NativeAd.15
                @Override // java.lang.Runnable
                public final void run() {
                    f fVarA;
                    if (NativeAd.this.mIsDestroyed || NativeAd.this.mAdCacheInfo == null) {
                        return;
                    }
                    NativeAd.this.fillShowTrackingInfo(detail);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        String[] strArrSplit = detail.A().split("_");
                        jCurrentTimeMillis = Long.parseLong(strArrSplit[strArrSplit.length - 1]);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (NativeAd.this.mBaseNativeAd != null && (NativeAd.this.mBaseNativeAd instanceof CustomNativeAd)) {
                        ((CustomNativeAd) NativeAd.this.mBaseNativeAd).setShowId(detail.A());
                    }
                    com.anythink.core.common.h.n nVar = detail;
                    if (nVar != null && (fVarA = nVar.a()) != null && fVarA.e() != null) {
                        fVarA.e().a(NativeAd.this.mContext.getApplicationContext(), NativeAd.this.mAdCacheInfo);
                    }
                    com.anythink.core.common.t.e.a(NativeAd.this.mContext);
                    com.anythink.core.common.t.e.a(13, detail, NativeAd.this.mAdCacheInfo.e().getUnitGroupInfo(), jCurrentTimeMillis);
                }
            }));
        }
    }

    public void setManualImpressionTrack(boolean z) {
        this.isManualImpressionTrack = z;
    }

    public void manualImpressionTrack() {
        if (this.mIsDestroyed) {
            Log.e(this.TAG, "NativeAd had been destroyed.");
            return;
        }
        if (!this.isManualImpressionTrack) {
            if (s.b().G()) {
                Log.e(this.TAG, "Must call \"setManualImpressionTrack(true);\" first.");
                return;
            }
            return;
        }
        ATNativeAdView aTNativeAdView = this.mNativeView;
        c cVar = this.mAdCacheInfo;
        ATBaseAdAdapter aTBaseAdAdapterE = cVar != null ? cVar.e() : null;
        if (aTBaseAdAdapterE != null && aTBaseAdAdapterE.supportImpressionCallback()) {
            if (s.b().G()) {
                Log.e(this.TAG, "This NativeAd don't support tracking impressions manually.");
                return;
            }
            return;
        }
        if (aTNativeAdView == null) {
            if (s.b().G()) {
                Log.e(this.TAG, "NativeAd don't call render.");
                return;
            }
            return;
        }
        if (!aTNativeAdView.isShown()) {
            if (s.b().G()) {
                Log.e(this.TAG, "ATNativeAdView isn't visible.");
            }
        } else if (!aTNativeAdView.isAttachedToWindow()) {
            if (s.b().G()) {
                Log.e(this.TAG, "ATNativeAdView don't attach window.");
            }
        } else {
            if (s.b().G()) {
                Log.i(this.TAG, "try to track impression manually.");
            }
            a aVar = this.mBaseNativeAd;
            if (aVar instanceof CustomNativeAd) {
                ((CustomNativeAd) aVar).impressionTrack(aTNativeAdView);
            }
        }
    }

    void handleImpression(final ATNativeAdView aTNativeAdView) {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bQ, new Runnable() { // from class: com.anythink.nativead.api.NativeAd.16
            @Override // java.lang.Runnable
            public void run() {
                if (!NativeAd.this.mIsDestroyed && NativeAd.this.mRecordedImpression.compareAndSet(false, true)) {
                    if (NativeAd.this.mAdCacheInfo != null && NativeAd.this.mBaseNativeAd != null) {
                        com.anythink.core.common.u.c.a().a(NativeAd.this.mAdCacheInfo.e(), NativeAd.this.mBaseNativeAd.getDetail(), NativeAd.this.isNativeExpressByNativeAd());
                    }
                    try {
                        if (NativeAd.this.mBaseNativeAd != null) {
                            com.anythink.core.common.h.n detail = NativeAd.this.mBaseNativeAd.getDetail();
                            detail.a(NativeAd.this.mBaseNativeAd.getNetworkInfoMap());
                            aa.a(detail, i.s.c, i.s.m, "");
                            NativeAd.this.fillShowTrackingInfo(detail);
                            NativeAd.this.fillRenderAreaToTrackingInfo(detail, aTNativeAdView);
                            ai.b(detail, NativeAd.this.mAdCacheInfo.e());
                            com.anythink.core.common.t.e.a(NativeAd.this.mContext.getApplicationContext());
                            com.anythink.core.common.t.e.a(4, detail, NativeAd.this.mAdCacheInfo.e().getUnitGroupInfo());
                            final k kVarA = k.a(NativeAd.this.mBaseNativeAd, NativeAd.this.mAdCacheInfo.e());
                            if (kVarA.getNetworkFirmId() == -1) {
                                g.a(i.o.a, NativeAd.this.mAdCacheInfo.e(), NativeAd.this.mBaseNativeAd);
                            }
                            s.b();
                            s.b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.16.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (NativeAd.this.mRevenueListener != null) {
                                        NativeAd.this.mRevenueListener.onAdRevenuePaid(kVarA);
                                    }
                                    if (NativeAd.this.mNativeEventListener != null) {
                                        NativeAd.this.mNativeEventListener.onAdImpressed(aTNativeAdView, kVarA);
                                    }
                                }
                            });
                        }
                    } catch (Exception unused) {
                        Log.e("NativeAd", "BaseNativeAd has been destotyed.");
                    }
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillRenderAreaToTrackingInfo(com.anythink.core.common.h.n nVar, ATNativeAdView aTNativeAdView) {
        if (nVar == null || aTNativeAdView == null || nVar.Z() != 66) {
            return;
        }
        nVar.a(aTNativeAdView.getWidth(), aTNativeAdView.getHeight());
    }

    void handleDeeplinkCallback(final ATNativeAdView aTNativeAdView, final boolean z) {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bN, new Runnable() { // from class: com.anythink.nativead.api.NativeAd.17
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mIsDestroyed || NativeAd.this.mNativeEventListener == null || !(NativeAd.this.mNativeEventListener instanceof ATNativeEventExListener)) {
                    return;
                }
                ((ATNativeEventExListener) NativeAd.this.mNativeEventListener).onDeeplinkCallback(aTNativeAdView, k.a(NativeAd.this.mBaseNativeAd, NativeAd.this.mAdCacheInfo.e()), z);
            }
        }));
    }

    void handleAdActRewardSuccess() {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bO, new Runnable() { // from class: com.anythink.nativead.api.NativeAd.2
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mIsDestroyed || NativeAd.this.mNativeEventListener == null || !(NativeAd.this.mNativeEventListener instanceof ATNativeEventExListener)) {
                    return;
                }
                ((ATNativeEventExListener) NativeAd.this.mNativeEventListener).onAdActRewardSuccess(k.a(NativeAd.this.mBaseNativeAd, NativeAd.this.mAdCacheInfo.e()));
            }
        }));
    }

    void handleAdActReward(final int i) {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bP, new Runnable() { // from class: com.anythink.nativead.api.NativeAd.3
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mIsDestroyed || NativeAd.this.mNativeEventListener == null || !(NativeAd.this.mNativeEventListener instanceof ATNativeEventExListener)) {
                    return;
                }
                ((ATNativeEventExListener) NativeAd.this.mNativeEventListener).onAdActReward(k.a(NativeAd.this.mBaseNativeAd, NativeAd.this.mAdCacheInfo.e()), i);
            }
        }));
    }

    void handleClick(final ATNativeAdView aTNativeAdView, View view) {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bM, new Runnable() { // from class: com.anythink.nativead.api.NativeAd.4
            @Override // java.lang.Runnable
            public void run() {
                if (NativeAd.this.mIsDestroyed) {
                    return;
                }
                if (NativeAd.this.mBaseNativeAd != null) {
                    com.anythink.core.common.h.n detail = NativeAd.this.mBaseNativeAd.getDetail();
                    if (detail.Z() == 66) {
                        try {
                            Object object = NativeAd.this.mBaseNativeAd.getObject();
                            if (object instanceof Map) {
                                ai.a(detail, (Map<String, Object>) object);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    com.anythink.core.common.t.e.a(NativeAd.this.mContext.getApplicationContext());
                    com.anythink.core.common.t.e.a(6, detail);
                    if (detail != null ? detail.aB() : false) {
                        return;
                    } else {
                        aa.a(detail, i.s.d, i.s.m, "");
                    }
                }
                if (NativeAd.this.mAdCacheInfo != null && NativeAd.this.mBaseNativeAd != null) {
                    com.anythink.core.common.u.c.a().b(NativeAd.this.mAdCacheInfo.e(), NativeAd.this.mBaseNativeAd.getDetail(), NativeAd.this.isNativeExpressByNativeAd());
                }
                s.b();
                s.b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (NativeAd.this.mNativeEventListener != null) {
                            NativeAd.this.mNativeEventListener.onAdClicked(aTNativeAdView, k.a(NativeAd.this.mBaseNativeAd, NativeAd.this.mAdCacheInfo.e()));
                        }
                    }
                });
            }
        }));
    }

    void handleVideoStart(final ATNativeAdView aTNativeAdView) {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bT, new Runnable() { // from class: com.anythink.nativead.api.NativeAd.5
            @Override // java.lang.Runnable
            public void run() {
                if (NativeAd.this.mIsDestroyed) {
                    return;
                }
                if (NativeAd.this.mBaseNativeAd != null) {
                    com.anythink.core.common.h.n detail = NativeAd.this.mBaseNativeAd.getDetail();
                    detail.w = 0;
                    com.anythink.core.common.t.e.a(NativeAd.this.mContext.getApplicationContext());
                    com.anythink.core.common.t.e.a(8, detail);
                }
                s.b();
                s.b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.5.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (NativeAd.this.mNativeEventListener != null) {
                            NativeAd.this.mNativeEventListener.onAdVideoStart(aTNativeAdView);
                        }
                    }
                });
            }
        }));
    }

    void handleAdDislikeButtonClick(final ATNativeAdView aTNativeAdView) {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bL, new Runnable() { // from class: com.anythink.nativead.api.NativeAd.6
            @Override // java.lang.Runnable
            public void run() {
                if (NativeAd.this.mIsDestroyed) {
                    return;
                }
                s.b();
                s.b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.6.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (NativeAd.this.mDislikeListener != null) {
                            NativeAd.this.mDislikeListener.onAdCloseButtonClick(aTNativeAdView, k.a(NativeAd.this.mBaseNativeAd, NativeAd.this.mAdCacheInfo.e()));
                        }
                    }
                });
                if (NativeAd.this.mAdCacheInfo != null && NativeAd.this.mBaseNativeAd != null) {
                    com.anythink.core.common.u.c cVarA = com.anythink.core.common.u.c.a();
                    NativeAd.this.mAdCacheInfo.e();
                    com.anythink.core.common.h.n detail = NativeAd.this.mBaseNativeAd.getDetail();
                    NativeAd.this.isNativeExpressByNativeAd();
                    cVarA.a(detail);
                }
                s.b().ai();
            }
        }));
    }

    void handleVideoEnd(final ATNativeAdView aTNativeAdView) {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bR, new Runnable() { // from class: com.anythink.nativead.api.NativeAd.7
            @Override // java.lang.Runnable
            public void run() {
                if (NativeAd.this.mIsDestroyed) {
                    return;
                }
                if (NativeAd.this.mBaseNativeAd != null) {
                    com.anythink.core.common.h.n detail = NativeAd.this.mBaseNativeAd.getDetail();
                    detail.w = 100;
                    com.anythink.core.common.t.e.a(NativeAd.this.mContext.getApplicationContext());
                    com.anythink.core.common.t.e.a(9, detail);
                }
                s.b();
                s.b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.7.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (NativeAd.this.mNativeEventListener != null) {
                            NativeAd.this.mNativeEventListener.onAdVideoEnd(aTNativeAdView);
                        }
                    }
                });
            }
        }));
    }

    void handleVideoProgress(final ATNativeAdView aTNativeAdView, final int i) {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bS, new Runnable() { // from class: com.anythink.nativead.api.NativeAd.8
            @Override // java.lang.Runnable
            public void run() {
                if (NativeAd.this.mIsDestroyed) {
                    return;
                }
                s.b();
                s.b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.8.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (NativeAd.this.mNativeEventListener != null) {
                            NativeAd.this.mNativeEventListener.onAdVideoProgress(aTNativeAdView, i);
                        }
                    }
                });
            }
        }));
    }

    void handleDownloadConfirm(final Context context, final View view, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bK, new Runnable() { // from class: com.anythink.nativead.api.NativeAd.9
            @Override // java.lang.Runnable
            public void run() {
                if (NativeAd.this.mIsDestroyed) {
                    return;
                }
                s.b();
                s.b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.9.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (NativeAd.this.mConfirmListener == null || NativeAd.this.mBaseNativeAd == null) {
                            return;
                        }
                        NativeAd.this.mConfirmListener.onDownloadConfirm(context != null ? context : NativeAd.this.mContext, k.a(NativeAd.this.mBaseNativeAd, NativeAd.this.mAdCacheInfo.e()), view, aTNetworkConfirmInfo);
                    }
                });
            }
        }));
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        this.mEventInterface = aTEventInterface;
        r rVarC = s.b().c();
        if (rVarC == null) {
            this.mBaseNativeAd.setDownloadListener(null);
            Log.e(this.TAG, "This method is not supported in this version");
        } else if (aTEventInterface != null) {
            this.mBaseNativeAd.setDownloadListener(rVarC.createDataFetchListener(this.mAdCacheInfo.e(), this.mBaseNativeAd, aTEventInterface));
        } else {
            this.mBaseNativeAd.setDownloadListener(null);
        }
    }

    public void onPause() {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.onPause();
    }

    public void onResume() {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.onResume();
    }

    public void resumeVideo() {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.resumeVideo();
    }

    public void pauseVideo() {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.pauseVideo();
    }

    public void setVideoMute(boolean z) {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.setVideoMute(z);
    }

    public double getVideoDuration() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return 0.0d;
        }
        return ((CustomNativeAd) aVar).getVideoDuration();
    }

    public double getVideoProgress() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return 0.0d;
        }
        return ((CustomNativeAd) aVar).getVideoProgress();
    }

    public boolean isNativeExpress() {
        if (isSupportRenderToInnerTemplate()) {
            return true;
        }
        return isNativeExpressByNativeAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNativeExpressByNativeAd() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return false;
        }
        return ((CustomNativeAd) aVar).isNativeExpress();
    }

    public int getNativeType() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return 0;
        }
        return ((CustomNativeAd) aVar).getNativeType();
    }

    @Deprecated
    public ATCustomVideo getCustomVideo() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return null;
        }
        return ((CustomNativeAd) aVar).getNativeCustomVideo();
    }

    public ATAdInfo getAdInfo() {
        return k.a(this.mBaseNativeAd, this.mAdCacheInfo.e(), this.mRecordedImpression.get() ? 5 : 4);
    }

    public int getDownloadStatus() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return 0;
        }
        return aVar.getDownloadStatus();
    }

    public int getDownloadProgress() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return 0;
        }
        return aVar.getDownloadProgress();
    }

    public void setDevParams(Map<String, Object> map) {
        a aVar;
        if (map == null || (aVar = this.mBaseNativeAd) == null || !(aVar instanceof CustomNativeAd)) {
            return;
        }
        aVar.setDevParams(map);
    }

    public boolean isValid() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return true;
        }
        return aVar.isValid();
    }

    private boolean isSupportRenderToInnerTemplate() {
        return isSupportRenderToInnerTemplate(true);
    }

    private boolean isSupportRenderToInnerTemplate(boolean z) {
        com.anythink.core.common.k.d.b serverExtraInfo = this.mAdCacheInfo.e() != null ? this.mAdCacheInfo.e().getServerExtraInfo() : null;
        if (serverExtraInfo == null || serverExtraInfo.p() <= 0) {
            return false;
        }
        return !z || serverExtraInfo.p() > 1;
    }

    public Object getObject() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return null;
        }
        return aVar.getObject();
    }
}
