package com.tapsdk.tapad.lib_tapadadapter;

import android.app.Activity;
import android.view.View;
import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.feed.FeedOption;
import com.tapsdk.tapad.feed.VideoOption;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedRenderOptions;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedSession;
import com.tapsdk.tapad.lib_tapadadapter.utils.Utils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class TapTapADNExpressFeedSession implements AdapterExpressFeedSession {
    private final int acceptedHeight;
    private final int acceptedWidth;
    private final TapFeedAd ad;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private volatile AdapterAdEventSink eventSink;

    public TapTapADNExpressFeedSession(TapFeedAd tapFeedAd, int i, int i2) {
        this.ad = tapFeedAd;
        this.acceptedWidth = i;
        this.acceptedHeight = i2;
        tapFeedAd.setExpressRenderListener(new TapFeedAd.ExpressRenderListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNExpressFeedSession.1
            @Override // com.tapsdk.tapad.TapFeedAd.ExpressRenderListener
            public void onAdClicked(View view) {
                AdapterAdEventSink adapterAdEventSink = TapTapADNExpressFeedSession.this.eventSink;
                if (adapterAdEventSink != null) {
                    adapterAdEventSink.onClick(view);
                }
            }

            @Override // com.tapsdk.tapad.TapFeedAd.ExpressRenderListener
            public void onAdClosed(View view) {
                AdapterAdEventSink adapterAdEventSink = TapTapADNExpressFeedSession.this.eventSink;
                if (adapterAdEventSink != null) {
                    adapterAdEventSink.onClose();
                }
            }

            @Override // com.tapsdk.tapad.TapFeedAd.ExpressRenderListener
            public void onAdShow(View view) {
            }

            @Override // com.tapsdk.tapad.TapFeedAd.ExpressRenderListener
            public void onAdValidShow(View view) {
                AdapterAdEventSink adapterAdEventSink = TapTapADNExpressFeedSession.this.eventSink;
                if (adapterAdEventSink != null) {
                    adapterAdEventSink.onShow(view);
                }
            }

            @Override // com.tapsdk.tapad.TapFeedAd.ExpressRenderListener
            public void onRenderFail(View view, TapFeedAd tapFeedAd2, int i3, String str) {
                AdapterAdEventSink adapterAdEventSink = TapTapADNExpressFeedSession.this.eventSink;
                if (adapterAdEventSink != null) {
                    adapterAdEventSink.onRenderFailure(view, i3, str);
                }
            }

            @Override // com.tapsdk.tapad.TapFeedAd.ExpressRenderListener
            public void onRenderSuccess(View view) {
                AdapterAdEventSink adapterAdEventSink = TapTapADNExpressFeedSession.this.eventSink;
                if (adapterAdEventSink != null) {
                    adapterAdEventSink.onRenderSuccess(view, 0.0f, 0.0f);
                }
            }
        });
    }

    private FeedOption toDirectOptions(AdapterExpressFeedRenderOptions adapterExpressFeedRenderOptions) {
        return new FeedOption.Builder().expressWidth(this.acceptedWidth).expressHeight(this.acceptedHeight).videoOption(new VideoOption.Builder().autoPlayPolicy(adapterExpressFeedRenderOptions.isAutoPlayAlways() ? VideoOption.AutoPlayPolicy.ALWAYS : VideoOption.AutoPlayPolicy.WIFI).build()).build();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        if (this.destroyed.compareAndSet(false, true)) {
            this.ad.dispose();
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        return this.ad.getMediaExtraInfo();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        return this.ad.getPrice();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return !this.destroyed.get() && this.ad.isValid();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterExpressFeedSession
    public void render(AdapterExpressFeedRenderOptions adapterExpressFeedRenderOptions) {
        this.ad.render(toDirectOptions(adapterExpressFeedRenderOptions));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long j, String str, String str2) {
        this.ad.sendLossNotification(Utils.getLossMap(j, str, str2));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long j, long j2, String str) {
        this.ad.sendWinNotification(Utils.getWinMap(j, j2));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink adapterAdEventSink) {
        this.eventSink = adapterAdEventSink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterExpressFeedSession
    public void render(Activity activity, AdapterExpressFeedRenderOptions adapterExpressFeedRenderOptions) {
        this.ad.render(activity, toDirectOptions(adapterExpressFeedRenderOptions));
    }
}
