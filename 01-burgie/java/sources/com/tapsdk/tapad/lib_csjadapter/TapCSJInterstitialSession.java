package com.tapsdk.tapad.lib_csjadapter;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterHostedInterstitialSession;
import com.tapsdk.tapad.lib_csjadapter.utils.Utils;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapCSJInterstitialSession implements AdapterHostedInterstitialSession {
    private TTFullScreenVideoAd ad;
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;

    TapCSJInterstitialSession(TTFullScreenVideoAd ad) {
        this.ad = ad;
        bindInteractionEvents(ad);
        bindDownloadEvents(ad);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    private void bindInteractionEvents(TTFullScreenVideoAd providerAd) {
        providerAd.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJInterstitialSession.1
            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdShow() {
                TapCSJInterstitialSession.this.eventSink.onShow(null);
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdVideoBarClick() {
                TapCSJInterstitialSession.this.eventSink.onClick(null);
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdClose() {
                TapCSJInterstitialSession.this.eventSink.onClose();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoComplete() {
                TapCSJInterstitialSession.this.eventSink.onVideoComplete(0L);
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onSkippedVideo() {
                TapCSJInterstitialSession.this.eventSink.onSkip();
            }
        });
    }

    private void bindDownloadEvents(TTFullScreenVideoAd providerAd) {
        providerAd.setDownloadListener(new TTAppDownloadListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJInterstitialSession.2
            private final AtomicBoolean downloading = new AtomicBoolean(false);
            private final AtomicBoolean finished = new AtomicBoolean(false);
            private final AtomicBoolean installed = new AtomicBoolean(false);

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long totalBytes, long currentBytes, String fileName, String appName) {
                if (this.downloading.compareAndSet(false, true)) {
                    TapCSJInterstitialSession.this.eventSink.onDownloadStart(totalBytes, appName, fileName);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long totalBytes, long currentBytes, String fileName, String appName) {
                this.downloading.set(false);
                TapCSJInterstitialSession.this.eventSink.onDownloadPause(totalBytes, totalBytes, currentBytes, appName, fileName);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long totalBytes, long currentBytes, String fileName, String appName) {
                this.downloading.set(false);
                TapCSJInterstitialSession.this.eventSink.onDownloadFailure(totalBytes, totalBytes, currentBytes, appName, fileName, -1, "");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long totalBytes, String fileName, String appName) {
                if (this.finished.compareAndSet(false, true)) {
                    TapCSJInterstitialSession.this.eventSink.onDownloadComplete(totalBytes, totalBytes, appName, fileName);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String fileName, String appName) {
                if (this.installed.compareAndSet(false, true)) {
                    TapCSJInterstitialSession.this.eventSink.onInstalled(0L, appName, fileName);
                }
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterHostedInterstitialSession
    public void show(Activity activity) {
        TTFullScreenVideoAd current = this.ad;
        if (current != null) {
            current.showFullScreenVideoAd(activity);
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        this.ad = null;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        TTFullScreenVideoAd current = this.ad;
        return current != null && current.getExpirationTimestamp() > System.currentTimeMillis();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        TTFullScreenVideoAd current = this.ad;
        if (current == null) {
            return 0L;
        }
        return Utils.getCSJPrice(current);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        TTFullScreenVideoAd current = this.ad;
        if (current == null) {
            return Collections.emptyMap();
        }
        return AdapterAdMetadata.fromProvider(current.getMediaExtraInfo());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        TTFullScreenVideoAd current = this.ad;
        if (current != null) {
            current.win(Double.valueOf(secondPrice));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        TTFullScreenVideoAd current = this.ad;
        if (current != null) {
            current.loss(Double.valueOf(winPrice), "102", winBidder);
        }
    }
}
