package com.tapsdk.tapad.lib_gdtadapter;

import android.app.Activity;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterHostedRewardSession;
import com.tapsdk.tapad.lib_gdtadapter.utils.Utils;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapGDTRewardSession implements AdapterHostedRewardSession {
    private final RewardVideoAD ad;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;

    TapGDTRewardSession(RewardVideoAD ad) {
        this.ad = ad;
    }

    AdapterAdEventSink eventSink() {
        return this.destroyed.get() ? AdapterAdEventSink.NONE : this.eventSink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterHostedRewardSession
    public void show(Activity activity) {
        if (!this.destroyed.get()) {
            this.ad.showAD(activity);
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        this.destroyed.set(true);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return !this.destroyed.get() && this.ad.isValid();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        if (this.destroyed.get()) {
            return 0L;
        }
        return this.ad.getECPM();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        if (this.destroyed.get()) {
            return Collections.emptyMap();
        }
        return AdapterAdMetadata.fromProvider(this.ad.getExtraInfo());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        if (!this.destroyed.get()) {
            this.ad.sendWinNotification(Utils.getWinMap(secondPrice, winPrice));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        if (!this.destroyed.get()) {
            this.ad.sendLossNotification(Utils.getLossMap(winPrice, lossReason, winBidder));
        }
    }
}
