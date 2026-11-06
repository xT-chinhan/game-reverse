package com.mar.sdk.taptap.ad;

import com.mar.sdk.MARSDK;
import com.mar.sdk.gg.AdInst;
import com.mar.sdk.log.Log;
import com.tapsdk.tapad.group.DirichletAdManager;
import com.tapsdk.tapad.group.DirichletAdNative;
import com.tapsdk.tapad.group.DirichletAdRequest;
import com.tapsdk.tapad.group.ads.DirichletRewardVideoAd;

/* JADX INFO: loaded from: classes2.dex */
public class RewardAd extends AdInst {
    private static RewardAd instance;
    private DirichletAdNative adNative;
    private DirichletRewardVideoAd tapRewardVideoAd;

    public static synchronized RewardAd getInstance() {
        if (instance == null) {
            instance = new RewardAd();
        }
        return instance;
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doInit() {
        this.adNative = DirichletAdManager.get().createAdNative(MARSDK.getInstance().getContext());
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doLoad(String adId) {
        this.adNative = DirichletAdManager.get().createAdNative(MARSDK.getInstance().getContext());
        int spaceId = 0;
        try {
            spaceId = Integer.parseInt(adId);
        } catch (Exception e) {
            Log.d("MARSDK-AD", "RewardAd spaceId:0 Exception:" + e.toString());
        }
        DirichletAdRequest request = new DirichletAdRequest.Builder().withSpaceId(spaceId).withRewardName("奖品").withRewardAmount(1).withExtra1("extra_info").withUserId(MARSDK.getInstance().getSDKUserID()).build();
        this.adNative.loadRewardVideoAd(request, new DirichletAdNative.RewardVideoAdListener() { // from class: com.mar.sdk.taptap.ad.RewardAd.1
            @Override // com.tapsdk.tapad.group.DirichletAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(DirichletRewardVideoAd dirichletRewardVideoAd) {
                RewardAd.this.tapRewardVideoAd = dirichletRewardVideoAd;
                RewardAd.this.onLoad(true, null);
            }

            @Override // com.tapsdk.tapad.group.CommonListener
            public void onError(int code, String message) {
                Log.d("MARSDK-AD", "RewardAd onError:" + code + "==" + message);
                RewardAd.this.onLoad(false, code + "==" + message);
            }
        });
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doShow() {
        DirichletRewardVideoAd dirichletRewardVideoAd = this.tapRewardVideoAd;
        if (dirichletRewardVideoAd == null) {
            Log.d("MARSDK-AD", "RewardAd tapRewardVideoAd is null");
            onShow(false, null);
        } else {
            dirichletRewardVideoAd.setRewardAdInteractionListener(new DirichletRewardVideoAd.RewardAdInteractionListener() { // from class: com.mar.sdk.taptap.ad.RewardAd.2
                @Override // com.tapsdk.tapad.group.ads.DirichletRewardVideoAd.RewardAdInteractionListener
                public void onAdShow() {
                    Log.d("MARSDK-AD", "RewardAd onAdShow");
                    RewardAd.this.onShow(true, null);
                }

                @Override // com.tapsdk.tapad.group.ads.DirichletRewardVideoAd.RewardAdInteractionListener
                public void onAdClose() {
                    Log.d("MARSDK-AD", "RewardAd onAdClose");
                    RewardAd.this.onHide();
                }

                @Override // com.tapsdk.tapad.group.ads.DirichletRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify(boolean rewardVerify, int rewardAmount, String rewardName, int code, String msg) {
                    RewardAd.this.videoCallback(rewardVerify);
                }

                @Override // com.tapsdk.tapad.group.ads.DirichletRewardVideoAd.RewardAdInteractionListener
                public void onAdClick() {
                    RewardAd.this.onClick();
                }
            });
            this.tapRewardVideoAd.showRewardVideoAd(MARSDK.getInstance().getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void videoCallback(boolean isReward) {
        MARSDK.getInstance().onResult(100, isReward ? "1" : "0");
        onResult(isReward);
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doHide() {
        DirichletRewardVideoAd dirichletRewardVideoAd = this.tapRewardVideoAd;
        if (dirichletRewardVideoAd != null) {
            dirichletRewardVideoAd.destroy();
        }
        this.tapRewardVideoAd = null;
    }
}
