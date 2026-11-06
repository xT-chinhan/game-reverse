package com.bytedance.ms.xr.ka;

import com.bytedance.sdk.component.utils.sl;
import com.tapsdk.tapad.e.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    /* JADX WARN: Code duplicated, block: B:9:0x0059 A[DONT_GENERATE, PHI: r4
      0x0059: PHI (r4v5 java.lang.Process) = (r4v4 java.lang.Process), (r4v6 java.lang.Process) binds: [B:8:0x0057, B:4:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    public static List<String> ms(int i, int i2) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        String[] strArr = {"logcat", "-t", String.valueOf(i), ms(i2)};
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(strArr);
            new ms(processExec.getInputStream(), copyOnWriteArrayList).start();
            new ms(processExec.getErrorStream(), copyOnWriteArrayList).start();
            new xr(processExec, a.f).start();
            processExec.waitFor(a.f, TimeUnit.MILLISECONDS);
            if (processExec != null) {
            }
        } catch (Throwable th) {
            try {
                sl.ms(th);
            } finally {
                if (processExec != null) {
                    processExec.destroy();
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private static class ms extends com.bytedance.sdk.component.ch.d.ah {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private InputStream f569ms;
        private List<String> xr;

        ms(InputStream inputStream, List<String> list) {
            super("LogcatDump$LogDumperThread");
            this.f569ms = inputStream;
            this.xr = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f569ms));
            int length = 32768;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        if (!line.startsWith("---------")) {
                            length -= line.getBytes("UTF-8").length;
                            if (length < 0) {
                                break;
                            } else {
                                this.xr.add(line);
                            }
                        }
                    } else {
                        break;
                    }
                } catch (IOException unused) {
                    com.bytedance.ms.xr.x.c.ms(bufferedReader);
                    return;
                } catch (Throwable th) {
                    com.bytedance.ms.xr.x.c.ms(bufferedReader);
                    throw th;
                }
            }
            com.bytedance.ms.xr.x.c.ms(bufferedReader);
        }
    }

    private static class xr extends com.bytedance.sdk.component.ch.d.ah {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private Process f570ms;
        private long xr;

        public xr(Process process, long j) {
            super("LogcatDump$TimerThread");
            this.f570ms = process;
            this.xr = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                sleep(this.xr);
            } catch (InterruptedException e) {
                sl.ms(e);
            }
            Process process = this.f570ms;
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static String ms(int i) {
        return (i < 0 || i >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i];
    }
}
