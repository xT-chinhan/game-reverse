package com.tapsdk.tapad.lib_gdtadapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterAppComplianceInfo;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedBinding;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession;
import com.tapsdk.tapad.group.adapter.AdapterNativeImage;
import com.tapsdk.tapad.lib_gdtadapter.utils.Utils;
import com.umeng.analytics.pro.an;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class TapGDTNativeFeedSession implements AdapterNativeFeedSession {
    private static final String DOWNLOAD_FLOW_TAG = "UP7723DownloadFlow";
    private static final long NORMAL_CLICK_DOWNLOAD_SUPPRESS_MS = 3000;
    private static final long PAUSED_CREATIVE_RESUME_MS = 1200;
    private static final long PENDING_NORMAL_CLICK_CONFIRM_MS = 120000;
    private final int acceptedHeight;
    private final int acceptedWidth;
    private NativeUnifiedADData adData;
    private final WeakReference<Context> context;
    volatile MediaView mediaView;
    private volatile DownloadDecision pendingDownloadDecision;
    Timer progressTimer;
    TimerTask progressTimerTask;
    private static final String[] STOP_DOWNLOAD_METHODS = {"cancelAppDownload", "cancelDownload", "stopAppDownload", "pauseAppDownload"};
    private static final String[] RESUME_DOWNLOAD_METHODS = {"resumeAppDownload"};
    private static final String[] PAUSE_DOWNLOAD_METHODS = {"pauseAppDownload"};
    private AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;
    private final AtomicBoolean released = new AtomicBoolean(false);
    final AtomicBoolean haveDownloading = new AtomicBoolean(false);
    final AtomicLong normalClickDownloadSuppressUntil = new AtomicLong(0);
    final AtomicBoolean normalClickWasDownloading = new AtomicBoolean(false);
    final AtomicBoolean normalClickSuppressHandled = new AtomicBoolean(false);
    final AtomicLong pausedCreativeResumeUntil = new AtomicLong(0);
    long curBytes = 0;

    private interface DownloadDecision {
        void onDownloadCancel();

        void onDownloadConfirm();
    }

    public TapGDTNativeFeedSession(NativeUnifiedADData adData, int acceptedWidth, int acceptedHeight, Context context) {
        this.adData = adData;
        this.acceptedWidth = acceptedWidth;
        this.acceptedHeight = acceptedHeight;
        this.context = new WeakReference<>(context);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        return nativeUnifiedADData == null ? Collections.emptyMap() : AdapterAdMetadata.fromProvider(nativeUnifiedADData.getExtraInfo());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getIconUrl() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        return nativeUnifiedADData == null ? "" : nativeUnifiedADData.getIconUrl();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public float getScore() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        if (nativeUnifiedADData == null) {
            return 0.0f;
        }
        return nativeUnifiedADData.getAppScore();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public List<AdapterNativeImage> getImages() {
        try {
            return Collections.singletonList(new AdapterNativeImage(this.adData.getImgUrl(), this.adData.getPictureWidth(), this.adData.getPictureHeight()));
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getTitle() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        return nativeUnifiedADData == null ? "" : nativeUnifiedADData.getTitle();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getDescription() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        return nativeUnifiedADData == null ? "" : nativeUnifiedADData.getDesc();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getApkSize() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getAppMiitInfo() == null) {
            return "0";
        }
        return this.adData.getAppMiitInfo().getPackageSizeBytes() + "";
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public long getApkSizeBytes() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getAppMiitInfo() == null) {
            return 0L;
        }
        return this.adData.getAppMiitInfo().getPackageSizeBytes();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public int getInteractionType() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        return (nativeUnifiedADData == null || !nativeUnifiedADData.isAppAd()) ? 0 : 1;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public int getImageMode() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        return (nativeUnifiedADData == null || nativeUnifiedADData.getAdPatternType() != 2) ? 1 : 2;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public AdapterAppComplianceInfo getComplianceInfo() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        NativeUnifiedADAppMiitInfo info = nativeUnifiedADData == null ? null : nativeUnifiedADData.getAppMiitInfo();
        if (info == null) {
            return AdapterAppComplianceInfo.EMPTY;
        }
        return new AdapterAppComplianceInfo(info.getAppName(), info.getVersionName(), info.getAuthorName(), info.getPrivacyAgreement(), info.getDescriptionUrl(), info.getPermissionsUrl(), "");
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public void bind(Activity activity, AdapterNativeFeedBinding binding) {
        NativeUnifiedADData boundAdData = this.adData;
        if (boundAdData == null) {
            throw new IllegalStateException("gdt native ad is null");
        }
        FrameLayout adContainer = binding.getContainer();
        List<View> clickViews = binding.getClickViews();
        List<View> creativeViews = binding.getCreativeViews();
        final ArrayList<View> newClicks = new ArrayList<>();
        final ArrayList<View> newCreatives = new ArrayList<>();
        final NativeAdContainer nativeAdContainer = new NativeAdContainer(activity) { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.1
            @Override // com.qq.e.ads.nativ.widget.NativeAdContainer, android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent event) {
                try {
                    int action = event.getActionMasked();
                    if (action == 0 || action == 1) {
                        boolean fromCreativeView = TapGDTNativeFeedSession.this.isTouchInList(event.getRawX(), event.getRawY(), newCreatives);
                        boolean fromNormalClickView = !fromCreativeView && TapGDTNativeFeedSession.this.isTouchInList(event.getRawX(), event.getRawY(), newClicks);
                        if (fromCreativeView) {
                            TapGDTNativeFeedSession.this.normalClickDownloadSuppressUntil.set(0L);
                            if (TapGDTNativeFeedSession.this.isCreativeDownloadControlStatus()) {
                                if (action == 0) {
                                    TapGDTNativeFeedSession.this.pausedCreativeResumeUntil.set(SystemClock.uptimeMillis() + TapGDTNativeFeedSession.PAUSED_CREATIVE_RESUME_MS);
                                    TapGDTNativeFeedSession.this.logDownloadFlow("creative download control touch down intercepted, status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog());
                                    return true;
                                }
                                if (action == 1) {
                                    TapGDTNativeFeedSession tapGDTNativeFeedSession = TapGDTNativeFeedSession.this;
                                    if (tapGDTNativeFeedSession.isPausedCreativeResumePending(tapGDTNativeFeedSession.pausedCreativeResumeUntil)) {
                                        TapGDTNativeFeedSession.this.pausedCreativeResumeUntil.set(0L);
                                        TapGDTNativeFeedSession.this.logDownloadFlow("creative download control touch up -> emit host control confirm, status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog());
                                        TapGDTNativeFeedSession.this.emitCreativeDownloadControlConfirm();
                                        return true;
                                    }
                                }
                            }
                        } else if (fromNormalClickView) {
                            TapGDTNativeFeedSession tapGDTNativeFeedSession2 = TapGDTNativeFeedSession.this;
                            tapGDTNativeFeedSession2.markNormalClickDownloadSuppress(tapGDTNativeFeedSession2.normalClickDownloadSuppressUntil, TapGDTNativeFeedSession.this.normalClickWasDownloading);
                        }
                    } else {
                        if (action == 3) {
                            TapGDTNativeFeedSession.this.normalClickDownloadSuppressUntil.set(0L);
                            TapGDTNativeFeedSession.this.pausedCreativeResumeUntil.set(0L);
                        }
                        return super.dispatchTouchEvent(event);
                    }
                } catch (Throwable th) {
                    TapGDTNativeFeedSession.this.normalClickDownloadSuppressUntil.set(0L);
                    TapGDTNativeFeedSession.this.pausedCreativeResumeUntil.set(0L);
                }
                return super.dispatchTouchEvent(event);
            }
        };
        binding.installProviderContainer(nativeAdContainer);
        for (View view : clickViews) {
            if (view != adContainer) {
                newClicks.add(view);
            } else {
                newClicks.add(nativeAdContainer);
            }
        }
        for (View view2 : creativeViews) {
            if (view2 != adContainer) {
                newCreatives.add(view2);
            } else {
                newCreatives.add(nativeAdContainer);
            }
        }
        boundAdData.bindAdToView(activity, nativeAdContainer, binding.getLogoLayoutParams(), newCreatives, newClicks);
        boundAdData.setNativeAdEventListener(new NativeADEventListenerWithClickInfo(boundAdData, adContainer, newCreatives, newClicks, nativeAdContainer) { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.2
            final long apkSize;
            final String appName;
            final /* synthetic */ FrameLayout val$adContainer;
            final /* synthetic */ NativeUnifiedADData val$boundAdData;
            final /* synthetic */ NativeAdContainer val$nativeAdContainer;
            final /* synthetic */ ArrayList val$newClicks;
            final /* synthetic */ ArrayList val$newCreatives;

            {
                this.val$boundAdData = boundAdData;
                this.val$adContainer = adContainer;
                this.val$newCreatives = newCreatives;
                this.val$newClicks = newClicks;
                this.val$nativeAdContainer = nativeAdContainer;
                this.appName = TapGDTNativeFeedSession.this.getComplianceInfo().getAppName();
                this.apkSize = boundAdData.getAppMiitInfo() == null ? 0L : boundAdData.getAppMiitInfo().getPackageSizeBytes();
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                if (!TapGDTNativeFeedSession.this.released.get()) {
                    TapGDTNativeFeedSession.this.eventSink.onShow(this.val$adContainer);
                }
            }

            /* JADX WARN: Code duplicated, block: B:18:0x0080 A[Catch: all -> 0x008c, TRY_LEAVE, TryCatch #0 {all -> 0x008c, blocks: (B:6:0x000f, B:8:0x0019, B:12:0x0026, B:14:0x006c, B:16:0x0076, B:18:0x0080), top: B:24:0x000f }] */
            @Override // com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo
            public void onADClicked(View view3) {
                if (!TapGDTNativeFeedSession.this.released.get()) {
                    try {
                        boolean fromCreativeView = TapGDTNativeFeedSession.this.isViewInList(view3, this.val$newCreatives);
                        boolean fromNormalClickView = !fromCreativeView && TapGDTNativeFeedSession.this.isViewInList(view3, this.val$newClicks);
                        TapGDTNativeFeedSession tapGDTNativeFeedSession = TapGDTNativeFeedSession.this;
                        StringBuilder sbAppend = new StringBuilder().append("onADClicked fromCreative=").append(fromCreativeView).append(", fromNormal=").append(fromNormalClickView).append(", suppressing=");
                        TapGDTNativeFeedSession tapGDTNativeFeedSession2 = TapGDTNativeFeedSession.this;
                        tapGDTNativeFeedSession.logDownloadFlow(sbAppend.append(tapGDTNativeFeedSession2.isNormalClickDownloadSuppressing(tapGDTNativeFeedSession2.normalClickDownloadSuppressUntil)).append(", status=").append(TapGDTNativeFeedSession.this.getCurrentAppStatusForLog()).toString());
                        if (fromCreativeView) {
                            TapGDTNativeFeedSession.this.normalClickDownloadSuppressUntil.set(0L);
                        } else if (!fromNormalClickView) {
                            TapGDTNativeFeedSession tapGDTNativeFeedSession3 = TapGDTNativeFeedSession.this;
                            if (tapGDTNativeFeedSession3.isNormalClickDownloadSuppressing(tapGDTNativeFeedSession3.normalClickDownloadSuppressUntil)) {
                                TapGDTNativeFeedSession tapGDTNativeFeedSession4 = TapGDTNativeFeedSession.this;
                                tapGDTNativeFeedSession4.markNormalClickDownloadSuppress(tapGDTNativeFeedSession4.normalClickDownloadSuppressUntil, TapGDTNativeFeedSession.this.normalClickWasDownloading);
                            }
                        } else {
                            TapGDTNativeFeedSession tapGDTNativeFeedSession5 = TapGDTNativeFeedSession.this;
                            tapGDTNativeFeedSession5.markNormalClickDownloadSuppress(tapGDTNativeFeedSession5.normalClickDownloadSuppressUntil, TapGDTNativeFeedSession.this.normalClickWasDownloading);
                        }
                    } catch (Throwable th) {
                        TapGDTNativeFeedSession.this.normalClickDownloadSuppressUntil.set(0L);
                    }
                    TapGDTNativeFeedSession.this.eventSink.onClick(null);
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                if (!TapGDTNativeFeedSession.this.released.get()) {
                    TapGDTNativeFeedSession.this.eventSink.onRenderFailure(null, adError.getErrorCode(), adError.getErrorMsg());
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
                if (TapGDTNativeFeedSession.this.released.get()) {
                    return;
                }
                int status = this.val$boundAdData.getAppStatus();
                TapGDTNativeFeedSession tapGDTNativeFeedSession = TapGDTNativeFeedSession.this;
                StringBuilder sbAppend = new StringBuilder().append("onADStatusChanged status=").append(TapGDTNativeFeedSession.this.appStatusToString(status)).append(", haveDownloading=").append(TapGDTNativeFeedSession.this.haveDownloading.get()).append(", suppressing=");
                TapGDTNativeFeedSession tapGDTNativeFeedSession2 = TapGDTNativeFeedSession.this;
                tapGDTNativeFeedSession.logDownloadFlow(sbAppend.append(tapGDTNativeFeedSession2.isNormalClickDownloadSuppressing(tapGDTNativeFeedSession2.normalClickDownloadSuppressUntil)).toString());
                if (status == 4) {
                    TapGDTNativeFeedSession tapGDTNativeFeedSession3 = TapGDTNativeFeedSession.this;
                    if (tapGDTNativeFeedSession3.trySuppressNormalClickDownload(this.val$nativeAdContainer, tapGDTNativeFeedSession3.normalClickDownloadSuppressUntil, TapGDTNativeFeedSession.this.normalClickWasDownloading)) {
                        TapGDTNativeFeedSession.this.logDownloadFlow("onADStatusChanged suppressed downloading callback");
                        return;
                    }
                    TapGDTNativeFeedSession.this.startDownload(this.val$boundAdData, this.appName, this.apkSize);
                }
                if (status == 8) {
                    TapGDTNativeFeedSession.this.stopDownload();
                    AdapterAdEventSink adapterAdEventSink = TapGDTNativeFeedSession.this.eventSink;
                    long j = this.apkSize;
                    adapterAdEventSink.onDownloadComplete(j, j, this.appName, "");
                }
                if (status == 1) {
                    TapGDTNativeFeedSession.this.stopDownload();
                    TapGDTNativeFeedSession.this.eventSink.onInstalled(this.apkSize, this.appName, "");
                }
                if (status == 16) {
                    TapGDTNativeFeedSession.this.stopDownload();
                    AdapterAdEventSink adapterAdEventSink2 = TapGDTNativeFeedSession.this.eventSink;
                    long j2 = this.apkSize;
                    adapterAdEventSink2.onDownloadFailure(j2, j2, TapGDTNativeFeedSession.this.curBytes, this.appName, "", -1, "");
                }
                if (status == 32) {
                    TapGDTNativeFeedSession tapGDTNativeFeedSession4 = TapGDTNativeFeedSession.this;
                    if (tapGDTNativeFeedSession4.trySuppressNormalClickDownload(this.val$nativeAdContainer, tapGDTNativeFeedSession4.normalClickDownloadSuppressUntil, TapGDTNativeFeedSession.this.normalClickWasDownloading)) {
                        TapGDTNativeFeedSession.this.logDownloadFlow("onADStatusChanged suppressed paused callback");
                        return;
                    }
                    TapGDTNativeFeedSession.this.stopDownload();
                    AdapterAdEventSink adapterAdEventSink3 = TapGDTNativeFeedSession.this.eventSink;
                    long j3 = this.apkSize;
                    adapterAdEventSink3.onDownloadPause(j3, j3, TapGDTNativeFeedSession.this.curBytes, this.appName, "");
                }
            }
        });
        syncCurrentDownloadStatus(boundAdData);
        boundAdData.bindMediaView(this.mediaView, new VideoOption.Builder().setAutoPlayMuted(true).setAutoPlayPolicy(1).setNeedCoverImage(true).setNeedProgressBar(true).setEnableUserControl(false).build(), new NativeADMediaListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.3
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                if (!TapGDTNativeFeedSession.this.released.get()) {
                    TapGDTNativeFeedSession.this.eventSink.onVideoPrepared();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i) {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStart() {
                if (!TapGDTNativeFeedSession.this.released.get()) {
                    TapGDTNativeFeedSession.this.eventSink.onVideoStart();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoPause() {
                if (!TapGDTNativeFeedSession.this.released.get()) {
                    TapGDTNativeFeedSession.this.eventSink.onVideoPause();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoResume() {
                if (!TapGDTNativeFeedSession.this.released.get()) {
                    TapGDTNativeFeedSession.this.eventSink.onVideoResume();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
                if (!TapGDTNativeFeedSession.this.released.get()) {
                    TapGDTNativeFeedSession.this.eventSink.onVideoComplete(0L);
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
                if (!TapGDTNativeFeedSession.this.released.get()) {
                    TapGDTNativeFeedSession.this.eventSink.onVideoFailure(adError.getErrorCode(), adError.getErrorMsg());
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                if (!TapGDTNativeFeedSession.this.released.get()) {
                    TapGDTNativeFeedSession.this.eventSink.onVideoPause();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
            }
        });
        if (boundAdData.isAppAd()) {
            if (binding.isSelfDoubleWindow()) {
                boundAdData.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.4
                    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                    public void onDownloadConfirm(Activity activity2, int scenes, String infoUrl, final DownloadConfirmCallBack gdtCallBack) {
                        if (TapGDTNativeFeedSession.this.released.get()) {
                            gdtCallBack.onCancel();
                            return;
                        }
                        TapGDTNativeFeedSession tapGDTNativeFeedSession = TapGDTNativeFeedSession.this;
                        StringBuilder sbAppend = new StringBuilder().append("GDT onDownloadConfirm scenes=").append(scenes).append(", status=").append(TapGDTNativeFeedSession.this.getCurrentAppStatusForLog()).append(", haveDownloading=").append(TapGDTNativeFeedSession.this.haveDownloading.get()).append(", suppressing=");
                        TapGDTNativeFeedSession tapGDTNativeFeedSession2 = TapGDTNativeFeedSession.this;
                        tapGDTNativeFeedSession.logDownloadFlow(sbAppend.append(tapGDTNativeFeedSession2.isNormalClickDownloadSuppressing(tapGDTNativeFeedSession2.normalClickDownloadSuppressUntil)).append(", hasInfoUrl=").append(infoUrl != null && infoUrl.length() > 0).toString());
                        TapGDTNativeFeedSession tapGDTNativeFeedSession3 = TapGDTNativeFeedSession.this;
                        if (tapGDTNativeFeedSession3.isNormalClickDownloadSuppressing(tapGDTNativeFeedSession3.normalClickDownloadSuppressUntil)) {
                            boolean wasDownloading = TapGDTNativeFeedSession.this.normalClickWasDownloading.get();
                            if (wasDownloading) {
                                try {
                                    gdtCallBack.onConfirm();
                                } catch (Throwable throwable) {
                                    TapGDTNativeFeedSession.this.logDownloadFlow("normal-click suppress gdt callback failed: " + throwable.getClass().getSimpleName());
                                }
                                TapGDTNativeFeedSession.this.logDownloadFlow("normal-click suppress kept downloading gdt confirm");
                                return;
                            }
                            final DownloadDecision[] pendingListener = new DownloadDecision[1];
                            pendingListener[0] = new DownloadDecision() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.4.1
                                @Override // com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.DownloadDecision
                                public void onDownloadConfirm() {
                                    try {
                                        TapGDTNativeFeedSession.this.logDownloadFlow("pending normal-click confirm -> gdtCallBack.onConfirm(), status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog());
                                        gdtCallBack.onConfirm();
                                    } catch (Throwable throwable2) {
                                        TapGDTNativeFeedSession.this.logDownloadFlow("pending normal-click confirm failed: " + throwable2.getClass().getSimpleName());
                                    }
                                    TapGDTNativeFeedSession.this.clearDownloadDecision(pendingListener[0]);
                                }

                                @Override // com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.DownloadDecision
                                public void onDownloadCancel() {
                                    try {
                                        TapGDTNativeFeedSession.this.logDownloadFlow("pending normal-click cancel -> gdtCallBack.onCancel(), status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog());
                                        gdtCallBack.onCancel();
                                    } catch (Throwable throwable2) {
                                        TapGDTNativeFeedSession.this.logDownloadFlow("pending normal-click cancel failed: " + throwable2.getClass().getSimpleName());
                                    }
                                    TapGDTNativeFeedSession.this.clearDownloadDecision(pendingListener[0]);
                                }
                            };
                            TapGDTNativeFeedSession.this.setDownloadDecision(pendingListener[0]);
                            nativeAdContainer.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.4.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (TapGDTNativeFeedSession.this.pendingDownloadDecision != pendingListener[0]) {
                                        return;
                                    }
                                    try {
                                        gdtCallBack.onCancel();
                                    } catch (Throwable throwable2) {
                                        TapGDTNativeFeedSession.this.logDownloadFlow("pending normal-click timeout cancel failed: " + throwable2.getClass().getSimpleName());
                                    }
                                    TapGDTNativeFeedSession.this.clearDownloadDecision(pendingListener[0]);
                                    TapGDTNativeFeedSession.this.logDownloadFlow("pending normal-click gdt confirm timeout canceled");
                                }
                            }, TapGDTNativeFeedSession.PENDING_NORMAL_CLICK_CONFIRM_MS);
                            TapGDTNativeFeedSession.this.logDownloadFlow("normal-click suppress deferred gdt confirm to creative control");
                            return;
                        }
                        TapGDTNativeFeedSession.this.normalClickDownloadSuppressUntil.set(0L);
                        TapGDTNativeFeedSession.this.logDownloadFlow("emit host onDownloadWindowConfirm");
                        TapGDTNativeFeedSession.this.setDownloadDecision(new DownloadDecision() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.4.3
                            @Override // com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.DownloadDecision
                            public void onDownloadConfirm() {
                                if (!TapGDTNativeFeedSession.this.released.get()) {
                                    TapGDTNativeFeedSession.this.logDownloadFlow("host onDownloadConfirm status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog() + ", haveDownloading=" + TapGDTNativeFeedSession.this.haveDownloading.get());
                                    if (TapGDTNativeFeedSession.this.isCurrentAppStatus(32) && TapGDTNativeFeedSession.this.reflectResumeAppDownload()) {
                                        TapGDTNativeFeedSession.this.logDownloadFlow("paused resume reflected -> gdtCallBack.onCancel()");
                                        gdtCallBack.onCancel();
                                    } else if (TapGDTNativeFeedSession.this.haveDownloading.get()) {
                                        TapGDTNativeFeedSession.this.logDownloadFlow("host confirm while downloading -> gdtCallBack.onCancel()");
                                        gdtCallBack.onCancel();
                                    } else {
                                        TapGDTNativeFeedSession.this.logDownloadFlow("host confirm idle -> gdtCallBack.onConfirm()");
                                        gdtCallBack.onConfirm();
                                    }
                                    TapGDTNativeFeedSession.this.setDownloadDecision(null);
                                    return;
                                }
                                gdtCallBack.onCancel();
                                TapGDTNativeFeedSession.this.setDownloadDecision(null);
                            }

                            @Override // com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.DownloadDecision
                            public void onDownloadCancel() {
                                if (!TapGDTNativeFeedSession.this.released.get()) {
                                    TapGDTNativeFeedSession.this.logDownloadFlow("host onDownloadCancel status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog() + ", haveDownloading=" + TapGDTNativeFeedSession.this.haveDownloading.get());
                                    if (TapGDTNativeFeedSession.this.haveDownloading.get()) {
                                        TapGDTNativeFeedSession.this.logDownloadFlow("host cancel while downloading -> gdtCallBack.onConfirm()");
                                        gdtCallBack.onConfirm();
                                    } else {
                                        TapGDTNativeFeedSession.this.logDownloadFlow("host cancel idle -> gdtCallBack.onCancel()");
                                        gdtCallBack.onCancel();
                                    }
                                    TapGDTNativeFeedSession.this.setDownloadDecision(null);
                                    return;
                                }
                                gdtCallBack.onCancel();
                                TapGDTNativeFeedSession.this.setDownloadDecision(null);
                            }
                        });
                        TapGDTNativeFeedSession.this.eventSink.onDownloadWindowConfirm();
                    }
                });
            } else if (!binding.isDoubleWindow()) {
                boundAdData.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.5
                    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                    public void onDownloadConfirm(Activity activity2, int i, String s, DownloadConfirmCallBack downloadConfirmCallBack) {
                        if (TapGDTNativeFeedSession.this.released.get()) {
                            downloadConfirmCallBack.onCancel();
                        } else if (TapGDTNativeFeedSession.this.haveDownloading.get()) {
                            downloadConfirmCallBack.onCancel();
                        } else {
                            downloadConfirmCallBack.onConfirm();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isViewInList(View clickedView, List<View> views) {
        if (clickedView == null || views == null || views.isEmpty()) {
            return false;
        }
        for (View view : views) {
            if (view != null) {
                if (clickedView == view) {
                    return true;
                }
                View parent = clickedView;
                while (parent.getParent() instanceof View) {
                    parent = (View) parent.getParent();
                    if (parent == view) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTouchInList(float rawX, float rawY, List<View> views) {
        if (views == null || views.isEmpty()) {
            return false;
        }
        Rect rect = new Rect();
        int[] location = new int[2];
        for (View view : views) {
            if (view != null && view.getVisibility() == 0) {
                view.getLocationOnScreen(location);
                rect.set(location[0], location[1], location[0] + view.getWidth(), location[1] + view.getHeight());
                if (rect.contains((int) rawX, (int) rawY)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markNormalClickDownloadSuppress(AtomicLong suppressUntil, AtomicBoolean wasDownloading) {
        wasDownloading.set(this.haveDownloading.get());
        this.normalClickSuppressHandled.set(false);
        suppressUntil.set(SystemClock.uptimeMillis() + NORMAL_CLICK_DOWNLOAD_SUPPRESS_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNormalClickDownloadSuppressing(AtomicLong suppressUntil) {
        return SystemClock.uptimeMillis() <= suppressUntil.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPausedCreativeResumePending(AtomicLong resumeUntil) {
        return SystemClock.uptimeMillis() <= resumeUntil.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitCreativeDownloadControlConfirm() {
        final boolean wasDownloading = isCurrentAppStatus(4) || this.haveDownloading.get();
        boolean isPaused = isCurrentAppStatus(32);
        boolean isFinished = isCurrentAppStatus(8);
        if (!wasDownloading && !isPaused && hasPendingDownloadDecision()) {
            logDownloadFlow("idle creative control -> emit host confirm with pending gdt callback, status=" + getCurrentAppStatusForLog());
            this.eventSink.onDownloadWindowConfirm();
        } else if (isFinished) {
            setDownloadDecision(new DownloadDecision() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.6
                @Override // com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.DownloadDecision
                public void onDownloadConfirm() {
                    boolean installed = TapGDTNativeFeedSession.this.reflectInstallDownloadedApp();
                    TapGDTNativeFeedSession.this.logDownloadFlow("finished creative host confirm -> reflect install=" + installed + ", status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog());
                    TapGDTNativeFeedSession.this.setDownloadDecision(null);
                }

                @Override // com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.DownloadDecision
                public void onDownloadCancel() {
                    TapGDTNativeFeedSession.this.logDownloadFlow("finished creative host cancel, status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog());
                    TapGDTNativeFeedSession.this.setDownloadDecision(null);
                }
            });
            this.eventSink.onDownloadWindowConfirm();
        } else {
            setDownloadDecision(new DownloadDecision() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.7
                @Override // com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.DownloadDecision
                public void onDownloadConfirm() {
                    if (wasDownloading) {
                        TapGDTNativeFeedSession.this.logDownloadFlow("downloading creative host confirm -> reflect pause, status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog());
                        boolean paused = TapGDTNativeFeedSession.this.reflectPauseAppDownload();
                        TapGDTNativeFeedSession.this.logDownloadFlow("downloading creative reflected pause=" + paused + ", status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog());
                    } else {
                        TapGDTNativeFeedSession.this.logDownloadFlow("paused creative host confirm -> reflect resume, status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog());
                        boolean resumed = TapGDTNativeFeedSession.this.reflectResumeAppDownload();
                        TapGDTNativeFeedSession.this.logDownloadFlow("paused creative reflected resume=" + resumed + ", status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog());
                    }
                    TapGDTNativeFeedSession.this.setDownloadDecision(null);
                }

                @Override // com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.DownloadDecision
                public void onDownloadCancel() {
                    if (wasDownloading) {
                        TapGDTNativeFeedSession.this.logDownloadFlow("downloading creative host cancel -> reflect pause, status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog());
                        boolean paused = TapGDTNativeFeedSession.this.reflectPauseAppDownload();
                        TapGDTNativeFeedSession.this.logDownloadFlow("downloading creative reflected pause=" + paused + ", status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog());
                    } else {
                        TapGDTNativeFeedSession.this.logDownloadFlow("paused creative host cancel, status=" + TapGDTNativeFeedSession.this.getCurrentAppStatusForLog());
                    }
                    TapGDTNativeFeedSession.this.setDownloadDecision(null);
                }
            });
            this.eventSink.onDownloadWindowConfirm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean trySuppressNormalClickDownload(View anchor, AtomicLong suppressUntil, AtomicBoolean wasDownloading) {
        try {
            if (!isNormalClickDownloadSuppressing(suppressUntil)) {
                return false;
            }
            if (this.normalClickSuppressHandled.compareAndSet(false, true)) {
                return suppressNormalClickDownload(anchor, suppressUntil, wasDownloading);
            }
            return true;
        } catch (Throwable th) {
            suppressUntil.set(0L);
            return false;
        }
    }

    private boolean suppressNormalClickDownload(View anchor, final AtomicLong suppressUntil, final AtomicBoolean wasDownloading) {
        boolean suppressed = reflectRollbackNormalClickDownload(wasDownloading.get());
        if (!suppressed) {
            suppressUntil.set(0L);
            return false;
        }
        long[] delays = {60, 180, 420, 900, 1400, 2200};
        for (long delay : delays) {
            anchor.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (TapGDTNativeFeedSession.this.isNormalClickDownloadSuppressing(suppressUntil)) {
                            TapGDTNativeFeedSession.this.reflectRollbackNormalClickDownload(wasDownloading.get());
                        }
                    } catch (Throwable th) {
                        suppressUntil.set(0L);
                    }
                }
            }, delay);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCurrentAppStatus(int expectedStatus) {
        try {
            NativeUnifiedADData nativeUnifiedADData = this.adData;
            return nativeUnifiedADData != null && nativeUnifiedADData.isAppAd() && this.adData.getAppStatus() == expectedStatus;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCreativeDownloadControlStatus() {
        return isCurrentAppStatus(32) || isCurrentAppStatus(4) || (isCurrentAppStatus(8) && hasDownloadedApkTask()) || hasPendingDownloadDecision();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public void pauseDownload() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        if (nativeUnifiedADData == null || !nativeUnifiedADData.isAppAd()) {
            logDownloadFlow("pauseDownload skip not-app, status=" + getCurrentAppStatusForLog());
            return;
        }
        if (!isCurrentAppStatus(4)) {
            logDownloadFlow("pauseDownload skip, status=" + getCurrentAppStatusForLog());
            return;
        }
        try {
            this.adData.pauseAppDownload();
            logDownloadFlow("pauseDownload direct, status=" + getCurrentAppStatusForLog());
        } catch (Throwable t) {
            logDownloadFlow("pauseDownload direct failed: " + t.getClass().getSimpleName());
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public void resumeDownload() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        if (nativeUnifiedADData == null || !nativeUnifiedADData.isAppAd()) {
            logDownloadFlow("resumeDownload skip not-app, status=" + getCurrentAppStatusForLog());
            return;
        }
        if (!isCurrentAppStatus(32)) {
            logDownloadFlow("resumeDownload skip, status=" + getCurrentAppStatusForLog());
            return;
        }
        try {
            this.adData.resumeAppDownload();
            logDownloadFlow("resumeDownload direct, status=" + getCurrentAppStatusForLog());
        } catch (Throwable t) {
            logDownloadFlow("resumeDownload direct failed: " + t.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reflectResumeAppDownload() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        String[] strArr = RESUME_DOWNLOAD_METHODS;
        boolean invoked = invokeDownloadControlMethods(nativeUnifiedADData, strArr);
        Object delegate = getDelegateAdData(this.adData);
        if (delegate != null && delegate != this.adData) {
            invoked |= invokeDownloadControlMethods(delegate, strArr);
        }
        logDownloadFlow("reflectResumeAppDownload invoked=" + invoked + ", status=" + getCurrentAppStatusForLog());
        return invoked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reflectPauseAppDownload() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        String[] strArr = PAUSE_DOWNLOAD_METHODS;
        boolean invoked = invokeDownloadControlMethods(nativeUnifiedADData, strArr);
        Object delegate = getDelegateAdData(this.adData);
        if (delegate != null && delegate != this.adData) {
            invoked |= invokeDownloadControlMethods(delegate, strArr);
        }
        logDownloadFlow("reflectPauseAppDownload invoked=" + invoked + ", status=" + getCurrentAppStatusForLog());
        return invoked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reflectInstallDownloadedApp() {
        Object task = getDownloadedApkTask(this.adData);
        Object delegate = getDelegateAdData(this.adData);
        if (task == null && delegate != null && delegate != this.adData) {
            task = getDownloadedApkTask(delegate);
        }
        boolean invoked = invokeInstallDownloadedApkTask(task);
        logDownloadFlow("reflectInstallDownloadedApp invoked=" + invoked + ", task=" + (task == null ? AbstractJsonLexerKt.NULL : task.getClass().getName()));
        return invoked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reflectRollbackNormalClickDownload(boolean wasDownloading) {
        String[] methodNames = wasDownloading ? RESUME_DOWNLOAD_METHODS : STOP_DOWNLOAD_METHODS;
        boolean invoked = invokeDownloadControlMethods(this.adData, methodNames);
        Object delegate = getDelegateAdData(this.adData);
        if (delegate != null && delegate != this.adData) {
            return invoked | invokeDownloadControlMethods(delegate, methodNames);
        }
        return invoked;
    }

    private boolean hasDownloadedApkTask() {
        Object task = getDownloadedApkTask(this.adData);
        Object delegate = getDelegateAdData(this.adData);
        return (task == null && (delegate == null || delegate == this.adData || getDownloadedApkTask(delegate) == null)) ? false : true;
    }

    private Object getDownloadedApkTask(Object target) {
        Method getTaskMethod;
        String packageName = getDownloadPackageName(target);
        if (packageName == null || packageName.length() == 0 || target == null) {
            return null;
        }
        try {
            ClassLoader classLoader = target.getClass().getClassLoader();
            Class<?> managerClass = Class.forName("com.qq.e.comm.plugin.apkmanager.l", true, classLoader);
            Method instanceMethod = findNoArgMethod(managerClass, "e");
            if (instanceMethod == null) {
                return null;
            }
            instanceMethod.setAccessible(true);
            Object manager = instanceMethod.invoke(null, new Object[0]);
            if (manager == null || (getTaskMethod = findOneArgMethod(manager.getClass(), an.aF, String.class)) == null) {
                return null;
            }
            getTaskMethod.setAccessible(true);
            return getTaskMethod.invoke(manager, packageName);
        } catch (Throwable th) {
            return null;
        }
    }

    private String getDownloadPackageName(Object target) {
        try {
            Object adInfo = invokeNoArgObject(target, an.aE);
            Object appInfo = invokeNoArgObject(adInfo, "F");
            Object packageName = invokeNoArgObject(appInfo, "e");
            if (packageName instanceof String) {
                return (String) packageName;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private boolean invokeInstallDownloadedApkTask(Object task) {
        if (task == null) {
            return false;
        }
        try {
            ClassLoader classLoader = task.getClass().getClassLoader();
            Class<?> installerClass = Class.forName("com.qq.e.comm.plugin.pf", true, classLoader);
            Method installMethod = findOneArgMethod(installerClass, "b", task.getClass());
            if (installMethod == null) {
                return false;
            }
            installMethod.setAccessible(true);
            installMethod.invoke(null, task);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean hasPendingDownloadDecision() {
        return this.pendingDownloadDecision != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloadDecision(DownloadDecision decision) {
        this.pendingDownloadDecision = decision;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDownloadDecision(DownloadDecision decision) {
        if (this.pendingDownloadDecision == decision) {
            this.pendingDownloadDecision = null;
        }
    }

    private boolean invokeDownloadControlMethods(Object target, String[] methodNames) {
        if (target == null) {
            return false;
        }
        boolean invoked = false;
        for (String methodName : methodNames) {
            try {
                Method method = findNoArgMethod(target.getClass(), methodName);
                if (method != null) {
                    method.setAccessible(true);
                    method.invoke(target, new Object[0]);
                    logDownloadFlow("invokeDownloadControlMethods success method=" + methodName + ", target=" + target.getClass().getName());
                    invoked = true;
                }
            } catch (Throwable th) {
            }
        }
        return invoked;
    }

    private Object invokeNoArgObject(Object target, String methodName) {
        if (target == null) {
            return null;
        }
        try {
            Method method = findNoArgMethod(target.getClass(), methodName);
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return method.invoke(target, new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    private Method findNoArgMethod(Class<?> clazz, String methodName) {
        for (Class<?> current = clazz; current != null; current = current.getSuperclass()) {
            try {
                return current.getDeclaredMethod(methodName, new Class[0]);
            } catch (NoSuchMethodException e) {
            }
        }
        try {
            return clazz.getMethod(methodName, new Class[0]);
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    private Method findOneArgMethod(Class<?> clazz, String methodName, Class<?> argType) {
        for (Class<?> current = clazz; current != null; current = current.getSuperclass()) {
            Method method = findOneArgDeclaredMethod(current, methodName, argType);
            if (method != null) {
                return method;
            }
        }
        Method[] methods = clazz.getMethods();
        for (Method method2 : methods) {
            if (isOneArgMethodMatch(method2, methodName, argType)) {
                return method2;
            }
        }
        return null;
    }

    private Method findOneArgDeclaredMethod(Class<?> clazz, String methodName, Class<?> argType) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (isOneArgMethodMatch(method, methodName, argType)) {
                return method;
            }
        }
        return null;
    }

    private boolean isOneArgMethodMatch(Method method, String methodName, Class<?> argType) {
        if (!methodName.equals(method.getName())) {
            return false;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        return parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(argType);
    }

    private Object getDelegateAdData(Object target) {
        if (target == null) {
            return null;
        }
        for (Class<?> current = target.getClass(); current != null; current = current.getSuperclass()) {
            Field[] fields = current.getDeclaredFields();
            for (Field field : fields) {
                if (NativeUnifiedADData.class.isAssignableFrom(field.getType())) {
                    try {
                        field.setAccessible(true);
                        return field.get(target);
                    } catch (Throwable th) {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCurrentAppStatusForLog() {
        try {
            NativeUnifiedADData nativeUnifiedADData = this.adData;
            if (nativeUnifiedADData != null && nativeUnifiedADData.isAppAd()) {
                return appStatusToString(this.adData.getAppStatus());
            }
            return "not_app";
        } catch (Throwable throwable) {
            return "error:" + throwable.getClass().getSimpleName();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String appStatusToString(int status) {
        if (status == 0) {
            return "UNKNOWN(" + status + ")";
        }
        if (status == 1) {
            return "INSTALLED(" + status + ")";
        }
        if (status == 4) {
            return "DOWNLOADING(" + status + ")";
        }
        if (status == 8) {
            return "FINISHED(" + status + ")";
        }
        if (status == 16) {
            return "FAILED(" + status + ")";
        }
        return status == 32 ? "PAUSED(" + status + ")" : "OTHER(" + status + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logDownloadFlow(String message) {
        Log.d(DOWNLOAD_FLOW_TAG, SystemClock.uptimeMillis() + " GDT " + message);
    }

    private void syncCurrentDownloadStatus(NativeUnifiedADData currentAdData) {
        if (!currentAdData.isAppAd() || this.released.get()) {
            return;
        }
        int status = currentAdData.getAppStatus();
        String appName = getComplianceInfo().getAppName();
        long apkSize = getApkSizeBytes();
        if (status == 4) {
            startDownload(currentAdData, appName, apkSize);
            return;
        }
        if (status == 8) {
            stopDownload();
            this.eventSink.onDownloadComplete(apkSize, apkSize, appName, "");
            return;
        }
        if (status == 1) {
            stopDownload();
            this.eventSink.onInstalled(apkSize, appName, "");
        } else if (status == 16) {
            stopDownload();
            this.eventSink.onDownloadFailure(apkSize, apkSize, this.curBytes, appName, "", -1, "");
        } else if (status == 32) {
            stopDownload();
            this.eventSink.onDownloadPause(apkSize, apkSize, this.curBytes, appName, "");
        }
    }

    void startDownload(final NativeUnifiedADData downloadAdData, final String appName, final long apkSize) {
        if (!this.released.get() && this.haveDownloading.compareAndSet(false, true)) {
            this.eventSink.onDownloadStart(apkSize, appName, "");
            this.progressTimer = new Timer();
            TimerTask timerTask = new TimerTask() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedSession.9
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (TapGDTNativeFeedSession.this.released.get()) {
                        return;
                    }
                    try {
                        int progress = downloadAdData.getProgress();
                        if (TapGDTNativeFeedSession.this.released.get()) {
                            return;
                        }
                        TapGDTNativeFeedSession.this.curBytes = (apkSize * ((long) progress)) / 100;
                        AdapterAdEventSink adapterAdEventSink = TapGDTNativeFeedSession.this.eventSink;
                        long j = apkSize;
                        adapterAdEventSink.onDownloadProgress(j, j, TapGDTNativeFeedSession.this.curBytes, appName, "");
                    } catch (Exception e) {
                    }
                }
            };
            this.progressTimerTask = timerTask;
            this.progressTimer.schedule(timerTask, 0L, 300L);
        }
    }

    void stopDownload() {
        this.haveDownloading.set(false);
        TimerTask timerTask = this.progressTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.progressTimerTask = null;
        }
        Timer timer = this.progressTimer;
        if (timer != null) {
            timer.cancel();
            this.progressTimer = null;
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public View getMediaView() {
        if (this.mediaView != null) {
            return this.mediaView;
        }
        if (this.mediaView == null) {
            synchronized (this) {
                if (this.mediaView == null) {
                    Context context = this.context.get();
                    if (context == null) {
                        return null;
                    }
                    this.mediaView = new MediaView(context);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mediaView.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(this.acceptedWidth, this.acceptedHeight);
                    } else {
                        layoutParams.width = this.acceptedWidth;
                        layoutParams.height = this.acceptedHeight;
                    }
                    this.mediaView.setLayoutParams(layoutParams);
                    this.mediaView.setVisibility(0);
                }
            }
        }
        return this.mediaView;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (!this.released.compareAndSet(false, true)) {
            return;
        }
        stopDownload();
        this.pendingDownloadDecision = null;
        NativeUnifiedADData currentAdData = this.adData;
        this.adData = null;
        if (currentAdData != null) {
            try {
                currentAdData.setNativeAdEventListener(null);
            } catch (Exception e) {
            }
            try {
                currentAdData.setDownloadConfirmListener(null);
            } catch (Exception e2) {
            }
            currentAdData.destroy();
        }
        this.mediaView = null;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        return nativeUnifiedADData != null && nativeUnifiedADData.isValid();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        if (nativeUnifiedADData == null) {
            return 0L;
        }
        return nativeUnifiedADData.getECPM();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.sendWinNotification(Utils.getWinMap(secondPrice, winPrice));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.sendLossNotification(Utils.getLossMap(winPrice, lossReason, winBidder));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public void confirmDownload() {
        DownloadDecision decision = this.pendingDownloadDecision;
        if (decision != null) {
            decision.onDownloadConfirm();
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public void cancelDownload() {
        DownloadDecision decision = this.pendingDownloadDecision;
        if (decision != null) {
            decision.onDownloadCancel();
        }
    }
}
