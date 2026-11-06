package com.bytedance.ms.xr.x;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ms {
    private static Field ah = null;
    private static Field d = null;
    private static boolean ka = false;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f592ms;
    private static Class<?> xr;

    public static boolean ah(Context context) {
        return false;
    }

    private static long ms(int i) {
        if (i < 0) {
            return 0L;
        }
        return ((long) i) * 1024;
    }

    public static boolean ms(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            return (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName())) ? false : true;
        } catch (Throwable unused) {
        }
    }

    public static ActivityManager.ProcessErrorStateInfo ms(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
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

    public static boolean xr(Context context) {
        String strD = d(context);
        if (strD != null && strD.contains(":")) {
            return false;
        }
        if (strD == null || !strD.equals(context.getPackageName())) {
            return strD != null && strD.equals(context.getApplicationInfo().processName);
        }
        return true;
    }

    public static String d(Context context) {
        String str = f592ms;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            f592ms = sl.ms(context);
        } catch (Throwable unused) {
        }
        String str2 = f592ms;
        return str2 == null ? "" : str2;
    }

    public static void ms(Context context, JSONObject jSONObject) {
        try {
            ms(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                xr(jSONObject, activityManager);
            }
            ms(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    private static void ms(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
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

    private static void xr(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", ab.ms(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    private static void ms(JSONObject jSONObject) throws JSONException {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", ms(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", ms(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", ms(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", ms(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", ms(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", ms(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", ms(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", ms(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        jSONObject2.put("totalPrivateClean", xr.ms(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", ms(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", xr.xr(memoryInfo));
        jSONObject2.put("totalSharedDirty", ms(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", ms(xr.ah(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }

    public static String ka(Context context) {
        Class<?> clsAb = ab(context);
        if (ah == null && clsAb != null) {
            try {
                ah = clsAb.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = ah;
        if (field == null) {
            return "";
        }
        try {
            return (String) field.get(null);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static int c(Context context) {
        Class<?> clsAb = ab(context);
        if (d == null && clsAb != null) {
            try {
                d = clsAb.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = d;
        if (field == null) {
            return -1;
        }
        try {
            return ((Integer) field.get(null)).intValue();
        } catch (Throwable unused2) {
            return -1;
        }
    }

    private static Class<?> ab(Context context) {
        if (xr == null && !ka) {
            try {
                xr = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            ka = true;
        }
        return xr;
    }
}
