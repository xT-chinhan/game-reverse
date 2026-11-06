package com.anythink.network.toutiao;

import com.bytedance.sdk.openadsdk.TTAdSdk;

/* JADX INFO: loaded from: classes.dex */
public class TTATConst {
    public static final String AD_LOAD_TYPE = "tt_ad_load_type";
    public static final String CUSTOM_DISLIKE_INFO = "tt_custom_dislike_info";
    public static final String NATIVE_AD_IMAGE_HEIGHT = "tt_image_height";
    public static final String NATIVE_AD_INTERRUPT_VIDEOPLAY = "tt_can_interrupt_video";
    public static final String NATIVE_AD_VIDEOPLAY_BTN_BITMAP = "tt_video_play_btn_bitmap";
    public static final String NATIVE_AD_VIDEOPLAY_BTN_SIZE = "tt_video_play_btn_SIZE";
    public static final int NETWORK_FIRM_ID = 15;
    static String a = null;
    public static boolean hasRequestPermission = false;

    public static class DEBUGGER_CONFIG {
        public static final int TT_INTERSTITIAL = 3;
        public static final int TT_NATIVE_DRAW_SELF_RENDER = 202;
        public static final int TT_NATIVE_DRAW_TEMPLATE = 201;
        public static final int TT_NATIVE_SELF_RENDER = 102;
        public static final int TT_NATIVE_TEMPLATE = 101;
        public static final int TT_NETWORK = 15;
    }

    public static class REWARD_EXTRA {
        public static final String REWARD_EXTRA_KEY_BUNDLE = "tt_bundle";
        public static final String REWARD_EXTRA_KEY_REWARD_TYPE = "tt_reward_type";
    }

    public static String getNetworkVersion() {
        String str = a;
        if (str != null) {
            return str;
        }
        try {
            String sDKVersion = TTAdSdk.getAdManager().getSDKVersion();
            a = sDKVersion;
            return sDKVersion;
        } catch (Throwable unused) {
            a = "";
            return "";
        }
    }
}
