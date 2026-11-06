package com.anythink.interstitial.api;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.common.u.o;
import com.anythink.interstitial.a.d;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ATInterstitialAutoAd {
    public static void init(Context context, String[] strArr, ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener) {
        init(context, strArr, aTInterstitialAutoLoadListener, null);
    }

    public static void init(Context context, String[] strArr, ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener, ATAdRequest aTAdRequest) {
        d.a().a(context, strArr, aTInterstitialAutoLoadListener, aTAdRequest);
    }

    public static void addPlacementId(String... strArr) {
        addPlacementId(null, strArr);
    }

    public static void addPlacementId(ATAdRequest aTAdRequest, String... strArr) {
        d.a().a(aTAdRequest, strArr);
    }

    public static void removePlacementId(String... strArr) {
        d.a();
        d.a(strArr);
    }

    public static void setLocalExtra(String str, Map<String, Object> map) {
        d.a();
        d.a(str, map);
    }

    public static void show(Activity activity, String str, ATInterstitialAutoEventListener aTInterstitialAutoEventListener) {
        show(activity, str, (ATShowConfig) null, aTInterstitialAutoEventListener);
    }

    @Deprecated
    public static void show(Activity activity, String str, String str2, ATInterstitialAutoEventListener aTInterstitialAutoEventListener) {
        show(activity, str, o.e(str2), aTInterstitialAutoEventListener);
    }

    public static void show(Activity activity, String str, ATShowConfig aTShowConfig, ATInterstitialAutoEventListener aTInterstitialAutoEventListener) {
        show(activity, str, aTShowConfig, aTInterstitialAutoEventListener, null);
    }

    public static void show(Activity activity, String str, ATShowConfig aTShowConfig, ATInterstitialAutoEventListener aTInterstitialAutoEventListener, ATAdRevenueListener aTAdRevenueListener) {
        d.a().a(activity, str, aTShowConfig, aTInterstitialAutoEventListener, aTAdRevenueListener);
    }

    public static boolean isAdReady(String str) {
        return d.a().b(str);
    }

    public static ATAdStatusInfo checkAdStatus(String str) {
        return d.a().c(str);
    }

    public static List<ATAdInfo> checkValidAdCaches(String str) {
        d.a();
        return d.d(str);
    }

    public static void entryAdScenario(String str, String str2) {
        d.a();
        d.a(str, str2, null);
    }

    public static void entryAdScenario(String str, String str2, Map<String, Object> map) {
        d.a();
        d.a(str, str2, map);
    }

    public static void setNativeAdCustomRender(ATNativeAdCustomRender aTNativeAdCustomRender) {
        d.a().a(aTNativeAdCustomRender);
    }

    public static void setAutoLoadListener(ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener) {
        d.a().a(aTInterstitialAutoLoadListener);
    }
}
