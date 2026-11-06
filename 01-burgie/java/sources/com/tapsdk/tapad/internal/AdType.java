package com.tapsdk.tapad.internal;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public enum AdType {
    Banner,
    RewardedAd,
    SplashAd,
    NativeFeedAd,
    InterstitialAd,
    ExpressFeedAd;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.AdType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tapsdk$tapad$internal$AdType;

        static {
            int[] iArr = new int[AdType.values().length];
            $SwitchMap$com$tapsdk$tapad$internal$AdType = iArr;
            try {
                iArr[AdType.Banner.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$internal$AdType[AdType.RewardedAd.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$internal$AdType[AdType.SplashAd.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$internal$AdType[AdType.NativeFeedAd.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$internal$AdType[AdType.InterstitialAd.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$internal$AdType[AdType.ExpressFeedAd.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static AdType fromWireName(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = str.trim().replace("-", "").replace("_", "").replace(" ", "").toLowerCase(Locale.US);
        if (lowerCase.length() == 0) {
            return null;
        }
        if ("reward".equals(lowerCase) || "rewarded".equals(lowerCase) || "rewardedad".equals(lowerCase) || "rewardvideo".equals(lowerCase)) {
            return RewardedAd;
        }
        if (MediationConstant.RIT_TYPE_BANNER.equals(lowerCase) || "bannerad".equals(lowerCase)) {
            return Banner;
        }
        if (MediationConstant.RIT_TYPE_SPLASH.equals(lowerCase) || "splashad".equals(lowerCase)) {
            return SplashAd;
        }
        if ("nativefeed".equals(lowerCase) || "nativefeedad".equals(lowerCase) || "feednative".equals(lowerCase)) {
            return NativeFeedAd;
        }
        if (MediationConstant.RIT_TYPE_INTERSTITIAL.equals(lowerCase) || "interstitialad".equals(lowerCase)) {
            return InterstitialAd;
        }
        if ("expressfeed".equals(lowerCase) || "expressfeedad".equals(lowerCase)) {
            return ExpressFeedAd;
        }
        return null;
    }

    public String getName() {
        switch (AnonymousClass1.$SwitchMap$com$tapsdk$tapad$internal$AdType[ordinal()]) {
            case 1:
                return "Banner";
            case 2:
                return "RewardedAd";
            case 3:
                return "SplashAd";
            case 4:
                return "NativeFeedAd";
            case 5:
                return "InterstitialAd";
            case 6:
                return "ExpressFeedAd";
            default:
                return "";
        }
    }
}
