package com.tapsdk.tapad.lib_iqyadapter;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.mar.sdk.IAction;
import com.mcto.sspsdk.IQyBanner;
import com.mcto.sspsdk.QyRewardProperty;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterBannerSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class TapIQYBannerSession implements AdapterBannerSession {
    private static final int VIEW_ATTACH_ERROR = -1;
    private static final String VIEW_ATTACH_ERROR_MESSAGE = "爱奇艺 Banner 视图挂载失败";
    private final IQyBanner ad;
    private FrameLayout container;
    private volatile boolean destroyed;
    private volatile AdapterAdEventSink eventSink;
    private final String placementId;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Runnable renderSuccessTask = new Runnable() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYBannerSession$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.dispatchRenderSuccess();
        }
    };

    TapIQYBannerSession(IQyBanner ad, String placementId) {
        this.ad = ad;
        this.placementId = placementId;
        ad.setBannerInteractionListener(new IQyBanner.IAdInteractionListener() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYBannerSession.1
            @Override // com.mcto.sspsdk.IQyBanner.IAdInteractionListener
            public void onAdShow() {
                AdapterAdEventSink sink = TapIQYBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onShow(TapIQYBannerSession.this.getView());
                }
            }

            @Override // com.mcto.sspsdk.IQyBanner.IAdInteractionListener
            public void onAdClick() {
                AdapterAdEventSink sink = TapIQYBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onClick(null);
                }
            }

            @Override // com.mcto.sspsdk.IQyBanner.IAdInteractionListener
            public void onAdClose() {
                AdapterAdEventSink sink = TapIQYBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onClose();
                }
            }

            @Override // com.mcto.sspsdk.IQyBanner.IAdInteractionListener
            public void onRenderSuccess() {
                TapIQYBannerSession.this.mainHandler.post(TapIQYBannerSession.this.renderSuccessTask);
            }

            @Override // com.mcto.sspsdk.IQyBanner.IAdInteractionListener
            public void onAdStart() {
                AdapterAdEventSink sink = TapIQYBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onVideoStart();
                }
            }

            @Override // com.mcto.sspsdk.IQyBanner.IAdInteractionListener
            public void onAdStop() {
                AdapterAdEventSink sink = TapIQYBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onVideoPause();
                }
            }

            @Override // com.mcto.sspsdk.IQyBanner.IAdInteractionListener
            public void onAdComplete() {
                AdapterAdEventSink sink = TapIQYBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onVideoComplete(0L);
                }
            }

            @Override // com.mcto.sspsdk.IQyBanner.IAdInteractionListener
            public void onAdPlayError() {
                AdapterAdEventSink sink = TapIQYBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onVideoFailure(-1, "爱奇艺banner播放错误");
                }
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterBannerSession
    public View getView() {
        if (this.destroyed) {
            return null;
        }
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            return frameLayout;
        }
        try {
            View bannerView = this.ad.getBannerView();
            if (bannerView == null) {
                return null;
            }
            FrameLayout next = new FrameLayout(bannerView.getContext());
            next.addView(bannerView, new FrameLayout.LayoutParams(-1, -1));
            if (this.destroyed) {
                next.removeView(bannerView);
                return null;
            }
            this.container = next;
            return next;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        this.destroyed = true;
        this.mainHandler.removeCallbacks(this.renderSuccessTask);
        this.eventSink = null;
        this.ad.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchRenderSuccess() {
        AdapterAdEventSink sink;
        if (this.destroyed || (sink = this.eventSink) == null) {
            return;
        }
        View view = getView();
        if (this.destroyed) {
            return;
        }
        if (view == null) {
            sink.onRenderFailure(null, -1, VIEW_ATTACH_ERROR_MESSAGE);
        } else {
            sink.onRenderSuccess(view, view.getWidth(), view.getHeight());
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        Map<String, String> extra = this.ad.getAdExtra();
        if (extra != null) {
            try {
                if (!extra.containsKey(IAction.PurchaseKey.Price)) {
                    return 0L;
                }
                return Long.parseLong(extra.get(IAction.PurchaseKey.Price));
            } catch (RuntimeException e) {
                return 0L;
            }
        }
        return 0L;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        Map<String, String> extra = this.ad.getAdExtra();
        if (extra == null) {
            extra = Collections.emptyMap();
        }
        Map<String, Object> metadata = new HashMap<>();
        if (extra.containsKey(QyRewardProperty.VERIFY_IMPRESSIONID)) {
            metadata.put(Constants.Bidding.REQUEST_ID, extra.get(QyRewardProperty.VERIFY_IMPRESSIONID));
        }
        if (extra.containsKey(IAction.PurchaseKey.Price)) {
            metadata.put(IAction.PurchaseKey.Price, extra.get(IAction.PurchaseKey.Price));
        }
        return AdapterAdMetadata.fromProvider(metadata);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        Map<String, String> extra = this.ad.getAdExtra();
        String impressionId = extra == null ? null : extra.get(QyRewardProperty.VERIFY_IMPRESSIONID);
        IQYBidInfoReporter.reportWin(impressionId, this.placementId, 5564, secondPrice, followBidder);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        Map<String, String> extra = this.ad.getAdExtra();
        String impressionId = extra == null ? null : extra.get(QyRewardProperty.VERIFY_IMPRESSIONID);
        IQYBidInfoReporter.reportLoss(impressionId, this.placementId, 5564, winPrice, winBidder, 1);
    }
}
