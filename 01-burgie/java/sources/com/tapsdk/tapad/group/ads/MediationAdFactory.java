package com.tapsdk.tapad.group.ads;

import com.tapsdk.tapad.group.AdNetworkType;
import com.tapsdk.tapad.group.DirichletAdRequest;
import com.tapsdk.tapad.group.adapter.AdapterBannerSession;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedSession;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialSession;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession;
import com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession;
import com.tapsdk.tapad.group.adapter.AdapterRewardSession;
import com.tapsdk.tapad.group.adapter.AdapterSplashSession;
import com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge;

/* JADX INFO: loaded from: classes2.dex */
public final class MediationAdFactory {
    private MediationAdFactory() {
    }

    public static DirichletBannerAd banner(DirichletAd dirichletAd) {
        return new DirichletBannerAd((MediationBannerSession) require(dirichletAd, MediationBannerSession.class));
    }

    public static DirichletAd bannerCandidate(AdapterBannerSession adapterBannerSession) {
        return new MediationBannerSession(adapterBannerSession);
    }

    public static boolean bindLoadedCandidate(DirichletAd dirichletAd, String str, AdNetworkType adNetworkType, boolean z, int i, DirichletAdRequest dirichletAdRequest, String str2, int i2, int i3, long j) {
        return bindLoadedCandidate(dirichletAd, str, adNetworkType, z, i, dirichletAdRequest, str2, i2, 0L, i3, j);
    }

    public static DirichletExpressFeedAd expressFeed(DirichletAd dirichletAd) {
        return new DirichletExpressFeedAd((MediationExpressFeedSession) require(dirichletAd, MediationExpressFeedSession.class));
    }

    public static DirichletAd expressFeedCandidate(AdapterExpressFeedSession adapterExpressFeedSession) {
        return new MediationExpressFeedSession(adapterExpressFeedSession);
    }

    public static DirichletInterstitialAd interstitial(DirichletAd dirichletAd) {
        return new DirichletInterstitialAd((MediationInterstitialSession) require(dirichletAd, MediationInterstitialSession.class));
    }

    public static DirichletAd interstitialCandidate(AdapterInterstitialSession adapterInterstitialSession) {
        return new MediationInterstitialSession(adapterInterstitialSession);
    }

    public static DirichletNativeFeedAd nativeFeed(DirichletAd dirichletAd) {
        return new DirichletNativeFeedAd((MediationNativeFeedSession) require(dirichletAd, MediationNativeFeedSession.class));
    }

    public static DirichletAd nativeFeedCandidate(AdapterNativeFeedSession adapterNativeFeedSession) {
        return new MediationNativeFeedSession(adapterNativeFeedSession);
    }

    private static <T extends DirichletAd> T require(DirichletAd dirichletAd, Class<T> cls) {
        if (cls.isInstance(dirichletAd)) {
            return cls.cast(dirichletAd);
        }
        throw new IllegalArgumentException("unexpected mediation candidate");
    }

    public static DirichletRewardVideoAd reward(DirichletAd dirichletAd) {
        return new DirichletRewardVideoAd((MediationRewardSession) require(dirichletAd, MediationRewardSession.class));
    }

    public static DirichletAd rewardCandidate(AdapterRewardSession adapterRewardSession) {
        return new MediationRewardSession(adapterRewardSession);
    }

    public static DirichletSplashAd splash(DirichletAd dirichletAd) {
        return new DirichletSplashAd((MediationSplashSession) require(dirichletAd, MediationSplashSession.class));
    }

    public static DirichletAd splashCandidate(AdapterSplashSession adapterSplashSession) {
        return adapterSplashSession instanceof AdapterNativeSplashSession ? new MediationNativeSplashSession((AdapterNativeSplashSession) adapterSplashSession) : new MediationSplashSession(adapterSplashSession);
    }

    public static boolean bindLoadedCandidate(DirichletAd dirichletAd, String str, AdNetworkType adNetworkType, boolean z, int i, DirichletAdRequest dirichletAdRequest, String str2, int i2, long j, int i3, long j2) {
        Boolean boolRecordFill;
        if (dirichletAd == null || adNetworkType == null || dirichletAdRequest == null) {
            return false;
        }
        DirichletAd.ProviderFacts providerFacts = dirichletAd.readProviderFacts();
        if (!dirichletAd.bindLoad(str, str2, providerFacts.adnTrackId, adNetworkType, dirichletAdRequest.expressViewAcceptedWidth, dirichletAdRequest.expressViewAcceptedHeight, z, i) || (boolRecordFill = MediationRuntimeCoreBridge.recordFill(str, i2, j, i3, dirichletAd.readProviderPriceFact(), j2, dirichletAd.getTrackId(), dirichletAd.getAdnTrackId(), providerFacts.adnExtraInfo)) == null) {
            return false;
        }
        dirichletAd.installCorePriceDisclosure(boolRecordFill.booleanValue());
        return true;
    }
}
