package com.byazt.wf;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.byazt.ol.TTDownloadField;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 201, 37})
public final class pr {
    public static String pr = null;
    public static Class<?> hw = null;
    public static Field hn = null;
    public static Field x = null;
    public static boolean c = false;

    public static boolean pr(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName())) {
                return false;
            }
            return true;
        } catch (Throwable th) {
        }
    }

    public static ActivityManager.ProcessErrorStateInfo pr(Context context, int i) {
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

    public static boolean hw(Context context) {
        String strX = x(context);
        if (strX != null && strX.contains(":")) {
            return false;
        }
        if (strX != null && strX.equals(context.getPackageName())) {
            return true;
        }
        if (strX == null || !strX.equals(context.getApplicationInfo().processName)) {
            return false;
        }
        return true;
    }

    public static boolean hn(Context context) {
        return false;
    }

    public static String x(Context context) {
        String str = pr;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            pr = k.pr(context);
        } catch (Throwable th) {
        }
        String str2 = pr;
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public static void pr(Context context, JSONObject jSONObject) {
        try {
            pr(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                hw(jSONObject, activityManager);
            }
            pr(jSONObject, activityManager);
        } catch (Throwable th) {
        }
    }

    private static void pr(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
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

    private static void hw(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", fw.pr(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    private static void pr(JSONObject jSONObject) throws JSONException {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", pr(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", pr(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", pr(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", pr(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", pr(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", pr(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", pr(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", pr(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        jSONObject2.put("totalPrivateClean", hw.pr(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", pr(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", hw.hw(memoryInfo));
        jSONObject2.put("totalSharedDirty", pr(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", pr(hw.hn(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }

    private static long pr(int i) {
        if (i < 0) {
            return 0L;
        }
        return ((long) i) * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static String c(Context context) {
        Class<?> clsFw = fw(context);
        if (hn == null && clsFw != null) {
            try {
                hn = clsFw.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException e) {
            }
        }
        Field field = hn;
        if (field != null) {
            try {
                return (String) field.get(null);
            } catch (Throwable th) {
                return "";
            }
        }
        return "";
    }

    public static int uc(Context context) {
        Class<?> clsFw = fw(context);
        if (x == null && clsFw != null) {
            try {
                x = clsFw.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException e) {
            }
        }
        Field field = x;
        if (field != null) {
            try {
                return ((Integer) field.get(null)).intValue();
            } catch (Throwable th) {
                return -1;
            }
        }
        return -1;
    }

    private static Class<?> fw(Context context) {
        if (hw == null && !c) {
            try {
                hw = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException e) {
            }
            c = true;
        }
        return hw;
    }
}
