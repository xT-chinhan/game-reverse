package com.tapsdk.tapad.group.ads;

import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletSplashAd {
    private final MediationSplashSession ad;

    public interface AdInteractionListener {
        void onAdClick();

        void onAdClose();

        void onAdShow();
    }

    public DirichletSplashAd(MediationSplashSession mediationSplashSession) {
        this.ad = mediationSplashSession;
        mediationSplashSession.setOuterAd(this);
    }

    public void destroy() {
        this.ad.destroy();
    }

    public Map<String, Object> getDirichletExtraInfo() {
        return this.ad.getDirichletExtraInfo();
    }

    public long getExpirationTimestamp() {
        return this.ad.getExpirationTimestamp();
    }

    public void loss(long j, String str, String str2) {
        this.ad.loss(j, str, str2);
    }

    public void setSplashInteractionListener(AdInteractionListener adInteractionListener) {
        this.ad.setSplashInteractionListener(adInteractionListener);
    }

    public void show(ViewGroup viewGroup) {
        this.ad.show(viewGroup);
    }

    public void win(long j) {
        this.ad.win(j);
    }
}
