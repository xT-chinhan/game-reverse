package com.tapsdk.tapad.lib_gdtadapter;

import android.app.Activity;
import android.content.Context;
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
import com.tapsdk.tapad.group.adapter.AdapterNativeImage;
import com.tapsdk.tapad.group.adapter.AdapterNativeSplashBinding;
import com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession;
import com.tapsdk.tapad.group.adapter.AdapterSplashLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterViewSupport;
import com.tapsdk.tapad.lib_gdtadapter.utils.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapGDTNativeSplashSession implements AdapterNativeSplashSession {
    private static final long DEFAULT_EXPIRATION_MILLIS = 1800000;
    private NativeUnifiedADData adData;
    private Activity boundActivity;
    private FrameLayout.LayoutParams boundAttributionParams;
    private AdapterNativeSplashBinding boundBinding;
    private NativeAdContainer boundContainer;
    private final WeakReference<Context> contextRef;
    private volatile MediaView mediaView;
    private final AdapterSplashLoadRequest request;
    private boolean videoMuted = true;
    private final AtomicBoolean released = new AtomicBoolean(false);
    private final AtomicBoolean haveDownloading = new AtomicBoolean(false);
    private final long expirationTimestamp = System.currentTimeMillis() + DEFAULT_EXPIRATION_MILLIS;
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;
    private final NativeADMediaListener mediaListener = new NativeADMediaListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeSplashSession.3
        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
            if (!TapGDTNativeSplashSession.this.released.get()) {
                TapGDTNativeSplashSession.this.eventSink.onVideoPrepared();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
            if (!TapGDTNativeSplashSession.this.released.get()) {
                TapGDTNativeSplashSession.this.eventSink.onVideoStart();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
            if (!TapGDTNativeSplashSession.this.released.get()) {
                TapGDTNativeSplashSession.this.eventSink.onVideoPause();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
            if (!TapGDTNativeSplashSession.this.released.get()) {
                TapGDTNativeSplashSession.this.eventSink.onVideoResume();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
            if (!TapGDTNativeSplashSession.this.released.get()) {
                TapGDTNativeSplashSession.this.eventSink.onVideoComplete(0L);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
            if (!TapGDTNativeSplashSession.this.released.get()) {
                TapGDTNativeSplashSession.this.eventSink.onVideoFailure(adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
            if (!TapGDTNativeSplashSession.this.released.get()) {
                TapGDTNativeSplashSession.this.eventSink.onVideoPause();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
        }
    };

    TapGDTNativeSplashSession(NativeUnifiedADData adData, AdapterSplashLoadRequest request, Context context) {
        this.adData = adData;
        this.request = request;
        this.contextRef = new WeakReference<>(context);
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

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getIconUrl() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        return nativeUnifiedADData == null ? "" : nativeUnifiedADData.getIconUrl();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public List<AdapterNativeImage> getImages() {
        if (this.adData == null) {
            return Collections.emptyList();
        }
        List<AdapterNativeImage> res = new ArrayList<>();
        addImageInfo(res, this.adData.getImgUrl(), this.adData.getPictureWidth(), this.adData.getPictureHeight());
        List<String> imageUrls = this.adData.getImgList();
        if (imageUrls != null) {
            for (String imageUrl : imageUrls) {
                addImageInfo(res, imageUrl, 0, 0);
            }
        }
        return res;
    }

    private void addImageInfo(List<AdapterNativeImage> target, String imageUrl, int width, int height) {
        if (target == null || imageUrl == null || imageUrl.length() == 0) {
            return;
        }
        target.add(new AdapterNativeImage(imageUrl, width, height));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getTitle() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        return nativeUnifiedADData == null ? "" : nativeUnifiedADData.getTitle();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getDescription() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        return nativeUnifiedADData == null ? "" : nativeUnifiedADData.getDesc();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public long getApkSizeBytes() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        NativeUnifiedADAppMiitInfo info = nativeUnifiedADData == null ? null : nativeUnifiedADData.getAppMiitInfo();
        if (info == null) {
            return 0L;
        }
        return info.getPackageSizeBytes();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public int getInteractionType() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        return (nativeUnifiedADData == null || !nativeUnifiedADData.isAppAd()) ? 0 : 1;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public int getImageMode() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        return (nativeUnifiedADData == null || nativeUnifiedADData.getAdPatternType() != 2) ? 1 : 2;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public boolean supportsVideoMuteControl() {
        return true;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public boolean isVideoMutedByDefault() {
        return this.videoMuted;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession
    public void setVideoMuted(boolean muted) {
        NativeUnifiedADData current = this.adData;
        if (current != null && !this.released.get()) {
            this.videoMuted = muted;
            current.setVideoMute(muted);
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public AdapterAppComplianceInfo getComplianceInfo() {
        NativeUnifiedADData nativeUnifiedADData = this.adData;
        NativeUnifiedADAppMiitInfo info = nativeUnifiedADData == null ? null : nativeUnifiedADData.getAppMiitInfo();
        if (info == null) {
            return AdapterAppComplianceInfo.EMPTY;
        }
        return new AdapterAppComplianceInfo(info.getAppName(), info.getVersionName(), info.getAuthorName(), info.getPrivacyAgreement(), info.getDescriptionUrl(), info.getPermissionsUrl(), "");
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession
    public View getMediaView(Context context) {
        if (getImageMode() != 2) {
            return null;
        }
        if (this.mediaView != null) {
            return this.mediaView;
        }
        Context viewContext = context != null ? context : this.contextRef.get();
        if (viewContext == null) {
            return null;
        }
        this.mediaView = new MediaView(viewContext);
        this.mediaView.setLayoutParams(new FrameLayout.LayoutParams(resolveWidth(viewContext), resolveHeight(viewContext)));
        this.mediaView.setVisibility(0);
        return this.mediaView;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession
    public void bind(Activity activity, AdapterNativeSplashBinding binding) {
        final NativeUnifiedADData boundAdData = this.adData;
        if (boundAdData == null) {
            throw new IllegalStateException("gdt native ad is null");
        }
        NativeAdContainer nativeAdContainer = new NativeAdContainer(activity);
        binding.installProviderContainer(nativeAdContainer);
        this.boundActivity = activity;
        this.boundContainer = nativeAdContainer;
        this.boundBinding = binding;
        final FrameLayout adContainer = binding.getHostContainer();
        List<View> clickViews = binding.getClickViews();
        List<View> creativeViews = binding.getCreativeViews();
        FrameLayout.LayoutParams attributionParams = binding.getAdLogoLayoutParams();
        this.boundAttributionParams = attributionParams;
        bindInteractionViews(boundAdData, activity, nativeAdContainer, attributionParams, clickViews, creativeViews);
        binding.attachProviderAttributionView(attributionParams);
        boundAdData.setNativeAdEventListener(new NativeADEventListenerWithClickInfo() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeSplashSession.1
            final long apkSize;
            final String appName;

            {
                this.appName = TapGDTNativeSplashSession.this.getComplianceInfo().getAppName();
                this.apkSize = TapGDTNativeSplashSession.this.getApkSizeBytes();
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                if (!TapGDTNativeSplashSession.this.released.get()) {
                    TapGDTNativeSplashSession.this.eventSink.onShow(adContainer);
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo
            public void onADClicked(View view) {
                if (!TapGDTNativeSplashSession.this.released.get()) {
                    TapGDTNativeSplashSession.this.eventSink.onClick(view);
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                if (TapGDTNativeSplashSession.this.released.get()) {
                    return;
                }
                TapGDTNativeSplashSession.this.eventSink.onRenderFailure(adContainer, adError.getErrorCode(), adError.getErrorMsg());
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
                if (TapGDTNativeSplashSession.this.released.get()) {
                    return;
                }
                int status = boundAdData.getAppStatus();
                if (status == 4) {
                    TapGDTNativeSplashSession.this.startDownload(this.appName, this.apkSize);
                }
                if (status == 8) {
                    TapGDTNativeSplashSession.this.stopDownload();
                    AdapterAdEventSink adapterAdEventSink = TapGDTNativeSplashSession.this.eventSink;
                    long j = this.apkSize;
                    adapterAdEventSink.onDownloadComplete(j, j, this.appName, "");
                }
                if (status == 1) {
                    TapGDTNativeSplashSession.this.stopDownload();
                    TapGDTNativeSplashSession.this.eventSink.onInstalled(this.apkSize, this.appName, "");
                }
                if (status == 16) {
                    TapGDTNativeSplashSession.this.stopDownload();
                    AdapterAdEventSink adapterAdEventSink2 = TapGDTNativeSplashSession.this.eventSink;
                    long j2 = this.apkSize;
                    adapterAdEventSink2.onDownloadFailure(j2, j2, TapGDTNativeSplashSession.this.currentBytes(boundAdData, j2), this.appName, "", -1, "");
                }
                if (status == 32) {
                    TapGDTNativeSplashSession.this.stopDownload();
                    AdapterAdEventSink adapterAdEventSink3 = TapGDTNativeSplashSession.this.eventSink;
                    long j3 = this.apkSize;
                    adapterAdEventSink3.onDownloadPause(j3, j3, TapGDTNativeSplashSession.this.currentBytes(boundAdData, j3), this.appName, "");
                }
            }
        });
        if (this.mediaView != null && getImageMode() == 2) {
            boundAdData.bindMediaView(this.mediaView, new VideoOption.Builder().setAutoPlayMuted(this.videoMuted).setAutoPlayPolicy(1).setNeedCoverImage(true).setNeedProgressBar(true).setEnableUserControl(false).build(), this.mediaListener);
        }
        if (!this.request.isDoubleWindow()) {
            boundAdData.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeSplashSession.2
                @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                public void onDownloadConfirm(Activity activity2, int i, String s, DownloadConfirmCallBack downloadConfirmCallBack) {
                    if (!TapGDTNativeSplashSession.this.released.get()) {
                        if (TapGDTNativeSplashSession.this.haveDownloading.get()) {
                            downloadConfirmCallBack.onCancel();
                            return;
                        } else {
                            downloadConfirmCallBack.onConfirm();
                            return;
                        }
                    }
                    downloadConfirmCallBack.onCancel();
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession
    public boolean updateSplashInteractionViews(List<View> clickViews, List<View> creativeViews, List<View> directDownloadViews) {
        NativeUnifiedADData current = this.adData;
        if (current == null || this.boundActivity == null || this.boundContainer == null || this.released.get()) {
            return false;
        }
        bindInteractionViews(current, this.boundActivity, this.boundContainer, this.boundAttributionParams, clickViews, creativeViews);
        AdapterNativeSplashBinding binding = this.boundBinding;
        if (binding != null && !this.released.get()) {
            binding.attachProviderAttributionView(this.boundAttributionParams);
            return true;
        }
        return true;
    }

    private static void bindInteractionViews(NativeUnifiedADData ad, Activity activity, NativeAdContainer container, FrameLayout.LayoutParams attributionParams, List<View> clickViews, List<View> creativeViews) {
        ad.bindAdToView(activity, container, attributionParams, creativeViews == null ? Collections.emptyList() : new ArrayList<>(creativeViews), clickViews == null ? Collections.emptyList() : new ArrayList<>(clickViews));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownload(String appName, long apkSize) {
        if (!this.released.get() && this.haveDownloading.compareAndSet(false, true)) {
            this.eventSink.onDownloadStart(apkSize, appName, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopDownload() {
        this.haveDownloading.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long currentBytes(NativeUnifiedADData downloadAdData, long apkSize) {
        try {
            int progress = Math.max(0, Math.min(100, downloadAdData.getProgress()));
            return (((long) progress) * apkSize) / 100;
        } catch (Exception e) {
            return 0L;
        }
    }

    private int resolveWidth(Context context) {
        if (this.request.getAcceptedImageWidthPx() > 0) {
            return this.request.getAcceptedImageWidthPx();
        }
        if (this.request.getCommon().getAcceptedWidthPx() > 0) {
            return this.request.getCommon().getAcceptedWidthPx();
        }
        return resolveScreenDimension(context, true);
    }

    private int resolveHeight(Context context) {
        if (this.request.getAcceptedImageHeightPx() > 0) {
            return this.request.getAcceptedImageHeightPx();
        }
        if (this.request.getCommon().getAcceptedHeightPx() > 0) {
            return this.request.getCommon().getAcceptedHeightPx();
        }
        return resolveScreenDimension(context, false);
    }

    private int resolveScreenDimension(Context context, boolean width) {
        int screenWidth = AdapterViewSupport.screenWidthPx(context);
        int screenHeight = AdapterViewSupport.screenHeightPx(context);
        if (this.request.getScreenOrientation() == 1) {
            return width ? Math.max(screenWidth, screenHeight) : Math.min(screenWidth, screenHeight);
        }
        if (this.request.getScreenOrientation() == 2) {
            return width ? Math.min(screenWidth, screenHeight) : Math.max(screenWidth, screenHeight);
        }
        return width ? screenWidth : screenHeight;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (!this.released.compareAndSet(false, true)) {
            return;
        }
        stopDownload();
        this.boundActivity = null;
        this.boundContainer = null;
        this.boundAttributionParams = null;
        this.boundBinding = null;
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

    @Override // com.tapsdk.tapad.group.adapter.AdapterSplashSession
    public long getExpirationTimestamp() {
        return this.expirationTimestamp;
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
}
