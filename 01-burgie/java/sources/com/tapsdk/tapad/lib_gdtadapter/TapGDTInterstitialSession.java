package com.tapsdk.tapad.lib_gdtadapter;

import android.app.Activity;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.util.AdError;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterHostedInterstitialSession;
import com.tapsdk.tapad.lib_gdtadapter.utils.Utils;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapGDTInterstitialSession implements AdapterHostedInterstitialSession {
    private final UnifiedInterstitialAD ad;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;
    private final boolean fullScreen;

    TapGDTInterstitialSession(UnifiedInterstitialAD ad, boolean fullScreen) {
        this.ad = ad;
        this.fullScreen = fullScreen;
        ad.setMediaListener(new UnifiedInterstitialMediaListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTInterstitialSession.1
            private long duration;

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoLoading() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoReady(long duration) {
                this.duration = duration;
                TapGDTInterstitialSession.this.eventSink.onVideoPrepared();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoStart() {
                TapGDTInterstitialSession.this.eventSink.onVideoStart();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPause() {
                TapGDTInterstitialSession.this.eventSink.onVideoPause();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoComplete() {
                TapGDTInterstitialSession.this.eventSink.onVideoComplete(this.duration);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoError(AdError error) {
                TapGDTInterstitialSession.this.eventSink.onVideoFailure(error.getErrorCode(), error.getErrorMsg());
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageOpen() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageClose() {
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    void onShow() {
        this.eventSink.onShow(null);
    }

    void onClick() {
        this.eventSink.onClick(null);
    }

    void onClose() {
        this.eventSink.onClose();
    }

    void onRenderSuccess() {
        this.eventSink.onRenderSuccess(null, 0.0f, 0.0f);
    }

    void onRenderFailure() {
        this.eventSink.onRenderFailure(null, -1, "");
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterHostedInterstitialSession
    public void show(Activity activity) {
        if (this.fullScreen) {
            this.ad.showFullScreenAD(activity);
        } else {
            this.ad.show(activity);
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (this.destroyed.compareAndSet(false, true)) {
            this.ad.destroy();
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return !this.destroyed.get() && this.ad.isValid();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        return this.ad.getECPM();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        Map<String, Object> extra = this.ad.getExtraInfo();
        if (extra == null) {
            return Collections.emptyMap();
        }
        return AdapterAdMetadata.fromProvider(extra);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        this.ad.sendWinNotification(Utils.getWinMap(secondPrice, winPrice));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        this.ad.sendLossNotification(Utils.getLossMap(winPrice, lossReason, winBidder));
    }
}
