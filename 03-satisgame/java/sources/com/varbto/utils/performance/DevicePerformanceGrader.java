package com.varbto.utils.performance;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.anythink.core.common.d.s;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.varbto.internal.d;
import com.varbto.internal.f;
import com.varbto.internal.k;
import com.varbto.utils.api.OnStaticScoreReadyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class DevicePerformanceGrader {
    public static volatile k i;
    public final Context a;
    public volatile PerformanceData c;
    public volatile HashMap d;
    public volatile ExecutorService h;
    public final Object e = new Object();
    public final Object f = new Object();
    public final Handler g = new Handler(Looper.getMainLooper());
    public final b b = new b(this);

    public static class AdvancedHardwareInfo {
        public int bigCoreCount;
        public float cpuTemperature = Float.NaN;
        public String eglVersion;
        public String glVersion;
        public boolean hasBigLittleArch;
        public boolean isGLES30Supported;
        public int littleCoreCount;
        public long storageSpeedMBps;
        public String supportedABIs;
        public float sustainedFps;
        public int thermalStatus;
    }

    public static class GradingResult {
        public PerformanceData data;
        public String report;
    }

    public static class PerformanceData {
        public AdvancedHardwareInfo advancedInfo;
        public int cpuCores;
        public float cpuMaxFreqMHz;
        public int cpuScore;
        public float cpuUsage;
        public String gpuModel;
        public int gpuScore;
        public int memoryScore;
        public long memoryUsage;
        public int resolutionScore;
        public long totalMemory;
        public int totalScore;
    }

    public interface PerformanceMonitorCallback {
        void onCpuUpdate(float f, float f2);

        void onGpuUpdate(float f);

        void onMemoryUpdate(float f);

        void onThermalUpdate(int i);
    }

    public DevicePerformanceGrader(Context context) {
        this.a = context;
        if (f.a) {
            Log.d("DevicePerformanceGrader", "DevicePerformanceGrader initialized");
        }
    }

    public static /* synthetic */ void a(OnStaticScoreReadyListener onStaticScoreReadyListener, int i2) {
        if (onStaticScoreReadyListener != null) {
            onStaticScoreReadyListener.onScoreReady(i2);
        }
    }

    public static k d() {
        if (i == null) {
            synchronized (DevicePerformanceGrader.class) {
                if (i == null) {
                    i = a();
                }
            }
        }
        return i;
    }

    public final /* synthetic */ void b(final OnStaticScoreReadyListener onStaticScoreReadyListener) {
        try {
            synchronized (this.f) {
                if (this.c == null) {
                    PerformanceData performanceData = new PerformanceData();
                    performanceData.advancedInfo = new AdvancedHardwareInfo();
                    c(performanceData);
                    a(performanceData);
                    this.c = performanceData;
                }
            }
            final int i2 = this.c != null ? this.c.totalScore : 0;
            this.g.post(new Runnable() { // from class: com.varbto.utils.performance.DevicePerformanceGrader$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    DevicePerformanceGrader.a(onStaticScoreReadyListener, i2);
                }
            });
        } catch (Throwable th) {
            if (f.a) {
                Log.e("DevicePerformanceGrader", "requestStaticScoreAsync failed", th);
            }
            this.g.post(new Runnable() { // from class: com.varbto.utils.performance.DevicePerformanceGrader$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    DevicePerformanceGrader.a(onStaticScoreReadyListener);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:171:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:174:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:192:0x0437  */
    /* JADX WARN: Code duplicated, block: B:200:0x0460 A[Catch: all -> 0x0492, TRY_LEAVE, TryCatch #2 {all -> 0x0492, blocks: (B:198:0x0442, B:200:0x0460), top: B:257:0x0442 }] */
    /* JADX WARN: Code duplicated, block: B:219:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:234:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:236:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:240:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:244:0x050c  */
    /* JADX WARN: Code duplicated, block: B:247:0x053c  */
    /* JADX WARN: Code duplicated, block: B:250:0x0569  */
    /* JADX WARN: Code duplicated, block: B:26:0x00e3 A[PHI: r9
      0x00e3: PHI (r9v35 java.lang.String) = (r9v6 java.lang.String), (r9v4 java.lang.String) binds: [B:39:0x0128, B:25:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:273:0x0490 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:283:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x017d  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c(PerformanceData performanceData) {
        long j;
        Object obj;
        int i2;
        int i3;
        int i4;
        CharSequence charSequence;
        CharSequence charSequence2;
        Display defaultDisplay;
        Display.HdrCapabilities hdrCapabilities;
        int[] supportedHdrTypes;
        double dNanoTime;
        AdvancedHardwareInfo advancedHardwareInfo;
        double dNanoTime2;
        k kVarD;
        double dNanoTime3;
        double dNanoTime4;
        double dNanoTime5;
        String lowerCase;
        String lowerCase2;
        String str;
        String str2;
        String str3;
        Method method;
        String[] strArr;
        int i5;
        String str4;
        boolean z;
        boolean z2;
        String str5;
        String str6;
        Display defaultDisplay2;
        String str7;
        long jNanoTime = System.nanoTime();
        long jNanoTime2 = System.nanoTime();
        performanceData.cpuCores = Runtime.getRuntime().availableProcessors();
        double dNanoTime6 = (System.nanoTime() - jNanoTime2) / 1000000.0d;
        if (f.a) {
            Log.i("PerfBench", String.format("[Static] cpuCores=%d 耗时=%.2fms", Integer.valueOf(performanceData.cpuCores), Double.valueOf(dNanoTime6)));
        }
        long jNanoTime3 = System.nanoTime();
        b(performanceData);
        double dNanoTime7 = (System.nanoTime() - jNanoTime3) / 1000000.0d;
        if (f.a) {
            Log.i("PerfBench", String.format("[Static] collectCpuFreqInfo(合并cpuMaxFreq+大小核,1遍读) cpuMaxFreq=%.0fMHz hasBigLittle=%b bigCore=%d 耗时=%.2fms", Float.valueOf(performanceData.cpuMaxFreqMHz), Boolean.valueOf(performanceData.advancedInfo.hasBigLittleArch), Integer.valueOf(performanceData.advancedInfo.bigCoreCount), Double.valueOf(dNanoTime7)));
        }
        long jNanoTime4 = System.nanoTime();
        long jNanoTime5 = System.nanoTime();
        k kVarD2 = d();
        String property = (kVarD2 == null || (str7 = kVarD2.a) == null || str7.isEmpty()) ? null : kVarD2.a;
        double dNanoTime8 = (System.nanoTime() - jNanoTime5) / 1000000.0d;
        boolean z3 = f.a;
        String str8 = AbstractJsonLexerKt.NULL;
        if (z3) {
            Log.i("PerfBench", String.format("[GPU] getGPUByOpenGL=%s 耗时=%.2fms", property != null ? property : AbstractJsonLexerKt.NULL, Double.valueOf(dNanoTime8)));
        }
        if (property == null || property.equals("Unknown GPU")) {
            long jNanoTime6 = System.nanoTime();
            try {
                property = System.getProperty("ro.hardware.gpu");
            } catch (Throwable unused) {
                property = null;
            }
            double dNanoTime9 = (System.nanoTime() - jNanoTime6) / 1000000.0d;
            if (f.a) {
                if (property != null) {
                    str8 = property;
                }
                Log.i("PerfBench", String.format("[GPU] getGPUBySystemProperty=%s 耗时=%.2fms", str8, Double.valueOf(dNanoTime9)));
            }
            Object obj2 = "Unknown GPU";
            if (property == null || property.equals(obj2)) {
                long jNanoTime7 = System.nanoTime();
                String str9 = Build.MODEL;
                Locale locale = Locale.US;
                String lowerCase3 = str9.toLowerCase(locale);
                String lowerCase4 = Build.MANUFACTURER.toLowerCase(locale);
                if (lowerCase4.contains("qualcomm") || lowerCase3.contains("qcom")) {
                    property = "Adreno GPU";
                } else {
                    if (lowerCase4.contains("samsung")) {
                        if (!lowerCase3.contains("exynos")) {
                            property = "Adreno GPU";
                        }
                    } else if (lowerCase4.contains("mediatek")) {
                        property = "PowerVR GPU";
                    } else if (!lowerCase4.contains("huawei") && !lowerCase4.contains("hi")) {
                        property = obj2;
                    }
                    property = "Mali GPU";
                }
                j = jNanoTime;
                double dNanoTime10 = (System.nanoTime() - jNanoTime7) / 1000000.0d;
                if (f.a) {
                    Log.i("PerfBench", String.format("[GPU] getGPUByDeviceModel=%s 耗时=%.2fms", property, Double.valueOf(dNanoTime10)));
                }
                if (property.equals(obj2)) {
                    long jNanoTime8 = System.nanoTime();
                    try {
                        Method method2 = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
                        String[] strArr2 = {"ro.hardware.gpu", "ro.chipname", "ro.board.platform"};
                        int i6 = 0;
                        while (true) {
                            if (i6 >= 3) {
                                obj = obj2;
                                property = obj;
                                break;
                            }
                            String[] strArr3 = strArr2;
                            obj = obj2;
                            try {
                                String str10 = (String) method2.invoke(null, strArr2[i6]);
                                if (str10 != null && !str10.isEmpty()) {
                                    property = str10;
                                    break;
                                } else {
                                    i6++;
                                    obj2 = obj;
                                    strArr2 = strArr3;
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (f.a) {
                                    Log.e("GPU", "Failed to get GPU info via reflection", th);
                                }
                                property = obj;
                                break;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        obj = obj2;
                    }
                    double dNanoTime11 = (System.nanoTime() - jNanoTime8) / 1000000.0d;
                    if (f.a) {
                        Log.i("PerfBench", String.format("[GPU] getGPUByReflection=%s 耗时=%.2fms", property, Double.valueOf(dNanoTime11)));
                    }
                }
            } else {
                j = jNanoTime;
            }
        } else {
            j = jNanoTime;
        }
        performanceData.gpuModel = property;
        double dNanoTime12 = (System.nanoTime() - jNanoTime4) / 1000000.0d;
        if (f.a) {
            Log.i("PerfBench", String.format("[Static] gpuModel=%s 耗时=%.2fms (含EGL,见[GPU]/[EGL]日志)", performanceData.gpuModel, Double.valueOf(dNanoTime12)));
        }
        long jNanoTime9 = System.nanoTime();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) this.a.getSystemService("activity");
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
        }
        performanceData.totalMemory = memoryInfo.totalMem;
        double dNanoTime13 = (System.nanoTime() - jNanoTime9) / 1000000.0d;
        if (f.a) {
            Log.i("PerfBench", String.format("[Static] totalMemory=%dMB 耗时=%.2fms", Long.valueOf(performanceData.totalMemory >> 20), Double.valueOf(dNanoTime13)));
        }
        long jNanoTime10 = System.nanoTime();
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        int iMax = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        if (iMax >= 3000) {
            i2 = 20;
        } else {
            if (iMax >= 2000) {
                i3 = 16;
            } else if (iMax >= 1500) {
                i3 = 12;
            } else if (iMax >= 1000) {
                i3 = 8;
            } else {
                i2 = 4;
            }
            i2 = i3;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (((windowManager == null || (defaultDisplay2 = windowManager.getDefaultDisplay()) == null) ? 60.0f : defaultDisplay2.getRefreshRate()) >= 120.0f) {
            if (f.a) {
                Log.i("Screen", "High refresh rate screen (120Hz+)");
            }
            i4 = 2;
        } else {
            i4 = 0;
        }
        try {
            Method method3 = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            charSequence = "huawei";
            charSequence2 = "qcom";
            try {
                String[] strArr4 = {"ro.display.type", "ro.vendor.display.type", "ro.product.display", "persist.vendor.sys.isfold"};
                int i7 = 0;
                while (true) {
                    if (i7 >= 4) {
                        if (Build.VERSION.SDK_INT >= 29) {
                            try {
                                WindowManager windowManager2 = (WindowManager) this.a.getSystemService("window");
                                if (windowManager2 != null && (defaultDisplay = windowManager2.getDefaultDisplay()) != null && (hdrCapabilities = defaultDisplay.getHdrCapabilities()) != null && (supportedHdrTypes = hdrCapabilities.getSupportedHdrTypes()) != null) {
                                    int length = supportedHdrTypes.length;
                                    int i8 = 0;
                                    while (true) {
                                        if (i8 < length) {
                                            if (supportedHdrTypes[i8] != 1) {
                                                i8++;
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable unused2) {
                            }
                        }
                        performanceData.resolutionScore = Math.min(i2 + i4, 20);
                        dNanoTime = (System.nanoTime() - jNanoTime10) / 1000000.0d;
                        if (f.a) {
                            Log.i("PerfBench", String.format("[Static] resolutionScore=%d 耗时=%.2fms", Integer.valueOf(performanceData.resolutionScore), Double.valueOf(dNanoTime)));
                        }
                        advancedHardwareInfo = performanceData.advancedInfo;
                        long jNanoTime11 = System.nanoTime();
                        advancedHardwareInfo.supportedABIs = Arrays.toString(Build.SUPPORTED_ABIS);
                        dNanoTime2 = (System.nanoTime() - jNanoTime11) / 1000000.0d;
                        if (f.a) {
                            Log.i("PerfBench", String.format("[Static] supportedABIs=%s 耗时=%.2fms", advancedHardwareInfo.supportedABIs, Double.valueOf(dNanoTime2)));
                        }
                        long jNanoTime12 = System.nanoTime();
                        kVarD = d();
                        if (kVarD != null && (z = kVarD.d)) {
                            advancedHardwareInfo.glVersion = kVarD.b;
                            if (!z && (((str5 = kVarD.c) != null && str5.contains("GL_ES_VERSION_3_0")) || ((str6 = kVarD.b) != null && str6.contains("OpenGL ES 3")))) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            advancedHardwareInfo.isGLES30Supported = z2;
                        }
                        if (advancedHardwareInfo.glVersion == null && advancedHardwareInfo.eglVersion == null) {
                            try {
                                method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
                                strArr = new String[]{"ro.opengles.version", "ro.hardware.egl", "ro.board.platform"};
                                i5 = 0;
                                while (true) {
                                    if (i5 < 3) {
                                        str2 = null;
                                        str3 = str2;
                                        break;
                                    }
                                    str2 = null;
                                    try {
                                        str4 = (String) method.invoke(null, strArr[i5]);
                                        if (str4 == null && !str4.isEmpty()) {
                                            str3 = "OpenGL ES " + str4;
                                            break;
                                        }
                                        i5++;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        Log.w("OpenGL", "Reflection failed", th);
                                        str3 = str2;
                                        break;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                str2 = null;
                            }
                            advancedHardwareInfo.glVersion = str3;
                        }
                        if (advancedHardwareInfo.glVersion == null) {
                            String str11 = Build.MANUFACTURER;
                            Locale locale2 = Locale.US;
                            lowerCase = str11.toLowerCase(locale2);
                            lowerCase2 = Build.MODEL.toLowerCase(locale2);
                            if (!lowerCase.contains("qualcomm") || lowerCase2.contains(charSequence2)) {
                                if (!lowerCase2.contains(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD) || lowerCase2.contains(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD)) {
                                    str = "OpenGL ES 3.2";
                                } else {
                                    str = "OpenGL ES 3.0";
                                }
                            } else if (lowerCase.contains(charSequence) || lowerCase.contains("honor")) {
                                str = lowerCase2.contains("kirin 9") ? "OpenGL ES 3.2" : "OpenGL ES 3.1";
                            } else {
                                str = "OpenGL ES 2.0";
                            }
                            advancedHardwareInfo.glVersion = str;
                            advancedHardwareInfo.isGLES30Supported = true;
                        }
                        dNanoTime3 = (System.nanoTime() - jNanoTime12) / 1000000.0d;
                        if (f.a) {
                            Log.i("PerfBench", String.format("[Static] detectGLVersion(走cachedGLInfo) glVersion=%s 耗时=%.2fms", advancedHardwareInfo.glVersion, Double.valueOf(dNanoTime3)));
                        }
                        long jNanoTime13 = System.nanoTime();
                        advancedHardwareInfo.sustainedFps = 60.0f;
                        dNanoTime4 = (System.nanoTime() - jNanoTime13) / 1000000.0d;
                        if (f.a) {
                            Log.i("PerfBench", String.format("[Static] sustainedFps=%.2f 耗时=%.2fms", Float.valueOf(advancedHardwareInfo.sustainedFps), Double.valueOf(dNanoTime4)));
                        }
                        dNanoTime5 = (System.nanoTime() - j) / 1000000.0d;
                        if (f.a) {
                            Log.i("PerfBench", String.format("[Static] === collectStaticHardwareInfo 总耗时=%.2fms ===", Double.valueOf(dNanoTime5)));
                            return;
                        }
                        return;
                    }
                    String[] strArr5 = strArr4;
                    String str12 = (String) method3.invoke(null, strArr4[i7]);
                    if (str12 == null || !str12.toLowerCase().contains("oled")) {
                        i7++;
                        strArr4 = strArr5;
                    }
                    i4++;
                    if (f.a) {
                        Log.i("Screen", "OLED/AMOLED screen detected");
                    }
                    performanceData.resolutionScore = Math.min(i2 + i4, 20);
                    dNanoTime = (System.nanoTime() - jNanoTime10) / 1000000.0d;
                    if (f.a) {
                        Log.i("PerfBench", String.format("[Static] resolutionScore=%d 耗时=%.2fms", Integer.valueOf(performanceData.resolutionScore), Double.valueOf(dNanoTime)));
                    }
                    advancedHardwareInfo = performanceData.advancedInfo;
                    long jNanoTime14 = System.nanoTime();
                    advancedHardwareInfo.supportedABIs = Arrays.toString(Build.SUPPORTED_ABIS);
                    dNanoTime2 = (System.nanoTime() - jNanoTime14) / 1000000.0d;
                    if (f.a) {
                        Log.i("PerfBench", String.format("[Static] supportedABIs=%s 耗时=%.2fms", advancedHardwareInfo.supportedABIs, Double.valueOf(dNanoTime2)));
                    }
                    long jNanoTime15 = System.nanoTime();
                    kVarD = d();
                    if (kVarD != null) {
                        advancedHardwareInfo.glVersion = kVarD.b;
                        if (z) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        advancedHardwareInfo.isGLES30Supported = z2;
                    }
                    if (advancedHardwareInfo.glVersion == null) {
                        method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
                        strArr = new String[]{"ro.opengles.version", "ro.hardware.egl", "ro.board.platform"};
                        i5 = 0;
                        while (true) {
                            if (i5 < 3) {
                                str2 = null;
                                str3 = str2;
                                break;
                            } else {
                                str2 = null;
                                str4 = (String) method.invoke(null, strArr[i5]);
                                if (str4 == null) {
                                }
                                i5++;
                            }
                        }
                        advancedHardwareInfo.glVersion = str3;
                    }
                    if (advancedHardwareInfo.glVersion == null) {
                        String str13 = Build.MANUFACTURER;
                        Locale locale3 = Locale.US;
                        lowerCase = str13.toLowerCase(locale3);
                        lowerCase2 = Build.MODEL.toLowerCase(locale3);
                        if (lowerCase.contains("qualcomm")) {
                            if (lowerCase2.contains(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD)) {
                                str = "OpenGL ES 3.2";
                            } else {
                                str = "OpenGL ES 3.2";
                            }
                        } else if (lowerCase2.contains(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD)) {
                            str = "OpenGL ES 3.2";
                        } else {
                            str = "OpenGL ES 3.2";
                        }
                        advancedHardwareInfo.glVersion = str;
                        advancedHardwareInfo.isGLES30Supported = true;
                    }
                    dNanoTime3 = (System.nanoTime() - jNanoTime15) / 1000000.0d;
                    if (f.a) {
                        Log.i("PerfBench", String.format("[Static] detectGLVersion(走cachedGLInfo) glVersion=%s 耗时=%.2fms", advancedHardwareInfo.glVersion, Double.valueOf(dNanoTime3)));
                    }
                    long jNanoTime16 = System.nanoTime();
                    advancedHardwareInfo.sustainedFps = 60.0f;
                    dNanoTime4 = (System.nanoTime() - jNanoTime16) / 1000000.0d;
                    if (f.a) {
                        Log.i("PerfBench", String.format("[Static] sustainedFps=%.2f 耗时=%.2fms", Float.valueOf(advancedHardwareInfo.sustainedFps), Double.valueOf(dNanoTime4)));
                    }
                    dNanoTime5 = (System.nanoTime() - j) / 1000000.0d;
                    if (f.a) {
                        Log.i("PerfBench", String.format("[Static] === collectStaticHardwareInfo 总耗时=%.2fms ===", Double.valueOf(dNanoTime5)));
                        return;
                    }
                    return;
                }
            } catch (Throwable th5) {
                th = th5;
                if (f.a) {
                    Log.w("Screen", "Failed to get screen type via reflection", th);
                }
            }
        } catch (Throwable th6) {
            th = th6;
            charSequence = "huawei";
            charSequence2 = "qcom";
        }
    }

    public final ExecutorService e() {
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.h = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.varbto.utils.performance.DevicePerformanceGrader$$ExternalSyntheticLambda1
                        @Override // java.util.concurrent.ThreadFactory
                        public final Thread newThread(Runnable runnable) {
                            return DevicePerformanceGrader.a(runnable);
                        }
                    });
                }
            }
        }
        return this.h;
    }

    public int getDynamicScore() {
        return this.b.b();
    }

    public GradingResult getFullPerformanceReport() {
        String str;
        String str2;
        if (f.a) {
            Log.d("DevicePerformanceGrader", "Getting full performance report");
        }
        if (this.c == null) {
            synchronized (this.f) {
                if (this.c == null) {
                    PerformanceData performanceData = new PerformanceData();
                    performanceData.advancedInfo = new AdvancedHardwareInfo();
                    c(performanceData);
                    this.c = performanceData;
                }
            }
        }
        PerformanceData performanceData2 = this.c;
        performanceData2.cpuUsage = c();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) this.a.getSystemService("activity");
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
        }
        performanceData2.memoryUsage = memoryInfo.totalMem - memoryInfo.availMem;
        AdvancedHardwareInfo advancedHardwareInfo = performanceData2.advancedInfo;
        advancedHardwareInfo.cpuTemperature = b();
        if (Build.VERSION.SDK_INT >= 29) {
            advancedHardwareInfo.thermalStatus = ((PowerManager) this.a.getSystemService("power")).getCurrentThermalStatus();
        }
        a(this.c);
        GradingResult gradingResult = new GradingResult();
        gradingResult.data = this.c;
        PerformanceData performanceData3 = this.c;
        float f = (performanceData3.memoryUsage * 100.0f) / performanceData3.totalMemory;
        AdvancedHardwareInfo advancedHardwareInfo2 = performanceData3.advancedInfo;
        StringBuilder sb = new StringBuilder("=== 设备性能评分报告 ===\n");
        StringBuilder sbAppend = sb.append(String.format(Locale.getDefault(), "CPU评分: %d/30 (核心数: %d, 最大频率: %.1fMHz, 使用率: %.1f%%)\n", Integer.valueOf(performanceData3.cpuScore), Integer.valueOf(performanceData3.cpuCores), Float.valueOf(performanceData3.cpuMaxFreqMHz), Float.valueOf(performanceData3.cpuUsage))).append(String.format("GPU评分: %d/30 (型号: %s)\n", Integer.valueOf(performanceData3.gpuScore), performanceData3.gpuModel)).append(String.format("内存评分: %d/20 (使用量: %dMB/总内存: %dMB, 使用率: %.1f%%)\n", Integer.valueOf(performanceData3.memoryScore), Long.valueOf(performanceData3.memoryUsage / 1048576), Long.valueOf(performanceData3.totalMemory / 1048576), Float.valueOf(f))).append(String.format("分辨率评分: %d/20\n", Integer.valueOf(performanceData3.resolutionScore))).append("\n=== 高级硬件信息 ===\n").append("ABI支持: " + advancedHardwareInfo2.supportedABIs + "\n");
        String str3 = advancedHardwareInfo2.glVersion;
        if (str3 == null) {
            str3 = "未知";
        }
        StringBuilder sbAppend2 = sbAppend.append("OpenGL版本: " + str3 + "\n");
        String str4 = advancedHardwareInfo2.eglVersion;
        if (str4 == null) {
            str4 = "未知";
        }
        sbAppend2.append("EGL版本: " + str4 + "\n").append("支持GLES3.0+: " + advancedHardwareInfo2.isGLES30Supported + "\n").append(String.format("存储速度: %d MB/s\n", Long.valueOf(advancedHardwareInfo2.storageSpeedMBps))).append(String.format("可持续帧率: %.1f FPS\n", Float.valueOf(advancedHardwareInfo2.sustainedFps)));
        if (!Float.isNaN(advancedHardwareInfo2.cpuTemperature)) {
            sb.append(String.format("CPU温度: %.1f°C\n", Float.valueOf(advancedHardwareInfo2.cpuTemperature)));
        }
        sb.append("大小核架构: " + (advancedHardwareInfo2.hasBigLittleArch ? "是" : "否") + "\n");
        if (advancedHardwareInfo2.hasBigLittleArch) {
            sb.append(String.format("大核数量: %d (高性能核心)\n", Integer.valueOf(advancedHardwareInfo2.bigCoreCount))).append(String.format("小核数量: %d (高能效核心)\n", Integer.valueOf(advancedHardwareInfo2.littleCoreCount)));
        }
        StringBuilder sbAppend3 = sb.append("\n----------------------\n").append(String.format("总分: %d/100\n", Integer.valueOf(performanceData3.totalScore)));
        int i2 = performanceData3.totalScore;
        if (i2 >= 80) {
            str = "旗舰级";
        } else if (i2 >= 60) {
            str = "高端";
        } else {
            str = i2 >= 40 ? "中端" : "低端";
        }
        StringBuilder sbAppend4 = sbAppend3.append("设备等级: " + str + "\n");
        int i3 = performanceData3.totalScore;
        if (i3 >= 80) {
            str2 = "可以启用所有高级图形特效，包括高清纹理、复杂着色器、后处理效果等";
        } else if (i3 >= 60) {
            str2 = "建议启用部分特效，但降低抗锯齿等级或阴影质量";
        } else {
            str2 = i3 >= 40 ? "建议使用中等画质设置，禁用抗锯齿和部分后处理效果" : "建议使用最低画质设置，禁用所有非必要特效";
        }
        sbAppend4.append("优化建议: ".concat(str2));
        gradingResult.report = sb.toString();
        if (f.a) {
            Log.d("DevicePerformanceGrader", "Performance report generated, total score: " + gradingResult.data.totalScore);
        }
        return gradingResult;
    }

    public b getMonitor() {
        return this.b;
    }

    public Map<String, Object> getStaticPerformanceDataMap() {
        if (this.c == null) {
            synchronized (this.f) {
                if (this.c == null) {
                    PerformanceData performanceData = new PerformanceData();
                    performanceData.advancedInfo = new AdvancedHardwareInfo();
                    c(performanceData);
                    a(performanceData);
                    this.c = performanceData;
                }
            }
        }
        if (this.d == null) {
            synchronized (this.e) {
                if (this.d == null) {
                    HashMap map = new HashMap();
                    map.put("cpu_cores", Integer.valueOf(this.c.cpuCores));
                    map.put("cpu_max_freq_mhz", Float.valueOf(this.c.cpuMaxFreqMHz));
                    map.put("cpu_score", Integer.valueOf(this.c.cpuScore));
                    map.put("gpu_model", this.c.gpuModel != null ? this.c.gpuModel : "");
                    map.put("gpu_score", Integer.valueOf(this.c.gpuScore));
                    map.put("total_memory", Long.valueOf(this.c.totalMemory));
                    map.put("memory_score", Integer.valueOf(this.c.memoryScore));
                    map.put("resolution_score", Integer.valueOf(this.c.resolutionScore));
                    map.put(s.k, Integer.valueOf(this.c.totalScore));
                    AdvancedHardwareInfo advancedHardwareInfo = this.c.advancedInfo;
                    String str = advancedHardwareInfo.supportedABIs;
                    if (str == null) {
                        str = "";
                    }
                    map.put("supported_abis", str);
                    String str2 = advancedHardwareInfo.glVersion;
                    if (str2 == null) {
                        str2 = "";
                    }
                    map.put("gl_version", str2);
                    String str3 = advancedHardwareInfo.eglVersion;
                    if (str3 == null) {
                        str3 = "";
                    }
                    map.put("egl_version", str3);
                    map.put("is_gles30_supported", Boolean.valueOf(advancedHardwareInfo.isGLES30Supported));
                    map.put("sustained_fps", Float.valueOf(advancedHardwareInfo.sustainedFps));
                    map.put("storage_speed_mbps", Long.valueOf(advancedHardwareInfo.storageSpeedMBps));
                    map.put("has_big_little_arch", Boolean.valueOf(advancedHardwareInfo.hasBigLittleArch));
                    map.put("big_core_count", Integer.valueOf(advancedHardwareInfo.bigCoreCount));
                    map.put("little_core_count", Integer.valueOf(advancedHardwareInfo.littleCoreCount));
                    this.d = map;
                    if (f.a) {
                        Log.d("DevicePerformanceGrader", "getStaticPerformanceDataMap: static map created, total=" + this.c.totalScore);
                    }
                }
            }
        }
        b bVar = this.b;
        float f = bVar != null ? bVar.g : 0.0f;
        b bVar2 = this.b;
        float f2 = bVar2 != null ? bVar2.h : 0.0f;
        b bVar3 = this.b;
        int i2 = bVar3 != null ? bVar3.i : 0;
        long j = this.c != null ? this.c.totalMemory : 0L;
        synchronized (this.e) {
            this.d.put("c_ra", Float.valueOf(f));
            this.d.put("memory_usage", Long.valueOf((long) (j * f2)));
            this.d.put("mem_ra", Float.valueOf(100.0f * f2));
            this.d.put("thermal_status", Integer.valueOf(i2));
        }
        if (f.a) {
            Log.d("DevicePerformanceGrader", "getStaticPerformanceDataMap: cpu_usage=" + f + " mem_ratio=" + f2 + " thermal=" + i2);
        }
        return this.d;
    }

    public int getTotalScore() {
        if (this.c == null) {
            synchronized (this.f) {
                if (this.c == null) {
                    PerformanceData performanceData = new PerformanceData();
                    performanceData.advancedInfo = new AdvancedHardwareInfo();
                    c(performanceData);
                    a(performanceData);
                    this.c = performanceData;
                }
            }
        }
        if (f.a) {
            Log.d("DevicePerformanceGrader", "getTotalScore: " + this.c.totalScore);
        }
        return this.c.totalScore;
    }

    public boolean isHighConsumption() {
        int i2;
        b bVar = this.b;
        bVar.getClass();
        if (System.currentTimeMillis() >= bVar.e && !bVar.c()) {
            if (!bVar.d && System.currentTimeMillis() - bVar.f > 1000 && Looper.myLooper() != Looper.getMainLooper()) {
                bVar.d();
            }
            int iA = b.a(bVar.g);
            int iB = b.b(bVar.h);
            switch (bVar.i) {
                case 1:
                    i2 = 80;
                    break;
                case 2:
                    i2 = 50;
                    break;
                case 3:
                    i2 = 25;
                    break;
                case 4:
                    i2 = 10;
                    break;
                case 5:
                    i2 = 5;
                    break;
                case 6:
                    i2 = 0;
                    break;
                default:
                    i2 = 100;
                    break;
            }
            if (iA > bVar.k && iB > bVar.k && i2 > bVar.k) {
                return false;
            }
        }
        return true;
    }

    public void requestStaticScoreAsync(final OnStaticScoreReadyListener onStaticScoreReadyListener) {
        e().execute(new Runnable() { // from class: com.varbto.utils.performance.DevicePerformanceGrader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(onStaticScoreReadyListener);
            }
        });
    }

    public void startMonitoring(PerformanceMonitorCallback performanceMonitorCallback, long j) {
        b bVar = this.b;
        if (bVar.d) {
            if (f.a) {
                Log.d("PerformanceMonitor", "Already monitoring, skipping");
            }
        } else {
            if (f.a) {
                Log.d("PerformanceMonitor", "Starting performance monitoring");
            }
            bVar.d = true;
            bVar.a().post(new a(bVar, performanceMonitorCallback, j));
        }
    }

    public void stopMonitoring() {
        b bVar = this.b;
        if (f.a) {
            bVar.getClass();
            Log.d("PerformanceMonitor", "Stopping performance monitoring");
        }
        bVar.d = false;
        if (bVar.b != null) {
            bVar.b.removeCallbacksAndMessages(null);
        }
    }

    public static /* synthetic */ void a(OnStaticScoreReadyListener onStaticScoreReadyListener) {
        if (onStaticScoreReadyListener != null) {
            onStaticScoreReadyListener.onScoreReady(0);
        }
    }

    public static /* synthetic */ Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "perf-score-collect");
        thread.setDaemon(true);
        return thread;
    }

    public static k a() {
        String str;
        double d;
        EGLDisplay eGLDisplay;
        double dNanoTime;
        double d2;
        double d3;
        double dNanoTime2;
        double dNanoTime3;
        double dNanoTime4;
        double dNanoTime5;
        k kVar = new k();
        long jNanoTime = System.nanoTime();
        try {
            long jNanoTime2 = System.nanoTime();
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            double dNanoTime6 = (System.nanoTime() - jNanoTime2) / 1000000.0d;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                if (f.a) {
                    Log.i("PerfBench", String.format("[EGL] eglGetDisplay 失败 耗时=%.2fms", Double.valueOf(dNanoTime6)));
                }
                return kVar;
            }
            long jNanoTime3 = System.nanoTime();
            if (!egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                double dNanoTime7 = (System.nanoTime() - jNanoTime3) / 1000000.0d;
                if (f.a) {
                    Log.i("PerfBench", String.format("[EGL] eglInitialize 失败 耗时=%.2fms", Double.valueOf(dNanoTime7)));
                }
                return kVar;
            }
            double dNanoTime8 = (System.nanoTime() - jNanoTime3) / 1000000.0d;
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr = new int[1];
            long jNanoTime4 = System.nanoTime();
            egl10.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344}, eGLConfigArr, 1, iArr);
            if (iArr[0] == 0) {
                egl10.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12339, 1, 12344}, eGLConfigArr, 1, iArr);
            }
            double dNanoTime9 = (System.nanoTime() - jNanoTime4) / 1000000.0d;
            if (iArr[0] > 0) {
                EGLConfig eGLConfig = eGLConfigArr[0];
                long jNanoTime5 = System.nanoTime();
                EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
                eGLDisplay = eGLDisplayEglGetDisplay;
                EGLContext eGLContextEglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{12440, 2, 12344});
                d = dNanoTime6;
                double dNanoTime10 = (System.nanoTime() - jNanoTime5) / 1000000.0d;
                long jNanoTime6 = System.nanoTime();
                EGLSurface eGLSurfaceEglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, 1, 12374, 1, 12344});
                dNanoTime4 = (System.nanoTime() - jNanoTime6) / 1000000.0d;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                if (eGLSurfaceEglCreatePbufferSurface == eGLSurface || eGLContextEglCreateContext == eGLContext) {
                    dNanoTime4 = dNanoTime4;
                    d3 = dNanoTime10;
                    dNanoTime = 0.0d;
                    d2 = 0.0d;
                    dNanoTime2 = 0.0d;
                    dNanoTime3 = 0.0d;
                } else {
                    long jNanoTime7 = System.nanoTime();
                    if (egl10.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext)) {
                        double dNanoTime11 = (System.nanoTime() - jNanoTime7) / 1000000.0d;
                        long jNanoTime8 = System.nanoTime();
                        dNanoTime3 = dNanoTime11;
                        kVar.a = GLES20.glGetString(7937);
                        kVar.b = GLES20.glGetString(7938);
                        kVar.c = GLES20.glGetString(7939);
                        dNanoTime5 = (System.nanoTime() - jNanoTime8) / 1000000.0d;
                        kVar.d = true;
                        long jNanoTime9 = System.nanoTime();
                        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
                        dNanoTime = (System.nanoTime() - jNanoTime9) / 1000000.0d;
                    } else {
                        dNanoTime3 = (System.nanoTime() - jNanoTime7) / 1000000.0d;
                        if (f.a) {
                            Log.i("PerfBench", String.format("[EGL] eglMakeCurrent 失败 耗时=%.2fms", Double.valueOf(dNanoTime3)));
                        }
                        dNanoTime = 0.0d;
                        dNanoTime5 = 0.0d;
                    }
                    long jNanoTime10 = System.nanoTime();
                    egl10.eglDestroySurface(eGLDisplay, eGLSurfaceEglCreatePbufferSurface);
                    egl10.eglDestroyContext(eGLDisplay, eGLContextEglCreateContext);
                    d2 = dNanoTime5;
                    dNanoTime2 = (System.nanoTime() - jNanoTime10) / 1000000.0d;
                    d3 = dNanoTime10;
                }
            } else {
                d = dNanoTime6;
                eGLDisplay = eGLDisplayEglGetDisplay;
                dNanoTime = 0.0d;
                d2 = 0.0d;
                d3 = 0.0d;
                dNanoTime2 = 0.0d;
                dNanoTime3 = 0.0d;
                dNanoTime4 = 0.0d;
            }
            long jNanoTime11 = System.nanoTime();
            egl10.eglTerminate(eGLDisplay);
            double dNanoTime12 = ((System.nanoTime() - jNanoTime11) / 1000000.0d) + dNanoTime2;
            str = "PerfBench";
            double dNanoTime13 = (System.nanoTime() - jNanoTime) / 1000000.0d;
            try {
                if (f.a) {
                    Double dValueOf = Double.valueOf(d);
                    Double dValueOf2 = Double.valueOf(dNanoTime8);
                    Double dValueOf3 = Double.valueOf(dNanoTime9);
                    Double dValueOf4 = Double.valueOf(d3);
                    Double dValueOf5 = Double.valueOf(dNanoTime4);
                    Double dValueOf6 = Double.valueOf(dNanoTime3);
                    Double dValueOf7 = Double.valueOf(d2);
                    Double dValueOf8 = Double.valueOf(dNanoTime);
                    Double dValueOf9 = Double.valueOf(dNanoTime12);
                    String str2 = kVar.a;
                    if (str2 == null) {
                        str2 = AbstractJsonLexerKt.NULL;
                    }
                    Log.i(str, String.format("[EGL] getDisplay=%.2f init=%.2f chooseConfig=%.2f createContext=%.2f createSurface=%.2f makeCurrent=%.2f glGetString=%.2f unmake=%.2f destroyTerm=%.2f | renderer=%s success=%b 总=%.2fms", dValueOf, dValueOf2, dValueOf3, dValueOf4, dValueOf5, dValueOf6, dValueOf7, dValueOf8, dValueOf9, str2, Boolean.valueOf(kVar.d), Double.valueOf(dNanoTime13)));
                }
            } catch (Throwable th) {
                th = th;
                double dNanoTime14 = (System.nanoTime() - jNanoTime) / 1000000.0d;
                if (f.a) {
                    Log.i(str, String.format("[EGL] 异常 总=%.2fms", Double.valueOf(dNanoTime14)));
                }
                Log.e("OpenGL", "Failed to fetch GL info safely", th);
            }
            return kVar;
        } catch (Throwable th2) {
            th = th2;
            str = "PerfBench";
        }
    }

    public static void b(PerformanceData performanceData) {
        long j;
        AdvancedHardwareInfo advancedHardwareInfo = performanceData.advancedInfo;
        advancedHardwareInfo.hasBigLittleArch = false;
        advancedHardwareInfo.bigCoreCount = 0;
        advancedHardwareInfo.littleCoreCount = 0;
        ArrayList arrayList = new ArrayList();
        long j2 = Long.MIN_VALUE;
        long j3 = LongCompanionObject.MAX_VALUE;
        try {
            File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.varbto.utils.performance.DevicePerformanceGrader$$ExternalSyntheticLambda2
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    return file.getName().matches("cpu[0-9]+");
                }
            });
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    File file2 = new File(file, "cpufreq/cpuinfo_max_freq");
                    if (file2.exists()) {
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
                            try {
                                String line = bufferedReader.readLine();
                                if (line != null) {
                                    try {
                                        j = Long.parseLong(line);
                                    } catch (Throwable unused) {
                                        bufferedReader.close();
                                    }
                                } else {
                                    j = -1;
                                }
                                bufferedReader.close();
                                if (j < 0) {
                                    continue;
                                } else {
                                    arrayList.add(Long.valueOf(j));
                                    if (j > j2) {
                                        j2 = j;
                                    }
                                    if (j < j3) {
                                        j3 = j;
                                    }
                                }
                            } catch (Throwable th) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Throwable unused2) {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            if (f.a) {
                Log.e("Performance", "Failed to collect cpu freq info", th3);
            }
        }
        if (arrayList.isEmpty()) {
            performanceData.cpuMaxFreqMHz = 0.0f;
            return;
        }
        performanceData.cpuMaxFreqMHz = j2 / 1000.0f;
        boolean z = new HashSet(arrayList).size() > 1;
        advancedHardwareInfo.hasBigLittleArch = z;
        if (z) {
            long j4 = (j2 + j3) / 2;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((Long) it.next()).longValue() >= j4) {
                    advancedHardwareInfo.bigCoreCount++;
                } else {
                    advancedHardwareInfo.littleCoreCount++;
                }
            }
        }
    }

    public static float b() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/sys/class/thermal/thermal_zone0/temp"));
            try {
                float f = Float.parseFloat(bufferedReader.readLine()) / 1000.0f;
                bufferedReader.close();
                return f;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable unused) {
            return Float.NaN;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0174  */
    /* JADX WARN: Code duplicated, block: B:105:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:109:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:112:0x0202  */
    /* JADX WARN: Code duplicated, block: B:113:0x0205  */
    /* JADX WARN: Code duplicated, block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x005f  */
    /* JADX WARN: Code duplicated, block: B:23:0x0064  */
    /* JADX WARN: Code duplicated, block: B:25:0x006b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0072  */
    /* JADX WARN: Code duplicated, block: B:28:0x0079  */
    /* JADX WARN: Code duplicated, block: B:29:0x007e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0084  */
    /* JADX WARN: Code duplicated, block: B:32:0x0089  */
    /* JADX WARN: Code duplicated, block: B:39:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x009a  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:83:0x0123  */
    /* JADX WARN: Code duplicated, block: B:85:0x0126  */
    /* JADX WARN: Code duplicated, block: B:87:0x012d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x012f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0134 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0136  */
    /* JADX WARN: Code duplicated, block: B:91:0x0139  */
    /* JADX WARN: Code duplicated, block: B:94:0x0152  */
    /* JADX WARN: Code duplicated, block: B:95:0x0155  */
    /* JADX WARN: Code duplicated, block: B:97:0x0159  */
    public final void a(PerformanceData performanceData) {
        int i2;
        int i3;
        String str;
        int i4;
        int iMax;
        int i5;
        String str2;
        String str3;
        long j;
        long j2 = performanceData.totalMemory / 1073741824;
        float f = performanceData.cpuMaxFreqMHz / 1000.0f;
        AdvancedHardwareInfo advancedHardwareInfo = performanceData.advancedInfo;
        if (j2 >= 16) {
            performanceData.memoryScore = 20;
            i2 = 3;
        } else if (j2 >= 12) {
            performanceData.memoryScore = 17;
            i2 = 2;
        } else if (j2 >= 8) {
            performanceData.memoryScore = 14;
            i2 = 1;
        } else {
            if (j2 < 4) {
                performanceData.memoryScore = 6;
                i3 = 3;
            } else if (j2 < 6) {
                performanceData.memoryScore = 10;
                i3 = 1;
            } else {
                performanceData.memoryScore = 12;
                i2 = 0;
            }
            i2 = 0;
            if (f >= 3.0f) {
                i2 += 2;
                performanceData.cpuScore = 30;
            } else if (f >= 2.6f) {
                i2++;
                performanceData.cpuScore = 24;
            } else if (f < 1.8f) {
                i3 += 2;
                performanceData.cpuScore = 10;
            } else if (f < 2.0f) {
                i3++;
                performanceData.cpuScore = 15;
            } else {
                performanceData.cpuScore = 20;
            }
            if (advancedHardwareInfo == null && advancedHardwareInfo.hasBigLittleArch && advancedHardwareInfo.bigCoreCount >= 6) {
                i2 += 2;
            } else if (advancedHardwareInfo == null && advancedHardwareInfo.hasBigLittleArch && advancedHardwareInfo.bigCoreCount >= 4) {
                i2++;
            } else if (advancedHardwareInfo != null || !advancedHardwareInfo.hasBigLittleArch || advancedHardwareInfo.bigCoreCount <= 1) {
                i3 += 2;
            }
            str = performanceData.gpuModel;
            if (str != null || str.isEmpty() || str.equals("Unknown GPU")) {
                i4 = 0;
            } else {
                String lowerCase = str.toLowerCase(Locale.US);
                if (lowerCase.matches(".*adreno.*[789]\\d{2}.*") || lowerCase.matches(".*mali.g[89]\\d{2}.*") || lowerCase.matches(".*mali.g7[1-9]\\d.*")) {
                    i4 = 3;
                } else if (lowerCase.matches(".*adreno.*[345]\\d{2}.*") || lowerCase.matches(".*mali.g3[0-9].*") || lowerCase.matches(".*mali.t.*") || lowerCase.matches(".*mali.[0-9]{3}.*") || lowerCase.contains("powervr")) {
                    i4 = 1;
                } else if (lowerCase.matches(".*adreno.*6\\d{2}.*") || lowerCase.matches(".*mali.g[567]\\d.*")) {
                    i4 = 2;
                } else {
                    i4 = 0;
                }
            }
            if (i4 == 3) {
                i2++;
                performanceData.gpuScore = 30;
            } else if (i4 == 1) {
                i3++;
                performanceData.gpuScore = 10;
            } else if (i4 == 2) {
                performanceData.gpuScore = 20;
            } else {
                performanceData.gpuScore = 15;
            }
            DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
            iMax = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            if (iMax >= 2800) {
                i2++;
            } else if (iMax < 1280) {
                i3++;
            }
            i5 = i2 - i3;
            int i6 = (i5 * 5) + 50;
            performanceData.totalScore = i6;
            performanceData.totalScore = Math.max(0, Math.min(100, i6));
            if (f.a) {
                StringBuilder sbAppend = new StringBuilder("评分明细: 内存=").append(j2).append("GB(memScore=").append(performanceData.memoryScore).append(") CPU=").append(f).append("GHz(cpuScore=").append(performanceData.cpuScore).append(") 大小核=");
                if (advancedHardwareInfo == null && advancedHardwareInfo.hasBigLittleArch) {
                    str2 = advancedHardwareInfo.bigCoreCount + "大核";
                } else {
                    str2 = "无/未识别";
                }
                StringBuilder sbAppend2 = sbAppend.append(str2).append(" GPU=");
                str3 = performanceData.gpuModel;
                if (str3 == null) {
                    str3 = "?";
                }
                StringBuilder sbAppend3 = sbAppend2.append(str3).append("(tier").append(i4).append(",gpuScore=").append(performanceData.gpuScore).append(") 分辨率=").append(iMax).append(" 存储=");
                if (advancedHardwareInfo != null) {
                    j = advancedHardwareInfo.storageSpeedMBps;
                } else {
                    j = 0;
                }
                Log.d("DeviceScore", sbAppend3.append(j).append("MB/s(已移除) | high=").append(i2).append(" low=").append(i3).append(" net=").append(i5).append(" total=").append(performanceData.totalScore).toString());
            }
        }
        i3 = 0;
        if (f >= 3.0f) {
            i2 += 2;
            performanceData.cpuScore = 30;
        } else if (f >= 2.6f) {
            i2++;
            performanceData.cpuScore = 24;
        } else if (f < 1.8f) {
            i3 += 2;
            performanceData.cpuScore = 10;
        } else if (f < 2.0f) {
            i3++;
            performanceData.cpuScore = 15;
        } else {
            performanceData.cpuScore = 20;
        }
        if (advancedHardwareInfo == null) {
            if (advancedHardwareInfo == null) {
                if (advancedHardwareInfo != null) {
                    i3 += 2;
                } else {
                    i3 += 2;
                }
            } else if (advancedHardwareInfo != null) {
                i3 += 2;
            } else {
                i3 += 2;
            }
        } else if (advancedHardwareInfo == null) {
            if (advancedHardwareInfo != null) {
                i3 += 2;
            } else {
                i3 += 2;
            }
        } else if (advancedHardwareInfo != null) {
            i3 += 2;
        } else {
            i3 += 2;
        }
        str = performanceData.gpuModel;
        if (str != null) {
            i4 = 0;
        } else {
            i4 = 0;
        }
        if (i4 == 3) {
            i2++;
            performanceData.gpuScore = 30;
        } else if (i4 == 1) {
            i3++;
            performanceData.gpuScore = 10;
        } else if (i4 == 2) {
            performanceData.gpuScore = 20;
        } else {
            performanceData.gpuScore = 15;
        }
        DisplayMetrics displayMetrics2 = this.a.getResources().getDisplayMetrics();
        iMax = Math.max(displayMetrics2.widthPixels, displayMetrics2.heightPixels);
        if (iMax >= 2800) {
            i2++;
        } else if (iMax < 1280) {
            i3++;
        }
        i5 = i2 - i3;
        int i7 = (i5 * 5) + 50;
        performanceData.totalScore = i7;
        performanceData.totalScore = Math.max(0, Math.min(100, i7));
        if (f.a) {
            StringBuilder sbAppend4 = new StringBuilder("评分明细: 内存=").append(j2).append("GB(memScore=").append(performanceData.memoryScore).append(") CPU=").append(f).append("GHz(cpuScore=").append(performanceData.cpuScore).append(") 大小核=");
            if (advancedHardwareInfo == null) {
                str2 = "无/未识别";
            } else {
                str2 = "无/未识别";
            }
            StringBuilder sbAppend5 = sbAppend4.append(str2).append(" GPU=");
            str3 = performanceData.gpuModel;
            if (str3 == null) {
                str3 = "?";
            }
            StringBuilder sbAppend6 = sbAppend5.append(str3).append("(tier").append(i4).append(",gpuScore=").append(performanceData.gpuScore).append(") 分辨率=").append(iMax).append(" 存储=");
            if (advancedHardwareInfo != null) {
                j = advancedHardwareInfo.storageSpeedMBps;
            } else {
                j = 0;
            }
            Log.d("DeviceScore", sbAppend6.append(j).append("MB/s(已移除) | high=").append(i2).append(" low=").append(i3).append(" net=").append(i5).append(" total=").append(performanceData.totalScore).toString());
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00c2 A[Catch: all -> 0x00ca, TryCatch #4 {all -> 0x00ca, blocks: (B:56:0x00bd, B:58:0x00c2, B:60:0x00c7), top: B:71:0x00bd }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00c7 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #4 {all -> 0x00ca, blocks: (B:56:0x00bd, B:58:0x00c2, B:60:0x00c7), top: B:71:0x00bd }] */
    public static float c() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        FileInputStream fileInputStream;
        File file = d.c;
        int i2 = 0;
        try {
            try {
                fileInputStream = new FileInputStream(d.c);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                bufferedReader.close();
                                inputStreamReader.close();
                            } else {
                                String[] strArrSplit = line.split("\\s+");
                                if (strArrSplit.length <= 14) {
                                    bufferedReader.close();
                                    inputStreamReader.close();
                                } else {
                                    try {
                                        long j = Long.parseLong(strArrSplit[13]) + Long.parseLong(strArrSplit[14]);
                                        long j2 = j - d.a;
                                        long jUptimeMillis = SystemClock.uptimeMillis();
                                        float f = ((jUptimeMillis - d.b) / 1000.0f) * 100.0f;
                                        if (f <= 0.0f) {
                                            bufferedReader.close();
                                            inputStreamReader.close();
                                        } else {
                                            d.a = j;
                                            d.b = jUptimeMillis;
                                            float f2 = (j2 / f) * 100.0f;
                                            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
                                            if (iAvailableProcessors <= 0) {
                                                iAvailableProcessors = 1;
                                            }
                                            int i3 = (int) (f2 / iAvailableProcessors);
                                            i2 = i3 >= 0 ? i3 : 0;
                                            if (i2 > 100) {
                                                i2 = 100;
                                            }
                                            bufferedReader.close();
                                            inputStreamReader.close();
                                            fileInputStream.close();
                                        }
                                    } catch (Throwable unused) {
                                        bufferedReader.close();
                                        inputStreamReader.close();
                                    }
                                    return i2;
                                }
                            }
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                            } catch (Throwable th3) {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                    } catch (Throwable unused2) {
                                        throw th3;
                                    }
                                } else {
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                }
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        bufferedReader = null;
                        th = th4;
                    }
                } catch (Throwable th5) {
                    bufferedReader = null;
                    th = th5;
                    inputStreamReader = null;
                }
            } catch (Throwable th6) {
                inputStreamReader = null;
                bufferedReader = null;
                th = th6;
                fileInputStream = null;
            }
        } catch (Throwable unused3) {
        }
        return i2;
    }
}
