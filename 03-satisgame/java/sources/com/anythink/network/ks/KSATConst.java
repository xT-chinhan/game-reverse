package com.anythink.network.ks;

import com.kwad.sdk.api.KsAdSDK;

/* JADX INFO: loaded from: classes.dex */
public class KSATConst {
    public static final String KS_LLS_ID = "llsid";
    public static final String NATIVE_AD_SOURCE_LOGO_TYPE = "KS_NATIVE_AD_SOURCE_LOGO_TYPE";
    public static final String NATIVE_CONVERT_TYPE_KEY = "KS_NATIVE_CONVERT_TYPE";
    public static final String NATIVE_SHOW_LIVE_STATUS = "KS_NATIVE_SHOW_LIVE_STATUS";
    public static final String NATIVE_SHOW_LIVE_STYLE = "KS_NATIVE_SHOW_LIVE_STYLE";
    public static final int NETWORK_FIRM_ID = 28;
    public static final String REWARDEDVIDEO_SKIP_AFTER_THIRTY_SECOND = "KS_RV_SKIP_AFTER_THIRTY_SECOND";
    public static final String TK_REQUEST_ID = "request_id";

    public static class AD_SOURCE_LOGO_TYPE {
        public static final int GREY = 1;
        public static final int NORMAL = 0;
    }

    public static class DEBUGGER_CONFIG {
        public static final int KS_NATIVE_DRAW = 200;
        public static final int KS_NATIVE_SELF_RENDER = 101;
        public static final int KS_NATIVE_TEMPLATE = 102;
        public static final int KS_NETWORK = 28;
    }

    public static class NATIVE_CONVERT_TYPE {
        public static final int CONVERT = 1;
        public static final int CONVERT_CLICK = 3;
        public static final int CONVERT_SLIDE = 5;
        public static final int SHOW_DOWNLOAD_TIPS_DIALOG = 2;
        public static final int SHOW_DOWNLOAD_TIPS_DIALOG_CLICK = 4;
        public static final int SHOW_DOWNLOAD_TIPS_DIALOG_SLIDE = 6;
    }

    public static String getNetworkVersion() {
        try {
            return KsAdSDK.getSDKVersion();
        } catch (Throwable unused) {
            return "";
        }
    }
}
