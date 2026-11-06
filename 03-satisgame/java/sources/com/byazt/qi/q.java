package com.byazt.qi;

import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 5})
public class q {
    /* JADX WARN: Code duplicated, block: B:12:0x005f A[PHI: r4
      0x005f: PHI (r4v5 java.lang.Process) = (r4v4 java.lang.Process), (r4v7 java.lang.Process) binds: [B:11:0x005d, B:8:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    public static List<String> n(int i, int i2) {
        Process processExec;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"logcat", "-t", String.valueOf(i), n(i2)});
            try {
                new n(processExec.getInputStream(), copyOnWriteArrayList).start();
                new n(processExec.getErrorStream(), copyOnWriteArrayList).start();
                new qg(processExec, 3000L).start();
                if (Build.VERSION.SDK_INT >= 26) {
                    processExec.waitFor(3000L, TimeUnit.MILLISECONDS);
                } else {
                    processExec.waitFor();
                }
                if (processExec != null) {
                    processExec.destroy();
                }
            } catch (Throwable unused) {
                if (processExec != null) {
                    processExec.destroy();
                }
            }
        } catch (Throwable unused2) {
            processExec = null;
        }
        return copyOnWriteArrayList;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private static class n extends com.byazt.xis.s {
        public InputStream n;
        public List<String> qg;

        public n(InputStream inputStream, List<String> list) {
            super("LogcatDump$LogDumperThread");
            this.n = inputStream;
            this.qg = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.n));
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
                                this.qg.add(line);
                            }
                        }
                    } else {
                        break;
                    }
                } catch (IOException unused) {
                    com.byazt.yw.w.n(bufferedReader);
                    return;
                } catch (Throwable th) {
                    com.byazt.yw.w.n(bufferedReader);
                    throw th;
                }
            }
            com.byazt.yw.w.n(bufferedReader);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 524})
    private static class qg extends com.byazt.xis.s {
        public Process n;
        public long qg;

        public qg(Process process, long j) {
            super("LogcatDump$TimerThread");
            this.n = process;
            this.qg = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                sleep(this.qg);
            } catch (InterruptedException unused) {
            }
            Process process = this.n;
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static String n(int i) {
        return (i < 0 || i >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i];
    }
}
