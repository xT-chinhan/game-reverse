package com.varbto.utils.performance;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import com.varbto.internal.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ DevicePerformanceGrader.PerformanceMonitorCallback a;
    public final /* synthetic */ long b;
    public final /* synthetic */ b c;

    public a(b bVar, DevicePerformanceGrader.PerformanceMonitorCallback performanceMonitorCallback, long j) {
        this.c = bVar;
        this.a = performanceMonitorCallback;
        this.b = j;
    }

    public static /* synthetic */ void a(DevicePerformanceGrader.PerformanceMonitorCallback performanceMonitorCallback, float f, float f2, float f3, int i) {
        performanceMonitorCallback.onCpuUpdate(f, f2);
        performanceMonitorCallback.onMemoryUpdate(f3);
        if (Build.VERSION.SDK_INT >= 29) {
            performanceMonitorCallback.onThermalUpdate(i);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        b bVar;
        final float f;
        int i;
        int i2;
        if (!this.c.d) {
            return;
        }
        try {
            DevicePerformanceGrader devicePerformanceGrader = this.c.m;
            float fC = DevicePerformanceGrader.c();
            float f2 = 0.0f;
            if (fC < 0.0f || fC > 100.0f) {
                if (f.a) {
                    Log.w("CPU", "Abnormal CPU usage: " + fC + ", using fallback value");
                }
                f = 0.0f;
            } else {
                f = fC;
            }
            DevicePerformanceGrader devicePerformanceGrader2 = this.c.m;
            final float fB = DevicePerformanceGrader.b();
            DevicePerformanceGrader devicePerformanceGrader3 = this.c.m;
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager) devicePerformanceGrader3.a.getSystemService("activity");
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
            }
            long j = memoryInfo.totalMem;
            if (j > 0) {
                f2 = (j - memoryInfo.availMem) / j;
            }
            this.c.g = f;
            this.c.h = f2;
            this.c.f = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 29) {
                this.c.i = ((PowerManager) this.c.m.a.getSystemService("power")).getCurrentThermalStatus();
            }
            int iA = b.a(this.c.g);
            int iB = b.b(this.c.h);
            switch (this.c.i) {
                case 1:
                    i = 80;
                    i2 = i;
                    break;
                case 2:
                    i = 50;
                    i2 = i;
                    break;
                case 3:
                    i = 25;
                    i2 = i;
                    break;
                case 4:
                    i = 10;
                    i2 = i;
                    break;
                case 5:
                    i = 5;
                    i2 = i;
                    break;
                case 6:
                    i2 = 0;
                    break;
                default:
                    i = 100;
                    i2 = i;
                    break;
            }
            boolean z = iA <= this.c.k || iB <= this.c.k || i2 <= this.c.k || this.c.c();
            if (z && !this.c.j) {
                this.c.e = System.currentTimeMillis() + 5000;
            } else if (!z) {
                this.c.e = 0L;
            }
            this.c.j = z;
            if (this.a != null) {
                final int i3 = this.c.i;
                Handler handler = this.c.m.g;
                final DevicePerformanceGrader.PerformanceMonitorCallback performanceMonitorCallback = this.a;
                str = "sample error: ";
                final float f3 = f2;
                try {
                    handler.post(new Runnable() { // from class: com.varbto.utils.performance.a$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.a(performanceMonitorCallback, f, fB, f3, i3);
                        }
                    });
                } catch (Throwable th) {
                    th = th;
                    try {
                        if (f.a) {
                            Log.e("PerformanceMonitor", str + th.getMessage());
                        }
                        if (!this.c.d) {
                            return;
                        } else {
                            bVar = this.c;
                        }
                    } finally {
                        if (this.c.d) {
                            this.c.a().postDelayed(this, this.b);
                        }
                    }
                }
            } else {
                str = "sample error: ";
            }
            if (f.a) {
                Log.d("PerformanceMonitor", "sample: cpuUsage=" + this.c.g + " memRatio=" + this.c.h + " thermal=" + this.c.i + " dyn(cpu/mem/therm)=" + iA + "/" + iB + "/" + i2 + " dynamicScore=" + this.c.b() + " high=" + z);
            }
            if (this.c.d) {
                bVar = this.c;
                Handler handlerA = bVar.a();
            }
        } catch (Throwable th2) {
            th = th2;
            str = "sample error: ";
        }
    }
}
