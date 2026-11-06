package com.varbto.utils.api;

import android.content.Context;
import android.util.Log;
import com.varbto.internal.c;
import com.varbto.internal.f;
import com.varbto.utils.anr.AnrHandler;
import com.varbto.utils.anr.AnrHandlerBuilder;
import com.varbto.utils.anr.AnrRecorder;
import com.varbto.utils.anr.LoggingAnrRecorder;
import com.varbto.utils.performance.DevicePerformanceGrader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class MediationUtilsManager {
    public static volatile MediationUtilsManager e;
    public final DevicePerformanceGrader a;
    public final Context b;
    public volatile AnrHandler c;
    public volatile OnAnrListener d;

    public MediationUtilsManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.a = new DevicePerformanceGrader(applicationContext);
        if (f.a) {
            Log.d("MediationUtilsManager", "MediationUtilsManager initialized");
        }
    }

    public static MediationUtilsManager getInstance(Context context) {
        if (e == null) {
            synchronized (MediationUtilsManager.class) {
                if (e == null) {
                    e = new MediationUtilsManager(context);
                }
            }
        }
        if (f.a) {
            Log.d("MediationUtilsManager", "getInstance: return singleton");
        }
        return e;
    }

    public int getAnrCountWithinDays(int i) {
        if (f.a) {
            Log.d("MediationUtilsManager", "getAnrCountWithinDays: " + i);
        }
        return c.a(this.b).a(i);
    }

    public List<File> getAnrFileList(String str) {
        if (this.c == null) {
            return new ArrayList();
        }
        if (f.a) {
            Log.d("MediationUtilsManager", "getAnrFileList(name): " + str);
        }
        return this.c.getAnrFileList(str);
    }

    public AnrHandler getAnrHandler() {
        if (f.a) {
            Log.d("MediationUtilsManager", "getAnrHandler: " + (this.c != null));
        }
        return this.c;
    }

    public AnrHandlerBuilder getAnrHandlerBuilder() {
        if (f.a) {
            Log.d("MediationUtilsManager", "getAnrHandlerBuilder");
        }
        return new AnrHandlerBuilder(this.b);
    }

    public OnAnrListener getAnrListener() {
        return this.d;
    }

    public JSONArray getAnrTimestampsWithinDays(int i) {
        if (f.a) {
            Log.d("MediationUtilsManager", "getAnrTimestampsWithinDays: " + i);
        }
        return c.a(this.b).b(i);
    }

    public int getDynamicScore() {
        DevicePerformanceGrader devicePerformanceGrader = this.a;
        if (devicePerformanceGrader == null) {
            return -1;
        }
        int dynamicScore = devicePerformanceGrader.getDynamicScore();
        if (f.a) {
            Log.d("MediationUtilsManager", "dynamicScore: " + dynamicScore);
        }
        return dynamicScore;
    }

    public DevicePerformanceGrader getGrader() {
        if (f.a) {
            Log.d("MediationUtilsManager", "getGrader");
        }
        return this.a;
    }

    public Map<String, Object> getStaticPerformanceDataMap() {
        if (this.a == null) {
            return null;
        }
        if (f.a) {
            Log.d("MediationUtilsManager", "getStaticPerformanceDataMap: begin");
        }
        return this.a.getStaticPerformanceDataMap();
    }

    public int getTotalScore() {
        DevicePerformanceGrader devicePerformanceGrader = this.a;
        if (devicePerformanceGrader == null) {
            return -1;
        }
        int totalScore = devicePerformanceGrader.getTotalScore();
        if (f.a) {
            Log.d("MediationUtilsManager", "totalScore: " + totalScore);
        }
        return totalScore;
    }

    public AnrHandler initAnrMonitoring(long j, boolean z, boolean z2) {
        if (this.c != null) {
            if (z2) {
                this.c.startMonitoring();
            }
            return this.c;
        }
        synchronized (this) {
            if (this.c == null) {
                if (f.a) {
                    Log.d("MediationUtilsManager", "Initializing ANR monitoring, interval: " + j + "ms, saveStackTrace: " + z);
                }
                this.c = new AnrHandlerBuilder(this.b).setCheckIntervalMs(j).setAnrRecorder(new LoggingAnrRecorder(this.b, z)).setStartImmediately(z2).setAnrStaceSwitch(z).build();
            } else if (z2) {
                this.c.startMonitoring();
            }
        }
        return this.c;
    }

    public boolean isHighConsumption() {
        DevicePerformanceGrader devicePerformanceGrader = this.a;
        if (devicePerformanceGrader == null) {
            return false;
        }
        boolean zIsHighConsumption = devicePerformanceGrader.isHighConsumption();
        if (f.a) {
            Log.d("MediationUtilsManager", "isHighConsumption: " + zIsHighConsumption);
        }
        return zIsHighConsumption;
    }

    public void markAnrFileSent(String str, String str2) {
        if (this.c != null) {
            if (f.a) {
                Log.d("MediationUtilsManager", "markAnrFileSent(name): file=" + str + " sdk=" + str2);
            }
            this.c.markFileSent(str, str2);
        }
    }

    public void registerAnrSdk(String str) {
        if (f.a) {
            Log.d("MediationUtilsManager", "registerAnrSdk(name): " + str);
        }
        if (f.a) {
            c cVar = c.b;
            Log.d("AnrTimestampDbHelper", "Registering SDK: " + str);
        }
        c.c.add(str);
    }

    public void requestStaticScoreAsync(OnStaticScoreReadyListener onStaticScoreReadyListener) {
        if (this.a == null) {
            if (f.a) {
                Log.d("MediationUtilsManager", "requestStaticScoreAsync: grader null, skip");
            }
        } else {
            if (f.a) {
                Log.d("MediationUtilsManager", "requestStaticScoreAsync");
            }
            this.a.requestStaticScoreAsync(onStaticScoreReadyListener);
        }
    }

    public void setAnrListener(OnAnrListener onAnrListener) {
        this.d = onAnrListener;
        if (f.a) {
            Log.d("MediationUtilsManager", "setAnrListener: " + (onAnrListener != null));
        }
    }

    public void setDebugMode(boolean z) {
        f.a = z;
        if (z) {
            Log.d("MediationUtilsManager", "Debug mode set to: " + z);
        }
    }

    public void setHighConsumptionThreshold(int i) {
        DevicePerformanceGrader devicePerformanceGrader = this.a;
        if (devicePerformanceGrader != null) {
            devicePerformanceGrader.getMonitor().k = i;
        }
    }

    public void setMinMemoryThresholdMB(long j) {
        DevicePerformanceGrader devicePerformanceGrader = this.a;
        if (devicePerformanceGrader != null) {
            devicePerformanceGrader.getMonitor().l = j * 1048576;
        }
    }

    public void startMonitoring(DevicePerformanceGrader.PerformanceMonitorCallback performanceMonitorCallback, long j) {
        if (this.a != null) {
            if (f.a) {
                Log.d("MediationUtilsManager", "Starting performance monitoring, interval: " + j + "ms");
            }
            this.a.startMonitoring(performanceMonitorCallback, j);
        }
    }

    public void stopMonitoring() {
        if (this.a != null) {
            if (f.a) {
                Log.d("MediationUtilsManager", "Stopping performance monitoring");
            }
            this.a.stopMonitoring();
        }
    }

    public List<File> getAnrFileList(int i) {
        if (this.c == null) {
            return new ArrayList();
        }
        if (f.a) {
            Log.d("MediationUtilsManager", "getAnrFileList(id): " + i);
        }
        return this.c.getAnrFileList(i + "");
    }

    public void markAnrFileSent(String str, int i) {
        if (this.c != null) {
            if (f.a) {
                Log.d("MediationUtilsManager", "markAnrFileSent(id): file=" + str + " sdk=" + i);
            }
            this.c.markFileSent(str, i + "");
        }
    }

    public void startMonitoring(long j) {
        if (this.a != null) {
            if (f.a) {
                Log.d("MediationUtilsManager", "startMonitoring(no callback), interval: " + j + "ms");
            }
            this.a.startMonitoring(null, j);
        }
    }

    public void registerAnrSdk(int i) {
        if (f.a) {
            Log.d("MediationUtilsManager", "registerAnrSdk(id): " + i);
        }
        String str = i + "";
        if (f.a) {
            c cVar = c.b;
            Log.d("AnrTimestampDbHelper", "Registering SDK: " + str);
        }
        c.c.add(str);
    }

    public AnrHandler initAnrMonitoring(long j, AnrRecorder anrRecorder, boolean z) {
        if (this.c != null) {
            if (z) {
                this.c.startMonitoring();
            }
            return this.c;
        }
        synchronized (this) {
            if (this.c == null) {
                this.c = new AnrHandlerBuilder(this.b).setCheckIntervalMs(j).setAnrRecorder(anrRecorder).setStartImmediately(z).build();
            } else if (z) {
                this.c.startMonitoring();
            }
        }
        return this.c;
    }
}
