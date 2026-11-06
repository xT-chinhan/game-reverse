package com.tapsdk.tapad.lib_tapadadapter;

import android.app.Activity;
import com.tapsdk.tapad.TapInterstitialAd;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterHostedInterstitialSession;
import com.tapsdk.tapad.lib_tapadadapter.utils.Utils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapTapADNInterstitialSession implements AdapterHostedInterstitialSession {
    private final TapInterstitialAd ad;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;

    public TapTapADNInterstitialSession(TapInterstitialAd tapInterstitialAd) {
        this.ad = tapInterstitialAd;
        tapInterstitialAd.setInteractionListener(new TapInterstitialAd.InterstitialAdInteractionListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNInterstitialSession.1
            @Override // com.tapsdk.tapad.TapInterstitialAd.InterstitialAdInteractionListener
            public void onAdClick() {
                TapTapADNInterstitialSession.this.eventSink.onClick(null);
            }

            @Override // com.tapsdk.tapad.TapInterstitialAd.InterstitialAdInteractionListener
            public void onAdClose() {
                TapTapADNInterstitialSession.this.eventSink.onClose();
            }

            @Override // com.tapsdk.tapad.TapInterstitialAd.InterstitialAdInteractionListener
            public void onAdError() {
                TapTapADNInterstitialSession.this.eventSink.onRenderFailure(null, -1, "");
            }

            @Override // com.tapsdk.tapad.TapInterstitialAd.InterstitialAdInteractionListener
            public void onAdShow() {
                TapTapADNInterstitialSession.this.eventSink.onShow(null);
            }

            @Override // com.tapsdk.tapad.TapInterstitialAd.InterstitialAdInteractionListener
            public void onAdValidShow() {
                TapTapADNInterstitialSession.this.eventSink.onShow(null);
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (this.destroyed.compareAndSet(false, true)) {
            this.ad.dispose();
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        return this.ad.getMediaExtraInfo();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        return this.ad.getPrice();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return !this.destroyed.get() && this.ad.isValid();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long j, String str, String str2) {
        this.ad.sendLossNotification(Utils.getLossMap(j, str, str2));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long j, long j2, String str) {
        this.ad.sendWinNotification(Utils.getWinMap(j, j2));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink adapterAdEventSink) {
        if (adapterAdEventSink == null) {
            adapterAdEventSink = AdapterAdEventSink.NONE;
        }
        this.eventSink = adapterAdEventSink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterHostedInterstitialSession
    public void show(Activity activity) {
        this.ad.show(activity);
    }
}
