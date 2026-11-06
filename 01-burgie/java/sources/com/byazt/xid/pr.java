package com.byazt.xid;

import com.byazt.gs.fw;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 582, 37})
public class pr {
    public static boolean pr(String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process processExec = Runtime.getRuntime().exec(strArr);
            InputStream errorStream = processExec.getErrorStream();
            InputStream inputStream = processExec.getInputStream();
            pr(errorStream);
            pr(inputStream);
            if (processExec.waitFor() != 0) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + Arrays.toString(strArr));
                return false;
            }
            return true;
        } catch (IOException e) {
            com.byazt.dea.uc.pr(e);
            return false;
        } catch (InterruptedException e2) {
            com.byazt.dea.uc.pr(e2);
            return false;
        }
    }

    private static void pr(final InputStream inputStream) {
        com.byazt.wo.c.hw(new Runnable() { // from class: com.byazt.xid.pr.1
            @Override // java.lang.Runnable
            public void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            } else {
                                ZeusLogger.d(ZeusLogger.TAG_INSTALL, "exec cmd info : ".concat(String.valueOf(line)));
                            }
                        } catch (IOException e) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(String.valueOf(e)));
                        }
                    } catch (Throwable th) {
                        fw.pr(bufferedReader);
                        throw th;
                    }
                }
                fw.pr(bufferedReader);
            }
        });
    }
}
