package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletInterstitialAd {
    private final MediationInterstitialSession ad;

    public interface InterstitialAdInteractionListener {
        void onAdClick();

        void onAdClose();

        void onAdShow();
    }

    public DirichletInterstitialAd(MediationInterstitialSession mediationInterstitialSession) {
        this.ad = mediationInterstitialSession;
        mediationInterstitialSession.setOuterAd(this);
    }

    public void destroy() {
        this.ad.destroy();
    }

    public Map<String, Object> getDirichletExtraInfo() {
        return this.ad.getDirichletExtraInfo();
    }

    public boolean isValid() {
        return MediationShowAdmissionBridge.isReady(this.ad, 2, this.ad.isValid());
    }

    public void loss(long j, String str, String str2) {
        this.ad.loss(j, str, str2);
    }

    public void setInteractionListener(InterstitialAdInteractionListener interstitialAdInteractionListener) {
        this.ad.setInteractionListener(interstitialAdInteractionListener);
    }

    public void show(Activity activity) {
        this.ad.show(activity);
    }

    public void win(long j) {
        this.ad.win(j);
    }
}
