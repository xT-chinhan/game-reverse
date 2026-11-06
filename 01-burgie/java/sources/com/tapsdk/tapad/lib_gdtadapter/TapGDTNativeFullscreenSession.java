package com.tapsdk.tapad.lib_gdtadapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterAppComplianceInfo;
import com.tapsdk.tapad.group.adapter.AdapterNativeFullscreenBinding;
import com.tapsdk.tapad.group.adapter.AdapterNativeImage;
import com.tapsdk.tapad.group.adapter.AdapterNativeInterstitialSession;
import com.tapsdk.tapad.group.adapter.AdapterNativeRewardSession;
import com.tapsdk.tapad.lib_gdtadapter.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapGDTNativeFullscreenSession implements AdapterNativeRewardSession, AdapterNativeInterstitialSession {
    private static final int ATTRIBUTION_TAG_HEIGHT_DP = 16;
    private static final int ATTRIBUTION_TAG_WIDTH_DP = 34;
    private NativeUnifiedADData ad;
    private Activity boundActivity;
    private FrameLayout.LayoutParams boundAttributionParams;
    private AdapterNativeFullscreenBinding boundBinding;
    private NativeAdContainer boundContainer;
    private MediaView mediaView;
    private boolean videoMuted;
    private final AtomicBoolean released = new AtomicBoolean(false);
    private final AtomicBoolean bound = new AtomicBoolean(false);
    private final AtomicBoolean downloadStarted = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;

    TapGDTNativeFullscreenSession(NativeUnifiedADData ad) {
        this.ad = ad;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        NativeUnifiedADData current = this.ad;
        if (current == null) {
            return Collections.emptyMap();
        }
        return AdapterAdMetadata.fromProvider(current.getExtraInfo());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getIconUrl() {
        NativeUnifiedADData nativeUnifiedADData = this.ad;
        return nativeUnifiedADData == null ? "" : value(nativeUnifiedADData.getIconUrl());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public List<AdapterNativeImage> getImages() {
        NativeUnifiedADData nativeUnifiedADData = this.ad;
        if (nativeUnifiedADData == null || value(nativeUnifiedADData.getImgUrl()).isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.singletonList(new AdapterNativeImage(this.ad.getImgUrl(), Math.max(0, this.ad.getPictureWidth()), Math.max(0, this.ad.getPictureHeight())));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getTitle() {
        NativeUnifiedADData nativeUnifiedADData = this.ad;
        return nativeUnifiedADData == null ? "" : value(nativeUnifiedADData.getTitle());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getDescription() {
        NativeUnifiedADData nativeUnifiedADData = this.ad;
        return nativeUnifiedADData == null ? "" : value(nativeUnifiedADData.getDesc());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public long getApkSizeBytes() {
        NativeUnifiedADData nativeUnifiedADData = this.ad;
        NativeUnifiedADAppMiitInfo info = nativeUnifiedADData == null ? null : nativeUnifiedADData.getAppMiitInfo();
        if (info == null) {
            return 0L;
        }
        return Math.max(0L, info.getPackageSizeBytes());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public int getInteractionType() {
        NativeUnifiedADData nativeUnifiedADData = this.ad;
        return (nativeUnifiedADData == null || !nativeUnifiedADData.isAppAd()) ? 0 : 1;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public int getImageMode() {
        NativeUnifiedADData nativeUnifiedADData = this.ad;
        return (nativeUnifiedADData == null || nativeUnifiedADData.getAdPatternType() != 2) ? 1 : 2;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public AdapterAppComplianceInfo getComplianceInfo() {
        NativeUnifiedADData nativeUnifiedADData = this.ad;
        NativeUnifiedADAppMiitInfo info = nativeUnifiedADData == null ? null : nativeUnifiedADData.getAppMiitInfo();
        if (info == null) {
            return AdapterAppComplianceInfo.EMPTY;
        }
        return new AdapterAppComplianceInfo(info.getAppName(), info.getVersionName(), info.getAuthorName(), info.getPrivacyAgreement(), info.getDescriptionUrl(), info.getPermissionsUrl(), "");
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFullscreenSession
    public FrameLayout createActivityRoot(Activity activity) {
        return new NativeAdContainer(activity);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFullscreenSession
    public void bind(Activity activity, AdapterNativeFullscreenBinding binding) {
        final NativeUnifiedADData current = this.ad;
        FrameLayout root = binding.getHostRoot();
        if (current == null || this.released.get() || !(root instanceof NativeAdContainer) || !this.bound.compareAndSet(false, true)) {
            throw new IllegalStateException("GDT native full-screen provider is unavailable");
        }
        final NativeAdContainer container = (NativeAdContainer) root;
        this.boundActivity = activity;
        this.boundContainer = container;
        this.boundBinding = binding;
        ViewGroup mediaSlot = binding.getMediaSlot();
        NativeUnifiedADAppMiitInfo info = current.getAppMiitInfo();
        final String appName = value(info == null ? null : info.getAppName());
        final long apkSize = info != null ? Math.max(0L, info.getPackageSizeBytes()) : 0L;
        current.setNativeAdEventListener(new NativeADEventListenerWithClickInfo() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFullscreenSession.1
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                TapGDTNativeFullscreenSession.this.eventSink.onShow(container);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo
            public void onADClicked(View view) {
                TapGDTNativeFullscreenSession.this.eventSink.onClick(view);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError error) {
                TapGDTNativeFullscreenSession.this.eventSink.onRenderFailure(container, error == null ? -1 : error.getErrorCode(), error == null ? "" : error.getErrorMsg());
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
                int status = current.getAppStatus();
                int progress = Math.max(0, Math.min(100, current.getProgress()));
                long currentBytes = (apkSize * ((long) progress)) / 100;
                if (status == 4) {
                    if (TapGDTNativeFullscreenSession.this.downloadStarted.compareAndSet(false, true)) {
                        TapGDTNativeFullscreenSession.this.eventSink.onDownloadStart(apkSize, appName, "");
                    }
                    AdapterAdEventSink adapterAdEventSink = TapGDTNativeFullscreenSession.this.eventSink;
                    long j = apkSize;
                    adapterAdEventSink.onDownloadProgress(j, j, currentBytes, appName, "");
                    return;
                }
                if (status == 32) {
                    TapGDTNativeFullscreenSession.this.downloadStarted.set(false);
                    AdapterAdEventSink adapterAdEventSink2 = TapGDTNativeFullscreenSession.this.eventSink;
                    long j2 = apkSize;
                    adapterAdEventSink2.onDownloadPause(j2, j2, currentBytes, appName, "");
                    return;
                }
                if (status == 8) {
                    TapGDTNativeFullscreenSession.this.downloadStarted.set(false);
                    AdapterAdEventSink adapterAdEventSink3 = TapGDTNativeFullscreenSession.this.eventSink;
                    long j3 = apkSize;
                    adapterAdEventSink3.onDownloadComplete(j3, j3, appName, "");
                    return;
                }
                if (status == 1) {
                    TapGDTNativeFullscreenSession.this.eventSink.onInstalled(apkSize, appName, "");
                } else if (status == 16) {
                    TapGDTNativeFullscreenSession.this.downloadStarted.set(false);
                    AdapterAdEventSink adapterAdEventSink4 = TapGDTNativeFullscreenSession.this.eventSink;
                    long j4 = apkSize;
                    adapterAdEventSink4.onDownloadFailure(j4, j4, currentBytes, appName, "", -1, "");
                }
            }
        });
        FrameLayout.LayoutParams attributionParams = binding.createProviderAttributionLayoutParams(34, 16);
        this.boundAttributionParams = attributionParams;
        bindCreativeViews(current, activity, container, attributionParams, binding.getClickViews(), binding.getCreativeViews());
        binding.attachProviderAttributionView(attributionParams);
        if (getImageMode() == 2) {
            MediaView mediaView = new MediaView(activity);
            this.mediaView = mediaView;
            mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            mediaSlot.removeAllViews();
            mediaSlot.addView(this.mediaView);
            this.eventSink.onViewAcquired(this.mediaView);
            final int[] durationMs = {0};
            current.bindMediaView(this.mediaView, new VideoOption.Builder().setAutoPlayMuted(this.videoMuted).setAutoPlayPolicy(1).setNeedCoverImage(true).setNeedProgressBar(true).setEnableUserControl(false).build(), new NativeADMediaListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFullscreenSession.2
                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoInit() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoading() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoReady() {
                    TapGDTNativeFullscreenSession.this.eventSink.onVideoPrepared();
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoaded(int duration) {
                    durationMs[0] = Math.max(0, duration);
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStart() {
                    TapGDTNativeFullscreenSession.this.eventSink.onVideoStart();
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoPause() {
                    TapGDTNativeFullscreenSession.this.eventSink.onVideoPause();
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoResume() {
                    TapGDTNativeFullscreenSession.this.eventSink.onVideoResume();
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoCompleted() {
                    TapGDTNativeFullscreenSession.this.eventSink.onVideoComplete(durationMs[0]);
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoError(AdError error) {
                    TapGDTNativeFullscreenSession.this.eventSink.onVideoFailure(error == null ? -1 : error.getErrorCode(), error == null ? "" : error.getErrorMsg());
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStop() {
                    TapGDTNativeFullscreenSession.this.eventSink.onVideoPause();
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoClicked() {
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFullscreenSession
    public boolean updateFullscreenCreativeViews(List<View> creativeViews) {
        return updateFullscreenInteractionViews(Collections.emptyList(), creativeViews, Collections.emptyList());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFullscreenSession
    public boolean updateFullscreenInteractionViews(List<View> clickViews, List<View> creativeViews, List<View> directDownloadViews) {
        NativeUnifiedADData current = this.ad;
        Activity activity = this.boundActivity;
        NativeAdContainer container = this.boundContainer;
        FrameLayout.LayoutParams attributionParams = this.boundAttributionParams;
        if (current == null || activity == null || container == null || attributionParams == null || this.released.get() || !this.bound.get()) {
            return false;
        }
        bindCreativeViews(current, activity, container, attributionParams, clickViews, creativeViews);
        AdapterNativeFullscreenBinding binding = this.boundBinding;
        if (binding != null && !this.released.get()) {
            binding.attachProviderAttributionView(attributionParams);
            return true;
        }
        return true;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public boolean supportsVideoMuteControl() {
        return true;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public boolean isVideoMutedByDefault() {
        return this.videoMuted;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFullscreenSession
    public void setVideoMuted(boolean muted) {
        NativeUnifiedADData current = this.ad;
        if (current != null && !this.released.get()) {
            this.videoMuted = muted;
            current.setVideoMute(muted);
        }
    }

    private static void bindCreativeViews(NativeUnifiedADData current, Activity activity, NativeAdContainer container, FrameLayout.LayoutParams attributionParams, List<View> clickViews, List<View> creativeViews) {
        List<View> clicks;
        List<View> creatives;
        if (clickViews == null) {
            clicks = Collections.emptyList();
        } else {
            clicks = new ArrayList(clickViews);
        }
        if (creativeViews == null) {
            creatives = Collections.emptyList();
        } else {
            creatives = new ArrayList(creativeViews);
        }
        current.bindAdToView(activity, container, attributionParams, creatives, clicks);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (this.released.compareAndSet(false, true)) {
            this.boundActivity = null;
            this.boundContainer = null;
            this.boundAttributionParams = null;
            this.boundBinding = null;
            MediaView currentMedia = this.mediaView;
            this.mediaView = null;
            if (currentMedia != null) {
                ViewParent parent = currentMedia.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(currentMedia);
                }
            }
            NativeUnifiedADData current = this.ad;
            this.ad = null;
            if (current != null) {
                try {
                    current.setNativeAdEventListener(null);
                } catch (Throwable th) {
                }
                current.destroy();
            }
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        NativeUnifiedADData current = this.ad;
        return (this.released.get() || current == null || !current.isValid()) ? false : true;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        NativeUnifiedADData nativeUnifiedADData = this.ad;
        if (nativeUnifiedADData == null) {
            return 0L;
        }
        return nativeUnifiedADData.getECPM();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        NativeUnifiedADData nativeUnifiedADData = this.ad;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.sendWinNotification(Utils.getWinMap(secondPrice, winPrice));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        NativeUnifiedADData nativeUnifiedADData = this.ad;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.sendLossNotification(Utils.getLossMap(winPrice, lossReason, winBidder));
        }
    }

    private static String value(String input) {
        return input == null ? "" : input;
    }
}
