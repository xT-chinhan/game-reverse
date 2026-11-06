package com.tapsdk.tapad;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tapsdk.tapad.constants.ErrorCodeEnum;
import com.tapsdk.tapad.internal.WasmBannerPresenter;
import com.tapsdk.tapad.internal.WasmExpressFeedPresenter;
import com.tapsdk.tapad.internal.WasmInterstitialPresenter;
import com.tapsdk.tapad.internal.WasmNativeFeedPresenter;
import com.tapsdk.tapad.internal.WasmRewardPresenter;
import com.tapsdk.tapad.internal.WasmSplashPresenter;
import com.tapsdk.tapad.internal.ionia.IoniaIdentityManager;
import com.tapsdk.tapad.internal.runtime.AdnRuntimeCoreBridge;
import com.tapsdk.tapad.internal.runtime.WasmRuntimeController;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class TapAdNativeImpl implements TapAdNative {
    private static final String TAG = "TapAdNativeImpl";
    private final WeakReference<Context> contextWeakReference;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Set<WasmNativeFeedPresenter> nativeFeedPresenters = new HashSet();
    private final Set<WasmExpressFeedPresenter> expressFeedPresenters = new HashSet();

    public TapAdNativeImpl(Context context) {
        this.contextWeakReference = new WeakReference<>(context);
    }

    private static void deliverBannerFallbackOnMain(final Context context, final TapAdNative.BannerAdListener bannerAdListener) {
        if (bannerAdListener == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.TapAdNativeImpl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                bannerAdListener.onBannerAdLoad(WasmBannerPresenter.fallbackOnly(context));
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private boolean isDebugRewardSmokeRequest(AdRequest adRequest) {
        return false;
    }

    private void loadCoreRewardVideoAd(AdRequest adRequest, TapAdNative.RewardVideoAdListener rewardVideoAdListener) {
        Context context = this.contextWeakReference.get();
        if (context == null) {
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onError(ErrorCodeEnum.INTERNAL_ERROR.getCode(), "Reward Core context is unavailable");
                return;
            }
            return;
        }
        IoniaIdentityManager.getInstance().onAdLoadRequested();
        WasmRuntimeController wasmRuntimeController = WasmRuntimeController.getInstance();
        if (!(isDebugRewardSmokeRequest(adRequest) ? wasmRuntimeController.ensureInitializedForDebugSmoke(context) : wasmRuntimeController.ensureRewardCoreInitialized(context))) {
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onError(ErrorCodeEnum.INTERNAL_ERROR.getCode(), "Reward Core runtime is unavailable");
                return;
            }
            return;
        }
        WasmRewardPresenter wasmRewardPresenter = null;
        try {
            WasmRewardPresenter wasmRewardPresenter2 = new WasmRewardPresenter(context, adRequest);
            try {
                wasmRewardPresenter2.load(rewardVideoAdListener);
            } catch (Throwable th) {
                wasmRewardPresenter = wasmRewardPresenter2;
                if (wasmRewardPresenter != null) {
                    boolean zRecordSynchronousLoadFailure = wasmRewardPresenter.recordSynchronousLoadFailure();
                    wasmRewardPresenter.dispose();
                    if (!zRecordSynchronousLoadFailure) {
                        return;
                    }
                }
                if (rewardVideoAdListener != null) {
                    rewardVideoAdListener.onError(ErrorCodeEnum.INTERNAL_ERROR.getCode(), "Reward Core load failed");
                }
            }
        } catch (Throwable th2) {
        }
    }

    private void runOnMain(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mainHandler.post(runnable);
        }
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public int canSwitchPassiveConnection() {
        return 0;
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void dispose() {
        runOnMain(new Runnable() { // from class: com.tapsdk.tapad.TapAdNativeImpl$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12lambda$dispose$5$comtapsdktapadTapAdNativeImpl();
            }
        });
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public Context getContext() {
        return this.contextWeakReference.get();
    }

    /* JADX INFO: renamed from: lambda$dispose$5$com-tapsdk-tapad-TapAdNativeImpl, reason: not valid java name */
    /* synthetic */ void m12lambda$dispose$5$comtapsdktapadTapAdNativeImpl() {
        ArrayList arrayList = new ArrayList(this.nativeFeedPresenters);
        this.nativeFeedPresenters.clear();
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((WasmNativeFeedPresenter) obj).dispose();
        }
        ArrayList arrayList2 = new ArrayList(this.expressFeedPresenters);
        this.expressFeedPresenters.clear();
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj2 = arrayList2.get(i);
            i++;
            ((WasmExpressFeedPresenter) obj2).dispose();
        }
    }

    /* JADX INFO: renamed from: lambda$loadExpressFeedAd$1$com-tapsdk-tapad-TapAdNativeImpl, reason: not valid java name */
    /* synthetic */ void m13lambda$loadExpressFeedAd$1$comtapsdktapadTapAdNativeImpl(WasmExpressFeedPresenter wasmExpressFeedPresenter) {
        this.expressFeedPresenters.remove(wasmExpressFeedPresenter);
    }

    /* JADX INFO: renamed from: lambda$loadExpressFeedAd$2$com-tapsdk-tapad-TapAdNativeImpl, reason: not valid java name */
    /* synthetic */ void m14lambda$loadExpressFeedAd$2$comtapsdktapadTapAdNativeImpl(final WasmExpressFeedPresenter wasmExpressFeedPresenter, final TapAdNative.FeedAdListener feedAdListener) {
        wasmExpressFeedPresenter.m116lambda$setOnDisposed$4$comtapsdktapadinternalWasmExpressFeedPresenter(new Runnable() { // from class: com.tapsdk.tapad.TapAdNativeImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m13lambda$loadExpressFeedAd$1$comtapsdktapadTapAdNativeImpl(wasmExpressFeedPresenter);
            }
        });
        this.expressFeedPresenters.add(wasmExpressFeedPresenter);
        wasmExpressFeedPresenter.m113lambda$load$0$comtapsdktapadinternalWasmExpressFeedPresenter(new TapAdNative.FeedAdListener() { // from class: com.tapsdk.tapad.TapAdNativeImpl.2
            @Override // com.tapsdk.tapad.internal.CommonListener
            public void onError(int i, String str) {
                TapAdNativeImpl.this.expressFeedPresenters.remove(wasmExpressFeedPresenter);
                wasmExpressFeedPresenter.dispose();
                TapAdNative.FeedAdListener feedAdListener2 = feedAdListener;
                if (feedAdListener2 != null) {
                    feedAdListener2.onError(i, str);
                }
            }

            @Override // com.tapsdk.tapad.TapAdNative.FeedAdListener
            public void onFeedAdLoad(List<TapFeedAd> list) {
                TapAdNative.FeedAdListener feedAdListener2 = feedAdListener;
                if (feedAdListener2 != null) {
                    feedAdListener2.onFeedAdLoad(list);
                }
            }
        });
    }

    /* JADX INFO: renamed from: lambda$loadNativeFeedAd$3$com-tapsdk-tapad-TapAdNativeImpl, reason: not valid java name */
    /* synthetic */ void m15lambda$loadNativeFeedAd$3$comtapsdktapadTapAdNativeImpl(WasmNativeFeedPresenter wasmNativeFeedPresenter) {
        this.nativeFeedPresenters.remove(wasmNativeFeedPresenter);
    }

    /* JADX INFO: renamed from: lambda$loadNativeFeedAd$4$com-tapsdk-tapad-TapAdNativeImpl, reason: not valid java name */
    /* synthetic */ void m16lambda$loadNativeFeedAd$4$comtapsdktapadTapAdNativeImpl(final WasmNativeFeedPresenter wasmNativeFeedPresenter, final TapAdNative.NativeFeedAdListener nativeFeedAdListener) {
        wasmNativeFeedPresenter.m138lambda$setOnDisposed$5$comtapsdktapadinternalWasmNativeFeedPresenter(new Runnable() { // from class: com.tapsdk.tapad.TapAdNativeImpl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m15lambda$loadNativeFeedAd$3$comtapsdktapadTapAdNativeImpl(wasmNativeFeedPresenter);
            }
        });
        this.nativeFeedPresenters.add(wasmNativeFeedPresenter);
        wasmNativeFeedPresenter.m135lambda$load$0$comtapsdktapadinternalWasmNativeFeedPresenter(new TapAdNative.FeedAdListener() { // from class: com.tapsdk.tapad.TapAdNativeImpl.3
            @Override // com.tapsdk.tapad.internal.CommonListener
            public void onError(int i, String str) {
                TapAdNativeImpl.this.nativeFeedPresenters.remove(wasmNativeFeedPresenter);
                wasmNativeFeedPresenter.dispose();
                TapAdNative.NativeFeedAdListener nativeFeedAdListener2 = nativeFeedAdListener;
                if (nativeFeedAdListener2 != null) {
                    nativeFeedAdListener2.onError(i, str);
                }
            }

            @Override // com.tapsdk.tapad.TapAdNative.FeedAdListener
            public void onFeedAdLoad(List<TapFeedAd> list) {
                TapAdNative.NativeFeedAdListener nativeFeedAdListener2 = nativeFeedAdListener;
                if (nativeFeedAdListener2 != null) {
                    nativeFeedAdListener2.onNativeFeedAdLoad(list);
                }
            }
        });
    }

    /* JADX INFO: renamed from: lambda$pause$7$com-tapsdk-tapad-TapAdNativeImpl, reason: not valid java name */
    /* synthetic */ void m17lambda$pause$7$comtapsdktapadTapAdNativeImpl() {
        Iterator<WasmNativeFeedPresenter> it = this.nativeFeedPresenters.iterator();
        while (it.hasNext()) {
            it.next().pause();
        }
        Iterator<WasmExpressFeedPresenter> it2 = this.expressFeedPresenters.iterator();
        while (it2.hasNext()) {
            it2.next().pause();
        }
    }

    /* JADX INFO: renamed from: lambda$resume$6$com-tapsdk-tapad-TapAdNativeImpl, reason: not valid java name */
    /* synthetic */ void m18lambda$resume$6$comtapsdktapadTapAdNativeImpl() {
        Iterator<WasmNativeFeedPresenter> it = this.nativeFeedPresenters.iterator();
        while (it.hasNext()) {
            it.next().resume();
        }
        Iterator<WasmExpressFeedPresenter> it2 = this.expressFeedPresenters.iterator();
        while (it2.hasNext()) {
            it2.next().resume();
        }
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void loadBannerAd(AdRequest adRequest, TapAdNative.BannerAdListener bannerAdListener) {
        if (adRequest == null) {
            if (bannerAdListener != null) {
                ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.INVALID_PARAMETER;
                bannerAdListener.onError(errorCodeEnum.getCode(), errorCodeEnum.getDesc());
                return;
            }
            return;
        }
        AdRequest adRequestSnapshotForLoadAttempt = adRequest.snapshotForLoadAttempt();
        if (!TapAdSdk.isInitialized()) {
            if (bannerAdListener != null) {
                ErrorCodeEnum errorCodeEnum2 = ErrorCodeEnum.NOT_INITIALIZED;
                bannerAdListener.onError(errorCodeEnum2.getCode(), errorCodeEnum2.getDesc());
                return;
            }
            return;
        }
        Context context = this.contextWeakReference.get();
        if (context == null) {
            if (bannerAdListener != null) {
                ErrorCodeEnum errorCodeEnum3 = ErrorCodeEnum.CONTEXT_NULL;
                bannerAdListener.onError(errorCodeEnum3.getCode(), errorCodeEnum3.getDesc());
                return;
            }
            return;
        }
        IoniaIdentityManager.getInstance().onAdLoadRequested();
        if (!WasmRuntimeController.getInstance().ensureRewardCoreInitialized(context)) {
            deliverBannerFallbackOnMain(context, bannerAdListener);
            return;
        }
        try {
            new WasmBannerPresenter(context, adRequestSnapshotForLoadAttempt).load(bannerAdListener);
        } catch (Throwable th) {
            deliverBannerFallbackOnMain(context, bannerAdListener);
        }
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void loadExpressFeedAd(AdRequest adRequest, final TapAdNative.FeedAdListener feedAdListener) {
        if (adRequest == null) {
            if (feedAdListener != null) {
                ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.INVALID_PARAMETER;
                feedAdListener.onError(errorCodeEnum.getCode(), errorCodeEnum.getDesc());
                return;
            }
            return;
        }
        AdRequest adRequestSnapshotForLoadAttempt = adRequest.snapshotForLoadAttempt();
        String str = adRequestSnapshotForLoadAttempt.requestId;
        if (!TapAdSdk.isInitialized()) {
            if (feedAdListener != null) {
                ErrorCodeEnum errorCodeEnum2 = ErrorCodeEnum.NOT_INITIALIZED;
                feedAdListener.onError(errorCodeEnum2.getCode(), errorCodeEnum2.getDesc());
                return;
            }
            return;
        }
        Context context = this.contextWeakReference.get();
        if (context == null) {
            if (feedAdListener != null) {
                feedAdListener.onError(ErrorCodeEnum.INTERNAL_ERROR.getCode(), "Express Feed Core context is unavailable");
                return;
            }
            return;
        }
        IoniaIdentityManager.getInstance().onAdLoadRequested();
        if (!WasmRuntimeController.getInstance().ensureAdCoreInitialized(context)) {
            if (feedAdListener != null) {
                feedAdListener.onFeedAdLoad(WasmExpressFeedPresenter.fallbackOnly(context));
            }
        } else {
            try {
                final WasmExpressFeedPresenter wasmExpressFeedPresenter = new WasmExpressFeedPresenter(context, adRequestSnapshotForLoadAttempt);
                runOnMain(new Runnable() { // from class: com.tapsdk.tapad.TapAdNativeImpl$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m14lambda$loadExpressFeedAd$2$comtapsdktapadTapAdNativeImpl(wasmExpressFeedPresenter, feedAdListener);
                    }
                });
            } catch (Throwable th) {
                if (feedAdListener != null) {
                    feedAdListener.onFeedAdLoad(WasmExpressFeedPresenter.fallbackOnly(context));
                }
            }
        }
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void loadFeedAd(AdRequest adRequest, final TapAdNative.FeedAdListener feedAdListener) {
        loadNativeFeedAd(adRequest, feedAdListener == null ? null : new TapAdNative.NativeFeedAdListener() { // from class: com.tapsdk.tapad.TapAdNativeImpl.1
            @Override // com.tapsdk.tapad.internal.CommonListener
            public void onError(int i, String str) {
                feedAdListener.onError(i, str);
            }

            @Override // com.tapsdk.tapad.TapAdNative.NativeFeedAdListener
            public void onNativeFeedAdLoad(List<TapFeedAd> list) {
                feedAdListener.onFeedAdLoad(list);
            }
        });
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void loadInterstitialAd(AdRequest adRequest, TapAdNative.InterstitialAdListener interstitialAdListener) {
        if (adRequest == null) {
            if (interstitialAdListener != null) {
                ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.INVALID_PARAMETER;
                interstitialAdListener.onError(errorCodeEnum.getCode(), errorCodeEnum.getDesc());
                return;
            }
            return;
        }
        AdRequest adRequestSnapshotForLoadAttempt = adRequest.snapshotForLoadAttempt();
        if (!TapAdSdk.isInitialized()) {
            if (interstitialAdListener != null) {
                ErrorCodeEnum errorCodeEnum2 = ErrorCodeEnum.NOT_INITIALIZED;
                interstitialAdListener.onError(errorCodeEnum2.getCode(), errorCodeEnum2.getDesc());
                return;
            }
            return;
        }
        Context context = this.contextWeakReference.get();
        if (context == null) {
            if (interstitialAdListener != null) {
                ErrorCodeEnum errorCodeEnum3 = ErrorCodeEnum.CONTEXT_NULL;
                interstitialAdListener.onError(errorCodeEnum3.getCode(), errorCodeEnum3.getDesc());
                return;
            }
            return;
        }
        IoniaIdentityManager.getInstance().onAdLoadRequested();
        if (!WasmRuntimeController.getInstance().ensureRewardCoreInitialized(context)) {
            if (interstitialAdListener != null) {
                interstitialAdListener.onInterstitialAdLoad(WasmInterstitialPresenter.fallbackOnly(context));
            }
        } else {
            try {
                new WasmInterstitialPresenter(context, adRequestSnapshotForLoadAttempt).load(interstitialAdListener);
            } catch (Throwable th) {
                if (interstitialAdListener != null) {
                    interstitialAdListener.onInterstitialAdLoad(WasmInterstitialPresenter.fallbackOnly(context));
                }
            }
        }
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void loadNativeFeedAd(AdRequest adRequest, final TapAdNative.NativeFeedAdListener nativeFeedAdListener) {
        if (adRequest == null) {
            if (nativeFeedAdListener != null) {
                ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.INVALID_PARAMETER;
                nativeFeedAdListener.onError(errorCodeEnum.getCode(), errorCodeEnum.getDesc());
                return;
            }
            return;
        }
        AdRequest adRequestSnapshotForLoadAttempt = adRequest.snapshotForLoadAttempt();
        String str = adRequestSnapshotForLoadAttempt.requestId;
        if (!TapAdSdk.isInitialized()) {
            if (nativeFeedAdListener != null) {
                ErrorCodeEnum errorCodeEnum2 = ErrorCodeEnum.NOT_INITIALIZED;
                nativeFeedAdListener.onError(errorCodeEnum2.getCode(), errorCodeEnum2.getDesc());
                return;
            }
            return;
        }
        Context context = this.contextWeakReference.get();
        if (context == null) {
            if (nativeFeedAdListener != null) {
                nativeFeedAdListener.onError(ErrorCodeEnum.INTERNAL_ERROR.getCode(), "Native Feed Core context is unavailable");
                return;
            }
            return;
        }
        IoniaIdentityManager.getInstance().onAdLoadRequested();
        if (!WasmRuntimeController.getInstance().ensureAdCoreInitialized(context)) {
            List<TapFeedAd> listFallbackOnly = WasmNativeFeedPresenter.fallbackOnly(context);
            if (nativeFeedAdListener != null) {
                nativeFeedAdListener.onNativeFeedAdLoad(listFallbackOnly);
                return;
            }
            return;
        }
        try {
            final WasmNativeFeedPresenter wasmNativeFeedPresenter = new WasmNativeFeedPresenter(context, adRequestSnapshotForLoadAttempt);
            runOnMain(new Runnable() { // from class: com.tapsdk.tapad.TapAdNativeImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m16lambda$loadNativeFeedAd$4$comtapsdktapadTapAdNativeImpl(wasmNativeFeedPresenter, nativeFeedAdListener);
                }
            });
        } catch (Throwable th) {
            List<TapFeedAd> listFallbackOnly2 = WasmNativeFeedPresenter.fallbackOnly(context);
            if (nativeFeedAdListener != null) {
                nativeFeedAdListener.onNativeFeedAdLoad(listFallbackOnly2);
            }
        }
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void loadRewardVideoAd(AdRequest adRequest, TapAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (adRequest == null) {
            if (rewardVideoAdListener != null) {
                ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.INVALID_PARAMETER;
                rewardVideoAdListener.onError(errorCodeEnum.getCode(), errorCodeEnum.getDesc());
                return;
            }
            return;
        }
        AdRequest adRequestSnapshotForLoadAttempt = adRequest.snapshotForLoadAttempt();
        if (TapAdSdk.isInitialized()) {
            loadCoreRewardVideoAd(adRequestSnapshotForLoadAttempt, rewardVideoAdListener);
        } else if (rewardVideoAdListener != null) {
            ErrorCodeEnum errorCodeEnum2 = ErrorCodeEnum.NOT_INITIALIZED;
            rewardVideoAdListener.onError(errorCodeEnum2.getCode(), errorCodeEnum2.getDesc());
        }
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void loadSplashAd(AdRequest adRequest, TapAdNative.SplashAdListener splashAdListener) {
        if (adRequest == null) {
            if (splashAdListener != null) {
                ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.INVALID_PARAMETER;
                splashAdListener.onError(errorCodeEnum.getCode(), errorCodeEnum.getDesc());
                return;
            }
            return;
        }
        AdRequest adRequestSnapshotForLoadAttempt = adRequest.snapshotForLoadAttempt();
        if (!TapAdSdk.isInitialized()) {
            if (splashAdListener != null) {
                ErrorCodeEnum errorCodeEnum2 = ErrorCodeEnum.NOT_INITIALIZED;
                splashAdListener.onError(errorCodeEnum2.getCode(), errorCodeEnum2.getDesc());
                return;
            }
            return;
        }
        Context context = this.contextWeakReference.get();
        if (context == null) {
            if (splashAdListener != null) {
                splashAdListener.onError(ErrorCodeEnum.INTERNAL_ERROR.getCode(), "Splash Core context is unavailable");
                return;
            }
            return;
        }
        IoniaIdentityManager.getInstance().onAdLoadRequested();
        if (!WasmRuntimeController.getInstance().ensureAdCoreInitialized(context)) {
            if (splashAdListener != null) {
                splashAdListener.onSplashAdLoad(WasmSplashPresenter.fallbackOnly(context));
            }
        } else {
            try {
                new WasmSplashPresenter(context, adRequestSnapshotForLoadAttempt).load(splashAdListener);
            } catch (Throwable th) {
                if (splashAdListener != null) {
                    splashAdListener.onSplashAdLoad(WasmSplashPresenter.fallbackOnly(context));
                }
            }
        }
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void pause() {
        runOnMain(new Runnable() { // from class: com.tapsdk.tapad.TapAdNativeImpl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m17lambda$pause$7$comtapsdktapadTapAdNativeImpl();
            }
        });
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void resume() {
        runOnMain(new Runnable() { // from class: com.tapsdk.tapad.TapAdNativeImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m18lambda$resume$6$comtapsdktapadTapAdNativeImpl();
            }
        });
    }

    @Override // com.tapsdk.tapad.TapAdNative
    public void sendLossNotification(String str, Map<String, Object> map) {
        AdnRuntimeCoreBridge.reportLoadLoss(str, map);
    }
}
