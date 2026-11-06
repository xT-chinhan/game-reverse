package com.bytedance.pangle.c;

import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static boolean ms(String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process processExec = Runtime.getRuntime().exec(strArr);
            InputStream errorStream = processExec.getErrorStream();
            InputStream inputStream = processExec.getInputStream();
            ms(errorStream);
            ms(inputStream);
            if (processExec.waitFor() == 0) {
                return true;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + Arrays.toString(strArr));
            return false;
        } catch (IOException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        } catch (InterruptedException e2) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e2);
            return false;
        }
    }

    private static void ms(final InputStream inputStream) {
        com.bytedance.pangle.ka.ka.xr(new Runnable() { // from class: com.bytedance.pangle.c.ms.1
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
                                com.bytedance.pangle.util.ab.ms(bufferedReader);
                                return;
                            }
                        } catch (IOException e) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(String.valueOf(e)));
                            com.bytedance.pangle.util.ab.ms(bufferedReader);
                            return;
                        }
                    } catch (Throwable th) {
                        com.bytedance.pangle.util.ab.ms(bufferedReader);
                        throw th;
                    }
                    com.bytedance.pangle.util.ab.ms(bufferedReader);
                    throw th;
                }
            }
        });
    }
}
