package com.anythink.nativead.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.mixad.b.e;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomVideo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.l;
import com.anythink.core.common.d.o;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.f;
import com.anythink.core.common.h.c;
import com.anythink.core.common.h.n;
import com.anythink.core.common.l.g.d;
import com.anythink.core.common.u;
import com.anythink.core.common.u.h;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.p;
import com.anythink.core.common.v.q;
import com.anythink.nativead.a.b;
import com.anythink.nativead.unitgroup.a;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import java.util.Map;

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
    private boolean mIsDestroyed;
    private int mNativeAdHeight;
    private int mNativeAdWidth;
    private ATNativeEventListener mNativeEventListener;
    ATNativeAdView mNativeView;
    private String mPlacementId;
    private boolean mRecordedImpression;
    private boolean mRecordedShow;
    private ATAdRevenueListener mRevenueListener;
    ATNativeMaterial nativeMaterial;
    private ATNativeAdInfo.AdPrepareInfo thirdPartyAdPrepareInfo;
    private final String TAG = getClass().getSimpleName();
    private boolean hasCallPrepareApi = false;
    private boolean hasCallPrepareRenderApi = false;
    private boolean hasReportRenderTypeAgent = false;
    View.OnClickListener mDefaultCloseViewListener = new View.OnClickListener() { // from class: com.anythink.nativead.api.NativeAd.11
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

    protected NativeAd(Context context, String str, c cVar) {
        this.mNativeAdWidth = 0;
        this.mNativeAdHeight = 0;
        this.mContext = context.getApplicationContext();
        this.mPlacementId = str;
        this.mAdCacheInfo = cVar;
        a aVar = (a) cVar.f();
        this.mBaseNativeAd = aVar;
        aVar.setNativeEventListener(new o() { // from class: com.anythink.nativead.api.NativeAd.1
            @Override // com.anythink.core.common.d.o
            public final void onAdDislikeButtonClick() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleAdDislikeButtonClick(nativeAd.mNativeView);
            }

            @Override // com.anythink.core.common.d.o
            public final void onDeeplinkCallback(boolean z) {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleDeeplinkCallback(nativeAd.mNativeView, z);
            }

            @Override // com.anythink.core.common.d.o
            public final void onDownloadConfirmCallback(Context context2, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                NativeAd.this.handleDownloadConfirm(context2, view, aTNetworkConfirmInfo);
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdImpressed() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleImpression(nativeAd.mNativeView);
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdClicked(View view) {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleClick(nativeAd.mNativeView, view);
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdVideoStart() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleVideoStart(nativeAd.mNativeView);
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdVideoEnd() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleVideoEnd(nativeAd.mNativeView);
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdVideoProgress(int i) {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleVideoProgress(nativeAd.mNativeView, i);
            }
        });
        if (this.mBaseNativeAd instanceof CustomNativeAd) {
            this.nativeMaterial = new b((CustomNativeAd) this.mBaseNativeAd, isSupportRenderToInnerTemplate());
        }
        c cVar2 = this.mAdCacheInfo;
        if (cVar2 == null || cVar2.i() == null || this.mAdCacheInfo.i().j() == null) {
            return;
        }
        Map<String, Object> mapJ = this.mAdCacheInfo.i().j();
        this.mNativeAdWidth = ((Integer) q.a(mapJ, ATAdConst.KEY.AD_WIDTH, 0)).intValue();
        this.mNativeAdHeight = ((Integer) q.a(mapJ, ATAdConst.KEY.AD_HEIGHT, 0)).intValue();
    }

    public ATNativeMaterial getAdMaterial() {
        return this.nativeMaterial;
    }

    public synchronized void renderAdContainer(final ATNativeAdView aTNativeAdView, final View view) {
        t.b().b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.7
            @Override // java.lang.Runnable
            public final void run() {
                NativeAd.this.renderAdOnUiThread(aTNativeAdView, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void renderAdOnUiThread(ATNativeAdView aTNativeAdView, View view) {
        com.anythink.core.common.l.d.b serverExtraInfo;
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
                com.anythink.core.common.l.d.a aVarA = new com.anythink.core.common.l.d.a.C0085a().a(aTNativeAdView.getContext()).a(this.mBaseNativeAd.getDetail()).a(new com.anythink.core.common.l.e.a() { // from class: com.anythink.nativead.api.NativeAd.8
                    @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
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
                        eVar.a(new com.anythink.basead.mixad.c.b(aVarA));
                    }
                }
                if (eVar instanceof com.anythink.core.common.l.c.a.d) {
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
        ab.b(this.mPlacementId, j.r.s, j.r.A, j.r.o, "");
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
        this.mNativeView.renderView(iHashCode, view, new ImpressionEventListener() { // from class: com.anythink.nativead.api.NativeAd.9
            @Override // com.anythink.nativead.api.NativeAd.ImpressionEventListener
            public final void onImpression() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                n detail = NativeAd.this.mBaseNativeAd != null ? NativeAd.this.mBaseNativeAd.getDetail() : null;
                if (detail != null && TextUtils.isEmpty(detail.z())) {
                    detail.n(p.a(detail.aJ(), detail.M(), jCurrentTimeMillis));
                }
                if (NativeAd.this.mBaseNativeAd instanceof CustomNativeAd) {
                    ((CustomNativeAd) NativeAd.this.mBaseNativeAd).setShowId(detail.z());
                }
                NativeAd nativeAd = NativeAd.this;
                nativeAd.recordShow(nativeAd.mNativeView);
            }
        });
    }

    public synchronized void prepare(final ATNativeAdView aTNativeAdView, final ATNativePrepareInfo aTNativePrepareInfo) {
        t.b().b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.10
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
            if (callback instanceof com.anythink.core.common.l.e.a.d) {
                ((com.anythink.core.common.l.e.a.d) callback).destroyNativeAd();
            }
            this.innerChildView = null;
        }
        this.thirdPartyAdPrepareInfo = null;
        a aVar = this.mBaseNativeAd;
        if (aVar != null) {
            aVar.setNativePrepareInfo(null);
            this.mBaseNativeAd.destroy();
        }
    }

    private void checkToReportRenderErrorAgent(boolean z) {
        n detail;
        String str;
        try {
            if ((this.mRecordedShow && this.mRecordedImpression) || this.hasReportRenderTypeAgent) {
                return;
            }
            this.hasReportRenderTypeAgent = true;
            a aVar = this.mBaseNativeAd;
            if (aVar == null || (detail = aVar.getDetail()) == null || detail.Y() != 66) {
                return;
            }
            String str2 = "1";
            String str3 = this.hasCallPrepareRenderApi ? "1" : "2";
            String str4 = this.hasCallPrepareApi ? "1" : "2";
            if (this.mRecordedShow || this.mRecordedImpression) {
                str2 = !this.mRecordedImpression ? "2" : "";
            }
            if (z) {
                str2 = "3";
                str = "0";
                str4 = str;
            } else {
                str = str3;
            }
            Map<String, Object> networkInfoMap = this.mBaseNativeAd.getNetworkInfoMap();
            Object obj = networkInfoMap.get("dsp_id");
            Object obj2 = networkInfoMap.get("offer_id");
            com.anythink.core.common.u.e.a(detail, str2, str, str4, obj != null ? obj.toString() : "", obj2 != null ? obj2.toString() : "");
        } catch (Throwable th) {
            th.getMessage();
            th.printStackTrace();
        }
    }

    protected void finalize() throws Throwable {
        checkToReportRenderErrorAgent(false);
        super.finalize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void fillShowTrackingInfo(n nVar) {
        if (!this.hasSetShowTkDetail) {
            this.hasSetShowTkDetail = true;
            if (nVar != null) {
                aj.a(this.mContext, nVar);
            }
        }
    }

    synchronized void recordShow(ATNativeAdView aTNativeAdView) {
        f fVarA;
        if (!this.mRecordedShow) {
            final n detail = this.mBaseNativeAd.getDetail();
            this.mRecordedShow = true;
            if (this.mAdCacheInfo != null && (fVarA = u.a().a(this.mPlacementId, "0")) != null) {
                fVarA.a(this.mAdCacheInfo);
            }
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.12
                @Override // java.lang.Runnable
                public final void run() {
                    if (NativeAd.this.mIsDestroyed || NativeAd.this.mAdCacheInfo == null) {
                        return;
                    }
                    NativeAd.this.fillShowTrackingInfo(detail);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        String[] strArrSplit = detail.z().split("_");
                        jCurrentTimeMillis = Long.parseLong(strArrSplit[strArrSplit.length - 1]);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    long j = jCurrentTimeMillis;
                    if (NativeAd.this.mBaseNativeAd != null && (NativeAd.this.mBaseNativeAd instanceof CustomNativeAd)) {
                        ((CustomNativeAd) NativeAd.this.mBaseNativeAd).setShowId(detail.z());
                    }
                    com.anythink.core.common.a.a().a(NativeAd.this.mContext.getApplicationContext(), NativeAd.this.mAdCacheInfo);
                    com.anythink.core.common.u.c.a(NativeAd.this.mContext).a(13, detail, NativeAd.this.mAdCacheInfo.e().getUnitGroupInfo(), j);
                }
            });
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
            if (t.b().F()) {
                Log.e(this.TAG, "Must call \"setManualImpressionTrack(true);\" first.");
                return;
            }
            return;
        }
        ATNativeAdView aTNativeAdView = this.mNativeView;
        c cVar = this.mAdCacheInfo;
        ATBaseAdAdapter aTBaseAdAdapterE = cVar != null ? cVar.e() : null;
        if (aTBaseAdAdapterE != null && aTBaseAdAdapterE.supportImpressionCallback()) {
            if (t.b().F()) {
                Log.e(this.TAG, "This NativeAd don't support tracking impressions manually.");
                return;
            }
            return;
        }
        if (aTNativeAdView == null) {
            if (t.b().F()) {
                Log.e(this.TAG, "NativeAd don't call render.");
                return;
            }
            return;
        }
        if (!aTNativeAdView.isShown()) {
            if (t.b().F()) {
                Log.e(this.TAG, "ATNativeAdView isn't visible.");
            }
        } else if (!aTNativeAdView.isAttachedToWindow()) {
            if (t.b().F()) {
                Log.e(this.TAG, "ATNativeAdView don't attach window.");
            }
        } else {
            if (t.b().F()) {
                Log.i(this.TAG, "try to track impression manually.");
            }
            a aVar = this.mBaseNativeAd;
            if (aVar instanceof CustomNativeAd) {
                ((CustomNativeAd) aVar).impressionTrack(aTNativeAdView);
            }
        }
    }

    synchronized void handleImpression(final ATNativeAdView aTNativeAdView) {
        if (!this.mRecordedImpression && !this.mIsDestroyed) {
            this.mRecordedImpression = true;
            if (this.mAdCacheInfo != null && this.mBaseNativeAd != null && isNativeExpressByNativeAd()) {
                com.anythink.core.common.v.c.a().a(this.mAdCacheInfo.e(), this.mBaseNativeAd.getDetail());
            }
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.13
                @Override // java.lang.Runnable
                public void run() {
                    if (NativeAd.this.mIsDestroyed) {
                        return;
                    }
                    try {
                        if (NativeAd.this.mBaseNativeAd != null) {
                            n detail = NativeAd.this.mBaseNativeAd.getDetail();
                            detail.a(NativeAd.this.mBaseNativeAd.getNetworkInfoMap());
                            ab.a(detail, j.r.c, j.r.m, "");
                            NativeAd.this.fillShowTrackingInfo(detail);
                            NativeAd.this.fillRenderAreaToTrackingInfo(detail, aTNativeAdView);
                            com.anythink.core.common.u.c.a(NativeAd.this.mContext.getApplicationContext()).a(4, detail, NativeAd.this.mAdCacheInfo.e().getUnitGroupInfo());
                            final l lVarA = l.a(NativeAd.this.mBaseNativeAd, NativeAd.this.mAdCacheInfo.e());
                            if (lVarA.getNetworkFirmId() == -1) {
                                h.a(j.n.a, NativeAd.this.mAdCacheInfo.e(), NativeAd.this.mBaseNativeAd);
                            }
                            t.b().b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.13.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (NativeAd.this.mRevenueListener != null) {
                                        NativeAd.this.mRevenueListener.onAdRevenuePaid(lVarA);
                                    }
                                    if (NativeAd.this.mNativeEventListener != null) {
                                        NativeAd.this.mNativeEventListener.onAdImpressed(aTNativeAdView, lVarA);
                                    }
                                }
                            });
                        }
                    } catch (Exception unused) {
                        Log.e("NativeAd", "BaseNativeAd has been destotyed.");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillRenderAreaToTrackingInfo(n nVar, ATNativeAdView aTNativeAdView) {
        if (nVar == null || aTNativeAdView == null || nVar.Y() != 66) {
            return;
        }
        nVar.a(aTNativeAdView.getWidth(), aTNativeAdView.getHeight());
    }

    synchronized void handleDeeplinkCallback(final ATNativeAdView aTNativeAdView, final boolean z) {
        if (this.mIsDestroyed) {
            return;
        }
        t.b().b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.14
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mNativeEventListener == null || !(NativeAd.this.mNativeEventListener instanceof ATNativeEventExListener)) {
                    return;
                }
                ((ATNativeEventExListener) NativeAd.this.mNativeEventListener).onDeeplinkCallback(aTNativeAdView, l.a(NativeAd.this.mBaseNativeAd, NativeAd.this.mAdCacheInfo.e()), z);
            }
        });
    }

    synchronized void handleClick(final ATNativeAdView aTNativeAdView, View view) {
        if (this.mIsDestroyed) {
            return;
        }
        a aVar = this.mBaseNativeAd;
        if (aVar != null) {
            n detail = aVar.getDetail();
            com.anythink.core.common.u.c.a(this.mContext.getApplicationContext()).a(6, detail);
            if (detail != null ? detail.aw() : false) {
                return;
            } else {
                ab.a(detail, j.r.d, j.r.m, "");
            }
        }
        if (this.mAdCacheInfo != null && this.mBaseNativeAd != null && isNativeExpressByNativeAd()) {
            com.anythink.core.common.v.c.a().b(this.mAdCacheInfo.e(), this.mBaseNativeAd.getDetail());
        }
        t.b().b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.2
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mNativeEventListener != null) {
                    NativeAd.this.mNativeEventListener.onAdClicked(aTNativeAdView, l.a(NativeAd.this.mBaseNativeAd, NativeAd.this.mAdCacheInfo.e()));
                }
            }
        });
    }

    synchronized void handleVideoStart(final ATNativeAdView aTNativeAdView) {
        if (this.mIsDestroyed) {
            return;
        }
        a aVar = this.mBaseNativeAd;
        if (aVar != null) {
            n detail = aVar.getDetail();
            detail.w = 0;
            com.anythink.core.common.u.c.a(this.mContext.getApplicationContext()).a(8, detail);
        }
        t.b().b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.3
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mNativeEventListener != null) {
                    NativeAd.this.mNativeEventListener.onAdVideoStart(aTNativeAdView);
                }
            }
        });
    }

    synchronized void handleAdDislikeButtonClick(final ATNativeAdView aTNativeAdView) {
        if (this.mIsDestroyed) {
            return;
        }
        t.b().b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.4
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mDislikeListener != null) {
                    NativeAd.this.mDislikeListener.onAdCloseButtonClick(aTNativeAdView, l.a(NativeAd.this.mBaseNativeAd, NativeAd.this.mAdCacheInfo.e()));
                }
            }
        });
    }

    synchronized void handleVideoEnd(final ATNativeAdView aTNativeAdView) {
        if (this.mIsDestroyed) {
            return;
        }
        a aVar = this.mBaseNativeAd;
        if (aVar != null) {
            n detail = aVar.getDetail();
            detail.w = 100;
            com.anythink.core.common.u.c.a(this.mContext.getApplicationContext()).a(9, detail);
        }
        t.b().b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.5
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mNativeEventListener != null) {
                    NativeAd.this.mNativeEventListener.onAdVideoEnd(aTNativeAdView);
                }
            }
        });
    }

    synchronized void handleVideoProgress(final ATNativeAdView aTNativeAdView, final int i) {
        if (this.mIsDestroyed) {
            return;
        }
        t.b().b(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.6
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mNativeEventListener != null) {
                    NativeAd.this.mNativeEventListener.onAdVideoProgress(aTNativeAdView, i);
                }
            }
        });
    }

    synchronized void handleDownloadConfirm(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        a aVar;
        if (this.mIsDestroyed) {
            return;
        }
        DownloadConfirmListener downloadConfirmListener = this.mConfirmListener;
        if (downloadConfirmListener != null && (aVar = this.mBaseNativeAd) != null) {
            if (context == null) {
                context = this.mContext;
            }
            downloadConfirmListener.onDownloadConfirm(context, l.a(aVar, this.mAdCacheInfo.e()), view, aTNetworkConfirmInfo);
        }
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        this.mEventInterface = aTEventInterface;
        s sVarC = t.b().c();
        if (sVarC == null) {
            this.mBaseNativeAd.setDownloadListener(null);
            Log.e(this.TAG, "This method is not supported in this version");
        } else if (aTEventInterface != null) {
            this.mBaseNativeAd.setDownloadListener(sVarC.createDataFetchListener(this.mAdCacheInfo.e(), this.mBaseNativeAd, aTEventInterface));
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

    private boolean isNativeExpressByNativeAd() {
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
        return l.a(this.mBaseNativeAd, this.mAdCacheInfo.e(), this.mRecordedImpression ? 5 : 4);
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
        com.anythink.core.common.l.d.b serverExtraInfo = this.mAdCacheInfo.e() != null ? this.mAdCacheInfo.e().getServerExtraInfo() : null;
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
