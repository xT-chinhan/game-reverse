package com.tapsdk.tapad.lib_gdtadapter;

import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedRenderOptions;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedSession;
import com.tapsdk.tapad.lib_gdtadapter.utils.Utils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapGDTExpressFeedSession implements AdapterExpressFeedSession {
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink;
    private final NativeExpressAD nativeExpressAd;
    private final Runnable onDestroy;
    private final NativeExpressADView view;

    TapGDTExpressFeedSession(NativeExpressAD nativeExpressAd, NativeExpressADView view, Runnable onDestroy) {
        this.nativeExpressAd = nativeExpressAd;
        this.view = view;
        this.onDestroy = onDestroy;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterExpressFeedSession
    public void render(AdapterExpressFeedRenderOptions options) {
        int playPolicy;
        if (options.isAutoPlayAlways()) {
            playPolicy = 1;
        } else {
            playPolicy = 0;
        }
        this.nativeExpressAd.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(playPolicy).build());
        this.view.render();
    }

    void onRenderFailure() {
        AdapterAdEventSink sink = this.eventSink;
        if (sink != null) {
            sink.onRenderFailure(this.view, -1, "");
        }
    }

    void onRenderSuccess() {
        AdapterAdEventSink sink = this.eventSink;
        if (sink != null) {
            sink.onRenderSuccess(this.view, 0.0f, 0.0f);
        }
    }

    void onShow() {
        AdapterAdEventSink sink = this.eventSink;
        if (sink != null) {
            sink.onShow(this.view);
        }
    }

    void onClick() {
        AdapterAdEventSink sink = this.eventSink;
        if (sink != null) {
            sink.onClick(this.view);
        }
    }

    void onClose() {
        AdapterAdEventSink sink = this.eventSink;
        if (sink != null) {
            sink.onClose();
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (this.destroyed.compareAndSet(false, true)) {
            this.onDestroy.run();
            this.view.destroy();
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return !this.destroyed.get() && this.view.isValid();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        return this.view.getECPM();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        return AdapterAdMetadata.fromProvider(this.view.getExtraInfo());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        this.view.sendWinNotification(Utils.getWinMap(secondPrice, winPrice));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        this.view.sendLossNotification(Utils.getLossMap(winPrice, lossReason, winBidder));
    }
}
