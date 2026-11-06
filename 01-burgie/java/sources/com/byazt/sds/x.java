package com.byazt.sds;

import android.os.Build;
import com.bumptech.glide.load.Key;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1663, 121})
public class x {
    /* JADX WARN: Code duplicated, block: B:15:0x0063 A[PHI: r4
      0x0063: PHI (r4v6 java.lang.Process) = (r4v5 java.lang.Process), (r4v8 java.lang.Process) binds: [B:14:0x0061, B:8:0x005a] A[DONT_GENERATE, DONT_INLINE]] */
    public static List<String> pr(int i, int i2) {
        Process processExec;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"logcat", "-t", String.valueOf(i), pr(i2)});
            try {
                new pr(processExec.getInputStream(), copyOnWriteArrayList).start();
                new pr(processExec.getErrorStream(), copyOnWriteArrayList).start();
                new hw(processExec, 3000L).start();
                if (Build.VERSION.SDK_INT >= 26) {
                    processExec.waitFor(3000L, TimeUnit.MILLISECONDS);
                } else {
                    processExec.waitFor();
                }
                if (processExec != null) {
                    processExec.destroy();
                }
            } catch (Throwable th) {
                if (processExec != null) {
                    processExec.destroy();
                }
            }
        } catch (Throwable th2) {
            processExec = null;
        }
        return copyOnWriteArrayList;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1663, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    private static class pr extends com.byazt.fr.hn {
        public List<String> hw;
        public InputStream pr;

        public pr(InputStream inputStream, List<String> list) {
            super("LogcatDump$LogDumperThread");
            this.pr = inputStream;
            this.hw = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.pr));
            int length = 32768;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        if (!line.startsWith("---------")) {
                            length -= line.getBytes(Key.STRING_CHARSET_NAME).length;
                            if (length < 0) {
                                break;
                            } else {
                                this.hw.add(line);
                            }
                        }
                    } else {
                        break;
                    }
                } catch (IOException e) {
                } finally {
                    com.byazt.wf.uc.pr(bufferedReader);
                }
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1663, 759})
    private static class hw extends com.byazt.fr.hn {
        public long hw;
        public Process pr;

        public hw(Process process, long j) {
            super("LogcatDump$TimerThread");
            this.pr = process;
            this.hw = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                sleep(this.hw);
            } catch (InterruptedException e) {
            }
            Process process = this.pr;
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static String pr(int i) {
        String[] strArr = {"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"};
        if (i >= 0 && i < 6) {
            return strArr[i];
        }
        return "*:V";
    }
}
