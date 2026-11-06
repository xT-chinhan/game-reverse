package com.tapsdk.tapad.lib_tapadadapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tapsdk.tapad.ComplianceInfo;
import com.tapsdk.tapad.TapAppDownloadListener;
import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAppComplianceInfo;
import com.tapsdk.tapad.group.adapter.AdapterNativeImage;
import com.tapsdk.tapad.group.adapter.AdapterNativeSplashBinding;
import com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession;
import com.tapsdk.tapad.lib_tapadadapter.utils.Utils;
import com.tapsdk.tapad.model.entities.ImageInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapTapADNNativeSplashSession implements AdapterNativeSplashSession {
    private static final long DEFAULT_EXPIRATION_MILLIS = 1800000;
    private TapFeedAd ad;
    private final WeakReference<Context> contextRef;
    private final boolean doubleWindow;
    private volatile FrameLayout mediaView;
    private final long expirationTimestamp = System.currentTimeMillis() + DEFAULT_EXPIRATION_MILLIS;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;
    private final TapAppDownloadListener downloadListener = new TapAppDownloadListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNNativeSplashSession.2
        private static final String FILE_NAME = "";
        private long currentBytes;

        @Override // com.tapsdk.tapad.TapAppDownloadListener
        public void onDownloadComplete() {
            if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                return;
            }
            long apkSizeBytes = TapTapADNNativeSplashSession.this.getApkSizeBytes();
            TapTapADNNativeSplashSession.this.eventSink.onDownloadComplete(apkSizeBytes, apkSizeBytes, TapTapADNNativeSplashSession.this.getComplianceInfo().getAppName(), "");
        }

        @Override // com.tapsdk.tapad.TapAppDownloadListener
        public void onDownloadError() {
            if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                return;
            }
            long apkSizeBytes = TapTapADNNativeSplashSession.this.getApkSizeBytes();
            TapTapADNNativeSplashSession.this.eventSink.onDownloadFailure(apkSizeBytes, apkSizeBytes, this.currentBytes, TapTapADNNativeSplashSession.this.getComplianceInfo().getAppName(), "", -1, "");
        }

        @Override // com.tapsdk.tapad.TapAppDownloadListener
        public void onDownloadPause() {
            if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                return;
            }
            long apkSizeBytes = TapTapADNNativeSplashSession.this.getApkSizeBytes();
            TapTapADNNativeSplashSession.this.eventSink.onDownloadPause(apkSizeBytes, apkSizeBytes, this.currentBytes, TapTapADNNativeSplashSession.this.getComplianceInfo().getAppName(), "");
        }

        @Override // com.tapsdk.tapad.TapAppDownloadListener
        public void onDownloadStart() {
            if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                return;
            }
            TapTapADNNativeSplashSession.this.eventSink.onDownloadStart(TapTapADNNativeSplashSession.this.getApkSizeBytes(), TapTapADNNativeSplashSession.this.getComplianceInfo().getAppName(), "");
        }

        @Override // com.tapsdk.tapad.TapAppDownloadListener
        public void onIdle() {
        }

        @Override // com.tapsdk.tapad.TapAppDownloadListener
        public void onInstalled() {
            if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                return;
            }
            TapTapADNNativeSplashSession.this.eventSink.onInstalled(TapTapADNNativeSplashSession.this.getApkSizeBytes(), TapTapADNNativeSplashSession.this.getComplianceInfo().getAppName(), "");
        }

        @Override // com.tapsdk.tapad.TapAppDownloadListener
        public void onUpdateDownloadProgress(int i) {
            if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                return;
            }
            this.currentBytes = (TapTapADNNativeSplashSession.this.getApkSizeBytes() * ((long) Math.max(0, Math.min(100, i)))) / 100;
        }
    };
    private final TapFeedAd.VideoAdListener videoListener = new TapFeedAd.VideoAdListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNNativeSplashSession.3
        @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
        public void onVideoError(TapFeedAd tapFeedAd, int i, String str) {
            if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                return;
            }
            TapTapADNNativeSplashSession.this.eventSink.onVideoFailure(i, str);
        }

        @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
        public void onVideoPause(TapFeedAd tapFeedAd) {
            if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                return;
            }
            TapTapADNNativeSplashSession.this.eventSink.onVideoPause();
        }

        @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
        public void onVideoPrepared(TapFeedAd tapFeedAd) {
            if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                return;
            }
            TapTapADNNativeSplashSession.this.eventSink.onVideoPrepared();
        }

        @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
        public void onVideoStart(TapFeedAd tapFeedAd) {
            if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                return;
            }
            TapTapADNNativeSplashSession.this.eventSink.onVideoStart();
        }

        @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
        public void onVideoVolumeClose(TapFeedAd tapFeedAd) {
        }

        @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
        public void onVideoVolumeOpen(TapFeedAd tapFeedAd) {
        }
    };

    public TapTapADNNativeSplashSession(Context context, TapFeedAd tapFeedAd, boolean z) {
        if (tapFeedAd == null) {
            throw new IllegalArgumentException("missing TapADN native Splash ad");
        }
        this.contextRef = new WeakReference<>(context);
        this.ad = tapFeedAd;
        this.doubleWindow = z;
    }

    private void bindMediaView(TapFeedAd tapFeedAd) {
        View adView;
        FrameLayout frameLayout = this.mediaView;
        if (frameLayout == null || getImageMode() != 2 || (adView = tapFeedAd.getAdView()) == null) {
            return;
        }
        ViewParent parent = adView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(adView);
        }
        frameLayout.removeAllViews();
        frameLayout.addView(adView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.requestLayout();
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession
    public void bind(Activity activity, AdapterNativeSplashBinding adapterNativeSplashBinding) {
        TapFeedAd tapFeedAd = this.ad;
        if (tapFeedAd == null) {
            throw new IllegalStateException("TapADN native Splash ad is released");
        }
        adapterNativeSplashBinding.installProviderContainer(new FrameLayout(activity));
        final FrameLayout hostContainer = adapterNativeSplashBinding.getHostContainer();
        tapFeedAd.setIsSelfDoubleWindow(this.doubleWindow);
        tapFeedAd.registerViewForInteraction(activity, hostContainer, adapterNativeSplashBinding.getClickViews(), adapterNativeSplashBinding.getCreativeViews(), null, null, null, new TapFeedAd.AdInteractionListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNNativeSplashSession.1
            @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
            public void onAdClicked(View view, TapFeedAd tapFeedAd2) {
                if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                    return;
                }
                TapTapADNNativeSplashSession.this.eventSink.onClick(view);
            }

            @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
            public void onAdCreativeClick(View view, TapFeedAd tapFeedAd2) {
                if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                    return;
                }
                TapTapADNNativeSplashSession.this.eventSink.onClick(view);
            }

            @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
            public void onAdShow(TapFeedAd tapFeedAd2) {
            }

            @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
            public void onAdValidView(TapFeedAd tapFeedAd2) {
                if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                    return;
                }
                TapTapADNNativeSplashSession.this.eventSink.onShow(hostContainer);
            }

            @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
            public void onDistinctAdShow(TapFeedAd tapFeedAd2) {
            }

            @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
            public void onDownloadWindowConfirm(TapFeedAd tapFeedAd2) {
                if (TapTapADNNativeSplashSession.this.destroyed.get()) {
                    return;
                }
                TapTapADNNativeSplashSession.this.eventSink.onDownloadWindowConfirm();
            }
        });
        bindMediaView(tapFeedAd);
        tapFeedAd.setDownloadListener(this.downloadListener);
        tapFeedAd.setVideoAdListener(this.videoListener);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (this.destroyed.compareAndSet(false, true)) {
            TapFeedAd tapFeedAd = this.ad;
            this.ad = null;
            if (tapFeedAd != null) {
                try {
                    tapFeedAd.setDownloadListener(null);
                } catch (Exception e) {
                }
                try {
                    tapFeedAd.setVideoAdListener(null);
                } catch (Exception e2) {
                }
                tapFeedAd.dispose();
            }
            this.mediaView = null;
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public long getApkSizeBytes() {
        TapFeedAd tapFeedAd = this.ad;
        if (tapFeedAd == null) {
            return 0L;
        }
        return tapFeedAd.getApkSizeBytes();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public AdapterAppComplianceInfo getComplianceInfo() {
        TapFeedAd tapFeedAd = this.ad;
        ComplianceInfo complianceInfo = tapFeedAd == null ? null : tapFeedAd.getComplianceInfo();
        return complianceInfo == null ? AdapterAppComplianceInfo.EMPTY : new AdapterAppComplianceInfo(complianceInfo.getAppName(), complianceInfo.getAppVersion(), complianceInfo.getDeveloperName(), complianceInfo.getPrivacyUrl(), complianceInfo.getFunctionDescUrl(), complianceInfo.getPermissionUrl(), complianceInfo.getAdLogIconUrl());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getDescription() {
        TapFeedAd tapFeedAd = this.ad;
        return tapFeedAd == null ? "" : safe(tapFeedAd.getDescription());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterSplashSession
    public long getExpirationTimestamp() {
        return this.expirationTimestamp;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getIconUrl() {
        TapFeedAd tapFeedAd = this.ad;
        return tapFeedAd == null ? "" : safe(tapFeedAd.getIconUrl());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public int getImageMode() {
        TapFeedAd tapFeedAd = this.ad;
        return (tapFeedAd == null || tapFeedAd.getImageMode() != 2) ? 1 : 2;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public List<AdapterNativeImage> getImages() {
        TapFeedAd tapFeedAd = this.ad;
        if (tapFeedAd == null || tapFeedAd.getImageInfoList() == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (ImageInfo imageInfo : tapFeedAd.getImageInfoList()) {
            if (imageInfo != null) {
                arrayList.add(new AdapterNativeImage(imageInfo.imageUrl, imageInfo.width, imageInfo.height));
            }
        }
        return arrayList;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public int getInteractionType() {
        TapFeedAd tapFeedAd = this.ad;
        return (tapFeedAd == null || tapFeedAd.getInteractionType() != 1) ? 0 : 1;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession
    public View getMediaView(Context context) {
        if (getImageMode() != 2) {
            return null;
        }
        FrameLayout frameLayout = this.mediaView;
        if (frameLayout != null) {
            return frameLayout;
        }
        if (context == null) {
            context = this.contextRef.get();
        }
        if (context == null) {
            return null;
        }
        this.mediaView = new FrameLayout(context);
        this.mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return this.mediaView;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        TapFeedAd tapFeedAd = this.ad;
        Map<String, Object> mediaExtraInfo = tapFeedAd == null ? null : tapFeedAd.getMediaExtraInfo();
        return mediaExtraInfo == null ? Collections.EMPTY_MAP : mediaExtraInfo;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        TapFeedAd tapFeedAd = this.ad;
        if (tapFeedAd == null) {
            return 0L;
        }
        return tapFeedAd.getPrice();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getTitle() {
        TapFeedAd tapFeedAd = this.ad;
        return tapFeedAd == null ? "" : safe(tapFeedAd.getTitle());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        TapFeedAd tapFeedAd = this.ad;
        return (this.destroyed.get() || tapFeedAd == null || !tapFeedAd.isValid()) ? false : true;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long j, String str, String str2) {
        TapFeedAd tapFeedAd = this.ad;
        if (tapFeedAd != null) {
            tapFeedAd.sendLossNotification(Utils.getLossMap(j, str, str2));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long j, long j2, String str) {
        TapFeedAd tapFeedAd = this.ad;
        if (tapFeedAd != null) {
            tapFeedAd.sendWinNotification(Utils.getWinMap(j, j2));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink adapterAdEventSink) {
        if (adapterAdEventSink == null) {
            adapterAdEventSink = AdapterAdEventSink.NONE;
        }
        this.eventSink = adapterAdEventSink;
    }
}
