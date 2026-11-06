package com.tapsdk.tapad.lib_csjadapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterBannerSession;
import com.tapsdk.tapad.lib_csjadapter.utils.Utils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapCSJBannerSession implements AdapterBannerSession {
    private final TTNativeExpressAd ad;
    private final int bannerHeightPx;
    private final int bannerWidthPx;
    private volatile AdapterAdEventSink eventSink;
    private final AtomicBoolean renderRequested = new AtomicBoolean(false);

    TapCSJBannerSession(TTNativeExpressAd ad, Context context, int bannerWidthPx, int bannerHeightPx) {
        this.ad = ad;
        this.bannerWidthPx = bannerWidthPx;
        this.bannerHeightPx = bannerHeightPx;
        bindInteractionEvents();
        bindDislike(context);
        bindDownloadEvents();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink;
    }

    private void bindInteractionEvents() {
        this.ad.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJBannerSession.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int type) {
                AdapterAdEventSink sink = TapCSJBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onClick(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int type) {
                AdapterAdEventSink sink = TapCSJBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onShow(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String message, int code) {
                AdapterAdEventSink sink = TapCSJBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onRenderFailure(view, code, message);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float width, float height) {
                TapCSJBannerSession.this.applyBannerLayout(view);
                AdapterAdEventSink sink = TapCSJBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onRenderSuccess(view, width, height);
                }
            }
        });
    }

    private void bindDislike(Context context) {
        if (!(context instanceof Activity)) {
            return;
        }
        try {
            this.ad.setDislikeCallback((Activity) context, new TTAdDislike.DislikeInteractionCallback() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJBannerSession.2
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int index, String reason, boolean enforce) {
                    AdapterAdEventSink sink = TapCSJBannerSession.this.eventSink;
                    if (sink != null) {
                        sink.onClose();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                }
            });
        } catch (RuntimeException e) {
        }
    }

    private void bindDownloadEvents() {
        this.ad.setDownloadListener(new TTAppDownloadListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJBannerSession.3
            private final AtomicBoolean downloading = new AtomicBoolean(false);
            private final AtomicBoolean finished = new AtomicBoolean(false);
            private final AtomicBoolean installed = new AtomicBoolean(false);

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long totalBytes, long currentBytes, String fileName, String appName) {
                AdapterAdEventSink sink = TapCSJBannerSession.this.eventSink;
                if (sink != null && this.downloading.compareAndSet(false, true)) {
                    sink.onDownloadStart(totalBytes, appName, fileName);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long totalBytes, long currentBytes, String fileName, String appName) {
                this.downloading.set(false);
                AdapterAdEventSink sink = TapCSJBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onDownloadPause(totalBytes, totalBytes, currentBytes, appName, fileName);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long totalBytes, long currentBytes, String fileName, String appName) {
                this.downloading.set(false);
                AdapterAdEventSink sink = TapCSJBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onDownloadFailure(totalBytes, totalBytes, currentBytes, appName, fileName, -1, "");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long totalBytes, String fileName, String appName) {
                AdapterAdEventSink sink = TapCSJBannerSession.this.eventSink;
                if (sink != null && this.finished.compareAndSet(false, true)) {
                    sink.onDownloadComplete(totalBytes, totalBytes, appName, fileName);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String fileName, String appName) {
                AdapterAdEventSink sink = TapCSJBannerSession.this.eventSink;
                if (sink != null && this.installed.compareAndSet(false, true)) {
                    sink.onInstalled(0L, appName, fileName);
                }
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterBannerSession
    public View getView() {
        if (this.renderRequested.compareAndSet(false, true)) {
            this.ad.render();
        }
        View view = this.ad.getExpressAdView();
        applyBannerLayout(view);
        return view;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterBannerSession
    public boolean show(Activity activity, int baseline, int offset) {
        View bannerView;
        if (activity == null || (bannerView = getView()) == null) {
            return false;
        }
        View content = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        if (!(content instanceof FrameLayout)) {
            return false;
        }
        ViewParent parent = bannerView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(bannerView);
        }
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(this.bannerWidthPx, this.bannerHeightPx);
        if (baseline == 0) {
            params.setMargins(0, offset, 0, 0);
            params.gravity = 49;
        } else {
            params.setMargins(0, 0, 0, offset);
            params.gravity = 81;
        }
        ((FrameLayout) content).addView(bannerView, params);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyBannerLayout(View view) {
        FrameLayout.LayoutParams params;
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams current = view.getLayoutParams();
        if (current instanceof FrameLayout.LayoutParams) {
            params = new FrameLayout.LayoutParams((FrameLayout.LayoutParams) current);
        } else if (current != null) {
            params = new FrameLayout.LayoutParams(current);
        } else {
            params = new FrameLayout.LayoutParams(this.bannerWidthPx, this.bannerHeightPx);
        }
        params.width = this.bannerWidthPx;
        params.height = this.bannerHeightPx;
        view.setLayoutParams(params);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        this.ad.destroy();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        return Utils.getCSJPrice(this.ad);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        return AdapterAdMetadata.fromProvider(this.ad.getMediaExtraInfo());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        this.ad.win(Double.valueOf(secondPrice));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        this.ad.loss(Double.valueOf(winPrice), "102", winBidder);
    }
}
