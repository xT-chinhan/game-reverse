package com.varbto.utils.api;

import android.content.Context;
import android.util.Log;
import com.varbto.internal.f;
import com.varbto.internal.i;
import com.varbto.utils.crash.CrashHandler;
import com.varbto.utils.crash.CrashHandlerBuilder;
import com.varbto.utils.crash.CrashRecorder;
import com.varbto.utils.crash.LoggingCrashRecorder;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class MediationCrashManager {
    public static MediationCrashManager j;
    public final Context a;
    public CrashHandler b;
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public final ConcurrentHashMap d = new ConcurrentHashMap();
    public int e = 7;
    public int f = 7;
    public int g = 0;
    public int h = 0;
    public int i = 0;

    public MediationCrashManager(Context context) {
        this.a = context.getApplicationContext();
        if (f.a) {
            Log.d("MediationCrashManager", "MediationCrashManager initialized");
        }
    }

    public static MediationCrashManager getInstance(Context context) {
        if (j == null) {
            synchronized (MediationCrashManager.class) {
                if (j == null) {
                    j = new MediationCrashManager(context);
                }
            }
        }
        if (f.a) {
            Log.d("MediationCrashManager", "getInstance: return singleton");
        }
        return j;
    }

    public void applyFuseConfig(int i, int i2, int i3, int i4, int i5) {
        this.g = i;
        this.h = i3;
        this.i = i5;
        initNetworkCrashCounters(i2);
        initMediationCrashCounters(i4);
    }

    public int getCrashCountWithinDays(int i) {
        if (this.b == null) {
            return 0;
        }
        if (f.a) {
            Log.d("MediationCrashManager", "getCrashCountWithinDays: " + i);
        }
        return this.b.getCrashCountWithinDays(i);
    }

    public List<File> getCrashFileList(String str) {
        if (this.b == null) {
            return new ArrayList();
        }
        if (f.a) {
            Log.d("MediationCrashManager", "getCrashFileList(name): " + str);
        }
        return this.b.getCrashFileList(str);
    }

    public CrashHandler getCrashHandler() {
        if (f.a) {
            Log.d("MediationCrashManager", "getCrashHandler: " + (this.b != null));
        }
        return this.b;
    }

    public CrashHandlerBuilder getCrashHandlerBuilder() {
        if (f.a) {
            Log.d("MediationCrashManager", "getCrashHandlerBuilder");
        }
        return new CrashHandlerBuilder(this.a);
    }

    public JSONArray getCrashTimestampsWithinDays(int i) {
        if (this.b == null) {
            return new JSONArray();
        }
        if (f.a) {
            Log.d("MediationCrashManager", "getCrashTimestampsWithinDays: " + i);
        }
        return this.b.getCrashTimestampsWithinDays(i);
    }

    public int getFuseLevel() {
        return this.g;
    }

    public CrashHandler initCrashMonitoring(boolean z, boolean z2) {
        CrashHandler crashHandler = this.b;
        if (crashHandler != null) {
            if (z2) {
                crashHandler.install();
            }
            return this.b;
        }
        synchronized (this) {
            CrashHandler crashHandler2 = this.b;
            if (crashHandler2 == null) {
                if (f.a) {
                    Log.d("MediationCrashManager", "Initializing Crash monitoring, saveStackTrace: " + z);
                }
                this.b = new CrashHandlerBuilder(this.a).setCrashRecorder(new LoggingCrashRecorder(this.a, z)).setStartImmediately(z2).setSaveStackSwitch(z).build();
            } else if (z2) {
                crashHandler2.install();
            }
        }
        return this.b;
    }

    public void initMediationCrashCounters(int i) {
        this.f = i;
        HashMap mapB = i.a(this.a).b(i);
        this.d.clear();
        this.d.putAll(mapB);
    }

    public void initNetworkCrashCounters(int i) {
        this.e = i;
        HashMap mapC = i.a(this.a).c(i);
        this.c.clear();
        this.c.putAll(mapC);
    }

    public boolean isNetworkIdReachedCrashLimit(String str, int i) {
        Integer num = (Integer) this.c.get(str);
        return (num != null ? num.intValue() : 0) >= i;
    }

    public void markCrashFileSent(String str, String str2) {
        if (this.b != null) {
            if (f.a) {
                Log.d("MediationCrashManager", "markCrashFileSent(name): file=" + str + " sdk=" + str2);
            }
            this.b.markFileSent(str, str2);
        }
    }

    public void recordCrashServerStatus(String str, int i, String str2) {
        try {
            i.a(this.a).b(i, str2, Long.parseLong(str));
            if (i == 1 && str2 != null) {
                recordNetworkCrashAttribution(str, str2);
            } else if (i == 2 && str2 != null) {
                recordMediationCrashAttribution(str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public void recordMediationCrashAttribution(String str, String str2) {
        try {
            long j2 = Long.parseLong(str);
            i.a(this.a).a(j2, str2);
            if (j2 >= System.currentTimeMillis() - (((long) this.f) * 86400000)) {
                Integer num = (Integer) this.d.get(str2);
                this.d.put(str2, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
            }
        } catch (Throwable unused) {
        }
    }

    public void recordNetworkCrashAttribution(String str, String str2) {
        try {
            long j2 = Long.parseLong(str);
            i.a(this.a).b(j2, str2);
            if (j2 >= System.currentTimeMillis() - (((long) this.e) * 86400000)) {
                Integer num = (Integer) this.c.get(str2);
                this.c.put(str2, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
            }
        } catch (Throwable unused) {
        }
    }

    public void registerCrashSdk(String str) {
        if (f.a) {
            Log.d("MediationCrashManager", "registerCrashSdk(name): " + str);
        }
        if (f.a) {
            i iVar = i.b;
            Log.d("CrashTimestampDbHelper", "Registering Crash SDK: " + str);
        }
        i.c.add(str);
    }

    public boolean shouldBlockMediationId(String str) {
        if (this.g < 2) {
            return false;
        }
        Integer num = (Integer) this.d.get(str);
        return (num != null ? num.intValue() : 0) >= this.i;
    }

    public boolean shouldBlockNetworkId(String str) {
        if (this.g < 1) {
            return false;
        }
        return isNetworkIdReachedCrashLimit(str, this.h);
    }

    public int getCrashCountWithinDays(String str, int i) {
        if (this.b == null) {
            return 0;
        }
        if (f.a) {
            Log.d("MediationCrashManager", "getCrashCountWithinDays(category): " + str + ", days=" + i);
        }
        if (!UtilConst.isValidCrashCategory(str)) {
            if (f.a) {
                Log.w("MediationCrashManager", "Invalid crash category: " + str);
            }
            return 0;
        }
        return this.b.getCrashCountWithinDays(str, i);
    }

    public List<File> getCrashFileList(int i) {
        if (this.b == null) {
            return new ArrayList();
        }
        if (f.a) {
            Log.d("MediationCrashManager", "getCrashFileList(id): " + i);
        }
        return this.b.getCrashFileList(i + "");
    }

    public JSONArray getCrashTimestampsWithinDays(String str, int i) {
        if (this.b == null) {
            return new JSONArray();
        }
        if (f.a) {
            Log.d("MediationCrashManager", "getCrashTimestampsWithinDays(category): " + str + ", days=" + i);
        }
        if (!UtilConst.isValidCrashCategory(str)) {
            if (f.a) {
                Log.w("MediationCrashManager", "Invalid crash category: " + str);
            }
            return new JSONArray();
        }
        return this.b.getCrashTimestampsWithinDays(str, i);
    }

    public void markCrashFileSent(String str, int i) {
        if (this.b != null) {
            if (f.a) {
                Log.d("MediationCrashManager", "markCrashFileSent(id): file=" + str + " sdk=" + i);
            }
            this.b.markFileSent(str, i + "");
        }
    }

    public void registerCrashSdk(int i) {
        if (f.a) {
            Log.d("MediationCrashManager", "registerCrashSdk(id): " + i);
        }
        String str = i + "";
        if (f.a) {
            i iVar = i.b;
            Log.d("CrashTimestampDbHelper", "Registering Crash SDK: " + str);
        }
        i.c.add(str);
    }

    public List<File> getCrashFileList(String str, String str2) {
        if (this.b == null) {
            return new ArrayList();
        }
        if (f.a) {
            Log.d("MediationCrashManager", "getCrashFileList(name, category): " + str + ", " + str2);
        }
        if (!UtilConst.isValidCrashCategory(str2)) {
            if (f.a) {
                Log.w("MediationCrashManager", "Invalid crash category: " + str2);
            }
            return new ArrayList();
        }
        return this.b.getCrashFileList(str, str2);
    }

    public CrashHandler initCrashMonitoring(CrashRecorder crashRecorder, boolean z) {
        CrashHandler crashHandler = this.b;
        if (crashHandler != null) {
            if (z) {
                crashHandler.install();
            }
            return this.b;
        }
        synchronized (this) {
            CrashHandler crashHandler2 = this.b;
            if (crashHandler2 == null) {
                this.b = new CrashHandlerBuilder(this.a).setCrashRecorder(crashRecorder).setStartImmediately(z).build();
            } else if (z) {
                crashHandler2.install();
            }
        }
        return this.b;
    }
}
