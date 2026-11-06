package com.anythink.rewardvideo.api;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.common.v.p;
import com.anythink.rewardvideo.a.c;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ATRewardVideoAutoAd {
    public static void init(Context context, String[] strArr, ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener) {
        init(context, strArr, aTRewardVideoAutoLoadListener, null);
    }

    public static void init(Context context, String[] strArr, ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener, ATAdRequest aTAdRequest) {
        c.a().a(context, strArr, aTRewardVideoAutoLoadListener, aTAdRequest);
    }

    public static void addPlacementId(String... strArr) {
        addPlacementId(null, strArr);
    }

    public static void addPlacementId(ATAdRequest aTAdRequest, String... strArr) {
        c.a().a(aTAdRequest, strArr);
    }

    public static void removePlacementId(String... strArr) {
        c.a();
        c.a(strArr);
    }

    public static void setLocalExtra(String str, Map<String, Object> map) {
        c.a();
        c.a(str, map);
    }

    public static void show(Activity activity, String str, ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener) {
        show(activity, str, "", aTRewardVideoAutoEventListener);
    }

    @Deprecated
    public static void show(Activity activity, String str, String str2, ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener) {
        show(activity, str, p.e(str2), aTRewardVideoAutoEventListener);
    }

    public static void show(Activity activity, String str, ATShowConfig aTShowConfig, ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener) {
        show(activity, str, aTShowConfig, aTRewardVideoAutoEventListener, null);
    }

    public static void show(Activity activity, String str, ATShowConfig aTShowConfig, ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener, ATAdRevenueListener aTAdRevenueListener) {
        c.a().a(activity, str, aTShowConfig, aTRewardVideoAutoEventListener, aTAdRevenueListener);
    }

    public static boolean isAdReady(String str) {
        return c.a().b(str);
    }

    public static ATAdStatusInfo checkAdStatus(String str) {
        return c.a().c(str);
    }

    public static List<ATAdInfo> checkValidAdCaches(String str) {
        return c.a().d(str);
    }

    public static void entryAdScenario(String str, String str2) {
        c.a();
        c.a(str, str2, null);
    }

    public static void entryAdScenario(String str, String str2, Map<String, Object> map) {
        c.a();
        c.a(str, str2, map);
    }

    public static void setAutoLoadListener(ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener) {
        c.a().a(aTRewardVideoAutoLoadListener);
    }
}
