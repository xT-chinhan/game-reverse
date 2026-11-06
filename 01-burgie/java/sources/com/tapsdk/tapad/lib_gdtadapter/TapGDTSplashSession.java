package com.tapsdk.tapad.lib_gdtadapter;

import android.view.ViewGroup;
import com.qq.e.ads.splash.SplashAD;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterHostedSplashSession;
import com.tapsdk.tapad.lib_gdtadapter.utils.Utils;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class TapGDTSplashSession implements AdapterHostedSplashSession {
    private SplashAD ad;
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;
    private final long expirationTimestamp;

    TapGDTSplashSession(SplashAD ad, long expirationTimestamp) {
        this.ad = ad;
        this.expirationTimestamp = expirationTimestamp;
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

    @Override // com.tapsdk.tapad.group.adapter.AdapterHostedSplashSession
    public void show(ViewGroup container) {
        SplashAD current = this.ad;
        if (current != null) {
            current.showAd(container);
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
        SplashAD current = this.ad;
        return current != null && current.isValid();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        SplashAD current = this.ad;
        if (current == null) {
            return 0L;
        }
        return current.getECPM();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        SplashAD current = this.ad;
        if (current == null) {
            return Collections.emptyMap();
        }
        return AdapterAdMetadata.fromProvider(current.getExtraInfo());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        SplashAD current = this.ad;
        if (current != null) {
            current.sendWinNotification(Utils.getWinMap(secondPrice, winPrice));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        SplashAD current = this.ad;
        if (current != null) {
            current.sendLossNotification(Utils.getLossMap(winPrice, lossReason, winBidder));
        }
    }
}
