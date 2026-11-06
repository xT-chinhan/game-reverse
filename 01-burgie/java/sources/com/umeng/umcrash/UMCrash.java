package com.umeng.umcrash;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import com.bykv.vk.component.ttvideo.utils.AVErrorInfo;
import com.efs.sdk.base.EfsConstant;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.h5pagesdk.H5Manager;
import com.efs.sdk.launch.LaunchManager;
import com.efs.sdk.memoryinfo.UMMemoryMonitor;
import com.efs.sdk.net.NetManager;
import com.efs.sdk.pa.PAFactory;
import com.efs.sdk.pa.config.IEfsReporter;
import com.efs.sdk.pa.config.PackageLevel;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.uc.crashsdk.export.CrashApi;
import com.uc.crashsdk.export.CustomLogInfo;
import com.uc.crashsdk.export.ICrashClient;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.an;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.pagesdk.PageManger;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UMCrash {
    private static final boolean DEFAULT_VALUE_CRASH_ANR = true;
    private static final boolean DEFAULT_VALUE_CRASH_JAVA = true;
    private static final boolean DEFAULT_VALUE_CRASH_NATIVE = true;
    private static final boolean DEFAULT_VALUE_CRASH_UNEXP = false;
    private static final boolean DEFAULT_VALUE_H5PAGE = true;
    private static final boolean DEFAULT_VALUE_LAUNCH = true;
    private static final boolean DEFAULT_VALUE_MEM = true;
    private static final boolean DEFAULT_VALUE_NET = true;
    private static final boolean DEFAULT_VALUE_PA = true;
    private static final boolean DEFAULT_VALUE_PAGE = true;
    private static final String INTEGRATIONTESTING_SP = "itconfig";
    private static final String IT_DEBUGKEY = "apm_debugkey";
    private static final String IT_SENDAGING = "apm_sendaging";
    private static final String KEY_ACTIITY_ON_CREATED = "onCreated";
    private static final String KEY_ACTIITY_ON_DESTROYED = "onDestroyed";
    private static final String KEY_ACTIITY_ON_PAUSED = "onPaused";
    private static final String KEY_ACTIITY_ON_RESUMED = "onResumed";
    private static final String KEY_ACTIITY_ON_STARTED = "onStarted";
    private static final String KEY_ACTIITY_ON_STOPPED = "onStopped";
    public static final String KEY_APM_DEFAULT_SECRET = "NEej8y@anWa*8hep";
    public static final String KEY_APM_ROOT_NAME = "UApm";
    public static final String KEY_CALLBACK_PAGE_ACTION = "um_action_log";
    public static final String KEY_CALLBACK_UMID = "um_umid";
    private static final String KEY_CALLBACK_USER_STRING = "um_user_string";
    public static final String KEY_DEBUGKEY = "um_dk";
    public static final String KEY_ENABLE_ANR = "enableANRLog";
    public static final String KEY_ENABLE_CRASH_JAVA = "enableJavaLog";
    public static final String KEY_ENABLE_CRASH_NATIVE = "enableNativeLog";
    public static final String KEY_ENABLE_CRASH_UNEXP = "enableUnexpLog";
    public static final String KEY_ENABLE_H5PAGE = "enableH5PageLog";
    public static final String KEY_ENABLE_LAUNCH = "enableLaunchLog";
    public static final String KEY_ENABLE_MEM = "enableMemLog";
    public static final String KEY_ENABLE_NET = "enableNetLog";
    public static final String KEY_ENABLE_PA = "enablePaLog";
    public static final String KEY_ENABLE_PAGE = "enablePageLog";
    public static final String KEY_HEADER_ACCESS = "um_access";
    public static final String KEY_HEADER_ACCESS_SUBTYPE = "um_access_subtype";
    public static final String KEY_HEADER_APPKEY = "um_app_key";
    public static final String KEY_HEADER_BESRIAL = "um_bserial";
    public static final String KEY_HEADER_BSVER = "um_bsver";
    public static final String KEY_HEADER_BVER = "um_bver";
    public static final String KEY_HEADER_CARRIER = "um_app_carrier";
    public static final String KEY_HEADER_CHANNEL = "um_app_channel";
    public static final String KEY_HEADER_CRASH_VERSION = "um_crash_sdk_version";
    public static final String KEY_HEADER_DEBUGKEY = "um_dk";
    public static final String KEY_HEADER_NETWORK_TYPE = "um_network_type";
    public static final String KEY_HEADER_OS = "um_os";
    public static final String KEY_HEADER_PROVIDER = "um_app_provider";
    public static final String KEY_HEADER_PUID = "um_app_puid";
    public static final String KEY_HEADER_START_TIME = "um_app_start_time";
    public static final String KEY_HEADER_UMID = "um_umid_header";
    private static final int KEY_MAX_LENGTH = 20480;
    private static final int KEY_MAX_LENGTH_128 = 128;
    public static final String KEY_PA_TIMEOUT_TIME = "pa_timeout_time";
    public static final String SP_KEY_DEBUG = "debugkey";
    public static final String SP_KEY_TIMESTAMP = "timestamp";
    private static Context mContext;
    private static UMCrashCallback mUMCrashCallback;
    public static EfsReporter sReporter;
    private static String userBesrial;
    private static String userBsver;
    private static String userBver;
    private static final String TAG = UMCrash.class.getSimpleName();
    private static boolean isDebug = true;
    private static boolean isEncrypt = false;
    private static boolean isZip = true;
    private static boolean isIntl = false;
    private static boolean isBuildId = true;
    private static String crashSdkVersion = EfsConstant.UM_SDK_VERSION;
    private static Object pageArrayLock = new Object();
    private static ArrayList<String> mArrayList = new ArrayList<>(10);
    private static boolean isPA = false;
    private static boolean isLa = false;
    private static boolean isNet = false;
    private static boolean isPage = false;
    private static boolean enableJavaLog = true;
    private static boolean enableNativeLog = true;
    private static boolean enableANRLog = true;
    private static boolean enablePaLog = true;
    private static boolean enableLaunchLog = true;
    private static boolean enableMemLog = true;
    private static boolean enableNetLog = true;
    private static boolean enableH5PageLog = true;
    private static boolean enablePageLog = true;
    private static final long DEFAULT_PA_TIMEOUT_TIME = 2000;
    private static long paTimeoutTime = DEFAULT_PA_TIMEOUT_TIME;
    private static int index = 0;
    private static boolean isOpenUserCrash = true;
    private static boolean isUploadNowUserCrash = false;

    static /* synthetic */ int access$908() {
        int i = index;
        index = i + 1;
        return i;
    }

    static /* synthetic */ int access$910() {
        int i = index;
        index = i - 1;
        return i;
    }

    public static EfsReporter getReporter() {
        return sReporter;
    }

    public static void isBuildId(boolean isBuId) {
        isBuildId = isBuId;
    }

    public static void setAppVersion(String version, String subVersion, String buildId) {
        String pVersion = version;
        try {
            if (!TextUtils.isEmpty(pVersion)) {
                int len = pVersion.trim().getBytes().length;
                if (len > 128) {
                    pVersion = UMCrashUtils.splitByByte(pVersion, 128);
                }
                userBver = pVersion;
            } else if (isDebug) {
                Log.e(TAG, "version is null or empty !");
            }
            String pSubVersion = subVersion;
            if (!TextUtils.isEmpty(pSubVersion)) {
                int len2 = pSubVersion.trim().getBytes().length;
                if (len2 > 128) {
                    pSubVersion = UMCrashUtils.splitByByte(pSubVersion, 128);
                }
                userBsver = pSubVersion;
            } else if (isDebug) {
                Log.e(TAG, "sub version is null or empty !");
            }
            String pBuildId = buildId;
            if (!TextUtils.isEmpty(pBuildId)) {
                int len3 = pBuildId.trim().getBytes().length;
                if (len3 > 128) {
                    pBuildId = UMCrashUtils.splitByByte(pBuildId, 128);
                }
                userBesrial = pBuildId;
            } else if (isDebug) {
                Log.e(TAG, "build id is null or empty !");
            }
            CrashApi crashApi = CrashApi.getInstance();
            if (crashApi != null) {
                if (!TextUtils.isEmpty(userBver)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BVER, userBver);
                }
                if (!TextUtils.isEmpty(userBsver)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BSVER, userBsver);
                }
                if (!TextUtils.isEmpty(userBesrial)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BESRIAL, userBesrial);
                }
            } else if (isDebug) {
                Log.e(TAG, "set app version. crashApi is null");
            }
            HashMap<String, String> params = new HashMap<>(1);
            if (!TextUtils.isEmpty(userBver)) {
                params.put(KEY_HEADER_BVER, userBver);
            }
            if (!TextUtils.isEmpty(userBsver)) {
                params.put(KEY_HEADER_BSVER, userBsver);
            }
            if (!TextUtils.isEmpty(userBesrial)) {
                params.put(KEY_HEADER_BESRIAL, userBesrial);
            }
            if (sReporter != null) {
                sReporter.addPublicParams(params);
            } else if (isDebug) {
                Log.e(TAG, "set app version.  sReporter is null");
            }
            if (!TextUtils.isEmpty(userBver)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BVER, userBver);
            }
            if (!TextUtils.isEmpty(userBsver)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BSVER, userBsver);
            }
            if (!TextUtils.isEmpty(userBesrial)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BESRIAL, userBesrial);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static class CrashClientImpl implements ICrashClient {
        private CrashClientImpl() {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onLogGenerated(File file, String s) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onClientProcessLogGenerated(String s, File file, String s1) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public File onBeforeUploadLog(File file) {
            return file;
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onCrashRestarting(boolean b) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onAddCrashStats(String s, int i, int i1) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public String onGetCallbackInfo(String category, boolean b) {
            String callbackString;
            if (UMCrash.KEY_CALLBACK_PAGE_ACTION.equals(category)) {
                String result = null;
                try {
                    if (UMCrash.mArrayList != null && UMCrash.mArrayList.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("source", 0);
                        jSONObject.put("action_name", TrackAction.PAGE_VIEW);
                        jSONObject.put("action_page_state", UMCrash.isPage);
                        JSONArray jsonParameter = new JSONArray();
                        for (int i = 0; i < UMCrash.mArrayList.size(); i++) {
                            String item = (String) UMCrash.mArrayList.get(i);
                            if (item != null) {
                                JSONObject jsonitem = new JSONObject();
                                jsonitem.put(Common.System.NAME, item);
                                jsonParameter.put(jsonitem);
                            }
                        }
                        jSONObject.put("action_parameter", jsonParameter);
                        result = jSONObject.toString();
                        if (UMCrash.isDebug) {
                            Log.i(UMCrash.TAG, "page json is " + result);
                        }
                    }
                } catch (Throwable th) {
                }
                return result;
            }
            if (UMCrash.KEY_CALLBACK_UMID.equals(category)) {
                return UMCrash.getUMID(UMCrash.mContext);
            }
            if (!UMCrash.KEY_CALLBACK_USER_STRING.equals(category) || UMCrash.mUMCrashCallback == null || (callbackString = UMCrash.mUMCrashCallback.onCallback()) == null) {
                return null;
            }
            int len = callbackString.trim().getBytes().length;
            if (len > UMCrash.KEY_MAX_LENGTH) {
                return UMCrashUtils.splitByByte(callbackString, UMCrash.KEY_MAX_LENGTH);
            }
            return callbackString;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized String getUMID(Context context) throws NoSuchMethodException, ClassNotFoundException {
        if (context == null) {
            return null;
        }
        String umId = null;
        Class<?> umConfigClass = null;
        try {
            umConfigClass = Class.forName("com.umeng.commonsdk.UMConfigure");
        } catch (ClassNotFoundException e) {
        }
        if (umConfigClass != null) {
            Method umConfigMethed = null;
            try {
                umConfigMethed = umConfigClass.getMethod("getUMIDString", Context.class);
            } catch (NoSuchMethodException e2) {
            }
            if (umConfigMethed != null) {
                try {
                    Object o = umConfigMethed.invoke(null, context);
                    if (o != null) {
                        umId = o.toString();
                    }
                } catch (IllegalAccessException e3) {
                } catch (InvocationTargetException e4) {
                }
            }
        }
        return umId;
    }

    public static String getUMAPMFlag() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("version", 0);
            jsonObject.put(AVErrorInfo.CRASH, 1);
            if (enableJavaLog) {
                jsonObject.put("crashJava", 1);
            } else {
                jsonObject.put("crashJava", 0);
            }
            if (enableNativeLog) {
                jsonObject.put("crashNative", 1);
            } else {
                jsonObject.put("crashNative", 0);
            }
            if (enableANRLog) {
                jsonObject.put(LogType.ANR_TYPE, 1);
            } else {
                jsonObject.put(LogType.ANR_TYPE, 0);
            }
            if (isPA) {
                jsonObject.put("pa", 1);
            } else {
                jsonObject.put("pa", 0);
            }
            if (isLa) {
                jsonObject.put("la", 1);
            } else {
                jsonObject.put("la", 0);
            }
            if (UMMemoryMonitor.get().isEnable()) {
                jsonObject.put("mem", 1);
            } else {
                jsonObject.put("mem", 0);
            }
            if (isNet) {
                jsonObject.put("net", 1);
            } else {
                jsonObject.put("net", 0);
            }
            if (H5Manager.getH5ConfigMananger() != null && H5Manager.getH5ConfigMananger().isH5TracerEnable()) {
                jsonObject.put("h5", 1);
            } else {
                jsonObject.put("h5", 0);
            }
            if (isOpenUserCrash) {
                jsonObject.put("crashUser", 1);
            } else {
                jsonObject.put("crashUser", 0);
            }
            if (isPage) {
                jsonObject.put("page", 1);
            } else {
                jsonObject.put("page", 0);
            }
        } catch (Throwable th) {
        }
        return jsonObject.toString();
    }

    public static void enableJavaScriptBridge(WebView webView) {
        enableJavaScriptBridge((View) webView);
    }

    public static void enableJavaScriptBridge(View webView) {
        try {
            H5Manager.setWebView(webView);
        } catch (Throwable th) {
        }
    }

    public static void setDebug(boolean isD) {
        isDebug = isD;
        LaunchManager.isDebug = isD;
        H5Manager.isDebug = isD;
        PageManger.isDebug = isD;
    }

    private static void useIntlServices(boolean isInSer) {
        isIntl = isInSer;
        if (isDebug) {
            Log.i(TAG, "useIntlServices is " + isIntl);
        }
    }

    @Deprecated
    public static void enableNativeLog(boolean isN) {
        enableNativeLog = isN;
    }

    @Deprecated
    public static void enableANRLog(boolean isA) {
        enableANRLog = isA;
    }

    public static void setPaTimeoutTime(long timeoutTime) {
        paTimeoutTime = timeoutTime;
    }

    public static void initConfig(Bundle args) {
        if (args != null) {
            if (args.getBoolean(KEY_ENABLE_CRASH_JAVA, true)) {
                enableJavaLog = true;
            } else {
                enableJavaLog = false;
            }
            if (args.getBoolean(KEY_ENABLE_CRASH_NATIVE, true)) {
                enableNativeLog = true;
            } else {
                enableNativeLog = false;
            }
            if (args.getBoolean(KEY_ENABLE_ANR, true)) {
                enableANRLog = true;
            } else {
                enableANRLog = false;
            }
            if (args.getBoolean(KEY_ENABLE_PA, true)) {
                enablePaLog = true;
            } else {
                enablePaLog = false;
            }
            if (args.getBoolean(KEY_ENABLE_LAUNCH, true)) {
                enableLaunchLog = true;
            } else {
                enableLaunchLog = false;
            }
            if (args.getBoolean(KEY_ENABLE_MEM, true)) {
                enableMemLog = true;
            } else {
                enableMemLog = false;
            }
            if (args.getBoolean(KEY_ENABLE_NET, true)) {
                enableNetLog = true;
            } else {
                enableNetLog = false;
            }
            if (args.getBoolean(KEY_ENABLE_H5PAGE, true)) {
                enableH5PageLog = true;
            } else {
                enableH5PageLog = false;
            }
            paTimeoutTime = args.getLong(KEY_PA_TIMEOUT_TIME, DEFAULT_PA_TIMEOUT_TIME);
            if (args.getBoolean(KEY_ENABLE_PAGE, true)) {
                enablePageLog = true;
            } else {
                enablePageLog = false;
            }
        }
    }

    @Deprecated
    public static void enableMemoryMonitor(boolean enable) {
        UMMemoryMonitor.get().setEnable(enable);
    }

    /* JADX WARN: Code duplicated, block: B:65:0x01d5 A[Catch: Throwable -> 0x02a4, TryCatch #4 {, blocks: (B:53:0x0181, B:63:0x01c4, B:65:0x01d5, B:66:0x01dc, B:68:0x01e4, B:69:0x01eb, B:71:0x01f3, B:95:0x0275, B:97:0x0279, B:98:0x0292, B:94:0x0272, B:86:0x0257, B:62:0x01b6, B:99:0x029a, B:87:0x025a, B:89:0x0260, B:90:0x0268, B:72:0x01fa, B:74:0x0208, B:79:0x0229, B:81:0x0233, B:82:0x023a, B:75:0x0210, B:77:0x021a, B:78:0x0222, B:54:0x019b, B:56:0x01a1, B:58:0x01a5), top: B:244:0x0176, inners: #14, #15, #17 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01e4 A[Catch: Throwable -> 0x02a4, TryCatch #4 {, blocks: (B:53:0x0181, B:63:0x01c4, B:65:0x01d5, B:66:0x01dc, B:68:0x01e4, B:69:0x01eb, B:71:0x01f3, B:95:0x0275, B:97:0x0279, B:98:0x0292, B:94:0x0272, B:86:0x0257, B:62:0x01b6, B:99:0x029a, B:87:0x025a, B:89:0x0260, B:90:0x0268, B:72:0x01fa, B:74:0x0208, B:79:0x0229, B:81:0x0233, B:82:0x023a, B:75:0x0210, B:77:0x021a, B:78:0x0222, B:54:0x019b, B:56:0x01a1, B:58:0x01a5), top: B:244:0x0176, inners: #14, #15, #17 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x01f3 A[Catch: Throwable -> 0x02a4, TRY_LEAVE, TryCatch #4 {, blocks: (B:53:0x0181, B:63:0x01c4, B:65:0x01d5, B:66:0x01dc, B:68:0x01e4, B:69:0x01eb, B:71:0x01f3, B:95:0x0275, B:97:0x0279, B:98:0x0292, B:94:0x0272, B:86:0x0257, B:62:0x01b6, B:99:0x029a, B:87:0x025a, B:89:0x0260, B:90:0x0268, B:72:0x01fa, B:74:0x0208, B:79:0x0229, B:81:0x0233, B:82:0x023a, B:75:0x0210, B:77:0x021a, B:78:0x0222, B:54:0x019b, B:56:0x01a1, B:58:0x01a5), top: B:244:0x0176, inners: #14, #15, #17 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0208 A[Catch: Throwable -> 0x0255, TryCatch #15 {Throwable -> 0x0255, blocks: (B:72:0x01fa, B:74:0x0208, B:79:0x0229, B:81:0x0233, B:82:0x023a, B:75:0x0210, B:77:0x021a, B:78:0x0222), top: B:258:0x01fa, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0210 A[Catch: Throwable -> 0x0255, TryCatch #15 {Throwable -> 0x0255, blocks: (B:72:0x01fa, B:74:0x0208, B:79:0x0229, B:81:0x0233, B:82:0x023a, B:75:0x0210, B:77:0x021a, B:78:0x0222), top: B:258:0x01fa, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x021a A[Catch: Throwable -> 0x0255, TryCatch #15 {Throwable -> 0x0255, blocks: (B:72:0x01fa, B:74:0x0208, B:79:0x0229, B:81:0x0233, B:82:0x023a, B:75:0x0210, B:77:0x021a, B:78:0x0222), top: B:258:0x01fa, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0222 A[Catch: Throwable -> 0x0255, TryCatch #15 {Throwable -> 0x0255, blocks: (B:72:0x01fa, B:74:0x0208, B:79:0x0229, B:81:0x0233, B:82:0x023a, B:75:0x0210, B:77:0x021a, B:78:0x0222), top: B:258:0x01fa, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0233 A[Catch: Throwable -> 0x0255, TryCatch #15 {Throwable -> 0x0255, blocks: (B:72:0x01fa, B:74:0x0208, B:79:0x0229, B:81:0x0233, B:82:0x023a, B:75:0x0210, B:77:0x021a, B:78:0x0222), top: B:258:0x01fa, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0260 A[Catch: Throwable -> 0x0270, TryCatch #14 {Throwable -> 0x0270, blocks: (B:87:0x025a, B:89:0x0260, B:90:0x0268), top: B:257:0x025a, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0268 A[Catch: Throwable -> 0x0270, TRY_LEAVE, TryCatch #14 {Throwable -> 0x0270, blocks: (B:87:0x025a, B:89:0x0260, B:90:0x0268), top: B:257:0x025a, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0279 A[Catch: Throwable -> 0x02a4, TryCatch #4 {, blocks: (B:53:0x0181, B:63:0x01c4, B:65:0x01d5, B:66:0x01dc, B:68:0x01e4, B:69:0x01eb, B:71:0x01f3, B:95:0x0275, B:97:0x0279, B:98:0x0292, B:94:0x0272, B:86:0x0257, B:62:0x01b6, B:99:0x029a, B:87:0x025a, B:89:0x0260, B:90:0x0268, B:72:0x01fa, B:74:0x0208, B:79:0x0229, B:81:0x0233, B:82:0x023a, B:75:0x0210, B:77:0x021a, B:78:0x0222, B:54:0x019b, B:56:0x01a1, B:58:0x01a5), top: B:244:0x0176, inners: #14, #15, #17 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0292 A[Catch: Throwable -> 0x02a4, TryCatch #4 {, blocks: (B:53:0x0181, B:63:0x01c4, B:65:0x01d5, B:66:0x01dc, B:68:0x01e4, B:69:0x01eb, B:71:0x01f3, B:95:0x0275, B:97:0x0279, B:98:0x0292, B:94:0x0272, B:86:0x0257, B:62:0x01b6, B:99:0x029a, B:87:0x025a, B:89:0x0260, B:90:0x0268, B:72:0x01fa, B:74:0x0208, B:79:0x0229, B:81:0x0233, B:82:0x023a, B:75:0x0210, B:77:0x021a, B:78:0x0222, B:54:0x019b, B:56:0x01a1, B:58:0x01a5), top: B:244:0x0176, inners: #14, #15, #17 }] */
    public static void init(final Context context, final String appkey, String channel) {
        String[] access;
        if (context == null || appkey == null) {
            Log.e(TAG, "context is null or appkey is null, init failed.");
            return;
        }
        mContext = context;
        try {
            WorkThreadUtil.submit(new Runnable() { // from class: com.umeng.umcrash.UMCrash.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ImprintHandler.getImprintService(UMCrash.mContext).registImprintCallback(UMCrashContent.KEY_APM_CTR_FLAG, new UMImprintChangeCallback() { // from class: com.umeng.umcrash.UMCrash.1.1
                            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                            public void onImprintValueChanged(String key, String value) {
                                try {
                                    if (!TextUtils.isEmpty(key) && UMCrashContent.KEY_APM_CTR_FLAG.equals(key)) {
                                        if (UMCrash.isDebug) {
                                            Log.i(UMCrash.TAG, "common callback. apm ctr flag is " + value);
                                        }
                                        UMCrashUtils.saveInnerConfig(context.getApplicationContext(), key, value);
                                    }
                                } catch (Throwable e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        String apmFlag = UMEnvelopeBuild.imprintProperty(UMCrash.mContext, UMCrashContent.KEY_APM_CTR_FLAG, "0");
                        if (UMCrash.isDebug) {
                            Log.i(UMCrash.TAG, "get common. apm ctr flag is " + apmFlag);
                        }
                        if (apmFlag != null && !TextUtils.isEmpty(apmFlag)) {
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.KEY_APM_CTR_FLAG, apmFlag);
                        }
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            int apm_ctr_flag = UMCrashUtils.getInnerConfig(mContext, UMCrashContent.KEY_APM_CTR_FLAG, 0);
            if (isDebug) {
                Log.i(TAG, "int apm. flag is " + apm_ctr_flag);
            }
            if (apm_ctr_flag == -1) {
                return;
            }
        } catch (Throwable e2) {
            e2.printStackTrace();
        }
        final SharedPreferences sharedPreferences = SharedPreferencesUtils.getSharedPreferences(context, INTEGRATIONTESTING_SP);
        try {
            if (enableJavaLog) {
                enableJavaLog = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, 100));
            }
            if (enableNativeLog) {
                enableNativeLog = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, 100));
            }
            if (enableANRLog) {
                enableANRLog = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, 100));
            }
            isOpenUserCrash = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, 100));
            int upload = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, -1);
            if (upload == 0) {
                isUploadNowUserCrash = true;
            } else {
                isUploadNowUserCrash = false;
            }
        } catch (Throwable e3) {
            e3.printStackTrace();
        }
        Bundle customInfo = new Bundle();
        customInfo.putBoolean("mDebug", isDebug);
        customInfo.putBoolean("mEncryptLog", isEncrypt);
        customInfo.putBoolean("mZipLog", isZip);
        customInfo.putBoolean(KEY_ENABLE_CRASH_JAVA, enableJavaLog);
        customInfo.putBoolean(KEY_ENABLE_CRASH_NATIVE, enableNativeLog);
        customInfo.putBoolean(KEY_ENABLE_ANR, enableANRLog);
        if (isDebug) {
            Log.i(TAG, "enable : java is " + enableJavaLog + ", native is " + enableNativeLog + ", anr is " + enableANRLog);
        }
        customInfo.putBoolean(KEY_ENABLE_CRASH_UNEXP, false);
        customInfo.putBoolean("mIsInternational", isIntl);
        customInfo.putBoolean("mDumpUserSolibBuildId", isBuildId);
        if (isIntl) {
            customInfo.putString("mCrashLogUploadUrl", "https://errnewlogos.umeng.com/upload");
            customInfo.putString("mCrashSDKAuthUrl", UMCrashContent.UM_DOMAIN_APM_URL_INTL);
            customInfo.putString("mCrashRateUploadUrl", UMCrashContent.UM_DOMAIN_APM_URL_INTL);
            if (isDebug) {
                Log.i(TAG, "crash log domain is https://errnewlogos.umeng.com");
            }
        } else {
            customInfo.putString("mCrashLogUploadUrl", "https://errnewlog.umeng.com/upload");
            customInfo.putString("mCrashSDKAuthUrl", UMCrashContent.UM_DOMAIN_APM_URL);
            customInfo.putString("mCrashRateUploadUrl", UMCrashContent.UM_DOMAIN_APM_URL);
            if (isDebug) {
                Log.i(TAG, "crash rate domain is https://errnewlog.umeng.com");
            }
        }
        CrashApi mCrashApi = CrashApi.createInstanceEx(context, appkey, isDebug, customInfo, new CrashClientImpl());
        if (mCrashApi != null) {
            mCrashApi.addHeaderInfo(KEY_HEADER_APPKEY, appkey);
            mCrashApi.addHeaderInfo(KEY_HEADER_CHANNEL, channel);
            mCrashApi.addHeaderInfo(KEY_HEADER_OS, "android");
            mCrashApi.addHeaderInfo(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
            mCrashApi.addHeaderInfo(KEY_HEADER_UMID, getUMID(context));
            try {
                String[] strings = UMCrashUtils.getActiveUser(context);
                if (strings != null && strings.length == 2) {
                    mCrashApi.addHeaderInfo(KEY_HEADER_PUID, strings[1]);
                    mCrashApi.addHeaderInfo(KEY_HEADER_PROVIDER, strings[0]);
                    mCrashApi.addHeaderInfo(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
                    if (!TextUtils.isEmpty(userBver)) {
                        mCrashApi.addHeaderInfo(KEY_HEADER_BVER, userBver);
                    }
                    if (!TextUtils.isEmpty(userBsver)) {
                        mCrashApi.addHeaderInfo(KEY_HEADER_BSVER, userBsver);
                    }
                    if (!TextUtils.isEmpty(userBesrial)) {
                        mCrashApi.addHeaderInfo(KEY_HEADER_BESRIAL, userBesrial);
                    }
                    access = NetworkUtil.getNetworkAccessMode(context);
                    if ("Wi-Fi".equals(access[0])) {
                        mCrashApi.addHeaderInfo(KEY_HEADER_ACCESS, NetworkUtil.NETWORK_TYPE_WIFI);
                    } else if ("2G/3G".equals(access[0])) {
                        mCrashApi.addHeaderInfo(KEY_HEADER_ACCESS, "2G/3G");
                    } else {
                        mCrashApi.addHeaderInfo(KEY_HEADER_ACCESS, "unknow");
                    }
                    if (!"".equals(access[1])) {
                        mCrashApi.addHeaderInfo(KEY_HEADER_ACCESS_SUBTYPE, access[1]);
                    }
                    int netType = NetworkUtil.getNetworkTypeUmeng(context);
                    mCrashApi.addHeaderInfo(KEY_HEADER_NETWORK_TYPE, "" + netType);
                    if (UMCrashUtils.isHarmony(context)) {
                        mCrashApi.addHeaderInfo("others_OS", "harmony");
                    } else {
                        mCrashApi.addHeaderInfo("others_OS", "Android");
                    }
                    if (context instanceof Application) {
                        ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.umcrash.UMCrash.2
                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                                Intent intent;
                                Uri data;
                                String scheme;
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_CREATED);
                                if (UMCrash.index != 0 || (intent = activity.getIntent()) == null || (data = intent.getData()) == null || (scheme = data.getScheme()) == null || scheme.isEmpty()) {
                                    return;
                                }
                                if (scheme.contains("um." + appkey)) {
                                    Set<String> params = data.getQueryParameterNames();
                                    if (params.contains(UMCrash.IT_DEBUGKEY) && params.contains(UMCrash.IT_SENDAGING)) {
                                        String debugKey = data.getQueryParameter(UMCrash.IT_DEBUGKEY);
                                        String sendaging = data.getQueryParameter(UMCrash.IT_SENDAGING);
                                        long period = 0;
                                        try {
                                            period = Long.parseLong(sendaging);
                                        } catch (NumberFormatException e4) {
                                        }
                                        if (period < 0) {
                                            sharedPreferences.edit().clear().apply();
                                            IntegrationTestingUtil.setIntegrationTestingInPeriod(false);
                                            return;
                                        }
                                        if (period > 6) {
                                            period = 6;
                                        }
                                        sharedPreferences.edit().putString("debugkey", debugKey).apply();
                                        sharedPreferences.edit().putLong("timestamp", System.currentTimeMillis() + (period * 60 * 60 * 1000)).apply();
                                        UMCrashUtils.setIntegrationTesingParams(debugKey);
                                        IntegrationTestingUtil.setIntegrationTestingInPeriod(true);
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityStarted(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_STARTED);
                                UMMemoryMonitor.get().onActivityStarted(activity);
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityResumed(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_RESUMED);
                                UMMemoryMonitor.get().onActivityResumed(activity);
                                UMCrash.access$908();
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityPaused(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_PAUSED);
                                UMCrash.access$910();
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityStopped(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_STOPPED);
                                UMMemoryMonitor.get().onActivityStopped(activity);
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityDestroyed(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_DESTROYED);
                            }
                        });
                        mCrashApi.registerInfoCallback(KEY_CALLBACK_UMID, 1048593);
                        mCrashApi.registerInfoCallback(KEY_CALLBACK_PAGE_ACTION, 1048593);
                    } else {
                        Log.e(TAG, "context not instanceof application.");
                    }
                } else {
                    mCrashApi.addHeaderInfo(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
                    if (!TextUtils.isEmpty(userBver)) {
                        mCrashApi.addHeaderInfo(KEY_HEADER_BVER, userBver);
                    }
                    if (!TextUtils.isEmpty(userBsver)) {
                        mCrashApi.addHeaderInfo(KEY_HEADER_BSVER, userBsver);
                    }
                    if (!TextUtils.isEmpty(userBesrial)) {
                        mCrashApi.addHeaderInfo(KEY_HEADER_BESRIAL, userBesrial);
                    }
                    try {
                        access = NetworkUtil.getNetworkAccessMode(context);
                        if ("Wi-Fi".equals(access[0])) {
                            mCrashApi.addHeaderInfo(KEY_HEADER_ACCESS, NetworkUtil.NETWORK_TYPE_WIFI);
                        } else if ("2G/3G".equals(access[0])) {
                            mCrashApi.addHeaderInfo(KEY_HEADER_ACCESS, "2G/3G");
                        } else {
                            mCrashApi.addHeaderInfo(KEY_HEADER_ACCESS, "unknow");
                        }
                        if (!"".equals(access[1])) {
                            mCrashApi.addHeaderInfo(KEY_HEADER_ACCESS_SUBTYPE, access[1]);
                        }
                        int netType2 = NetworkUtil.getNetworkTypeUmeng(context);
                        mCrashApi.addHeaderInfo(KEY_HEADER_NETWORK_TYPE, "" + netType2);
                    } catch (Throwable e4) {
                        e4.printStackTrace();
                    }
                    try {
                        if (UMCrashUtils.isHarmony(context)) {
                            mCrashApi.addHeaderInfo("others_OS", "harmony");
                        } else {
                            mCrashApi.addHeaderInfo("others_OS", "Android");
                        }
                    } catch (Throwable e5) {
                        e5.printStackTrace();
                    }
                    if (context instanceof Application) {
                        ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.umcrash.UMCrash.2
                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                                Intent intent;
                                Uri data;
                                String scheme;
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_CREATED);
                                if (UMCrash.index != 0 || (intent = activity.getIntent()) == null || (data = intent.getData()) == null || (scheme = data.getScheme()) == null || scheme.isEmpty()) {
                                    return;
                                }
                                if (scheme.contains("um." + appkey)) {
                                    Set<String> params = data.getQueryParameterNames();
                                    if (params.contains(UMCrash.IT_DEBUGKEY) && params.contains(UMCrash.IT_SENDAGING)) {
                                        String debugKey = data.getQueryParameter(UMCrash.IT_DEBUGKEY);
                                        String sendaging = data.getQueryParameter(UMCrash.IT_SENDAGING);
                                        long period = 0;
                                        try {
                                            period = Long.parseLong(sendaging);
                                        } catch (NumberFormatException e6) {
                                        }
                                        if (period < 0) {
                                            sharedPreferences.edit().clear().apply();
                                            IntegrationTestingUtil.setIntegrationTestingInPeriod(false);
                                            return;
                                        }
                                        if (period > 6) {
                                            period = 6;
                                        }
                                        sharedPreferences.edit().putString("debugkey", debugKey).apply();
                                        sharedPreferences.edit().putLong("timestamp", System.currentTimeMillis() + (period * 60 * 60 * 1000)).apply();
                                        UMCrashUtils.setIntegrationTesingParams(debugKey);
                                        IntegrationTestingUtil.setIntegrationTestingInPeriod(true);
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityStarted(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_STARTED);
                                UMMemoryMonitor.get().onActivityStarted(activity);
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityResumed(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_RESUMED);
                                UMMemoryMonitor.get().onActivityResumed(activity);
                                UMCrash.access$908();
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityPaused(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_PAUSED);
                                UMCrash.access$910();
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityStopped(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_STOPPED);
                                UMMemoryMonitor.get().onActivityStopped(activity);
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityDestroyed(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_DESTROYED);
                            }
                        });
                        mCrashApi.registerInfoCallback(KEY_CALLBACK_UMID, 1048593);
                        mCrashApi.registerInfoCallback(KEY_CALLBACK_PAGE_ACTION, 1048593);
                    } else {
                        Log.e(TAG, "context not instanceof application.");
                    }
                }
            } catch (Throwable th) {
                mCrashApi.addHeaderInfo(KEY_HEADER_PUID, "");
                mCrashApi.addHeaderInfo(KEY_HEADER_PROVIDER, "");
            }
        } else {
            Log.e(TAG, "create CrashAPI is null.");
        }
        try {
            initReporter(context, appkey, channel);
        } catch (Throwable e6) {
            e6.printStackTrace();
        }
        try {
            String debugKey = sharedPreferences.getString("debugkey", "");
            if (sharedPreferences.getLong("timestamp", 0L) - System.currentTimeMillis() >= 0 && !TextUtils.isEmpty(debugKey)) {
                IntegrationTestingUtil.setIntegrationTestingInPeriod(true);
                UMCrashUtils.setIntegrationTesingParams(debugKey);
            } else {
                sharedPreferences.edit().clear().apply();
                IntegrationTestingUtil.setIntegrationTestingInPeriod(false);
            }
        } catch (Throwable e7) {
            e7.printStackTrace();
        }
        try {
            if (enablePaLog) {
                WorkThreadUtil.submit(new Runnable() { // from class: com.umeng.umcrash.UMCrash.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            PAFactory.Builder builder = new PAFactory.Builder(context.getApplicationContext(), new IEfsReporter() { // from class: com.umeng.umcrash.UMCrash.3.1
                                @Override // com.efs.sdk.pa.config.IEfsReporter
                                public EfsReporter getReporter() {
                                    return UMCrash.sReporter;
                                }
                            });
                            builder.packageLevel(PackageLevel.RELEASE);
                            builder.timeoutTime(UMCrash.paTimeoutTime);
                            PAFactory paFactory = builder.build();
                            paFactory.getPaInstance().start();
                            boolean unused = UMCrash.isPA = paFactory.getConfigManager().enableTracer();
                        } catch (Throwable e8) {
                            e8.printStackTrace();
                        }
                    }
                });
            } else if (isDebug) {
                Log.e(TAG, "enablePaLog is false");
            }
        } catch (Throwable e8) {
            e8.printStackTrace();
        }
        try {
            if (enableLaunchLog) {
                LaunchManager.init(context, sReporter);
                try {
                    if (LaunchManager.getLaunchConfigManager() != null) {
                        isLa = LaunchManager.getLaunchConfigManager().enableTracer();
                    }
                } catch (Throwable e9) {
                    e9.printStackTrace();
                }
                String umid = UMUtils.getUMId(context);
                if (umid == null || TextUtils.isEmpty(umid)) {
                    if (isDebug) {
                        Log.i(TAG, "begin register common callback.  key is umid.");
                    }
                    ImprintHandler.getImprintService(context).registImprintCallback(an.g, new UMImprintChangeCallback() { // from class: com.umeng.umcrash.UMCrash.4
                        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                        public void onImprintValueChanged(String key, String value) {
                            if (UMCrash.isDebug) {
                                Log.i(UMCrash.TAG, "common callback.  key is " + key + "; value is " + value);
                            }
                            try {
                                if (an.g.equals(key)) {
                                    LaunchManager.sendLaunchCache(context, value);
                                    ImprintHandler.getImprintService(context).unregistImprintCallback(an.g, this);
                                }
                            } catch (Throwable e10) {
                                e10.printStackTrace();
                            }
                        }
                    });
                }
            } else if (isDebug) {
                Log.e(TAG, "enableLaunchLog is false");
            }
        } catch (Throwable e10) {
            e10.printStackTrace();
        }
        try {
            if (enableMemLog) {
                UMMemoryMonitor.get().start(context, sReporter);
            } else if (isDebug) {
                Log.e(TAG, "enableMemLog is false");
            }
        } catch (Throwable e11) {
            e11.printStackTrace();
        }
        try {
            int rate = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NET, -1);
            if (isDebug) {
                Log.i(TAG, "inner config : net rate is " + rate);
            }
            if (rate == 0) {
                if (isDebug) {
                    Log.i(TAG, "inner config : net close.");
                }
            } else if (rate == 100) {
                if (isDebug) {
                    Log.i(TAG, "inner config : net open.");
                }
                if (enableNetLog) {
                    NetManager.init(context, sReporter);
                    try {
                        if (NetManager.getNetConfigManager() != null) {
                            isNet = NetManager.getNetConfigManager().enableTracer();
                        }
                    } catch (Throwable e12) {
                        e12.printStackTrace();
                    }
                } else if (isDebug) {
                    Log.e(TAG, "enableNetLog is false");
                }
            }
        } catch (Throwable e13) {
            e13.printStackTrace();
        }
        try {
            int nativeH5Rate = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NATIVE_H5, -1);
            if (isDebug) {
                Log.i(TAG, "inner config : nativeH5Rate is " + nativeH5Rate);
            }
            if (nativeH5Rate == 0) {
                if (isDebug) {
                    Log.i(TAG, "inner config : h5 close.");
                }
            } else if (nativeH5Rate == 100) {
                if (isDebug) {
                    Log.i(TAG, "inner config : h5 open.");
                }
                if (enableH5PageLog) {
                    H5Manager.init(context, sReporter);
                } else if (isDebug) {
                    Log.e(TAG, "enableH5PageLog is false");
                }
            }
        } catch (Throwable e14) {
            e14.printStackTrace();
        }
        try {
            int rate2 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_PAGE, -1);
            if (isDebug) {
                Log.i(TAG, "inner config : page rate is " + rate2);
            }
            if (rate2 == 0) {
                if (isDebug) {
                    Log.i(TAG, "inner config : page close.");
                    return;
                }
                return;
            }
            if (rate2 == 100) {
                if (isDebug) {
                    Log.i(TAG, "inner config : page open.");
                }
                if (enablePageLog) {
                    PageManger.init(mContext, sReporter);
                    try {
                        if (PageManger.getPageConfigManger() != null) {
                            isPage = PageManger.getPageConfigManger().enableTracer();
                            return;
                        }
                        return;
                    } catch (Throwable e15) {
                        e15.printStackTrace();
                        return;
                    }
                }
                if (isDebug) {
                    Log.e(TAG, "enableNetLog is false");
                }
            }
        } catch (Throwable e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveActivityState(String className, String methodName) {
        try {
            if (mArrayList != null) {
                if (mArrayList.size() >= 20) {
                    mArrayList.remove(0);
                }
                mArrayList.add(className + "-" + System.currentTimeMillis() + "-" + methodName);
            }
        } catch (Throwable th) {
        }
    }

    private static void initReporter(final Context context, String appkey, String channel) {
        HashMap<String, String> params = new HashMap<>(1);
        params.put(KEY_HEADER_UMID, getUMID(context));
        params.put(KEY_HEADER_CHANNEL, channel);
        params.put(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
        params.put(KEY_HEADER_OS, "android");
        params.put(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
        try {
            String[] strings = UMCrashUtils.getActiveUser(context);
            if (strings != null && strings.length == 2) {
                params.put(KEY_HEADER_PUID, strings[1]);
                params.put(KEY_HEADER_PROVIDER, strings[0]);
            }
        } catch (Throwable th) {
            params.put(KEY_HEADER_PUID, "");
            params.put(KEY_HEADER_PROVIDER, "");
        }
        if (!TextUtils.isEmpty(userBver)) {
            params.put(KEY_HEADER_BVER, userBver);
        }
        if (!TextUtils.isEmpty(userBsver)) {
            params.put(KEY_HEADER_BSVER, userBsver);
        }
        if (!TextUtils.isEmpty(userBesrial)) {
            params.put(KEY_HEADER_BESRIAL, userBesrial);
        }
        try {
            if (UMCrashUtils.isHarmony(context)) {
                params.put("others_OS", "harmony");
            } else {
                params.put("others_OS", "Android");
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        sReporter = new EfsReporter.Builder(context.getApplicationContext(), appkey, KEY_APM_DEFAULT_SECRET).debug(isDebug).efsDirRootName(KEY_APM_ROOT_NAME).printLogDetail(isDebug).intl(isIntl).enableWaStat(false).build();
        sReporter.addPublicParams(params);
        try {
            sReporter.getAllSdkConfig(new String[]{UMCrashContent.APM_STATE_PAGE, UMCrashContent.APM_STATE_NET, UMCrashContent.APM_STATE_NATIVE_H5, UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, UMCrashContent.APM_CRASH_USER_MAX_COUNT, UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE}, new IConfigCallback() { // from class: com.umeng.umcrash.UMCrash.5
                @Override // com.efs.sdk.base.observer.IConfigCallback
                public void onChange(Map<String, Object> map) {
                    try {
                        Object netRate = map.get(UMCrashContent.APM_STATE_NET);
                        if (netRate != null) {
                            if (UMCrash.isDebug) {
                                Log.i("efs.config", "callback netRate is " + netRate.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NET, netRate);
                        }
                    } catch (Throwable e2) {
                        e2.printStackTrace();
                    }
                    try {
                        Object nativeH5Rate = map.get(UMCrashContent.APM_STATE_NATIVE_H5);
                        if (nativeH5Rate != null) {
                            if (UMCrash.isDebug) {
                                Log.i("efs.config", "callback nativeH5Rate is " + nativeH5Rate.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NATIVE_H5, nativeH5Rate);
                        }
                    } catch (Throwable e3) {
                        e3.printStackTrace();
                    }
                    try {
                        UMCrash.saveLocalCrashSampling(context, map);
                    } catch (Throwable e4) {
                        e4.printStackTrace();
                    }
                    try {
                        UMCrash.updateLocalCrashConfig(context, map);
                    } catch (Throwable e5) {
                        e5.printStackTrace();
                    }
                    try {
                        Object uploadType = map.get(UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE);
                        if (uploadType != null) {
                            if (UMCrash.isDebug) {
                                Log.i("efs.config", "callback uploadType is " + uploadType.toString());
                            }
                            int type = Integer.valueOf(uploadType.toString()).intValue();
                            if (type == 0) {
                                boolean unused = UMCrash.isUploadNowUserCrash = true;
                            } else {
                                boolean unused2 = UMCrash.isUploadNowUserCrash = false;
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, uploadType);
                        }
                    } catch (Throwable e6) {
                        e6.printStackTrace();
                    }
                    try {
                        Object pageRate = map.get(UMCrashContent.APM_STATE_PAGE);
                        if (pageRate != null) {
                            if (UMCrash.isDebug) {
                                Log.i("efs.config", "callback pageRate is " + pageRate.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_PAGE, pageRate);
                        }
                    } catch (Throwable e7) {
                        e7.printStackTrace();
                    }
                }
            });
        } catch (Throwable e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveLocalCrashSampling(Context context, Map<String, Object> map) {
        if (context != null && map != null) {
            Object crashJavaSampling = map.get(UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE);
            if (crashJavaSampling != null) {
                if (isDebug) {
                    Log.i("efs.config", "callback crashJavaSampling is " + crashJavaSampling.toString());
                }
                UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, crashJavaSampling);
            }
            Object crashNativeSampling = map.get(UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE);
            if (crashNativeSampling != null) {
                if (isDebug) {
                    Log.i("efs.config", "callback crashNativeSampling is " + crashNativeSampling.toString());
                }
                UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, crashNativeSampling);
            }
            Object crashANRSampling = map.get(UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE);
            if (crashANRSampling != null) {
                if (isDebug) {
                    Log.i("efs.config", "callback crashANRSampling is " + crashANRSampling.toString());
                }
                UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, crashANRSampling);
            }
            Object crashUserSampling = map.get(UMCrashContent.APM_CRASH_USER_SAMPLING_RATE);
            if (crashUserSampling != null) {
                if (isDebug) {
                    Log.i("efs.config", "callback crashUserSampling is " + crashUserSampling.toString());
                }
                UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, crashUserSampling);
            }
        }
    }

    private static void updateLocalCrashSampling(Object crashJavaSampling, Object crashNativeSampling, Object crashANRSampling, Object crashUserSampling) {
        CrashApi crashApi = CrashApi.getInstance();
        if (crashApi != null) {
            if (crashJavaSampling != null && UMCrashUtils.random(Integer.valueOf(crashJavaSampling.toString()).intValue())) {
                crashApi.disableLog(16);
            }
            if (crashNativeSampling != null && UMCrashUtils.random(Integer.valueOf(crashNativeSampling.toString()).intValue())) {
                crashApi.disableLog(1);
            }
            if (crashANRSampling != null && UMCrashUtils.random(Integer.valueOf(crashANRSampling.toString()).intValue())) {
                crashApi.disableLog(1048576);
            }
            if (crashUserSampling != null && UMCrashUtils.random(Integer.valueOf(crashUserSampling.toString()).intValue())) {
                isOpenUserCrash = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateLocalCrashConfig(Context context, Map<String, Object> map) {
        if (context != null && map != null) {
            Bundle customInfo = new Bundle();
            Object crashMaxUserCount = map.get(UMCrashContent.APM_CRASH_USER_MAX_COUNT);
            if (crashMaxUserCount != null) {
                if (isDebug) {
                    Log.i("efs.config", "callback crashMaxUserCount is " + crashMaxUserCount.toString());
                }
                customInfo.putInt("mMaxCustomLogCountPerTypePerDay", Integer.valueOf(crashMaxUserCount.toString()).intValue());
                customInfo.putInt("mMaxUploadCustomLogCountPerDay", Integer.valueOf(crashMaxUserCount.toString()).intValue());
            }
            CrashApi.getInstance().updateCustomInfo(customInfo);
        }
    }

    public static void registerUMCrashCallback(UMCrashCallback umCrashCallback) {
        if (umCrashCallback != null) {
            mUMCrashCallback = umCrashCallback;
            if (CrashApi.getInstance() != null) {
                CrashApi.getInstance().registerInfoCallback(KEY_CALLBACK_USER_STRING, 1048593);
                return;
            } else {
                Log.e(TAG, "callback error, instance is null.");
                return;
            }
        }
        Log.e(TAG, "callback error.");
    }

    public static void generateCustomLog(Throwable e, String type) {
        if (!isOpenUserCrash) {
            Log.e(TAG, "generate user is closed .");
            return;
        }
        if (e == null || TextUtils.isEmpty(type)) {
            Log.e(TAG, "generate custom log failed ! e is null or type is empty .");
            return;
        }
        try {
            CustomLogInfo customLogInfo = new UMCustomLogInfoBuilder(type).stack(e).build();
            ArrayList<String> mCallbacks = new ArrayList<>();
            mCallbacks.add(KEY_CALLBACK_UMID);
            mCallbacks.add(KEY_CALLBACK_PAGE_ACTION);
            customLogInfo.mCallbacks = mCallbacks;
            Log.i(TAG, "upload is " + isUploadNowUserCrash);
            customLogInfo.mUploadNow = isUploadNowUserCrash;
            CrashApi mCrashApi = CrashApi.getInstance();
            if (mCrashApi == null) {
                Log.e(TAG, "CrashApi is null, not init .");
            } else {
                mCrashApi.generateCustomLog(customLogInfo);
            }
        } catch (Throwable th) {
        }
    }

    public static void generateCustomLog(String e, String type) {
        if (!isOpenUserCrash) {
            Log.e(TAG, "generate user is closed .");
            return;
        }
        if (TextUtils.isEmpty(e) || TextUtils.isEmpty(type)) {
            Log.e(TAG, "generate custom log failed ! e is null or type is empty .");
            return;
        }
        try {
            CustomLogInfo info = new CustomLogInfo(null, "exception");
            ArrayList<String> mCallbacks = new ArrayList<>();
            mCallbacks.add(KEY_CALLBACK_UMID);
            mCallbacks.add(KEY_CALLBACK_PAGE_ACTION);
            info.mCallbacks = mCallbacks;
            Log.i(TAG, "upload is " + isUploadNowUserCrash);
            info.mUploadNow = isUploadNowUserCrash;
            Map<String, String> kvInfoMap = new HashMap<>(20);
            kvInfoMap.put(UMCustomLogInfoBuilder.LOG_KEY_CT, "exception");
            kvInfoMap.put(UMCustomLogInfoBuilder.LOG_KEY_AC, type);
            StringBuffer sb = new StringBuffer();
            for (Map.Entry<String, String> entry : kvInfoMap.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(entry.getValue());
                sb.append("\n");
            }
            String stack = "Exception message:\nBack traces starts.\n" + e + "\nBack traces ends.";
            if (!TextUtils.isEmpty(stack)) {
                sb.append(stack);
                sb.append("\n");
            }
            info.mData = sb;
            CrashApi mCrashApi = CrashApi.getInstance();
            if (mCrashApi == null) {
                Log.e(TAG, "CrashApi is null, not init .");
            } else {
                mCrashApi.generateCustomLog(info);
            }
        } catch (Throwable th) {
        }
    }
}
