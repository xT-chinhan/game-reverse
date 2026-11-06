package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletBannerAd {
    private final MediationBannerSession ad;

    public interface BannerInteractionListener {
        void onAdClick();

        void onAdClose();

        void onAdShow();
    }

    public DirichletBannerAd(MediationBannerSession mediationBannerSession) {
        this.ad = mediationBannerSession;
        mediationBannerSession.setOuterAd(this);
    }

    public void destroy() {
        this.ad.destroy();
    }

    public View getBannerView() {
        return this.ad.getBannerView();
    }

    public Map<String, Object> getDirichletExtraInfo() {
        return this.ad.getDirichletExtraInfo();
    }

    public boolean isValid() {
        return MediationShowAdmissionBridge.isReady(this.ad, 4, this.ad.isValid());
    }

    public void loss(long j, String str, String str2) {
        this.ad.loss(j, str, str2);
    }

    public void setBannerInteractionListener(BannerInteractionListener bannerInteractionListener) {
        this.ad.setBannerInteractionListener(bannerInteractionListener);
    }

    public void show(Activity activity, int i, int i2) {
        this.ad.show(activity, i, i2);
    }

    public void win(long j) {
        this.ad.win(j);
    }
}
