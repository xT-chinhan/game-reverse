package com.tapsdk.tapad.lib_tapadadapter;

import android.app.Activity;
import android.view.View;
import com.tapsdk.tapad.TapBannerAd;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterBannerSession;
import com.tapsdk.tapad.lib_tapadadapter.utils.Utils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class TapTapADNBannerSession implements AdapterBannerSession {
    private final TapBannerAd ad;
    private volatile AdapterAdEventSink eventSink;

    public TapTapADNBannerSession(TapBannerAd tapBannerAd) {
        this.ad = tapBannerAd;
        tapBannerAd.setBannerInteractionListener(new TapBannerAd.BannerInteractionListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNBannerSession.1
            @Override // com.tapsdk.tapad.TapBannerAd.BannerInteractionListener
            public void onAdClick() {
                AdapterAdEventSink adapterAdEventSink = TapTapADNBannerSession.this.eventSink;
                if (adapterAdEventSink != null) {
                    adapterAdEventSink.onClick(null);
                }
            }

            @Override // com.tapsdk.tapad.TapBannerAd.BannerInteractionListener
            public void onAdClose() {
                AdapterAdEventSink adapterAdEventSink = TapTapADNBannerSession.this.eventSink;
                if (adapterAdEventSink != null) {
                    adapterAdEventSink.onClose();
                }
            }

            @Override // com.tapsdk.tapad.TapBannerAd.BannerInteractionListener
            public void onAdShow() {
            }

            @Override // com.tapsdk.tapad.TapBannerAd.BannerInteractionListener
            public void onAdValidShow() {
                AdapterAdEventSink adapterAdEventSink = TapTapADNBannerSession.this.eventSink;
                if (adapterAdEventSink != null) {
                    adapterAdEventSink.onShow(null);
                }
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        this.ad.dispose();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        return this.ad.getMediaExtraInfo();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        return this.ad.getPrice();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterBannerSession
    public View getView() {
        return this.ad.getBannerView();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return this.ad.isValid();
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

    @Override // com.tapsdk.tapad.group.adapter.AdapterBannerSession
    public boolean show(Activity activity, int i, int i2) {
        if (activity == null) {
            return false;
        }
        this.ad.show(activity, i, i2);
        return true;
    }
}
