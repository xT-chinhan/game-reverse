package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletRewardVideoAd {
    private final MediationRewardSession ad;

    public interface RewardAdInteractionListener {
        void onAdClick();

        void onAdClose();

        void onAdShow();

        void onRewardVerify(boolean z, int i, String str, int i2, String str2);
    }

    public DirichletRewardVideoAd(MediationRewardSession mediationRewardSession) {
        this.ad = mediationRewardSession;
        mediationRewardSession.setOuterAd(this);
    }

    public void destroy() {
        this.ad.destroy();
    }

    public Map<String, Object> getDirichletExtraInfo() {
        return this.ad.getDirichletExtraInfo();
    }

    public boolean isValid() {
        return MediationShowAdmissionBridge.isReady(this.ad, 1, this.ad.isValid());
    }

    public void loss(long j, String str, String str2) {
        this.ad.loss(j, str, str2);
    }

    public void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener) {
        this.ad.setRewardAdInteractionListener(rewardAdInteractionListener);
    }

    public void showRewardVideoAd(Activity activity) {
        this.ad.showRewardVideoAd(activity);
    }

    public void win(long j) {
        this.ad.win(j);
    }
}
