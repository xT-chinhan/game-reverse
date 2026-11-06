package com.tapsdk.tapad.group;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.tapsdk.tapad.exceptions.ClientException;
import com.tapsdk.tapad.group.ads.DirichletAd;
import com.tapsdk.tapad.group.ads.MediationAdFactory;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.Callback;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class DirichletAdNativeImpl implements DirichletAdNative {
    private final MediationAutoPoolShell autoPool;
    private final WeakReference<Context> contextWeakReference;

    public DirichletAdNativeImpl(Context context) {
        this.contextWeakReference = new WeakReference<>(context);
        this.autoPool = new MediationAutoPoolShell(context, this);
    }

    private void load(final AdType adType, final DirichletAdRequest dirichletAdRequest, final Callback<List<DirichletAd>> callback) {
        final Context context = this.contextWeakReference.get();
        if (AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.group.DirichletAdNativeImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediationAdapterLoadHost.load(context, adType, dirichletAdRequest, callback);
            }
        })) {
            return;
        }
        AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.group.DirichletAdNativeImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                callback.onFail(new ClientException(Constants.SDK_AD_LOAD_ERROR_CODE, "adapter load executor is saturated"));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportLoadFailure(CommonListener commonListener, Exception exc) {
        commonListener.onError(exc instanceof ClientException ? ((ClientException) exc).code : -1, (exc == null || exc.getMessage() == null) ? "" : exc.getMessage());
    }

    @Override // com.tapsdk.tapad.group.DirichletAdNative
    public void loadBannerAd(DirichletAdRequest dirichletAdRequest, final DirichletAdNative.BannerAdListener bannerAdListener) {
        load(AdType.Banner, dirichletAdRequest, new Callback<List<DirichletAd>>() { // from class: com.tapsdk.tapad.group.DirichletAdNativeImpl.3
            @Override // com.tapsdk.tapad.internal.Callback
            public void onFail(Exception exc) {
                DirichletAdNativeImpl.reportLoadFailure(bannerAdListener, exc);
            }

            @Override // com.tapsdk.tapad.internal.Callback
            public void onSuccess(List<DirichletAd> list) {
                bannerAdListener.onBannerAdLoad(MediationAdFactory.banner(list.get(0)));
            }
        });
    }

    @Override // com.tapsdk.tapad.group.DirichletAdNative
    public void loadExpressFeedAd(DirichletAdRequest dirichletAdRequest, final DirichletAdNative.NativeExpressAdListener nativeExpressAdListener) {
        load(AdType.ExpressFeedAd, dirichletAdRequest, new Callback<List<DirichletAd>>() { // from class: com.tapsdk.tapad.group.DirichletAdNativeImpl.5
            @Override // com.tapsdk.tapad.internal.Callback
            public void onFail(Exception exc) {
                DirichletAdNativeImpl.reportLoadFailure(nativeExpressAdListener, exc);
            }

            @Override // com.tapsdk.tapad.internal.Callback
            public void onSuccess(List<DirichletAd> list) {
                ArrayList arrayList = new ArrayList();
                Iterator<DirichletAd> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(MediationAdFactory.expressFeed(it.next()));
                }
                nativeExpressAdListener.onExpressFeedAdLoad(arrayList);
            }
        });
    }

    @Override // com.tapsdk.tapad.group.DirichletAdNative
    public void loadInterstitialAd(DirichletAdRequest dirichletAdRequest, final DirichletAdNative.InterstitialAdListener interstitialAdListener) {
        load(AdType.InterstitialAd, dirichletAdRequest, new Callback<List<DirichletAd>>() { // from class: com.tapsdk.tapad.group.DirichletAdNativeImpl.2
            @Override // com.tapsdk.tapad.internal.Callback
            public void onFail(Exception exc) {
                DirichletAdNativeImpl.reportLoadFailure(interstitialAdListener, exc);
            }

            @Override // com.tapsdk.tapad.internal.Callback
            public void onSuccess(List<DirichletAd> list) {
                interstitialAdListener.onInterstitialAdLoad(MediationAdFactory.interstitial(list.get(0)));
            }
        });
    }

    @Override // com.tapsdk.tapad.group.DirichletAdNative
    public void loadNativeFeedAd(DirichletAdRequest dirichletAdRequest, final DirichletAdNative.NativeFeedAdListener nativeFeedAdListener) {
        load(AdType.NativeFeedAd, dirichletAdRequest, new Callback<List<DirichletAd>>() { // from class: com.tapsdk.tapad.group.DirichletAdNativeImpl.6
            @Override // com.tapsdk.tapad.internal.Callback
            public void onFail(Exception exc) {
                DirichletAdNativeImpl.reportLoadFailure(nativeFeedAdListener, exc);
            }

            @Override // com.tapsdk.tapad.internal.Callback
            public void onSuccess(List<DirichletAd> list) {
                ArrayList arrayList = new ArrayList();
                Iterator<DirichletAd> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(MediationAdFactory.nativeFeed(it.next()));
                }
                nativeFeedAdListener.onNativeFeedAdLoad(arrayList);
            }
        });
    }

    @Override // com.tapsdk.tapad.group.DirichletAdNative
    public void loadRewardVideoAd(DirichletAdRequest dirichletAdRequest, final DirichletAdNative.RewardVideoAdListener rewardVideoAdListener) {
        load(AdType.RewardedAd, dirichletAdRequest, new Callback<List<DirichletAd>>() { // from class: com.tapsdk.tapad.group.DirichletAdNativeImpl.1
            @Override // com.tapsdk.tapad.internal.Callback
            public void onFail(Exception exc) {
                DirichletAdNativeImpl.reportLoadFailure(rewardVideoAdListener, exc);
            }

            @Override // com.tapsdk.tapad.internal.Callback
            public void onSuccess(List<DirichletAd> list) {
                if (list != null) {
                    list.size();
                }
                if (list != null) {
                    try {
                        if (!list.isEmpty()) {
                            rewardVideoAdListener.onRewardVideoAdLoad(MediationAdFactory.reward(list.get(0)));
                            return;
                        }
                    } catch (Throwable th) {
                        if (list != null) {
                            for (DirichletAd dirichletAd : list) {
                                if (dirichletAd != null) {
                                    dirichletAd.destroy();
                                }
                            }
                        }
                        DirichletAdNativeImpl.reportLoadFailure(rewardVideoAdListener, new ClientException(Constants.SDK_AD_LOAD_ERROR_CODE, "reward result projection failed: ".concat(th.getClass().getSimpleName())));
                        return;
                    }
                }
                throw new IllegalArgumentException("empty mediation candidates");
            }
        });
    }

    @Override // com.tapsdk.tapad.group.DirichletAdNative
    public void loadSplashAd(DirichletAdRequest dirichletAdRequest, final DirichletAdNative.SplashAdListener splashAdListener) {
        load(AdType.SplashAd, dirichletAdRequest, new Callback<List<DirichletAd>>() { // from class: com.tapsdk.tapad.group.DirichletAdNativeImpl.4
            @Override // com.tapsdk.tapad.internal.Callback
            public void onFail(Exception exc) {
                DirichletAdNativeImpl.reportLoadFailure(splashAdListener, exc);
            }

            @Override // com.tapsdk.tapad.internal.Callback
            public void onSuccess(List<DirichletAd> list) {
                splashAdListener.onSplashAdLoad(MediationAdFactory.splash(list.get(0)));
            }
        });
    }

    @Override // com.tapsdk.tapad.group.DirichletAdNative
    public void preLoad(DirichletAdRequest dirichletAdRequest, int i) {
        if (i == 3) {
            this.autoPool.preloadReward(dirichletAdRequest);
        }
    }

    @Override // com.tapsdk.tapad.group.DirichletAdNative
    public void showBannerAutoAd(DirichletAdRequest dirichletAdRequest, ViewGroup viewGroup, DirichletAdNative.BannerAutoAdListener bannerAutoAdListener) {
        this.autoPool.showBanner(dirichletAdRequest, this.contextWeakReference.get(), viewGroup, bannerAutoAdListener);
    }

    @Override // com.tapsdk.tapad.group.DirichletAdNative
    public void showInterstitialAutoAd(DirichletAdRequest dirichletAdRequest, Activity activity, DirichletAdNative.InterstitialAutoAdListener interstitialAutoAdListener) {
        this.autoPool.showInterstitial(dirichletAdRequest, activity, interstitialAutoAdListener);
    }

    @Override // com.tapsdk.tapad.group.DirichletAdNative
    public void showRewardVideoAutoAd(DirichletAdRequest dirichletAdRequest, Activity activity, DirichletAdNative.RewardVideoAutoAdListener rewardVideoAutoAdListener) {
        this.autoPool.showReward(dirichletAdRequest, activity, rewardVideoAutoAdListener);
    }

    @Override // com.tapsdk.tapad.group.DirichletAdNative
    public void showSplashAutoAd(DirichletAdRequest dirichletAdRequest, ViewGroup viewGroup, DirichletAdNative.SplashAutoAdListener splashAutoAdListener) {
        this.autoPool.showSplash(dirichletAdRequest, viewGroup, splashAutoAdListener);
    }
}
