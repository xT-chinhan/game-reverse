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
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.UMAPMCustomController;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.efs.sdk.base.custommapping.IUMPerfCallback;
import com.efs.sdk.base.custommapping.InnerCustomMappingManager;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.efs.sdk.fluttersdk.FlutterManager;
import com.efs.sdk.h5pagesdk.H5Manager;
import com.efs.sdk.launch.LaunchManager;
import com.efs.sdk.memleaksdk.IMemLeakClient;
import com.efs.sdk.memleaksdk.MemLeakManager;
import com.efs.sdk.memoryinfo.UMMemoryMonitor;
import com.efs.sdk.net.NetManager;
import com.efs.sdk.pa.IPaClient;
import com.efs.sdk.pa.PAFactory;
import com.efs.sdk.pa.config.IEfsReporter;
import com.efs.sdk.pa.config.PackageLevel;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import com.uc.crashsdk.export.CrashApi;
import com.uc.crashsdk.export.ICrashClient;
import com.umeng.analytics.pro.bv;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.crash.UCrash;
import com.umeng.crash.UCrashCallback;
import com.umeng.crash.UCrashConfig;
import com.umeng.logsdk.ULogManager;
import com.umeng.logsdk.UploadFileFilterCodeLog;
import com.umeng.pagesdk.PageManger;
import com.umeng.powersdk.PowerManager;
import com.umeng.umcrash.custom_exception.UAPMCustomException;
import com.umeng.umcrash.custominfo.UAPMCustomInfo;
import com.umeng.umcrash.customlog.UAPMCustomLogManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class UMCrash {
    private static final long DEFAULT_PA_TIMEOUT_TIME = 2000;
    private static final boolean DEFAULT_VALUE_CODE_LOG = true;
    private static final boolean DEFAULT_VALUE_CRASH_ANR = true;
    private static final boolean DEFAULT_VALUE_CRASH_JAVA = true;
    private static final boolean DEFAULT_VALUE_CRASH_NATIVE = true;
    private static final boolean DEFAULT_VALUE_CRASH_UNEXP = false;
    private static final boolean DEFAULT_VALUE_FLUTTER = true;
    private static final boolean DEFAULT_VALUE_H5PAGE = true;
    private static final boolean DEFAULT_VALUE_LAUNCH = true;
    private static final boolean DEFAULT_VALUE_MEM = true;
    private static final boolean DEFAULT_VALUE_MEMLEAK = true;
    private static final boolean DEFAULT_VALUE_NET = true;
    private static final boolean DEFAULT_VALUE_PA = true;
    private static final boolean DEFAULT_VALUE_PAGE = true;
    private static final boolean DEFAULT_VALUE_POWER = true;
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
    public static final String KEY_CALLBACK_CUSTOM_LOG = "um_custom_log";
    public static final String KEY_CALLBACK_CUSTOM_MAPPING = "um_custom_mapping";
    public static final String KEY_CALLBACK_PAGE_ACTION = "um_action_log";
    public static final String KEY_CALLBACK_SESSION_ID = "um_session_id";
    public static final String KEY_CALLBACK_UMID = "um_umid";
    public static final String KEY_CALLBACK_UM_INFOS = "um_infos:";
    public static final String KEY_CALLBACK_USER_STRING = "um_user_string";
    private static final String KEY_CALLBACK_USER_STRING_ANR = "um_user_str_anr:";
    public static final String KEY_CALLBACK_USER_STRING_CUSTOM_LOG = "um_user_str_custom_log:";
    private static final String KEY_CALLBACK_USER_STRING_JAVA = "um_user_str_java:";
    private static final String KEY_CALLBACK_USER_STRING_NATIVE = "um_user_str_native:";
    public static final String KEY_DEBUGKEY = "um_dk";
    public static final String KEY_ENABLE_ANR = "enableANRLog";
    public static final String KEY_ENABLE_CODE_LOG = "enableCodeLog";
    public static final String KEY_ENABLE_CRASH_JAVA = "enableJavaLog";
    public static final String KEY_ENABLE_CRASH_NATIVE = "enableNativeLog";
    public static final String KEY_ENABLE_CRASH_UNEXP = "enableUnexpLog";
    public static final String KEY_ENABLE_FLUTTER = "enableFlutterLog";
    public static final String KEY_ENABLE_H5PAGE = "enableH5PageLog";
    public static final String KEY_ENABLE_LAUNCH = "enableLaunchLog";
    public static final String KEY_ENABLE_MEM = "enableMemLog";
    public static final String KEY_ENABLE_MEMLEAK = "enableMemLeakLog";
    public static final String KEY_ENABLE_NET = "enableNetLog";
    public static final String KEY_ENABLE_PA = "enablePaLog";
    public static final String KEY_ENABLE_PAGE = "enablePageLog";
    public static final String KEY_ENABLE_POWER = "enablePowerLog";
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
    public static final String KEY_LOG_DEVICES_ID = "log_devices_id";
    public static final String KEY_LOG_USER_ID = "log_user_id";
    private static final int KEY_MAX_LENGTH = 20480;
    private static final int KEY_MAX_LENGTH_128 = 128;
    public static final String KEY_PA_TIMEOUT_TIME = "pa_timeout_time";
    public static final String SP_KEY_DEBUG = "debugkey";
    public static final String SP_KEY_TIMESTAMP = "timestamp";
    private static final String TAG = "UMCrash";
    private static String crashSdkVersion = "2.0.8";
    private static boolean isBuildId = true;
    private static boolean isDebug = true;
    private static boolean isEncrypt = false;
    private static boolean isIntl = false;
    private static boolean isZip = true;
    private static Context mContext = null;
    private static UMCrashCallback mUMCrashCallback = null;
    private static IUMCrashCallbackWithType mUMCrashCallbackWithType = null;
    private static boolean sIsDumpAllStackTrace = true;
    private static boolean sIsEnableLogBackup = false;
    private static boolean sIsKillProcessAfterCrash = true;
    public static EfsReporter sReporter;
    public static UMAPMCustomController sUMAPMCustomController;
    private static String userBesrial;
    private static String userBsver;
    private static String userBver;
    private static Object pageArrayLock = new Object();
    private static ArrayList<String> mArrayList = new ArrayList<>(10);
    private static int sApmCallbackLimit = 0;
    private static boolean isPA = false;
    private static boolean isLa = false;
    private static boolean isNet = false;
    private static boolean isPage = false;
    private static boolean isPower = false;
    private static boolean isFlutter = false;
    private static boolean isCodeLog = false;
    private static boolean isMemLeak = false;
    private static boolean enableJavaLog = true;
    private static boolean enableNativeLog = true;
    private static boolean enableANRLog = true;
    private static boolean enablePaLog = true;
    private static boolean enableLaunchLog = true;
    private static boolean enableMemLog = true;
    private static boolean enableNetLog = true;
    private static boolean enableH5PageLog = true;
    private static boolean enablePageLog = true;
    private static boolean enableCodeLog = true;
    private static boolean enablePowerLog = true;
    private static boolean enableFlutterLog = true;
    private static boolean enableMemLeakLog = true;
    private static boolean enableUCJavaLog = false;
    private static boolean enableUCNativeLog = false;
    private static boolean enableUCANRLog = false;
    private static boolean enableUCUserLog = false;
    private static boolean enableUMJavaLog = true;
    private static boolean enableUMNativeLog = true;
    private static boolean enableUMANRLog = true;
    private static boolean enableUMUserLog = true;
    private static boolean enableUMAnrTrace = true;
    private static long paTimeoutTime = 2000;
    private static int index = 0;
    private static boolean isOpenUserCrash = true;
    private static boolean isUploadNowUserCrash = false;

    static /* synthetic */ int access$1608() {
        int i = index;
        index = i + 1;
        return i;
    }

    static /* synthetic */ int access$1610() {
        int i = index;
        index = i - 1;
        return i;
    }

    public static EfsReporter getReporter() {
        return sReporter;
    }

    public static void isBuildId(boolean z) {
        isBuildId = z;
    }

    public static void setAppVersion(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.trim().getBytes().length > 128) {
                    str = UMCrashUtils.splitByByte(str, 128);
                }
                userBver = str;
            } else if (isDebug) {
                Log.e(TAG, "version is null or empty !");
            }
            if (!TextUtils.isEmpty(str2)) {
                if (str2.trim().getBytes().length > 128) {
                    str2 = UMCrashUtils.splitByByte(str2, 128);
                }
                userBsver = str2;
            } else if (isDebug) {
                Log.e(TAG, "sub version is null or empty !");
            }
            if (!TextUtils.isEmpty(str3)) {
                if (str3.trim().getBytes().length > 128) {
                    str3 = UMCrashUtils.splitByByte(str3, 128);
                }
                userBesrial = str3;
            } else if (isDebug) {
                Log.e(TAG, "build id is null or empty !");
            }
            CrashApi crashApi = CrashApi.getInstance();
            if (crashApi != null) {
                if (!TextUtils.isEmpty(userBver)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BVER, userBver);
                    UCrash.addHeader(KEY_HEADER_BVER, userBver);
                }
                if (!TextUtils.isEmpty(userBsver)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BSVER, userBsver);
                    UCrash.addHeader(KEY_HEADER_BSVER, userBsver);
                }
                if (!TextUtils.isEmpty(userBesrial)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BESRIAL, userBesrial);
                    UCrash.addHeader(KEY_HEADER_BESRIAL, userBesrial);
                }
            } else if (isDebug) {
                Log.e(TAG, "set app version. crashApi is null");
            }
            HashMap map = new HashMap(1);
            if (!TextUtils.isEmpty(userBver)) {
                map.put(KEY_HEADER_BVER, userBver);
            }
            if (!TextUtils.isEmpty(userBsver)) {
                map.put(KEY_HEADER_BSVER, userBsver);
            }
            if (!TextUtils.isEmpty(userBesrial)) {
                map.put(KEY_HEADER_BESRIAL, userBesrial);
            }
            EfsReporter efsReporter = sReporter;
            if (efsReporter != null) {
                efsReporter.addPublicParams(map);
            } else if (isDebug) {
                Log.e(TAG, "set app version.  sReporter is null");
            }
            if (!TextUtils.isEmpty(userBver)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BVER, userBver);
            }
            if (!TextUtils.isEmpty(userBsver)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BSVER, userBsver);
            }
            if (TextUtils.isEmpty(userBesrial)) {
                return;
            }
            UMCrashUtils.setCommonTag(KEY_HEADER_BESRIAL, userBesrial);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static class CrashClientImpl implements ICrashClient {
        @Override // com.uc.crashsdk.export.ICrashClient
        public void onAddCrashStats(String str, int i, int i2) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public File onBeforeUploadLog(File file) {
            return file;
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onClientProcessLogGenerated(String str, File file, String str2) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onCrashRestarting(boolean z) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onLogGenerated(File file, String str) {
        }

        private CrashClientImpl() {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public String onGetCallbackInfo(String str, boolean z) {
            if (UMCrash.KEY_CALLBACK_UMID.equals(str)) {
                return UMCrashUtils.getUMID(UMCrash.mContext);
            }
            if (UMCrash.KEY_CALLBACK_UM_INFOS.equals(str)) {
                return UMCrash.generateUMInfos();
            }
            if (UMCrash.KEY_CALLBACK_USER_STRING.equals(str)) {
                return UMCrash.generateNormalUserString();
            }
            if (UMCrash.KEY_CALLBACK_USER_STRING_JAVA.equals(str)) {
                return UMCrash.generateJavaUserString();
            }
            if (UMCrash.KEY_CALLBACK_USER_STRING_NATIVE.equals(str)) {
                return UMCrash.generateNativeUserString();
            }
            if (UMCrash.KEY_CALLBACK_USER_STRING_ANR.equals(str)) {
                return UMCrash.generateANRUserString();
            }
            if (UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG.equals(str)) {
                return UMCrash.generateCustomUserString();
            }
            return null;
        }
    }

    private static class UCrashCallbackImpl implements UCrashCallback {
        private UCrashCallbackImpl() {
        }

        @Override // com.umeng.crash.UCrashCallback
        public Map<String, String> getExtras(String str) {
            HashMap map = new HashMap();
            map.put(UMCrash.KEY_CALLBACK_USER_STRING, UMCrash.generateNormalUserString());
            if ("java".equals(str)) {
                map.put(UMCrash.KEY_CALLBACK_USER_STRING_JAVA, UMCrash.generateJavaUserString());
            } else if ("jni".equals(str)) {
                map.put(UMCrash.KEY_CALLBACK_USER_STRING_NATIVE, UMCrash.generateNativeUserString());
            } else if ("anr".equals(str)) {
                map.put(UMCrash.KEY_CALLBACK_USER_STRING_ANR, UMCrash.generateANRUserString());
            } else if ("exception".equals(str)) {
                map.put(UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG, UMCrash.generateCustomUserString());
            }
            map.put(UMCrash.KEY_CALLBACK_UMID, UMCrashUtils.getUMID(UMCrash.mContext));
            map.put(UMCrash.KEY_CALLBACK_UM_INFOS, UMCrash.generateUMInfos());
            return map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateNormalUserString() {
        UMCrashCallback uMCrashCallback;
        String strOnCallback;
        if (mUMCrashCallbackWithType != null || (uMCrashCallback = mUMCrashCallback) == null || (strOnCallback = uMCrashCallback.onCallback()) == null) {
            return null;
        }
        return strOnCallback.trim().getBytes().length > Math.max(20480, sApmCallbackLimit) ? UMCrashUtils.splitByByte(strOnCallback, Math.max(20480, sApmCallbackLimit)) : strOnCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateJavaUserString() {
        String strOnCallback;
        IUMCrashCallbackWithType iUMCrashCallbackWithType = mUMCrashCallbackWithType;
        if (iUMCrashCallbackWithType == null || (strOnCallback = iUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_JAVA)) == null) {
            return null;
        }
        return strOnCallback.trim().getBytes().length > Math.max(20480, sApmCallbackLimit) ? UMCrashUtils.splitByByte(strOnCallback, Math.max(20480, sApmCallbackLimit)) : strOnCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateNativeUserString() {
        String strOnCallback;
        IUMCrashCallbackWithType iUMCrashCallbackWithType = mUMCrashCallbackWithType;
        if (iUMCrashCallbackWithType == null || (strOnCallback = iUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_NATIVE)) == null) {
            return null;
        }
        return strOnCallback.trim().getBytes().length > Math.max(20480, sApmCallbackLimit) ? UMCrashUtils.splitByByte(strOnCallback, Math.max(20480, sApmCallbackLimit)) : strOnCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateANRUserString() {
        String strOnCallback;
        IUMCrashCallbackWithType iUMCrashCallbackWithType = mUMCrashCallbackWithType;
        if (iUMCrashCallbackWithType == null || (strOnCallback = iUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_ANR)) == null) {
            return null;
        }
        return strOnCallback.trim().getBytes().length > Math.max(20480, sApmCallbackLimit) ? UMCrashUtils.splitByByte(strOnCallback, Math.max(20480, sApmCallbackLimit)) : strOnCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateCustomUserString() {
        String strOnCallback;
        IUMCrashCallbackWithType iUMCrashCallbackWithType = mUMCrashCallbackWithType;
        if (iUMCrashCallbackWithType == null || (strOnCallback = iUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_CUSTOM_LOG)) == null) {
            return null;
        }
        return strOnCallback.trim().getBytes().length > Math.max(20480, sApmCallbackLimit) ? UMCrashUtils.splitByByte(strOnCallback, Math.max(20480, sApmCallbackLimit)) : strOnCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateUMInfos() {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList<String> arrayList = mArrayList;
            if (arrayList != null && arrayList.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("source", 0);
                jSONObject2.put("action_name", TrackAction.PAGE_VIEW);
                jSONObject2.put("action_page_state", isPage);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < mArrayList.size(); i++) {
                    String str = mArrayList.get(i);
                    if (str != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(Common.System.NAME, str);
                        jSONArray.put(jSONObject3);
                    }
                }
                jSONObject2.put("action_parameter", jSONArray);
                String string = jSONObject2.toString();
                if (isDebug) {
                    Log.i(TAG, "page json is " + string);
                }
                jSONObject.put(KEY_CALLBACK_PAGE_ACTION, string);
            }
        } catch (Throwable unused) {
        }
        try {
            jSONObject.put(KEY_CALLBACK_SESSION_ID, UMCrashUtils.getSessionId(mContext));
            jSONObject.put(KEY_CALLBACK_CUSTOM_LOG, UAPMCustomLogManager.getCustomLogs());
            jSONObject.put(KEY_CALLBACK_CUSTOM_MAPPING, InnerCustomMappingManager.getCustomMappingJsonStr());
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static class PaClientImpl implements IPaClient {
        private PaClientImpl() {
        }

        @Override // com.efs.sdk.pa.IPaClient
        public String onGetCallbackInfo(String str) {
            String strOnCallback;
            String string = null;
            if (UMCrash.KEY_CALLBACK_PAGE_ACTION.equals(str)) {
                try {
                    if (UMCrash.mArrayList != null && UMCrash.mArrayList.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("source", 0);
                        jSONObject.put("action_name", TrackAction.PAGE_VIEW);
                        jSONObject.put("action_page_state", UMCrash.isPage);
                        JSONArray jSONArray = new JSONArray();
                        for (int i = 0; i < UMCrash.mArrayList.size(); i++) {
                            String str2 = (String) UMCrash.mArrayList.get(i);
                            if (str2 != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(Common.System.NAME, str2);
                                jSONArray.put(jSONObject2);
                            }
                        }
                        jSONObject.put("action_parameter", jSONArray);
                        string = jSONObject.toString();
                        if (UMCrash.isDebug) {
                            Log.i(UMCrash.TAG, "page json is " + string);
                        }
                    }
                } catch (Throwable unused) {
                }
                return string;
            }
            if (UMCrash.KEY_CALLBACK_USER_STRING.equals(str)) {
                if (UMCrash.mUMCrashCallbackWithType != null) {
                    String strOnCallback2 = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_BLOCK);
                    if (strOnCallback2 == null) {
                        return null;
                    }
                    return strOnCallback2.trim().getBytes().length > Math.max(20480, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(strOnCallback2, Math.max(20480, UMCrash.sApmCallbackLimit)) : strOnCallback2;
                }
                if (UMCrash.mUMCrashCallback == null || (strOnCallback = UMCrash.mUMCrashCallback.onCallback()) == null) {
                    return null;
                }
                return strOnCallback.trim().getBytes().length > Math.max(20480, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(strOnCallback, Math.max(20480, UMCrash.sApmCallbackLimit)) : strOnCallback;
            }
            return null;
        }
    }

    private static class MemLeakClientImpl implements IMemLeakClient {
        private MemLeakClientImpl() {
        }

        @Override // com.efs.sdk.memleaksdk.IMemLeakClient
        public String onGetCallbackInfo(String str) {
            String strOnCallback;
            String string = null;
            if (UMCrash.KEY_CALLBACK_PAGE_ACTION.equals(str)) {
                try {
                    if (UMCrash.mArrayList != null && UMCrash.mArrayList.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("source", 0);
                        jSONObject.put("action_name", TrackAction.PAGE_VIEW);
                        jSONObject.put("action_page_state", UMCrash.isPage);
                        JSONArray jSONArray = new JSONArray();
                        for (int i = 0; i < UMCrash.mArrayList.size(); i++) {
                            String str2 = (String) UMCrash.mArrayList.get(i);
                            if (str2 != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(Common.System.NAME, str2);
                                jSONArray.put(jSONObject2);
                            }
                        }
                        jSONObject.put("action_parameter", jSONArray);
                        string = jSONObject.toString();
                        if (UMCrash.isDebug) {
                            Log.i(UMCrash.TAG, "page json is " + string);
                        }
                    }
                } catch (Throwable unused) {
                }
                return string;
            }
            if (UMCrash.KEY_CALLBACK_USER_STRING.equals(str)) {
                if (UMCrash.mUMCrashCallbackWithType != null) {
                    String strOnCallback2 = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_MEM_LEAK);
                    if (strOnCallback2 == null) {
                        return null;
                    }
                    return strOnCallback2.trim().getBytes().length > Math.max(20480, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(strOnCallback2, Math.max(20480, UMCrash.sApmCallbackLimit)) : strOnCallback2;
                }
                if (UMCrash.mUMCrashCallback == null || (strOnCallback = UMCrash.mUMCrashCallback.onCallback()) == null) {
                    return null;
                }
                return strOnCallback.trim().getBytes().length > Math.max(20480, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(strOnCallback, Math.max(20480, UMCrash.sApmCallbackLimit)) : strOnCallback;
            }
            return null;
        }
    }

    public static String getUMAPMFlag() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", 0);
            jSONObject.put("crash", 1);
            if (enableJavaLog) {
                jSONObject.put("crashJava", 1);
            } else {
                jSONObject.put("crashJava", 0);
            }
            if (enableNativeLog) {
                jSONObject.put("crashNative", 1);
            } else {
                jSONObject.put("crashNative", 0);
            }
            if (enableANRLog) {
                jSONObject.put("anr", 1);
            } else {
                jSONObject.put("anr", 0);
            }
            if (isPA) {
                jSONObject.put("pa", 1);
            } else {
                jSONObject.put("pa", 0);
            }
            if (isLa) {
                jSONObject.put("la", 1);
            } else {
                jSONObject.put("la", 0);
            }
            if (UMMemoryMonitor.get().isEnable()) {
                jSONObject.put("mem", 1);
            } else {
                jSONObject.put("mem", 0);
            }
            if (isNet) {
                jSONObject.put(TKDownloadReason.KSAD_TK_NET, 1);
            } else {
                jSONObject.put(TKDownloadReason.KSAD_TK_NET, 0);
            }
            if (H5Manager.getH5ConfigMananger() != null && H5Manager.getH5ConfigMananger().isH5TracerEnable()) {
                jSONObject.put("h5", 1);
            } else {
                jSONObject.put("h5", 0);
            }
            if (isOpenUserCrash) {
                jSONObject.put("crashUser", 1);
            } else {
                jSONObject.put("crashUser", 0);
            }
            if (isPage) {
                jSONObject.put("page", 1);
            } else {
                jSONObject.put("page", 0);
            }
            if (isPower) {
                jSONObject.put("power", 1);
            } else {
                jSONObject.put("power", 0);
            }
            if (isCodeLog) {
                jSONObject.put("codelog", 1);
            } else {
                jSONObject.put("codelog", 0);
            }
            if (isMemLeak) {
                jSONObject.put("memleak", 1);
            } else {
                jSONObject.put("memleak", 0);
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public static void enableJavaScriptBridge(WebView webView) {
        enableJavaScriptBridge((View) webView);
    }

    public static void enableJavaScriptBridge(View view) {
        try {
            H5Manager.setWebView(view);
        } catch (Throwable unused) {
        }
    }

    public static void enableKillProcessAfterCrash(boolean z) {
        sIsKillProcessAfterCrash = z;
    }

    public static void setLogCollectSaveSize(long j) {
        ULogManager.setsLogMaxCache(j);
    }

    public static void setDebug(boolean z) {
        isDebug = z;
        LaunchManager.isDebug = z;
        H5Manager.isDebug = z;
        PageManger.isDebug = z;
        PowerManager.isDebug = z;
        ULogManager.isDebug = z;
        MemLeakManager.isDebug = z;
    }

    private static void useIntlServices(boolean z) {
        isIntl = z;
        if (isDebug) {
            Log.i(TAG, "useIntlServices is " + isIntl);
        }
    }

    @Deprecated
    public static void enableNativeLog(boolean z) {
        enableNativeLog = z;
    }

    @Deprecated
    public static void enableANRLog(boolean z) {
        enableANRLog = z;
    }

    public static void setPaTimeoutTime(long j) {
        paTimeoutTime = j;
    }

    public static void setCustomController(UMAPMCustomController uMAPMCustomController) {
        sUMAPMCustomController = uMAPMCustomController;
    }

    public static void initConfig(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getBoolean(KEY_ENABLE_CRASH_JAVA, true)) {
                enableJavaLog = true;
            } else {
                enableJavaLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_CRASH_NATIVE, true)) {
                enableNativeLog = true;
            } else {
                enableNativeLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_ANR, true)) {
                enableANRLog = true;
            } else {
                enableANRLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_PA, true)) {
                enablePaLog = true;
            } else {
                enablePaLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_LAUNCH, true)) {
                enableLaunchLog = true;
            } else {
                enableLaunchLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_MEM, true)) {
                enableMemLog = true;
            } else {
                enableMemLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_NET, true)) {
                enableNetLog = true;
            } else {
                enableNetLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_H5PAGE, true)) {
                enableH5PageLog = true;
            } else {
                enableH5PageLog = false;
            }
            paTimeoutTime = bundle.getLong(KEY_PA_TIMEOUT_TIME, 2000L);
            if (bundle.getBoolean(KEY_ENABLE_PAGE, true)) {
                enablePageLog = true;
            } else {
                enablePageLog = false;
            }
            try {
                if (bundle.getBoolean(KEY_ENABLE_CODE_LOG, true)) {
                    enableCodeLog = true;
                } else {
                    enableCodeLog = false;
                }
                ULogManager.setUserID(bundle.getString(KEY_LOG_USER_ID, ""));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (bundle.getBoolean(KEY_ENABLE_POWER, true)) {
                enablePowerLog = true;
            } else {
                enablePowerLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_FLUTTER, true)) {
                enableFlutterLog = true;
            } else {
                enableFlutterLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_MEMLEAK, true)) {
                enableMemLeakLog = true;
            } else {
                enableMemLeakLog = false;
            }
        }
    }

    @Deprecated
    public static void enableMemoryMonitor(boolean z) {
        UMMemoryMonitor.get().setEnable(z);
    }

    /* JADX WARN: Code duplicated, block: B:124:0x03b2 A[Catch: all -> 0x042e, TryCatch #8 {all -> 0x042e, blocks: (B:122:0x03a3, B:124:0x03b2, B:126:0x03c8, B:128:0x03cc, B:142:0x0413, B:144:0x0417, B:130:0x03d6, B:132:0x03da, B:133:0x03e1, B:135:0x03e5, B:137:0x03ef, B:139:0x03f9, B:140:0x040d, B:141:0x0410), top: B:380:0x03a3 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x03c8 A[Catch: all -> 0x042e, TryCatch #8 {all -> 0x042e, blocks: (B:122:0x03a3, B:124:0x03b2, B:126:0x03c8, B:128:0x03cc, B:142:0x0413, B:144:0x0417, B:130:0x03d6, B:132:0x03da, B:133:0x03e1, B:135:0x03e5, B:137:0x03ef, B:139:0x03f9, B:140:0x040d, B:141:0x0410), top: B:380:0x03a3 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x03cc A[Catch: all -> 0x042e, TryCatch #8 {all -> 0x042e, blocks: (B:122:0x03a3, B:124:0x03b2, B:126:0x03c8, B:128:0x03cc, B:142:0x0413, B:144:0x0417, B:130:0x03d6, B:132:0x03da, B:133:0x03e1, B:135:0x03e5, B:137:0x03ef, B:139:0x03f9, B:140:0x040d, B:141:0x0410), top: B:380:0x03a3 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:130:0x03d6 A[Catch: all -> 0x042e, TryCatch #8 {all -> 0x042e, blocks: (B:122:0x03a3, B:124:0x03b2, B:126:0x03c8, B:128:0x03cc, B:142:0x0413, B:144:0x0417, B:130:0x03d6, B:132:0x03da, B:133:0x03e1, B:135:0x03e5, B:137:0x03ef, B:139:0x03f9, B:140:0x040d, B:141:0x0410), top: B:380:0x03a3 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x03da A[Catch: all -> 0x042e, TryCatch #8 {all -> 0x042e, blocks: (B:122:0x03a3, B:124:0x03b2, B:126:0x03c8, B:128:0x03cc, B:142:0x0413, B:144:0x0417, B:130:0x03d6, B:132:0x03da, B:133:0x03e1, B:135:0x03e5, B:137:0x03ef, B:139:0x03f9, B:140:0x040d, B:141:0x0410), top: B:380:0x03a3 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x03e5 A[Catch: all -> 0x042e, TryCatch #8 {all -> 0x042e, blocks: (B:122:0x03a3, B:124:0x03b2, B:126:0x03c8, B:128:0x03cc, B:142:0x0413, B:144:0x0417, B:130:0x03d6, B:132:0x03da, B:133:0x03e1, B:135:0x03e5, B:137:0x03ef, B:139:0x03f9, B:140:0x040d, B:141:0x0410), top: B:380:0x03a3 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x03ef A[Catch: all -> 0x042e, TryCatch #8 {all -> 0x042e, blocks: (B:122:0x03a3, B:124:0x03b2, B:126:0x03c8, B:128:0x03cc, B:142:0x0413, B:144:0x0417, B:130:0x03d6, B:132:0x03da, B:133:0x03e1, B:135:0x03e5, B:137:0x03ef, B:139:0x03f9, B:140:0x040d, B:141:0x0410), top: B:380:0x03a3 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x03f9 A[Catch: all -> 0x042e, TryCatch #8 {all -> 0x042e, blocks: (B:122:0x03a3, B:124:0x03b2, B:126:0x03c8, B:128:0x03cc, B:142:0x0413, B:144:0x0417, B:130:0x03d6, B:132:0x03da, B:133:0x03e1, B:135:0x03e5, B:137:0x03ef, B:139:0x03f9, B:140:0x040d, B:141:0x0410), top: B:380:0x03a3 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0417 A[Catch: all -> 0x042e, TRY_LEAVE, TryCatch #8 {all -> 0x042e, blocks: (B:122:0x03a3, B:124:0x03b2, B:126:0x03c8, B:128:0x03cc, B:142:0x0413, B:144:0x0417, B:130:0x03d6, B:132:0x03da, B:133:0x03e1, B:135:0x03e5, B:137:0x03ef, B:139:0x03f9, B:140:0x040d, B:141:0x0410), top: B:380:0x03a3 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x0460 A[Catch: all -> 0x0470, TRY_LEAVE, TryCatch #9 {all -> 0x0470, blocks: (B:152:0x043b, B:154:0x0452, B:156:0x0458, B:157:0x0460), top: B:382:0x043b }] */
    /* JADX WARN: Code duplicated, block: B:163:0x0478 A[Catch: all -> 0x048d, TryCatch #22 {all -> 0x048d, blocks: (B:161:0x0474, B:163:0x0478, B:164:0x0481, B:166:0x0485), top: B:403:0x0474 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x0481 A[Catch: all -> 0x048d, TryCatch #22 {all -> 0x048d, blocks: (B:161:0x0474, B:163:0x0478, B:164:0x0481, B:166:0x0485), top: B:403:0x0474 }] */
    /* JADX WARN: Code duplicated, block: B:166:0x0485 A[Catch: all -> 0x048d, TRY_LEAVE, TryCatch #22 {all -> 0x048d, blocks: (B:161:0x0474, B:163:0x0478, B:164:0x0481, B:166:0x0485), top: B:403:0x0474 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0495 A[Catch: all -> 0x04e1, TRY_LEAVE, TryCatch #1 {all -> 0x04e1, blocks: (B:170:0x0491, B:172:0x0495, B:179:0x04af, B:181:0x04b5, B:183:0x04bb, B:185:0x04bf, B:186:0x04c6, B:178:0x04ac, B:187:0x04d5, B:189:0x04d9, B:173:0x049a, B:175:0x04a0), top: B:369:0x0491, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x04a0 A[Catch: all -> 0x04ab, TRY_LEAVE, TryCatch #5 {all -> 0x04ab, blocks: (B:173:0x049a, B:175:0x04a0), top: B:375:0x049a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:183:0x04bb A[Catch: all -> 0x04e1, TryCatch #1 {all -> 0x04e1, blocks: (B:170:0x0491, B:172:0x0495, B:179:0x04af, B:181:0x04b5, B:183:0x04bb, B:185:0x04bf, B:186:0x04c6, B:178:0x04ac, B:187:0x04d5, B:189:0x04d9, B:173:0x049a, B:175:0x04a0), top: B:369:0x0491, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x04bf A[Catch: all -> 0x04e1, TryCatch #1 {all -> 0x04e1, blocks: (B:170:0x0491, B:172:0x0495, B:179:0x04af, B:181:0x04b5, B:183:0x04bb, B:185:0x04bf, B:186:0x04c6, B:178:0x04ac, B:187:0x04d5, B:189:0x04d9, B:173:0x049a, B:175:0x04a0), top: B:369:0x0491, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x04d5 A[Catch: all -> 0x04e1, TryCatch #1 {all -> 0x04e1, blocks: (B:170:0x0491, B:172:0x0495, B:179:0x04af, B:181:0x04b5, B:183:0x04bb, B:185:0x04bf, B:186:0x04c6, B:178:0x04ac, B:187:0x04d5, B:189:0x04d9, B:173:0x049a, B:175:0x04a0), top: B:369:0x0491, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x04d9 A[Catch: all -> 0x04e1, TRY_LEAVE, TryCatch #1 {all -> 0x04e1, blocks: (B:170:0x0491, B:172:0x0495, B:179:0x04af, B:181:0x04b5, B:183:0x04bb, B:185:0x04bf, B:186:0x04c6, B:178:0x04ac, B:187:0x04d5, B:189:0x04d9, B:173:0x049a, B:175:0x04a0), top: B:369:0x0491, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x04e9 A[Catch: all -> 0x04ff, TryCatch #16 {all -> 0x04ff, blocks: (B:193:0x04e5, B:195:0x04e9, B:196:0x04f3, B:198:0x04f7), top: B:394:0x04e5 }] */
    /* JADX WARN: Code duplicated, block: B:196:0x04f3 A[Catch: all -> 0x04ff, TryCatch #16 {all -> 0x04ff, blocks: (B:193:0x04e5, B:195:0x04e9, B:196:0x04f3, B:198:0x04f7), top: B:394:0x04e5 }] */
    /* JADX WARN: Code duplicated, block: B:198:0x04f7 A[Catch: all -> 0x04ff, TRY_LEAVE, TryCatch #16 {all -> 0x04ff, blocks: (B:193:0x04e5, B:195:0x04e9, B:196:0x04f3, B:198:0x04f7), top: B:394:0x04e5 }] */
    /* JADX WARN: Code duplicated, block: B:204:0x0512 A[Catch: all -> 0x056c, TryCatch #7 {all -> 0x056c, blocks: (B:202:0x0503, B:204:0x0512, B:206:0x0528, B:208:0x052c, B:210:0x0536, B:212:0x053a, B:213:0x0541, B:215:0x0545, B:221:0x055c, B:222:0x0560, B:224:0x0564, B:216:0x054a, B:218:0x0550), top: B:379:0x0503, inners: #29 }] */
    /* JADX WARN: Code duplicated, block: B:206:0x0528 A[Catch: all -> 0x056c, TryCatch #7 {all -> 0x056c, blocks: (B:202:0x0503, B:204:0x0512, B:206:0x0528, B:208:0x052c, B:210:0x0536, B:212:0x053a, B:213:0x0541, B:215:0x0545, B:221:0x055c, B:222:0x0560, B:224:0x0564, B:216:0x054a, B:218:0x0550), top: B:379:0x0503, inners: #29 }] */
    /* JADX WARN: Code duplicated, block: B:208:0x052c A[Catch: all -> 0x056c, TryCatch #7 {all -> 0x056c, blocks: (B:202:0x0503, B:204:0x0512, B:206:0x0528, B:208:0x052c, B:210:0x0536, B:212:0x053a, B:213:0x0541, B:215:0x0545, B:221:0x055c, B:222:0x0560, B:224:0x0564, B:216:0x054a, B:218:0x0550), top: B:379:0x0503, inners: #29 }] */
    /* JADX WARN: Code duplicated, block: B:209:0x0534  */
    /* JADX WARN: Code duplicated, block: B:210:0x0536 A[Catch: all -> 0x056c, TryCatch #7 {all -> 0x056c, blocks: (B:202:0x0503, B:204:0x0512, B:206:0x0528, B:208:0x052c, B:210:0x0536, B:212:0x053a, B:213:0x0541, B:215:0x0545, B:221:0x055c, B:222:0x0560, B:224:0x0564, B:216:0x054a, B:218:0x0550), top: B:379:0x0503, inners: #29 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x053a A[Catch: all -> 0x056c, TryCatch #7 {all -> 0x056c, blocks: (B:202:0x0503, B:204:0x0512, B:206:0x0528, B:208:0x052c, B:210:0x0536, B:212:0x053a, B:213:0x0541, B:215:0x0545, B:221:0x055c, B:222:0x0560, B:224:0x0564, B:216:0x054a, B:218:0x0550), top: B:379:0x0503, inners: #29 }] */
    /* JADX WARN: Code duplicated, block: B:215:0x0545 A[Catch: all -> 0x056c, TRY_LEAVE, TryCatch #7 {all -> 0x056c, blocks: (B:202:0x0503, B:204:0x0512, B:206:0x0528, B:208:0x052c, B:210:0x0536, B:212:0x053a, B:213:0x0541, B:215:0x0545, B:221:0x055c, B:222:0x0560, B:224:0x0564, B:216:0x054a, B:218:0x0550), top: B:379:0x0503, inners: #29 }] */
    /* JADX WARN: Code duplicated, block: B:218:0x0550 A[Catch: all -> 0x055b, TRY_LEAVE, TryCatch #29 {all -> 0x055b, blocks: (B:216:0x054a, B:218:0x0550), top: B:414:0x054a, outer: #7 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x0560 A[Catch: all -> 0x056c, TryCatch #7 {all -> 0x056c, blocks: (B:202:0x0503, B:204:0x0512, B:206:0x0528, B:208:0x052c, B:210:0x0536, B:212:0x053a, B:213:0x0541, B:215:0x0545, B:221:0x055c, B:222:0x0560, B:224:0x0564, B:216:0x054a, B:218:0x0550), top: B:379:0x0503, inners: #29 }] */
    /* JADX WARN: Code duplicated, block: B:224:0x0564 A[Catch: all -> 0x056c, TRY_LEAVE, TryCatch #7 {all -> 0x056c, blocks: (B:202:0x0503, B:204:0x0512, B:206:0x0528, B:208:0x052c, B:210:0x0536, B:212:0x053a, B:213:0x0541, B:215:0x0545, B:221:0x055c, B:222:0x0560, B:224:0x0564, B:216:0x054a, B:218:0x0550), top: B:379:0x0503, inners: #29 }] */
    /* JADX WARN: Code duplicated, block: B:230:0x057f A[Catch: all -> 0x05c4, TryCatch #18 {all -> 0x05c4, blocks: (B:228:0x0570, B:230:0x057f, B:232:0x0595, B:234:0x0599, B:236:0x05a3, B:238:0x05a7, B:239:0x05ae, B:241:0x05b2, B:242:0x05b8, B:244:0x05bc), top: B:397:0x0570 }] */
    /* JADX WARN: Code duplicated, block: B:232:0x0595 A[Catch: all -> 0x05c4, TryCatch #18 {all -> 0x05c4, blocks: (B:228:0x0570, B:230:0x057f, B:232:0x0595, B:234:0x0599, B:236:0x05a3, B:238:0x05a7, B:239:0x05ae, B:241:0x05b2, B:242:0x05b8, B:244:0x05bc), top: B:397:0x0570 }] */
    /* JADX WARN: Code duplicated, block: B:234:0x0599 A[Catch: all -> 0x05c4, TryCatch #18 {all -> 0x05c4, blocks: (B:228:0x0570, B:230:0x057f, B:232:0x0595, B:234:0x0599, B:236:0x05a3, B:238:0x05a7, B:239:0x05ae, B:241:0x05b2, B:242:0x05b8, B:244:0x05bc), top: B:397:0x0570 }] */
    /* JADX WARN: Code duplicated, block: B:235:0x05a1  */
    /* JADX WARN: Code duplicated, block: B:236:0x05a3 A[Catch: all -> 0x05c4, TryCatch #18 {all -> 0x05c4, blocks: (B:228:0x0570, B:230:0x057f, B:232:0x0595, B:234:0x0599, B:236:0x05a3, B:238:0x05a7, B:239:0x05ae, B:241:0x05b2, B:242:0x05b8, B:244:0x05bc), top: B:397:0x0570 }] */
    /* JADX WARN: Code duplicated, block: B:238:0x05a7 A[Catch: all -> 0x05c4, TryCatch #18 {all -> 0x05c4, blocks: (B:228:0x0570, B:230:0x057f, B:232:0x0595, B:234:0x0599, B:236:0x05a3, B:238:0x05a7, B:239:0x05ae, B:241:0x05b2, B:242:0x05b8, B:244:0x05bc), top: B:397:0x0570 }] */
    /* JADX WARN: Code duplicated, block: B:241:0x05b2 A[Catch: all -> 0x05c4, TryCatch #18 {all -> 0x05c4, blocks: (B:228:0x0570, B:230:0x057f, B:232:0x0595, B:234:0x0599, B:236:0x05a3, B:238:0x05a7, B:239:0x05ae, B:241:0x05b2, B:242:0x05b8, B:244:0x05bc), top: B:397:0x0570 }] */
    /* JADX WARN: Code duplicated, block: B:242:0x05b8 A[Catch: all -> 0x05c4, TryCatch #18 {all -> 0x05c4, blocks: (B:228:0x0570, B:230:0x057f, B:232:0x0595, B:234:0x0599, B:236:0x05a3, B:238:0x05a7, B:239:0x05ae, B:241:0x05b2, B:242:0x05b8, B:244:0x05bc), top: B:397:0x0570 }] */
    /* JADX WARN: Code duplicated, block: B:244:0x05bc A[Catch: all -> 0x05c4, TRY_LEAVE, TryCatch #18 {all -> 0x05c4, blocks: (B:228:0x0570, B:230:0x057f, B:232:0x0595, B:234:0x0599, B:236:0x05a3, B:238:0x05a7, B:239:0x05ae, B:241:0x05b2, B:242:0x05b8, B:244:0x05bc), top: B:397:0x0570 }] */
    /* JADX WARN: Code duplicated, block: B:250:0x05d7 A[Catch: all -> 0x0633, TryCatch #11 {all -> 0x0633, blocks: (B:248:0x05c8, B:250:0x05d7, B:252:0x05ed, B:254:0x05f1, B:256:0x05fb, B:258:0x05ff, B:259:0x0606, B:261:0x060a, B:267:0x0623, B:268:0x0627, B:270:0x062b, B:262:0x0611, B:264:0x0617), top: B:385:0x05c8, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:252:0x05ed A[Catch: all -> 0x0633, TryCatch #11 {all -> 0x0633, blocks: (B:248:0x05c8, B:250:0x05d7, B:252:0x05ed, B:254:0x05f1, B:256:0x05fb, B:258:0x05ff, B:259:0x0606, B:261:0x060a, B:267:0x0623, B:268:0x0627, B:270:0x062b, B:262:0x0611, B:264:0x0617), top: B:385:0x05c8, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:254:0x05f1 A[Catch: all -> 0x0633, TryCatch #11 {all -> 0x0633, blocks: (B:248:0x05c8, B:250:0x05d7, B:252:0x05ed, B:254:0x05f1, B:256:0x05fb, B:258:0x05ff, B:259:0x0606, B:261:0x060a, B:267:0x0623, B:268:0x0627, B:270:0x062b, B:262:0x0611, B:264:0x0617), top: B:385:0x05c8, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:255:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:256:0x05fb A[Catch: all -> 0x0633, TryCatch #11 {all -> 0x0633, blocks: (B:248:0x05c8, B:250:0x05d7, B:252:0x05ed, B:254:0x05f1, B:256:0x05fb, B:258:0x05ff, B:259:0x0606, B:261:0x060a, B:267:0x0623, B:268:0x0627, B:270:0x062b, B:262:0x0611, B:264:0x0617), top: B:385:0x05c8, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:258:0x05ff A[Catch: all -> 0x0633, TryCatch #11 {all -> 0x0633, blocks: (B:248:0x05c8, B:250:0x05d7, B:252:0x05ed, B:254:0x05f1, B:256:0x05fb, B:258:0x05ff, B:259:0x0606, B:261:0x060a, B:267:0x0623, B:268:0x0627, B:270:0x062b, B:262:0x0611, B:264:0x0617), top: B:385:0x05c8, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:261:0x060a A[Catch: all -> 0x0633, TRY_LEAVE, TryCatch #11 {all -> 0x0633, blocks: (B:248:0x05c8, B:250:0x05d7, B:252:0x05ed, B:254:0x05f1, B:256:0x05fb, B:258:0x05ff, B:259:0x0606, B:261:0x060a, B:267:0x0623, B:268:0x0627, B:270:0x062b, B:262:0x0611, B:264:0x0617), top: B:385:0x05c8, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:264:0x0617 A[Catch: all -> 0x0622, TRY_LEAVE, TryCatch #3 {all -> 0x0622, blocks: (B:262:0x0611, B:264:0x0617), top: B:372:0x0611, outer: #11 }] */
    /* JADX WARN: Code duplicated, block: B:268:0x0627 A[Catch: all -> 0x0633, TryCatch #11 {all -> 0x0633, blocks: (B:248:0x05c8, B:250:0x05d7, B:252:0x05ed, B:254:0x05f1, B:256:0x05fb, B:258:0x05ff, B:259:0x0606, B:261:0x060a, B:267:0x0623, B:268:0x0627, B:270:0x062b, B:262:0x0611, B:264:0x0617), top: B:385:0x05c8, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:270:0x062b A[Catch: all -> 0x0633, TRY_LEAVE, TryCatch #11 {all -> 0x0633, blocks: (B:248:0x05c8, B:250:0x05d7, B:252:0x05ed, B:254:0x05f1, B:256:0x05fb, B:258:0x05ff, B:259:0x0606, B:261:0x060a, B:267:0x0623, B:268:0x0627, B:270:0x062b, B:262:0x0611, B:264:0x0617), top: B:385:0x05c8, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:276:0x0646 A[Catch: all -> 0x06a2, TryCatch #4 {all -> 0x06a2, blocks: (B:274:0x0637, B:276:0x0646, B:278:0x065c, B:280:0x0660, B:282:0x066a, B:284:0x066e, B:285:0x0675, B:287:0x0679, B:293:0x0692, B:294:0x0696, B:296:0x069a, B:288:0x0680, B:290:0x0686), top: B:374:0x0637, inners: #25 }] */
    /* JADX WARN: Code duplicated, block: B:278:0x065c A[Catch: all -> 0x06a2, TryCatch #4 {all -> 0x06a2, blocks: (B:274:0x0637, B:276:0x0646, B:278:0x065c, B:280:0x0660, B:282:0x066a, B:284:0x066e, B:285:0x0675, B:287:0x0679, B:293:0x0692, B:294:0x0696, B:296:0x069a, B:288:0x0680, B:290:0x0686), top: B:374:0x0637, inners: #25 }] */
    /* JADX WARN: Code duplicated, block: B:280:0x0660 A[Catch: all -> 0x06a2, TryCatch #4 {all -> 0x06a2, blocks: (B:274:0x0637, B:276:0x0646, B:278:0x065c, B:280:0x0660, B:282:0x066a, B:284:0x066e, B:285:0x0675, B:287:0x0679, B:293:0x0692, B:294:0x0696, B:296:0x069a, B:288:0x0680, B:290:0x0686), top: B:374:0x0637, inners: #25 }] */
    /* JADX WARN: Code duplicated, block: B:281:0x0668  */
    /* JADX WARN: Code duplicated, block: B:282:0x066a A[Catch: all -> 0x06a2, TryCatch #4 {all -> 0x06a2, blocks: (B:274:0x0637, B:276:0x0646, B:278:0x065c, B:280:0x0660, B:282:0x066a, B:284:0x066e, B:285:0x0675, B:287:0x0679, B:293:0x0692, B:294:0x0696, B:296:0x069a, B:288:0x0680, B:290:0x0686), top: B:374:0x0637, inners: #25 }] */
    /* JADX WARN: Code duplicated, block: B:284:0x066e A[Catch: all -> 0x06a2, TryCatch #4 {all -> 0x06a2, blocks: (B:274:0x0637, B:276:0x0646, B:278:0x065c, B:280:0x0660, B:282:0x066a, B:284:0x066e, B:285:0x0675, B:287:0x0679, B:293:0x0692, B:294:0x0696, B:296:0x069a, B:288:0x0680, B:290:0x0686), top: B:374:0x0637, inners: #25 }] */
    /* JADX WARN: Code duplicated, block: B:287:0x0679 A[Catch: all -> 0x06a2, TRY_LEAVE, TryCatch #4 {all -> 0x06a2, blocks: (B:274:0x0637, B:276:0x0646, B:278:0x065c, B:280:0x0660, B:282:0x066a, B:284:0x066e, B:285:0x0675, B:287:0x0679, B:293:0x0692, B:294:0x0696, B:296:0x069a, B:288:0x0680, B:290:0x0686), top: B:374:0x0637, inners: #25 }] */
    /* JADX WARN: Code duplicated, block: B:290:0x0686 A[Catch: all -> 0x0691, TRY_LEAVE, TryCatch #25 {all -> 0x0691, blocks: (B:288:0x0680, B:290:0x0686), top: B:407:0x0680, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:294:0x0696 A[Catch: all -> 0x06a2, TryCatch #4 {all -> 0x06a2, blocks: (B:274:0x0637, B:276:0x0646, B:278:0x065c, B:280:0x0660, B:282:0x066a, B:284:0x066e, B:285:0x0675, B:287:0x0679, B:293:0x0692, B:294:0x0696, B:296:0x069a, B:288:0x0680, B:290:0x0686), top: B:374:0x0637, inners: #25 }] */
    /* JADX WARN: Code duplicated, block: B:296:0x069a A[Catch: all -> 0x06a2, TRY_LEAVE, TryCatch #4 {all -> 0x06a2, blocks: (B:274:0x0637, B:276:0x0646, B:278:0x065c, B:280:0x0660, B:282:0x066a, B:284:0x066e, B:285:0x0675, B:287:0x0679, B:293:0x0692, B:294:0x0696, B:296:0x069a, B:288:0x0680, B:290:0x0686), top: B:374:0x0637, inners: #25 }] */
    /* JADX WARN: Code duplicated, block: B:302:0x06b5 A[Catch: all -> 0x0711, TryCatch #26 {all -> 0x0711, blocks: (B:300:0x06a6, B:302:0x06b5, B:304:0x06cb, B:306:0x06cf, B:308:0x06d9, B:310:0x06dd, B:311:0x06e4, B:313:0x06e8, B:319:0x0701, B:320:0x0705, B:322:0x0709, B:314:0x06ef, B:316:0x06f5), top: B:409:0x06a6, inners: #17 }] */
    /* JADX WARN: Code duplicated, block: B:304:0x06cb A[Catch: all -> 0x0711, TryCatch #26 {all -> 0x0711, blocks: (B:300:0x06a6, B:302:0x06b5, B:304:0x06cb, B:306:0x06cf, B:308:0x06d9, B:310:0x06dd, B:311:0x06e4, B:313:0x06e8, B:319:0x0701, B:320:0x0705, B:322:0x0709, B:314:0x06ef, B:316:0x06f5), top: B:409:0x06a6, inners: #17 }] */
    /* JADX WARN: Code duplicated, block: B:306:0x06cf A[Catch: all -> 0x0711, TryCatch #26 {all -> 0x0711, blocks: (B:300:0x06a6, B:302:0x06b5, B:304:0x06cb, B:306:0x06cf, B:308:0x06d9, B:310:0x06dd, B:311:0x06e4, B:313:0x06e8, B:319:0x0701, B:320:0x0705, B:322:0x0709, B:314:0x06ef, B:316:0x06f5), top: B:409:0x06a6, inners: #17 }] */
    /* JADX WARN: Code duplicated, block: B:307:0x06d7  */
    /* JADX WARN: Code duplicated, block: B:308:0x06d9 A[Catch: all -> 0x0711, TryCatch #26 {all -> 0x0711, blocks: (B:300:0x06a6, B:302:0x06b5, B:304:0x06cb, B:306:0x06cf, B:308:0x06d9, B:310:0x06dd, B:311:0x06e4, B:313:0x06e8, B:319:0x0701, B:320:0x0705, B:322:0x0709, B:314:0x06ef, B:316:0x06f5), top: B:409:0x06a6, inners: #17 }] */
    /* JADX WARN: Code duplicated, block: B:310:0x06dd A[Catch: all -> 0x0711, TryCatch #26 {all -> 0x0711, blocks: (B:300:0x06a6, B:302:0x06b5, B:304:0x06cb, B:306:0x06cf, B:308:0x06d9, B:310:0x06dd, B:311:0x06e4, B:313:0x06e8, B:319:0x0701, B:320:0x0705, B:322:0x0709, B:314:0x06ef, B:316:0x06f5), top: B:409:0x06a6, inners: #17 }] */
    /* JADX WARN: Code duplicated, block: B:313:0x06e8 A[Catch: all -> 0x0711, TRY_LEAVE, TryCatch #26 {all -> 0x0711, blocks: (B:300:0x06a6, B:302:0x06b5, B:304:0x06cb, B:306:0x06cf, B:308:0x06d9, B:310:0x06dd, B:311:0x06e4, B:313:0x06e8, B:319:0x0701, B:320:0x0705, B:322:0x0709, B:314:0x06ef, B:316:0x06f5), top: B:409:0x06a6, inners: #17 }] */
    /* JADX WARN: Code duplicated, block: B:316:0x06f5 A[Catch: all -> 0x0700, TRY_LEAVE, TryCatch #17 {all -> 0x0700, blocks: (B:314:0x06ef, B:316:0x06f5), top: B:395:0x06ef, outer: #26 }] */
    /* JADX WARN: Code duplicated, block: B:320:0x0705 A[Catch: all -> 0x0711, TryCatch #26 {all -> 0x0711, blocks: (B:300:0x06a6, B:302:0x06b5, B:304:0x06cb, B:306:0x06cf, B:308:0x06d9, B:310:0x06dd, B:311:0x06e4, B:313:0x06e8, B:319:0x0701, B:320:0x0705, B:322:0x0709, B:314:0x06ef, B:316:0x06f5), top: B:409:0x06a6, inners: #17 }] */
    /* JADX WARN: Code duplicated, block: B:322:0x0709 A[Catch: all -> 0x0711, TRY_LEAVE, TryCatch #26 {all -> 0x0711, blocks: (B:300:0x06a6, B:302:0x06b5, B:304:0x06cb, B:306:0x06cf, B:308:0x06d9, B:310:0x06dd, B:311:0x06e4, B:313:0x06e8, B:319:0x0701, B:320:0x0705, B:322:0x0709, B:314:0x06ef, B:316:0x06f5), top: B:409:0x06a6, inners: #17 }] */
    /* JADX WARN: Code duplicated, block: B:328:0x0724 A[Catch: all -> 0x0786, TryCatch #19 {all -> 0x0786, blocks: (B:326:0x0715, B:328:0x0724, B:330:0x073a, B:332:0x073e, B:334:0x0748, B:336:0x074c, B:337:0x0753, B:339:0x0757, B:345:0x0776, B:346:0x077a, B:348:0x077e, B:340:0x0764, B:342:0x076a), top: B:398:0x0715, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:330:0x073a A[Catch: all -> 0x0786, TryCatch #19 {all -> 0x0786, blocks: (B:326:0x0715, B:328:0x0724, B:330:0x073a, B:332:0x073e, B:334:0x0748, B:336:0x074c, B:337:0x0753, B:339:0x0757, B:345:0x0776, B:346:0x077a, B:348:0x077e, B:340:0x0764, B:342:0x076a), top: B:398:0x0715, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:332:0x073e A[Catch: all -> 0x0786, TryCatch #19 {all -> 0x0786, blocks: (B:326:0x0715, B:328:0x0724, B:330:0x073a, B:332:0x073e, B:334:0x0748, B:336:0x074c, B:337:0x0753, B:339:0x0757, B:345:0x0776, B:346:0x077a, B:348:0x077e, B:340:0x0764, B:342:0x076a), top: B:398:0x0715, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:333:0x0746  */
    /* JADX WARN: Code duplicated, block: B:334:0x0748 A[Catch: all -> 0x0786, TryCatch #19 {all -> 0x0786, blocks: (B:326:0x0715, B:328:0x0724, B:330:0x073a, B:332:0x073e, B:334:0x0748, B:336:0x074c, B:337:0x0753, B:339:0x0757, B:345:0x0776, B:346:0x077a, B:348:0x077e, B:340:0x0764, B:342:0x076a), top: B:398:0x0715, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:336:0x074c A[Catch: all -> 0x0786, TryCatch #19 {all -> 0x0786, blocks: (B:326:0x0715, B:328:0x0724, B:330:0x073a, B:332:0x073e, B:334:0x0748, B:336:0x074c, B:337:0x0753, B:339:0x0757, B:345:0x0776, B:346:0x077a, B:348:0x077e, B:340:0x0764, B:342:0x076a), top: B:398:0x0715, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:339:0x0757 A[Catch: all -> 0x0786, TRY_LEAVE, TryCatch #19 {all -> 0x0786, blocks: (B:326:0x0715, B:328:0x0724, B:330:0x073a, B:332:0x073e, B:334:0x0748, B:336:0x074c, B:337:0x0753, B:339:0x0757, B:345:0x0776, B:346:0x077a, B:348:0x077e, B:340:0x0764, B:342:0x076a), top: B:398:0x0715, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:342:0x076a A[Catch: all -> 0x0775, TRY_LEAVE, TryCatch #12 {all -> 0x0775, blocks: (B:340:0x0764, B:342:0x076a), top: B:386:0x0764, outer: #19 }] */
    /* JADX WARN: Code duplicated, block: B:346:0x077a A[Catch: all -> 0x0786, TryCatch #19 {all -> 0x0786, blocks: (B:326:0x0715, B:328:0x0724, B:330:0x073a, B:332:0x073e, B:334:0x0748, B:336:0x074c, B:337:0x0753, B:339:0x0757, B:345:0x0776, B:346:0x077a, B:348:0x077e, B:340:0x0764, B:342:0x076a), top: B:398:0x0715, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:348:0x077e A[Catch: all -> 0x0786, TRY_LEAVE, TryCatch #19 {all -> 0x0786, blocks: (B:326:0x0715, B:328:0x0724, B:330:0x073a, B:332:0x073e, B:334:0x0748, B:336:0x074c, B:337:0x0753, B:339:0x0757, B:345:0x0776, B:346:0x077a, B:348:0x077e, B:340:0x0764, B:342:0x076a), top: B:398:0x0715, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:354:0x079b A[Catch: all -> 0x07b2, TRY_LEAVE, TryCatch #10 {all -> 0x07b2, blocks: (B:352:0x078a, B:354:0x079b), top: B:383:0x078a }] */
    /* JADX WARN: Code duplicated, block: B:360:0x07ba  */
    /* JADX WARN: Code duplicated, block: B:420:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.content.SharedPreferences] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    public static void init(final Context context, final String str, String str2) {
        String str3;
        int innerConfig;
        int innerConfig2;
        int innerConfig3;
        int innerConfig4;
        int innerConfig5;
        int innerConfig6;
        String umid;
        int innerConfig7;
        String umid2;
        SharedPreferences sharedPreferences;
        String str4;
        String str5 = KEY_HEADER_CRASH_VERSION;
        ?? r6 = KEY_HEADER_OS;
        if (context == null || str == null) {
            Log.e(TAG, "context is null or appkey is null, init failed.");
            return;
        }
        Log.e(TAG, "==================可接入免费的网络分析能力!!!===================\n============================详情见============================\nhttps://developer.umeng.com/docs/193624/detail/194590#h2-n5n-d0l-fmj");
        mContext = context;
        try {
            WorkThreadUtil.submit(new Runnable() { // from class: com.umeng.umcrash.UMCrash.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ImprintHandler.getImprintService(UMCrash.mContext).registImprintCallback(UMCrashContent.KEY_APM_CTR_FLAG, new UMImprintChangeCallback() { // from class: com.umeng.umcrash.UMCrash.1.1
                            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                            public void onImprintValueChanged(String str6, String str7) {
                                try {
                                    if (TextUtils.isEmpty(str6) || !UMCrashContent.KEY_APM_CTR_FLAG.equals(str6)) {
                                        return;
                                    }
                                    if (UMCrash.isDebug) {
                                        Log.i(UMCrash.TAG, "common callback. apm ctr flag is " + str7);
                                    }
                                    UMCrashUtils.saveInnerConfig(context.getApplicationContext(), str6, str7);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        });
                        String strImprintProperty = UMEnvelopeBuild.imprintProperty(UMCrash.mContext, UMCrashContent.KEY_APM_CTR_FLAG, "0");
                        if (UMCrash.isDebug) {
                            Log.i(UMCrash.TAG, "get common. apm ctr flag is " + strImprintProperty);
                        }
                        if (strImprintProperty == null || TextUtils.isEmpty(strImprintProperty)) {
                            return;
                        }
                        UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.KEY_APM_CTR_FLAG, strImprintProperty);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            str3 = "";
            try {
                int innerConfig8 = UMCrashUtils.getInnerConfig(mContext, UMCrashContent.KEY_APM_CTR_FLAG, 0);
                if (isDebug) {
                    Log.i(TAG, "int apm. flag is " + innerConfig8);
                }
                if (innerConfig8 == -1) {
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            str3 = "";
        }
        try {
            int innerConfig9 = UMCrashUtils.getInnerConfig(mContext, UMCrashContent.APM_STATE_HIT_WL, 0);
            if (isDebug) {
                Log.i(TAG, "int apm. hitWlState is " + innerConfig9);
            }
            SamplingWhiteListUtil.setHitWL(innerConfig9 == 1);
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        SharedPreferences sharedPreferences2 = SharedPreferencesUtils.getSharedPreferences(context, INTEGRATIONTESTING_SP);
        try {
            initCrashState(context);
            Bundle bundle = new Bundle();
            bundle.putBoolean("mDebug", isDebug);
            bundle.putBoolean("mEncryptLog", isEncrypt);
            bundle.putBoolean("mZipLog", isZip);
            bundle.putBoolean("mEnableKillProcessAfterCrash", sIsKillProcessAfterCrash);
            bundle.putBoolean(KEY_ENABLE_CRASH_JAVA, enableUCJavaLog);
            bundle.putBoolean(KEY_ENABLE_CRASH_NATIVE, enableUCNativeLog);
            bundle.putBoolean(KEY_ENABLE_ANR, enableUCANRLog);
            if (sIsEnableLogBackup) {
                bundle.putBoolean("mBackupLogs", true);
                sharedPreferences = sharedPreferences2;
                try {
                    bundle.putString("mLogsBackupPathName", context.getApplicationInfo().dataDir + File.separator + "apm_backup_files");
                } catch (Throwable unused) {
                    str5 = str3;
                    r6 = sharedPreferences;
                    innerConfig7 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_CODE_LOG, -1);
                    if (isDebug) {
                        Log.i(TAG, "inner config : code log rate is " + innerConfig7);
                    }
                    if (innerConfig7 == 0) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : code log close.");
                        }
                    } else if (innerConfig7 == 100) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : code log open.");
                        }
                        if (enableCodeLog) {
                            if (TextUtils.isEmpty(ULogManager.getDeviceID())) {
                                umid2 = UMCrashUtils.getUMID(mContext);
                                if (isDebug) {
                                    Log.i(TAG, "inner config : code log set umid is " + umid2);
                                }
                                ULogManager.setDeviceID(umid2);
                            }
                            isCodeLog = true;
                        }
                    }
                    if (isDebug) {
                        Log.i(TAG, "enable codeLog is " + isCodeLog);
                    }
                    initReporter(context, str, str2);
                    String string = r6.getString("debugkey", str5);
                    if (r6.getLong("timestamp", 0L) - System.currentTimeMillis() < 0) {
                        r6.edit().clear().apply();
                        IntegrationTestingUtil.setIntegrationTestingInPeriod(false);
                    } else {
                        r6.edit().clear().apply();
                        IntegrationTestingUtil.setIntegrationTestingInPeriod(false);
                    }
                    if (enablePaLog) {
                        WorkThreadUtil.submit(new Runnable() { // from class: com.umeng.umcrash.UMCrash.4
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    PAFactory.Builder builder = new PAFactory.Builder(context.getApplicationContext(), new IEfsReporter() { // from class: com.umeng.umcrash.UMCrash.4.1
                                        @Override // com.efs.sdk.pa.config.IEfsReporter
                                        public EfsReporter getReporter() {
                                            return UMCrash.sReporter;
                                        }
                                    });
                                    builder.packageLevel(PackageLevel.RELEASE);
                                    builder.timeoutTime(UMCrash.paTimeoutTime);
                                    builder.setPaClient(new PaClientImpl());
                                    PAFactory pAFactoryBuild = builder.build();
                                    pAFactoryBuild.getPaInstance().start();
                                    boolean unused2 = UMCrash.isPA = pAFactoryBuild.getConfigManager().enableTracer();
                                } catch (Throwable th5) {
                                    th5.printStackTrace();
                                }
                            }
                        });
                    } else if (isDebug) {
                        Log.e(TAG, "enablePaLog is false");
                    }
                    if (enableLaunchLog) {
                        LaunchManager.init(context, sReporter);
                        try {
                            if (LaunchManager.getLaunchConfigManager() != null) {
                                isLa = LaunchManager.getLaunchConfigManager().enableTracer();
                            }
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                        umid = UMCrashUtils.getUMID(context);
                        if (umid != null) {
                            if (isDebug) {
                                Log.i(TAG, "begin register common callback.  key is umid.");
                            }
                            ImprintHandler.getImprintService(context).registImprintCallback(bv.g, new UMImprintChangeCallback() { // from class: com.umeng.umcrash.UMCrash.5
                                @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                                public void onImprintValueChanged(String str6, String str7) {
                                    if (UMCrash.isDebug) {
                                        Log.i(UMCrash.TAG, "common callback.  key is " + str6 + "; value is " + str7);
                                    }
                                    try {
                                        if (bv.g.equals(str6)) {
                                            LaunchManager.sendLaunchCache(context, str7);
                                            ImprintHandler.getImprintService(context).unregistImprintCallback(bv.g, this);
                                        }
                                    } catch (Throwable th6) {
                                        th6.printStackTrace();
                                    }
                                }
                            });
                        } else {
                            if (isDebug) {
                                Log.i(TAG, "begin register common callback.  key is umid.");
                            }
                            ImprintHandler.getImprintService(context).registImprintCallback(bv.g, new UMImprintChangeCallback() { // from class: com.umeng.umcrash.UMCrash.5
                                @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                                public void onImprintValueChanged(String str6, String str7) {
                                    if (UMCrash.isDebug) {
                                        Log.i(UMCrash.TAG, "common callback.  key is " + str6 + "; value is " + str7);
                                    }
                                    try {
                                        if (bv.g.equals(str6)) {
                                            LaunchManager.sendLaunchCache(context, str7);
                                            ImprintHandler.getImprintService(context).unregistImprintCallback(bv.g, this);
                                        }
                                    } catch (Throwable th6) {
                                        th6.printStackTrace();
                                    }
                                }
                            });
                        }
                    } else if (isDebug) {
                        Log.e(TAG, "enableLaunchLog is false");
                    }
                    if (enableMemLog) {
                        UMMemoryMonitor.get().start(context, sReporter);
                    } else if (isDebug) {
                        Log.e(TAG, "enableMemLog is false");
                    }
                    innerConfig6 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NET, -1);
                    if (isDebug) {
                        Log.i(TAG, "inner config : net rate is " + innerConfig6);
                    }
                    if (innerConfig6 == 0) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : net close.");
                        }
                    } else if (innerConfig6 == 100) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : net open.");
                        }
                        if (enableNetLog) {
                            NetManager.init(context, sReporter);
                            try {
                                if (NetManager.getNetConfigManager() != null) {
                                    isNet = NetManager.getNetConfigManager().enableTracer();
                                }
                            } catch (Throwable th6) {
                                th6.printStackTrace();
                            }
                        } else if (isDebug) {
                            Log.e(TAG, "enableNetLog is false");
                        }
                    }
                    innerConfig5 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NATIVE_H5, -1);
                    if (isDebug) {
                        Log.i(TAG, "inner config : nativeH5Rate is " + innerConfig5);
                    }
                    if (innerConfig5 == 0) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : h5 close.");
                        }
                    } else if (innerConfig5 == 100) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : h5 open.");
                        }
                        if (enableH5PageLog) {
                            H5Manager.init(context, sReporter);
                        } else if (isDebug) {
                            Log.e(TAG, "enableH5PageLog is false");
                        }
                    }
                    innerConfig4 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_PAGE, -1);
                    if (isDebug) {
                        Log.i(TAG, "inner config : page rate is " + innerConfig4);
                    }
                    if (innerConfig4 == 0) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : page close.");
                        }
                    } else if (innerConfig4 == 100) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : page open.");
                        }
                        if (enablePageLog) {
                            PageManger.init(mContext, sReporter);
                            try {
                                if (PageManger.getPageConfigManger() != null) {
                                    isPage = PageManger.getPageConfigManger().enableTracer();
                                }
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                            }
                        } else if (isDebug) {
                            Log.e(TAG, "enablePageLog is false");
                        }
                    }
                    innerConfig3 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_POWER, -1);
                    if (isDebug) {
                        Log.i(TAG, "inner config : power rate is " + innerConfig3);
                    }
                    if (innerConfig3 == 0) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : power close.");
                        }
                    } else if (innerConfig3 == 100) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : power open.");
                        }
                        if (enablePowerLog) {
                            PowerManager.init(mContext, sReporter);
                            try {
                                if (PowerManager.getPowerConfigManager() != null) {
                                    isPower = PowerManager.getPowerConfigManager().enableTracer();
                                }
                            } catch (Throwable th8) {
                                th8.printStackTrace();
                            }
                        } else if (isDebug) {
                            Log.e(TAG, "enablePowerLog is false");
                        }
                    }
                    innerConfig2 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_FLUTTER, -1);
                    if (isDebug) {
                        Log.i(TAG, "inner config : flutter rate is " + innerConfig2);
                    }
                    if (innerConfig2 == 0) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : flutter close.");
                        }
                    } else if (innerConfig2 == 100) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : flutter open.");
                        }
                        if (enableFlutterLog) {
                            FlutterManager.init(mContext, sReporter);
                            try {
                                if (FlutterManager.getFlutterConfigManager() != null) {
                                    isFlutter = FlutterManager.getFlutterConfigManager().isFlutterEnable();
                                }
                            } catch (Throwable th9) {
                                th9.printStackTrace();
                            }
                        } else if (isDebug) {
                            Log.e(TAG, "enableFlutterLog is false");
                        }
                    }
                    innerConfig = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_MEMLEAK, -1);
                    if (isDebug) {
                        Log.i(TAG, "inner config : memleak rate is " + innerConfig);
                    }
                    if (innerConfig == 0) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : memleak close.");
                        }
                    } else if (innerConfig == 100) {
                        if (isDebug) {
                            Log.i(TAG, "inner config : memleak open.");
                        }
                        if (enableMemLeakLog) {
                            MemLeakManager.init(mContext, sReporter, new MemLeakClientImpl());
                            try {
                                if (MemLeakManager.getMemLeakConfigManager() != null) {
                                    isMemLeak = MemLeakManager.getMemLeakConfigManager().enableTracer();
                                }
                            } catch (Throwable th10) {
                                th10.printStackTrace();
                            }
                        } else if (isDebug) {
                            Log.e(TAG, "enableMemLeakLog is false");
                        }
                    }
                    sApmCallbackLimit = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CALLBACK_LIMIT, -1);
                    if (isDebug) {
                        Log.i(TAG, "inner config : callback limit is " + sApmCallbackLimit);
                    }
                    if (isCodeLog) {
                        ULogManager.init(mContext, sReporter);
                    }
                }
            } else {
                sharedPreferences = sharedPreferences2;
            }
            if (isDebug) {
                Log.i(TAG, "enable : java is " + enableJavaLog + ", native is " + enableNativeLog + ", anr is " + enableANRLog);
            }
            bundle.putBoolean(KEY_ENABLE_CRASH_UNEXP, false);
            bundle.putBoolean("mIsInternational", isIntl);
            bundle.putBoolean("mDumpUserSolibBuildId", isBuildId);
            boolean z = isIntl;
            String str6 = UMCrashContent.UM_DOMAIN_APM_URL_INTL;
            if (z) {
                bundle.putString("mCrashLogUploadUrl", "https://errnewlogos.umeng.com/upload");
                bundle.putString("mCrashSDKAuthUrl", UMCrashContent.UM_DOMAIN_APM_URL_INTL);
                bundle.putString("mCrashRateUploadUrl", UMCrashContent.UM_DOMAIN_APM_URL_INTL);
                if (isDebug) {
                    Log.i(TAG, "crash log domain is https://errnewlogos.umeng.com");
                }
            } else {
                bundle.putString("mCrashLogUploadUrl", "https://errnewlog.umeng.com/upload");
                bundle.putString("mCrashSDKAuthUrl", UMCrashContent.UM_DOMAIN_APM_URL);
                bundle.putString("mCrashRateUploadUrl", UMCrashContent.UM_DOMAIN_APM_URL);
                if (isDebug) {
                    Log.i(TAG, "crash rate domain is https://errnewlog.umeng.com");
                }
            }
            final CrashApi crashApiCreateInstanceEx = CrashApi.createInstanceEx(context, str, isDebug, bundle, new CrashClientImpl());
            try {
                if (crashApiCreateInstanceEx != null) {
                    crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_APPKEY, str);
                    crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_CHANNEL, str2);
                    crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_OS, "android");
                    crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
                    String umid3 = UMCrashUtils.getUMID(context);
                    crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_UMID, umid3);
                    UCrash.addHeader(KEY_HEADER_APPKEY, str);
                    UCrash.addHeader(KEY_HEADER_CHANNEL, str2);
                    UCrash.addHeader(KEY_HEADER_OS, "android");
                    UCrash.addHeader(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
                    UCrash.addHeader(KEY_HEADER_UMID, umid3);
                    try {
                        String[] activeUser = UMCrashUtils.getActiveUser(context);
                        if (activeUser != null && activeUser.length == 2) {
                            crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_PUID, activeUser[1]);
                            String str7 = activeUser[0];
                            str4 = KEY_HEADER_PROVIDER;
                            try {
                                crashApiCreateInstanceEx.addHeaderInfo(str4, str7);
                                UCrash.addHeader(KEY_HEADER_PUID, activeUser[1]);
                                UCrash.addHeader(str4, activeUser[0]);
                            } catch (Throwable unused2) {
                                str5 = str3;
                                try {
                                    crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_PUID, str5);
                                    crashApiCreateInstanceEx.addHeaderInfo(str4, str5);
                                    UCrash.addHeader(KEY_HEADER_PUID, str5);
                                    UCrash.addHeader(str4, str5);
                                } catch (Throwable unused3) {
                                    r6 = sharedPreferences;
                                }
                            }
                        }
                        str5 = str3;
                    } catch (Throwable unused4) {
                        str4 = KEY_HEADER_PROVIDER;
                    }
                    UMAPMCustomController uMAPMCustomController = sUMAPMCustomController;
                    if (uMAPMCustomController != null && !uMAPMCustomController.isCanUseNetworkOperator()) {
                        crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_CARRIER, str5);
                        UCrash.addHeader(KEY_HEADER_CARRIER, str5);
                    } else {
                        crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
                        UCrash.addHeader(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
                    }
                    if (!TextUtils.isEmpty(userBver)) {
                        crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_BVER, userBver);
                        UCrash.addHeader(KEY_HEADER_BVER, userBver);
                    }
                    if (!TextUtils.isEmpty(userBsver)) {
                        crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_BSVER, userBsver);
                        UCrash.addHeader(KEY_HEADER_BSVER, userBsver);
                    }
                    if (!TextUtils.isEmpty(userBesrial)) {
                        crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_BESRIAL, userBesrial);
                        UCrash.addHeader(KEY_HEADER_BESRIAL, userBesrial);
                    }
                    try {
                        int networkTypeUmeng = NetworkUtil.getNetworkTypeUmeng(context);
                        crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_NETWORK_TYPE, str5 + networkTypeUmeng);
                        UCrash.addHeader(KEY_HEADER_NETWORK_TYPE, str5 + networkTypeUmeng);
                    } catch (Throwable th11) {
                        th11.printStackTrace();
                    }
                    try {
                        if (UMCrashUtils.isHarmony(context)) {
                            crashApiCreateInstanceEx.addHeaderInfo("others_OS", "harmony");
                            UCrash.addHeader("others_OS", "harmony");
                        } else {
                            crashApiCreateInstanceEx.addHeaderInfo("others_OS", "Android");
                            UCrash.addHeader("others_OS", "Android");
                        }
                    } catch (Throwable th12) {
                        th12.printStackTrace();
                    }
                    registerInfoCallback(crashApiCreateInstanceEx);
                    if (context instanceof Application) {
                        final SharedPreferences sharedPreferences3 = sharedPreferences;
                        ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.umcrash.UMCrash.2
                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityCreated(Activity activity, Bundle bundle2) {
                                Intent intent;
                                Uri data;
                                String scheme;
                                long j;
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_CREATED);
                                if (UMCrash.index != 0 || (intent = activity.getIntent()) == null || (data = intent.getData()) == null || (scheme = data.getScheme()) == null || scheme.isEmpty() || !scheme.contains("um." + str)) {
                                    return;
                                }
                                Set<String> queryParameterNames = data.getQueryParameterNames();
                                if (queryParameterNames.contains(UMCrash.IT_DEBUGKEY) && queryParameterNames.contains(UMCrash.IT_SENDAGING)) {
                                    String queryParameter = data.getQueryParameter(UMCrash.IT_DEBUGKEY);
                                    try {
                                        j = Long.parseLong(data.getQueryParameter(UMCrash.IT_SENDAGING));
                                    } catch (NumberFormatException unused5) {
                                        j = 0;
                                    }
                                    if (j < 0) {
                                        sharedPreferences3.edit().clear().apply();
                                        IntegrationTestingUtil.setIntegrationTestingInPeriod(false);
                                        return;
                                    }
                                    if (j > 6) {
                                        j = 6;
                                    }
                                    sharedPreferences3.edit().putString("debugkey", queryParameter).apply();
                                    sharedPreferences3.edit().putLong("timestamp", System.currentTimeMillis() + (j * 60 * 60 * 1000)).apply();
                                    UMCrashUtils.setIntegrationTesingParams(queryParameter);
                                    IntegrationTestingUtil.setIntegrationTestingInPeriod(true);
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityStarted(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_STARTED);
                                UMMemoryMonitor.get().onActivityStarted(activity);
                                PowerManager.onActivityStarted(activity);
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityResumed(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_RESUMED);
                                UMMemoryMonitor.get().onActivityResumed(activity);
                                PowerManager.onActivityResumed(activity);
                                UMCrash.access$1608();
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityPaused(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_PAUSED);
                                UMCrash.access$1610();
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityStopped(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_STOPPED);
                                UMMemoryMonitor.get().onActivityStopped(activity);
                                PowerManager.onActivityStopped(activity);
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityDestroyed(Activity activity) {
                                UMCrash.saveActivityState(activity.getClass().getName(), UMCrash.KEY_ACTIITY_ON_DESTROYED);
                            }
                        });
                        r6 = sharedPreferences3;
                    } else {
                        r6 = sharedPreferences;
                        Log.e(TAG, "context not instanceof application.");
                    }
                    try {
                        WorkThreadUtil.submit(new Runnable() { // from class: com.umeng.umcrash.UMCrash.3
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    String[] networkAccessMode = NetworkUtil.getNetworkAccessMode(context);
                                    if ("Wi-Fi".equals(networkAccessMode[0])) {
                                        crashApiCreateInstanceEx.addHeaderInfo(UMCrash.KEY_HEADER_ACCESS, NetworkUtil.NETWORK_TYPE_WIFI);
                                        UCrash.addHeader(UMCrash.KEY_HEADER_ACCESS, NetworkUtil.NETWORK_TYPE_WIFI);
                                    } else if ("2G/3G".equals(networkAccessMode[0])) {
                                        crashApiCreateInstanceEx.addHeaderInfo(UMCrash.KEY_HEADER_ACCESS, "2G/3G");
                                        UCrash.addHeader(UMCrash.KEY_HEADER_ACCESS, "2G/3G");
                                    } else {
                                        crashApiCreateInstanceEx.addHeaderInfo(UMCrash.KEY_HEADER_ACCESS, "unknow");
                                        UCrash.addHeader(UMCrash.KEY_HEADER_ACCESS, "unknow");
                                    }
                                    if ("".equals(networkAccessMode[1])) {
                                        return;
                                    }
                                    crashApiCreateInstanceEx.addHeaderInfo(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, networkAccessMode[1]);
                                    UCrash.addHeader(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, networkAccessMode[1]);
                                } catch (Throwable th13) {
                                    th13.printStackTrace();
                                }
                            }
                        });
                        r6 = r6;
                    } catch (Throwable th13) {
                        th13.printStackTrace();
                        r6 = r6;
                    }
                } else {
                    str5 = str3;
                    r6 = sharedPreferences;
                    Log.e(TAG, "create CrashAPI is null.");
                }
                UCrashConfig.Builder javaCrashRethrow = new UCrashConfig.Builder().setLogEnable(isDebug).setJavaCrashEnable(enableUMJavaLog).setNativeCrashEnable(enableUMNativeLog).setAnrEnable(enableUMANRLog).setAnrTraceHkEnable(enableUMAnrTrace).setCustomEnable(enableUMUserLog).setCustomUploadImmediately(isUploadNowUserCrash).setBackupEnable(sIsEnableLogBackup).setBackupDir(context.getApplicationInfo().dataDir + File.separator + "apm_backup_files").setJavaDumpAllThreads(sIsDumpAllStackTrace).setNativeDumpAllThreads(sIsDumpAllStackTrace).setJavaCrashRethrow(!sIsKillProcessAfterCrash);
                if (!isIntl) {
                    str6 = UMCrashContent.UM_DOMAIN_APM_URL;
                }
                UCrash.init(context, javaCrashRethrow.setUrl(str6.concat("/upload")).setCallback(new UCrashCallbackImpl()).build());
            } catch (Throwable unused5) {
            }
        } catch (Throwable unused6) {
            r6 = sharedPreferences2;
            str5 = str3;
        }
        try {
            innerConfig7 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_CODE_LOG, -1);
            if (isDebug) {
                Log.i(TAG, "inner config : code log rate is " + innerConfig7);
            }
            if (innerConfig7 == 0) {
                if (isDebug) {
                    Log.i(TAG, "inner config : code log close.");
                }
            } else if (innerConfig7 == 100) {
                if (isDebug) {
                    Log.i(TAG, "inner config : code log open.");
                }
                if (enableCodeLog) {
                    if (TextUtils.isEmpty(ULogManager.getDeviceID())) {
                        umid2 = UMCrashUtils.getUMID(mContext);
                        if (isDebug) {
                            Log.i(TAG, "inner config : code log set umid is " + umid2);
                        }
                        ULogManager.setDeviceID(umid2);
                    }
                    isCodeLog = true;
                }
            }
            if (isDebug) {
                Log.i(TAG, "enable codeLog is " + isCodeLog);
            }
        } catch (Throwable th14) {
            th14.printStackTrace();
        }
        try {
            initReporter(context, str, str2);
        } catch (Throwable th15) {
            th15.printStackTrace();
        }
        try {
            String string2 = r6.getString("debugkey", str5);
            if (r6.getLong("timestamp", 0L) - System.currentTimeMillis() < 0 && !TextUtils.isEmpty(string2)) {
                IntegrationTestingUtil.setIntegrationTestingInPeriod(true);
                UMCrashUtils.setIntegrationTesingParams(string2);
            } else {
                r6.edit().clear().apply();
                IntegrationTestingUtil.setIntegrationTestingInPeriod(false);
            }
        } catch (Throwable th16) {
            th16.printStackTrace();
        }
        try {
            if (enablePaLog) {
                WorkThreadUtil.submit(new Runnable() { // from class: com.umeng.umcrash.UMCrash.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            PAFactory.Builder builder = new PAFactory.Builder(context.getApplicationContext(), new IEfsReporter() { // from class: com.umeng.umcrash.UMCrash.4.1
                                @Override // com.efs.sdk.pa.config.IEfsReporter
                                public EfsReporter getReporter() {
                                    return UMCrash.sReporter;
                                }
                            });
                            builder.packageLevel(PackageLevel.RELEASE);
                            builder.timeoutTime(UMCrash.paTimeoutTime);
                            builder.setPaClient(new PaClientImpl());
                            PAFactory pAFactoryBuild = builder.build();
                            pAFactoryBuild.getPaInstance().start();
                            boolean unused7 = UMCrash.isPA = pAFactoryBuild.getConfigManager().enableTracer();
                        } catch (Throwable th17) {
                            th17.printStackTrace();
                        }
                    }
                });
            } else if (isDebug) {
                Log.e(TAG, "enablePaLog is false");
            }
        } catch (Throwable th17) {
            th17.printStackTrace();
        }
        try {
            if (enableLaunchLog) {
                LaunchManager.init(context, sReporter);
                if (LaunchManager.getLaunchConfigManager() != null) {
                    isLa = LaunchManager.getLaunchConfigManager().enableTracer();
                }
                umid = UMCrashUtils.getUMID(context);
                if (umid != null || TextUtils.isEmpty(umid)) {
                    if (isDebug) {
                        Log.i(TAG, "begin register common callback.  key is umid.");
                    }
                    ImprintHandler.getImprintService(context).registImprintCallback(bv.g, new UMImprintChangeCallback() { // from class: com.umeng.umcrash.UMCrash.5
                        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                        public void onImprintValueChanged(String str8, String str9) {
                            if (UMCrash.isDebug) {
                                Log.i(UMCrash.TAG, "common callback.  key is " + str8 + "; value is " + str9);
                            }
                            try {
                                if (bv.g.equals(str8)) {
                                    LaunchManager.sendLaunchCache(context, str9);
                                    ImprintHandler.getImprintService(context).unregistImprintCallback(bv.g, this);
                                }
                            } catch (Throwable th18) {
                                th18.printStackTrace();
                            }
                        }
                    });
                }
            } else if (isDebug) {
                Log.e(TAG, "enableLaunchLog is false");
            }
        } catch (Throwable th18) {
            th18.printStackTrace();
        }
        try {
            if (enableMemLog) {
                UMMemoryMonitor.get().start(context, sReporter);
            } else if (isDebug) {
                Log.e(TAG, "enableMemLog is false");
            }
        } catch (Throwable th19) {
            th19.printStackTrace();
        }
        try {
            innerConfig6 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NET, -1);
            if (isDebug) {
                Log.i(TAG, "inner config : net rate is " + innerConfig6);
            }
            if (innerConfig6 == 0) {
                if (isDebug) {
                    Log.i(TAG, "inner config : net close.");
                }
            } else if (innerConfig6 == 100) {
                if (isDebug) {
                    Log.i(TAG, "inner config : net open.");
                }
                if (enableNetLog) {
                    NetManager.init(context, sReporter);
                    if (NetManager.getNetConfigManager() != null) {
                        isNet = NetManager.getNetConfigManager().enableTracer();
                    }
                } else if (isDebug) {
                    Log.e(TAG, "enableNetLog is false");
                }
            }
        } catch (Throwable th20) {
            th20.printStackTrace();
        }
        try {
            innerConfig5 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NATIVE_H5, -1);
            if (isDebug) {
                Log.i(TAG, "inner config : nativeH5Rate is " + innerConfig5);
            }
            if (innerConfig5 == 0) {
                if (isDebug) {
                    Log.i(TAG, "inner config : h5 close.");
                }
            } else if (innerConfig5 == 100) {
                if (isDebug) {
                    Log.i(TAG, "inner config : h5 open.");
                }
                if (enableH5PageLog) {
                    H5Manager.init(context, sReporter);
                } else if (isDebug) {
                    Log.e(TAG, "enableH5PageLog is false");
                }
            }
        } catch (Throwable th21) {
            th21.printStackTrace();
        }
        try {
            innerConfig4 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_PAGE, -1);
            if (isDebug) {
                Log.i(TAG, "inner config : page rate is " + innerConfig4);
            }
            if (innerConfig4 == 0) {
                if (isDebug) {
                    Log.i(TAG, "inner config : page close.");
                }
            } else if (innerConfig4 == 100) {
                if (isDebug) {
                    Log.i(TAG, "inner config : page open.");
                }
                if (enablePageLog) {
                    PageManger.init(mContext, sReporter);
                    if (PageManger.getPageConfigManger() != null) {
                        isPage = PageManger.getPageConfigManger().enableTracer();
                    }
                } else if (isDebug) {
                    Log.e(TAG, "enablePageLog is false");
                }
            }
        } catch (Throwable th22) {
            th22.printStackTrace();
        }
        try {
            innerConfig3 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_POWER, -1);
            if (isDebug) {
                Log.i(TAG, "inner config : power rate is " + innerConfig3);
            }
            if (innerConfig3 == 0) {
                if (isDebug) {
                    Log.i(TAG, "inner config : power close.");
                }
            } else if (innerConfig3 == 100) {
                if (isDebug) {
                    Log.i(TAG, "inner config : power open.");
                }
                if (enablePowerLog) {
                    PowerManager.init(mContext, sReporter);
                    if (PowerManager.getPowerConfigManager() != null) {
                        isPower = PowerManager.getPowerConfigManager().enableTracer();
                    }
                } else if (isDebug) {
                    Log.e(TAG, "enablePowerLog is false");
                }
            }
        } catch (Throwable th23) {
            th23.printStackTrace();
        }
        try {
            innerConfig2 = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_FLUTTER, -1);
            if (isDebug) {
                Log.i(TAG, "inner config : flutter rate is " + innerConfig2);
            }
            if (innerConfig2 == 0) {
                if (isDebug) {
                    Log.i(TAG, "inner config : flutter close.");
                }
            } else if (innerConfig2 == 100) {
                if (isDebug) {
                    Log.i(TAG, "inner config : flutter open.");
                }
                if (enableFlutterLog) {
                    FlutterManager.init(mContext, sReporter);
                    if (FlutterManager.getFlutterConfigManager() != null) {
                        isFlutter = FlutterManager.getFlutterConfigManager().isFlutterEnable();
                    }
                } else if (isDebug) {
                    Log.e(TAG, "enableFlutterLog is false");
                }
            }
        } catch (Throwable th24) {
            th24.printStackTrace();
        }
        try {
            innerConfig = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_MEMLEAK, -1);
            if (isDebug) {
                Log.i(TAG, "inner config : memleak rate is " + innerConfig);
            }
            if (innerConfig == 0) {
                if (isDebug) {
                    Log.i(TAG, "inner config : memleak close.");
                }
            } else if (innerConfig == 100) {
                if (isDebug) {
                    Log.i(TAG, "inner config : memleak open.");
                }
                if (enableMemLeakLog) {
                    MemLeakManager.init(mContext, sReporter, new MemLeakClientImpl());
                    if (MemLeakManager.getMemLeakConfigManager() != null) {
                        isMemLeak = MemLeakManager.getMemLeakConfigManager().enableTracer();
                    }
                } else if (isDebug) {
                    Log.e(TAG, "enableMemLeakLog is false");
                }
            }
        } catch (Throwable th25) {
            th25.printStackTrace();
        }
        try {
            sApmCallbackLimit = UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CALLBACK_LIMIT, -1);
            if (isDebug) {
                Log.i(TAG, "inner config : callback limit is " + sApmCallbackLimit);
            }
        } catch (Throwable th26) {
            th26.printStackTrace();
        }
        if (isCodeLog) {
            ULogManager.init(mContext, sReporter);
        }
    }

    private static void initCrashState(Context context) {
        try {
            if (enableJavaLog) {
                boolean zRandom = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_JAVA_SAMPLING_RATE, 100));
                enableUMJavaLog = zRandom;
                if (!zRandom) {
                    enableUCJavaLog = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, 100));
                }
                enableJavaLog = enableUMJavaLog || enableUCJavaLog;
            } else {
                enableUMJavaLog = false;
                enableUCJavaLog = false;
            }
            if (enableNativeLog) {
                boolean zRandom2 = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_NATIVE_SAMPLING_RATE, 100));
                enableUMNativeLog = zRandom2;
                if (!zRandom2) {
                    enableUCNativeLog = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, 100));
                }
                enableNativeLog = enableUMNativeLog || enableUCNativeLog;
            } else {
                enableUMNativeLog = false;
                enableUCNativeLog = false;
            }
            if (enableANRLog) {
                boolean zRandom3 = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_ANR_SAMPLING_RATE, 100));
                enableUMANRLog = zRandom3;
                if (!zRandom3) {
                    enableUCANRLog = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, 100));
                }
                enableANRLog = enableUMANRLog || enableUCANRLog;
            } else {
                enableUMANRLog = false;
                enableUCANRLog = false;
            }
            boolean zRandom4 = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_USER_SAMPLING_RATE, 100));
            enableUMUserLog = zRandom4;
            if (!zRandom4) {
                enableUCUserLog = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, 100));
            }
            isOpenUserCrash = enableUMUserLog || enableUCUserLog;
            enableUMAnrTrace = UMCrashUtils.random(UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_ANR_TRACE_STATE, 100));
            if (UMCrashUtils.getInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, -1) == 0) {
                isUploadNowUserCrash = true;
            } else {
                isUploadNowUserCrash = false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void registerInfoCallback(CrashApi crashApi) {
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_JAVA, 16);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_NATIVE, 1);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_ANR, 1048576);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_CUSTOM_LOG, 256);
        crashApi.registerInfoCallback(KEY_CALLBACK_UM_INFOS, 1048593);
        crashApi.registerInfoCallback(KEY_CALLBACK_UMID, 1048593);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveActivityState(String str, String str2) {
        ArrayList<String> arrayList;
        try {
            UMAPMCustomController uMAPMCustomController = sUMAPMCustomController;
            if ((uMAPMCustomController == null || uMAPMCustomController.isCanUseUserOperationRecord()) && (arrayList = mArrayList) != null) {
                if (arrayList.size() >= 20) {
                    mArrayList.remove(0);
                }
                mArrayList.add(str + "-" + System.currentTimeMillis() + "-" + str2);
            }
        } catch (Throwable unused) {
        }
    }

    private static void initReporter(final Context context, String str, String str2) {
        HashMap map = new HashMap(1);
        map.put(KEY_HEADER_UMID, UMCrashUtils.getUMID(context));
        map.put(KEY_HEADER_CHANNEL, str2);
        UMAPMCustomController uMAPMCustomController = sUMAPMCustomController;
        if (uMAPMCustomController != null && !uMAPMCustomController.isCanUseNetworkOperator()) {
            map.put(KEY_HEADER_CARRIER, "");
        } else {
            map.put(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
        }
        map.put(KEY_HEADER_OS, "android");
        map.put(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
        try {
            String[] activeUser = UMCrashUtils.getActiveUser(context);
            if (activeUser != null && activeUser.length == 2) {
                map.put(KEY_HEADER_PUID, activeUser[1]);
                map.put(KEY_HEADER_PROVIDER, activeUser[0]);
            }
        } catch (Throwable unused) {
            map.put(KEY_HEADER_PUID, "");
            map.put(KEY_HEADER_PROVIDER, "");
        }
        if (!TextUtils.isEmpty(userBver)) {
            map.put(KEY_HEADER_BVER, userBver);
        }
        if (!TextUtils.isEmpty(userBsver)) {
            map.put(KEY_HEADER_BSVER, userBsver);
        }
        if (!TextUtils.isEmpty(userBesrial)) {
            map.put(KEY_HEADER_BESRIAL, userBesrial);
        }
        try {
            if (UMCrashUtils.isHarmony(context)) {
                map.put("others_OS", "harmony");
            } else {
                map.put("others_OS", "Android");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        EfsReporter efsReporterBuild = new EfsReporter.Builder(context.getApplicationContext(), str, KEY_APM_DEFAULT_SECRET).debug(isDebug).enablePaBackup(sIsEnableLogBackup).efsDirRootName(KEY_APM_ROOT_NAME).printLogDetail(isDebug).intl(isIntl).enableWaStat(false).logUid(ULogManager.getUserID()).logDid(ULogManager.getDeviceID()).setOpenCodeLog(isCodeLog).customController(sUMAPMCustomController).build();
        sReporter = efsReporterBuild;
        efsReporterBuild.addPublicParams(map);
        try {
            if (isCodeLog) {
                sReporter.setFileFilterCodeLog(new UploadFileFilterCodeLog());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            sReporter.getAllSdkConfig(new String[]{UMCrashContent.APM_STATE_CODE_LOG, UMCrashContent.APM_STATE_HIT_WL, UMCrashContent.APM_STATE_MEMLEAK, UMCrashContent.APM_STATE_FLUTTER, UMCrashContent.APM_STATE_POWER, UMCrashContent.APM_STATE_PAGE, UMCrashContent.APM_STATE_NET, UMCrashContent.APM_STATE_NATIVE_H5, UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, UMCrashContent.APM_CRASH_USER_MAX_COUNT, UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, UMCrashContent.APM_CALLBACK_LIMIT, UMCrashContent.APM_UM_CRASH_JAVA_SAMPLING_RATE, UMCrashContent.APM_UM_CRASH_NATIVE_SAMPLING_RATE, UMCrashContent.APM_UM_CRASH_ANR_SAMPLING_RATE, UMCrashContent.APM_UM_CRASH_USER_SAMPLING_RATE, UMCrashContent.APM_UM_CRASH_ANR_TRACE_STATE}, new IConfigCallback() { // from class: com.umeng.umcrash.UMCrash.6
                @Override // com.efs.sdk.base.observer.IConfigCallback
                public void onChange(Map<String, Object> map2) {
                    String str3;
                    try {
                        Object obj = map2.get(UMCrashContent.APM_STATE_NET);
                        if (obj != null) {
                            if (UMCrash.isDebug) {
                                str3 = "callback powerRate is ";
                                try {
                                    Log.i("efs.config", "callback netRate is " + obj.toString());
                                } catch (Throwable th3) {
                                    th = th3;
                                    th.printStackTrace();
                                }
                            } else {
                                str3 = "callback powerRate is ";
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NET, obj);
                        } else {
                            str3 = "callback powerRate is ";
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str3 = "callback powerRate is ";
                    }
                    try {
                        Object obj2 = map2.get(UMCrashContent.APM_STATE_NATIVE_H5);
                        if (obj2 != null) {
                            if (UMCrash.isDebug) {
                                Log.i("efs.config", "callback nativeH5Rate is " + obj2.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NATIVE_H5, obj2);
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    try {
                        UMCrash.saveLocalCrashSampling(context, map2);
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                    try {
                        UMCrash.updateLocalCrashConfig(context, map2);
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                    try {
                        Object obj3 = map2.get(UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE);
                        if (obj3 != null) {
                            if (UMCrash.isDebug) {
                                Log.i("efs.config", "callback uploadType is " + obj3.toString());
                            }
                            if (Integer.valueOf(obj3.toString()).intValue() == 0) {
                                boolean unused2 = UMCrash.isUploadNowUserCrash = true;
                            } else {
                                boolean unused3 = UMCrash.isUploadNowUserCrash = false;
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, obj3);
                        }
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                    try {
                        Object obj4 = map2.get(UMCrashContent.APM_STATE_PAGE);
                        if (obj4 != null) {
                            if (UMCrash.isDebug) {
                                Log.i("efs.config", "callback pageRate is " + obj4.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_PAGE, obj4);
                        }
                    } catch (Throwable th9) {
                        th9.printStackTrace();
                    }
                    try {
                        Object obj5 = map2.get(UMCrashContent.APM_STATE_CODE_LOG);
                        if (obj5 != null) {
                            if (UMCrash.isDebug) {
                                Log.i("efs.config", "callback codeLogRate is " + obj5.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_CODE_LOG, obj5);
                        }
                    } catch (Throwable th10) {
                        th10.printStackTrace();
                    }
                    try {
                        Object obj6 = map2.get(UMCrashContent.APM_STATE_POWER);
                        if (obj6 != null) {
                            if (UMCrash.isDebug) {
                                Log.i("efs.config", str3 + obj6);
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_POWER, obj6);
                        }
                    } catch (Throwable th11) {
                        th11.printStackTrace();
                    }
                    try {
                        Object obj7 = map2.get(UMCrashContent.APM_STATE_HIT_WL);
                        if (obj7 != null) {
                            if (UMCrash.isDebug) {
                                Log.i("efs.config", "callback hitwl is " + obj7);
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_HIT_WL, obj7);
                        }
                    } catch (Throwable th12) {
                        th12.printStackTrace();
                    }
                    try {
                        Object obj8 = map2.get(UMCrashContent.APM_STATE_FLUTTER);
                        if (obj8 != null) {
                            if (UMCrash.isDebug) {
                                Log.i("efs.config", "callback flutterRate is " + obj8);
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_FLUTTER, obj8);
                        }
                    } catch (Throwable th13) {
                        th13.printStackTrace();
                    }
                    try {
                        Object obj9 = map2.get(UMCrashContent.APM_STATE_MEMLEAK);
                        if (obj9 != null) {
                            if (UMCrash.isDebug) {
                                Log.i("efs.config", "callback memLeakRate is " + obj9);
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_MEMLEAK, obj9);
                        }
                    } catch (Throwable th14) {
                        th14.printStackTrace();
                    }
                    try {
                        Object obj10 = map2.get(UMCrashContent.APM_CALLBACK_LIMIT);
                        if (obj10 != null) {
                            if (UMCrash.isDebug) {
                                Log.i("efs.config", "callback callbackLimit is " + obj10);
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CALLBACK_LIMIT, obj10);
                        }
                    } catch (Throwable th15) {
                        th15.printStackTrace();
                    }
                }
            });
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveLocalCrashSampling(Context context, Map<String, Object> map) {
        if (context == null || map == null) {
            return;
        }
        Object obj = map.get(UMCrashContent.APM_UM_CRASH_JAVA_SAMPLING_RATE);
        if (obj != null) {
            if (isDebug) {
                Log.i("efs.config", "callback umCrashJavaSampling is " + obj);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_JAVA_SAMPLING_RATE, obj);
        }
        Object obj2 = map.get(UMCrashContent.APM_UM_CRASH_NATIVE_SAMPLING_RATE);
        if (obj2 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback umCrashNativeSampling is " + obj2);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_NATIVE_SAMPLING_RATE, obj2);
        }
        Object obj3 = map.get(UMCrashContent.APM_UM_CRASH_ANR_SAMPLING_RATE);
        if (obj3 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback umCrashANRSampling is " + obj3);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_ANR_SAMPLING_RATE, obj3);
        }
        Object obj4 = map.get(UMCrashContent.APM_UM_CRASH_USER_SAMPLING_RATE);
        if (obj4 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback umCrashUserSampling is " + obj4);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_USER_SAMPLING_RATE, obj4);
        }
        Object obj5 = map.get(UMCrashContent.APM_UM_CRASH_ANR_TRACE_STATE);
        if (obj5 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback umCrashANRTraceSampling is " + obj5);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_ANR_TRACE_STATE, obj5);
        }
        Object obj6 = map.get(UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE);
        if (obj6 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback ucCrashJavaSampling is " + obj6);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, obj6);
        }
        Object obj7 = map.get(UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE);
        if (obj7 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback ucCrashNativeSampling is " + obj7);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, obj7);
        }
        Object obj8 = map.get(UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE);
        if (obj8 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback ucCrashANRSampling is " + obj8);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, obj8);
        }
        Object obj9 = map.get(UMCrashContent.APM_CRASH_USER_SAMPLING_RATE);
        if (obj9 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback ucCrashUserSampling is " + obj9);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, obj9);
        }
    }

    private static void updateLocalCrashSampling(Object obj, Object obj2, Object obj3, Object obj4) {
        CrashApi crashApi = CrashApi.getInstance();
        if (crashApi != null) {
            if (obj != null && UMCrashUtils.random(Integer.valueOf(obj.toString()).intValue())) {
                crashApi.disableLog(16);
            }
            if (obj2 != null && UMCrashUtils.random(Integer.valueOf(obj2.toString()).intValue())) {
                crashApi.disableLog(1);
            }
            if (obj3 != null && UMCrashUtils.random(Integer.valueOf(obj3.toString()).intValue())) {
                crashApi.disableLog(1048576);
            }
            if (obj4 == null || !UMCrashUtils.random(Integer.valueOf(obj4.toString()).intValue())) {
                return;
            }
            isOpenUserCrash = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateLocalCrashConfig(Context context, Map<String, Object> map) {
        if (context == null || map == null) {
            return;
        }
        Bundle bundle = new Bundle();
        Object obj = map.get(UMCrashContent.APM_CRASH_USER_MAX_COUNT);
        if (obj != null) {
            if (isDebug) {
                Log.i("efs.config", "callback crashMaxUserCount is " + obj.toString());
            }
            bundle.putInt("mMaxCustomLogCountPerTypePerDay", Integer.valueOf(obj.toString()).intValue());
            bundle.putInt("mMaxUploadCustomLogCountPerDay", Integer.valueOf(obj.toString()).intValue());
            UCrash.updateCustomLogLimit(Integer.valueOf(obj.toString()).intValue(), Integer.valueOf(obj.toString()).intValue());
        }
        CrashApi.getInstance().updateCustomInfo(bundle);
    }

    public static void registerUMCrashCallback(UMCrashCallback uMCrashCallback) {
        if (uMCrashCallback != null) {
            mUMCrashCallback = uMCrashCallback;
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

    public static void registerUMCrashCallback(IUMCrashCallbackWithType iUMCrashCallbackWithType) {
        if (iUMCrashCallbackWithType != null) {
            mUMCrashCallbackWithType = iUMCrashCallbackWithType;
        } else {
            Log.e(TAG, "callback error.");
        }
    }

    public static void registerPerfCallback(IUMPerfCallback iUMPerfCallback) {
        EfsReporter.registerPerfCallback(iUMPerfCallback);
    }

    public static void generateCustomLog(Throwable th, String str) {
        generateCustomLog(th, str, false, false);
    }

    public static void generateCustomLog(Throwable th, String str, boolean z, boolean z2) {
        generateCustomLog(th, str, (String) null, z, z2);
    }

    public static void generateCustomLog(Throwable th, String str, String str2, boolean z, boolean z2) {
        UAPMCustomException.generateCustomLog(enableUMUserLog, enableUCUserLog, isUploadNowUserCrash, th, str, str2, z, z2);
    }

    public static void generateCustomLog(String str, String str2) {
        generateCustomLog(str, str2, false, false);
    }

    public static void generateCustomLog(String str, String str2, boolean z, boolean z2) {
        generateCustomLog(str, str2, (String) null, z, z2);
    }

    public static void generateCustomLog(String str, String str2, String str3, boolean z, boolean z2) {
        UAPMCustomException.generateCustomLog(enableUMUserLog, enableUCUserLog, isUploadNowUserCrash, str, str2, str3, z, z2);
    }

    public static void enableLogBackup(boolean z) {
        sIsEnableLogBackup = z;
    }

    public static void enableDumpAllStackTrace(boolean z) {
        sIsDumpAllStackTrace = z;
    }

    public static void addCustomInfo(String str, String str2) {
        UAPMCustomInfo.addCustomInfo(str, str2);
    }

    public static void reRegisterAnrHandler() {
        if (enableUMANRLog) {
            UCrash.reRegisterAnrHandler();
        }
    }
}
