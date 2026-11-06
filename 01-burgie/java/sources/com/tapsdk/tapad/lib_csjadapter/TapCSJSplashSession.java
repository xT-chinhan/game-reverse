package com.tapsdk.tapad.lib_csjadapter;

import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterHostedSplashSession;
import com.tapsdk.tapad.lib_csjadapter.utils.Utils;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapCSJSplashSession implements AdapterHostedSplashSession {
    private static final long DEFAULT_EXPIRATION_MILLIS = 1800000;
    private CSJSplashAd ad;
    private final long expirationTimestamp = System.currentTimeMillis() + DEFAULT_EXPIRATION_MILLIS;
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;

    TapCSJSplashSession(CSJSplashAd ad) {
        this.ad = ad;
        bindEvents(ad);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    private void bindEvents(CSJSplashAd providerAd) {
        providerAd.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJSplashSession.1
            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdShow(CSJSplashAd ad) {
                TapCSJSplashSession.this.eventSink.onShow(null);
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClick(CSJSplashAd ad) {
                TapCSJSplashSession.this.eventSink.onClick(null);
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClose(CSJSplashAd ad, int reason) {
                TapCSJSplashSession.this.eventSink.onClose();
            }
        });
        providerAd.setDownloadListener(new TTAppDownloadListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJSplashSession.2
            private final AtomicBoolean downloading = new AtomicBoolean(false);
            private final AtomicBoolean finished = new AtomicBoolean(false);
            private final AtomicBoolean installed = new AtomicBoolean(false);

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long total, long current, String file, String app) {
                if (this.downloading.compareAndSet(false, true)) {
                    TapCSJSplashSession.this.eventSink.onDownloadStart(total, app, file);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long total, long current, String file, String app) {
                this.downloading.set(false);
                TapCSJSplashSession.this.eventSink.onDownloadPause(total, total, current, app, file);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long total, long current, String file, String app) {
                this.downloading.set(false);
                TapCSJSplashSession.this.eventSink.onDownloadFailure(total, total, current, app, file, -1, "");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long total, String file, String app) {
                if (this.finished.compareAndSet(false, true)) {
                    TapCSJSplashSession.this.eventSink.onDownloadComplete(total, total, app, file);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String file, String app) {
                if (this.installed.compareAndSet(false, true)) {
                    TapCSJSplashSession.this.eventSink.onInstalled(0L, app, file);
                }
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterHostedSplashSession
    public void show(ViewGroup container) {
        CSJSplashAd current = this.ad;
        if (current != null) {
            current.showSplashView(container);
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterSplashSession
    public long getExpirationTimestamp() {
        return this.expirationTimestamp;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        this.ad = null;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return this.ad != null;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        CSJSplashAd cSJSplashAd = this.ad;
        if (cSJSplashAd == null) {
            return 0L;
        }
        return Utils.getCSJPrice(cSJSplashAd);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        CSJSplashAd current = this.ad;
        if (current == null) {
            return Collections.emptyMap();
        }
        return AdapterAdMetadata.fromProvider(current.getMediaExtraInfo());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        CSJSplashAd current = this.ad;
        if (current != null) {
            current.win(Double.valueOf(secondPrice));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        CSJSplashAd current = this.ad;
        if (current != null) {
            current.loss(Double.valueOf(winPrice), "102", winBidder);
        }
    }
}
