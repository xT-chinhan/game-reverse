package com.tapsdk.tapad.lib_csjadapter;

import android.app.Activity;
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
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedBinding;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession;
import com.tapsdk.tapad.group.adapter.AdapterNativeImage;
import com.tapsdk.tapad.lib_csjadapter.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class TapCSJNativeFeedSession implements AdapterNativeFeedSession {
    private final TTFeedAd feedAd;
    private AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    final TTAppDownloadListener downloadListener = new TTAppDownloadListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJNativeFeedSession.1
        final AtomicBoolean isDownloading = new AtomicBoolean(false);
        final AtomicBoolean hasFinished = new AtomicBoolean(false);
        final AtomicBoolean hasInstalled = new AtomicBoolean(false);

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long l, long l1, String s, String s1) {
            if (l > 0) {
                TapCSJNativeFeedSession.this.eventSink.onDownloadProgress(TapCSJNativeFeedSession.this.feedAd.getAppSize(), l, l1, s1, s);
            }
            if (this.isDownloading.compareAndSet(false, true)) {
                TapCSJNativeFeedSession.this.eventSink.onDownloadStart(TapCSJNativeFeedSession.this.feedAd.getAppSize(), s1, s);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long l, long l1, String s, String s1) {
            this.isDownloading.set(false);
            TapCSJNativeFeedSession.this.eventSink.onDownloadPause(TapCSJNativeFeedSession.this.feedAd.getAppSize(), l, l1, s1, s);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long l, long l1, String s, String s1) {
            this.isDownloading.set(false);
            TapCSJNativeFeedSession.this.eventSink.onDownloadFailure(TapCSJNativeFeedSession.this.feedAd.getAppSize(), l, l1, s1, s, -1, "");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long l, String s, String s1) {
            if (this.hasFinished.compareAndSet(false, true)) {
                TapCSJNativeFeedSession.this.eventSink.onDownloadComplete(TapCSJNativeFeedSession.this.feedAd.getAppSize(), l, s1, s);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String s, String s1) {
            if (this.hasInstalled.compareAndSet(false, true)) {
                TapCSJNativeFeedSession.this.eventSink.onInstalled(TapCSJNativeFeedSession.this.feedAd.getAppSize(), s1, s);
            }
        }
    };

    public TapCSJNativeFeedSession(TTFeedAd ad) {
        this.feedAd = ad;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        return AdapterAdMetadata.fromProvider(this.feedAd.getMediaExtraInfo());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getIconUrl() {
        return this.feedAd.getIcon().getImageUrl();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public List<AdapterNativeImage> getImages() {
        List<AdapterNativeImage> res = new ArrayList<>();
        for (TTImage ttImage : this.feedAd.getImageList()) {
            res.add(new AdapterNativeImage(ttImage.getImageUrl(), ttImage.getWidth(), ttImage.getHeight()));
        }
        return res;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getTitle() {
        return this.feedAd.getTitle();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getDescription() {
        return this.feedAd.getDescription();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getApkSize() {
        return String.valueOf(this.feedAd.getAppSize());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public long getApkSizeBytes() {
        return this.feedAd.getAppSize();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public int getInteractionType() {
        if (this.feedAd.getInteractionType() == 4) {
            return 1;
        }
        return 0;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public int getImageMode() {
        int mode = this.feedAd.getImageMode();
        return (mode == 5 || mode == 15) ? 2 : 1;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public float getScore() {
        return this.feedAd.getAppScore();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public AdapterAppComplianceInfo getComplianceInfo() {
        ComplianceInfo info = this.feedAd.getComplianceInfo();
        if (info == null) {
            return AdapterAppComplianceInfo.EMPTY;
        }
        return new AdapterAppComplianceInfo(info.getAppName(), info.getAppVersion(), info.getDeveloperName(), info.getPrivacyUrl(), info.getFunctionDescUrl(), info.getPermissionUrl(), "");
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public void bind(Activity activity, AdapterNativeFeedBinding adapterNativeFeedBinding) {
        final FrameLayout container = adapterNativeFeedBinding.getContainer();
        List<View> clickViews = adapterNativeFeedBinding.getClickViews();
        List<View> creativeViews = adapterNativeFeedBinding.getCreativeViews();
        FrameLayout newContainer = new FrameLayout(activity);
        adapterNativeFeedBinding.installProviderContainer(newContainer);
        this.feedAd.setActivityForDownloadApp(activity);
        FrameLayout logoContainer = new FrameLayout(activity);
        ImageView imageView = new ImageView(activity);
        imageView.setImageBitmap(this.feedAd.getAdLogo());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        logoContainer.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        adapterNativeFeedBinding.addOverlay(logoContainer);
        this.feedAd.registerViewForInteraction(container, (List<View>) null, clickViews, adapterNativeFeedBinding.isDoubleWindow() ? creativeViews : Collections.emptyList(), adapterNativeFeedBinding.isDoubleWindow() ? Collections.emptyList() : creativeViews, (View) null, new TTNativeAd.AdInteractionListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJNativeFeedSession.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view, TTNativeAd ttNativeAd) {
                TapCSJNativeFeedSession.this.eventSink.onClick(view);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view, TTNativeAd ttNativeAd) {
                TapCSJNativeFeedSession.this.eventSink.onCreativeClick(view);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd ttNativeAd) {
                TapCSJNativeFeedSession.this.eventSink.onShow(container);
            }
        });
        this.feedAd.setDownloadListener(this.downloadListener);
        this.feedAd.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJNativeFeedSession.3
            long duration;

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoLoad(TTFeedAd ttFeedAd) {
                TapCSJNativeFeedSession.this.eventSink.onVideoPrepared();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoError(int i, int i1) {
                TapCSJNativeFeedSession.this.eventSink.onVideoFailure(i, String.valueOf(i1));
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdStartPlay(TTFeedAd ttFeedAd) {
                TapCSJNativeFeedSession.this.eventSink.onVideoStart();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdPaused(TTFeedAd ttFeedAd) {
                TapCSJNativeFeedSession.this.eventSink.onVideoPause();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdContinuePlay(TTFeedAd ttFeedAd) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onProgressUpdate(long l, long l1) {
                this.duration = l1;
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdComplete(TTFeedAd ttFeedAd) {
                TapCSJNativeFeedSession.this.eventSink.onVideoComplete(this.duration);
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public View getMediaView() {
        return this.feedAd.getAdView();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (this.destroyed.compareAndSet(false, true)) {
            this.feedAd.destroy();
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return !this.destroyed.get();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        if (this.destroyed.get()) {
            return 0L;
        }
        return Utils.getCSJPrice(this.feedAd);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        if (!this.destroyed.get()) {
            this.feedAd.win(Double.valueOf(secondPrice));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        if (!this.destroyed.get()) {
            this.feedAd.loss(Double.valueOf(winPrice), "102", winBidder);
        }
    }
}
