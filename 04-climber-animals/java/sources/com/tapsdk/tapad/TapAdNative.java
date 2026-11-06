package com.tapsdk.tapad;

import com.tapsdk.tapad.internal.CommonListener;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface TapAdNative {

    public interface BannerAdListener extends CommonListener {
        void onBannerAdLoad(TapBannerAd tapBannerAd);
    }

    public interface FeedAdListener extends CommonListener {
        void onFeedAdLoad(List<TapFeedAd> list);
    }

    public interface InterstitialAdListener extends CommonListener {
        void onInterstitialAdLoad(TapInterstitialAd tapInterstitialAd);
    }

    public interface RewardVideoAdListener extends CommonListener {
        void onRewardVideoAdLoad(TapRewardVideoAd tapRewardVideoAd);

        void onRewardVideoCached(TapRewardVideoAd tapRewardVideoAd);
    }

    public interface SplashAdListener extends CommonListener {
        void onSplashAdLoad(TapSplashAd tapSplashAd);
    }

    int canSwitchPassiveConnection();

    void dispose();

    void loadBannerAd(AdRequest adRequest, BannerAdListener bannerAdListener);

    void loadFeedAd(AdRequest adRequest, int i, FeedAdListener feedAdListener);

    void loadFeedAd(AdRequest adRequest, FeedAdListener feedAdListener);

    void loadInterstitialAd(AdRequest adRequest, InterstitialAdListener interstitialAdListener);

    void loadRewardVideoAd(AdRequest adRequest, RewardVideoAdListener rewardVideoAdListener);

    void loadSplashAd(AdRequest adRequest, SplashAdListener splashAdListener);

    void pause();

    void resume();

    void sendLossNotification(String str, Map<String, Object> map);
}
