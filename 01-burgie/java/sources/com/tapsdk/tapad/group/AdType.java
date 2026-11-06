package com.tapsdk.tapad.group;

/* JADX INFO: loaded from: classes2.dex */
public enum AdType {
    UNKOWN(0),
    Banner(2),
    RewardedAd(3),
    SplashAd(4),
    InterstitialAd(6),
    NativeFeedAd(1),
    ExpressFeedAd(5);

    int value;

    /* JADX INFO: renamed from: com.tapsdk.tapad.group.AdType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tapsdk$tapad$group$AdType;

        static {
            int[] iArr = new int[AdType.values().length];
            $SwitchMap$com$tapsdk$tapad$group$AdType = iArr;
            try {
                iArr[AdType.Banner.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$group$AdType[AdType.RewardedAd.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$group$AdType[AdType.SplashAd.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$group$AdType[AdType.NativeFeedAd.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$group$AdType[AdType.InterstitialAd.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$group$AdType[AdType.ExpressFeedAd.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    AdType(int i) {
        this.value = i;
    }

    public static AdType getAdTypeForValue(int i) {
        for (AdType adType : values()) {
            if (i == adType.value) {
                return adType;
            }
        }
        return UNKOWN;
    }

    public String getName() {
        switch (AnonymousClass1.$SwitchMap$com$tapsdk$tapad$group$AdType[ordinal()]) {
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
