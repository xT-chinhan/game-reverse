package com.anythink.network.tap;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.tapsdk.tapad.TapAdManager;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapBannerAd;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TapATBannerAdapter extends CustomBannerAdapter {
    private boolean b;
    private TapAdNative d;
    private TapBannerAd e;
    private View f;
    private final TapATInitManager a = TapATInitManager.getInstance();
    private int c = 0;

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.f;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.b = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, final Map<String, Object> map2) {
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "Tap Banner context must be activity.");
            return;
        }
        int spaceId = this.a.getSpaceId(map);
        this.c = spaceId;
        if (spaceId == 0) {
            notifyATLoadFail("", "Banner spaceId is null. spaceId:" + this.c);
        } else {
            this.a.initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.tap.TapATBannerAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    TapATBannerAdapter.this.postOnMainThread(new Runnable() { // from class: com.anythink.network.tap.TapATBannerAdapter.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            TapATBannerAdapter.a(TapATBannerAdapter.this, context, map2);
                        }
                    });
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TapATBannerAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.tap.TapATBannerAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements TapAdNative.BannerAdListener {
        AnonymousClass2() {
        }

        @Override // com.tapsdk.tapad.TapAdNative.BannerAdListener
        public final void onBannerAdLoad(TapBannerAd tapBannerAd) {
            if (tapBannerAd != null) {
                TapATBannerAdapter.this.e = tapBannerAd;
                TapATBannerAdapter.this.a.handleAdLoadedCallback(TapATBannerAdapter.this.b, TapATBannerAdapter.this.e, tapBannerAd.getMediaExtraInfo(), TapATBannerAdapter.this.mBiddingListener, TapATBannerAdapter.this.mLoadListener, new BaseAd[0]);
                tapBannerAd.setBannerInteractionListener(new TapBannerAd.BannerInteractionListener() { // from class: com.anythink.network.tap.TapATBannerAdapter.2.1
                    @Override // com.tapsdk.tapad.TapBannerAd.BannerInteractionListener
                    public final void onAdValidShow() {
                    }

                    @Override // com.tapsdk.tapad.TapBannerAd.BannerInteractionListener
                    public final void onAdShow() {
                        if (TapATBannerAdapter.this.mImpressionEventListener != null) {
                            TapATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
                        }
                    }

                    @Override // com.tapsdk.tapad.TapBannerAd.BannerInteractionListener
                    public final void onAdClose() {
                        if (TapATBannerAdapter.this.mImpressionEventListener != null) {
                            TapATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
                        }
                    }

                    @Override // com.tapsdk.tapad.TapBannerAd.BannerInteractionListener
                    public final void onAdClick() {
                        if (TapATBannerAdapter.this.mImpressionEventListener != null) {
                            TapATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
                        }
                    }

                    @Override // com.tapsdk.tapad.TapBannerAd.BannerInteractionListener
                    public final void onDownloadClick() {
                        if (TapATBannerAdapter.this.mImpressionEventListener != null) {
                            TapATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
                        }
                    }
                });
                TapATBannerAdapter.this.f = tapBannerAd.getBannerView();
                return;
            }
            TapATBannerAdapter.this.notifyATLoadFail("", "BannerAd load failed, tapBannerAd = null.");
        }

        @Override // com.tapsdk.tapad.internal.CommonListener
        public final void onError(int i, String str) {
            TapATBannerAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }
    }

    private void a(Context context, Map<String, Object> map) {
        TapAdNative tapAdNativeCreateAdNative = TapAdManager.get().createAdNative(context);
        this.d = tapAdNativeCreateAdNative;
        tapAdNativeCreateAdNative.loadBannerAd(this.a.getAdRequest(this.c, map), new AnonymousClass2());
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        TapBannerAd tapBannerAd = this.e;
        if (tapBannerAd != null) {
            tapBannerAd.dispose();
            this.e = null;
        }
        TapAdNative tapAdNative = this.d;
        if (tapAdNative != null) {
            tapAdNative.dispose();
            this.d = null;
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return String.valueOf(this.c);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return this.a.getNetworkVersion();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return this.a.getNetworkName();
    }

    static /* synthetic */ void a(TapATBannerAdapter tapATBannerAdapter, Context context, Map map) {
        TapAdNative tapAdNativeCreateAdNative = TapAdManager.get().createAdNative(context);
        tapATBannerAdapter.d = tapAdNativeCreateAdNative;
        tapAdNativeCreateAdNative.loadBannerAd(tapATBannerAdapter.a.getAdRequest(tapATBannerAdapter.c, map), tapATBannerAdapter.new AnonymousClass2());
    }
}
