package com.mcto.sspsdk.internal;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r9 {
    public static int a = 3;

    public static void a(String str, Object... objArr) {
        if (a > 0) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                sb.append(obj).append(" ");
            }
            Log.e(str, sb.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2 == null || a > 2) {
            return;
        }
        Log.e(str, str2, th);
    }

    public static String a(Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append(exc.toString()).append("\n");
        StackTraceElement[] stackTrace = exc.getStackTrace();
        for (int i = 0; i < Math.min(stackTrace.length, 5); i++) {
            sb.append("\tat ").append(stackTrace[i]).append("\n");
        }
        return sb.toString();
    }
}
