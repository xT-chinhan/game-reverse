package com.tapsdk.tapad.constants;

/* JADX INFO: loaded from: classes3.dex */
public class Constants {

    public static class AdError {
        public static final int ERROR_CODE_UNKNOWN = 19999;
        public static final String ERROR_MESSAGE_DEFAULT = "unknown";
    }

    public static class AdTypeName {
        public static final String BANNER = "banner";
        public static final String REWARD = "reward";
        public static final String SPLASH = "splash";
    }

    public static class Bidding {
        public static final String ADN_ID = "adn_id";
        public static final String EXPECT_COST_PRICE = "expect_cost_price";
        public static final String HIGHEST_LOSS_PRICE = "highest_loss_price";
        public static final String LOSS_REASON = "lose_reason";
        public static final String REQUEST_ID = "request_id";
        public static final String REQ_UUID = "req_uuid";
        public static final String SPACE_ID = "space_id";
        public static final String WIN_PRICE = "win_price";
    }

    public static class BiddingLossReason {
        public static final int LOW_PRICE = 1;
        public static final int NOT_COMPETITION = 101;
        public static final int NO_AD = 2;
        public static final int OTHER = 10001;
    }

    public static class DownloadError {
        public static final int ERROR_CODE_CANCEL = 6;
        public static final int ERROR_CODE_COMPLETE_WITH_CACHED_FILE = 3;
        public static final int ERROR_CODE_INVALID_URL = 0;
        public static final int ERROR_CODE_NETWORK_DISCONNECTED = 1;
        public static final int ERROR_CODE_NO_SUFFICIENT_STORAGE = 2;
        public static final int ERROR_CODE_OTHER = 7;
        public static final int ERROR_CODE_PRE_ALLOCATE_FAILED = 5;
        public static final int ERROR_CODE_SAME_TASK_RUNNING = 4;
    }

    public static class ImageMode {
        public static final int BIG_IMAGE = 1;
        public static final int VIDEO = 2;
    }

    public static class InteractionType {
        public static final int DEEPLINK = 2;
        public static final int DOWNLOAD = 1;
        public static final int H5URL = 3;
        public static final int MINIPROGRAM = 4;
    }

    public static class LandingType {
        public static final int LANDINGTYPE_DEFAULT = 0;
        public static final int LANDINGTYPE_WEBVIEW = 1;
        public static final int LANDINGTYPE_WEBVIEW_302 = 2;
    }

    public static class LogoStatus {
        public static final int HIDE = 2;
        public static final int SHOW = 1;
    }

    public static class a {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
    }

    public static class b {
        public static final String a = "TapAdSDK";
        public static final String b = "AdMaterial";
        public static final String c = "AdRecord";
        public static final String d = "TapADNSdk/3.16.3.45";
    }

    public static class c {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        public static final int g = 6;
        public static final int h = 7;
        public static final int i = 8;
        public static final int j = 9;
        public static final int k = 10;
        public static final int l = 11;
    }

    public static class d {
        public static int a = 0;
        public static int b = 1;
    }

    public static class e {
        public static final String a = "crash";
        public static final String b = "error";
        public static final String c = "all";
    }

    public static class f {
        public static final String a = "download_cancelable_switch";
        public static final String b = "tapfeedad_passive_native_support_switch";
        public static final String c = "custom_playtime_switch";
        public static final String d = "tapfeedad_preload_support_switch";
        public static final String e = "interstitial_dismiss_enable_switch";
        public static final String f = "browser_ua_enable";
        public static final String g = "net_host_whitelist";
        public static final String h = "event_tracker_option";
        public static final String i = "event_flag_is_new_inner_browser";
        public static final String j = "event_flag_is_new_inner_browser_v2";
        public static final String k = "event_flag_is_new_view_monitor";
        public static final String l = "sdk_crash_log_is_open";
        public static final String m = "sdk_oaid_manufacturer_open";
        public static final String n = "dns_complete_log";
    }

    public static class g {
        public static final String a = "Content-Type";
        public static final String b = "User-Agent";
        public static final String c = "Content-Length";
    }

    public static class h {
        public static final float a = 120.0f;
        public static final int b = 120;
        public static final int c = 120;
        public static final int d = 120;
        public static final float e = 30.0f;
        public static final float f = 30.0f;
        public static final float g = 30.0f;
    }

    public static class i {
        public static final int a = 1008614;
        public static final int b = 1008610;
        public static final int c = 1008612;
        public static final int d = 1008613;
        public static final int e = 1008611;
        public static final int f = 1008615;
    }

    public static class j {
        public static final String a = "UnSupported devices";
        public static final String b = "Load certificate error.Pls confirm msa certificate";
        public static final String c = "Unsupported manufactures";
        public static final String d = "Call msa sdk error";
    }

    public static class k {
        public static final int a = 0;
        public static final int b = -1;
        public static final int c = 1;
        public static final int d = 1000;
        public static final int e = 1001;
        public static final int f = 1002;
        public static final int g = 1003;
        public static final int h = 1004;
        public static final int i = 2001;
        public static final int j = 2002;
        public static final int k = 2003;
        public static final int l = 2004;
        public static final int m = 2005;
    }

    public static class l {
        public static final String a = "NO ERROR";
        public static final String b = "未知错误";
        public static final String c = "流程正在执行中";
        public static final String d = "OAID client init fail";
        public static final String e = "The MSA OAID SDK is Not imported into the project / UnSupported MSA OAID SDK version";
        public static final String f = "The certificate configuration is abnormal; Pls check certificate file name is ${packageName}.cert.pem and file is placed in the src/main/assets";
        public static final String g = "OAID client init timeout";
        public static final String h = "OAID client init interrupted";
        public static final String i = "OAID client fetch msa interface error:refer msa";
        public static final String j = "MSA interface error";
        public static final String k = "OAID client fetch timeout";
        public static final String l = "OAID client fetch interrupted";
        public static final String m = "OAID client fetch result is invalid";
    }

    public static class m {
        public static final int a = 0;
        public static final int b = 1;
    }

    public static class n {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2000;
    }

    public static class o {
        public static final String a = "runtime_environment";
        public static final int b = 0;
        public static final int c = 1;
    }

    public static class p {
        public static final String a = "ad_info";
    }

    public static class q {
        public static String a = "sdk_download";
        public static String b = "download_complete_has_old_downloaded_file";
    }

    public static class r {
        public static final int a = 5000;
    }

    public static class s {
        public static int a = 0;
        public static int b = 1;
    }

    public static class t {
        public static int a = 18;
        public static int b = 8;
        public static int c = 9;
    }

    public static class u {
        public static final String a = "internal_web_view_exception";
    }
}
