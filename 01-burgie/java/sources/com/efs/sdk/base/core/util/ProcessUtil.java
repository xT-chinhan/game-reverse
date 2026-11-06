package com.efs.sdk.base.core.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessUtil {
    private static String a;
    private static List<Integer> b;
    private static long c = -1;

    public static int myPid() {
        return Process.myPid();
    }

    public static String getCurrentProcessName() throws Throwable {
        String str = a;
        if (TextUtils.isEmpty(str)) {
            String processName = getProcessName(Process.myPid());
            a = processName;
            return processName;
        }
        return str;
    }

    public static String getProcessName(int i) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i + "/cmdline")));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i2 = bufferedReader2.read();
                        if (i2 <= 0) {
                            sb.trimToSize();
                            String string = sb.toString();
                            try {
                                bufferedReader2.close();
                                return string;
                            } catch (Throwable th) {
                                th.printStackTrace();
                                return string;
                            }
                        }
                        sb.append((char) i2);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    Log.e("efs.base", "get process name error", th);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    return "";
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static boolean isProcessExist(Context context, String str) {
        try {
            int i = Integer.parseInt(str);
            boolean z = false;
            if (b != null && !b.isEmpty()) {
                if (c > 0 && System.currentTimeMillis() - c <= 600000) {
                    z = true;
                }
            }
            if (!z) {
                if (b != null) {
                    b.clear();
                } else {
                    b = new ArrayList();
                }
                if (!TextUtils.isEmpty(getProcessName(Process.myPid()))) {
                    b.add(Integer.valueOf(Process.myPid()));
                }
                if (!TextUtils.isEmpty(getProcessName(i))) {
                    b.add(Integer.valueOf(i));
                }
                c = System.currentTimeMillis();
            }
            return b.contains(Integer.valueOf(i));
        } catch (Throwable th) {
            Log.e("efs.base", "Process exist judge error", th);
            return true;
        }
    }
}
