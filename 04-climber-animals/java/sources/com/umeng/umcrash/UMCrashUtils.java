package com.umeng.umcrash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.uc.crashsdk.export.CrashApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public class UMCrashUtils {
    private static final int DEF_CLOSE_RATE = 0;
    private static final int MAX_THREAD_TRACE_LENGTH = 20480;
    private static final int MAX_TRACE_RATE = 100;
    public static final String UNKNOW = "";
    private static volatile boolean hasReadOperatorName = false;
    private static volatile String sOperatorName = "";

    public static boolean random(int i) {
        if (i == 0) {
            return false;
        }
        return i == 100 || new Random().nextInt(100) <= i;
    }

    public static void saveInnerConfig(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || obj == null || (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) == null || (editorEdit = sharedPreferences.edit()) == null) {
                    return;
                }
                editorEdit.putInt(str, Integer.parseInt(obj.toString()));
                editorEdit.commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static int getInnerConfig(Context context, String str, int i) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            return i;
        }
        try {
            return (TextUtils.isEmpty(str) || (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) == null) ? i : sharedPreferences.getInt(str, i);
        } catch (Throwable th) {
            th.printStackTrace();
            return i;
        }
    }

    public static void setCommonTag(String str, String str2) {
        Class<?> cls;
        Method declaredMethod;
        try {
            Class<?> cls2 = Class.forName("com.umeng.commonsdk.UMConfigure");
            if (cls2 == null || (cls = Class.forName("com.umeng.commonsdk.UMConfigure$BS_TYPE")) == null || (declaredMethod = cls2.getDeclaredMethod("setModuleTag", cls, String.class, String.class)) == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            for (Enum r9 : (Enum[]) cls.getEnumConstants()) {
                if (r9 != null && r9.name().equals("APM")) {
                    declaredMethod.invoke(cls2, r9, str, str2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean isHarmony(final Context context) {
        try {
            final SharedPreferences sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0);
            if (sharedPreferences.contains("um_apm_harmony")) {
                return sharedPreferences.getBoolean("um_apm_harmony", false);
            }
            WorkThreadUtil.submit(new Runnable() { // from class: com.umeng.umcrash.UMCrashUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        sharedPreferences.edit().putBoolean("um_apm_harmony", context.getString(Resources.getSystem().getIdentifier("config_os_brand", "string", "android")).equals("harmony")).apply();
                    } catch (Throwable unused) {
                    }
                }
            });
            return false;
        } catch (Throwable unused) {
        }
    }

    public static String[] getActiveUser(Context context) {
        Class<?> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.utils.UMUtils");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getActiveUser", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, context);
            if (objInvoke != null) {
                return (String[]) objInvoke;
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    public static void setPuidAndProvider(String str, String str2) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PUID, str);
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PROVIDER, str2);
        }
        HashMap map = new HashMap();
        map.put(UMCrash.KEY_HEADER_PUID, str);
        map.put(UMCrash.KEY_HEADER_PROVIDER, str2);
        if (UMCrash.getReporter() != null) {
            UMCrash.getReporter().addPublicParams(map);
        }
    }

    public static void setIntegrationTesingParams(String str) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo("um_dk", str);
        }
        if (UMCrash.getReporter() != null) {
            HashMap map = new HashMap();
            map.put("um_dk", str);
            UMCrash.getReporter().addPublicParams(map);
        }
    }

    public static String getNetworkOperatorName(Context context) {
        if (!TextUtils.isEmpty(sOperatorName)) {
            return sOperatorName;
        }
        if (hasReadOperatorName || context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                sOperatorName = telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable unused) {
        }
        hasReadOperatorName = true;
        return sOperatorName;
    }

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            return ((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String splitByByte(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        try {
            int length = str.length();
            int length2 = 0;
            for (int i2 = 0; i2 < length; i2++) {
                String strValueOf = String.valueOf(str.charAt(i2));
                length2 += strValueOf.getBytes().length;
                if (i < length2) {
                    break;
                }
                stringBuffer.append(strValueOf);
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    public static synchronized String getUMID(Context context) {
        Class<?> cls;
        Method method;
        String string = null;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.UMConfigure");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                method = cls.getMethod("getUMIDString", Context.class);
            } catch (NoSuchMethodException unused2) {
                method = null;
            }
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, context);
                    if (objInvoke != null) {
                        string = objInvoke.toString();
                    }
                } catch (IllegalAccessException | InvocationTargetException unused3) {
                }
            }
        }
        return string;
    }

    public static synchronized String getSessionId(Context context) {
        Class<?> cls;
        Method method;
        String string = null;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                method = cls.getMethod("getSid", Context.class);
            } catch (NoSuchMethodException unused2) {
                method = null;
            }
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, context);
                    if (objInvoke != null) {
                        string = objInvoke.toString();
                    }
                } catch (IllegalAccessException | InvocationTargetException unused3) {
                }
            }
        }
        return string;
    }

    public static Map<String, String> getAllThreadTraces() {
        HashMap map = new HashMap();
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            if (allStackTraces == null) {
                return null;
            }
            Thread thread = Looper.getMainLooper().getThread();
            if (!allStackTraces.containsKey(thread)) {
                allStackTraces.put(thread, thread.getStackTrace());
            }
            long id = Thread.currentThread().getId();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                if (id != entry.getKey().getId()) {
                    sb.setLength(0);
                    if (entry.getValue() != null && entry.getValue().length != 0) {
                        for (StackTraceElement stackTraceElement : entry.getValue()) {
                            if (sb.length() >= 20480) {
                                sb.append("\n[Stack trace size must be less than :").append(20480).append("!]");
                                break;
                            }
                            sb.append("  at ").append(stackTraceElement.toString()).append("\n");
                        }
                        map.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return map;
    }
}
