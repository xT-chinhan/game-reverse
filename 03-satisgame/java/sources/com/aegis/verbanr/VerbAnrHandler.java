package com.aegis.verbanr;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.varbto.internal.a;
import com.varbto.internal.c;
import com.varbto.internal.f;
import com.varbto.internal.m;
import com.varbto.internal.o;
import com.varbto.internal.q;
import com.varbto.internal.r;
import com.varbto.internal.s;
import com.varbto.internal.t;
import com.varbto.utils.api.MediationUtilsManager;
import com.varbto.utils.api.OnAnrListener;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

/* JADX INFO: loaded from: classes.dex */
public class VerbAnrHandler {
    public static VerbAnrHandler c;
    public static volatile long d;
    public r a;
    public File b;

    public static void a(long j, VerbAnrHandler verbAnrHandler, File file) {
        verbAnrHandler.getClass();
        m.b("anrStackSuccess() >>> timestamp: %d, stackFile: %s", Long.valueOf(j), file.getAbsolutePath());
        r rVar = verbAnrHandler.a;
        a aVar = rVar != null ? rVar.d : null;
        if (aVar != null) {
            if (f.a) {
                Log.i("AnrHandler", "VerbAnr ANR detected, timestamp=" + j + ", file=" + file.getAbsolutePath());
            }
            c.a(aVar.a.b).a(j, "native");
        }
    }

    public static void earlyDetectionCallback(long j) {
        VerbAnrHandler verbAnrHandler = c;
        if (verbAnrHandler == null) {
            m.a("VerbAnrHandler", "earlyDetectionCallback() >>> mInstance is null.", null, new Object[0]);
            return;
        }
        r rVar = verbAnrHandler.a;
        a aVar = rVar != null ? rVar.d : null;
        if (aVar == null) {
            return;
        }
        try {
            OnAnrListener anrListener = MediationUtilsManager.getInstance(aVar.a.b).getAnrListener();
            if (anrListener != null) {
                try {
                    anrListener.onAnrDetected(j);
                } catch (Throwable th) {
                    if (f.a) {
                        Log.e("AnrHandler", "onAnrDetected listener threw", th);
                    }
                }
            }
        } catch (Throwable th2) {
            m.a("VerbAnrHandler", "earlyDetectionCallback() >>> listener threw", th2, new Object[0]);
        }
    }

    public static native int initDumpStack(String str, String str2);

    public static native int initVerb();

    public static boolean isEnableDumpStack() {
        r rVar;
        VerbAnrHandler verbAnrHandler = c;
        return (verbAnrHandler == null || (rVar = verbAnrHandler.a) == null || !rVar.c) ? false : true;
    }

    public static native void nativeResetCaptured();

    public static native void nativeSetAnrSuspected(boolean z);

    public static void obtainFailedCallback(int i, String str) {
        m.a("VerbAnrHandler", "failedCallback() >>> code: %d, msg: %s", null, Integer.valueOf(i), str);
        if (c != null) {
            t tVar = new t(i, str);
            Handler handler = q.a;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                q.b.execute(tVar);
            } else {
                tVar.run();
            }
        }
    }

    public static void stackCallback(long j, boolean z) {
        VerbAnrHandler verbAnrHandler = c;
        if (verbAnrHandler == null) {
            m.a("VerbAnrHandler", "stackCallback() >>> mInstance is null.", null, new Object[0]);
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (d > 0 && jUptimeMillis - d < 10000) {
            m.a("VerbAnrHandler", "stackCallback() >>> duplicate within %dms window, drop. timestamp=%d", 10000L, Long.valueOf(j));
            File file = verbAnrHandler.b;
            if (file != null) {
                File file2 = new File(file, String.valueOf(j));
                if (file2.exists() && file2.delete()) {
                    m.a("VerbAnrHandler", "deleteStackFile() >>> deleted: %s", file2.getName());
                    return;
                }
                return;
            }
            return;
        }
        File file3 = verbAnrHandler.b;
        if (file3 == null) {
            m.a("VerbAnrHandler", "stackCallback() >>> traceDir is null.", null, new Object[0]);
            return;
        }
        File file4 = new File(file3, String.valueOf(j));
        if (!file4.exists() || file4.length() == 0) {
            m.a("VerbAnrHandler", "stackCallback() >>> stack file missing or empty, skip. timestamp=%d", null, Long.valueOf(j));
            return;
        }
        d = jUptimeMillis;
        m.b("stackCallback() >>> ANR received from native, timestamp=%d", Long.valueOf(j));
        s sVar = new s(j, verbAnrHandler, file4);
        Handler handler = q.a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            q.b.execute(sVar);
        } else {
            sVar.run();
        }
    }

    public static void a(File file, long j) {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            return;
        }
        File file2 = new File(file.getParentFile(), file.getName() + ".tmp");
        FileOutputStream fileOutputStream = null;
        try {
            String strA = o.a(j);
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2, false);
            try {
                fileOutputStream2.write(strA.getBytes("UTF-8"));
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        } else {
                            fileOutputStream2.write(bArr, 0, i);
                        }
                    }
                    fileOutputStream2.flush();
                    a(fileOutputStream2);
                    a(fileInputStream);
                    if (!file2.exists() || file2.length() == 0) {
                        return;
                    }
                    if (!file.delete()) {
                        m.a("VerbAnrHandler", "prependHeaderToFile() >>> delete original failed: %s", null, file.getAbsolutePath());
                        file2.delete();
                    } else {
                        if (file2.renameTo(file)) {
                            return;
                        }
                        m.a("VerbAnrHandler", "prependHeaderToFile() >>> rename failed: %s -> %s", null, file2.getAbsolutePath(), file.getAbsolutePath());
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        m.a("VerbAnrHandler", "prependHeaderToFile() >>> failed, keep original file.", th, new Object[0]);
                        try {
                            if (file2.exists()) {
                                file2.delete();
                            }
                        } catch (Throwable unused) {
                        }
                    } finally {
                        a(fileOutputStream);
                        a(fileInputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static void a(File file) {
        if (file.exists() && file.length() != 0) {
            try {
                m.b("========== ANR Stack Trace (file: %s, size: %d bytes) ==========", file.getName(), Long.valueOf(file.length()));
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line).append("\n");
                    i++;
                    if (sb.length() > 3500 || i % 80 == 0) {
                        m.b("%s", sb.toString());
                        sb.setLength(0);
                    }
                }
                if (sb.length() > 0) {
                    m.b("%s", sb.toString());
                }
                bufferedReader.close();
                m.b("========== ANR Stack Trace End (total %d lines) ==========", Integer.valueOf(i));
                return;
            } catch (Throwable th) {
                m.a("VerbAnrHandler", "logStackFileContent() >>> read stack file failed.", th, new Object[0]);
                return;
            }
        }
        m.a("VerbAnrHandler", "logStackFileContent() >>> stack file is empty or not exists.", new Object[0]);
    }

    public final void a(int i, String str) {
        r rVar = this.a;
        if ((rVar != null ? rVar.d : null) == null || !f.a) {
            return;
        }
        Log.e("AnrHandler", "VerbAnr failed: code=" + i + ", msg=" + str);
    }
}
