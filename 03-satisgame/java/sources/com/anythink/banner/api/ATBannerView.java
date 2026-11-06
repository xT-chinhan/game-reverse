package com.anythink.banner.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.banner.a.b;
import com.anythink.banner.a.c;
import com.anythink.banner.a.d;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdCreateConfig;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATCustomContentResult;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.ATRequestingInfo;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.k;
import com.anythink.core.common.d.r;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.t.g;
import com.anythink.core.common.u.a.f;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.b.e;
import com.anythink.core.common.u.o;
import com.anythink.core.common.u.q;
import com.anythink.core.e.l;
import com.anythink.core.e.n;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ATBannerView extends FrameLayout implements c {
    private static final long CONTROL_SHOW_DEBOUNCE_MS = 100;
    private final String TAG;
    com.anythink.core.common.d.a adLoadListener;
    public ATAdMultipleLoadedListener adMultipleLoadedListener;
    private ATAdxBidFloorInfo adxBidFloorInfo;
    private boolean canRenderBanner;
    boolean hasTouchWindow;
    com.anythink.core.common.u.a.c impressionTracker;
    private volatile boolean isControlShowing;
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
    private volatile long mLastControlShowTime;
    private com.anythink.core.common.k.e.a.c mLastShowBannerView;
    private ATBannerListener mListener;
    private ATAdMultipleLoadedListener mMultipleLoadedListener;
    private String mPlacementId;
    private ATAdRevenueListener mRevenueListener;
    private String mScenario;
    private String mShowCustomExt;
    Map<String, Object> mTKExtraMap;
    private ATNativeAdCustomRender nativeAdCustomRender;
    f.b visibilityChecker;

    private boolean isLifecycleShowType(int i) {
        return i == 2 || i == 3 || i == 4;
    }

    public ATBannerView(Context context) {
        super(context);
        this.TAG = "ATBannerView";
        this.mScenario = "";
        this.mShowCustomExt = "";
        this.hasTouchWindow = false;
        this.mIsRefresh = false;
        this.isControlShowing = false;
        this.mLastControlShowTime = 0L;
        this.mInnerBannerListener = new d() { // from class: com.anythink.banner.api.ATBannerView.1
            @Override // com.anythink.banner.a.d
            public void onBannerClicked(final CustomBannerAdapter customBannerAdapter) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClicked(k.a(customBannerAdapter));
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onBannerShow(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        k kVarA = k.a(customBannerAdapter);
                        if (ATBannerView.this.mRevenueListener != null) {
                            ATBannerView.this.mRevenueListener.onAdRevenuePaid(kVarA);
                        }
                        if (ATBannerView.this.mListener != null) {
                            if (customBannerAdapter == null || !z) {
                                ATBannerView.this.mListener.onBannerShow(kVarA);
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(kVarA);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onBannerClose(final CustomBannerAdapter customBannerAdapter) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClose(k.a(customBannerAdapter));
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
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDeeplinkCallback(ATBannerView.this.mIsRefresh, k.a(customBannerAdapter), z);
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onDownloadConfirm(final Context context2, final CustomBannerAdapter customBannerAdapter, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDownloadConfirm(context2, k.a(customBannerAdapter), aTNetworkConfirmInfo);
                    }
                });
            }
        };
        this.adLoadListener = new com.anythink.core.common.d.a() { // from class: com.anythink.banner.api.ATBannerView.2
            @Override // com.anythink.core.common.d.a
            public void onAdLoaded() {
                ATBannerView.this.isShowCall = true;
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            s.b();
                            com.anythink.core.common.u.c.a();
                            com.anythink.core.common.u.c.a(ATBannerView.this.getBannerCache(false));
                        } catch (Throwable unused) {
                        }
                        if (ATBannerView.this.mListener != null && !ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerLoaded();
                        }
                        ATBannerView.this.controlShow(0);
                    }
                });
            }

            @Override // com.anythink.core.common.d.a
            public void onAdLoadFail(final AdError adError) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.2
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
                ATBannerView.this.mBannerRefreshTimer.b();
            }
        };
        this.adMultipleLoadedListener = new ATAdMultipleLoadedListener() { // from class: com.anythink.banner.api.ATBannerView.3
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.3.1
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
        this.isControlShowing = false;
        this.mLastControlShowTime = 0L;
        this.mInnerBannerListener = new d() { // from class: com.anythink.banner.api.ATBannerView.1
            @Override // com.anythink.banner.a.d
            public void onBannerClicked(final CustomBannerAdapter customBannerAdapter) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClicked(k.a(customBannerAdapter));
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onBannerShow(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        k kVarA = k.a(customBannerAdapter);
                        if (ATBannerView.this.mRevenueListener != null) {
                            ATBannerView.this.mRevenueListener.onAdRevenuePaid(kVarA);
                        }
                        if (ATBannerView.this.mListener != null) {
                            if (customBannerAdapter == null || !z) {
                                ATBannerView.this.mListener.onBannerShow(kVarA);
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(kVarA);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onBannerClose(final CustomBannerAdapter customBannerAdapter) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClose(k.a(customBannerAdapter));
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
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDeeplinkCallback(ATBannerView.this.mIsRefresh, k.a(customBannerAdapter), z);
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onDownloadConfirm(final Context context2, final CustomBannerAdapter customBannerAdapter, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDownloadConfirm(context2, k.a(customBannerAdapter), aTNetworkConfirmInfo);
                    }
                });
            }
        };
        this.adLoadListener = new com.anythink.core.common.d.a() { // from class: com.anythink.banner.api.ATBannerView.2
            @Override // com.anythink.core.common.d.a
            public void onAdLoaded() {
                ATBannerView.this.isShowCall = true;
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            s.b();
                            com.anythink.core.common.u.c.a();
                            com.anythink.core.common.u.c.a(ATBannerView.this.getBannerCache(false));
                        } catch (Throwable unused) {
                        }
                        if (ATBannerView.this.mListener != null && !ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerLoaded();
                        }
                        ATBannerView.this.controlShow(0);
                    }
                });
            }

            @Override // com.anythink.core.common.d.a
            public void onAdLoadFail(final AdError adError) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.2
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
                ATBannerView.this.mBannerRefreshTimer.b();
            }
        };
        this.adMultipleLoadedListener = new ATAdMultipleLoadedListener() { // from class: com.anythink.banner.api.ATBannerView.3
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.3.1
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
        this.isControlShowing = false;
        this.mLastControlShowTime = 0L;
        this.mInnerBannerListener = new d() { // from class: com.anythink.banner.api.ATBannerView.1
            @Override // com.anythink.banner.a.d
            public void onBannerClicked(final CustomBannerAdapter customBannerAdapter) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClicked(k.a(customBannerAdapter));
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onBannerShow(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        k kVarA = k.a(customBannerAdapter);
                        if (ATBannerView.this.mRevenueListener != null) {
                            ATBannerView.this.mRevenueListener.onAdRevenuePaid(kVarA);
                        }
                        if (ATBannerView.this.mListener != null) {
                            if (customBannerAdapter == null || !z) {
                                ATBannerView.this.mListener.onBannerShow(kVarA);
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(kVarA);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onBannerClose(final CustomBannerAdapter customBannerAdapter) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClose(k.a(customBannerAdapter));
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
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDeeplinkCallback(ATBannerView.this.mIsRefresh, k.a(customBannerAdapter), z);
                    }
                });
            }

            @Override // com.anythink.banner.a.d
            public void onDownloadConfirm(final Context context2, final CustomBannerAdapter customBannerAdapter, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDownloadConfirm(context2, k.a(customBannerAdapter), aTNetworkConfirmInfo);
                    }
                });
            }
        };
        this.adLoadListener = new com.anythink.core.common.d.a() { // from class: com.anythink.banner.api.ATBannerView.2
            @Override // com.anythink.core.common.d.a
            public void onAdLoaded() {
                ATBannerView.this.isShowCall = true;
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            s.b();
                            com.anythink.core.common.u.c.a();
                            com.anythink.core.common.u.c.a(ATBannerView.this.getBannerCache(false));
                        } catch (Throwable unused) {
                        }
                        if (ATBannerView.this.mListener != null && !ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerLoaded();
                        }
                        ATBannerView.this.controlShow(0);
                    }
                });
            }

            @Override // com.anythink.core.common.d.a
            public void onAdLoadFail(final AdError adError) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.2
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
                ATBannerView.this.mBannerRefreshTimer.b();
            }
        };
        this.adMultipleLoadedListener = new ATAdMultipleLoadedListener() { // from class: com.anythink.banner.api.ATBannerView.3
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.3.1
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
        setPlacementId(str, null);
    }

    public void setPlacementId(String str, ATAdCreateConfig aTAdCreateConfig) {
        this.mPlacementId = str;
        this.mBannerRefreshTimer.a(str);
        if (this.impressionTracker == null) {
            getContext();
            this.impressionTracker = new com.anythink.core.common.u.a.c();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mAdLoadManager = new com.anythink.banner.a.a(getContext(), str, aTAdCreateConfig);
    }

    @Deprecated
    public void setScenario(String str) {
        setShowConfig(o.e(str));
    }

    public void setShowConfig(ATShowConfig aTShowConfig) {
        if (aTShowConfig != null) {
            this.mScenario = aTShowConfig.getScenarioId();
            this.mShowCustomExt = aTShowConfig.getShowCustomExt();
            this.mATCustomContentResult = aTShowConfig.getATCustomContentResult();
        }
    }

    public ATAdStatusInfo checkAdStatus() {
        if (s.b().g() == null || TextUtils.isEmpty(s.b().p()) || TextUtils.isEmpty(s.b().q())) {
            Log.e(this.TAG, "SDK init error!");
            return new ATAdStatusInfo(false, false, null);
        }
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar == null) {
            Log.e(this.TAG, "PlacementId is empty!");
            return new ATAdStatusInfo(false, false, null);
        }
        ATAdStatusInfo aTAdStatusInfoA = aVar.a(getContext(), this.mTKExtraMap);
        aa.b(this.mPlacementId, i.s.p, i.s.C, aTAdStatusInfoA.toString(), "");
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
            return;
        }
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.b(map);
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
        String str = this.mPlacementId;
        String str2 = i.s.p;
        String str3 = i.s.y;
        String str4 = i.s.o;
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        aa.a(str, str2, str3, str4, "", aVar != null ? aVar.b() : null);
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
        com.anythink.banner.a.a aVar2 = this.mAdLoadManager;
        if (aVar2 != null) {
            aVar2.a(getContext(), i, this.adLoadListener, this.mAdSourceEventListener, this.adMultipleLoadedListener, this.mTKExtraMap, aTAdRequest2);
            return;
        }
        com.anythink.core.common.d.a aVar3 = this.adLoadListener;
        if (aVar3 != null) {
            aVar3.onAdLoadFail(ErrorCode.getErrorCode(ErrorCode.exception, "", "placementId maybe is null"));
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
    public com.anythink.core.common.h.c getBannerCache(boolean z) {
        ae cacheCheckInfo = getCacheCheckInfo(this.mTKExtraMap);
        cacheCheckInfo.f();
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            return aVar.a(getContext(), z, cacheCheckInfo);
        }
        return null;
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
        CustomBannerAdapter customBannerAdapter = this.mCustomBannerAd;
        if (customBannerAdapter != null) {
            clearAdClickRecord(customBannerAdapter.getTrackingInfo());
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            controlShow(3);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            controlShow(4);
        }
    }

    private void registerDelayShow(View view, final Context context, final com.anythink.core.common.h.c cVar, CustomBannerAdapter customBannerAdapter, final boolean z) {
        if (view == null) {
            view = this;
        }
        com.anythink.core.common.u.a.c cVar2 = this.impressionTracker;
        if (cVar2 != null) {
            cVar2.a(view, new com.anythink.core.common.u.a.a() { // from class: com.anythink.banner.api.ATBannerView.4
                @Override // com.anythink.core.common.u.a.a, com.anythink.core.common.u.a.b
                public final int getImpressionMinPercentageViewed() {
                    return 50;
                }

                @Override // com.anythink.core.common.u.a.a, com.anythink.core.common.u.a.b
                public final int getImpressionMinTimeViewed() {
                    return 0;
                }

                @Override // com.anythink.core.common.u.a.a, com.anythink.core.common.u.a.b
                public final void recordImpression(View view2) {
                    ATBannerView.this.notifyBannerShow(context, cVar, z);
                }
            });
        }
    }

    public void entryAdScenario(String str) {
        if (this.mAdLoadManager != null) {
            s.b().a(this.mAdLoadManager.b(), str, "2", (Map<String, Object>) null);
        }
    }

    public void entryAdScenario(String str, Map<String, Object> map) {
        if (this.mAdLoadManager != null) {
            s.b().a(this.mAdLoadManager.b(), str, "2", map);
        }
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

    protected void controlShow(int i) {
        if (this.mAdLoadManager == null || this.isControlShowing) {
            return;
        }
        if (isLifecycleShowType(i)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.mLastControlShowTime < CONTROL_SHOW_DEBOUNCE_MS) {
                return;
            } else {
                this.mLastControlShowTime = jCurrentTimeMillis;
            }
        }
        final boolean z = this.mIsRefresh;
        this.isControlShowing = true;
        com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(e.Z, new Runnable() { // from class: com.anythink.banner.api.ATBannerView.5
            @Override // java.lang.Runnable
            public void run() {
                final com.anythink.core.common.h.c bannerCache;
                boolean z2;
                boolean z3;
                boolean z4;
                try {
                    synchronized (ATBannerView.this.mAdLoadManager) {
                        if (ATBannerView.this.canRenderBanner) {
                            ATBannerView aTBannerView = ATBannerView.this;
                            bannerCache = aTBannerView.getBannerCache(aTBannerView.isShowCall);
                            ATBannerView.this.isShowCall = false;
                            if (bannerCache != null) {
                                if (ATBannerView.this.isInView()) {
                                    bannerCache.a(bannerCache.c() + 1);
                                    ATBannerView.this.canRenderBanner = false;
                                    z2 = false;
                                    z4 = false;
                                    z3 = true;
                                } else if (ATBannerView.this.hasTouchWindow && ATBannerView.this.isShown()) {
                                    z3 = false;
                                    z2 = false;
                                    z4 = true;
                                }
                            } else {
                                if (ATBannerView.this.isRefreshOpen() && ATBannerView.this.mAdLoadManager != null && !ATBannerView.this.mAdLoadManager.c()) {
                                    if (ATBannerView.this.hasTouchWindow && ATBannerView.this.isShown()) {
                                        z3 = false;
                                        z2 = true;
                                    } else {
                                        z3 = false;
                                        z4 = false;
                                        z2 = true;
                                    }
                                }
                                z4 = z2;
                            }
                        } else {
                            bannerCache = null;
                        }
                        z3 = false;
                        z2 = false;
                        z4 = z2;
                    }
                    if (z3 && bannerCache != null) {
                        s.b();
                        s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.5.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ATBannerView.this.renderBannerView(bannerCache, z);
                            }
                        });
                    }
                    if (z2) {
                        ATBannerView aTBannerView2 = ATBannerView.this;
                        aTBannerView2.loadAd(1, aTBannerView2.mAdRequest);
                    }
                    if (z4 && ATBannerView.this.mBannerRefreshTimer != null) {
                        ATBannerView.this.mBannerRefreshTimer.b();
                    }
                    ATBannerView.this.isControlShowing = false;
                } catch (Throwable th) {
                    ATBannerView.this.isControlShowing = false;
                    throw th;
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRefreshOpen() {
        if (TextUtils.isEmpty(this.mPlacementId)) {
            Log.e(this.TAG, "You must set unit Id first.");
            return false;
        }
        l lVarA = n.a(getContext().getApplicationContext()).a(this.mPlacementId);
        return lVarA != null && lVarA.an() == 1;
    }

    private boolean isShowToReload() {
        if (TextUtils.isEmpty(this.mPlacementId)) {
            Log.e(this.TAG, "You must set unit Id first.");
            return false;
        }
        l lVarA = n.a(getContext().getApplicationContext()).a(this.mPlacementId);
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
        com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(e.ac, new Runnable() { // from class: com.anythink.banner.api.ATBannerView.6
            @Override // java.lang.Runnable
            public final void run() {
                if (trackingInfo != null) {
                    ai.a(ATBannerView.this.getContext(), trackingInfo);
                    com.anythink.core.common.f fVarA = trackingInfo.a();
                    if (fVarA != null && fVarA.e() != null) {
                        fVarA.e().a(context.getApplicationContext(), cVar);
                    }
                    com.anythink.core.common.t.e.a(context);
                    com.anythink.core.common.t.e.a(13, trackingInfo, aTBaseAdAdapterE.getUnitGroupInfo(), jCurrentTimeMillis);
                    if (aTBaseAdAdapterE.supportImpressionCallback()) {
                        return;
                    }
                    ATBannerView.this.notifyBannerImpression(context, aTBaseAdAdapterE, z);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBannerImpression(final Context context, final ATBaseAdAdapter aTBaseAdAdapter, final boolean z) {
        final com.anythink.core.common.h.n trackingInfo = aTBaseAdAdapter.getTrackingInfo();
        com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(e.ab, new Runnable() { // from class: com.anythink.banner.api.ATBannerView.7
            @Override // java.lang.Runnable
            public void run() {
                com.anythink.core.common.u.c.a().a(aTBaseAdAdapter);
                trackingInfo.a(aTBaseAdAdapter.getInternalNetworkInfoMap());
                aa.a(trackingInfo, i.s.c, i.s.m, "");
                ai.b(trackingInfo, aTBaseAdAdapter);
                com.anythink.core.common.t.e.a(context);
                com.anythink.core.common.t.e.a(4, trackingInfo, aTBaseAdAdapter.getUnitGroupInfo());
                s.b();
                s.b(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.7.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            k kVarA = k.a(aTBaseAdAdapter);
                            if (kVarA != null && kVarA.getNetworkFirmId() == -1) {
                                g.a(i.o.c, aTBaseAdAdapter, null);
                            }
                            if (ATBannerView.this.mRevenueListener != null) {
                                ATBannerView.this.mRevenueListener.onAdRevenuePaid(kVarA);
                            }
                            if (z) {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(kVarA);
                            } else {
                                ATBannerView.this.mListener.onBannerShow(kVarA);
                            }
                        }
                    }
                });
            }
        }));
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        r rVarC;
        this.mDownloadListener = aTEventInterface;
        if (this.mCustomBannerAd == null || (rVarC = s.b().c()) == null) {
            return;
        }
        CustomBannerAdapter customBannerAdapter = this.mCustomBannerAd;
        customBannerAdapter.setAdDownloadListener(rVarC.createDataFetchListener(customBannerAdapter, null, this.mDownloadListener));
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
            controlShow(1);
        }
    }

    public void destroy() {
        removeAllViews();
        this.isControlShowing = false;
        CustomBannerAdapter customBannerAdapter = this.mCustomBannerAd;
        if (customBannerAdapter != null) {
            clearAdClickRecord(customBannerAdapter.getTrackingInfo());
            this.mCustomBannerAd.internalDestroy();
        }
        com.anythink.banner.b.a aVar = this.mBannerRefreshTimer;
        if (aVar != null) {
            aVar.c();
        }
        com.anythink.core.common.u.a.c cVar = this.impressionTracker;
        if (cVar != null) {
            cVar.a();
        }
        com.anythink.banner.a.a aVar2 = this.mAdLoadManager;
        if (aVar2 != null) {
            aVar2.d();
            com.anythink.banner.a.a.a(this.mPlacementId);
        }
        com.anythink.core.common.k.e.a.c cVar2 = this.mLastShowBannerView;
        if (cVar2 instanceof com.anythink.core.common.k.e.a.d) {
            ((com.anythink.core.common.k.e.a.d) cVar2).destroyNativeAd();
            this.mLastShowBannerView = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        CustomBannerAdapter customBannerAdapter = this.mCustomBannerAd;
        if (customBannerAdapter != null) {
            com.anythink.core.common.t.a.a(getContext(), motionEvent, customBannerAdapter.getTrackingInfo());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void clearAdClickRecord(com.anythink.core.common.h.n nVar) {
        com.anythink.core.common.u.c.a().b().d(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0012  */
    /* JADX WARN: Multi-variable type inference failed */
    public void renderBannerView(final com.anythink.core.common.h.c cVar, boolean z) {
        CustomBannerAdapter customBannerAdapter;
        boolean z2;
        if (cVar != null) {
            try {
                if (cVar.e() instanceof CustomBannerAdapter) {
                    customBannerAdapter = (CustomBannerAdapter) cVar.e();
                } else {
                    customBannerAdapter = null;
                }
            } catch (Throwable unused) {
                return;
            }
        } else {
            customBannerAdapter = null;
        }
        CustomBannerAdapter customBannerAdapter2 = this.mCustomBannerAd;
        if (customBannerAdapter2 == null || customBannerAdapter2.getUnitGroupInfo() == null) {
            z2 = false;
        } else {
            z2 = customBannerAdapter2.getUnitGroupInfo().n() == 11;
        }
        if (customBannerAdapter2 != null) {
            clearAdClickRecord(customBannerAdapter2.getTrackingInfo());
        }
        if (customBannerAdapter == null || this.mAdLoadManager == null) {
            return;
        }
        if (customBannerAdapter2 != null && !z2) {
            customBannerAdapter2.internalDestroy();
        }
        com.anythink.core.common.k.e.a.c cVar2 = this.mLastShowBannerView;
        if (cVar2 instanceof com.anythink.core.common.k.e.a.d) {
            ((com.anythink.core.common.k.e.a.d) cVar2).destroyNativeAd();
            this.mLastShowBannerView = null;
        }
        View viewA = this.mAdLoadManager.a(getContext(), cVar, customBannerAdapter, new b(this.mInnerBannerListener, customBannerAdapter, z), this.nativeAdCustomRender);
        if (viewA instanceof com.anythink.core.common.k.e.a.c) {
            this.mLastShowBannerView = (com.anythink.core.common.k.e.a.c) viewA;
        }
        if (viewA != 0 && viewA.getParent() != null && viewA.getParent() != this) {
            ((ViewGroup) viewA.getParent()).removeView(viewA);
        }
        this.mCustomBannerAd = customBannerAdapter;
        if (viewA != 0) {
            com.anythink.core.common.h.n trackingInfo = customBannerAdapter.getTrackingInfo();
            ai.a(this.mAdRequest, trackingInfo);
            final com.anythink.core.common.f fVarA = trackingInfo.a();
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(e.aa, new Runnable() { // from class: com.anythink.banner.api.ATBannerView.8
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.core.common.f fVar = fVarA;
                    if (fVar == null || fVar.e() == null) {
                        return;
                    }
                    fVarA.e().a(cVar, 5);
                }
            }));
            if (fVarA != null) {
                trackingInfo.z = fVarA.m();
            }
            trackingInfo.H = this.mScenario;
            trackingInfo.y(this.mShowCustomExt);
            ai.a(this.mTKExtraMap, trackingInfo);
            ai.a(this.mPlacementId, trackingInfo);
            q.a(this.mATCustomContentResult, trackingInfo);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (TextUtils.isEmpty(trackingInfo.A())) {
                trackingInfo.n(o.a(trackingInfo.aR(), trackingInfo.N(), jCurrentTimeMillis));
            }
            if (!isInView()) {
                registerDelayShow(viewA, getContext().getApplicationContext(), cVar, customBannerAdapter, z);
            } else {
                notifyBannerShow(getContext().getApplicationContext(), cVar, z);
            }
            r rVarC = s.b().c();
            if (rVarC != null) {
                customBannerAdapter.setAdDownloadListener(rVarC.createDataFetchListener(customBannerAdapter, null, this.mDownloadListener));
            }
            removeAllViews();
            int i = viewA.getLayoutParams() != null ? viewA.getLayoutParams().width : 0;
            int i2 = -2;
            if (i == 0) {
                i = -2;
            }
            int i3 = viewA.getLayoutParams() != null ? viewA.getLayoutParams().height : 0;
            if (i3 > 0) {
                i2 = i3;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
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
            customBannerAdapter2.internalDestroy();
        }
        if (isRefreshOpen() && isShowToReload()) {
            loadAd(1, this.mAdRequest);
        }
    }

    public void setNativeAdCustomRender(ATNativeAdCustomRender aTNativeAdCustomRender) {
        this.nativeAdCustomRender = aTNativeAdCustomRender;
    }

    private static class a {
        static final int AD_LOADED = 0;
        static final int AUTO_REFRESH = 1;
        static final int ON_ATTACH_TO_WINDOW = 2;
        static final int ON_VISIBILITY_CHANGED = 3;
        static final int ON_WINDOW_FOCUS_CHANGED = 4;

        private a() {
        }
    }

    public void clearCache(int i) {
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void clearCache(List<ATAdInfo> list) {
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.a(list);
        }
    }

    public void sendEvent(Map<String, Object> map) {
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.a(map);
        }
    }

    public boolean isMultiton() {
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        return aVar != null && aVar.a();
    }
}
