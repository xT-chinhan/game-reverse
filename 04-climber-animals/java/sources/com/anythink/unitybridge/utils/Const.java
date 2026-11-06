package com.anythink.unitybridge.utils;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Const {
    public static final int AREA_CHINESE_MAINLAND = 1;
    public static final int AREA_GLOBAL = 0;
    public static final boolean DEBUG = true;
    public static final String SCENARIO = "Scenario";

    public static class Interstital {
        public static final String UseRewardedVideoAsInterstitial = "UseRewardedVideoAsInterstitial";
        public static final String UseRewardedVideoAsInterstitialNo = "0";
        public static final String UseRewardedVideoAsInterstitialYes = "1";
        public static final String interstitial_ad_size = "interstitial_ad_size";
    }

    public static class Native {
        public static final String ADAPTIVE_HEIGHT = "AdaptiveHeight";
        public static final String ADAPTIVE_HEIGHT_YES = "1";
        public static final String POSITION = "Position";
        public static final String POSITION_BOTTOM = "Bottom";
        public static final String POSITION_TOP = "Top";
        public static final String native_ad_size = "native_ad_size";
    }

    public static void fillMapFromJsonObject(Map<String, Object> map, JSONObject jSONObject) {
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.opt(next));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
