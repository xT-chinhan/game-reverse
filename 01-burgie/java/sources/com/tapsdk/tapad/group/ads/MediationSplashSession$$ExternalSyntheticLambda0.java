package com.tapsdk.tapad.group.ads;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class MediationSplashSession$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DirichletSplashAd.AdInteractionListener f$0;

    public /* synthetic */ MediationSplashSession$$ExternalSyntheticLambda0(DirichletSplashAd.AdInteractionListener adInteractionListener) {
        this.f$0 = adInteractionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.onAdClose();
    }
}
