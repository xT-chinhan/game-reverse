package com.tapsdk.tapad.group;

import android.app.Activity;
import android.view.ViewGroup;
import com.tapsdk.tapad.group.ads.DirichletBannerAd;
import com.tapsdk.tapad.group.ads.DirichletExpressFeedAd;
import com.tapsdk.tapad.group.ads.DirichletInterstitialAd;
import com.tapsdk.tapad.group.ads.DirichletNativeFeedAd;
import com.tapsdk.tapad.group.ads.DirichletRewardVideoAd;
import com.tapsdk.tapad.group.ads.DirichletSplashAd;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface DirichletAdNative {

    public interface BannerAdListener extends CommonListener {
        void onBannerAdLoad(DirichletBannerAd dirichletBannerAd);
    }

    public interface BannerAutoAdListener extends CommonListener, DirichletBannerAd.BannerInteractionListener {
    }

    @Deprecated
    public interface FeedAdListener extends CommonListener {
        void onFeedAdLoad(List<DirichletNativeFeedAd> list);
    }

    public interface InterstitialAdListener extends CommonListener {
        void onInterstitialAdLoad(DirichletInterstitialAd dirichletInterstitialAd);
    }

    public interface InterstitialAutoAdListener extends CommonListener, DirichletInterstitialAd.InterstitialAdInteractionListener {
    }

    public interface NativeExpressAdListener extends CommonListener {
        void onExpressFeedAdLoad(List<DirichletExpressFeedAd> list);
    }

    public interface NativeFeedAdListener extends CommonListener {
        void onNativeFeedAdLoad(List<DirichletNativeFeedAd> list);
    }

    public interface RewardVideoAdListener extends CommonListener {
        void onRewardVideoAdLoad(DirichletRewardVideoAd dirichletRewardVideoAd);
    }

    public interface RewardVideoAutoAdListener extends CommonListener, DirichletRewardVideoAd.RewardAdInteractionListener {
    }

    public interface SplashAdListener extends CommonListener {
        void onSplashAdLoad(DirichletSplashAd dirichletSplashAd);
    }

    public interface SplashAutoAdListener extends CommonListener, DirichletSplashAd.AdInteractionListener {
    }

    void loadBannerAd(DirichletAdRequest dirichletAdRequest, BannerAdListener bannerAdListener);

    void loadExpressFeedAd(DirichletAdRequest dirichletAdRequest, NativeExpressAdListener nativeExpressAdListener);

    void loadInterstitialAd(DirichletAdRequest dirichletAdRequest, InterstitialAdListener interstitialAdListener);

    void loadNativeFeedAd(DirichletAdRequest dirichletAdRequest, NativeFeedAdListener nativeFeedAdListener);

    void loadRewardVideoAd(DirichletAdRequest dirichletAdRequest, RewardVideoAdListener rewardVideoAdListener);

    void loadSplashAd(DirichletAdRequest dirichletAdRequest, SplashAdListener splashAdListener);

    void preLoad(DirichletAdRequest dirichletAdRequest, int i);

    void showBannerAutoAd(DirichletAdRequest dirichletAdRequest, ViewGroup viewGroup, BannerAutoAdListener bannerAutoAdListener);

    void showInterstitialAutoAd(DirichletAdRequest dirichletAdRequest, Activity activity, InterstitialAutoAdListener interstitialAutoAdListener);

    void showRewardVideoAutoAd(DirichletAdRequest dirichletAdRequest, Activity activity, RewardVideoAutoAdListener rewardVideoAutoAdListener);

    void showSplashAutoAd(DirichletAdRequest dirichletAdRequest, ViewGroup viewGroup, SplashAutoAdListener splashAutoAdListener);
}
