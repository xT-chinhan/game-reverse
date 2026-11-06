package com.tapsdk.tapad.internal.runtime;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import com.byazt.ol.TTDownloadField;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.mar.sdk.utils.SecurityUtil;
import com.tapsdk.tapad.TapAdCustomController;
import com.tapsdk.tapad.internal.oaid.OaidHelper;
import com.tapsdk.tapad.internal.runtime.download.ApkNotificationReceiver;
import com.tapsdk.tapad.internal.utils.AdnDeviceManager;
import com.tapsdk.tapad.internal.utils.AndroidUserAgent;
import com.tapsdk.tapad.internal.utils.FinstallIdManager;
import com.tapsdk.tapad.internal.utils.GUIDHelper;
import com.tapsdk.tapad.internal.utils.NetworkUtils;
import com.tapsdk.tapad.internal.utils.WXUtil;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.cc;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.UByte;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidDeviceFacts {
    private static volatile String cachedAppSha1;
    private static final PrivacyFactCache<String> androidIdCache = new PrivacyFactCache<>();
    private static final PrivacyFactCache<Integer> wxCache = new PrivacyFactCache<>();

    private AndroidDeviceFacts() {
    }

    private static String adnDid(Context context) {
        try {
            return safe(AdnDeviceManager.getInstance(context).getAdnDid());
        } catch (Throwable th) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x000d  */
    private static boolean allowsAndroidId(TapAdCustomController tapAdCustomController) {
        boolean z;
        if (tapAdCustomController != null) {
            try {
                if (tapAdCustomController.isCanUseAndroidId()) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                return false;
            }
        } else {
            z = false;
        }
        return AndroidPrivacyPolicy.allowsAndroidId(z);
    }

    private static boolean allowsPhoneState(TapAdCustomController tapAdCustomController) {
        if (tapAdCustomController != null) {
            try {
                if (tapAdCustomController.isCanUsePhoneState()) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        return false;
    }

    private static boolean allowsSerial(Context context, boolean z) {
        if (z && context != null) {
            try {
                return context.checkCallingOrSelfPermission(Build.VERSION.SDK_INT >= 29 ? "android.permission.READ_PRIVILEGED_PHONE_STATE" : "android.permission.READ_PHONE_STATE") == 0;
            } catch (Throwable th) {
            }
        }
        return false;
    }

    private static String appSha1(Context context) {
        String str = cachedAppSha1;
        if (str != null) {
            return str;
        }
        synchronized (AndroidDeviceFacts.class) {
            String str2 = cachedAppSha1;
            if (str2 != null) {
                return str2;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
                Signature[] signatureArr = packageInfo == null ? null : packageInfo.signatures;
                if (signatureArr != null && signatureArr.length != 0) {
                    byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                    StringBuilder sb = new StringBuilder((bArrDigest.length * 3) - 1);
                    for (int i = 0; i < bArrDigest.length; i++) {
                        if (i > 0) {
                            sb.append(AbstractJsonLexerKt.COLON);
                        }
                        byte b = bArrDigest[i];
                        sb.append(SecurityUtil.BASE_TABLE.charAt((b & UByte.MAX_VALUE) >>> 4));
                        sb.append(SecurityUtil.BASE_TABLE.charAt(b & cc.m));
                    }
                    cachedAppSha1 = sb.toString();
                    return cachedAppSha1;
                }
                cachedAppSha1 = "";
                return "";
            } catch (Throwable th) {
                cachedAppSha1 = "";
                return "";
            }
        }
    }

    public static String bootMark(long j, long j2) {
        return (j2 < 0 || j <= j2) ? "" : String.valueOf(j - j2);
    }

    private static String bounded(String str) {
        String strSafe = safe(str);
        return strSafe.length() <= 40 ? strSafe : strSafe.substring(0, 40);
    }

    private static String cachedAndroidId(Context context, boolean z) {
        if (!AndroidPrivacyPolicy.allowsAndroidId(z) || context == null) {
            return "";
        }
        try {
            return safe(AdnDeviceManager.getInstance(context).getAndroidId());
        } catch (Throwable th) {
            return "";
        }
    }

    private static String cachedSerial(Context context, boolean z) {
        return !allowsSerial(context, z) ? "" : AdnDeviceManager.getInstance(context).getSerial();
    }

    public static JSONObject collectAdRequestIdentifiers(Context context, TapAdCustomController tapAdCustomController) {
        Context applicationContext = context == null ? null : context.getApplicationContext();
        JSONObject jSONObject = new JSONObject();
        if (applicationContext != null) {
            try {
                jSONObject.put(Common.Predefined.SUB_ANDROID_ID, refreshAdRequestIdentifierCache(applicationContext, tapAdCustomController)).put("serial", refreshSerial(applicationContext, allowsPhoneState(tapAdCustomController))).put("oaid", oaid()).put("oaid_manufacturer", oaidManufacturer());
                return jSONObject;
            } catch (Throwable th) {
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Throwable] */
    public static JSONObject collectAdnBootstrapFacts(Context context) {
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext == null) {
            return new JSONObject();
        }
        long[] jArrDiskSize = diskSize();
        long[] jArrMemorySize = memorySize(applicationContext);
        try {
            JSONObject jSONObjectPut = new JSONObject().put("model", bounded(Build.MODEL));
            String str = Build.MANUFACTURER;
            JSONObject jSONObjectPut2 = jSONObjectPut.put("brand", bounded(str)).put(Common.Predefined.SUB_OS_TYPE, 1).put(an.y, safe(Build.VERSION.RELEASE, "unknown")).put("fingerprint", safe(Build.FINGERPRINT)).put("product", safe(Build.PRODUCT)).put("manufacturer", safe(str)).put(an.J, safe(Build.DEVICE)).put("hardware", safe(Build.HARDWARE)).put("board", safe(Build.BOARD)).put("supported_abis", Arrays.toString(Build.SUPPORTED_ABIS));
            long j = Build.TIME;
            return jSONObjectPut2.put("build_time", j).put("boot_mark", bootMark(System.currentTimeMillis(), SystemClock.elapsedRealtime())).put("update_mark", systemUpdateMark(new File("/system/build.prop"), j)).put("android_api_version", Build.VERSION.SDK_INT).put("cpu_count", cpuCount()).put("system_disk_size", jArrDiskSize[1]).put("system_memory_size", jArrMemorySize[0]).put("package_name", packageName(applicationContext)).put("app_version", versionName(applicationContext)).put("app_sha1", appSha1(applicationContext)).put(ContentProviderManager.PLUGIN_PROCESS_NAME, processName(applicationContext)).put("runtime_environment", isSandbox() ? 1 : 0).put("sdk_version_code", 50300001).put("sdk_version_name", safe("5.3.0.1"));
        } catch (Throwable th) {
            return new JSONObject();
        }
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Throwable] */
    public static JSONObject collectAdnBootstrapRequestFacts(Context context, TapAdCustomController tapAdCustomController) {
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext == null) {
            return new JSONObject();
        }
        boolean zAllowsAndroidId = allowsAndroidId(tapAdCustomController);
        boolean zAllowsPhoneState = allowsPhoneState(tapAdCustomController);
        OaidHelper.getInstance().setGaidCollectionAllowed(zAllowsPhoneState);
        int[] iArrScreenSize = screenSize(applicationContext);
        long[] jArrDiskSize = diskSize();
        long[] jArrMemorySize = memorySize(applicationContext);
        Locale locale = Locale.getDefault();
        try {
            return new JSONObject().put("schema_version", 1).put("screen_width", iArrScreenSize[0]).put("screen_height", iArrScreenSize[1]).put(an.ai, isPad(applicationContext) ? 2 : 1).put("system_available_size", jArrDiskSize[0]).put("system_memory_available_size", jArrMemorySize[1]).put(Common.Predefined.SUB_ANDROID_ID, cachedAndroidId(applicationContext, zAllowsAndroidId)).put("serial", cachedSerial(applicationContext, zAllowsPhoneState)).put("imei", "").put("oaid", oaid()).put("oaid_manufacturer", oaidManufacturer()).put("connect_type", NetworkUtils.getNetworkType(applicationContext, zAllowsPhoneState)).put("runtime_environment", isSandbox() ? 1 : 0).put(an.O, safe(locale.getCountry())).put("language", safe(locale.getLanguage())).put("time_zone", safe(TimeZone.getDefault().getID())).put("browser_user_agent", safe(AndroidUserAgent.browserUserAgent())).put("adn_did", adnDid(applicationContext)).put("app_install_id", installId(applicationContext)).put("tap_open_id", tapOpenId(applicationContext)).put("local_adn_id", localAdnId(applicationContext)).put("wx_installed_state", 0).put("can_use_location", false).put("media_enable_installed_packages", false);
        } catch (Throwable th) {
            return new JSONObject();
        }
    }

    public static JSONObject collectAdnRequestFacts(final Context context, TapAdCustomController tapAdCustomController) {
        JSONObject jSONObjectCollectAdRequestIdentifiers = collectAdRequestIdentifiers(context, tapAdCustomController);
        JSONObject jSONObjectCollectAdnBootstrapRequestFacts = collectAdnBootstrapRequestFacts(context, tapAdCustomController);
        if (context != null) {
            try {
                String[] strArr = {Common.Predefined.SUB_ANDROID_ID, "serial", "oaid", "oaid_manufacturer"};
                for (int i = 0; i < 4; i++) {
                    String str = strArr[i];
                    jSONObjectCollectAdnBootstrapRequestFacts.put(str, jSONObjectCollectAdRequestIdentifiers.optString(str, ""));
                }
                boolean zAllowsInstalledApps = AndroidPrivacyPolicy.allowsInstalledApps();
                jSONObjectCollectAdnBootstrapRequestFacts.put("can_use_location", AndroidPrivacyPolicy.allowsLocation()).put("media_enable_installed_packages", zAllowsInstalledApps);
                if (zAllowsInstalledApps) {
                    Integer num = wxCache.read(new PrivacyFactCache.Permission() { // from class: com.tapsdk.tapad.internal.runtime.AndroidDeviceFacts$$ExternalSyntheticLambda2
                        @Override // com.tapsdk.tapad.internal.runtime.PrivacyFactCache.Permission
                        public final boolean allowed() {
                            return AndroidPrivacyPolicy.allowsInstalledApps();
                        }
                    }, AndroidPrivacyPolicy.collectionIntervalMs(), new PrivacyFactCache.Probe() { // from class: com.tapsdk.tapad.internal.runtime.AndroidDeviceFacts$$ExternalSyntheticLambda3
                        @Override // com.tapsdk.tapad.internal.runtime.PrivacyFactCache.Probe
                        public final Object read() {
                            return Integer.valueOf(AndroidDeviceFacts.wxInstalledState(context));
                        }
                    });
                    jSONObjectCollectAdnBootstrapRequestFacts.put("wx_installed_state", num != null ? num.intValue() : 0);
                    return jSONObjectCollectAdnBootstrapRequestFacts;
                }
            } catch (Throwable th) {
            }
        }
        return jSONObjectCollectAdnBootstrapRequestFacts;
    }

    public static JSONObject collectInitialization(Context context, boolean z, boolean z2) {
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext == null) {
            return new JSONObject();
        }
        JSONObject jSONObjectCollectStable = collectStable(applicationContext);
        OaidHelper.getInstance().setGaidCollectionAllowed(z2);
        try {
            return jSONObjectCollectStable.put(Common.Predefined.SUB_ANDROID_ID, cachedAndroidId(applicationContext, z)).put("serial", cachedSerial(applicationContext, z2)).put("oaid", oaid()).put("oaid_manufacturer", oaidManufacturer());
        } catch (Throwable th) {
            return jSONObjectCollectStable;
        }
    }

    public static JSONObject collectStable(Context context) {
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext == null) {
            return new JSONObject();
        }
        JSONObject jSONObjectCollectAdnBootstrapFacts = collectAdnBootstrapFacts(applicationContext);
        int[] iArrScreenSize = screenSize(applicationContext);
        long[] jArrDiskSize = diskSize();
        long[] jArrMemorySize = memorySize(applicationContext);
        Locale locale = Locale.getDefault();
        try {
            return jSONObjectCollectAdnBootstrapFacts.put("screen_width", iArrScreenSize[0]).put("screen_height", iArrScreenSize[1]).put(an.ai, isPad(applicationContext) ? 2 : 1).put("boot_time", jSONObjectCollectAdnBootstrapFacts.optString("boot_mark", "")).put("system_available_size", jArrDiskSize[0]).put("system_memory_available_size", jArrMemorySize[1]).put("connect_type", connectType(applicationContext)).put(an.O, safe(locale.getCountry())).put("language", safe(locale.getLanguage())).put("time_zone", safe(TimeZone.getDefault().getID())).put("user_agent", safe(AndroidUserAgent.browserUserAgent())).put("adn_did", adnDid(applicationContext)).put("app_install_id", installId(applicationContext));
        } catch (Throwable th) {
            return jSONObjectCollectAdnBootstrapFacts;
        }
    }

    private static int connectType(Context context) {
        try {
            return NetworkUtils.getNetworkType(context);
        } catch (Throwable th) {
            return 0;
        }
    }

    private static int cpuCount() {
        try {
            File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.tapsdk.tapad.internal.runtime.AndroidDeviceFacts.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file != null && file.getName().matches("cpu[0-9]+");
                }
            });
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                return fileArrListFiles.length;
            }
            return Runtime.getRuntime().availableProcessors();
        } catch (Throwable th) {
            return Runtime.getRuntime().availableProcessors();
        }
    }

    private static String currentTapProfileOpenId() {
        try {
            Class<?> cls = Class.forName("com.taptap.sdk.Profile");
            Method declaredMethod = cls.getDeclaredMethod("getCurrentProfile", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            if (objInvoke == null) {
                return "";
            }
            Method declaredMethod2 = cls.getDeclaredMethod("toJsonString", null);
            declaredMethod2.setAccessible(true);
            Object objInvoke2 = declaredMethod2.invoke(objInvoke, null);
            return objInvoke2 instanceof String ? safe(new JSONObject((String) objInvoke2).optString("openid", "")) : "";
        } catch (Throwable th) {
            return "";
        }
    }

    private static long[] diskSize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSizeLong = statFs.getBlockSizeLong();
            return new long[]{Math.max(0L, statFs.getAvailableBlocksLong() * blockSizeLong), Math.max(0L, statFs.getBlockCountLong() * blockSizeLong)};
        } catch (Throwable th) {
            return new long[]{0, 0};
        }
    }

    private static String gaid() {
        try {
            return safe(OaidHelper.getInstance().getGaid());
        } catch (Throwable th) {
            return "";
        }
    }

    private static String installId(Context context) {
        try {
            return safe(FinstallIdManager.getInstance(context).getFinstallId());
        } catch (Throwable th) {
            return "";
        }
    }

    private static boolean isPad(Context context) {
        try {
            if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
                return true;
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float f = displayMetrics.xdpi;
            if (f > 0.0f) {
                float f2 = displayMetrics.ydpi;
                if (f2 > 0.0f) {
                    double d = displayMetrics.widthPixels / f;
                    double d2 = displayMetrics.heightPixels / f2;
                    if (Math.sqrt((d2 * d2) + (d * d)) >= 7.0d) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean isSandbox() {
        return System.getProperties().get("flag_running_in_sandbox") != null;
    }

    static /* synthetic */ boolean lambda$refreshAndroidId$1(boolean z) {
        return AndroidPrivacyPolicy.allowsAndroidId(z) && AndroidPrivacyPolicy.allowsAndroidId();
    }

    static /* synthetic */ String lambda$refreshAndroidId$2(Context context) {
        AdnDeviceManager adnDeviceManager = AdnDeviceManager.getInstance(context);
        String strSafe = safe(Settings.Secure.getString(context.getContentResolver(), Common.Predefined.SUB_ANDROID_ID));
        if (!strSafe.isEmpty() && AndroidPrivacyPolicy.allowsAndroidId()) {
            adnDeviceManager.saveAndroidId(strSafe);
        }
        return strSafe;
    }

    private static String localAdnId(Context context) {
        try {
            GUIDHelper gUIDHelper = GUIDHelper.INSTANCE;
            gUIDHelper.init(context);
            return safe(gUIDHelper.getUID());
        } catch (Throwable th) {
            return "";
        }
    }

    private static long[] memorySize(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null) {
                return new long[]{0, 0};
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return new long[]{Math.max(0L, memoryInfo.totalMem), Math.max(0L, memoryInfo.availMem)};
        } catch (Throwable th) {
            return new long[]{0, 0};
        }
    }

    private static String oaid() {
        try {
            OaidHelper.getInstance().getSnapshot();
            return safe(OaidHelper.getInstance().getOaid());
        } catch (Throwable th) {
            return "";
        }
    }

    private static String oaidManufacturer() {
        try {
            return safe(OaidHelper.getInstance().getOaidManufacturer());
        } catch (Throwable th) {
            return "";
        }
    }

    public static String packageName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return safe(context.getPackageName());
        } catch (Throwable th) {
            return "";
        }
    }

    public static String processName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return safe(Application.getProcessName());
            }
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager == null ? null : activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == iMyPid) {
                        return safe(runningAppProcessInfo.processName);
                    }
                }
            }
            try {
                return safe(context.getApplicationInfo().processName);
            } catch (Throwable th) {
                return "";
            }
        } catch (Throwable th2) {
        }
    }

    public static String refreshAdRequestIdentifierCache(Context context, TapAdCustomController tapAdCustomController) {
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        OaidHelper oaidHelper = OaidHelper.getInstance();
        oaidHelper.setGaidCollectionAllowed(allowsPhoneState(tapAdCustomController));
        try {
            oaidHelper.refreshForAdRequest(applicationContext, tapAdCustomController);
        } catch (Throwable th) {
        }
        return refreshAndroidId(applicationContext, allowsAndroidId(tapAdCustomController));
    }

    private static String refreshAndroidId(final Context context, final boolean z) {
        return context == null ? "" : safe(androidIdCache.read(new PrivacyFactCache.Permission() { // from class: com.tapsdk.tapad.internal.runtime.AndroidDeviceFacts$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.internal.runtime.PrivacyFactCache.Permission
            public final boolean allowed() {
                return AndroidDeviceFacts.lambda$refreshAndroidId$1(z);
            }
        }, AndroidPrivacyPolicy.collectionIntervalMs(), new PrivacyFactCache.Probe() { // from class: com.tapsdk.tapad.internal.runtime.AndroidDeviceFacts$$ExternalSyntheticLambda1
            @Override // com.tapsdk.tapad.internal.runtime.PrivacyFactCache.Probe
            public final Object read() {
                return AndroidDeviceFacts.lambda$refreshAndroidId$2(context);
            }
        }));
    }

    private static String refreshSerial(Context context, boolean z) {
        if (!allowsSerial(context, z)) {
            return "";
        }
        try {
            String strSafe = safe(Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : Build.SERIAL);
            if (!strSafe.isEmpty() && !"unknown".equalsIgnoreCase(strSafe)) {
                AdnDeviceManager.getInstance(context).saveSerial(strSafe);
                return strSafe;
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    private static String safe(String str) {
        return safe(str, "");
    }

    public static int[] screenSize(Context context) {
        if (context == null) {
            return new int[]{0, 0};
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int iMax = Math.max(0, displayMetrics.widthPixels);
        int iMax2 = Math.max(0, displayMetrics.heightPixels);
        return iMax >= iMax2 ? new int[]{iMax, iMax2} : new int[]{iMax2, iMax};
    }

    public static String systemUpdateMark(File file, long j) {
        try {
            long jLastModified = file.lastModified();
            if (jLastModified > 0) {
                return String.valueOf(jLastModified);
            }
        } catch (SecurityException e) {
        }
        return j > 0 ? String.valueOf(j) : "";
    }

    private static String tapOpenId(Context context) {
        String strCurrentTapProfileOpenId = currentTapProfileOpenId();
        if (!strCurrentTapProfileOpenId.isEmpty()) {
            return strCurrentTapProfileOpenId;
        }
        try {
            return safe(new JSONObject(context.getSharedPreferences("taptap_sharepreference", 0).getString("taptap_account", "")).optString("openid", ""));
        } catch (Throwable th) {
            return "";
        }
    }

    public static Map<String, Object> telemetryPlatformFacts(Context context) {
        HashMap map = new HashMap();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String strProcessName = processName(context);
        map.put("sdk_version", "5.3.0.1");
        map.put("sdk_version_code", 50300001);
        map.put(Common.Predefined.SUB_OS_TYPE, 1);
        map.put("app_package", packageName(context));
        map.put("app_version", versionName(context));
        map.put("sdk_first_install_time", Long.valueOf(context == null ? 0L : FinstallIdManager.getInstance(context).getFirstInstallTime()));
        map.put(an.F, Build.BRAND);
        map.put(an.H, Build.MANUFACTURER);
        map.put("device_model", Build.MODEL);
        map.put(an.y, Build.VERSION.RELEASE);
        map.put("android_api_version", Integer.valueOf(Build.VERSION.SDK_INT));
        map.put(ContentProviderManager.PLUGIN_PROCESS_NAME, strProcessName);
        map.put("current_process_name", strProcessName);
        map.put(ApkNotificationReceiver.EXTRA_PROCESS_ID, Integer.valueOf(Process.myPid()));
        return map;
    }

    public static String versionName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo == null ? "" : safe(packageInfo.versionName);
        } catch (Throwable th) {
            return "";
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    private static int wxInstalledState(Context context) {
        try {
            return WXUtil.isWXInstalledThroughOpenSDK(context) ? 1 : 0;
        } catch (Throwable th) {
            return 0;
        }
    }

    private static String safe(String str, String str2) {
        return (str == null || str.length() == 0) ? str2 : str;
    }
}
