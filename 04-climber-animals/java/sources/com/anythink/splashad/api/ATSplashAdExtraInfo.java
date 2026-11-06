package com.anythink.splashad.api;

/* JADX INFO: loaded from: classes.dex */
public class ATSplashAdExtraInfo {
    private IATSplashEyeAd atSplashEyeAd;
    private int dismissType;

    public ATSplashAdExtraInfo(int i, IATSplashEyeAd iATSplashEyeAd) {
        this.dismissType = i;
        this.atSplashEyeAd = iATSplashEyeAd;
    }

    public int getDismissType() {
        return this.dismissType;
    }

    public IATSplashEyeAd getAtSplashEyeAd() {
        return this.atSplashEyeAd;
    }
}
