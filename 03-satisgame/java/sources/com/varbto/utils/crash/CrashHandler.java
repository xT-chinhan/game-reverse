package com.varbto.utils.crash;

import android.content.Context;
import android.util.Log;
import com.varbto.internal.f;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public final CrashAttributionService a;
    public final CrashRecorder b;
    public final AtomicBoolean c = new AtomicBoolean(false);
    public Thread.UncaughtExceptionHandler d;

    public CrashHandler(Context context, CrashAttributionService crashAttributionService, CrashRecorder crashRecorder) {
        context.getApplicationContext();
        this.a = crashAttributionService;
        this.b = crashRecorder;
    }

    public int getCrashCountWithinDays(int i) {
        return this.b.getCrashCountWithinDays(i);
    }

    public int getCrashFileCount() {
        return this.b.getCrashFileCount();
    }

    public List<File> getCrashFileList() {
        return this.b.getCrashFileList();
    }

    public JSONArray getCrashTimestampsWithinDays(int i) {
        return this.b.getCrashTimestampsWithinDays(i);
    }

    public void install() {
        if (this.c.getAndSet(true)) {
            if (f.a) {
                Log.d("CrashHandler", "Crash handler already installed");
            }
        } else {
            this.d = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (f.a) {
                Log.i("CrashHandler", "Crash handler installed");
            }
        }
    }

    public void markFileSent(String str, String str2) {
        this.b.markFileSent(str, str2);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        try {
            if (f.a) {
                Log.d("CrashHandler", "Uncaught exception captured from thread: " + thread.getName());
            }
            CrashAttributionService crashAttributionService = this.a;
            this.b.recordCrash(crashAttributionService != null ? crashAttributionService.process(th) : null, th);
            uncaughtExceptionHandler = this.d;
            if (uncaughtExceptionHandler == null) {
                throw new RuntimeException(th);
            }
        } catch (Throwable th2) {
            try {
                if (f.a) {
                    Log.e("CrashHandler", "Crash recording failed: " + th2.getMessage(), th2);
                }
                uncaughtExceptionHandler = this.d;
                if (uncaughtExceptionHandler == null) {
                    throw new RuntimeException(th);
                }
            } catch (Throwable th3) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.d;
                if (uncaughtExceptionHandler2 == null) {
                    throw new RuntimeException(th);
                }
                uncaughtExceptionHandler2.uncaughtException(thread, th);
                throw th3;
            }
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    public void uninstall() {
        if (this.c.getAndSet(false)) {
            Thread.setDefaultUncaughtExceptionHandler(this.d);
            if (f.a) {
                Log.i("CrashHandler", "Crash handler uninstalled");
            }
        }
    }

    public int getCrashCountWithinDays(String str, int i) {
        return this.b.getCrashCountWithinDays(str, i);
    }

    public List<File> getCrashFileList(String str) {
        return this.b.getCrashFileList(str);
    }

    public JSONArray getCrashTimestampsWithinDays(String str, int i) {
        return this.b.getCrashTimestampsWithinDays(str, i);
    }

    public List<File> getCrashFileList(String str, String str2) {
        return this.b.getCrashFileList(str, str2);
    }
}
