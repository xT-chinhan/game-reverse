package com.tapsdk.tapad.lib_csjadapter;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterHostedRewardSession;
import com.tapsdk.tapad.lib_csjadapter.utils.Utils;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapCSJRewardSession implements AdapterHostedRewardSession {
    private TTRewardVideoAd ad;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;

    TapCSJRewardSession(TTRewardVideoAd ad) {
        this.ad = ad;
        ad.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJRewardSession.1
            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdShow() {
                TapCSJRewardSession.this.eventSink.onShow(null);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdVideoBarClick() {
                TapCSJRewardSession.this.eventSink.onClick(null);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdClose() {
                TapCSJRewardSession.this.eventSink.onClose();
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoComplete() {
                TapCSJRewardSession.this.eventSink.onVideoComplete(0L);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoError() {
                TapCSJRewardSession.this.eventSink.onVideoFailure(-1, "");
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(boolean success, int amount, String name, int code, String message) {
                TapCSJRewardSession.this.eventSink.onRewardVerify(success, amount, name, code, message);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardArrived(boolean success, int rewardType, Bundle metadata) {
                int amount = 0;
                String name = "";
                int code = success ? 0 : -1;
                String message = "";
                if (metadata != null) {
                    amount = metadata.getInt("reward_extra_key_reward_amount", 0);
                    name = metadata.getString("reward_extra_key_reward_name", "");
                    code = metadata.getInt("reward_extra_key_error_code", code);
                    message = metadata.getString("reward_extra_key_error_msg", "");
                }
                TapCSJRewardSession.this.eventSink.onRewardVerify(success, amount, name, code, message);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onSkippedVideo() {
                TapCSJRewardSession.this.eventSink.onSkip();
            }
        });
        ad.setDownloadListener(new TTAppDownloadListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJRewardSession.2
            private final AtomicBoolean downloading = new AtomicBoolean(false);
            private final AtomicBoolean finished = new AtomicBoolean(false);
            private final AtomicBoolean installed = new AtomicBoolean(false);

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long totalBytes, long currentBytes, String fileName, String appName) {
                if (this.downloading.compareAndSet(false, true)) {
                    TapCSJRewardSession.this.eventSink.onDownloadStart(totalBytes, appName, fileName);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long totalBytes, long currentBytes, String fileName, String appName) {
                this.downloading.set(false);
                TapCSJRewardSession.this.eventSink.onDownloadPause(totalBytes, totalBytes, currentBytes, appName, fileName);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long totalBytes, long currentBytes, String fileName, String appName) {
                this.downloading.set(false);
                TapCSJRewardSession.this.eventSink.onDownloadFailure(totalBytes, totalBytes, currentBytes, appName, fileName, -1, "");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long totalBytes, String fileName, String appName) {
                this.downloading.set(false);
                if (this.finished.compareAndSet(false, true)) {
                    TapCSJRewardSession.this.eventSink.onDownloadComplete(totalBytes, totalBytes, appName, fileName);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String fileName, String appName) {
                if (this.installed.compareAndSet(false, true)) {
                    TapCSJRewardSession.this.eventSink.onInstalled(0L, appName, fileName);
                }
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterHostedRewardSession
    public void show(Activity activity) {
        TTRewardVideoAd current = this.ad;
        if (!this.destroyed.get() && current != null) {
            current.showRewardVideoAd(activity);
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (this.destroyed.compareAndSet(false, true)) {
            this.ad = null;
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        TTRewardVideoAd current = this.ad;
        return (this.destroyed.get() || current == null || current.getExpirationTimestamp() <= System.currentTimeMillis()) ? false : true;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        TTRewardVideoAd current = this.ad;
        if (current == null) {
            return Collections.emptyMap();
        }
        return AdapterAdMetadata.fromProvider(current.getMediaExtraInfo());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        TTRewardVideoAd tTRewardVideoAd = this.ad;
        if (tTRewardVideoAd == null) {
            return 0L;
        }
        return Utils.getCSJPrice(tTRewardVideoAd);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        TTRewardVideoAd tTRewardVideoAd = this.ad;
        if (tTRewardVideoAd != null) {
            tTRewardVideoAd.win(Double.valueOf(secondPrice));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        TTRewardVideoAd tTRewardVideoAd = this.ad;
        if (tTRewardVideoAd != null) {
            tTRewardVideoAd.loss(Double.valueOf(winPrice), "102", winBidder);
        }
    }
}
