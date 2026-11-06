package com.byazt.yw;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.china.a.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 19})
public final class n {
    public static boolean l = false;
    public static String n;
    public static Field q;
    public static Class<?> qg;
    public static Field s;

    private static long n(int i) {
        if (i < 0) {
            return 0L;
        }
        return ((long) i) * c.k;
    }

    public static boolean s(Context context) {
        return false;
    }

    public static boolean n(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName())) ? false : true;
        } catch (Throwable unused) {
        }
    }

    public static ActivityManager.ProcessErrorStateInfo n(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        for (int i2 = 0; i2 < i; i2++) {
            SystemClock.sleep(200L);
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        return processErrorStateInfo;
                    }
                }
            }
        }
        return null;
    }

    public static boolean qg(Context context) {
        String strQ = q(context);
        if (strQ != null && strQ.contains(":")) {
            return false;
        }
        if (strQ == null || !strQ.equals(context.getPackageName())) {
            return strQ != null && strQ.equals(context.getApplicationInfo().processName);
        }
        return true;
    }

    public static String q(Context context) {
        String str = n;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            n = d.n(context);
        } catch (Throwable unused) {
        }
        String str2 = n;
        return str2 == null ? "" : str2;
    }

    public static void n(Context context, JSONObject jSONObject) {
        try {
            n(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                qg(jSONObject, activityManager);
            }
            n(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    private static void n(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
        jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime runtime = Runtime.getRuntime();
        jSONObject2.put("max_memory", runtime.maxMemory());
        jSONObject2.put("free_memory", runtime.freeMemory());
        jSONObject2.put("total_memory", runtime.totalMemory());
        if (activityManager != null) {
            jSONObject2.put("memory_class", activityManager.getMemoryClass());
            jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
        }
        jSONObject.put("app_memory_info", jSONObject2);
    }

    private static void qg(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", x.n(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    private static void n(JSONObject jSONObject) throws JSONException {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", n(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", n(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", n(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", n(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", n(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", n(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", n(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", n(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        jSONObject2.put("totalPrivateClean", qg.n(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", n(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", qg.qg(memoryInfo));
        jSONObject2.put("totalSharedDirty", n(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", n(qg.s(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }

    public static String l(Context context) {
        Class<?> clsX = x(context);
        if (s == null && clsX != null) {
            try {
                s = clsX.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = s;
        if (field == null) {
            return "";
        }
        try {
            return (String) field.get(null);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static int w(Context context) {
        Class<?> clsX = x(context);
        if (q == null && clsX != null) {
            try {
                q = clsX.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = q;
        if (field == null) {
            return -1;
        }
        try {
            return ((Integer) field.get(null)).intValue();
        } catch (Throwable unused2) {
            return -1;
        }
    }

    private static Class<?> x(Context context) {
        if (qg == null && !l) {
            try {
                qg = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            l = true;
        }
        return qg;
    }
}
