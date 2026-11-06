package com.tapsdk.tapad.lib_csjadapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterAppComplianceInfo;
import com.tapsdk.tapad.group.adapter.AdapterNativeFullscreenBinding;
import com.tapsdk.tapad.group.adapter.AdapterNativeImage;
import com.tapsdk.tapad.group.adapter.AdapterNativeInterstitialSession;
import com.tapsdk.tapad.group.adapter.AdapterNativeRewardSession;
import com.tapsdk.tapad.lib_csjadapter.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapCSJNativeFullscreenSession implements AdapterNativeRewardSession, AdapterNativeInterstitialSession {
    private TTFeedAd ad;
    private ViewGroup boundMediaSlot;
    private FrameLayout boundRoot;
    private final AtomicBoolean released = new AtomicBoolean(false);
    private final AtomicBoolean bound = new AtomicBoolean(false);
    private final AtomicBoolean downloadStarted = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;
    private final TTNativeAd.AdInteractionListener interactionListener = new TTNativeAd.AdInteractionListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJNativeFullscreenSession.1
        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd nativeAd) {
            TapCSJNativeFullscreenSession.this.eventSink.onClick(view);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd nativeAd) {
            TapCSJNativeFullscreenSession.this.eventSink.onCreativeClick(view);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd nativeAd) {
            FrameLayout root = TapCSJNativeFullscreenSession.this.boundRoot;
            TapCSJNativeFullscreenSession.this.eventSink.onShow(root);
        }
    };
    private final TTAppDownloadListener downloadListener = new TTAppDownloadListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJNativeFullscreenSession.2
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long totalBytes, long currentBytes, String fileName, String appName) {
            if (TapCSJNativeFullscreenSession.this.downloadStarted.compareAndSet(false, true)) {
                TapCSJNativeFullscreenSession.this.eventSink.onDownloadStart(TapCSJNativeFullscreenSession.this.getApkSizeBytes(), appName, fileName);
            }
            TapCSJNativeFullscreenSession.this.eventSink.onDownloadProgress(TapCSJNativeFullscreenSession.this.getApkSizeBytes(), totalBytes, currentBytes, appName, fileName);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long totalBytes, long currentBytes, String fileName, String appName) {
            TapCSJNativeFullscreenSession.this.downloadStarted.set(false);
            TapCSJNativeFullscreenSession.this.eventSink.onDownloadPause(TapCSJNativeFullscreenSession.this.getApkSizeBytes(), totalBytes, currentBytes, appName, fileName);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long totalBytes, long currentBytes, String fileName, String appName) {
            TapCSJNativeFullscreenSession.this.downloadStarted.set(false);
            TapCSJNativeFullscreenSession.this.eventSink.onDownloadFailure(TapCSJNativeFullscreenSession.this.getApkSizeBytes(), totalBytes, currentBytes, appName, fileName, -1, "");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long totalBytes, String fileName, String appName) {
            TapCSJNativeFullscreenSession.this.downloadStarted.set(false);
            TapCSJNativeFullscreenSession.this.eventSink.onDownloadComplete(TapCSJNativeFullscreenSession.this.getApkSizeBytes(), totalBytes, appName, fileName);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String fileName, String appName) {
            TapCSJNativeFullscreenSession.this.eventSink.onInstalled(TapCSJNativeFullscreenSession.this.getApkSizeBytes(), appName, fileName);
        }
    };
    private final TTFeedAd.VideoAdListener videoListener = new TTFeedAd.VideoAdListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJNativeFullscreenSession.3
        private long durationMs;

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoLoad(TTFeedAd ad) {
            TapCSJNativeFullscreenSession.this.eventSink.onVideoPrepared();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoError(int code, int extra) {
            TapCSJNativeFullscreenSession.this.eventSink.onVideoFailure(code, String.valueOf(extra));
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdStartPlay(TTFeedAd ad) {
            TapCSJNativeFullscreenSession.this.eventSink.onVideoStart();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdPaused(TTFeedAd ad) {
            TapCSJNativeFullscreenSession.this.eventSink.onVideoPause();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdContinuePlay(TTFeedAd ad) {
            TapCSJNativeFullscreenSession.this.eventSink.onVideoResume();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onProgressUpdate(long current, long total) {
            this.durationMs = Math.max(0L, total);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdComplete(TTFeedAd ad) {
            TapCSJNativeFullscreenSession.this.eventSink.onVideoComplete(this.durationMs);
        }
    };

    TapCSJNativeFullscreenSession(TTFeedAd ad) {
        this.ad = ad;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        TTFeedAd current = this.ad;
        if (current == null) {
            return Collections.emptyMap();
        }
        return AdapterAdMetadata.fromProvider(current.getMediaExtraInfo());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getIconUrl() {
        TTFeedAd tTFeedAd = this.ad;
        TTImage icon = tTFeedAd == null ? null : tTFeedAd.getIcon();
        return icon == null ? "" : value(icon.getImageUrl());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public List<AdapterNativeImage> getImages() {
        TTFeedAd current = this.ad;
        if (current == null) {
            return Collections.emptyList();
        }
        List<AdapterNativeImage> result = new ArrayList<>();
        if (isVideo(current)) {
            addImage(result, current.getVideoCoverImage());
        } else if (current.getImageList() != null) {
            for (TTImage image : current.getImageList()) {
                addImage(result, image);
            }
        }
        return result;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getTitle() {
        TTFeedAd tTFeedAd = this.ad;
        return tTFeedAd == null ? "" : value(tTFeedAd.getTitle());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public String getDescription() {
        TTFeedAd tTFeedAd = this.ad;
        return tTFeedAd == null ? "" : value(tTFeedAd.getDescription());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public long getApkSizeBytes() {
        TTFeedAd tTFeedAd = this.ad;
        if (tTFeedAd == null) {
            return 0L;
        }
        return Math.max(0L, tTFeedAd.getAppSize());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public int getInteractionType() {
        TTFeedAd tTFeedAd = this.ad;
        return (tTFeedAd == null || tTFeedAd.getInteractionType() != 4) ? 0 : 1;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public int getImageMode() {
        TTFeedAd tTFeedAd = this.ad;
        return (tTFeedAd == null || !isVideo(tTFeedAd)) ? 1 : 2;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public boolean supportsVideoMuteControl() {
        return false;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession
    public AdapterAppComplianceInfo getComplianceInfo() {
        TTFeedAd tTFeedAd = this.ad;
        ComplianceInfo info = tTFeedAd == null ? null : tTFeedAd.getComplianceInfo();
        if (info == null) {
            return AdapterAppComplianceInfo.EMPTY;
        }
        return new AdapterAppComplianceInfo(info.getAppName(), info.getAppVersion(), info.getDeveloperName(), info.getPrivacyUrl(), info.getFunctionDescUrl(), info.getPermissionUrl(), "");
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFullscreenSession
    public FrameLayout createActivityRoot(Activity activity) {
        return new FrameLayout(activity);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFullscreenSession
    public void bind(Activity activity, AdapterNativeFullscreenBinding binding) {
        TTFeedAd current = this.ad;
        if (current == null || this.released.get() || !this.bound.compareAndSet(false, true)) {
            throw new IllegalStateException("CSJ native full-screen provider is unavailable");
        }
        FrameLayout root = binding.getHostRoot();
        this.boundRoot = root;
        ViewGroup mediaSlot = binding.getMediaSlot();
        this.boundMediaSlot = mediaSlot;
        List<View> clickViews = binding.getClickViews();
        List<View> creativeViews = binding.getCreativeViews();
        try {
            Bitmap adLogo = current.getAdLogo();
            if (adLogo != null) {
                binding.applyProviderAttributionBitmap(adLogo);
            }
        } catch (Throwable th) {
        }
        current.setActivityForDownloadApp(activity);
        registerInteractionViews(current, root, clickViews, creativeViews, binding.getDirectDownloadViews());
        if (isVideo(current)) {
            View media = current.getAdView();
            this.eventSink.onViewAcquired(media);
            if (media == null) {
                throw new IllegalStateException("CSJ native full-screen video view is unavailable");
            }
            ViewParent parent = media.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(media);
            }
            mediaSlot.removeAllViews();
            mediaSlot.addView(media, new ViewGroup.LayoutParams(-1, -1));
        }
        current.setDownloadListener(this.downloadListener);
        if (isVideo(current)) {
            current.setVideoAdListener(this.videoListener);
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFullscreenSession
    public boolean updateFullscreenCreativeViews(List<View> creativeViews) {
        return updateFullscreenInteractionViews(Collections.emptyList(), creativeViews, Collections.emptyList());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFullscreenSession
    public boolean updateFullscreenInteractionViews(List<View> clickViews, List<View> creativeViews, List<View> directDownloadViews) {
        TTFeedAd current = this.ad;
        FrameLayout root = this.boundRoot;
        if (current == null || root == null || this.released.get() || !this.bound.get()) {
            return false;
        }
        registerInteractionViews(current, root, clickViews, creativeViews, directDownloadViews);
        return true;
    }

    private void registerInteractionViews(TTFeedAd current, FrameLayout root, List<View> clickViews, List<View> creativeViews, List<View> directDownloadViews) {
        List<View> clicks;
        List<View> creatives;
        List<View> directDownloads;
        if (clickViews == null) {
            clicks = new ArrayList<>();
        } else {
            clicks = new ArrayList<>(clickViews);
        }
        ViewGroup viewGroup = this.boundMediaSlot;
        if (viewGroup != null && !clicks.contains(viewGroup)) {
            clicks.add(this.boundMediaSlot);
        }
        if (creativeViews == null) {
            creatives = Collections.emptyList();
        } else {
            creatives = new ArrayList(creativeViews);
        }
        if (directDownloadViews == null) {
            directDownloads = Collections.emptyList();
        } else {
            directDownloads = new ArrayList(directDownloadViews);
        }
        current.registerViewForInteraction(root, (List<View>) null, clicks, creatives, directDownloads, (View) null, this.interactionListener);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (this.released.compareAndSet(false, true)) {
            TTFeedAd current = this.ad;
            this.ad = null;
            this.boundRoot = null;
            this.boundMediaSlot = null;
            if (current != null) {
                try {
                    current.setDownloadListener(null);
                } catch (Exception e) {
                }
                try {
                    current.setVideoAdListener(null);
                } catch (Exception e2) {
                }
                current.destroy();
            }
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return (this.released.get() || this.ad == null) ? false : true;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        TTFeedAd tTFeedAd = this.ad;
        if (tTFeedAd == null) {
            return 0L;
        }
        return Utils.getCSJPrice(tTFeedAd);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        TTFeedAd tTFeedAd = this.ad;
        if (tTFeedAd != null) {
            tTFeedAd.win(Double.valueOf(secondPrice));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        TTFeedAd tTFeedAd = this.ad;
        if (tTFeedAd != null) {
            tTFeedAd.loss(Double.valueOf(winPrice), "102", winBidder);
        }
    }

    private static boolean isVideo(TTFeedAd ad) {
        int mode = ad.getImageMode();
        return mode == 5 || mode == 15;
    }

    private static void addImage(List<AdapterNativeImage> result, TTImage image) {
        if (image != null && !value(image.getImageUrl()).isEmpty()) {
            result.add(new AdapterNativeImage(image.getImageUrl(), image.getWidth(), image.getHeight()));
        }
    }

    private static String value(String input) {
        return input == null ? "" : input;
    }
}
