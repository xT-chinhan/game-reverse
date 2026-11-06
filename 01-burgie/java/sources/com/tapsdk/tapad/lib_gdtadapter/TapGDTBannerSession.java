package com.tapsdk.tapad.lib_gdtadapter;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterBannerSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import com.tapsdk.tapad.lib_gdtadapter.utils.Utils;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapGDTBannerSession implements AdapterBannerSession {
    private final UnifiedBannerView bannerView;
    private volatile AdapterAdEventSink eventSink;
    private final AtomicBoolean loadFinished = new AtomicBoolean(false);

    TapGDTBannerSession(Activity activity, AdapterLoadRequest request, final AdapterLoadCallback<AdapterBannerSession> loadCallback) {
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView(activity, request.getPlacementId(), new UnifiedBannerADListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTBannerSession.1
            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onNoAD(AdError error) {
                if (TapGDTBannerSession.this.loadFinished.compareAndSet(false, true)) {
                    loadCallback.onFailure(error.getErrorCode(), error.getErrorMsg());
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADReceive() {
                if (TapGDTBannerSession.this.loadFinished.compareAndSet(false, true)) {
                    loadCallback.onSuccess(Collections.singletonList(TapGDTBannerSession.this));
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADExposure() {
                AdapterAdEventSink sink = TapGDTBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onShow(TapGDTBannerSession.this.bannerView);
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClosed() {
                AdapterAdEventSink sink = TapGDTBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onClose();
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClicked() {
                AdapterAdEventSink sink = TapGDTBannerSession.this.eventSink;
                if (sink != null) {
                    sink.onClick(TapGDTBannerSession.this.bannerView);
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADLeftApplication() {
            }
        });
        this.bannerView = unifiedBannerView;
        int width = request.getAcceptedWidthPx();
        int height = request.getAcceptedHeightPx();
        if (width <= 0) {
            unifiedBannerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        } else if (height <= 0) {
            unifiedBannerView.setLayoutParams(new FrameLayout.LayoutParams(width, -2));
        } else {
            unifiedBannerView.setLayoutParams(new FrameLayout.LayoutParams(width, height));
        }
        unifiedBannerView.setRefresh(0);
    }

    void load() {
        this.bannerView.loadAD();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterBannerSession
    public View getView() {
        return this.bannerView;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        this.bannerView.destroy();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return this.bannerView.isValid();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        return this.bannerView.getECPM();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        return AdapterAdMetadata.fromProvider(this.bannerView.getExtraInfo());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        this.bannerView.sendWinNotification(Utils.getWinMap(secondPrice, winPrice));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        this.bannerView.sendLossNotification(Utils.getLossMap(winPrice, lossReason, winBidder));
    }
}
