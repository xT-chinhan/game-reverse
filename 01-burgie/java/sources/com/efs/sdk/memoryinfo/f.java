package com.efs.sdk.memoryinfo;

import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
final class f {
    public static long a(Debug.MemoryInfo memoryInfo) {
        if (Build.VERSION.SDK_INT >= 23) {
            String memoryStat = memoryInfo.getMemoryStat("summary.graphics");
            try {
                if (!TextUtils.isEmpty(memoryStat)) {
                    return Long.parseLong(memoryStat);
                }
                return 0L;
            } catch (Exception e) {
                return 0L;
            }
        }
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b9 A[Catch: Throwable -> 0x00a5, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Throwable -> 0x00a5, blocks: (B:29:0x00a1, B:47:0x00b9), top: B:56:0x0005 }] */
    public static long a() throws Throwable {
        BufferedReader bufferedReader;
        long j;
        long j2 = -1;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/status")));
                try {
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                            sb.append('\n');
                        }
                        String[] strArrSplit = sb.toString().trim().split("\n");
                        int length = strArrSplit.length;
                        int length2 = strArrSplit.length;
                        int i = 0;
                        while (true) {
                            if (i < length2) {
                                String str = strArrSplit[i];
                                if (str.startsWith("VmSize")) {
                                    Matcher matcher = Pattern.compile("\\d+").matcher(str);
                                    if (matcher.find()) {
                                        j = Long.parseLong(matcher.group());
                                        break;
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    return j2;
                                }
                                i++;
                            } else {
                                j = -1;
                                break;
                            }
                        }
                        if (j == -1 && length > 12) {
                            try {
                                Matcher matcher2 = Pattern.compile("\\d+").matcher(strArrSplit[12]);
                                if (matcher2.find()) {
                                    j2 = Long.parseLong(matcher2.group());
                                } else {
                                    j2 = j;
                                }
                            } catch (Throwable th) {
                                j2 = j;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return j2;
                            }
                        } else {
                            j2 = j;
                        }
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                }
            } catch (Throwable th5) {
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
        }
        return j2;
    }

    public static void a(String str, Throwable th) {
        if (a.DEBUG) {
            Log.e("MemoryCollect", str, th);
        }
    }
}
