package com.tapsdk.tapad.lib_csjadapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterAppComplianceInfo;
import com.tapsdk.tapad.group.adapter.AdapterNativeImage;
import com.tapsdk.tapad.group.adapter.AdapterNativeSplashBinding;
import com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession;
import com.tapsdk.tapad.group.adapter.AdapterViewSupport;
import com.tapsdk.tapad.lib_csjadapter.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapCSJNativeSplashSession implements AdapterNativeSplashSession {
    private static final long DEFAULT_EXPIRATION_MILLIS = 1800000;
    private View adLogoView;
    private FrameLayout boundContainer;
    private final boolean doubleWindow;
    private TTFeedAd feedAd;
    private final AtomicBoolean released = new AtomicBoolean(false);
    private final long expirationTimestamp = System.currentTimeMillis() + DEFAULT_EXPIRATION_MILLIS;
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;
    private final TTAppDownloadListener downloadListener = new TTAppDownloadListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJNativeSplashSession.2
        private final AtomicBoolean isDownloading = new AtomicBoolean(false);
        private final AtomicBoolean hasFinished = new AtomicBoolean(false);
        private final AtomicBoolean hasInstalled = new AtomicBoolean(false);

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
            if (!TapCSJNativeSplashSession.this.released.get() && this.isDownloading.compareAndSet(false, true)) {
                TapCSJNativeSplashSession.this.eventSink.onDownloadStart(TapCSJNativeSplashSession.this.getApkSizeBytes(), appName, fileName);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
            if (TapCSJNativeSplashSession.this.released.get()) {
                return;
            }
            this.isDownloading.set(false);
            TapCSJNativeSplashSession.this.eventSink.onDownloadPause(TapCSJNativeSplashSession.this.getApkSizeBytes(), totalBytes, currBytes, appName, fileName);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
            if (TapCSJNativeSplashSession.this.released.get()) {
                return;
            }
            this.isDownloading.set(false);
            TapCSJNativeSplashSession.this.eventSink.onDownloadFailure(TapCSJNativeSplashSession.this.getApkSizeBytes(), totalBytes, currBytes, appName, fileName, -1, "");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long totalBytes, String fileName, String appName) {
            if (!TapCSJNativeSplashSession.this.released.get() && this.hasFinished.compareAndSet(false, true)) {
                TapCSJNativeSplashSession.this.eventSink.onDownloadComplete(TapCSJNativeSplashSession.this.getApkSizeBytes(), totalBytes, appName, fileName);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String fileName, String appName) {
            if (!TapCSJNativeSplashSession.this.released.get() && this.hasInstalled.compareAndSet(false, true)) {
                TapCSJNativeSplashSession.this.eventSink.onInstalled(TapCSJNativeSplashSession.this.getApkSizeBytes(), appName, fileName);
            }
        }
    };
    private final TTFeedAd.VideoAdListener videoAdListener = new TTFeedAd.VideoAdListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJNativeSplashSession.3
        private long duration;

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoLoad(TTFeedAd ttFeedAd) {
            if (!TapCSJNativeSplashSession.this.released.get()) {
                TapCSJNativeSplashSession.this.eventSink.onVideoPrepared();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoError(int code, int extra) {
            if (!TapCSJNativeSplashSession.this.released.get()) {
                TapCSJNativeSplashSession.this.eventSink.onVideoFailure(code, String.valueOf(extra));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdStartPlay(TTFeedAd ttFeedAd) {
            if (!TapCSJNativeSplashSession.this.released.get()) {
                TapCSJNativeSplashSession.this.eventSink.onVideoStart();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdPaused(TTFeedAd ttFeedAd) {
            if (!TapCSJNativeSplashSession.this.released.get()) {
                TapCSJNativeSplashSession.this.eventSink.onVideoPause();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdContinuePlay(TTFeedAd ttFeedAd) {
            if (!TapCSJNativeSplashSession.this.released.get()) {
                TapCSJNativeSplashSession.this.eventSink.onVideoResume();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onProgressUpdate(long current, long duration) {
            if (TapCSJNativeSplashSession.this.released.get()) {
                return;
            }
            this.duration = duration;
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdComplete(TTFeedAd ttFeedAd) {
            if (!TapCSJNativeSplashSession.this.released.get()) {
                TapCSJNativeSplashSession.this.eventSink.onVideoComplete(this.duration);
            }
        }
    };

    TapCSJNativeSplashSession(TTFeedAd feedAd, boolean doubleWindow) {
        this.feedAd = feedAd;
        this.doubleWindow = doubleWindow;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        TTFeedAd tTFeedAd = this.feedAd;
        return tTFeedAd == null ? Collections.emptyMap() : AdapterAdMetadata.fromProvider(tTFeedAd.getMediaExtraInfo());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getIconUrl() {
        TTFeedAd tTFeedAd = this.feedAd;
        TTImage icon = tTFeedAd == null ? null : tTFeedAd.getIcon();
        return icon == null ? "" : icon.getImageUrl();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public List<AdapterNativeImage> getImages() {
        TTFeedAd tTFeedAd = this.feedAd;
        if (tTFeedAd == null || tTFeedAd.getImageList() == null) {
            return Collections.emptyList();
        }
        List<AdapterNativeImage> res = new ArrayList<>();
        for (TTImage ttImage : this.feedAd.getImageList()) {
            if (ttImage != null) {
                res.add(new AdapterNativeImage(ttImage.getImageUrl(), ttImage.getWidth(), ttImage.getHeight()));
            }
        }
        return res;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getTitle() {
        TTFeedAd tTFeedAd = this.feedAd;
        return tTFeedAd == null ? "" : tTFeedAd.getTitle();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getDescription() {
        TTFeedAd tTFeedAd = this.feedAd;
        return tTFeedAd == null ? "" : tTFeedAd.getDescription();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public long getApkSizeBytes() {
        TTFeedAd tTFeedAd = this.feedAd;
        if (tTFeedAd == null) {
            return 0L;
        }
        return tTFeedAd.getAppSize();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public int getInteractionType() {
        TTFeedAd tTFeedAd = this.feedAd;
        if (tTFeedAd != null && tTFeedAd.getInteractionType() == 4) {
            return 1;
        }
        return 0;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public int getImageMode() {
        TTFeedAd tTFeedAd = this.feedAd;
        if (tTFeedAd == null) {
            return 1;
        }
        int mode = tTFeedAd.getImageMode();
        return (mode == 5 || mode == 15) ? 2 : 1;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public AdapterAppComplianceInfo getComplianceInfo() {
        TTFeedAd tTFeedAd = this.feedAd;
        ComplianceInfo info = tTFeedAd == null ? null : tTFeedAd.getComplianceInfo();
        if (info == null) {
            return AdapterAppComplianceInfo.EMPTY;
        }
        return new AdapterAppComplianceInfo(info.getAppName(), info.getAppVersion(), info.getDeveloperName(), info.getPrivacyUrl(), info.getFunctionDescUrl(), info.getPermissionUrl(), "");
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession
    public View getMediaView(Context context) {
        TTFeedAd tTFeedAd = this.feedAd;
        if (tTFeedAd == null) {
            return null;
        }
        return tTFeedAd.getAdView();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession
    public void bind(Activity activity, AdapterNativeSplashBinding binding) {
        TTFeedAd boundFeedAd = this.feedAd;
        if (boundFeedAd == null) {
            throw new IllegalStateException("csj native ad is null");
        }
        FrameLayout newContainer = new FrameLayout(activity);
        binding.installProviderContainer(newContainer);
        FrameLayout adContainer = binding.getHostContainer();
        this.boundContainer = adContainer;
        List<View> clickViews = binding.getClickViews();
        List<View> creativeViews = binding.getCreativeViews();
        Bitmap adLogo = boundFeedAd.getAdLogo();
        if (!binding.applyProviderAttributionBitmap(adLogo)) {
            addCsjAdLogo(activity, adContainer, adLogo, binding.getAdLogoLayoutParams());
        }
        boundFeedAd.setActivityForDownloadApp(activity);
        registerInteractionViews(boundFeedAd, adContainer, clickViews, creativeViews, Collections.emptyList());
        boundFeedAd.setDownloadListener(this.downloadListener);
        boundFeedAd.setVideoAdListener(this.videoAdListener);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession
    public boolean updateSplashInteractionViews(List<View> clickViews, List<View> creativeViews, List<View> directDownloadViews) {
        TTFeedAd current = this.feedAd;
        FrameLayout container = this.boundContainer;
        if (current == null || container == null || this.released.get()) {
            return false;
        }
        registerInteractionViews(current, container, clickViews, creativeViews, directDownloadViews);
        return true;
    }

    private void registerInteractionViews(TTFeedAd ad, final FrameLayout container, List<View> clickViews, List<View> creativeViews, List<View> directDownloadViews) {
        List<View> creatives = this.doubleWindow ? safeViews(creativeViews) : Collections.emptyList();
        List<View> directDownloads = this.doubleWindow ? safeViews(directDownloadViews) : safeViews(creativeViews);
        ad.registerViewForInteraction(container, (List<View>) null, safeViews(clickViews), creatives, directDownloads, (View) null, new TTNativeAd.AdInteractionListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJNativeSplashSession.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view, TTNativeAd ttNativeAd) {
                if (!TapCSJNativeSplashSession.this.released.get()) {
                    TapCSJNativeSplashSession.this.eventSink.onClick(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view, TTNativeAd ttNativeAd) {
                if (!TapCSJNativeSplashSession.this.released.get()) {
                    TapCSJNativeSplashSession.this.eventSink.onCreativeClick(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd ttNativeAd) {
                if (!TapCSJNativeSplashSession.this.released.get()) {
                    TapCSJNativeSplashSession.this.eventSink.onShow(container);
                }
            }
        });
    }

    private static List<View> safeViews(List<View> views) {
        return (views == null || views.isEmpty()) ? Collections.emptyList() : new ArrayList(views);
    }

    private void addCsjAdLogo(Activity activity, FrameLayout frameLayout, Bitmap adLogo, FrameLayout.LayoutParams params) {
        View view = this.adLogoView;
        if ((view != null && view.getParent() != null) || adLogo == null) {
            return;
        }
        FrameLayout logoContainer = new FrameLayout(activity);
        ImageView imageView = new ImageView(activity);
        imageView.setImageBitmap(adLogo);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        logoContainer.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        if (params == null) {
            params = new FrameLayout.LayoutParams(AdapterViewSupport.dpToPx(activity, 32.0f), AdapterViewSupport.dpToPx(activity, 14.0f));
        }
        params.width = AdapterViewSupport.dpToPx(activity, 32.0f);
        params.height = AdapterViewSupport.dpToPx(activity, 14.0f);
        frameLayout.addView(logoContainer, params);
        this.adLogoView = logoContainer;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (!this.released.compareAndSet(false, true)) {
            return;
        }
        TTFeedAd currentFeedAd = this.feedAd;
        this.feedAd = null;
        this.boundContainer = null;
        this.adLogoView = null;
        if (currentFeedAd != null) {
            try {
                currentFeedAd.setDownloadListener(null);
            } catch (Exception e) {
            }
            try {
                currentFeedAd.setVideoAdListener(null);
            } catch (Exception e2) {
            }
            currentFeedAd.destroy();
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return this.feedAd != null;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterSplashSession
    public long getExpirationTimestamp() {
        return this.expirationTimestamp;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        TTFeedAd tTFeedAd = this.feedAd;
        if (tTFeedAd == null) {
            return 0L;
        }
        return Utils.getCSJPrice(tTFeedAd);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        TTFeedAd tTFeedAd = this.feedAd;
        if (tTFeedAd != null) {
            tTFeedAd.win(Double.valueOf(secondPrice));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        TTFeedAd tTFeedAd = this.feedAd;
        if (tTFeedAd != null) {
            tTFeedAd.loss(Double.valueOf(winPrice), "102", winBidder);
        }
    }
}
