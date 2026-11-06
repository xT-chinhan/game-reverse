package com.mar.sdk.taptap.ad;

import com.mar.sdk.MARSDK;
import com.mar.sdk.gg.AdInst;
import com.mar.sdk.log.Log;
import com.tapsdk.tapad.group.DirichletAdManager;
import com.tapsdk.tapad.group.DirichletAdNative;
import com.tapsdk.tapad.group.DirichletAdRequest;

/* JADX INFO: loaded from: classes2.dex */
public class AutoRewardAd extends AdInst {
    private static AutoRewardAd instance;
    private String adId;
    private DirichletAdNative adNative;

    public static synchronized AutoRewardAd getInstance() {
        if (instance == null) {
            instance = new AutoRewardAd();
        }
        return instance;
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doInit() {
        this.adNative = DirichletAdManager.get().createAdNative(MARSDK.getInstance().getContext());
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doLoad(String adId) {
        this.adId = adId;
        onLoad(true, null);
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doShow() {
        long spaceId = 0;
        try {
            spaceId = Long.parseLong(this.adId);
        } catch (Exception e) {
            Log.d("MARSDK-AD", "RewardAd spaceId:0 Exception:" + e.toString());
        }
        DirichletAdRequest request = new DirichletAdRequest.Builder().withSpaceId(spaceId).withUserId(MARSDK.getInstance().getSDKUserID()).withRewardName("金币").withRewardAmount(100).build();
        this.adNative.showRewardVideoAutoAd(request, MARSDK.getInstance().getContext(), new DirichletAdNative.RewardVideoAutoAdListener() { // from class: com.mar.sdk.taptap.ad.AutoRewardAd.1
            @Override // com.tapsdk.tapad.group.CommonListener
            public void onError(int code, String message) {
                Log.e("MARSDK-AD", "激励视频加载/展示失败: " + code + ", " + message);
                AutoRewardAd.this.onShow(false, code + "==" + message);
                AutoRewardAd.this.videoCallback(false);
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletRewardVideoAd.RewardAdInteractionListener
            public void onAdShow() {
                Log.d("MARSDK-AD", "激励视频展示");
                AutoRewardAd.this.onShow(true, null);
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletRewardVideoAd.RewardAdInteractionListener
            public void onAdClose() {
                Log.d("MARSDK-AD", "激励视频关闭");
                AutoRewardAd.this.onHide();
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(boolean rewardVerify, int rewardAmount, String rewardName, int code, String msg) {
                if (rewardVerify) {
                    Log.d("MARSDK-AD", "获得奖励: " + rewardAmount + " " + rewardName);
                }
                AutoRewardAd.this.videoCallback(rewardVerify);
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletRewardVideoAd.RewardAdInteractionListener
            public void onAdClick() {
                Log.d("MARSDK-AD", "激励视频点击");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void videoCallback(boolean isReward) {
        MARSDK.getInstance().onResult(100, isReward ? "1" : "0");
        onResult(isReward);
    }
}
