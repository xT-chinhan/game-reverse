package com.umeng.commonsdk;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.be;
import com.umeng.analytics.pro.bg;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cm;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.cz;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMLogCommon;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.deeplink.OnAttributionListener;
import com.umeng.commonsdk.deeplink.a;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.TagHelper;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.c;
import com.umeng.commonsdk.utils.d;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class UMConfigure {
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    private static final String KEY_FILE_NAME_APPKEY = "APPKEY";
    private static final String KEY_FILE_NAME_LOG = "LOG";
    private static final String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    private static final String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    private static final String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    private static final String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    private static final String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    private static final String TAG = "UMConfigure";
    private static final String WRAPER_TYPE_COCOS2DX_X = "Cocos2d-x";
    private static final String WRAPER_TYPE_COCOS2DX_XLUA = "Cocos2d-x_lua";
    private static final String WRAPER_TYPE_FLUTTER = "flutter";
    private static final String WRAPER_TYPE_HYBRID = "hybrid";
    private static final String WRAPER_TYPE_NATIVE = "native";
    private static final String WRAPER_TYPE_PHONEGAP = "phonegap";
    private static final String WRAPER_TYPE_REACTNATIVE = "react-native";
    private static final String WRAPER_TYPE_UNITY = "Unity";
    private static final String WRAPER_TYPE_WEEX = "weex";
    private static boolean debugLog = false;
    private static OnGetOaidListener mOnGetOaidListener;
    public static UMLog umDebugLog = new UMLog();
    private static boolean preInitComplete = false;
    private static Object PreInitLock = new Object();
    public static String sAppkey = "";
    public static String sChannel = "";
    public static boolean isInit = false;
    private static Object lock = new Object();
    private static int preInitInvokedFlag = 0;
    private static int policyGrantInvokedFlag = 0;
    private static int policyGrantResult = 0;
    private static boolean shouldCheckShareSdk = true;
    private static volatile boolean shouldCollectAid = true;
    private static volatile boolean shouldCollectOaid = true;
    private static volatile boolean shouldCollectImei = true;
    private static volatile boolean shouldCollectImsi = true;
    private static volatile boolean shouldCollectIccid = true;
    private static volatile boolean shouldCollectWiFiMac = true;
    private static volatile boolean shouldCollectApl = true;
    private static volatile boolean shouldOutputRT = false;
    public static MobclickAgent.PageMode AUTO_ACTIVITY_PAGE_COLLECTION = MobclickAgent.PageMode.AUTO;
    private static volatile long initCompleteTs = 0;
    private static UMAnalyticsCustomController customController = null;
    private static Object controllerLock = new Object();
    private static final String[] BUSINESS_TYPE = {"apm", "push", "share", "ulink", "uverify", "usms", "urec", "abtest", "game", bv.af};
    private static boolean isFinish = false;
    private static Object lockObject = new Object();

    public enum BS_TYPE {
        APM,
        PUSH,
        SHARE,
        ULINK,
        UVERIFY,
        USMS,
        UREC,
        ABTEST,
        GAME,
        ZID
    }

    private static void ignoreSdkCheck(Context context) {
        shouldCheckShareSdk = false;
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static Object getDecInstanceObject(Class<?> cls) {
        Constructor<?> declaredConstructor;
        if (cls == null) {
            return null;
        }
        try {
            declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        } catch (NoSuchMethodException unused) {
            declaredConstructor = null;
        }
        if (declaredConstructor == null) {
            return null;
        }
        declaredConstructor.setAccessible(true);
        try {
            return declaredConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused2) {
            return null;
        }
    }

    private static Method getDecMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        Method declaredMethod = null;
        if (cls != null) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
            }
        }
        return declaredMethod;
    }

    private static void invoke(Method method, Object obj, Object[] objArr) {
        if (method == null || obj == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
        }
    }

    private static void invoke(Method method, Object[] objArr) {
        if (method != null) {
            try {
                method.invoke(null, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    private static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    private static void setFile(Class<?> cls, String str, boolean z) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, Boolean.valueOf(z));
            } catch (Exception unused) {
            }
        }
    }

    public static boolean getInitStatus() {
        boolean z;
        synchronized (lockObject) {
            z = isFinish;
        }
        return z;
    }

    private static boolean checkShareSdk(Class<?> cls) {
        try {
            return cls.getDeclaredField("isZyb") != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void setOnAttributionListener(OnAttributionListener onAttributionListener) {
        a.a().a(UMGlobalContext.getAppContext(), onAttributionListener);
    }

    public static void init(Context context, int i, String str) {
        init(context, null, null, i, str);
    }

    private static boolean isPreInit() {
        boolean z;
        synchronized (PreInitLock) {
            z = preInitComplete;
        }
        return z;
    }

    public static void preInit(Context context, String str, String str2) {
        synchronized (lock) {
            preInitInvokedFlag = 1;
        }
        preInitInternal(context, str, str2);
    }

    public static void submitPolicyGrantResult(Context context, boolean z) {
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.B, b.a(context).a(), null);
        synchronized (lock) {
            policyGrantInvokedFlag = 1;
            if (z) {
                policyGrantResult = 1;
            } else {
                policyGrantResult = 2;
            }
        }
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.z, b.a(context).a(), Integer.valueOf(policyGrantResult));
    }

    public static boolean shouldOutput() {
        return shouldOutputRT;
    }

    private static void preInitInternal(Context context, String str, String str2) {
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "preInit: context is null, pls check!");
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if ("1".equals(UMUtils.getSystemProperty("debug.umeng.rtlog", "0"))) {
            shouldOutputRT = true;
        }
        if (TextUtils.isEmpty(str)) {
            str = UMUtils.getAppkeyByXML(applicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = UMUtils.getChannelByXML(applicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "Unknown";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sAppkey = str;
        sChannel = str2;
        UMGlobalContext.getInstance(applicationContext);
        o.a(applicationContext);
        o.a(applicationContext).b();
        ck.a(applicationContext);
        if (!needSendZcfgEnv(applicationContext)) {
            FieldManager.a().a(applicationContext);
        }
        synchronized (PreInitLock) {
            preInitComplete = true;
        }
        boolean zA = c.a();
        if (debugLog && zA) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 当前处于静默模式!");
        }
    }

    /* JADX WARN: Type inference failed for: r8v30, types: [com.umeng.commonsdk.UMConfigure$3] */
    /* JADX WARN: Type inference failed for: r8v36, types: [com.umeng.commonsdk.UMConfigure$2] */
    /* JADX WARN: Type inference failed for: r8v40, types: [com.umeng.commonsdk.UMConfigure$1] */
    public static void init(Context context, String str, String str2, int i, String str3) {
        Method declaredMethod;
        Object objInvoke;
        Method declaredMethod2;
        Class<?> cls;
        Method declaredMethod3;
        Method declaredMethod4;
        Method declaredMethod5;
        Method declaredMethod6;
        Object objInvoke2;
        Method declaredMethod7;
        Class<?> cls2;
        Method declaredMethod8;
        Method declaredMethod9;
        try {
            try {
                if (debugLog) {
                    Log.i(TAG, "common version is 9.9.6");
                    Log.i(TAG, "common type is " + SdkVersion.SDK_TYPE);
                }
                if (context == null) {
                    if (debugLog) {
                        Log.e(TAG, "context is null !!!");
                        return;
                    }
                    return;
                }
                if (isInit) {
                    if (debugLog) {
                        Log.e(TAG, "has inited !!!");
                        return;
                    }
                    return;
                }
                final Context applicationContext = context.getApplicationContext();
                UMGlobalContext.getInstance(applicationContext);
                if (c.a()) {
                    if (!isPreInit()) {
                        preInitInternal(applicationContext, str, str2);
                        if (!isPreInit()) {
                            return;
                        }
                    }
                    UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.D, b.a(applicationContext).a(), null);
                    return;
                }
                if (getClass("com.umeng.umzid.ZIDManager") == null) {
                    Log.e(TAG, "--->>> SDK 初始化失败，请检查是否集成umeng-asms-1.2.x.aar库。<<<--- ");
                    new Thread() { // from class: com.umeng.commonsdk.UMConfigure.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Looper.prepare();
                                Toast.makeText(applicationContext, "SDK 初始化失败，请检查是否集成umeng-asms-1.2.X.aar库。", 1).show();
                                Looper.loop();
                            } catch (Throwable unused) {
                            }
                        }
                    }.start();
                    return;
                }
                try {
                    Class<?> cls3 = getClass("com.umeng.message.PushAgent");
                    if (cls3 != null && !checkShareSdk(cls3)) {
                        Log.e("UMLog", UMLogCommon.SC_10015);
                        if (shouldCheckShareSdk) {
                            new Thread() { // from class: com.umeng.commonsdk.UMConfigure.2
                                @Override // java.lang.Thread, java.lang.Runnable
                                public void run() {
                                    try {
                                        Looper.prepare();
                                        Toast.makeText(applicationContext, UMLogCommon.SC_10015, 1).show();
                                        Looper.loop();
                                    } catch (Throwable unused) {
                                    }
                                }
                            }.start();
                        }
                    }
                } catch (Throwable unused) {
                }
                try {
                    Class<?> cls4 = getClass("com.umeng.socialize.UMShareAPI");
                    if (cls4 != null && !checkShareSdk(cls4)) {
                        Log.e("UMLog", UMLogCommon.SC_10015);
                        if (shouldCheckShareSdk) {
                            new Thread() { // from class: com.umeng.commonsdk.UMConfigure.3
                                @Override // java.lang.Thread, java.lang.Runnable
                                public void run() {
                                    try {
                                        Looper.prepare();
                                        Toast.makeText(applicationContext, UMLogCommon.SC_10015, 1).show();
                                        Looper.loop();
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }.start();
                        }
                    }
                } catch (Throwable unused2) {
                }
                if (!isPreInit()) {
                    preInitInternal(applicationContext, str, str2);
                    if (!isPreInit()) {
                        return;
                    }
                }
                UMEnvelopeBuild.registerNetReceiver(applicationContext);
                UMUtils.setAppkey(applicationContext, sAppkey);
                String lastAppkey = UMUtils.getLastAppkey(applicationContext);
                if (!TextUtils.isEmpty(sAppkey) && !sAppkey.equals(lastAppkey)) {
                    if (!TextUtils.isEmpty(lastAppkey) && debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10008, 2, "");
                    }
                    UMUtils.setLastAppkey(applicationContext, sAppkey);
                }
                if (debugLog) {
                    Log.i(TAG, "current appkey is " + sAppkey + ", last appkey is " + lastAppkey);
                }
                if (debugLog) {
                    String appkeyByXML = UMUtils.getAppkeyByXML(applicationContext);
                    if (!TextUtils.isEmpty(sAppkey) && !TextUtils.isEmpty(appkeyByXML) && !sAppkey.equals(appkeyByXML)) {
                        UMLog.mutlInfo(UMLogCommon.SC_10011, 3, "", new String[]{"@", "#"}, new String[]{sAppkey, appkeyByXML});
                    }
                }
                UMUtils.setChannel(applicationContext, sChannel);
                if (debugLog) {
                    Log.i(TAG, "channel is " + sChannel);
                }
                try {
                    Class<?> cls5 = Class.forName("com.umeng.analytics.MobclickAgent");
                    if (cls5 != null) {
                        Method declaredMethod10 = cls5.getDeclaredMethod(TrackAction.INIT, Context.class);
                        if (declaredMethod10 != null) {
                            declaredMethod10.setAccessible(true);
                            declaredMethod10.invoke(cls5, applicationContext);
                            if (FieldManager.allow(d.F)) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger enabled.");
                                o.a(applicationContext).b(applicationContext);
                            } else {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger disabled.");
                            }
                            if (debugLog) {
                                UMLog.mutlInfo(UMLogCommon.SC_10003, 2, "");
                            }
                        }
                        if (Class.forName("com.umeng.analytics.game.UMGameAgent") != null && (declaredMethod9 = cls5.getDeclaredMethod("setGameScenarioType", Context.class)) != null) {
                            declaredMethod9.setAccessible(true);
                            declaredMethod9.invoke(cls5, applicationContext);
                        }
                    }
                    if (com.umeng.commonsdk.statistics.b.a.indexOf("e") >= 0 && (cls2 = Class.forName("com.umeng.analytics.MobclickAgent")) != null && (declaredMethod8 = cls2.getDeclaredMethod("disableExceptionCatch", new Class[0])) != null) {
                        declaredMethod8.setAccessible(true);
                        declaredMethod8.invoke(cls2, new Object[0]);
                    }
                } catch (Throwable unused3) {
                }
                try {
                    Class<?> cls6 = Class.forName("com.umeng.message.PushAgent");
                    if (cls6 != null && (declaredMethod7 = cls6.getDeclaredMethod(TrackAction.INIT, Context.class)) != null) {
                        declaredMethod7.setAccessible(true);
                        declaredMethod7.invoke(cls6, applicationContext);
                    }
                } catch (Throwable unused4) {
                }
                try {
                    Class<?> cls7 = Class.forName("com.umeng.message.MessageSharedPrefs");
                    if (cls7 != null && (declaredMethod6 = cls7.getDeclaredMethod("getInstance", Context.class)) != null && (objInvoke2 = declaredMethod6.invoke(cls7, applicationContext)) != null) {
                        Method declaredMethod11 = cls7.getDeclaredMethod("setMessageAppKey", String.class);
                        if (declaredMethod11 != null) {
                            declaredMethod11.setAccessible(true);
                            declaredMethod11.invoke(objInvoke2, sAppkey);
                            if (debugLog) {
                                UMLog.mutlInfo(UMLogCommon.SC_10004, 2, "");
                            }
                        }
                        Method declaredMethod12 = cls7.getDeclaredMethod(KEY_METHOD_NAME_PUSH_SETCHANNEL, String.class);
                        if (declaredMethod12 != null) {
                            declaredMethod12.setAccessible(true);
                            declaredMethod12.invoke(objInvoke2, sChannel);
                            if (debugLog) {
                                UMLog.mutlInfo(UMLogCommon.SC_10005, 2, "");
                            }
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            if (debugLog) {
                                Log.i(TAG, "push secret is " + str3);
                            }
                            Method declaredMethod13 = cls7.getDeclaredMethod("setMessageAppSecret", String.class);
                            if (declaredMethod13 != null) {
                                declaredMethod13.setAccessible(true);
                                declaredMethod13.invoke(objInvoke2, str3);
                                if (debugLog) {
                                    UMLog.mutlInfo(UMLogCommon.SC_10009, 2, "");
                                }
                            }
                        }
                    }
                } catch (Exception unused5) {
                }
                try {
                    Class<?> cls8 = getClass("com.umeng.socialize.UMShareAPI");
                    setFile(cls8, KEY_FILE_NAME_APPKEY, sAppkey);
                    if (cls8 != null && (declaredMethod5 = cls8.getDeclaredMethod(TrackAction.INIT, Context.class, String.class)) != null) {
                        declaredMethod5.setAccessible(true);
                        declaredMethod5.invoke(cls8, applicationContext, sAppkey);
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10006, 2, "");
                        }
                    }
                } catch (Throwable unused6) {
                }
                AnalyticsConstants.setDeviceType(i);
                try {
                    Class<?> cls9 = Class.forName("com.umeng.error.UMError");
                    if (cls9 != null && (declaredMethod4 = cls9.getDeclaredMethod(TrackAction.INIT, Context.class)) != null) {
                        declaredMethod4.setAccessible(true);
                        declaredMethod4.invoke(cls9, applicationContext);
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10010, 2, "");
                        }
                    }
                } catch (Throwable unused7) {
                }
                try {
                    if (getClass("com.umeng.umefs.UMEfs") == null && (cls = getClass("com.umeng.umcrash.UMCrash")) != null) {
                        if (SdkVersion.SDK_TYPE == 1 && (declaredMethod3 = cls.getDeclaredMethod("useIntlServices", Boolean.TYPE)) != null) {
                            declaredMethod3.setAccessible(true);
                            declaredMethod3.invoke(cls, true);
                        }
                        Method declaredMethod14 = cls.getDeclaredMethod(TrackAction.INIT, Context.class, String.class, String.class);
                        if (declaredMethod14 != null) {
                            declaredMethod14.setAccessible(true);
                            declaredMethod14.invoke(cls, applicationContext, sAppkey, sChannel);
                            if (debugLog) {
                                UMLog.mutlInfo(UMLogCommon.SC_10014, 2, "");
                            }
                        }
                    }
                } catch (Throwable unused8) {
                }
                try {
                    Method declaredMethod15 = Class.forName("com.umeng.vt.facade.EventFacade").getDeclaredMethod(TrackAction.INIT, Application.class, String.class, String.class, Integer.TYPE, String.class);
                    if (declaredMethod15 != null) {
                        declaredMethod15.invoke(null, applicationContext, sAppkey, sChannel, Integer.valueOf(i), str3);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 EventFacade 成功.");
                    }
                } catch (Throwable unused9) {
                }
                try {
                    Method declaredMethod16 = Class.forName("com.umeng.vt.common.VTTracker").getDeclaredMethod(TrackAction.INIT, Application.class, String.class);
                    if (declaredMethod16 != null) {
                        declaredMethod16.invoke(null, applicationContext, sAppkey);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 VTTracker 成功.");
                    }
                } catch (Throwable unused10) {
                }
                synchronized (lockObject) {
                    isFinish = true;
                }
                if (needCheckPolicyResult(applicationContext)) {
                    synchronized (lock) {
                        if (preInitInvokedFlag == 0) {
                            Log.e(TAG, UMLogCommon.SC_10026);
                        }
                        if (policyGrantResult == 0) {
                            Log.e(TAG, UMLogCommon.SC_10028);
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(com.umeng.commonsdk.internal.a.N, preInitInvokedFlag);
                            jSONObject.put(com.umeng.commonsdk.internal.a.O, policyGrantInvokedFlag);
                            jSONObject.put("policyGrantResult", policyGrantResult);
                            UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.A, b.a(applicationContext).a(), jSONObject);
                        } catch (Throwable unused11) {
                        }
                    }
                }
                if (needSendZcfgEnv(applicationContext)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走零号报文发送逻辑");
                    UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.p, b.a(applicationContext).a(), null);
                } else if (UMUtils.isMainProgress(applicationContext)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走正常逻辑.");
                    if (FieldManager.b()) {
                        UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.y, b.a(applicationContext).a(), null);
                    }
                    if (FieldManager.allow(d.G)) {
                        com.umeng.commonsdk.internal.c.a(applicationContext, false);
                    }
                }
                try {
                    if (UMUtils.isMainProgress(applicationContext)) {
                        cz.b(applicationContext);
                        cm.a(context, 105, cn.a(), null);
                    }
                } catch (Throwable unused12) {
                }
                if (isDebugLog()) {
                    UMConfigureInternation.doSelfCheck(applicationContext);
                }
                try {
                    Context applicationContext2 = context.getApplicationContext();
                    Class<?> cls10 = Class.forName("com.umeng.cconfig.UMRemoteConfig");
                    if (cls10 != null && (declaredMethod = cls10.getDeclaredMethod("getInstance", new Class[0])) != null && (objInvoke = declaredMethod.invoke(cls10, new Object[0])) != null && (declaredMethod2 = cls10.getDeclaredMethod(TrackAction.INIT, Context.class)) != null) {
                        declaredMethod2.setAccessible(true);
                        declaredMethod2.invoke(objInvoke, applicationContext2);
                    }
                } catch (Exception unused13) {
                }
                UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.F, b.a(context).a(), null);
                if (!isInit) {
                    isInit = true;
                }
                initCompleteTs = System.currentTimeMillis();
                if (SdkVersion.SDK_TYPE == 0) {
                    try {
                        a.a().a(context);
                    } catch (Throwable unused14) {
                    }
                }
                if (debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10029, 2, "");
                }
            } catch (Exception e) {
                if (debugLog) {
                    Log.e(TAG, "init e is " + e);
                }
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e(TAG, "init e is " + th);
            }
        }
    }

    public static long getInitCompleteTs() {
        return initCompleteTs;
    }

    public static boolean needSendZcfgEnv(Context context) {
        return !new File(new StringBuilder().append(context.getFilesDir().getAbsolutePath()).append(File.separator).append(bz.l).toString()).exists();
    }

    private static boolean needCheckPolicyResult(Context context) {
        return !new File(new StringBuilder().append(context.getFilesDir().getAbsolutePath()).append(File.separator).append(bz.m).toString()).exists();
    }

    private static boolean isSilentMode() {
        boolean zA = c.a();
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> isSilentMode() return: " + zA);
        return zA;
    }

    public static boolean isDebugLog() {
        return debugLog;
    }

    public static void setLogEnabled(boolean z) {
        try {
            debugLog = z;
            MLog.DEBUG = z;
            Class<?> cls = getClass("com.umeng.message.PushAgent");
            invoke(getDecMethod(cls, KEY_METHOD_NAME_SETDEBUGMODE, new Class[]{Boolean.TYPE}), getDecInstanceObject(cls), new Object[]{Boolean.valueOf(z)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z);
            invoke(getDecMethod(getClass("com.umeng.umcrash.UMCrash"), "setDebug", new Class[]{Boolean.TYPE}), new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + e);
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + th);
            }
        }
    }

    public static void setEncryptEnabled(boolean z) {
        com.umeng.commonsdk.statistics.b.a(z);
    }

    public static String getUMIDString(Context context) {
        if (context != null) {
            return UMUtils.getUMId(context.getApplicationContext());
        }
        return null;
    }

    public static String getUmengZID(Context context) {
        if (context != null) {
            return UMUtils.getZid(context.getApplicationContext());
        }
        return null;
    }

    public static void setProcessEvent(boolean z) {
        AnalyticsConstants.SUB_PROCESS_EVENT = z;
    }

    private static void setLatencyWindow(long j) {
        com.umeng.commonsdk.statistics.a.c = ((int) j) * 1000;
    }

    private static void setModuleTag(BS_TYPE bs_type, String str, String str2) {
        try {
            if (bs_type == null) {
                Log.e("UMLog", UMLogCommon.SC_10024);
                return;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.trim().getBytes().length > 64) {
                    Log.e("UMLog", UMLogCommon.SC_10017);
                    return;
                }
                if (str2.trim().getBytes().length > 128) {
                    Log.e("UMLog", UMLogCommon.SC_10018);
                    return;
                }
                int iOrdinal = bs_type.ordinal();
                String[] strArr = BUSINESS_TYPE;
                String str3 = iOrdinal < strArr.length ? strArr[iOrdinal] : "";
                if (TextUtils.isEmpty(str3)) {
                    Log.e("UMLog", UMLogCommon.SC_10019);
                    return;
                } else {
                    TagHelper.setModuleTag(str3 + "_" + str, str2);
                    return;
                }
            }
            Log.e("UMLog", UMLogCommon.SC_10016);
        } catch (Throwable unused) {
        }
    }

    private static void deleteModuleTag(BS_TYPE bs_type, String str) {
        if (bs_type == null) {
            Log.e("UMLog", UMLogCommon.SC_10025);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e("UMLog", UMLogCommon.SC_10020);
            return;
        }
        try {
            if (str.trim().getBytes().length > 64) {
                Log.e("UMLog", UMLogCommon.SC_10021);
                return;
            }
            int iOrdinal = bs_type.ordinal();
            String[] strArr = BUSINESS_TYPE;
            String str2 = iOrdinal < strArr.length ? strArr[iOrdinal] : "";
            if (TextUtils.isEmpty(str2)) {
                Log.e("UMLog", UMLogCommon.SC_10022);
            } else {
                TagHelper.deleteModuleTag(str2 + "_" + str);
            }
        } catch (Throwable unused) {
        }
    }

    private static Map<String, String> getModuleTags() {
        try {
            return TagHelper.getModuleTags();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void setCheckDevice(boolean z) {
        AnalyticsConstants.CHECK_DEVICE = z;
    }

    private static void setWraperType(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(WRAPER_TYPE_NATIVE)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_NATIVE;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_NATIVE;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_X)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_COCOS2DX_X;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_COCOS2DX_X;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_XLUA)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_COCOS2DX_XLUA;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_COCOS2DX_XLUA;
            } else if (str.equals(WRAPER_TYPE_UNITY)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_UNITY;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_UNITY;
            } else if (str.equals(WRAPER_TYPE_REACTNATIVE)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_REACTNATIVE;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_REACTNATIVE;
            } else if (str.equals(WRAPER_TYPE_PHONEGAP)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_PHONEGAP;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_PHONEGAP;
            } else if (str.equals(WRAPER_TYPE_WEEX)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_WEEX;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_WEEX;
            } else if (str.equals("hybrid")) {
                com.umeng.commonsdk.stateless.a.a = "hybrid";
                com.umeng.commonsdk.statistics.a.a = "hybrid";
            } else if (str.equals(WRAPER_TYPE_FLUTTER)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_FLUTTER;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_FLUTTER;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.umeng.commonsdk.stateless.a.b = str2;
        com.umeng.commonsdk.statistics.a.b = str2;
    }

    public static String[] getTestDeviceInfo(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
            } catch (Exception unused) {
            }
        }
        return strArr;
    }

    public static void getOaid(Context context, OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "context is null !!!");
                return;
            }
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        mOnGetOaidListener = onGetOaidListener;
        if (!shouldCollectOaid) {
            OnGetOaidListener onGetOaidListener2 = mOnGetOaidListener;
            if (onGetOaidListener2 != null) {
                onGetOaidListener2.onGetOaid(null);
                return;
            }
            return;
        }
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMConfigure.4
            @Override // java.lang.Runnable
            public void run() {
                String strB = bg.b(applicationContext);
                if (UMConfigure.mOnGetOaidListener != null) {
                    UMConfigure.mOnGetOaidListener.onGetOaid(strB);
                }
            }
        }).start();
    }

    public static void resetStorePrefix(String str) {
        be.b().a(str);
    }

    public static void resetStorePath() {
        resetStorePrefix("um_");
    }

    public static void setDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("UMLog", "setDomain: Parameter domain is null or empty string, do nothing.");
        } else {
            UMServerURL.DEFAULT_URL = str;
            UMServerURL.SECONDARY_URL = str;
        }
    }

    public static void enableAzxSwitch(boolean z) {
        com.umeng.ccg.b.a(z);
    }

    public static void enableUmcCfgSwitch(boolean z) {
        com.umeng.ccg.b.b(z);
    }

    public static void enableApModeSwitch(boolean z) {
        com.umeng.ccg.b.c(z);
    }

    public static void onActEvent(String str, String str2, Bundle bundle) {
        ck.a(str, str2, bundle);
    }

    public static void registerActionInfo(ActionInfo actionInfo) {
        CcgAgent.registerActionInfo(actionInfo);
    }

    private static void disableAidCollect() {
        try {
            Class<?> cls = getClass("com.umeng.socialize.UMShareAPI");
            Class<?> cls2 = getClass("com.uyumao.nns.zmd.ZmdManager");
            if (cls == null && cls2 == null) {
                return;
            }
            shouldCollectAid = false;
        } catch (Throwable unused) {
        }
    }

    private static void disableOaidCollect() {
        try {
            if (getClass("com.uyumao.nns.zmd.ZmdManager") != null) {
                shouldCollectOaid = false;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean shouldCollectAid() {
        return shouldCollectAid;
    }

    public static boolean shouldCollectOaid() {
        return shouldCollectOaid;
    }

    public static boolean shouldCollectImei() {
        return shouldCollectImei;
    }

    public static boolean shouldCollectImsi() {
        return shouldCollectImsi;
    }

    public static boolean shouldCollectIccid() {
        return shouldCollectIccid;
    }

    public static boolean shouldCollectWifiMac() {
        return shouldCollectWiFiMac;
    }

    public static boolean shouldCollectApl() {
        return shouldCollectApl;
    }

    private static Boolean isInForeground() {
        return Boolean.valueOf(com.umeng.analytics.vshelper.b.d());
    }

    private static String getCurrentActivityName() {
        return PageNameMonitor.getInstance().getCurrentActivityName();
    }

    public static void enableImeiCollection(boolean z) {
        shouldCollectImei = z;
    }

    public static void enableImsiCollection(boolean z) {
        shouldCollectImsi = z;
    }

    public static void enableIccidCollection(boolean z) {
        shouldCollectIccid = z;
    }

    public static void enableWiFiMacCollection(boolean z) {
        shouldCollectWiFiMac = z;
    }

    @Deprecated
    public static void enableAplCollection(boolean z) {
        shouldCollectApl = z;
    }

    public static void enablePi(boolean z) {
        o.a(z);
    }

    public static void enablePo(boolean z) {
        o.b(z);
    }

    public static void setCustomController(UMAnalyticsCustomController uMAnalyticsCustomController) {
        synchronized (controllerLock) {
            if (uMAnalyticsCustomController != null) {
                customController = uMAnalyticsCustomController;
            }
        }
    }

    public static UMAnalyticsCustomController getCustomController() {
        UMAnalyticsCustomController uMAnalyticsCustomController;
        synchronized (controllerLock) {
            uMAnalyticsCustomController = customController;
        }
        return uMAnalyticsCustomController;
    }

    public static void enableInstallReferrerCollection(boolean z) {
        com.umeng.commonsdk.statistics.common.d.a(z);
    }

    public static void setInstallReferrer(String str, String str2) {
        com.umeng.commonsdk.statistics.common.d.a(str, str2);
    }
}
