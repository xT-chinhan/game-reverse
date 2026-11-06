package com.umeng.crash;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.system.Os;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.UMCrash;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: UCrash */
/* JADX INFO: loaded from: classes4.dex */
final class m {
    private static final String[] a = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};

    static String a(Context context) {
        return UMFrUtils.getCurrentProcessName(context);
    }

    static String b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(applicationInfo);
            return obj instanceof String ? (String) obj : "";
        } catch (Throwable th) {
            UCrash.a().a("UCrash.Utils", "get primary cpu abi failed", th);
            return "";
        }
    }

    private static boolean n() {
        try {
            for (String str : a) {
                if (new File(str).exists()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    static String c(Context context) {
        return UMUtils.getAppkey(context);
    }

    static String d(Context context) {
        return DeviceConfig.getAppVersionName(context);
    }

    static String e(Context context) {
        return DeviceConfig.getAppVersionCode(context);
    }

    static ActivityManager.ProcessErrorStateInfo a() {
        ActivityManager activityManager = (ActivityManager) UMGlobalContext.getAppContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return null;
        }
        int iMyPid = Process.myPid();
        for (int i = 0; i < 50; i++) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                if (i % 2 == 0) {
                    UCrash.a().a("UCrash.Utils", "state not null. times:" + (i / 2));
                }
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.pid == iMyPid && processErrorStateInfo.condition == 2) {
                        UCrash.a().b("UCrash.Utils", "anr info.pid:" + processErrorStateInfo.pid + ", info.condition:" + processErrorStateInfo.condition);
                        return processErrorStateInfo;
                    }
                }
            } else if (i % 2 == 0) {
                UCrash.a().a("UCrash.Utils", "state empty. total:25, times:" + (i / 2));
            }
            try {
                Thread.sleep(500L);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    static String a(String str, long j, String str2) {
        c cVarA = c.a();
        e eVarA = e.a();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        StringBuilder sb = new StringBuilder("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n");
        sb.append(String.format(Locale.US, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), simpleDateFormat.format(Long.valueOf(j))));
        sb.append(String.format(Locale.US, "Cpu Information: 'abi: %s/%s'\n", TextUtils.join(",", Build.SUPPORTED_ABIS), q()));
        String[] strArrO = o();
        sb.append(String.format(Locale.US, "Mobile Information: 'model: %s/version: %s/sdk: %s'\n", p(), strArrO[0], strArrO[1]));
        if (ControllerCenter.getGlobalEnvStruct().getCustomController() == null || (ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseDeviceModel() && ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseSystemVersion())) {
            sb.append(String.format(Locale.US, "Build fingerprint: '%s'\n", Build.FINGERPRINT));
        } else {
            sb.append(String.format(Locale.US, "Build fingerprint: '%s'\n", "UNKNOWN"));
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[4];
        objArr[0] = simpleDateFormat.format(Long.valueOf(cVarA.k));
        objArr[1] = Long.valueOf(Runtime.getRuntime().maxMemory());
        objArr[2] = cVarA.i;
        objArr[3] = eVarA.a ? "fg" : "bg";
        sb.append(String.format(locale, "Runtime Information: 'start: %s/maxheap: %d/primaryabi: %s/ground: %s'\n", objArr));
        sb.append(String.format(Locale.US, "Application Information: 'version: %s/versioncode: %s'\n", cVarA.g, cVarA.h));
        sb.append(String.format(Locale.US, "CrashSDK Information: 'version: %s'\n", "1.1.1"));
        sb.append(String.format(Locale.US, "Report Name: %s\n", str2));
        sb.append(String.format(Locale.US, "UUID: %s\n", r()));
        sb.append(String.format(Locale.US, "Log Type: %s\n", str));
        if ("anr".equals(str) || "jni".equals(str)) {
            sb.append(String.format(Locale.US, "Build time: %s\n", Long.valueOf(Build.TIME)));
            sb.append(String.format(Locale.US, "Build version incremental: %s\n", Build.VERSION.INCREMENTAL));
        }
        Locale locale2 = Locale.US;
        Object[] objArr2 = new Object[1];
        objArr2[0] = TextUtils.isEmpty(eVarA.b) ? AbstractJsonLexerKt.NULL : eVarA.b;
        sb.append(String.format(locale2, "Activity: %s\n", objArr2));
        return sb.toString();
    }

    static String b() {
        String canonicalPath;
        StringBuilder sb = new StringBuilder();
        try {
            File[] fileArrListFiles = new File("/proc/self/fd").listFiles(new FilenameFilter() { // from class: com.umeng.crash.m.1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    return TextUtils.isDigitsOnly(str);
                }
            });
            if (fileArrListFiles != null) {
                sb.append("opened file count: ").append(fileArrListFiles.length).append(", write limit: 0\n");
                sb.append("opened files:\n");
                for (File file : fileArrListFiles) {
                    try {
                        canonicalPath = Os.readlink(file.getAbsolutePath());
                    } catch (Throwable unused) {
                        canonicalPath = null;
                    }
                    try {
                        if (TextUtils.isEmpty(canonicalPath)) {
                            canonicalPath = file.getCanonicalPath();
                        }
                    } catch (Exception unused2) {
                    }
                    sb.append(file.getName()).append(" -> ").append(TextUtils.isEmpty(canonicalPath) ? "" : canonicalPath.trim()).append('\n');
                }
            }
        } catch (Throwable unused3) {
        }
        sb.append('\n');
        return sb.toString();
    }

    static String c() throws Throwable {
        int iMyPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        sb.append("logcat:\n");
        c cVarA = c.a();
        if (cVarA.l > 0) {
            a(iMyPid, sb, "main", cVarA.l, 'D');
        }
        if (cVarA.m > 0) {
            a(iMyPid, sb, "system", cVarA.m, 'W');
        }
        if (cVarA.n > 0) {
            a(iMyPid, sb, com.umeng.analytics.pro.g.ax, cVarA.n, 'I');
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.Closeable] */
    private static void a(int i, StringBuilder sb, String str, int i2, char c) throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        Exception e;
        String string = Integer.toString(i);
        String str2 = " " + string + " ";
        ArrayList arrayList = new ArrayList();
        arrayList.add("/system/bin/logcat");
        arrayList.add("-b");
        arrayList.add(str);
        arrayList.add("-d");
        arrayList.add("-v");
        arrayList.add("threadtime");
        arrayList.add("-t");
        arrayList.add(Integer.toString(i2));
        arrayList.add("--pid");
        arrayList.add(string);
        arrayList.add("*:".concat(String.valueOf(c)));
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder(new String[0]).command(arrayList).start().getInputStream()));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line).append("\n");
                        } else {
                            k.a(bufferedReader);
                            return;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        UCrash.a().a("UCrash.Utils", "get logcat failed", e);
                        k.a(bufferedReader);
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                k.a((Closeable) i2);
                throw th;
            }
        } catch (Exception e3) {
            bufferedReader = null;
            e = e3;
        } catch (Throwable th3) {
            i2 = 0;
            th = th3;
            k.a((Closeable) i2);
            throw th;
        }
    }

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static boolean d() {
        return "1".equals(a("debug.umeng.apm", "0"));
    }

    private static String[] o() {
        String[] strArr = {"UNKNOWN", "0"};
        try {
            if (ControllerCenter.getGlobalEnvStruct().getCustomController() != null && !ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseSystemVersion()) {
                return strArr;
            }
            strArr[0] = Build.VERSION.RELEASE;
            strArr[1] = new StringBuilder().append(Build.VERSION.SDK_INT).toString();
        } catch (Throwable unused) {
        }
        return strArr;
    }

    private static String p() {
        String strA;
        if (ControllerCenter.getGlobalEnvStruct().getCustomController() != null && !ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseDeviceModel()) {
            return "UNKNOWN";
        }
        if (!TextUtils.isEmpty(a("ro.miui.ui.version.name", ""))) {
            try {
                strA = a("ro.product.marketname", "");
                try {
                    if (TextUtils.isEmpty(strA)) {
                        strA = a("ro.product.model", "");
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                strA = "";
            }
        } else {
            strA = null;
        }
        if (TextUtils.isEmpty(strA)) {
            strA = Build.MODEL;
        }
        return strA == null ? "" : strA;
    }

    public static String e() {
        try {
            StringBuilder sb = new StringBuilder("memory info:\nJavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024).append(" kB\nJavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024).append(" kB\nJavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024).append(" kB\nNativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024).append(" kB\nNativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024).append(" kB\nNativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024).append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) UMGlobalContext.getAppContext().getSystemService(TTDownloadField.TT_ACTIVITY);
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ").append(memoryInfo.availMem / 1024).append(" kB\n");
                    sb.append("threshold:  ").append(memoryInfo.threshold / 1024).append(" kB\n");
                    sb.append("lowMemory:  ").append(memoryInfo.lowMemory);
                }
            } catch (Throwable unused) {
            }
            sb.append("\n");
            return sb.toString();
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static String q() {
        String str;
        String str2;
        BufferedReader bufferedReader = null;
        String str3 = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"), 512);
            int i = 0;
            str2 = null;
            do {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    String strTrim = line.substring(line.indexOf(":") + 1).trim();
                    if (line.startsWith("Hardware")) {
                        i++;
                        str3 = strTrim;
                    } else if (line.startsWith("Processor")) {
                        i++;
                        str2 = strTrim;
                    }
                } catch (Throwable unused) {
                    str = str3;
                    bufferedReader = bufferedReader2;
                    k.a(bufferedReader);
                    str3 = str;
                }
            } while (i < 2);
            k.a(bufferedReader2);
        } catch (Throwable unused2) {
            str = null;
            str2 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            try {
                str3 = Build.HARDWARE;
            } catch (Throwable unused3) {
            }
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "-";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "-";
        }
        return "processor: " + str2 + "/hardware: " + str3;
    }

    static String f() {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder("meminfo:\n");
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 1024);
            int i = 0;
            do {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line.trim()).append("\n");
                    i++;
                } catch (Throwable unused) {
                }
            } while (i < 500);
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        k.a(bufferedReader);
        sb.append("\n");
        return sb.toString();
    }

    static String g() {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder("limits:\n");
        try {
            int i = 0;
            bufferedReader = new BufferedReader(new FileReader(String.format(Locale.US, "/proc/%d/limits", Integer.valueOf(Process.myPid()))), 1024);
            do {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line.trim()).append("\n");
                    i++;
                } catch (Throwable unused) {
                }
            } while (i < 100);
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        k.a(bufferedReader);
        sb.append("\n");
        return sb.toString();
    }

    static String h() {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder("status:\n");
        try {
            int i = 0;
            bufferedReader = new BufferedReader(new FileReader(String.format(Locale.US, "/proc/%d/status", Integer.valueOf(Process.myPid()))), 1024);
            do {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line.trim()).append("\n");
                    i++;
                } catch (Throwable unused) {
                }
            } while (i < 200);
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        k.a(bufferedReader);
        sb.append("\n");
        return sb.toString();
    }

    private static String r() {
        FileInputStream fileInputStream;
        String str;
        String str2 = null;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(UMGlobalContext.getAppContext().getFilesDir().getParent(), "crashsdk/tags");
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "unique");
            if (file2.exists()) {
                try {
                    fileInputStream = new FileInputStream(file2);
                    try {
                        byte[] bArr = new byte[48];
                        int i = fileInputStream.read(bArr);
                        if (i > 0) {
                            str = new String(bArr, 0, i);
                            try {
                                k.a(fileInputStream);
                            } catch (Throwable unused) {
                                str2 = str;
                                return str2;
                            }
                        } else {
                            k.a(fileInputStream);
                            return null;
                        }
                    } catch (Throwable unused2) {
                        k.a(fileInputStream);
                        str = null;
                    }
                } catch (Throwable unused3) {
                    fileInputStream = null;
                }
            } else {
                str = null;
            }
            if (str != null) {
                str = str.length() != 36 ? null : str.replaceAll("[^0-9a-zA-Z-]", "-");
            }
            if (str != null && !str.trim().isEmpty()) {
                return str;
            }
            String string = UUID.randomUUID().toString();
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream2.write(string.getBytes());
                    fileOutputStream2.flush();
                    k.a((Closeable) fileOutputStream2);
                    return string;
                } catch (Throwable unused4) {
                    fileOutputStream = fileOutputStream2;
                    k.a((Closeable) fileOutputStream);
                    return string;
                }
            } catch (Throwable unused5) {
            }
        } catch (Throwable unused6) {
        }
    }

    static String i() {
        StringBuilder sb = new StringBuilder("um_app_key: ");
        Map<String, String> mapB = c.a().b();
        String strRemove = mapB.remove(UMCrash.KEY_HEADER_APPKEY);
        if (TextUtils.isEmpty(strRemove)) {
            strRemove = UMUtils.getAppkey(UMGlobalContext.getAppContext());
        }
        sb.append(strRemove).append("\n");
        for (Map.Entry<String, String> entry : mapB.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                sb.append(key).append(": ").append(value).append("\n");
            }
        }
        return sb.toString();
    }

    static String j() {
        int i;
        try {
            Intent intentRegisterReceiver = UMGlobalContext.getAppContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                return "null\n";
            }
            int intExtra = intentRegisterReceiver.getIntExtra("level", -1);
            int intExtra2 = intentRegisterReceiver.getIntExtra("voltage", -1);
            int intExtra3 = intentRegisterReceiver.getIntExtra("temperature", -1);
            int intExtra4 = intentRegisterReceiver.getIntExtra("status", -1);
            int i2 = 0;
            if (intExtra4 == 1) {
                i = -1;
            } else if (intExtra4 == 2) {
                i = 1;
            } else {
                i = intExtra4 == 5 ? 2 : 0;
            }
            int intExtra5 = intentRegisterReceiver.getIntExtra("plugged", -1);
            if (intExtra5 == 1) {
                i2 = 1;
            } else if (intExtra5 == 2) {
                i2 = 2;
            }
            return "battery info:\nlevel: " + intExtra + "\nscale: " + intentRegisterReceiver.getIntExtra("scale", -1) + "\nhealth: " + intentRegisterReceiver.getIntExtra("health", -1) + "\npluged: " + i2 + "\nstatus: " + i + "\nvoltage: " + intExtra2 + "\ntemperature: " + intExtra3 + "\ntechnology: " + intentRegisterReceiver.getStringExtra("technology") + "\n";
        } catch (Throwable th) {
            UCrash.a().a("UCrash.Utils", "getBatteryInfo", th);
            return "null\n";
        }
    }

    static String k() {
        try {
            return c(UMGlobalContext.getAppContext().getFilesDir().getParent());
        } catch (Throwable th) {
            UCrash.a().a("UCrash.Utils", "getDiskInfo", th);
            return "\n";
        }
    }

    private static String c(String str) {
        try {
            StatFs statFs = new StatFs(str);
            long blockSizeLong = statFs.getBlockSizeLong();
            long blockCountLong = statFs.getBlockCountLong() * blockSizeLong;
            long availableBlocksLong = statFs.getAvailableBlocksLong() * blockSizeLong;
            long freeBlocksLong = (ControllerCenter.getGlobalEnvStruct().getCustomController() == null || ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseRemainingStorageSpace()) ? statFs.getFreeBlocksLong() * blockSizeLong : -1L;
            return "disk info:\n" + str + ":\n  total:      " + (blockCountLong / 1024) + " kB\n  available:  " + (availableBlocksLong / 1024) + " kB\n  free:       " + (freeBlocksLong == -1 ? AbstractJsonLexerKt.NULL : Long.valueOf(freeBlocksLong / 1024)) + " kB\n  block size: " + blockSizeLong + " B\n";
        } catch (Throwable th) {
            UCrash.a().a("UCrash.Utils", "getDiskInfoImpl", th);
            return "\n";
        }
    }

    public static String l() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return mainLooper.getThread().getName();
        }
        return null;
    }

    public static String m() {
        return String.format(Locale.US, "device status:\nhas root: %s\nbuild tags: %s\n", Boolean.valueOf(n()), Build.TAGS);
    }

    public static String a(boolean z) {
        return String.format(Locale.US, "recent status:\nlast version: '%s'\ndumping all threads: %s\n", c.a().d, Boolean.valueOf(z));
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder("java stacktrace:\n");
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            if (TextUtils.equals(str, entry.getKey().getName())) {
                StackTraceElement[] value = entry.getValue();
                for (StackTraceElement stackTraceElement : value) {
                    sb.append("\tat ").append(stackTraceElement.toString()).append("\n");
                }
                break;
            }
        }
        return sb.toString();
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            if (!TextUtils.equals(str, key.getName()) && value != null && value.length != 0) {
                sb.append("--- --- --- ---\ntid: ");
                sb.append(key.getId()).append(", name: ").append(key.getName()).append("\njava stacktrace:\n");
                for (StackTraceElement stackTraceElement : value) {
                    sb.append("\tat ").append(stackTraceElement.toString()).append("\n");
                }
            }
        }
        return sb.toString();
    }
}
