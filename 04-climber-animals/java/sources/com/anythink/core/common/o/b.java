package com.anythink.core.common.o;

import android.app.ActivityManager;
import android.content.Context;
import com.anythink.core.common.v.k;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static int a() {
        return a(1);
    }

    public static int b() {
        return a(3);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0048 A[EXC_TOP_SPLITTER, PHI: r3
      0x0048: PHI (r3v3 java.io.FileReader) = (r3v2 java.io.FileReader), (r3v4 java.io.FileReader) binds: [B:18:0x0046, B:24:0x0052] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    private static int a(int i) {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(k.b("L3Byb2MvbWVtaW5mbw=="));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                String line = "";
                for (int i2 = 0; i2 < i; i2++) {
                    try {
                        line = bufferedReader2.readLine();
                    } catch (IOException unused) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return 0;
                    } catch (Throwable unused4) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return 0;
                    }
                }
                int iLongValue = (int) (Long.valueOf(line.split("\\s+")[1]).longValue() / 1024);
                try {
                    bufferedReader2.close();
                } catch (IOException unused6) {
                }
                try {
                    fileReader.close();
                } catch (IOException unused7) {
                }
                return iLongValue;
            } catch (IOException unused8) {
            } catch (Throwable unused9) {
            }
        } catch (IOException unused10) {
            fileReader = null;
        } catch (Throwable unused11) {
            fileReader = null;
        }
    }

    public static int a(ActivityManager activityManager) {
        try {
            activityManager.getMemoryInfo(new ActivityManager.MemoryInfo());
            return (int) ((Runtime.getRuntime().totalMemory() / 1024) / 1024);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static int a(Context context, ActivityManager activityManager) {
        return (context.getApplicationContext().getApplicationInfo().flags & 1048576) == 1048576 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
    }
}
