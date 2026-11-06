package com.byazt.sw;

import com.byazt.gx.x;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 96, 19})
public class n {
    public static boolean n(String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process processExec = Runtime.getRuntime().exec(strArr);
            InputStream errorStream = processExec.getErrorStream();
            InputStream inputStream = processExec.getInputStream();
            n(errorStream);
            n(inputStream);
            if (processExec.waitFor() == 0) {
                return true;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + Arrays.toString(strArr));
            return false;
        } catch (IOException e) {
            com.byazt.vx.w.n(e);
            return false;
        } catch (InterruptedException e2) {
            com.byazt.vx.w.n(e2);
            return false;
        }
    }

    private static void n(final InputStream inputStream) {
        com.byazt.zi.l.qg(new Runnable() { // from class: com.byazt.sw.n.1
            @Override // java.lang.Runnable
            public void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                ZeusLogger.d(ZeusLogger.TAG_INSTALL, "exec cmd info : ".concat(String.valueOf(line)));
                            } else {
                                x.n(bufferedReader);
                                return;
                            }
                        } catch (IOException e) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(String.valueOf(e)));
                            x.n(bufferedReader);
                            return;
                        }
                    } catch (Throwable th) {
                        x.n(bufferedReader);
                        throw th;
                    }
                    x.n(bufferedReader);
                    throw th;
                }
            }
        });
    }
}
