package com.tapsdk.tapad.lib_tapadadapter;

import android.app.Activity;
import com.tapsdk.tapad.TapRewardVideoAd;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterHostedRewardSession;
import com.tapsdk.tapad.lib_tapadadapter.utils.Utils;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapTapADNRewardSession implements AdapterHostedRewardSession {
    private final TapRewardVideoAd ad;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;

    public TapTapADNRewardSession(TapRewardVideoAd tapRewardVideoAd) {
        this.ad = tapRewardVideoAd;
        tapRewardVideoAd.setRewardAdInteractionListener(new TapRewardVideoAd.RewardAdInteractionListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNRewardSession.1
            @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
            public void onAdClick(TapRewardVideoAd tapRewardVideoAd2) {
                TapTapADNRewardSession.this.eventSink.onClick(null);
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
            public void onAdClose(TapRewardVideoAd tapRewardVideoAd2) {
                TapTapADNRewardSession.this.eventSink.onClose();
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
            public void onAdShow(TapRewardVideoAd tapRewardVideoAd2) {
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
            public void onAdValidShow(TapRewardVideoAd tapRewardVideoAd2) {
                TapTapADNRewardSession.this.eventSink.onShow(null);
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(TapRewardVideoAd tapRewardVideoAd2, boolean z, int i, String str, int i2, String str2) {
                TapTapADNRewardSession.this.eventSink.onRewardVerify(z, i, str, i2, str2);
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
            public void onSkippedVideo(TapRewardVideoAd tapRewardVideoAd2) {
                TapTapADNRewardSession.this.eventSink.onSkip();
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
            public void onVideoComplete(TapRewardVideoAd tapRewardVideoAd2) {
                TapTapADNRewardSession.this.eventSink.onVideoComplete(0L);
            }

            @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
            public void onVideoError(TapRewardVideoAd tapRewardVideoAd2) {
                TapTapADNRewardSession.this.eventSink.onVideoFailure(-1, "");
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
        return this.destroyed.get() ? Collections.EMPTY_MAP : this.ad.getMediaExtraInfo();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        if (this.destroyed.get()) {
            return 0L;
        }
        return this.ad.getPrice();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return !this.destroyed.get() && this.ad.isValid();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long j, String str, String str2) {
        if (this.destroyed.get()) {
            return;
        }
        this.ad.sendLossNotification(Utils.getLossMap(j, str, str2));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long j, long j2, String str) {
        if (this.destroyed.get()) {
            return;
        }
        this.ad.sendWinNotification(Utils.getWinMap(j, j2));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink adapterAdEventSink) {
        if (adapterAdEventSink == null) {
            adapterAdEventSink = AdapterAdEventSink.NONE;
        }
        this.eventSink = adapterAdEventSink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterHostedRewardSession
    public void show(Activity activity) {
        if (this.destroyed.get()) {
            return;
        }
        this.ad.showRewardVideoAd(activity);
    }
}
