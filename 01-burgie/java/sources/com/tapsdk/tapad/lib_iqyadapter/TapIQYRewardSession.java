package com.tapsdk.tapad.lib_iqyadapter;

import android.app.Activity;
import com.mar.sdk.IAction;
import com.mcto.sspsdk.IQyRewardVideoAd;
import com.mcto.sspsdk.QyRewardProperty;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterHostedRewardSession;
import com.tapsdk.tapad.group.adapter.AdapterRewardLoadRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapIQYRewardSession implements AdapterHostedRewardSession {
    private final IQyRewardVideoAd ad;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;
    private final AdapterRewardLoadRequest request;

    TapIQYRewardSession(IQyRewardVideoAd ad, final AdapterRewardLoadRequest request) {
        this.ad = ad;
        this.request = request;
        ad.setRewardVideoAdInteractionListener(new IQyRewardVideoAd.IAdInteractionListener() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYRewardSession.1
            @Override // com.mcto.sspsdk.IQyRewardVideoAd.IAdInteractionListener
            public void onAdShow() {
                TapIQYRewardSession.this.eventSink.onShow(null);
            }

            @Override // com.mcto.sspsdk.IQyRewardVideoAd.IAdInteractionListener
            public void onAdClick() {
                TapIQYRewardSession.this.eventSink.onClick(null);
            }

            @Override // com.mcto.sspsdk.IQyRewardVideoAd.IAdInteractionListener
            public void onRewardVerify(HashMap<String, Object> metadata) {
                TapIQYRewardSession.this.eventSink.onRewardVerify(true, request.getRewardAmount(), request.getRewardName(), 0, "");
            }

            @Override // com.mcto.sspsdk.IQyRewardVideoAd.IAdInteractionListener
            public void onAdClose() {
                TapIQYRewardSession.this.eventSink.onClose();
            }

            @Override // com.mcto.sspsdk.IQyRewardVideoAd.IAdInteractionListener
            public void onVideoComplete() {
                TapIQYRewardSession.this.eventSink.onVideoComplete(0L);
            }

            @Override // com.mcto.sspsdk.IQyRewardVideoAd.IAdInteractionListener
            public void onVideoError(int code, String message) {
                TapIQYRewardSession.this.eventSink.onVideoFailure(code, message);
            }

            @Override // com.mcto.sspsdk.IQyRewardVideoAd.IAdInteractionListener
            public void onAdNextShow() {
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterHostedRewardSession
    public void show(Activity activity) {
        if (!this.destroyed.get()) {
            this.ad.showRewardVideoAd(activity);
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
        Map<String, String> extra = extra();
        try {
            if (!extra.containsKey(IAction.PurchaseKey.Price)) {
                return 0L;
            }
            return Long.parseLong(extra.get(IAction.PurchaseKey.Price));
        } catch (Exception e) {
            return 0L;
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        Map<String, String> extra = extra();
        Map<String, Object> result = new HashMap<>();
        if (extra.containsKey(QyRewardProperty.VERIFY_IMPRESSIONID)) {
            result.put(Constants.Bidding.REQUEST_ID, extra.get(QyRewardProperty.VERIFY_IMPRESSIONID));
        }
        if (extra.containsKey(IAction.PurchaseKey.Price)) {
            result.put(IAction.PurchaseKey.Price, extra.get(IAction.PurchaseKey.Price));
        }
        return AdapterAdMetadata.fromProvider(result);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        IQYBidInfoReporter.reportWin(extra().get(QyRewardProperty.VERIFY_IMPRESSIONID), this.request.getCommon().getPlacementId(), 5564, secondPrice, followBidder);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        IQYBidInfoReporter.reportLoss(extra().get(QyRewardProperty.VERIFY_IMPRESSIONID), this.request.getCommon().getPlacementId(), 5564, winPrice, winBidder, 1);
    }

    private Map<String, String> extra() {
        Map<String, String> extra;
        if (!this.destroyed.get() && (extra = this.ad.getAdExtra()) != null) {
            return extra;
        }
        return Collections.emptyMap();
    }
}
