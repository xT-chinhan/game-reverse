package com.tapsdk.tapad.lib_iqyadapter;

import android.app.Activity;
import com.mar.sdk.IAction;
import com.mcto.sspsdk.IQyFullScreenAd;
import com.mcto.sspsdk.QyRewardProperty;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterHostedInterstitialSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapIQYInterstitialSession implements AdapterHostedInterstitialSession {
    private final IQyFullScreenAd ad;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;
    private final String placementId;

    TapIQYInterstitialSession(IQyFullScreenAd ad, String placementId) {
        this.ad = ad;
        this.placementId = placementId;
        ad.setAdInteractionListener(new IQyFullScreenAd.AdInteractionListener() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYInterstitialSession.1
            @Override // com.mcto.sspsdk.IQyFullScreenAd.AdInteractionListener
            public void onAdShow() {
                TapIQYInterstitialSession.this.eventSink.onShow(null);
            }

            @Override // com.mcto.sspsdk.IQyFullScreenAd.AdInteractionListener
            public void onAdClick() {
                TapIQYInterstitialSession.this.eventSink.onClick(null);
            }

            @Override // com.mcto.sspsdk.IQyFullScreenAd.AdInteractionListener
            public void onError(int code, String message) {
                TapIQYInterstitialSession.this.eventSink.onRenderFailure(null, code, message);
            }

            @Override // com.mcto.sspsdk.IQyFullScreenAd.AdInteractionListener
            public void onAdClose() {
                TapIQYInterstitialSession.this.eventSink.onClose();
            }

            @Override // com.mcto.sspsdk.IQyFullScreenAd.AdInteractionListener
            public void onVideoComplete() {
                TapIQYInterstitialSession.this.eventSink.onVideoComplete(0L);
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterHostedInterstitialSession
    public void show(Activity activity) {
        this.ad.showAd(activity);
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
        String price = extras().get(IAction.PurchaseKey.Price);
        if (price == null) {
            return 0L;
        }
        try {
            return Long.parseLong(price);
        } catch (RuntimeException e) {
            return 0L;
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        Map<String, String> source = extras();
        Map<String, Object> result = new HashMap<>();
        if (source.containsKey(QyRewardProperty.VERIFY_IMPRESSIONID)) {
            result.put(Constants.Bidding.REQUEST_ID, source.get(QyRewardProperty.VERIFY_IMPRESSIONID));
        }
        if (source.containsKey(IAction.PurchaseKey.Price)) {
            result.put(IAction.PurchaseKey.Price, source.get(IAction.PurchaseKey.Price));
        }
        return AdapterAdMetadata.fromProvider(result);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        IQYBidInfoReporter.reportWin(extras().get(QyRewardProperty.VERIFY_IMPRESSIONID), this.placementId, 5564, secondPrice, followBidder);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        IQYBidInfoReporter.reportLoss(extras().get(QyRewardProperty.VERIFY_IMPRESSIONID), this.placementId, 5564, winPrice, winBidder, 1);
    }

    private Map<String, String> extras() {
        Map<String, String> extra = this.ad.getAdExtra();
        return extra == null ? Collections.emptyMap() : extra;
    }
}
