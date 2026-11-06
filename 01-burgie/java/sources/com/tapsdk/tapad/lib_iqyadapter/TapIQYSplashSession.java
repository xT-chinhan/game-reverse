package com.tapsdk.tapad.lib_iqyadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.mar.sdk.IAction;
import com.mcto.sspsdk.IQySplash;
import com.mcto.sspsdk.QyRewardProperty;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterHostedSplashSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapIQYSplashSession implements AdapterHostedSplashSession {
    private IQySplash ad;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;
    private final String placementId;

    TapIQYSplashSession(IQySplash ad, String placementId) {
        this.ad = ad;
        this.placementId = placementId;
        ad.setSplashInteractionListener(new IQySplash.IAdInteractionListener() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYSplashSession.1
            @Override // com.mcto.sspsdk.IQySplash.IAdInteractionListener
            public void onAdClick() {
                TapIQYSplashSession.this.eventSink.onClick(null);
            }

            @Override // com.mcto.sspsdk.IQySplash.IAdInteractionListener
            public void onAdShow() {
                TapIQYSplashSession.this.eventSink.onShow(null);
            }

            @Override // com.mcto.sspsdk.IQySplash.IAdInteractionListener
            public void onAdSkip() {
                TapIQYSplashSession.this.eventSink.onClose();
            }

            @Override // com.mcto.sspsdk.IQySplash.IAdInteractionListener
            public void onAdTimeOver() {
                TapIQYSplashSession.this.eventSink.onClose();
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterHostedSplashSession
    public void show(ViewGroup container) {
        IQySplash current = this.ad;
        if (current == null) {
            return;
        }
        View view = current.getSplashView();
        this.eventSink.onViewAcquired(view);
        if (view == null) {
            this.eventSink.onRenderFailure(null, -1, "splash view 为空");
            return;
        }
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        container.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterSplashSession
    public long getExpirationTimestamp() {
        return 0L;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (this.destroyed.compareAndSet(false, true)) {
            this.ad = null;
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return (this.destroyed.get() || this.ad == null) ? false : true;
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
        IQySplash current = this.ad;
        Map<String, String> extra = current == null ? null : current.getAdExtra();
        return extra == null ? Collections.emptyMap() : extra;
    }
}
