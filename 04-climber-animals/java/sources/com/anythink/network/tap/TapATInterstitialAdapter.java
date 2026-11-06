package com.anythink.network.tap;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.tapsdk.tapad.TapAdManager;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapInterstitialAd;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TapATInterstitialAdapter extends CustomInterstitialAdapter {
    private final TapATInitManager a = TapATInitManager.getInstance();
    private int b = 0;
    private boolean c = false;
    private TapAdNative d;
    private TapInterstitialAd e;

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.c = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, final Map<String, Object> map2) {
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "Tap InterstitialAd context must be activity.");
            return;
        }
        int spaceId = this.a.getSpaceId(map);
        this.b = spaceId;
        if (spaceId == 0) {
            notifyATLoadFail("", "InterstitialAd spaceId is null or zero. spaceId:" + this.b);
        } else {
            this.a.initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.tap.TapATInterstitialAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    TapATInterstitialAdapter.this.postOnMainThread(new Runnable() { // from class: com.anythink.network.tap.TapATInterstitialAdapter.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            TapATInterstitialAdapter.a(TapATInterstitialAdapter.this, context, map2);
                        }
                    });
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TapATInterstitialAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.tap.TapATInterstitialAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements TapAdNative.InterstitialAdListener {
        AnonymousClass2() {
        }

        @Override // com.tapsdk.tapad.TapAdNative.InterstitialAdListener
        public final void onInterstitialAdLoad(TapInterstitialAd tapInterstitialAd) {
            if (tapInterstitialAd != null) {
                TapATInterstitialAdapter.this.e = tapInterstitialAd;
                TapATInterstitialAdapter.this.a.handleAdLoadedCallback(TapATInterstitialAdapter.this.c, TapATInterstitialAdapter.this.e, tapInterstitialAd.getMediaExtraInfo(), TapATInterstitialAdapter.this.mBiddingListener, TapATInterstitialAdapter.this.mLoadListener, new BaseAd[0]);
            } else {
                TapATInterstitialAdapter.this.notifyATLoadFail("", "InterstitialAd load failed, tapInterstitialAd = null.");
            }
        }

        @Override // com.tapsdk.tapad.internal.CommonListener
        public final void onError(int i, String str) {
            TapATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }
    }

    private void a(Context context, Map<String, Object> map) {
        TapAdNative tapAdNativeCreateAdNative = TapAdManager.get().createAdNative(context);
        this.d = tapAdNativeCreateAdNative;
        tapAdNativeCreateAdNative.loadInterstitialAd(this.a.getAdRequest(this.b, map), new AnonymousClass2());
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        TapInterstitialAd tapInterstitialAd = this.e;
        if (tapInterstitialAd != null) {
            tapInterstitialAd.dispose();
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
        return String.valueOf(this.b);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return this.a.getNetworkVersion();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return this.a.getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        return this.e != null;
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        TapInterstitialAd tapInterstitialAd = this.e;
        if (tapInterstitialAd == null) {
            a("Tap InterstitialAd show failed, mTapInterstitialAd = null.");
        } else if (activity == null) {
            a("Tap InterstitialAd show failed, activity == null.");
        } else {
            tapInterstitialAd.setInteractionListener(new TapInterstitialAd.InterstitialAdInteractionListener() { // from class: com.anythink.network.tap.TapATInterstitialAdapter.3
                @Override // com.tapsdk.tapad.TapInterstitialAd.InterstitialAdInteractionListener
                public final void onAdValidShow() {
                }

                @Override // com.tapsdk.tapad.TapInterstitialAd.InterstitialAdInteractionListener
                public final void onAdShow() {
                    TapATInterstitialAdapter.e(TapATInterstitialAdapter.this);
                }

                @Override // com.tapsdk.tapad.TapInterstitialAd.InterstitialAdInteractionListener
                public final void onAdClose() {
                    TapATInterstitialAdapter.f(TapATInterstitialAdapter.this);
                }

                @Override // com.tapsdk.tapad.TapInterstitialAd.InterstitialAdInteractionListener
                public final void onAdError() {
                    TapATInterstitialAdapter.this.a("Tap InterstitialAd show failed, onAdError() called");
                }
            });
            this.e.show(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.mDismissType = 99;
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdVideoError("", str);
        }
    }

    private void a() {
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdClose();
        }
    }

    private void b() {
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdShow();
        }
    }

    static /* synthetic */ void a(TapATInterstitialAdapter tapATInterstitialAdapter, Context context, Map map) {
        TapAdNative tapAdNativeCreateAdNative = TapAdManager.get().createAdNative(context);
        tapATInterstitialAdapter.d = tapAdNativeCreateAdNative;
        tapAdNativeCreateAdNative.loadInterstitialAd(tapATInterstitialAdapter.a.getAdRequest(tapATInterstitialAdapter.b, map), tapATInterstitialAdapter.new AnonymousClass2());
    }

    static /* synthetic */ void e(TapATInterstitialAdapter tapATInterstitialAdapter) {
        if (tapATInterstitialAdapter.mImpressListener != null) {
            tapATInterstitialAdapter.mImpressListener.onInterstitialAdShow();
        }
    }

    static /* synthetic */ void f(TapATInterstitialAdapter tapATInterstitialAdapter) {
        if (tapATInterstitialAdapter.mImpressListener != null) {
            tapATInterstitialAdapter.mImpressListener.onInterstitialAdClose();
        }
    }
}
