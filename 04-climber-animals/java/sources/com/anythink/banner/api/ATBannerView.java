package com.anythink.banner.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.banner.a.c;
import com.anythink.banner.a.d;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomContentResult;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.ATRequestingInfo;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.d.a;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.l;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.u;
import com.anythink.core.common.u.h;
import com.anythink.core.common.v.a.f;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.b.b;
import com.anythink.core.common.v.p;
import com.anythink.core.common.v.r;
import com.anythink.core.d.n;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ATBannerView extends FrameLayout implements c {
    private final String TAG;
    a adLoadListener;
    public ATAdMultipleLoadedListener adMultipleLoadedListener;
    private ATAdxBidFloorInfo adxBidFloorInfo;
    private boolean canRenderBanner;
    boolean hasTouchWindow;
    com.anythink.core.common.v.a.c impressionTracker;
    boolean isShowCall;
    private ATCustomContentResult mATCustomContentResult;
    private com.anythink.banner.a.a mAdLoadManager;
    private ATAdRequest mAdRequest;
    com.anythink.core.common.d.c mAdSourceEventListener;
    private com.anythink.banner.b.a mBannerRefreshTimer;
    CustomBannerAdapter mCustomBannerAd;
    ATAdSourceStatusListener mDeveloperStatusListener;
    ATEventInterface mDownloadListener;
    private d mInnerBannerListener;
    boolean mIsRefresh;
    private com.anythink.core.common.l.e.a.c mLastShowBannerView;
    private ATBannerListener mListener;
    private ATAdMultipleLoadedListener mMultipleLoadedListener;
    private String mPlacementId;
    private ATAdRevenueListener mRevenueListener;
    private String mScenario;
    private String mShowCustomExt;
    Map<String, Object> mTKExtraMap;
    private ATNativeAdCustomRender nativeAdCustomRender;
    f.b visibilityChecker;

    public ATBannerView(Context context) {
        super(context);
        this.TAG = "ATBannerView";
        this.mScenario = "";
        this.mShowCustomExt = "";
        this.hasTouchWindow = false;
        this.mIsRefresh = false;
        this.mInnerBannerListener = new d() { // from class: com.anythink.banner.api.ATBannerView.1
            @Override // com.anythink.banner.a.d
            public void onBannerClicked(final CustomBannerAdapter customBannerAdapter) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClicked(l.a(customBannerAdapter));
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onBannerShow(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        l lVarA = l.a(customBannerAdapter);
                        if (ATBannerView.this.mRevenueListener != null) {
                            ATBannerView.this.mRevenueListener.onAdRevenuePaid(lVarA);
                        }
                        if (ATBannerView.this.mListener != null) {
                            if (customBannerAdapter == null || !z) {
                                ATBannerView.this.mListener.onBannerShow(lVarA);
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(lVarA);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onBannerClose(final CustomBannerAdapter customBannerAdapter) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClose(l.a(customBannerAdapter));
                        }
                    }
                });
                if (ATAdxSetting.getInstance().isAdxNetworkMode(ATBannerView.this.mPlacementId)) {
                    return;
                }
                ATBannerView.this.canRenderBanner = true;
                ATBannerView aTBannerView = ATBannerView.this;
                aTBannerView.loadAd(1, aTBannerView.mAdRequest);
            }

            @Override // com.anythink.banner.a.d
            public void onDeeplinkCallback(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDeeplinkCallback(ATBannerView.this.mIsRefresh, l.a(customBannerAdapter), z);
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onDownloadConfirm(final Context context2, final CustomBannerAdapter customBannerAdapter, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDownloadConfirm(context2, l.a(customBannerAdapter), aTNetworkConfirmInfo);
                    }
                });
            }
        };
        this.adLoadListener = new a() { // from class: com.anythink.banner.api.ATBannerView.2
            @Override // com.anythink.core.common.d.a
            public void onAdLoaded() {
                ATBannerView.this.isShowCall = true;
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null && !ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerLoaded();
                        }
                        ATBannerView.this.controlShow();
                    }
                });
            }

            @Override // com.anythink.core.common.d.a
            public void onAdLoadFail(final AdError adError) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !ATBannerView.this.canRenderBanner) {
                            return;
                        }
                        if (ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerAutoRefreshFail(adError);
                        } else {
                            ATBannerView.this.mListener.onBannerFailed(adError);
                        }
                    }
                });
                if (ATBannerView.this.mAdLoadManager == null || !ATBannerView.this.isInView() || ATBannerView.this.mBannerRefreshTimer.a()) {
                    return;
                }
                String unused = ATBannerView.this.TAG;
                ATBannerView.this.mBannerRefreshTimer.b();
            }
        };
        this.adMultipleLoadedListener = new ATAdMultipleLoadedListener() { // from class: com.anythink.banner.api.ATBannerView.3
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mMultipleLoadedListener != null) {
                            ATBannerView.this.mMultipleLoadedListener.onAdMultipleLoaded(aTRequestingInfo);
                        }
                    }
                });
            }
        };
        this.mBannerRefreshTimer = new com.anythink.banner.b.a(this);
    }

    public ATBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "ATBannerView";
        this.mScenario = "";
        this.mShowCustomExt = "";
        this.hasTouchWindow = false;
        this.mIsRefresh = false;
        this.mInnerBannerListener = new d() { // from class: com.anythink.banner.api.ATBannerView.1
            @Override // com.anythink.banner.a.d
            public void onBannerClicked(final CustomBannerAdapter customBannerAdapter) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClicked(l.a(customBannerAdapter));
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onBannerShow(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        l lVarA = l.a(customBannerAdapter);
                        if (ATBannerView.this.mRevenueListener != null) {
                            ATBannerView.this.mRevenueListener.onAdRevenuePaid(lVarA);
                        }
                        if (ATBannerView.this.mListener != null) {
                            if (customBannerAdapter == null || !z) {
                                ATBannerView.this.mListener.onBannerShow(lVarA);
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(lVarA);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onBannerClose(final CustomBannerAdapter customBannerAdapter) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClose(l.a(customBannerAdapter));
                        }
                    }
                });
                if (ATAdxSetting.getInstance().isAdxNetworkMode(ATBannerView.this.mPlacementId)) {
                    return;
                }
                ATBannerView.this.canRenderBanner = true;
                ATBannerView aTBannerView = ATBannerView.this;
                aTBannerView.loadAd(1, aTBannerView.mAdRequest);
            }

            @Override // com.anythink.banner.a.d
            public void onDeeplinkCallback(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDeeplinkCallback(ATBannerView.this.mIsRefresh, l.a(customBannerAdapter), z);
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onDownloadConfirm(final Context context2, final CustomBannerAdapter customBannerAdapter, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDownloadConfirm(context2, l.a(customBannerAdapter), aTNetworkConfirmInfo);
                    }
                });
            }
        };
        this.adLoadListener = new a() { // from class: com.anythink.banner.api.ATBannerView.2
            @Override // com.anythink.core.common.d.a
            public void onAdLoaded() {
                ATBannerView.this.isShowCall = true;
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null && !ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerLoaded();
                        }
                        ATBannerView.this.controlShow();
                    }
                });
            }

            @Override // com.anythink.core.common.d.a
            public void onAdLoadFail(final AdError adError) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !ATBannerView.this.canRenderBanner) {
                            return;
                        }
                        if (ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerAutoRefreshFail(adError);
                        } else {
                            ATBannerView.this.mListener.onBannerFailed(adError);
                        }
                    }
                });
                if (ATBannerView.this.mAdLoadManager == null || !ATBannerView.this.isInView() || ATBannerView.this.mBannerRefreshTimer.a()) {
                    return;
                }
                String unused = ATBannerView.this.TAG;
                ATBannerView.this.mBannerRefreshTimer.b();
            }
        };
        this.adMultipleLoadedListener = new ATAdMultipleLoadedListener() { // from class: com.anythink.banner.api.ATBannerView.3
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mMultipleLoadedListener != null) {
                            ATBannerView.this.mMultipleLoadedListener.onAdMultipleLoaded(aTRequestingInfo);
                        }
                    }
                });
            }
        };
        this.mBannerRefreshTimer = new com.anythink.banner.b.a(this);
    }

    public ATBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "ATBannerView";
        this.mScenario = "";
        this.mShowCustomExt = "";
        this.hasTouchWindow = false;
        this.mIsRefresh = false;
        this.mInnerBannerListener = new d() { // from class: com.anythink.banner.api.ATBannerView.1
            @Override // com.anythink.banner.a.d
            public void onBannerClicked(final CustomBannerAdapter customBannerAdapter) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClicked(l.a(customBannerAdapter));
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onBannerShow(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        l lVarA = l.a(customBannerAdapter);
                        if (ATBannerView.this.mRevenueListener != null) {
                            ATBannerView.this.mRevenueListener.onAdRevenuePaid(lVarA);
                        }
                        if (ATBannerView.this.mListener != null) {
                            if (customBannerAdapter == null || !z) {
                                ATBannerView.this.mListener.onBannerShow(lVarA);
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(lVarA);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onBannerClose(final CustomBannerAdapter customBannerAdapter) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClose(l.a(customBannerAdapter));
                        }
                    }
                });
                if (ATAdxSetting.getInstance().isAdxNetworkMode(ATBannerView.this.mPlacementId)) {
                    return;
                }
                ATBannerView.this.canRenderBanner = true;
                ATBannerView aTBannerView = ATBannerView.this;
                aTBannerView.loadAd(1, aTBannerView.mAdRequest);
            }

            @Override // com.anythink.banner.a.d
            public void onDeeplinkCallback(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDeeplinkCallback(ATBannerView.this.mIsRefresh, l.a(customBannerAdapter), z);
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onDownloadConfirm(final Context context2, final CustomBannerAdapter customBannerAdapter, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDownloadConfirm(context2, l.a(customBannerAdapter), aTNetworkConfirmInfo);
                    }
                });
            }
        };
        this.adLoadListener = new a() { // from class: com.anythink.banner.api.ATBannerView.2
            @Override // com.anythink.core.common.d.a
            public void onAdLoaded() {
                ATBannerView.this.isShowCall = true;
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null && !ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerLoaded();
                        }
                        ATBannerView.this.controlShow();
                    }
                });
            }

            @Override // com.anythink.core.common.d.a
            public void onAdLoadFail(final AdError adError) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !ATBannerView.this.canRenderBanner) {
                            return;
                        }
                        if (ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerAutoRefreshFail(adError);
                        } else {
                            ATBannerView.this.mListener.onBannerFailed(adError);
                        }
                    }
                });
                if (ATBannerView.this.mAdLoadManager == null || !ATBannerView.this.isInView() || ATBannerView.this.mBannerRefreshTimer.a()) {
                    return;
                }
                String unused = ATBannerView.this.TAG;
                ATBannerView.this.mBannerRefreshTimer.b();
            }
        };
        this.adMultipleLoadedListener = new ATAdMultipleLoadedListener() { // from class: com.anythink.banner.api.ATBannerView.3
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mMultipleLoadedListener != null) {
                            ATBannerView.this.mMultipleLoadedListener.onAdMultipleLoaded(aTRequestingInfo);
                        }
                    }
                });
            }
        };
        this.mBannerRefreshTimer = new com.anythink.banner.b.a(this);
    }

    public void setPlacementId(String str) {
        this.mAdLoadManager = com.anythink.banner.a.a.a(getContext(), str);
        this.mPlacementId = str;
        this.mBannerRefreshTimer.a(str);
        if (this.impressionTracker == null) {
            getContext();
            this.impressionTracker = new com.anythink.core.common.v.a.c(1, 50);
        }
    }

    @Deprecated
    public void setScenario(String str) {
        setShowConfig(p.e(str));
    }

    public void setShowConfig(ATShowConfig aTShowConfig) {
        if (aTShowConfig != null) {
            this.mScenario = aTShowConfig.getScenarioId();
            this.mShowCustomExt = aTShowConfig.getShowCustomExt();
            this.mATCustomContentResult = aTShowConfig.getATCustomContentResult();
        }
    }

    public ATAdStatusInfo checkAdStatus() {
        if (t.b().g() == null || TextUtils.isEmpty(t.b().p()) || TextUtils.isEmpty(t.b().q())) {
            Log.e(this.TAG, "SDK init error!");
            return new ATAdStatusInfo(false, false, null);
        }
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar == null) {
            Log.e(this.TAG, "PlacementId is empty!");
            return new ATAdStatusInfo(false, false, null);
        }
        ATAdStatusInfo aTAdStatusInfoA = aVar.a(getContext(), this.mTKExtraMap);
        ab.b(this.mPlacementId, j.r.p, j.r.C, aTAdStatusInfoA.toString(), "");
        return aTAdStatusInfoA;
    }

    public void setTKExtra(Map<String, Object> map) {
        if (this.mTKExtraMap == null) {
            this.mTKExtraMap = new ConcurrentHashMap();
        }
        this.mTKExtraMap.clear();
        this.mTKExtraMap.putAll(map);
    }

    public List<ATAdInfo> checkValidAdCaches() {
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            return aVar.a(getContext());
        }
        return null;
    }

    public void setLocalExtra(Map<String, Object> map) {
        if (TextUtils.isEmpty(this.mPlacementId)) {
            Log.e(this.TAG, "You must set unit Id first.");
        } else {
            u.a().a(this.mPlacementId, map);
        }
    }

    @Deprecated
    public void setAdxBidFloorInfo(ATAdxBidFloorInfo aTAdxBidFloorInfo) {
        this.adxBidFloorInfo = aTAdxBidFloorInfo;
    }

    public void loadAd() {
        loadAd(null);
    }

    public void loadAd(ATAdRequest aTAdRequest) {
        loadAd(0, aTAdRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(int i, ATAdRequest aTAdRequest) {
        ab.a(this.mPlacementId, j.r.p, j.r.y, j.r.o, "", true);
        if (this.adxBidFloorInfo != null) {
            if (aTAdRequest == null) {
                aTAdRequest = new ATAdRequest.Builder().setATAdxBidFloorInfo(this.adxBidFloorInfo).build();
            } else if (aTAdRequest.getATAdxBidFloorInfo() == null) {
                aTAdRequest.setAdxBidFloorInfo(this.adxBidFloorInfo);
            }
        }
        ATAdRequest aTAdRequest2 = aTAdRequest;
        this.mAdRequest = aTAdRequest2;
        this.mIsRefresh = i == 1;
        if (i == 0) {
            this.canRenderBanner = true;
        }
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.a(getContext(), i, this.adLoadListener, this.mAdSourceEventListener, this.adMultipleLoadedListener, this.mTKExtraMap, aTAdRequest2);
        } else {
            this.adLoadListener.onAdLoadFail(ErrorCode.getErrorCode(ErrorCode.exception, "", "An error occurred before loading"));
        }
    }

    public void setBannerAdListener(ATBannerListener aTBannerListener) {
        this.mListener = aTBannerListener;
    }

    public void setAdRevenueListener(ATAdRevenueListener aTAdRevenueListener) {
        this.mRevenueListener = aTAdRevenueListener;
    }

    public void setAdMultipleLoadedListener(ATAdMultipleLoadedListener aTAdMultipleLoadedListener) {
        this.mMultipleLoadedListener = aTAdMultipleLoadedListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.anythink.core.common.h.c getBannerCache() {
        return this.mAdLoadManager.a(getContext(), this.isShowCall, getCacheCheckInfo(this.mTKExtraMap));
    }

    private ae getCacheCheckInfo(Map<String, Object> map) {
        ae aeVar = new ae();
        aeVar.a(map);
        aeVar.a(this.mAdRequest);
        return aeVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.hasTouchWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hasTouchWindow = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
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

    private void registerDelayShow(View view, final Context context, final com.anythink.core.common.h.c cVar, CustomBannerAdapter customBannerAdapter, final boolean z) {
        if (view == null) {
            view = this;
        }
        com.anythink.core.common.v.a.c cVar2 = this.impressionTracker;
        if (cVar2 != null) {
            cVar2.a(view, new com.anythink.core.common.v.a.a() { // from class: com.anythink.banner.api.ATBannerView.4
                @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
                public final int getImpressionMinPercentageViewed() {
                    return 50;
                }

                @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
                public final int getImpressionMinTimeViewed() {
                    return 0;
                }

                @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
                public final void recordImpression(View view2) {
                    ATBannerView.this.notifyBannerShow(context, cVar, z);
                }
            });
        }
    }

    public static void entryAdScenario(String str, String str2) {
        entryAdScenario(str, str2, null);
    }

    public static void entryAdScenario(String str, String str2, Map<String, Object> map) {
        t.b().a(str, str2, "2", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInView() {
        if (this.hasTouchWindow && isShown()) {
            return this.mCustomBannerAd == null || checkVisibilityPercent();
        }
        return false;
    }

    private boolean checkVisibilityPercent() {
        if (this.visibilityChecker == null) {
            this.visibilityChecker = new f.b(1);
        }
        if (getParent() != null) {
            return this.visibilityChecker.a((View) getParent(), this, 80, 0);
        }
        return false;
    }

    protected void controlShow() {
        if (this.mAdLoadManager == null) {
            return;
        }
        final boolean z = this.mIsRefresh;
        b.a().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ATBannerView.this.mAdLoadManager) {
                    if (ATBannerView.this.canRenderBanner) {
                        final com.anythink.core.common.h.c bannerCache = ATBannerView.this.getBannerCache();
                        boolean z2 = false;
                        if (bannerCache != null) {
                            if (ATBannerView.this.isInView()) {
                                bannerCache.a(bannerCache.c() + 1);
                                ATBannerView.this.canRenderBanner = false;
                                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.5.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        ATBannerView.this.renderBannerView(bannerCache, z);
                                    }
                                });
                            } else {
                                if (ATBannerView.this.hasTouchWindow && ATBannerView.this.isShown()) {
                                    z2 = true;
                                }
                                String unused = ATBannerView.this.TAG;
                            }
                        } else if (ATBannerView.this.isRefreshOpen() && ATBannerView.this.mAdLoadManager != null && !ATBannerView.this.mAdLoadManager.a()) {
                            ATBannerView aTBannerView = ATBannerView.this;
                            aTBannerView.loadAd(1, aTBannerView.mAdRequest);
                            if (ATBannerView.this.hasTouchWindow && ATBannerView.this.isShown()) {
                                z2 = true;
                            }
                        }
                        if (z2 && ATBannerView.this.mBannerRefreshTimer != null) {
                            ATBannerView.this.mBannerRefreshTimer.b();
                        }
                        return;
                    }
                    String unused2 = ATBannerView.this.TAG;
                }
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRefreshOpen() {
        com.anythink.core.d.l lVarA = n.a(getContext().getApplicationContext()).a(this.mPlacementId);
        return lVarA != null && lVarA.ao() == 1;
    }

    private boolean isShowToReload() {
        com.anythink.core.d.l lVarA = n.a(getContext().getApplicationContext()).a(this.mPlacementId);
        if (lVarA == null) {
            return false;
        }
        int iH = lVarA.h();
        if (-1 == iH) {
            return true;
        }
        return 1 == iH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBannerShow(final Context context, final com.anythink.core.common.h.c cVar, final boolean z) {
        final ATBaseAdAdapter aTBaseAdAdapterE = cVar.e();
        final com.anythink.core.common.h.n trackingInfo = aTBaseAdAdapterE.getTrackingInfo();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        b.a().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.6
            @Override // java.lang.Runnable
            public final void run() {
                if (trackingInfo != null) {
                    aj.a(ATBannerView.this.getContext(), trackingInfo);
                    com.anythink.core.common.a.a().a(context.getApplicationContext(), cVar);
                    com.anythink.core.common.u.c.a(context).a(13, trackingInfo, aTBaseAdAdapterE.getUnitGroupInfo(), jCurrentTimeMillis);
                    if (aTBaseAdAdapterE.supportImpressionCallback()) {
                        return;
                    }
                    ATBannerView.this.notifyBannerImpression(context, aTBaseAdAdapterE, z);
                }
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBannerImpression(final Context context, final ATBaseAdAdapter aTBaseAdAdapter, final boolean z) {
        final com.anythink.core.common.h.n trackingInfo = aTBaseAdAdapter.getTrackingInfo();
        b.a().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.7
            @Override // java.lang.Runnable
            public void run() {
                com.anythink.core.common.v.c.a().a(aTBaseAdAdapter);
                trackingInfo.a(aTBaseAdAdapter.getInternalNetworkInfoMap());
                ab.a(trackingInfo, j.r.c, j.r.m, "");
                com.anythink.core.common.u.c.a(context).a(4, trackingInfo, aTBaseAdAdapter.getUnitGroupInfo());
                t.b().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.7.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            l lVarA = l.a(aTBaseAdAdapter);
                            if (lVarA != null && lVarA.getNetworkFirmId() == -1) {
                                h.a(j.n.c, aTBaseAdAdapter, null);
                            }
                            if (ATBannerView.this.mRevenueListener != null) {
                                ATBannerView.this.mRevenueListener.onAdRevenuePaid(lVarA);
                            }
                            if (z) {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(lVarA);
                            } else {
                                ATBannerView.this.mListener.onBannerShow(lVarA);
                            }
                        }
                    }
                });
            }
        }, 2);
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        s sVarC;
        this.mDownloadListener = aTEventInterface;
        if (this.mCustomBannerAd == null || (sVarC = t.b().c()) == null) {
            return;
        }
        CustomBannerAdapter customBannerAdapter = this.mCustomBannerAd;
        customBannerAdapter.setAdDownloadListener(sVarC.createDataFetchListener(customBannerAdapter, null, this.mDownloadListener));
    }

    public void setAdSourceStatusListener(ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (this.mAdSourceEventListener == null) {
            this.mAdSourceEventListener = new com.anythink.core.common.d.c();
        }
        this.mDeveloperStatusListener = aTAdSourceStatusListener;
        this.mAdSourceEventListener.setAdSourceStatusListener(aTAdSourceStatusListener);
    }

    @Override // com.anythink.banner.a.c
    public void timeUpRefreshView() {
        this.isShowCall = true;
        this.canRenderBanner = true;
        if (!isShowToReload()) {
            loadAd(1, this.mAdRequest);
        } else {
            controlShow();
        }
    }

    public void destroy() {
        removeAllViews();
        CustomBannerAdapter customBannerAdapter = this.mCustomBannerAd;
        if (customBannerAdapter != null) {
            customBannerAdapter.internalDestory();
        }
        com.anythink.banner.b.a aVar = this.mBannerRefreshTimer;
        if (aVar != null) {
            aVar.c();
        }
        com.anythink.core.common.v.a.c cVar = this.impressionTracker;
        if (cVar != null) {
            cVar.a();
        }
        if (this.mAdLoadManager != null) {
            com.anythink.banner.a.a.a(this.mPlacementId);
        }
        com.anythink.core.common.l.e.a.c cVar2 = this.mLastShowBannerView;
        if (cVar2 instanceof com.anythink.core.common.l.e.a.d) {
            ((com.anythink.core.common.l.e.a.d) cVar2).destroyNativeAd();
            this.mLastShowBannerView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void renderBannerView(final com.anythink.core.common.h.c cVar, boolean z) {
        boolean z2;
        CustomBannerAdapter customBannerAdapter = (cVar == null || !(cVar.e() instanceof CustomBannerAdapter)) ? null : (CustomBannerAdapter) cVar.e();
        CustomBannerAdapter customBannerAdapter2 = this.mCustomBannerAd;
        if (customBannerAdapter2 == null || customBannerAdapter2.getUnitGroupInfo() == null) {
            z2 = false;
        } else {
            z2 = customBannerAdapter2.getUnitGroupInfo().g() == 11;
        }
        if (customBannerAdapter != null) {
            if (customBannerAdapter2 != null && !z2) {
                customBannerAdapter2.internalDestory();
            }
            com.anythink.core.common.l.e.a.c cVar2 = this.mLastShowBannerView;
            if (cVar2 instanceof com.anythink.core.common.l.e.a.d) {
                ((com.anythink.core.common.l.e.a.d) cVar2).destroyNativeAd();
                this.mLastShowBannerView = null;
            }
            View viewA = this.mAdLoadManager.a(getContext(), cVar, customBannerAdapter, new com.anythink.banner.a.b(this.mInnerBannerListener, customBannerAdapter, z), this.nativeAdCustomRender);
            if (viewA instanceof com.anythink.core.common.l.e.a.c) {
                this.mLastShowBannerView = (com.anythink.core.common.l.e.a.c) viewA;
            }
            if (viewA != 0 && viewA.getParent() != null && viewA.getParent() != this) {
                ((ViewGroup) viewA.getParent()).removeView(viewA);
            }
            this.mCustomBannerAd = customBannerAdapter;
            b.a().b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.8
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.core.common.a.a().a(cVar);
                }
            }, 2);
            if (viewA != 0) {
                com.anythink.core.common.h.n trackingInfo = this.mCustomBannerAd.getTrackingInfo();
                trackingInfo.F = this.mScenario;
                trackingInfo.z(this.mShowCustomExt);
                aj.a(this.mTKExtraMap, trackingInfo);
                aj.a(this.mPlacementId, trackingInfo);
                r.a(this.mATCustomContentResult, trackingInfo);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(trackingInfo.z())) {
                    trackingInfo.n(p.a(trackingInfo.aJ(), trackingInfo.M(), jCurrentTimeMillis));
                }
                if (!isInView()) {
                    registerDelayShow(viewA, getContext().getApplicationContext(), cVar, customBannerAdapter, z);
                } else {
                    notifyBannerShow(getContext().getApplicationContext(), cVar, z);
                }
                s sVarC = t.b().c();
                if (sVarC != null) {
                    customBannerAdapter.setAdDownloadListener(sVarC.createDataFetchListener(customBannerAdapter, null, this.mDownloadListener));
                }
                removeAllViews();
                int i = viewA.getLayoutParams() != null ? viewA.getLayoutParams().width : 0;
                if (i == 0) {
                    i = -2;
                }
                int i2 = viewA.getLayoutParams() != null ? viewA.getLayoutParams().height : 0;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2 > 0 ? i2 : -2);
                layoutParams.gravity = 17;
                viewA.setLayoutParams(layoutParams);
                if (viewA.getParent() instanceof ViewGroup) {
                    ((ViewGroup) viewA.getParent()).removeView(viewA);
                }
                addView(viewA, layoutParams);
            } else {
                Log.e(this.TAG, "Network's banner view = null. Did you call destroy()?");
            }
            this.mAdLoadManager.a(cVar);
            this.mBannerRefreshTimer.a(this.mCustomBannerAd);
            this.mBannerRefreshTimer.b();
            if (customBannerAdapter2 != null && z2) {
                customBannerAdapter2.internalDestory();
            }
            if (isRefreshOpen() && isShowToReload()) {
                loadAd(1, this.mAdRequest);
            }
        }
    }

    public void setNativeAdCustomRender(ATNativeAdCustomRender aTNativeAdCustomRender) {
        this.nativeAdCustomRender = aTNativeAdCustomRender;
    }
}
