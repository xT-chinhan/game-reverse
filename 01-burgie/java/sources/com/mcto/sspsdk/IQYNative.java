package com.mcto.sspsdk;

import com.mcto.sspsdk.ssp.callback.AdErrorCallback;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IQYNative {

    public interface BannerAdListener extends AdErrorCallback {
        void onBannerAdLoad(IQyBanner iQyBanner);
    }

    public interface FullScreenAdListener extends AdErrorCallback {
        void onFullScreenAdLoad(IQyFullScreenAd iQyFullScreenAd);
    }

    public interface QYNativeAdListener extends AdErrorCallback {
        void onNativeAdLoad(List<IQyNativeAd> list);
    }

    public interface RewardVideoAdListener extends AdErrorCallback {
        void onRewardVideoAdLoad(IQyRewardVideoAd iQyRewardVideoAd);
    }

    public interface SplashAdListener extends AdErrorCallback {
        void onSplashAdLoad(IQySplash iQySplash);

        void onTimeout();
    }

    void loadBannerAd(QyAdSlot qyAdSlot, BannerAdListener bannerAdListener);

    void loadFullScreenAd(QyAdSlot qyAdSlot, FullScreenAdListener fullScreenAdListener);

    void loadNativeAd(QyAdSlot qyAdSlot, QYNativeAdListener qYNativeAdListener);

    void loadRewardVideoAd(QyAdSlot qyAdSlot, RewardVideoAdListener rewardVideoAdListener);

    void loadSplashAd(QyAdSlot qyAdSlot, SplashAdListener splashAdListener);
}
