package com.anythink.network.baidu;

import com.baidu.mobads.sdk.api.AdSettings;

/* JADX INFO: loaded from: classes.dex */
public class BaiduATConst {
    public static final String EN_P_KEY = "en_p";
    public static final String EXPECTED_SIZE_HEIGHT = "bd_expected_size_height";
    public static final String EXPECTED_SIZE_WIDTH = "bd_expected_size_width";
    public static final int NETWORK_FIRM_ID = 22;
    public static final String REQUEST_PARAMS_CUST_EXT = "request_params_cust_ext";
    public static final String REQUEST_PARAMS_EXT = "request_params_ext";
    public static final String STYLE_BUILDER = "baidu_style_builder";

    public static class DEBUGGER_CONFIG {
        public static final int BAIDU_INTERSTITIAL_FULL_SCREEN = 2;
        public static final int BAIDU_INTERSTITIAL_TEMPLATE = 3;
        public static final int BAIDU_NATIVE_SELF_RENDER = 1;
        public static final int BAIDU_NATIVE_TEMPLATE = 2;
        public static final int BAIDU_NETWORK = 22;
    }

    public static String getNetworkVersion() {
        try {
            return AdSettings.getSDKVersion();
        } catch (Throwable unused) {
            return "";
        }
    }
}
