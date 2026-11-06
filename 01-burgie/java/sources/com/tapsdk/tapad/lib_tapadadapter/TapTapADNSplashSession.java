package com.tapsdk.tapad.lib_tapadadapter;

import android.view.ViewGroup;
import com.tapsdk.tapad.TapSplashAd;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterHostedSplashSession;
import com.tapsdk.tapad.lib_tapadadapter.utils.Utils;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapTapADNSplashSession implements AdapterHostedSplashSession {
    private TapSplashAd ad;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;

    public TapTapADNSplashSession(TapSplashAd tapSplashAd) {
        if (tapSplashAd == null) {
            throw new IllegalArgumentException("missing TapADN Splash ad");
        }
        this.ad = tapSplashAd;
        tapSplashAd.setSplashInteractionListener(new TapSplashAd.AdInteractionListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNSplashSession.1
            @Override // com.tapsdk.tapad.TapSplashAd.AdInteractionListener
            public void onAdClick() {
                if (TapTapADNSplashSession.this.destroyed.get()) {
                    return;
                }
                TapTapADNSplashSession.this.eventSink.onClick(null);
            }

            @Override // com.tapsdk.tapad.TapSplashAd.AdInteractionListener
            public void onAdShow() {
                if (TapTapADNSplashSession.this.destroyed.get()) {
                    return;
                }
                TapTapADNSplashSession.this.eventSink.onShow(null);
            }

            @Override // com.tapsdk.tapad.TapSplashAd.AdInteractionListener
            public void onAdSkip() {
                if (TapTapADNSplashSession.this.destroyed.get()) {
                    return;
                }
                TapTapADNSplashSession.this.eventSink.onClose();
            }

            @Override // com.tapsdk.tapad.TapSplashAd.AdInteractionListener
            public void onAdTimeOver() {
                if (TapTapADNSplashSession.this.destroyed.get()) {
                    return;
                }
                TapTapADNSplashSession.this.eventSink.onTimeOver();
            }

            @Override // com.tapsdk.tapad.TapSplashAd.AdInteractionListener
            public void onAdValidShow() {
                if (TapTapADNSplashSession.this.destroyed.get()) {
                    return;
                }
                TapTapADNSplashSession.this.eventSink.onShow(null);
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (this.destroyed.compareAndSet(false, true)) {
            TapSplashAd tapSplashAd = this.ad;
            this.ad = null;
            if (tapSplashAd != null) {
                try {
                    tapSplashAd.setSplashInteractionListener(null);
                } catch (Exception e) {
                }
                tapSplashAd.dispose();
            }
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterSplashSession
    public long getExpirationTimestamp() {
        TapSplashAd tapSplashAd = this.ad;
        if (tapSplashAd == null) {
            return 0L;
        }
        return tapSplashAd.getExpirationTimestamp();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        TapSplashAd tapSplashAd = this.ad;
        Map<String, Object> mediaExtraInfo = tapSplashAd == null ? null : tapSplashAd.getMediaExtraInfo();
        return mediaExtraInfo == null ? Collections.EMPTY_MAP : mediaExtraInfo;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        TapSplashAd tapSplashAd = this.ad;
        if (tapSplashAd == null) {
            return 0L;
        }
        return tapSplashAd.getPrice();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        TapSplashAd tapSplashAd = this.ad;
        return (this.destroyed.get() || tapSplashAd == null || !tapSplashAd.isValid()) ? false : true;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long j, String str, String str2) {
        TapSplashAd tapSplashAd = this.ad;
        if (tapSplashAd != null) {
            tapSplashAd.sendLossNotification(Utils.getLossMap(j, str, str2));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long j, long j2, String str) {
        TapSplashAd tapSplashAd = this.ad;
        if (tapSplashAd != null) {
            tapSplashAd.sendWinNotification(Utils.getWinMap(j, j2));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink adapterAdEventSink) {
        if (adapterAdEventSink == null) {
            adapterAdEventSink = AdapterAdEventSink.NONE;
        }
        this.eventSink = adapterAdEventSink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterHostedSplashSession
    public void show(ViewGroup viewGroup) {
        TapSplashAd tapSplashAd = this.ad;
        if (tapSplashAd == null) {
            this.eventSink.onRenderFailure(viewGroup, -1, "TapADN Splash ad is released");
        } else {
            tapSplashAd.show(viewGroup);
        }
    }
}
