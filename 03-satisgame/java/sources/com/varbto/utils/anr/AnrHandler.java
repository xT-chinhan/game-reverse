package com.varbto.utils.anr;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.varbto.internal.a;
import com.varbto.internal.c;
import com.varbto.internal.f;
import com.varbto.internal.l;
import com.varbto.internal.m;
import com.varbto.internal.q;
import com.varbto.internal.r;
import com.varbto.internal.u;
import com.varbto.internal.v;
import com.varbto.internal.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class AnrHandler {
    public final AnrRecorder a;
    public final Context b;
    public final AtomicBoolean c = new AtomicBoolean(false);
    public final boolean d;

    public AnrHandler(Context context, l lVar, AnrRecorder anrRecorder, long j, boolean z) {
        this.b = context.getApplicationContext();
        this.a = anrRecorder;
        this.d = z;
    }

    public final void a() {
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        final File file = new File(this.b.getFilesDir(), "anr_reports");
        Thread thread = new Thread(new Runnable() { // from class: com.varbto.utils.anr.AnrHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(file);
            }
        }, "AnrBackfill");
        thread.setDaemon(true);
        thread.start();
    }

    public int getAnrCountWithinDays(int i) {
        return this.a.getAnrCountWithinDays(i);
    }

    public int getAnrFileCount() {
        return this.a.getAnrFileCount();
    }

    public List<File> getAnrFileList() {
        return this.a.getAnrFileList();
    }

    public JSONArray getAnrTimestampsWithinDays(int i) {
        return this.a.getAnrTimestampsWithinDays(i);
    }

    public void markFileSent(String str, String str2) {
        this.a.markFileSent(str, str2);
    }

    public void startMonitoring() {
        if (this.c.getAndSet(true)) {
            if (f.a) {
                Log.d("AnrHandler", "ANR monitoring is already started");
                return;
            }
            return;
        }
        File file = new File(this.b.getFilesDir(), "anr_reports");
        if (!file.exists()) {
            file.mkdirs();
        }
        Context applicationContext = this.b;
        if (applicationContext instanceof Activity) {
            applicationContext = applicationContext.getApplicationContext();
        }
        boolean z = this.d;
        String absolutePath = file.getAbsolutePath();
        a aVar = new a(this);
        r rVar = new r();
        rVar.a = applicationContext;
        rVar.b = absolutePath;
        rVar.c = z;
        rVar.d = aVar;
        if (w.e == null) {
            synchronized (w.class) {
                if (w.e == null) {
                    w.e = new w();
                }
            }
        }
        w wVar = w.e;
        wVar.getClass();
        try {
            m.a("w", "----------------------- v1.1.5 -----------------------", new Object[0]);
            if (rVar.a == null) {
                throw new IllegalArgumentException("Context cant not be null.");
            }
            q.b.execute(new v(rVar));
            if (!wVar.b) {
                wVar.b = true;
                u uVar = new u(wVar, rVar);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    uVar.run();
                } else {
                    q.a.post(uVar);
                }
            }
            if (f.a) {
                Log.i("AnrHandler", "VerbAnr monitoring started, stackSwitch=" + this.d);
            }
            a();
        } catch (Throwable th) {
            m.a("w", "startVerb() >>> Start verb anr failed. ", th, new Object[0]);
            wVar.b = false;
        }
    }

    public void stopMonitoring() {
        this.c.set(false);
        if (f.a) {
            Log.i("AnrHandler", "ANR monitoring stopped");
        }
    }

    public List<File> getAnrFileList(String str) {
        return this.a.getAnrFileList(str);
    }

    public final /* synthetic */ void a(File file) {
        try {
            ActivityManager activityManager = (ActivityManager) this.b.getSystemService("activity");
            if (activityManager == null) {
                return;
            }
            int i = 0;
            List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(this.b.getPackageName(), 0, 0);
            if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                c cVarA = c.a(this.b);
                for (ApplicationExitInfo applicationExitInfo : historicalProcessExitReasons) {
                    if (applicationExitInfo.getReason() == 6) {
                        long timestamp = applicationExitInfo.getTimestamp();
                        if (timestamp > 0 && !cVarA.a(timestamp)) {
                            a(applicationExitInfo, timestamp, file);
                            cVarA.a(timestamp, "exit_info");
                            i++;
                            if (f.a) {
                                Log.i("AnrHandler", "Backfill ANR from ApplicationExitInfo, ts=" + timestamp + ", desc=" + applicationExitInfo.getDescription());
                            }
                        }
                    }
                }
                if (f.a) {
                    Log.i("AnrHandler", "ApplicationExitInfo backfill done, added=" + i);
                }
            }
        } catch (Throwable th) {
            if (f.a) {
                Log.e("AnrHandler", "Backfill ANR failed: " + th.getMessage(), th);
            }
        }
    }

    public static void a(ApplicationExitInfo applicationExitInfo, long j, File file) {
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        try {
            InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            if (traceInputStream == null) {
                return;
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, String.valueOf(j));
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
                try {
                    fileOutputStream.write(("===== VerbAnr Report =====\ntriggerSource=exit_info\ntimestamp=" + j + "\nexitReason=ANR\ndescription=" + (applicationExitInfo.getDescription() != null ? applicationExitInfo.getDescription() : "") + "\nimportance=" + applicationExitInfo.getImportance() + "\n===== End Header =====\n").getBytes("UTF-8"));
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = traceInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i);
                        }
                        try {
                            traceInputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                    fileOutputStream.flush();
                    if (f.a) {
                        Log.i("AnrHandler", "Saved ExitInfo ANR trace: " + file2.getAbsolutePath() + ", size=" + file2.length());
                    }
                    fileOutputStream.close();
                    traceInputStream.close();
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                traceInputStream.close();
                throw th4;
            }
        } catch (Throwable th5) {
            if (f.a) {
                Log.e("AnrHandler", "Save ExitInfo trace failed: " + th5.getMessage(), th5);
            }
        }
    }
}
