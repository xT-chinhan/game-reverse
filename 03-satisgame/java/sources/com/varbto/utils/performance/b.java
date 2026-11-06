package com.varbto.utils.performance;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import com.anythink.china.a.c;
import com.varbto.internal.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public volatile HandlerThread a;
    public volatile Handler b;
    public final Object c = new Object();
    public volatile boolean d = false;
    public volatile long e = 0;
    public volatile long f = 0;
    public volatile float g = 0.0f;
    public volatile float h = 0.0f;
    public volatile int i = 0;
    public volatile boolean j = false;
    public volatile int k = 30;
    public volatile long l = 0;
    public final /* synthetic */ DevicePerformanceGrader m;

    public b(DevicePerformanceGrader devicePerformanceGrader) {
        this.m = devicePerformanceGrader;
    }

    public static int a(float f) {
        if (f >= 95.0f) {
            return 5;
        }
        if (f >= 90.0f) {
            return 15;
        }
        if (f >= 80.0f) {
            return 30;
        }
        if (f >= 60.0f) {
            return 50;
        }
        return f >= 30.0f ? 75 : 100;
    }

    public static int b(float f) {
        if (f >= 0.95f) {
            return 5;
        }
        if (f >= 0.9f) {
            return 15;
        }
        if (f >= 0.85f) {
            return 30;
        }
        if (f >= 0.7f) {
            return 50;
        }
        return f >= 0.5f ? 75 : 100;
    }

    public final Handler a() {
        if (this.b != null) {
            return this.b;
        }
        synchronized (this.c) {
            if (this.b == null) {
                this.a = new HandlerThread("perf-monitor");
                this.a.start();
                this.b = new Handler(this.a.getLooper());
            }
        }
        return this.b;
    }

    public final int b() {
        int i;
        if (System.currentTimeMillis() < this.e) {
            if (f.a) {
                Log.d("PerformanceMonitor", "getDynamicScore: within highConsumption debounce window, returning " + this.k);
            }
            return this.k;
        }
        if (!this.d && System.currentTimeMillis() - this.f > 1000 && Looper.myLooper() != Looper.getMainLooper()) {
            d();
        }
        if (c()) {
            if (f.a) {
                Log.d("PerformanceMonitor", "getDynamicScore: memory below threshold, returning " + this.k);
            }
            return this.k;
        }
        int iA = a(this.g);
        int iB = b(this.h);
        switch (this.i) {
            case 1:
                i = 80;
                break;
            case 2:
                i = 50;
                break;
            case 3:
                i = 25;
                break;
            case 4:
                i = 10;
                break;
            case 5:
                i = 5;
                break;
            case 6:
                i = 0;
                break;
            default:
                i = 100;
                break;
        }
        if (iA <= this.k || iB <= this.k || i <= this.k) {
            if (f.a) {
                Log.d("PerformanceMonitor", "getDynamicScore: low score guard triggered cpu=" + iA + " mem=" + iB + " thermal=" + i);
            }
            return this.k;
        }
        int i2 = (int) ((i * 0.25f) + (iB * 0.35f) + (iA * 0.4f));
        if (f.a) {
            Log.d("PerformanceMonitor", "getDynamicScore: cpu=" + iA + " mem=" + iB + " thermal=" + i + " result=" + i2);
        }
        return i2;
    }

    public final boolean c() {
        long j;
        if (this.l <= 0) {
            return false;
        }
        if (this.m.c == null || this.m.c.totalMemory <= 0) {
            DevicePerformanceGrader devicePerformanceGrader = this.m;
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager) devicePerformanceGrader.a.getSystemService("activity");
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
            }
            j = memoryInfo.totalMem;
        } else {
            j = this.m.c.totalMemory;
        }
        if (f.a) {
            Log.d("PerformanceMonitor", "isMemoryBelowThreshold: totalMem=" + ((j / c.k) / c.k) + "MB, threshold=" + ((this.l / c.k) / c.k) + "MB");
        }
        return j <= this.l;
    }

    public final void d() {
        float fC = DevicePerformanceGrader.c();
        if (fC < 0.0f || fC > 100.0f) {
            if (f.a) {
                Log.w("CPU", "Abnormal CPU usage: " + fC + ", using fallback value");
            }
            fC = 0.0f;
        }
        DevicePerformanceGrader devicePerformanceGrader = this.m;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) devicePerformanceGrader.a.getSystemService("activity");
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
        }
        long j = memoryInfo.totalMem;
        float f = j > 0 ? (j - memoryInfo.availMem) / j : 0.0f;
        this.g = fC;
        this.h = f;
        if (Build.VERSION.SDK_INT >= 29) {
            this.i = ((PowerManager) this.m.a.getSystemService("power")).getCurrentThermalStatus();
        }
        this.f = System.currentTimeMillis();
    }
}
