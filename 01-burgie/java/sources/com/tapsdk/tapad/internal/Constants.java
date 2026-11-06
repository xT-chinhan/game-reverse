package com.tapsdk.tapad.internal;

import com.tapsdk.tapad.constants.ErrorCodeEnum;

/* JADX INFO: loaded from: classes2.dex */
public class Constants {

    public static class AdError {
        public static final int ERROR_CODE_UNKNOWN = ErrorCodeEnum.UNKNOWN_ERROR.getCode();
    }

    public static class CacheKeys {
        public static final String DEVICE_ID = "td_c7";
        public static final String OAID = "oaid";
        public static final String PERMISSION_REQUESTED = "permission_requested";
        public static final String PREFERENCES_NAME = "tap_cache";
    }

    public static class HTTP_STANDARD_HEADERS {
        public static final String USER_AGENT = "User-Agent";
    }

    public static class InteractionType {
        public static final int DEEPLINK = 2;
        public static final int H5URL = 3;
        public static final int MINIPROGRAM = 4;
    }

    public static class MSAOAIDErrorCode {
        public static final int INIT_ERROR_DEVICE_NO_SUPPORT = 1008612;
        public static final int INIT_ERROR_HELPER_CALL_ERROR = 1008615;
        public static final int INIT_ERROR_LOAD_CONFIG_FILE = 1008613;
        public static final int INIT_ERROR_MANUFACTURER_NO_SUPPORT = 1008611;
        public static final int INIT_ERROR_RESULT_DELAY = 1008614;
        public static final int INIT_RESULT_OK = 1008610;
    }

    public static class MSAOAIDErrorMessage {
        public static final String INIT_ERROR_DEVICE_NO_SUPPORT = "UnSupported devices";
        public static final String INIT_ERROR_INIT_SDK_ERROR = "Call msa sdk error";
        public static final String INIT_ERROR_LOAD_CONFIG_FILE = "Load certificate error.Pls confirm msa certificate";
        public static final String INIT_ERROR_MANUFACTURER_NO_SUPPORT = "Unsupported manufactures";
    }

    public static class OAIDErrorCode {
        public static final int OAID_CLIENT_FETCH_INTERRUPTED = 2004;
        public static final int OAID_CLIENT_FETCH_MSA_INTERFACE_ERROR_1 = 2001;
        public static final int OAID_CLIENT_FETCH_MSA_INTERFACE_ERROR_2 = 2002;
        public static final int OAID_CLIENT_FETCH_TIMEOUT = 2003;
        public static final int OAID_CLIENT_INIT_CERTIFICATE_CONFIGURATION_FAIL = 1002;
        public static final int OAID_CLIENT_INIT_INTERRUPTED = 1004;
        public static final int OAID_CLIENT_MSA_CONFIGURATION_ERROR = 1001;
        public static final int OAID_INVALID_RESULT = 2005;
        public static final int OK = 0;
        public static final int UNKNOWN = -1;
    }

    public static class OAIDErrorMessage {
        public static final String OAID_CLIENT_FETCH_INTERRUPTED = "OAID client fetch interrupted";
        public static final String OAID_CLIENT_FETCH_MSA_INTERFACE_ERROR_2 = "MSA interface error";
        public static final String OAID_CLIENT_FETCH_TIMEOUT = "OAID client fetch timeout";
        public static final String OAID_CLIENT_INIT_CERTIFICATE_CONFIGURATION_FAIL = "The certificate configuration is abnormal; Pls check certificate file name is ${packageName}.cert.pem and file is placed in the src/main/assets";
        public static final String OAID_CLIENT_INIT_INTERRUPTED = "OAID client init interrupted";
        public static final String OAID_CLIENT_MSA_CONFIGURATION_ERROR = "The MSA OAID SDK is Not imported into the project / UnSupported MSA OAID SDK version";
        public static final String OAID_INVALID_RESULT = "OAID client fetch result is invalid";
        public static final String OK_MESSAGE = "NO ERROR";
        public static final String UNKNOWN = "未知错误";
    }

    public static class RuntimeEnvironment {
        public static final int NON_TAP_SANDBOX = 0;
        public static final int TAP_SANDBOX = 1;
    }

    public static class SupportWXOpenSDKState {
        public static final int NOT_SUPPORTED = 2;
        public static final int SUPPORTED = 1;
    }

    public static class WXInstalledState {
        public static final int INSTALLED = 1;
        public static final int NOT_INSTALLED = 0;
    }

    public static class WebViewEventType {
        public static int DOWNLOAD_COMPLETE = 18;
    }
}
