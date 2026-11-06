package com.tapsdk.tapad.internal.o.a.b;

import android.os.Process;
import android.text.TextUtils;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.TapAdManager;
import com.tapsdk.tapad.constants.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class a implements Thread.UncaughtExceptionHandler {
    private static final a g = new a();
    private TapAdConfig a;
    private final boolean b;
    private Thread.UncaughtExceptionHandler c;
    private ThreadPoolExecutor d;
    private String e;
    com.tapsdk.tapad.internal.o.a.a f;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.o.a.b.a$a, reason: collision with other inner class name */
    class ThreadFactoryC0626a implements ThreadFactory {
        ThreadFactoryC0626a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "tapad_crash_thread");
            thread.setDaemon(false);
            return thread;
        }
    }

    class b implements Runnable {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.a);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.d();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private a() {
        this.b = ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.l, Integer.class, 1)).intValue() == 1;
        this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryC0626a());
        this.e = "";
        this.f = com.tapsdk.tapad.internal.o.a.a.a();
    }

    public static a a() {
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.a == null || TextUtils.isEmpty(str) || !str.contains("com.tapsdk.tapad.")) {
            return;
        }
        try {
            String str2 = String.format(Locale.getDefault(), "crashTime %d, mediaId %s, sdkVersion %s, crashLog: %s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.a.mMediaId), 31603045, str);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(b(), String.format(Locale.getDefault(), "%d.log", Long.valueOf(System.currentTimeMillis() / 1000))));
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
            d();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private synchronized void a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        while (true) {
            th = th.getCause();
            if (th == null) {
                break;
            } else {
                th.printStackTrace(printWriter);
            }
        }
        printWriter.close();
        String string = stringWriter.toString();
        if (!TextUtils.isEmpty(string)) {
            this.d.execute(new b(string));
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String b() {
        if (!TextUtils.isEmpty(this.e)) {
            return this.e;
        }
        this.e = TapAdManager.get().appContext.getExternalCacheDir() + File.separator + "tapad" + File.separator + "crashlog";
        File file = new File(this.e);
        if (!file.exists()) {
            file.mkdirs();
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() throws IOException {
        File[] fileArrListFiles = new File(b()).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                } else {
                    sb.append(line).append("\n");
                }
            }
            bufferedReader.close();
            if (sb.length() != 0) {
                HashMap<String, String> map = new HashMap<>();
                map.put("sdk_crash", sb.toString());
                com.tapsdk.tapad.internal.o.a.a aVar = this.f;
                if (aVar != null && aVar.a(map)) {
                    file.delete();
                }
            }
        }
    }

    public void a(TapAdConfig tapAdConfig) {
        if (this.b) {
            this.c = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.a = tapAdConfig;
        }
    }

    public synchronized void c() {
        if (this.b) {
            this.d.execute(new c());
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.c;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }
}
